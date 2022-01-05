package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.controller.CategoryController;
import com.restaurant.restaurantapp.exception.InformationExistException;
import com.restaurant.restaurantapp.exception.InformationNotFoundException;
import com.restaurant.restaurantapp.model.Category;
import com.restaurant.restaurantapp.model.Restaurant;
import com.restaurant.restaurantapp.repository.CategoryRepository;
import com.restaurant.restaurantapp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private RestaurantRepository restaurantRepository;

    private static final Logger LOGGER = Logger.getLogger(CategoryService.class.getName());

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setRestaurantRepository(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public List<Category> getCategories(){
        LOGGER.info("calling getCategories method from service");
        return categoryRepository.findAll();
    }


    public Optional getCategory(Long categoryId) {
        LOGGER.info("calling getCategory method from controller");
        Optional category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category;
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }

    public Category createCategory(Category categoryObject) {
        LOGGER.info("calling createCategory from controller");
        Category category = categoryRepository.findByName(categoryObject.getName());
        if (category != null) {
            throw new InformationExistException("category with name " + category.getName() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }

    public Category updateCategory(Long categoryId, Category categoryObject) {
        LOGGER.info("calling updateCategory method from controller");
        Optional<Category> category = categoryRepository.findById(categoryId);
        // findById
        if (category.isPresent()) {
            // check the category name match with the category name in the DB
            if (categoryObject.getName().equals(category.get().getName())) {
                LOGGER.warning("category name is equal to database object name");
                throw new InformationExistException("category " + category.get().getName() + " is already exists");
            } else {
                // find the category and update with new information
                Category updateCategory = categoryRepository.findById(categoryId).get();
                updateCategory.setName(categoryObject.getName());
                return categoryRepository.save(updateCategory);
            }
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }

    public Optional<Category> deleteCategory(Long categoryId) {
        LOGGER.info("calling deleteCategory method from controller");
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            categoryRepository.deleteById(categoryId);
            return category;
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }

    public Restaurant createCategoryRestaurant(Long categoryId, Restaurant restaurantObject){
        LOGGER.info("calling createCategoryRestaurant method from service");
        try{
           Optional category = categoryRepository.findById(categoryId);
           restaurantObject.setCategory((Category) category.get());
           return restaurantRepository.save(restaurantObject);
        } catch(NoSuchElementException e) {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }

//    public Restaurant getCategoryRestaurant( Long categoryId, Long restaurantId){
//        LOGGER.info("calling getCategoryRestaurant from service");
//        Optional<Category> category = categoryRepository.findById(categoryId);
//        if(category.isPresent()){
//
//        } else {
//            throw new InformationNotFoundException("category with id " + categoryId + " not found");
//        }
//    }
}
