package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.DishDTO;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants/{id}/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    ResponseEntity<?> addDish(@PathVariable Long id, @RequestBody DishDTO dishDTO){
        Dish dish = dishService.addDish(dishDTO, id);
        if(dish == null) return ResponseEntity.badRequest().body("failed to create new dish");
        return ResponseEntity.status(201).body(null);
    }

    @PutMapping("/{dishId}")
    ResponseEntity<?> updateDish(@PathVariable Long dishId, @RequestBody DishDTO dishDTO){
        Dish dish = dishService.updateDish(dishDTO, dishId);
        if(dish == null) return ResponseEntity.badRequest().body("failed to update new dish");
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{dishId}")
    ResponseEntity<?> deleteDish(@PathVariable Long dishId){
        dishService.deleteDish(dishId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    ResponseEntity<List<Dish>> getDishesByRestaurant(@PathVariable Long id){
        return ResponseEntity.ok(dishService.getDishesByRestaurantId(id));
    }
}
