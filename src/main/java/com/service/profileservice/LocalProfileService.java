package com.service.profileservice;



import org.springframework.stereotype.Service;

@Service
public class LocalProfileService implements ProfileService {

    @Override
    public void activeProfile() {
        System.out.println("Active Profile is default not need to set any thing");
    }
}