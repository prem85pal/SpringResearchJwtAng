package com.controller;

import com.auth.Privileges;
import com.model.User;
import com.service.UserService;
import com.view.UserDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Secured(Privileges.USER_WRITE)
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return new UserDTO(userService.save(userDTO.toEntity()));
    }

    @Secured(Privileges.USER_WRITE)
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public UserDTO update(@PathVariable Long id ,@RequestBody UserDTO userDTO) {


        return new UserDTO();
    }

    @Secured(Privileges.USER_WRITE)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public UserDTO delete(@PathVariable Long id) {

        return new UserDTO();
    }

    @Secured(Privileges.USER_READ)
    @RequestMapping(value = "/retrieve", method = RequestMethod.GET)
    public List<UserDTO> retrieve() {
        List<UserDTO> userDTOS= new ArrayList<>();
        return userDTOS;
    }

}
