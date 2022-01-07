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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Review getRestaurantReview(Long restaurantId, Long reviewId){
        LOGGER.info("calling getRestaurantReview from service");
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if( restaurant.isPresent()){
            Optional<Review> review = reviewRepository.findById(reviewId);
            if(review.isPresent()){
                return review.get();
            } else {
                throw new InformationNotFoundException("review with id " + reviewId  + " does not exist");
            }
        } else {
            throw new InformationNotFoundException("restaurant with id " + restaurantId + " not found");
        }
    }

    public Review updateRestaurantReview( Long restaurantId, Long reviewId, Long userId, Review reviewObject){
        LOGGER.info("calling updateRestaurantReview from service");
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        Optional<User> user = userRepository.findById(userId);
        Optional<Review> review = reviewRepository.findById(reviewId);
        if( restaurant.isPresent() && user.isPresent() && review.isPresent()){
            review.get().setRestaurant(restaurant.get());
            review.get().setComment(reviewObject.getComment());
            review.get().setRating(reviewObject.getRating());
            review.get().setUser(user.get());
            return reviewRepository.save(review.get());

        } else {
            throw new InformationNotFoundException("Either restaurant with id of " + restaurantId + ", review with id " + reviewId + ", or user with id of " + userId + " not found");
        }
    }

    public Review deleteRestaurantReview(Long restaurantId, Long userId, Long reviewId){
        LOGGER.info("calling deleteRestaurantReview from service");
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        Optional<User> user = userRepository.findById(userId);
        Optional<Review> review = reviewRepository.findById(reviewId);
        if ( restaurant.isPresent() && user.isPresent() && review.isPresent()){
            reviewRepository.deleteById(reviewId);
            return review.get();
        } else {
            throw new InformationNotFoundException("Either restaurant with id of " + restaurantId + ", review with id " + reviewId + ", or user with id of " + userId + " not found");
        }
    }
}
