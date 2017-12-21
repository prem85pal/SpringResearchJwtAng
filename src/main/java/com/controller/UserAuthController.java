package com.controller;

import com.model.User;
import com.auth.UserLogin;
import com.auth.UserLoginResponse;
import com.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/")
public class UserAuthController {


    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.token_exp_hrs}")
    private int hours;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin, HttpServletRequest request) {

        User user = userService.validate(userLogin.getEmail(), userLogin.getPassword());

        if (user == null) {
            System.out.println("Invalid User");
        }

        String authToken = Jwts.builder()
                .setSubject(userLogin.getEmail())
                .claim("roles", "USER")
                .setIssuedAt(new Date())
                .setExpiration(getAuthExpiration())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        // Return the token
        return ResponseEntity.ok(new UserLoginResponse(authToken));
    }

    private Date getAuthExpiration() {
        return new DateTime().plusHours(hours).toDate();
    }


}
