package com.scalable.task03.repository;

import com.scalable.task03.model.Product;
import com.scalable.task03.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategory(ProductCategory category);
}
