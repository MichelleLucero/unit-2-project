package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);
    User findByEmailAndIdIsNot(String email, Long userId);

}