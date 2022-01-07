package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.model.Restaurant;
import com.restaurant.restaurantapp.service.CategoryService;
import com.restaurant.restaurantapp.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    private RestaurantService restaurantService;
    private static final Logger LOGGER = Logger.getLogger(RestaurantController.class.getName());

    @Autowired
    public void setRestaurantService(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

//    //  http://localhost:9092/api/categories/1/restaurants
//    @PostMapping("/categories/{categoryId}/restaurants")
//    public Restaurant createCategoryRestaurant(
//            @PathVariable(value = "categoryId") Long categoryId,
//            @RequestBody Restaurant restaurantObject){
//        LOGGER.info("calling createCategoryRestaurant method from controller");
//        return restaurantService.createCategoryRestaurant(categoryId, restaurantObject);
//    }
//
    //  http://localhost:9092/api/restaurants/1
    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurant(
            @PathVariable(value = "restaurantId") Long restaurantId
    ){
        LOGGER.info("calling getRestaurant from controller");
        return restaurantService.getRestaurant(restaurantId);
    }

    //    http://localhost:9092/api/restaurants
    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants(){
        LOGGER.info("calling getRestaurant from controller");
        return restaurantService.getRestaurants();
    }


    @PutMapping("/restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable(value = "restaurantId") Long restaurantId,
                                               @RequestBody Restaurant restaurantObject){
        LOGGER.info("calling updateRestaurant from controller");
        return restaurantService.updateRestaurant(restaurantId, restaurantObject);
    }
//
//    @DeleteMapping("/categories/{categoryId}/restaurants/{restaurantId}")
//    public Restaurant deleteCategoryRestaurant(@PathVariable(value = "categoryId") Long categoryId,
//                                               @PathVariable(value = "restaurantId") Long restaurantId){
//        LOGGER.info("calling deleteCategoryRestaurant from controller");
//        return restaurantService.deleteCategoryRestaurant(categoryId, restaurantId);
//    }

}
