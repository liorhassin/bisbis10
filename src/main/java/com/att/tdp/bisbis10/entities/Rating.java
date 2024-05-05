package com.att.tdp.bisbis10.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Rating {
    private @Id @GeneratedValue Long id;
    private float ratingValue;
    private Long restaurantId;


    public float getRatingValue() {return ratingValue;}
    public void setRatingValue(float ratingValue) {this.ratingValue = ratingValue;}

    public Long getRestaurantId() {return restaurantId;}
    public void setRestaurantId(Long restaurantId) {this.restaurantId = restaurantId;}

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
}
