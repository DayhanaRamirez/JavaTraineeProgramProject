package com.javatraineeprogram.finalproject.mapper;

import com.javatraineeprogram.finalproject.dto.CustomerDto;
import com.javatraineeprogram.finalproject.dto.CustomerDtoForReturn;
import com.javatraineeprogram.finalproject.entity.Customer;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CustomerMapper {

    public Customer customerDtoToCustomerEntity(CustomerDto customerDto) {
        return Customer.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .email(customerDto.getEmail())
                .build();
    }

    public CustomerDtoForReturn customerEntityToCustomerDto(Customer customer) {
        return CustomerDtoForReturn.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }
}
