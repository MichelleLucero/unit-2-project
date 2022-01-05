package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
