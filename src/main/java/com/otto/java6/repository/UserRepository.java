package com.otto.java6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otto.java6.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
