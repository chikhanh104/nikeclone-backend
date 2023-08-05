package com.otto.java6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otto.java6.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
