# Restaurant Review App

## Description

Restaurant review App, which allows users to see reviews of a restaurant or add a review to a restaurant.

## User Stories

- As a user, I should be able to find a restaurant by category, name, or address
- As a user, I should be able to create a new review for a specific restaurant
- As a user, I should be able to see all the review(s) I have created 
- As a user, I should be able to update my review(s)
- As a user, I should be able to delete my review(s)
- As a user, I should be able to see reviews for a specific restaurant
- As a user, I should be able to rate a restaurant from 1 - 5, 5 being highest score
- As a user, I should be able to update my rating for a restaurant
- As a user, I should be able to see restaurant details

## Entity Relationship Diagram

![image](https://user-images.githubusercontent.com/31500626/147986739-982dbfac-f9af-4cbf-a7a2-4172b4d4116c.png)

## Endpoints

| Request Type | URL                                                     | Functionality                                                       |
| :----------- | :------------------------------------------------------ | :------------------------------------------------------------------ |
| GET          | /api/categories/                                        | get all the categories                                              |
| POST         | /api/categoies/                                         | create a category                                                   |
| GET          | /api/categories/{categoryId}                            | get a specific category                                             |
| PUT          | /api/categories/{categoryId}                            | update a specific category                                          |
| DELETE       | /api/categories/{categoryId}                            | delete a specific category                                          |
| GET          | /api/categories/{categoryId}/restaurants                | List all restaurants in category                                    |
| POST         | /api/categories/{categoryId}/restaurants                | Creates a new restaurant in the given category                      |
| GET          | /api/categories/{categoryId}/restaurants/{restaurantId} | Gets a single restaurant with the given restaurantId and CategoryId |
| PUT          | /api/categories/{categoryId}/restaurants/{restaurantId} | Updates a restaurant in the given category                          |
| DELETE       | /api/categories/{categoryId}/restaurants/{restaurantId} | Deletes a restaurant in the given category                          |
