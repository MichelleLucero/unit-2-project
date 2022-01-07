package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.controller.CategoryController;
import com.restaurant.restaurantapp.exception.InformationExistException;
import com.restaurant.restaurantapp.exception.InformationNotFoundException;
import com.restaurant.restaurantapp.model.Category;
import com.restaurant.restaurantapp.model.Restaurant;
import com.restaurant.restaurantapp.model.Review;
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
//    private RestaurantRepository restaurantRepository;

    private static final Logger LOGGER = Logger.getLogger(CategoryService.class.getName());

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

//    @Autowired
//    public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
//        this.restaurantRepository = restaurantRepository;
//    }

    public List<Category> getCategories() {
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
        if (category.isPresent()) {
            Category categoryDuplicate = categoryRepository.findByNameAndIdIsNot(categoryObject.getName(), categoryId);
            if (categoryDuplicate == null) {
                Category updateCategory = categoryRepository.findById(categoryId).get();
                updateCategory.setName(categoryObject.getName());
                return categoryRepository.save(updateCategory);

            } else {
                throw new InformationExistException("category with name " + categoryObject.getName() + " already exists.");
            }
        } else {
            throw new InformationNotFoundException("Category with Id " + categoryId + " not found.");
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

//    public Restaurant createCategoryRestaurant(Long categoryId, Restaurant restaurantObject) {
//        LOGGER.info("calling createCategoryRestaurant method from service");
//        Optional<Category> category = categoryRepository.findById(categoryId);
//        if (category.isPresent()) {
//            Restaurant restaurant = restaurantRepository.findByName(restaurantObject.getName());
//            if (restaurant != null) {
//                throw new InformationExistException("restaurant with name " + restaurant.getName() + " already exists");
//            } else {
//                restaurantObject.setCategory(category.get());
//                return restaurantRepository.save(restaurantObject);
//            }
//        } else {
//            throw new InformationNotFoundException("category with id " + categoryId + " does not exist.");
//        }
//    }
//
//    public Restaurant getCategoryRestaurant(Long categoryId, Long restaurantId) {
//        LOGGER.info("calling getCategoryRestaurant from service");
//        Optional<Category> category = categoryRepository.findById(categoryId);
//        if (category.isPresent()) {
//            Optional<Restaurant> restaurant = restaurantRepository.findByCategoryId(categoryId).stream().filter(
//                    p -> p.getId().equals(restaurantId)).findFirst();
//            if (restaurant.isEmpty()) {
//                throw new InformationNotFoundException("category with id " + restaurantId + " not found");
//            } else {
//                return restaurant.get();
//            }
//        } else {
//            throw new InformationNotFoundException("category with id " + categoryId + " not found");
//        }
//    }
//
    public List<Restaurant> getCategoryRestaurants(Long categoryId) {
        LOGGER.info("calling getCategoryRestaurants");
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            List<Restaurant> restaurantList = category.get().getRestaurantList();
            if (restaurantList.isEmpty()) {
                throw new InformationNotFoundException("category with id " + categoryId + "does not have recipes");
            }
            return restaurantList;
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }
//
//    public Restaurant updateCategoryRestaurant(Long categoryId, Long restaurantId, Restaurant restaurantObject) {
//        LOGGER.info("calling updateCategoryRestaurant from service");
//        Optional<Category> category = categoryRepository.findById(categoryId);
//        if (category.isPresent()) {
//            Optional<Restaurant> restaurant = restaurantRepository.findByCategoryId(categoryId).stream().filter(
//                    p -> p.getId().equals(restaurantId)).findFirst();
//            if (restaurant.isEmpty()) {
//                throw new InformationNotFoundException("restaurant with id " + restaurantId + " not found");
//            } else {
//                //                update
//                if (restaurant.get().getName().equals(restaurantObject.getName())) {
//                    throw new InformationExistException("restaurant " + restaurant.get().getName() + " already exists");
//                }
//
//                restaurant.get().setName(restaurantObject.getName());
//                restaurant.get().setStreet(restaurantObject.getStreet());
//                restaurant.get().setCity(restaurantObject.getCity());
//                restaurant.get().setState(restaurantObject.getState());
//                restaurant.get().setZipCode(restaurantObject.getZipCode());
//                return restaurantRepository.save(restaurant.get());
//            }
//
//        } else {
//            throw new InformationNotFoundException("category with id " + categoryId + " not found");
//        }
//    }
//
//    public Restaurant deleteCategoryRestaurant(Long categoryId, Long restaurantId) {
//        LOGGER.info("calling deleteCategoryRestaurant from service");
//        Optional<Category> category = categoryRepository.findById(categoryId);
//        if (category.isPresent()) {
//            Optional<Restaurant> restaurant = restaurantRepository.findByCategoryId(categoryId).stream().filter(
//                    p -> p.getId().equals(restaurantId)).findFirst();
//            if (restaurant.isEmpty()) {
//                throw new InformationNotFoundException("restaurant with id " + restaurantId + " not found");
//            }
////            Delete
//            restaurantRepository.deleteById(restaurantId);
//            return restaurant.get();
//        } else {
//            throw new InformationNotFoundException("category with id " + categoryId + " not found");
//        }
//    }


}
