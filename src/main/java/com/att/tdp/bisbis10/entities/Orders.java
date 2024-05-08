package com.att.tdp.bisbis10.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Orders {

    private @Id @GeneratedValue(strategy = GenerationType.UUID) UUID id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false, referencedColumnName = "id")
    private Restaurant restaurant;



}
