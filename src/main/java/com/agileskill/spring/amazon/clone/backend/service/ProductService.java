package com.agileskill.spring.amazon.clone.backend.service;

import com.agileskill.spring.amazon.clone.backend.model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> retrieveAllProduct();

    public void addProductToCart(Integer productCode);

    public void rmProductFromCart(Integer productCode);

    public List<Product> retrieveCartProducts();
}
