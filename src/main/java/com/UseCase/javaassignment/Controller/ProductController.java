package com.UseCase.javaassignment.Controller;

import com.UseCase.javaassignment.Model.Product;
import com.UseCase.javaassignment.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api")
    public class ProductController {

        @Autowired
        private ProductService productService;

        @PostMapping("/products")
        public ResponseEntity<Product> createProduct(@RequestBody Product product) {
            try {
                Product _product = productService.createProduct(product);
                return new ResponseEntity<>(_product, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @GetMapping("/products")
        public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = true) String product) {
            List<Product> productList = productService.getProducts(product);
            return ResponseEntity.ok(productList);
        }
        @GetMapping("/products/name")
        public ResponseEntity<List<Product>> getProducts(@RequestParam(required = true) String product){
            List<Product> productList = productService.getProducts(product);
            return ResponseEntity.ok(productList);
        }

    }
