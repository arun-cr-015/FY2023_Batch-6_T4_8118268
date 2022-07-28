package com.virtusa.project.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.virtusa.project.model.Cart;
import com.virtusa.project.model.UserModel;



@Repository
public interface CartRepo extends JpaRepository<Cart, Long>{
	
	
	
	public Cart  findByUser(UserModel user);
	
}
