package com.javatraineeprogram.finalproject.repository;

import com.javatraineeprogram.finalproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findProductByName(String name);
}
