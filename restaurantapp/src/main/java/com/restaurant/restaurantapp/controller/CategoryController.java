package com.restaurant.restaurantapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class CategoryController {


    private static final Logger LOGGER = Logger.getLogger(CategoryController.class.getName());

//  http://localhost:9092/api/categories
    @GetMapping("/categories")
    public String getCategories(){
        return "Get all categories";
    }

    //http://localhost:9092/api/categories/1
    @GetMapping("/categories/{categoryId}")
    public String getCategory(@PathVariable Long categoryId){
        return "Get the category with id " + categoryId;
    }

    //  http://localhost:9092/api/categories
    @PostMapping("/categories")
    public String createCategory(@RequestBody String body){
        return "Creating a category with id " + body;
    }

    //  http://localhost:9092/api/categories/1
    @PutMapping("/categories/{categoryId}")
    public String updateCategory(@PathVariable(value = "categoryId") Long categoryId, @RequestBody String body){
        LOGGER.info("Calling updateCategory method from controller");
        return "Updating category with id " + categoryId + " " + body;
    }

    //  http://localhost:9092/api/categories/1
    @DeleteMapping("/categories/{categoryId}")
    public String deleteCategory(@PathVariable(value = "categoryId") Long categoryId){
        LOGGER.info("Calling deleteCategory method from controller");
        return "Deleting category with id " + categoryId;
    }
}
