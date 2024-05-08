package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    ResponseEntity<?> addOrder(@RequestBody OrderDTO order){
        return ResponseEntity.ok(orderService.addOrder(order).getId());
    }
}
