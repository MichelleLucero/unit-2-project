package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);

    Category findByNameAndIdIsNot(String categoryName, Long categoryId);
}
