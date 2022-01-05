package com.restaurant.restaurantapp.controller;

import com.restaurant.restaurantapp.exception.InformationExistException;
import com.restaurant.restaurantapp.exception.InformationNotFoundException;
import com.restaurant.restaurantapp.model.Category;
import com.restaurant.restaurantapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryRepository categoryRepository;
    private static final Logger LOGGER = Logger.getLogger(CategoryController.class.getName());

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

//  http://localhost:9092/api/categories
    @GetMapping("/categories")
    public List<Category> getCategories(){
        LOGGER.info("calling getCategories method from controller");
        return categoryRepository.findAll();
    }

    // http://localhost:9092/api/categories/1
    @GetMapping(path = "/categories/{categoryId}")
    public Optional getCategory(@PathVariable Long categoryId) {
        LOGGER.info("calling getCategory method from controller");
        Optional category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            return category;
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }


    //  http://localhost:9092/api/categories
    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category categoryObject){
        LOGGER.info("calling createCategory from controller");
        Category category = categoryRepository.findByName(categoryObject.getName());
        if(category != null){
            throw new InformationExistException("category with name " + category.getName() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }

    // http://localhost:9092/api/categories/1
    @PutMapping(path = "/categories/{categoryId}")
    public Category updateCategory(@PathVariable(value = "categoryId") Long categoryId, @RequestBody Category categoryObject) {
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


    //  http://localhost:9092/api/categories/1
    @DeleteMapping("/categories/{categoryId}")
    public Optional<Category> deleteCategory(@PathVariable(value = "categoryId") Long categoryId) {
        LOGGER.info("calling deleteCategory method from controller");
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            categoryRepository.deleteById(categoryId);
            return category;
        } else {
            throw new InformationNotFoundException("category with id " + categoryId + " not found");
        }
    }
}

