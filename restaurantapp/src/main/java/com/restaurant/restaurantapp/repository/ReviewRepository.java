package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    //    List<Review> findByUserId(Long userId);

    List<Review> findByRestaurantId(Long restaurantId);
    List<Review> findByUserId(Long userId);
}
