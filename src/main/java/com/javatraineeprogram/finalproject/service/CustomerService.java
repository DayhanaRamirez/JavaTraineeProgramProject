package com.javatraineeprogram.finalproject.service;

import com.javatraineeprogram.finalproject.dto.CustomerDto;
import com.javatraineeprogram.finalproject.dto.NoEmailCustomerDto;
import com.javatraineeprogram.finalproject.entity.Customer;
import com.javatraineeprogram.finalproject.exception.customer.CreateUserEmailException;
import com.javatraineeprogram.finalproject.exception.customer.NotFoundUserException;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(CustomerDto customerDto) throws CreateUserEmailException;

    CustomerDto getCustomerById(int id) throws NotFoundUserException;

    List<CustomerDto> getAllCustomers();

    Customer updateCustomer(NoEmailCustomerDto noEmailCustomerDto, int id) throws NotFoundUserException;

    void deleteCustomerById(int id) throws NotFoundUserException;
}
