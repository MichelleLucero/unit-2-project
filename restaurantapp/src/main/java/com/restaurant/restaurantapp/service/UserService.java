package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.exception.InformationExistException;
import com.restaurant.restaurantapp.exception.InformationNotFoundException;
import com.restaurant.restaurantapp.model.User;
import com.restaurant.restaurantapp.model.User;
import com.restaurant.restaurantapp.model.Review;
import com.restaurant.restaurantapp.model.User;
import com.restaurant.restaurantapp.repository.ReviewRepository;
import com.restaurant.restaurantapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public Optional getUser(Long userId) {
        LOGGER.info("calling getUser method from controller");
        Optional user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user;
        } else {
            throw new InformationNotFoundException("user with id " + userId + " not found");
        }
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

    public User updateUser(Long userId, User userObject) {
        LOGGER.info("calling updateUser method from controller");
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User userDuplicate = userRepository.findByEmailAndIdIsNot(userObject.getEmail(), userId);
            if (userDuplicate == null) {
                User updateUser = userRepository.findById(userId).get();
                updateUser.setFirstName(userObject.getFirstName());
                updateUser.setLastName(userObject.getLastName());
                updateUser.setEmail(userObject.getEmail());
                return userRepository.save(updateUser);

            } else {
                throw new InformationExistException("user with name " + userObject.getEmail() + " already exists.");
            }
        } else {
            throw new InformationNotFoundException("User with Id " + userId + " not found.");
        }

    }
}
