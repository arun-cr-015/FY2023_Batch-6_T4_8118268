package com.virtusa.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.virtusa.project.model.Product;
import com.virtusa.project.model.ProductCategory;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	public List<Product> findAllByProductCategoryOrderByProductName(ProductCategory productCategory);

	public List<Product> findAllByOrderByProductName();

	public List<Product> findByProductNameContaining(String productname);
}
