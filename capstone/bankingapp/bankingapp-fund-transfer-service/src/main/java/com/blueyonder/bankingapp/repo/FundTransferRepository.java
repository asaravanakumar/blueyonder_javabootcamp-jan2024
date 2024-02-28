package com.blueyonder.bankingapp.repo;

import com.blueyonder.bankingapp.model.FundTransferVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundTransferRepository extends JpaRepository<FundTransferVo, Integer> {
}
