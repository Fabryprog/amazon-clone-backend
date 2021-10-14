package com.agileskill.spring.amazon.clone.backend.repo;

import com.agileskill.spring.amazon.clone.backend.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, String> {

}