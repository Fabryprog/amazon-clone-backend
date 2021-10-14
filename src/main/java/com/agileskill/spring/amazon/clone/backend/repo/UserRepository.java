package com.agileskill.spring.amazon.clone.backend.repo;

import com.agileskill.spring.amazon.clone.backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByUsername(String username);
}
