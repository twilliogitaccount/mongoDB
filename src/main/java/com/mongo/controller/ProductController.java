package com.mongo.controller;

import com.mongo.entity.Product;
import com.mongo.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/product")
public class ProductController {

    private ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> savedProduct(@RequestBody Product product) {
        Product product1 = productService.saveProduct(product);
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    //    @GetMapping
//    public List<Product> getProductById(Long prodId){
//        productService.findById(prodId);
//
//        return null;
//    }
    @GetMapping("/allProduct")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    @GetMapping("/{prodId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long prodId) {
        Optional<Product> product = productService.getProductById(prodId);
        return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{prodId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long prodId) {
        productService.deleteProductById(prodId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{prodId}")
    public ResponseEntity<Product> updateProductById(@PathVariable Long prodId, @RequestBody Product updatedProduct) {
        try {
            Product updatedProductResult = productService.updateProductById(prodId, updatedProduct);
            return new ResponseEntity<>(updatedProductResult, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
