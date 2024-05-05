package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.dto.RatingDTO;
import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public void updateRating(RatingDTO ratingDTO) {
        Rating rating = ratingDtoToEntity(ratingDTO);
        ratingRepository.save(rating);
    }

    private Rating ratingDtoToEntity(RatingDTO ratingDTO){
        Rating rating = new Rating();
        rating.setRatingValue(ratingDTO.rating());
        rating.setRestaurantId(ratingDTO.restaurantId());
        return rating;
    }
}
