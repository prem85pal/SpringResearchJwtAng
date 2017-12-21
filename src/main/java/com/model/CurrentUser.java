package com.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class CurrentUser extends User {

    private com.model.User user;

    public CurrentUser(com.model.User user, Collection<? extends GrantedAuthority> roles) {
        super(user.getEmail(), user.getPassword(), roles);
        this.user = user;
    }

    public com.model.User getUser() {
        return user;
    }

    public void setUser(com.model.User user) {
        this.user = user;
    }
}
