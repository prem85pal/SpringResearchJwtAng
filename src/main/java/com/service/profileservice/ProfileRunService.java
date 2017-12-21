package com.service.profileservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ProfileRunService {


    @Autowired
    private ProfileService profileService;

    @PostConstruct
    public void init() {

        profileService.activeProfile();

    }


}
