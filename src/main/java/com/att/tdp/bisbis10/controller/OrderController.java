package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.OrderDTO;
import com.att.tdp.bisbis10.entities.Orders;
import com.att.tdp.bisbis10.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    ResponseEntity<?> addOrder(@RequestBody OrderDTO orderDto){
        Orders order = orderService.addOrder(orderDto);
        if(order == null) return ResponseEntity.badRequest().body("Failed to create new order");
        return ResponseEntity.ok().body(order.getId());
    }
}
