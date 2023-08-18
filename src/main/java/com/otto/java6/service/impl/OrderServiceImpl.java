package com.otto.java6.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.otto.java6.entity.Order;
import com.otto.java6.entity.Product;
import com.otto.java6.entity.User;
import com.otto.java6.repository.OrderRepository;
import com.otto.java6.repository.ProductRepository;
import com.otto.java6.repository.UserRepository;
import com.otto.java6.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    @Override
    public List<Order> getAllOrders() {
        // TODO Auto-generated method stub
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        // TODO Auto-generated method stub
        Integer userId = order.getUser().getId();
        User user = userRepository.findById(userId).orElse(null);

        Long productId = order.getProduct().getId();
        Product product = productRepository.findById(productId).orElse(null);

        if (user != null && product != null) {
            order.setUser(user);
            order.setProduct(product);
            order.setUpdatedate(LocalDateTime.now());
            return orderRepository.save(order);
        } else {
            // Handle user or product not found
            return null;
        }
    }
}

