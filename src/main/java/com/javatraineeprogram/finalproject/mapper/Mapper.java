package com.javatraineeprogram.finalproject.mapper;

import com.javatraineeprogram.finalproject.dto.CustomerDto;
import com.javatraineeprogram.finalproject.entity.Customer;

public class Mapper {

    public static Customer customerDtoToCustomerEntity(CustomerDto customerDto){
        return Customer.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .email(customerDto.getEmail())
                .addresses(customerDto.getAddresses())
                .paymentMethods(customerDto.getPaymentMethods())
                .build();
    }

    public static CustomerDto customerEntityToCustomerDto(Customer customer){
        return CustomerDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .addresses(customer.getAddresses())
                .paymentMethods(customer.getPaymentMethods())
                .build();
    }
}
