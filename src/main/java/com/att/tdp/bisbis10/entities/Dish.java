package com.att.tdp.bisbis10.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Dish {

    private @Id @GeneratedValue Long id;
    private String name;
    private String description;
    private int price;

    @ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false, referencedColumnName = "id")
    @JsonIgnore
    private Restaurant restaurant;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    public Restaurant getRestaurant() {return restaurant;}
    public void setRestaurant(Restaurant restaurant) {this.restaurant = restaurant;}

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
}
