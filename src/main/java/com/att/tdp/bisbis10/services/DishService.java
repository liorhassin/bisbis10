package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.dto.DishDTO;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private DishRepository dishRepository;

    public Dish addDish(DishDTO dto, Long restaurantId){
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(restaurantId);
        if(restaurant.isPresent()){
            Dish dish = dishDtoToEntity(dto, restaurantId);
            return dishRepository.save(dish);
        }
        return null;
    }

    public Dish updateDish(DishDTO dto, Long dishId){
        return dishRepository.findById(dishId).map(dish -> {
            if(dto.name() != null) dish.setName(dto.name());
            if(dto.price() != 0) dish.setPrice(dto.price());
            if(dto.description() != null) dish.setDescription(dto.description());
            return dishRepository.save(dish);
        }).orElse(null);
    }

    public void deleteDish(Long dishId){
        dishRepository.deleteById(dishId);
    }

    public List<Dish> getDishesByRestaurantId(Long restaurantId) {
        return dishRepository.getDishesByRestaurantId(restaurantId);
    }

    public Dish getDishById(Long dishId) {
        return dishRepository.findById(dishId).orElse(null);
    }

    private Dish dishDtoToEntity(DishDTO dto, Long restaurantId){
        Dish dish = new Dish();
        dish.setPrice(dto.price());
        dish.setName(dto.name());
        dish.setDescription(dto.description());

        Optional<Restaurant> restaurantOptional = restaurantService.getRestaurantById(restaurantId);
        dish.setRestaurant(restaurantOptional.orElse(null));
        return dish;
    }
}
