package com.blueyonder.bankingapp.repo;

import com.blueyonder.bankingapp.model.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRequest, Integer> {
    public UserRequest findByUsername(String username);
}
