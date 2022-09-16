package com.javatraineeprogram.finalproject.service.impl;

import com.javatraineeprogram.finalproject.dto.ProductDto;
import com.javatraineeprogram.finalproject.entity.Product;
import com.javatraineeprogram.finalproject.exception.CreateProductNameException;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.repository.ProductRepository;
import com.javatraineeprogram.finalproject.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product saveProduct(ProductDto productDto) throws CreateProductNameException {
        if(productRepository.findProductByName(productDto.getName()) != null){
            throw new CreateProductNameException("A product already exists with the given name");
        }

        return null;
}

    @Override
    public ProductDto getProductById(int id) throws NotFoundException {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(ProductDto productDto) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteProductById(int id) throws NotFoundException {

    }
}
