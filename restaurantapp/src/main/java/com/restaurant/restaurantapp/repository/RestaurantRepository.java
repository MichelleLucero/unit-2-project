package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCategoryId(Long categoryId);
}
