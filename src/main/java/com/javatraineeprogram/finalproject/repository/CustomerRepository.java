package com.javatraineeprogram.finalproject.repository;

import com.javatraineeprogram.finalproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer findCustomerByEmail(String email);
}
