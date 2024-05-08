package com.att.tdp.bisbis10.entities;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    private @Id @GeneratedValue Long id;

    @ManyToOne
    @JoinColumn(name  = "dishId")
    private Dish dish;

    private int amount;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false,referencedColumnName = "id")
    private Orders order;

    public Dish getDish() {return dish;}

    public void setDish(Dish dish) {this.dish = dish;}

    public int getAmount() {return amount;}

    public void setAmount(int amount) {this.amount = amount;}

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}

    public void setOrder(Orders order) {
        this.order = order;
    }
}
