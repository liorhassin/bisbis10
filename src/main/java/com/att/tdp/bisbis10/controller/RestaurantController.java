package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.RestaurantDTO;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{id}")
    ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id){
        return restaurantService.getRestaurantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping()
    ResponseEntity<List<Restaurant>> getAllRestaurants(@RequestParam(name = "cuisine", required = false) String cuisine){
        ResponseEntity<List<Restaurant>> responseEntity;
        if(cuisine!=null && !cuisine.isEmpty()){
            responseEntity = ResponseEntity.ok(restaurantService.findRestaurantsByCuisine(cuisine));
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
    ResponseEntity<?> editRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable Long id, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(restaurantService.editRestaurant(newRestaurant, id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteRestaurant(@PathVariable Long id){
        try {
            restaurantService.deleteRestaurant(id);
            return ResponseEntity.status(204).body(null);
        }catch(Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }
}
