package com.service;


import com.model.CurrentUser;
import com.model.Org;
import com.model.Role;
import com.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseService {

    public Org getOrg() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        if (authentication.getPrincipal() instanceof CurrentUser) {
            return ((CurrentUser) authentication.getPrincipal()).getUser().getOrg();
        }
        return null;
    }

    public User getUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        if (authentication.getPrincipal() instanceof CurrentUser) {
            return ((CurrentUser) authentication.getPrincipal()).getUser();
        }
        return null;
    }


    public List<String> getPrivilege() {
        List<String> privileges = new ArrayList<>();
        for (Role role : getUser().getRoles()) {
            privileges.addAll(getPrivilege(role));
        }
        return privileges;
    }

    public List<String> getPrivilege(Role x) {
        return x.getPrivileges().stream().map(p -> p.getName()).collect(Collectors.toList());
    }


}
