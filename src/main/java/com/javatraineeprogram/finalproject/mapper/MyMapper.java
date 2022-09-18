package com.javatraineeprogram.finalproject.mapper;

import com.javatraineeprogram.finalproject.dto.AddressDto;
import com.javatraineeprogram.finalproject.dto.CustomerDto;
import com.javatraineeprogram.finalproject.dto.PaymentMethodDto;
import com.javatraineeprogram.finalproject.dto.ProductDto;
import com.javatraineeprogram.finalproject.entity.Address;
import com.javatraineeprogram.finalproject.entity.Customer;
import com.javatraineeprogram.finalproject.entity.PaymentMethod;
import com.javatraineeprogram.finalproject.entity.Product;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MyMapper {

    public Customer customerDtoToCustomerEntity(CustomerDto customerDto) {
        return Customer.builder()
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .email(customerDto.getEmail())
                .build();
    }

    public CustomerDto customerEntityToCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }

    public Product productDtoToProductEntity(ProductDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();
    }

    public ProductDto productEntityToProductDto(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public Address addressDtoToAddressEntity(AddressDto addressDto) {
        return Address.builder()
                .street(addressDto.getStreet())
                .city(addressDto.getCity())
                .state(addressDto.getState())
                .build();
    }

    public AddressDto addressEntityToAddressDto(Address address) {
        return AddressDto.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .build();
    }

    public PaymentMethod paymentMethodDtoToPaymentMethodEntity(PaymentMethodDto paymentMethodDto) {
        return PaymentMethod.builder()
                .type(paymentMethodDto.getType())
                .number(paymentMethodDto.getNumber())
                .build();
    }

    public PaymentMethodDto paymentMethodEntityToPaymentMethodDto(PaymentMethod paymentMethod) {
        return PaymentMethodDto.builder()
                .type(paymentMethod.getType())
                .number(paymentMethod.getNumber())
                .build();
    }

}
