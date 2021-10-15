package com.agileskill.spring.amazon.clone.backend.service;

import com.agileskill.spring.amazon.clone.backend.model.Product;
import com.agileskill.spring.amazon.clone.backend.model.ShoppingCart;
import com.agileskill.spring.amazon.clone.backend.repo.ProductRepository;
import com.agileskill.spring.amazon.clone.backend.repo.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public List<Product> retrieveAllProduct() {
        //TODO business logic (sort/ filtering)
        return productRepository.findAll();
    }

    public void addProductToCart(Integer productCode, String username) {
        Product product = productRepository.findProductByCode(productCode);

        Optional<ShoppingCart> opt = shoppingCartRepository.findById(username);

        List<Product> products = new LinkedList<>();

        if(opt.isPresent()) {
            products = (opt.get().getProduct() == null) ? new LinkedList<>() : opt.get().getProduct();

            //TODO quantity
            boolean find = false;
            for(Product p : products) {
                if(p.getCode().equals(product.getCode())) {
                    find = true;
                    break;
                }
            }
            if(!find) {
                products.add(product);
            }
        } else {
            products.add(product);
        }

        shoppingCartRepository.save(new ShoppingCart(username, products));

    }

    public void rmProductFromCart(Integer productCode, String username) {
        Product product = productRepository.findProductByCode(productCode);

        Optional<ShoppingCart> opt = shoppingCartRepository.findById(username);

        if(opt.isPresent()) {
            List<Product> products = opt.get().getProduct();

            //TODO quantity
            for(Product p : products) {
                if(p.getCode().equals(product.getCode())) {
                    products.remove(p);
                    shoppingCartRepository.save(new ShoppingCart(username, products));
                    break;
                }
            }
        }
    }

    public List<Product> retrieveCartProducts(String username) {
        Optional<ShoppingCart> opt = shoppingCartRepository.findById(username);

        return opt.isPresent() ? shoppingCartRepository.findById(username).get().getProduct() : Collections.EMPTY_LIST;
    }

}
