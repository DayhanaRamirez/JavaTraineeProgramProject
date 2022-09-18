package com.javatraineeprogram.finalproject.controller;

import com.javatraineeprogram.finalproject.dto.CustomerDto;
import com.javatraineeprogram.finalproject.dto.CustomerDtoForReturn;
import com.javatraineeprogram.finalproject.dto.NoEmailCustomerDto;
import com.javatraineeprogram.finalproject.exception.CreateUserEmailException;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Validated
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDtoForReturn> getCustomerById(@PathVariable("id") int id) throws NotFoundException {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDtoForReturn>> getCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveCustomer(@Valid @RequestBody CustomerDto customerDto) throws CreateUserEmailException {
        customerService.saveCustomer(customerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateCustomer(@PathVariable("id") int id, @Valid @RequestBody NoEmailCustomerDto noEmailCustomerDto) throws NotFoundException {
        customerService.updateCustomer(noEmailCustomerDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") int id) throws NotFoundException {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
