package com.agileskill.spring.amazon.clone.backend.controller.rest;

import com.agileskill.spring.amazon.clone.backend.model.Product;
import com.agileskill.spring.amazon.clone.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class RestAPI {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> retrieveProducts() {
        return productService.retrieveAllProduct();
    }

    @PostMapping("/product/cart")
    public void addToCart(@RequestBody Map<String, Object> body, Principal principal) {
        productService.addProductToCart(Integer.parseInt(String.valueOf(body.get("code"))), principal.getName());
    }

    @GetMapping("/product/cart")
    public List<Product> retrieveCartProducts(Principal principal) {
        return productService.retrieveCartProducts(principal.getName());
    }

    @PostMapping("/product/cart/{code}")
    public void rmFromCart(@PathVariable Integer code, Principal principal) {
        productService.rmProductFromCart(code, principal.getName());
    }


    @RequestMapping(value = "/**/**",method = RequestMethod.OPTIONS)
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
