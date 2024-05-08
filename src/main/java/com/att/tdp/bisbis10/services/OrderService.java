package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.dto.OrderDTO;
import com.att.tdp.bisbis10.dto.OrderItemDTO;
import com.att.tdp.bisbis10.entities.OrderItem;
import com.att.tdp.bisbis10.entities.Orders;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DishService dishService;

    @Autowired
    private RestaurantService restaurantService;

    //TODO - Make sure all validations are set before enabling the creation of new order.
    public Orders addOrder(OrderDTO orderDTO){
        Orders orders = new Orders();
        Restaurant restaurant = restaurantService.getRestaurantById(orderDTO.restaurantId()).orElse(null);
        if(restaurant == null){
            return null;
        }
        orders.setRestaurant(restaurant);
        List<OrderItem> orderItems = new ArrayList<>();
        orderDTO.orderItems().forEach(orderItemDto -> {
            OrderItem orderItem = orderItemDtoToEntity(orderItemDto);
            orderItem.setOrder(orders);
            orderItems.add(orderItem);
        });
        orders.setOrderItems(orderItems);
        return orderRepository.save(orders);
    }

    private OrderItem orderItemDtoToEntity(OrderItemDTO orderItemDTO){
        OrderItem orderItem = new OrderItem();
        orderItem.setAmount(orderItemDTO.amount());
        orderItem.setDish(dishService.getDishById(orderItemDTO.dishId()));
        return orderItem;
    }
}
