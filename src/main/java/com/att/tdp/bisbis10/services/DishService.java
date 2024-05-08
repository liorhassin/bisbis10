package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.dto.DishDTO;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private DishRepository dishRepository;

    public Dish addDish(DishDTO dto, Long restaurantId){
        Dish dish = dishDtoToEntity(dto, restaurantId);
        return dishRepository.save(dish);
    }

    private Dish dishDtoToEntity(DishDTO dto, Long restaurantId){
        Dish dish = new Dish();
        dish.setPrice(dto.price());
        dish.setName(dto.name());
        dish.setDescription(dto.description());

        //TODO - Check how orElse works instead of this code:
        Optional<Restaurant> restaurantOptional = restaurantService.getRestaurantById(restaurantId);
        if(restaurantOptional.isPresent())
            dish.setRestaurant(restaurantOptional.get());
        else dish.setRestaurant(null);

        return dish;
    }
}
