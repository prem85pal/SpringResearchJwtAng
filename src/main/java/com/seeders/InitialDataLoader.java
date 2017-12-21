package com.seeders;

import com.model.Privilege;
import com.model.Role;
import com.model.User;
import com.repository.PrivilegeRepository;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;

        Privilege userReadPrivilege = createPrivilegeIfNotFound("USER_READ");
        Privilege userWritePrivilege = createPrivilegeIfNotFound("USER_WRITE");

        Set<Privilege> adminPrivileges = new HashSet<>();
        adminPrivileges.add(userReadPrivilege);
        adminPrivileges.add(userWritePrivilege);

        createRoleIfNotFound("ADMIN", adminPrivileges);

        createUserIfNotFound("admin.com");


        alreadySetup = true;
    }

    private void createUserIfNotFound(String s) {

        User user = userRepository.findByEmail(s);
        if (user != null) {
            return;
        }
        Role adminRole = roleRepository.findByName("ADMIN");
        Set<Role> adminRoleSet = new LinkedHashSet<>();
        adminRoleSet.add(adminRole);
        user = new User();
        user.setName("admin");
        user.setPassword("admin");
        user.setEmail("admin.com");
        user.setRoles(adminRoleSet);
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Transactional
    private Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private Role createRoleIfNotFound(String name, Set<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}
