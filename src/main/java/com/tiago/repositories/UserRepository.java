package com.tiago.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiago.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
