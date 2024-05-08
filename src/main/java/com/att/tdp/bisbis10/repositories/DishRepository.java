package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id = :restaurantId")
    List<Dish> getDishesByRestaurantId(@Param("restaurantId") Long restaurantId);
}
