package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.exception.InformationExistException;
import com.restaurant.restaurantapp.model.User;
import com.restaurant.restaurantapp.model.Review;
import com.restaurant.restaurantapp.model.User;
import com.restaurant.restaurantapp.repository.ReviewRepository;
import com.restaurant.restaurantapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {

    private UserRepository userRepository;
    private ReviewRepository reviewRepository;
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<User> getUsers(){
        LOGGER.info("Calling getUsers method from service");
        return userRepository.findAll();
    }

    public User createUser(User userObject) {
        LOGGER.info("calling createUser from controller");
        User user = userRepository.findByEmail(userObject.getEmail());
        if (user != null) {
            throw new InformationExistException("user with email " + user.getEmail() + " already exists");
        } else {
            return userRepository.save(userObject);
        }
    }

}
