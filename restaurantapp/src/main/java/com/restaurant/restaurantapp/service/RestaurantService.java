package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.exception.InformationExistException;
import com.restaurant.restaurantapp.exception.InformationNotFoundException;
import com.restaurant.restaurantapp.model.Category;
import com.restaurant.restaurantapp.model.Restaurant;
import com.restaurant.restaurantapp.repository.CategoryRepository;
import com.restaurant.restaurantapp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;
    private CategoryRepository categoryRepository;
    private static final Logger LOGGER = Logger.getLogger(RestaurantService.class.getName());

    @Autowired
    public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Restaurant getRestaurant(Long restaurantId) {
        LOGGER.info("calling getCategoryRestaurant from service");
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isEmpty()) {
            throw new InformationNotFoundException("restaurant with id " + restaurantId + " not found");
        } else {
            return restaurant.get();
        }

    }

    public List<Restaurant> getRestaurants() {
        LOGGER.info("calling getRestaurants from controller");

        return restaurantRepository.findAll();
    }

    public Restaurant updateRestaurant(Long restaurantId, Restaurant restaurantObject) {
        LOGGER.info("calling updateRestaurant from service");
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isEmpty()) {
            throw new InformationNotFoundException("restaurant with id " + restaurantId + " not found");
        } else {
            //                update
            if (restaurant.get().getName().equals(restaurantObject.getName())
                    && restaurant.get().getStreet().equals(restaurantObject.getStreet())
                    && restaurant.get().getCity().equals(restaurantObject.getCity())
                    && restaurant.get().getState().equals(restaurantObject.getState())
                    && restaurant.get().getZipCode().equals(restaurantObject.getZipCode())) {
                throw new InformationExistException("restaurant " + restaurant.get().getName() + " already exists");
            }
            restaurant.get().setName(restaurantObject.getName());
            restaurant.get().setStreet(restaurantObject.getStreet());
            restaurant.get().setCity(restaurantObject.getCity());
            restaurant.get().setState(restaurantObject.getState());
            restaurant.get().setZipCode(restaurantObject.getZipCode());
            return restaurantRepository.save(restaurant.get());
        }
    }

    public Restaurant deleteRestaurant(Long restaurantId) {
        LOGGER.info("calling deleteRestaurant from service");
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isEmpty()) {
            throw new InformationNotFoundException("restaurant with id " + restaurantId + " not found");
        }
//            Delete the restaurant and return restaurant information.
        restaurantRepository.deleteById(restaurantId);
        return restaurant.get();

    }
}
