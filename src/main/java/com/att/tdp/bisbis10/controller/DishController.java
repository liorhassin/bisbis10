package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.DishDTO;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants/{id}/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    ResponseEntity<?> addDish(@PathVariable Long id, @RequestBody DishDTO dishDTO){
        Dish dish = dishService.addDish(dishDTO, id);
        if(dish == null) return ResponseEntity.status(500).body(null);
        return ResponseEntity.status(201).body(null);
    }

}
