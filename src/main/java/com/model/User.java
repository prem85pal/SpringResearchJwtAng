package com.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

    private String name;
    private String email;
    private String password;
    private boolean enabled;

    @OneToOne
    private UserDetail userDetail;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.PERSIST)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;

    public Set<String> getPrivileges() {
        Set<String> usrPrivileges = new HashSet<>();
        for (Role userRole : roles) {
            for (Privilege privilege : userRole.getPrivileges()) {
                usrPrivileges.add(privilege.getName());
            }
        }
        return usrPrivileges;
    }
}
