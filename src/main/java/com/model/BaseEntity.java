package com.model;

import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity extends AbstractAuditable<User, Long> {

    @ManyToOne
    public Org org;

    @PrePersist
    private void preCreate() {
        this.setCreatedDate(DateTime.now());
        if (org == null) {
            User current = getCurrentUser();
            if (current != null) {
                this.setOrg(current.getOrg());
                this.setCreatedBy(current);
            }
        }
    }

    @PreUpdate
    private void preUpdate() {
        this.setLastModifiedDate(DateTime.now());
        User current = getCurrentUser();
        if (current != null) {
            this.setLastModifiedBy(current);
        }

    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        if ((authentication.getPrincipal() instanceof CurrentUser)) {
            return ((CurrentUser) authentication.getPrincipal()).getUser();
        }
        return null;
    }


}
