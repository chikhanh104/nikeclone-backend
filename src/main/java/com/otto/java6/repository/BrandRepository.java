package com.otto.java6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otto.java6.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
