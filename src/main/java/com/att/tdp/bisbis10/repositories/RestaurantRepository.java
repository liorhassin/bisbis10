package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
