package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.dto.RestaurantDTO;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void newRestaurant(RestaurantDTO restaurant){
        restaurantRepository.save(restaurantDtoToEntity(restaurant));
    }

    public Optional<Restaurant> getRestaurantById(Long id){
        return restaurantRepository.findById(id);
    }

    private Restaurant restaurantDtoToEntity(RestaurantDTO restaurantDTO){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.name());
        restaurant.setIsKosher(restaurantDTO.isKosher());
        restaurant.setCuisines(restaurantDTO.cuisines());
        return restaurant;
    }

    public List<Restaurant> findRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.getRestaurantsByCuisine(cuisine);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant editRestaurant(RestaurantDTO newRestaurant, Long id) {
        return getRestaurantById(id).map(restaurant -> {
            if(newRestaurant.name() != null) restaurant.setName(newRestaurant.name());
            if(newRestaurant.isKosher() != restaurant.getIsKosher()) restaurant.setIsKosher(newRestaurant.isKosher());
            if(newRestaurant.cuisines() != null) restaurant.setCuisines(newRestaurant.cuisines());
            return restaurantRepository.save(restaurant);
        }).orElse(null);
    }
}
