package com.agileskill.spring.amazon.clone.backend.repo;

import com.agileskill.spring.amazon.clone.backend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    // Doc: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords

    public Product findProductByCode(Integer code);

}
