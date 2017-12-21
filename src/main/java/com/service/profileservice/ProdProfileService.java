package com.service.profileservice;


import com.auth.Prod;
import org.springframework.stereotype.Service;

@Service
@Prod
public class ProdProfileService implements ProfileService {

    @Override
    public void activeProfile() {
        System.out.println("Active Profile is Prod");
    }
}