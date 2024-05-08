package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {

}
