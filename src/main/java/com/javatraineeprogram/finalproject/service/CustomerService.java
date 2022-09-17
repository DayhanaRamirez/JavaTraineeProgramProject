package com.javatraineeprogram.finalproject.service;

import com.javatraineeprogram.finalproject.dto.CustomerDto;
import com.javatraineeprogram.finalproject.dto.NoEmailCustomerDto;
import com.javatraineeprogram.finalproject.entity.Customer;
import com.javatraineeprogram.finalproject.exception.CreateUserEmailException;
import com.javatraineeprogram.finalproject.exception.NotFoundException;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(CustomerDto customerDto) throws CreateUserEmailException;

    CustomerDto getCustomerById(int id) throws NotFoundException;

    List<CustomerDto> getAllCustomers();

    Customer updateCustomer(NoEmailCustomerDto noEmailCustomerDto, int id) throws NotFoundException;

    void deleteCustomerById(int id) throws NotFoundException;
}
