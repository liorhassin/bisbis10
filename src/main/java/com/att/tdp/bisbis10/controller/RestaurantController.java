package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.RestaurantDTO;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{id}")
    ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id){
        return restaurantService.getRestaurantById(id)
                .map(restaurant -> ResponseEntity.ok().body(restaurant))
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping()
    ResponseEntity<List<Restaurant>> getAllRestaurants(@RequestParam(name = "cuisine", required = false) Optional<String> cuisine){
        ResponseEntity<List<Restaurant>> responseEntity;
        if(cuisine.isPresent() && !cuisine.get().isEmpty()){
            responseEntity = ResponseEntity.ok(restaurantService.findRestaurantsByCuisine(cuisine.get()));
        }else{
            responseEntity = ResponseEntity.ok(restaurantService.getAllRestaurants());
        }
        return responseEntity;
    }

    @PostMapping
    ResponseEntity<?> newRestaurant(@RequestBody RestaurantDTO restaurant){
        restaurantService.newRestaurant(restaurant);
        return ResponseEntity.status(201).body(null);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> editRestaurant(@RequestBody RestaurantDTO newRestaurant, @PathVariable Long id){
        if(newRestaurant == null){
            return ResponseEntity.badRequest().body("Restaurant data is missing");
        }
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        if(restaurant.isPresent())
            return ResponseEntity.ok(restaurantService.editRestaurant(newRestaurant, id));
        else
            return ResponseEntity.badRequest().body("Restaurant is not found in database with given id");
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteRestaurant(@PathVariable Long id){
        try {
            restaurantService.deleteRestaurant(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }
}
