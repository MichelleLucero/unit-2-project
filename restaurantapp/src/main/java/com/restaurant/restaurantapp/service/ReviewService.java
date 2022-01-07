package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.model.Review;
import com.restaurant.restaurantapp.repository.ReviewRepository;
import com.restaurant.restaurantapp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    private static final Logger LOGGER = Logger.getLogger(ReviewService.class.getName());

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

//  http://localhost:9092/api/restaurants/1/reviews
    public List<Review> getRestaurantReviews(@PathVariable(value = "restaurantId") Long categoryId){
        LOGGER.info("calling getRestaurantReviews from controller");
        return reviewRepository.findAll();
    }

}
