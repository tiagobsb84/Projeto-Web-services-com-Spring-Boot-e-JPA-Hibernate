package com.tiago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
