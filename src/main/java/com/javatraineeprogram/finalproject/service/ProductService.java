package com.javatraineeprogram.finalproject.service;

import com.javatraineeprogram.finalproject.dto.ProductDto;
import com.javatraineeprogram.finalproject.entity.Product;
import com.javatraineeprogram.finalproject.exception.CreateProductNameException;
import com.javatraineeprogram.finalproject.exception.NotFoundException;

import java.util.List;

public interface ProductService {

    Product saveProduct(ProductDto productDto) throws CreateProductNameException;

    ProductDto getProductById(int id) throws NotFoundException;

    List<ProductDto> getAllProducts();

    Product updateProduct(ProductDto productDto, int id) throws NotFoundException;

    void deleteProductById(int id) throws NotFoundException;
}
