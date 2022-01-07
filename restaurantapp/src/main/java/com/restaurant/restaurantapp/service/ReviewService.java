package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.exception.InformationNotFoundException;
import com.restaurant.restaurantapp.model.Category;
import com.restaurant.restaurantapp.model.Restaurant;
import com.restaurant.restaurantapp.model.Review;
import com.restaurant.restaurantapp.model.User;
import com.restaurant.restaurantapp.repository.RestaurantRepository;
import com.restaurant.restaurantapp.repository.ReviewRepository;
import com.restaurant.restaurantapp.repository.ReviewRepository;
import com.restaurant.restaurantapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    private RestaurantRepository restaurantRepository;
    private UserRepository userRepository;

    private static final Logger LOGGER = Logger.getLogger(ReviewService.class.getName());

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Autowired
    public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<Review> getRestaurantReviews(Long restaurantId){
        LOGGER.info("calling getRestaurantReviews from service");
        return reviewRepository.findByRestaurantId(restaurantId);
    }

    public Review createRestaurantReview( Long restaurantId, Long userId, Review reviewObject){
        LOGGER.info("calling createRestaurantReview from controller");
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        Optional<User> user = userRepository.findById(userId);
        if( restaurant.isPresent() && user.isPresent()){
            reviewObject.setRestaurant(restaurant.get());
            reviewObject.setUser(user.get());
            return reviewRepository.save(reviewObject);
        } else {
            throw new InformationNotFoundException("restaurant with id of " + restaurantId + " does not exist");
        }
    }

}
