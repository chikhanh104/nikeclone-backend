package com.otto.java6.service;

import java.util.List;

import com.otto.java6.entity.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Order createOrder(Order order);
}