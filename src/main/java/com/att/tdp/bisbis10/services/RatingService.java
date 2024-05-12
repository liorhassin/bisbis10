package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.dto.RatingDTO;
import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private RestaurantService restaurantService;

    public void addRating(RatingDTO ratingDTO) {
        ratingRepository.save(ratingDtoToEntity(ratingDTO));
    }

    private Rating ratingDtoToEntity(RatingDTO ratingDTO){
        Rating rating = new Rating();
        rating.setRatingValue(ratingDTO.rating());

        Optional<Restaurant> restaurantOptional = restaurantService.getRestaurantById(ratingDTO.restaurantId());
        if(restaurantOptional.isPresent()) rating.setRestaurant(restaurantOptional.get());
        else rating.setRestaurant(null);

        return rating;
    }
}
