package com.javatraineeprogram.finalproject.service.impl;

import com.javatraineeprogram.finalproject.dto.CustomerDto;
import com.javatraineeprogram.finalproject.dto.NoEmailCustomerDto;
import com.javatraineeprogram.finalproject.entity.Customer;
import com.javatraineeprogram.finalproject.exception.CreateUserEmailException;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.mapper.Mapper;
import com.javatraineeprogram.finalproject.repository.CustomerRepository;
import com.javatraineeprogram.finalproject.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(CustomerDto customerDto) throws CreateUserEmailException {
        if (customerRepository.findCustomerByEmail(customerDto.getEmail()) != null) {
            throw new CreateUserEmailException("A customer already exists with the given email");
        }
        return customerRepository.save(Mapper.customerDtoToCustomerEntity(customerDto));
    }

    @Override
    public CustomerDto getCustomerById(int id) throws NotFoundException {

        try {
            return Mapper.customerEntityToCustomerDto(customerRepository.getReferenceById(id));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Couldn't find a customer with the given id");
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            customerDtos.add(Mapper.customerEntityToCustomerDto(customer));
        }
        return customerDtos;
    }

    @Override
    public Customer updateCustomer(NoEmailCustomerDto noEmailCustomerDto, int id) throws NotFoundException {
        try {
            Customer customer = customerRepository.getReferenceById(id);
            customer.setFirstName(noEmailCustomerDto.getFirstName());
            customer.setLastName(noEmailCustomerDto.getLastName());
            customer.setAddresses(noEmailCustomerDto.getAddresses());
            customer.setPaymentMethods(noEmailCustomerDto.getPaymentMethods());
            return customerRepository.save(customer);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Couldn't find a customer with the given id");
        }
    }

    @Override
    public void deleteCustomerById(int id) throws NotFoundException {
        try {
            customerRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("Couldn't find a customer with the given id");
        }
    }
}
