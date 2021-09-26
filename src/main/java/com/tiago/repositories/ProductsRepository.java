package com.tiago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.entities.Product;

public interface ProductsRepository extends JpaRepository<Product, Long> {

}
