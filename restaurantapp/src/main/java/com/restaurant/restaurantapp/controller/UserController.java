package com.restaurant.restaurantapp.controller;


import com.restaurant.restaurantapp.repository.ReviewRepository;
import com.restaurant.restaurantapp.repository.UserRepository;
import com.restaurant.restaurantapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;
@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());


    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }



}
