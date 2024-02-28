package com.blueyonder.bankingapp.repo;

import com.blueyonder.bankingapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
