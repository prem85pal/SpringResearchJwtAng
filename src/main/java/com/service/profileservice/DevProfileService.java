package com.service.profileservice;

import com.auth.Dev;
import org.springframework.stereotype.Service;

@Service
@Dev
public class DevProfileService implements ProfileService {

    @Override
    public void activeProfile() {
        System.out.println("Active Profile is Dev");
    }
}
