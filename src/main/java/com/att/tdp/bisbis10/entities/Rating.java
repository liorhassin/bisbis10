package com.att.tdp.bisbis10.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Rating {
    private @Id @GeneratedValue Long id;
    private float rating;

    @OneToOne
    @JoinColumn(name = "restaurantId", nullable = false, referencedColumnName = "id")
    @JsonIgnore
    private Restaurant restaurant;

    public Restaurant getRestaurant() {return restaurant;}

    public void setRestaurant(Restaurant restaurant) {this.restaurant = restaurant;}

    public float getRatingValue() {return rating;}
    public void setRatingValue(float ratingValue) {this.rating = ratingValue;}

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
}
