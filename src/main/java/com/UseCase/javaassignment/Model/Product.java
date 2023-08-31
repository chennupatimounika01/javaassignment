package com.UseCase.javaassignment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Product {

        private long id;
        private String Product;
        private String description;
        private double price;

    }
