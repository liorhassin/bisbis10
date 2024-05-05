package com.att.tdp.bisbis10.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Rating {
    private @Id @GeneratedValue Long id;
    private float ratingValue;

    @OneToOne
    @JoinColumn(name = "restaurantId", nullable = false, referencedColumnName = "id")
    private Restaurant restaurant;

    public Restaurant getRestaurant() {return restaurant;}

    public void setRestaurant(Restaurant restaurant) {this.restaurant = restaurant;}

    public float getRatingValue() {return ratingValue;}
    public void setRatingValue(float ratingValue) {this.ratingValue = ratingValue;}

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
}
