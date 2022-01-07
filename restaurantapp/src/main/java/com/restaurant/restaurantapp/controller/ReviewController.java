package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.model.Restaurant;
import com.restaurant.restaurantapp.model.Review;
import com.restaurant.restaurantapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;
@RestController
@RequestMapping("/api")
public class ReviewController {
    private ReviewService reviewService;
    private static final Logger LOGGER = Logger.getLogger(ReviewController.class.getName());

    @Autowired
    public void setReviewService(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    //    http://localhost:9092/api/restaurants/1/reviews
    @GetMapping("/restaurants/{restaurantId}/reviews")
    public List<Review> getRestaurantReviews(@PathVariable(value = "restaurantId") Long categoryId){
        LOGGER.info("calling getRestaurantReviews from controller");
        return reviewService.getRestaurantReviews(categoryId);
    }
}