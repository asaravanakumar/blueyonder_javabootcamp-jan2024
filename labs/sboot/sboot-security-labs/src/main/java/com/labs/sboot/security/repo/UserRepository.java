package com.labs.sboot.security.repo;

import com.labs.sboot.security.model.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRequest, Integer> {
    public UserRequest findByUsername(String username);
}
