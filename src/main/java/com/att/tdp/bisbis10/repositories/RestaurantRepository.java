package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.dto.RestaurantDTO;
import com.att.tdp.bisbis10.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("SELECT r FROM Restaurant r JOIN r.cuisines c WHERE c ilike :cuisine")
    List<RestaurantDTO> getRestaurantsByCuisine(@Param("cuisine") String cuisine);

}
