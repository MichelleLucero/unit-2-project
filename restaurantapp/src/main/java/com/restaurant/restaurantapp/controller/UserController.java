package com.restaurant.restaurantapp.controller;


import com.restaurant.restaurantapp.model.User;
import com.restaurant.restaurantapp.model.User;
import com.restaurant.restaurantapp.model.User;
import com.restaurant.restaurantapp.repository.ReviewRepository;
import com.restaurant.restaurantapp.repository.UserRepository;
import com.restaurant.restaurantapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    // http://localhost:9092/api/users
    @GetMapping("/users")
    public List<User> getUsers() {
        LOGGER.info("calling getUsers method from controller");
        return userService.getUsers();
    }

    // http://localhost:9092/api/users/1
    @GetMapping(path = "/users/{userId}")
    public Optional getUser(@PathVariable Long userId) {
        LOGGER.info("calling getUser method from controller");
        return userService.getUser(userId);
    }

    // http://localhost:9092/api/users
    @PostMapping(path = "/users")
    public User createUser(@RequestBody User userObject){
        LOGGER.info("calling createUser method from controller");
        return userService.createUser(userObject);
    }

    // http://localhost:9092/api/users/1
    @PutMapping(path = "/users/{userId}")
    public User updateUser(@PathVariable(value = "userId") Long userId, @RequestBody User userObject) {
        LOGGER.info("calling updateUser method from service");
        return userService.updateUser(userId, userObject);
    }

    //  http://localhost:9092/api/users/1
    @DeleteMapping("/users/{userId}")
    public Optional<User> deleteUser(@PathVariable(value = "userId") Long userId) {
        LOGGER.info("calling deleteUser method from service");
        return userService.deleteUser(userId);
    }
}
