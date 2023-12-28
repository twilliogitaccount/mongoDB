package com.mongo.service;

import com.mongo.entity.Product;
import com.mongo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        Product save = productRepository.save(product);
        return save;
    }

    @Override
    public void deleteProductById(Long prodId) {
        productRepository.deleteById(prodId);
    }


    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = productRepository.findAll();

        return productList;
    }

    @Override
    public Optional<Product> getProductById(Long prodId) {
        return productRepository.findById(prodId);
    }

    @Override
    public Product updateProductById(Long prodId, Product updatedProduct) {
        // Check if the product with the given ID exists
        Optional<Product> existingProduct = productRepository.findById(prodId);

        if (existingProduct.isPresent()) {
            // Update the existing product with the new values
            Product productToUpdate = existingProduct.get();
            productToUpdate.setName(updatedProduct.getName());
            productToUpdate.setPrice(updatedProduct.getPrice());
            productToUpdate.setDesc(updatedProduct.getDesc());

            // Save and return the updated product
            return productRepository.save(productToUpdate);
        } else {
            // Handle the case where the product with the given ID is not found
            throw new RuntimeException("Product not found with ID: " + prodId);
        }
    }

}
