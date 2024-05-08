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

    //TODO - Add validation, can't add dish if restaurant id doesn't exist.
    public Dish addDish(DishDTO dto, Long restaurantId){
        Dish dish = dishDtoToEntity(dto, restaurantId);
        return dishRepository.save(dish);
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
