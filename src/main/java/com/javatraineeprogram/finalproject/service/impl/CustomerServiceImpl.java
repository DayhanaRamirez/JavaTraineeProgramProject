package com.javatraineeprogram.finalproject.service.impl;

import com.javatraineeprogram.finalproject.dto.*;
import com.javatraineeprogram.finalproject.entity.Address;
import com.javatraineeprogram.finalproject.entity.Customer;
import com.javatraineeprogram.finalproject.entity.PaymentMethod;
import com.javatraineeprogram.finalproject.exception.CreateUserEmailException;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.mapper.AddressMapper;
import com.javatraineeprogram.finalproject.mapper.CustomerMapper;
import com.javatraineeprogram.finalproject.mapper.PaymentMethodMapper;
import com.javatraineeprogram.finalproject.repository.AddressRepository;
import com.javatraineeprogram.finalproject.repository.CustomerRepository;
import com.javatraineeprogram.finalproject.repository.PaymentMethodRepository;
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
    private AddressRepository addressRepository;
    private PaymentMethodRepository paymentMethodRepository;
    private CustomerMapper customerMapper;
    private AddressMapper addressMapper;
    private PaymentMethodMapper paymentMethodMapper;

    @Override
    public Customer saveCustomer(CustomerDto customerDto) throws CreateUserEmailException {
        if (customerRepository.findCustomerByEmail(customerDto.getEmail()) != null) {
            throw new CreateUserEmailException("A customer already exists with the given email");
        }

        return customerRepository.save(saveWithEmail(customerDto));
    }

    @Override
    public CustomerDtoForReturn getCustomerById(int id) throws NotFoundException {
        try {
            Customer customer = customerRepository.getReferenceById(id);
            return convert(customer);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Couldn't find a customer with the given id");
        }
    }

    @Override
    public List<CustomerDtoForReturn> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDtoForReturn> customerDtoForReturnList = new ArrayList<>();
        for (Customer customer : customers) {
            customerDtoForReturnList.add(convert(customer));
        }
        return customerDtoForReturnList;
    }

    @Override
    public Customer updateCustomer(NoEmailCustomerDto noEmailCustomerDto, int id) throws NotFoundException {
        try {
            Customer customer = customerRepository.getReferenceById(id);
            customer.setFirstName(noEmailCustomerDto.getFirstName());
            customer.setLastName(noEmailCustomerDto.getLastName());
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

    private CustomerDtoForReturn convert(Customer customer) {
        CustomerDtoForReturn customerDtoForReturn = customerMapper.customerEntityToCustomerDto(customer);

        if (!customer.getAddresses().isEmpty()) {
            for (Address address : customer.getAddresses()) {
                AddressDtoForReturn addressDtoForReturn = addressMapper.addressEntityToAddressDto(address);
                customerDtoForReturn.getAddressDtoForReturnList().add(addressDtoForReturn);
            }
        }

        if (!customer.getPaymentMethods().isEmpty()) {
            for (PaymentMethod paymentMethod : customer.getPaymentMethods()) {
                PaymentMethodDtoForReturn paymentMethodDtoForReturn = paymentMethodMapper.paymentMethodEntityToPaymentMethodDto(paymentMethod);
                customerDtoForReturn.getPaymentMethodDtoForReturnList().add(paymentMethodDtoForReturn);
            }
        }

        return customerDtoForReturn;
    }

    private Customer saveWithEmail(CustomerDto customerDto) {
        Customer customer = customerMapper.customerDtoToCustomerEntity(customerDto);

        if (!customerDto.getAddressDtoList().isEmpty()) {
            for (AddressDto addressDto : customerDto.getAddressDtoList()) {
                Address address = addressMapper.addressDtoToAddressEntity(addressDto);
                address.setCustomer(customer);
                customer.getAddresses().add(address);
            }
        }

        if (!customerDto.getPaymentMethodDtoList().isEmpty()) {
            for (PaymentMethodDto paymentMethodDto : customerDto.getPaymentMethodDtoList()) {
                PaymentMethod paymentMethod = paymentMethodMapper.paymentMethodDtoToPaymentMethodEntity(paymentMethodDto);
                paymentMethod.setCustomer(customer);
                customer.getPaymentMethods().add(paymentMethod);
            }
        }

        return customer;
    }
}
