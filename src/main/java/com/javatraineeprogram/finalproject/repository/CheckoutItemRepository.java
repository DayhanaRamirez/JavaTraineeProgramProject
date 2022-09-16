package com.javatraineeprogram.finalproject.repository;

import com.javatraineeprogram.finalproject.entity.CheckoutItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutItemRepository extends JpaRepository<CheckoutItem, Integer> {
}
