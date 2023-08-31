package com.UseCase.javaassignment.Repository;

import com.UseCase.javaassignment.Entity.ProductEntity;
import com.UseCase.javaassignment.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByProduct(String product);
    List<ProductEntity> findByPrice(Double price);

    static List<Product> findProductByIdIsNotNull() {
        return null;
    }
}


