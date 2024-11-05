package com.amir.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amir.product.dto.ProductRequest;
import com.amir.product.dto.ProductResponse;
import com.amir.product.model.Product;
import com.amir.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    // method to create a Product and save in database
    public void createProduct(ProductRequest productRequest) {
        // using the builder pattern 
        Product product = Product.builder()
            .name(productRequest.name())
            .description(productRequest.description())
            .price(productRequest.price())
            .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
        
    }
    // method to get all products
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(),
                product.getDescription(), product.getPrice());
    }
}