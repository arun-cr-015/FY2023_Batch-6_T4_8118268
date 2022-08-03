package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.CartItem;
@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long>{

}
