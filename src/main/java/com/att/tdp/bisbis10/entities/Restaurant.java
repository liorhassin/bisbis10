package com.att.tdp.bisbis10.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {

    private @Id @GeneratedValue Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Rating> ratings;


    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Dish> dishes;

    private boolean is_kosher;
    private @ElementCollection List<String> cuisines;

    public Restaurant() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("averageRating")
    public Float getAverageRatingValue(){
        float value = 0f;
        if(ratings != null && !ratings.isEmpty()){
            int ratingLength = ratings.toArray().length;
            for(int i = 0; i < ratingLength; i++){
                value += ratings.get(i).getRatingValue();
            }
            value = value/ratingLength;
        }
        return Math.round(value * 100.0)/100.0f;
    }

    public boolean getIsKosher() {
        return is_kosher;
    }

    public void setIsKosher(boolean isKosher) {
        this.is_kosher = isKosher;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = new ArrayList<>(cuisines);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Dish> getDishes() {return dishes;}

    public void setDishes(List<Dish> dishes) {this.dishes = dishes;}
}
