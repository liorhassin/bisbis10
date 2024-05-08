package com.att.tdp.bisbis10.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Dish {

    private @Id @GeneratedValue Long id;


    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}
}
