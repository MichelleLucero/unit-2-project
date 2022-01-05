package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
