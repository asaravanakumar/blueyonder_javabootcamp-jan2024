package com.blueyonder.bankingapp.service;

import com.blueyonder.bankingapp.exception.FundTransferException;
import com.blueyonder.bankingapp.model.FundTransferVo;

import java.util.Collection;
import java.util.Optional;

public interface FundTransferService {
    public boolean fundTransfer(FundTransferVo fundTransferVo) throws FundTransferException;
    public Optional<FundTransferVo> getFundTransfer(int id) throws FundTransferException;

    public Collection<FundTransferVo> getAllFundTransfers() throws FundTransferException;

    public boolean processFundTransfer(FundTransferVo fundTransferVo) throws FundTransferException;
}
