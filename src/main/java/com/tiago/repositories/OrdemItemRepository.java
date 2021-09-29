package com.tiago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.entities.OrdemItem;

public interface OrdemItemRepository extends JpaRepository<OrdemItem, Long> {

}
