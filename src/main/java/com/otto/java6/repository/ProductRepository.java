package com.otto.java6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otto.java6.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
