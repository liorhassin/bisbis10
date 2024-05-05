package com.att.tdp.bisbis10.entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {

    private @Id @GeneratedValue Long id;
    private String name;

    @JsonIgnore
    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Rating rating;

    private boolean is_kosher;
    private @ElementCollection List<String> cuisines;

    public Restaurant() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {return rating;}

    @JsonGetter("rating")
    public Float getRatingValue(){ return rating != null ? rating.getRatingValue() : null; }

    public void setRating(Rating rating) {
        this.rating = rating;
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

}
