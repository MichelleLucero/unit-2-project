package com.restaurant.restaurantapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

//  http://localhost:9092/helloworld
    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello World";
    }


}
