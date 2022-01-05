package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.exception.InformationExistException;
import com.restaurant.restaurantapp.exception.InformationNotFoundException;
import com.restaurant.restaurantapp.model.Category;
import com.restaurant.restaurantapp.model.Restaurant;
import com.restaurant.restaurantapp.repository.CategoryRepository;
import com.restaurant.restaurantapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;
    private static final Logger LOGGER = Logger.getLogger(CategoryController.class.getName());

    @Autowired
    public void setCategoryService(CategoryService categoryService){
        this.categoryService = categoryService;
    }

//  http://localhost:9092/api/categories
    @GetMapping("/categories")
    public List<Category> getCategories(){
        LOGGER.info("calling getCategories method from controller");
        return categoryService.getCategories();
    }

    // http://localhost:9092/api/categories/1
    @GetMapping(path = "/categories/{categoryId}")
    public Optional getCategory(@PathVariable Long categoryId) {
        LOGGER.info("calling getCategory method from controller");
        return categoryService.getCategory(categoryId);
    }

    //  http://localhost:9092/api/categories
    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category categoryObject){
        LOGGER.info("calling createCategory from service");
        return categoryService.createCategory(categoryObject);
    }

    // http://localhost:9092/api/categories/1
    @PutMapping(path = "/categories/{categoryId}")
    public Category updateCategory(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Category categoryObject) {
        LOGGER.info("calling updateCategory method from service");
        return categoryService.updateCategory(categoryId, categoryObject);
    }


    //  http://localhost:9092/api/categories/1
    @DeleteMapping("/categories/{categoryId}")
    public Optional<Category> deleteCategory(@PathVariable(value = "categoryId") Long categoryId) {
        LOGGER.info("calling deleteCategory method from service");
        return categoryService.deleteCategory(categoryId);
    }

    //  http://localhost:9092/api/categories/1/restaurants
    @PostMapping("/categories/{categoryId}/restaurants")
    public Restaurant createCategoryRestaurant(
            @PathVariable(value = "categoryId") Long categoryId,
            @RequestBody Restaurant restaurantObject){
        LOGGER.info("calling createCategoryRestaurant method from controller");
        return categoryService.createCategoryRestaurant(categoryId, restaurantObject);
    }

    //  http://localhost:9092/api/categories/1/restaurants/1
//    @GetMapping("/categories/{categoryId}/restaurants/{restaurantId}")
//    public Restaurant getCategoryRestaurant(
//            @PathVariable(value = "categoryId") Long categoryId,
//            @PathVariable(value = "restaurantId") Long restaurantId
//    ){
//        LOGGER.info("calling getCategoryRestaurant from controller");
//        return categoryService.getCategoryRestaurant(categoryId, restaurantId);
//    }

}

