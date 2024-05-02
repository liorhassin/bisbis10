package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.dto.RestaurantDTO;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void newRestaurant(RestaurantDTO restaurant){
        restaurantRepository.save(restaurantDtoToEntity(restaurant));
    }

    private Restaurant restaurantDtoToEntity(RestaurantDTO restaurantDTO){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.name());
        restaurant.setIsKosher(restaurantDTO.isKosher());
        restaurant.setCuisines(restaurantDTO.cuisines());
        return restaurant;
    }
}
