/*
package com.seeders;

import com.model.Role;
import com.model.User;
import com.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DatabaseSeeder {

    private Logger logger = Logger.getLogger(DatabaseSeeder.class);

    private UserRepository userRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseSeeder(UserRepository userRepository, JdbcTemplate jdbcTemplate) {
        this.userRepository = userRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUsersTable();
    }

    private void seedUsersTable() {
        String sql = "SELECT * FROM user u WHERE u.name = 'admin' OR  U.email = 'admin' LIMIT 1";

        List<User> u = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);

        if (u == null || u.size() <= 0) {
            User user = new User();
            user.setName("AdminName");
            user.setEmail("admin");
            user.setPassword("admin");
            List<Role> roles = new ArrayList<>();
            roles.add(new Role("admin"));
            //user.setRoles(roles);
            userRepository.save(user);
            logger.info("Users Seeded");
        } else {
            logger.trace("Users Seeding Not Required");
        }
    }


}
*/
