package com.javatraineeprogram.finalproject.service.impl;

import com.javatraineeprogram.finalproject.dto.ProductDto;
import com.javatraineeprogram.finalproject.entity.Product;
import com.javatraineeprogram.finalproject.exception.CreateProductNameException;
import com.javatraineeprogram.finalproject.exception.NotFoundException;
import com.javatraineeprogram.finalproject.mapper.MyMapper;
import com.javatraineeprogram.finalproject.repository.ProductRepository;
import com.javatraineeprogram.finalproject.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private MyMapper myMapper;

    @Override
    public Product saveProduct(ProductDto productDto) throws CreateProductNameException {
        if (productRepository.findProductByName(productDto.getName()) != null) {
            throw new CreateProductNameException("A product already exists with the given name");
        }

        return productRepository.save(myMapper.productDtoToProductEntity(productDto));
    }

    @Override
    public ProductDto getProductById(int id) throws NotFoundException {
        try {
            return myMapper.productEntityToProductDto(productRepository.getReferenceById(id));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Couldn't find a product with the given id");
        }
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : products) {
            productDtoList.add(myMapper.productEntityToProductDto(product));
        }
        return productDtoList;
    }

    @Override
    public Product updateProduct(ProductDto productDto, int id) throws NotFoundException {
        try {
            Product product = productRepository.getReferenceById(id);
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            return productRepository.save(product);

        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Couldn't find a product with the given id");
        }
    }

    @Override
    public void deleteProductById(int id) throws NotFoundException {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new NotFoundException("Couldn't find a product with the given id");
        }
    }
}
