package com.agileskill.spring.amazon.clone.backend.model;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@RedisHash
public class ShoppingCart {
    @Id
    private String id;
    private List<Product> products;

    public ShoppingCart(String id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }
}
