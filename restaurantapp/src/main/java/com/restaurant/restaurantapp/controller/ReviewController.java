package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.model.Restaurant;
import com.restaurant.restaurantapp.model.Review;
import com.restaurant.restaurantapp.model.ReviewRequest;
import com.restaurant.restaurantapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Review> getRestaurantReviews(@PathVariable(value = "restaurantId") Long restaurantId){
        LOGGER.info("calling getRestaurantReviews from controller");
        return reviewService.getRestaurantReviews(restaurantId);
    }

    //    http://localhost:9092/api/restaurants/1/reviews
    @PostMapping("/restaurants/{restaurantId}/reviews")
    public Review createRestaurantReview(@PathVariable(value = "restaurantId") Long restaurantId, @RequestBody ReviewRequest reviewRequestObject){
        LOGGER.info("calling createRestaurantReview from controller");
        return reviewService.createRestaurantReview(restaurantId, reviewRequestObject);
    }

    //    http://localhost:9092/api/restaurants/1/reviews/1
    @GetMapping("/restaurants/{restaurantId}/reviews/{reviewId}")
    public Review getRestaurantReview(@PathVariable(value = "restaurantId") Long restaurantId,
                                            @PathVariable(value = "reviewId") Long reviewId){
        LOGGER.info("calling getRestaurantReview from controller");
        return reviewService.getRestaurantReview(restaurantId, reviewId);
    }

    //    http://localhost:9092/api/restaurants/1/reviews/1
    @PutMapping("/restaurants/{restaurantId}/reviews/{reviewId}")
    public Review updateRestaurantReview(@PathVariable(value = "restaurantId") Long restaurantId,
                                         @PathVariable(value = "reviewId") Long reviewId,
                                         @RequestBody ReviewRequest reviewRequestObject){
        LOGGER.info("calling updateRestaurantReview from controller");
        return reviewService.updateRestaurantReview(restaurantId, reviewId, reviewRequestObject);
    }

    @DeleteMapping("/restaurants/{restaurantId}/reviews/{reviewId}")
    public Review deleteRestaurantReview(@PathVariable(value = "restaurantId") Long restaurantId,
                                         @PathVariable(value = "reviewId") Long reviewId){
        LOGGER.info("calling deleteRestaurantReview from controller");
        return reviewService.deleteRestaurantReview(restaurantId, reviewId);
    }
}