package com.javatraineeprogram.finalproject.controller;

import com.javatraineeprogram.finalproject.dto.ProductDto;
import com.javatraineeprogram.finalproject.exception.CreateUserEmailException;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getCustomerById(@PathVariable("id") int id) throws NotFoundException {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getCustomers() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveCustomer(@Valid @RequestBody ProductDto productDto) throws CreateUserEmailException {
        productService.saveProduct(productDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateCustomer(@PathVariable("id") int id, @Valid @RequestBody ProductDto productDto) throws NotFoundException {
        productService.updateProduct(productDto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") int id) throws NotFoundException {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
