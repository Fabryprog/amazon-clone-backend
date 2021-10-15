package com.agileskill.spring.amazon.clone.backend.service;

import com.agileskill.spring.amazon.clone.backend.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> retrieveAllProduct();

    public void addProductToCart(Integer productCode, String username);

    public void rmProductFromCart(Integer productCode, String username);

    public List<Product> retrieveCartProducts(String username);
}
