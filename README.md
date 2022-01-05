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

![image](https://raw.githubusercontent.com/MichelleLucero/unit-2-project/main/ERD_Planning/Restaurant%20Review%20App%20-%20Database%20ER%20diagram%20(1).jpeg)

## Endpoints

| Request Type | URL                                                                        | Functionality                                                              |
| :----------- | :------------------------------------------------------------------------- | :------------------------------------------------------------------------- |
| GET          | /api/categories/                                                           | get all the categories                                                     |
| POST         | /api/categories/                                                           | create a category                                                          |
| GET          | /api/categories/{categoryId}                                               | get a specific category                                                    |
| PUT          | /api/categories/{categoryId}                                               | update a specific category                                                 |
| DELETE       | /api/categories/{categoryId}                                               | delete a specific category                                                 |
| GET          | /api/categories/{categoryId}/restaurants                                   | List all restaurants in category                                           |
| POST         | /api/categories/{categoryId}/restaurants                                   | Creates a new restaurant in the given category                             |
| GET          | /api/categories/{categoryId}/restaurants/{restaurantId}                    | Gets a single restaurant with the given restaurantId and categoryId        |
| PUT          | /api/categories/{categoryId}/restaurants/{restaurantId}                    | Updates a restaurant in the given category                                 |
| DELETE       | /api/categories/{categoryId}/restaurants/{restaurantId}                    | Deletes a restaurant in the given category                                 |
| GET          | /api/categories/{categoryId}/restaurants/{restaurantId}/reviews            | List all reviews in restaurant                                             |
| POST         | /api/categories/{categoryId}/restaurants/{restaurantId}/reviews            | Creates a new review in the given restaurant                               |
| GET          | /api/categories/{categoryId}/restaurants/{restaurantId}/reviews/{reviewId} | Gets a single review with the given restaurantId, categoryId, and reviewId |
| GET          | /api/users/                                                                | Gets all the users                                                         |
| POST         | /api/users/                                                                | Create a user                                                              |
| GET          | /api/users/{userId}                                                        | Get a specific user                                                        |
| PUT          | /api/users/{userId}                                                        | Update a specific user                                                     |
| DELETE       | /api/users/{userId}                                                        | Delete a specific user                                                     |
| GET          | /api/users/{userId}/reviews                                                | Get all reviews from a given user                                          |
| PUT          | /api/users/{userId}/reviews/{reviewId}                                     | Updates a review in the given restaurant                                   |
| DELETE       | /api/users/{userId}/reviews/{reviewId}                                     | Deletes a review in the given restaurant                                   |

## MVP

Our MVP is a will have four models: categories, restaurants, reviews and users. The categories, restaurants, and users models will have all the CRUD endpoints created using REST conventions. When an invalid request is made, an error message will be displayed.

## Stretch Goals

- Allow a restaurant to have multiple categories
- Add authentication using JWT
- Apply google maps API or openstreetmap
- Allow restaurant owners to respond to reviews
- Allow users to post images in their reviews
