package com.mongo.service;

import com.mongo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product saveProduct(Product product);
//    List<Product> getAllProduct();
//    List<Product> getProductById(long prodId);

    void deleteProductById(Long prodId);

    List<Product> getAllProduct();

    Optional<Product> getProductById(Long prodId);

    Product updateProductById(Long prodId, Product updatedProduct);
}
