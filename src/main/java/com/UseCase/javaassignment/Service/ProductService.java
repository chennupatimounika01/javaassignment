package com.UseCase.javaassignment.Service;

import com.UseCase.javaassignment.Entity.ProductEntity;
import com.UseCase.javaassignment.Model.Product;
import com.UseCase.javaassignment.Repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class ProductService {

        @Autowired
        private ProductRepository productRepository;
        @lombok.Setter
        @Getter
        private List<ProductEntity> productEntities;

        public Product createProduct(Product product) {
            ProductEntity productEntity = productRepository.save(new ProductEntity(product.getProduct(), product.getDescription(), product.getPrice()));
            return new Product(productEntity.getId(), productEntity.getProduct(), productEntity.getDescription(), productEntity.getPrice());
        }
        private List<Product> mapEntityToModel(@org.jetbrains.annotations.NotNull List<ProductEntity> productEntities) {
            this.productEntities = productEntities;
            List<Product> product = productEntities.stream().map(productEntity -> new Product(productEntity.getId(), productEntity.getProduct(), productEntity.getDescription(), productEntity.getPrice())).toList();
            return product;
        }
        public List<Product> getProducts(String product) {
            List<Product> productByIdIsNotNull = ProductRepository.findProductByIdIsNotNull();
            return productByIdIsNotNull;
        }

        public void setProductRepository(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

    }
