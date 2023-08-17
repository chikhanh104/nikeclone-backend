package com.otto.java6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otto.java6.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
