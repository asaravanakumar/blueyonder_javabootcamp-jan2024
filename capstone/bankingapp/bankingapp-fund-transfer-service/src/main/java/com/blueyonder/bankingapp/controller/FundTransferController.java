package com.blueyonder.bankingapp.controller;

import com.blueyonder.bankingapp.exception.FundTransferException;
import com.blueyonder.bankingapp.exception.NoFundTransferFoundException;
import com.blueyonder.bankingapp.model.FundTransferVo;
import com.blueyonder.bankingapp.model.ResponseMessage;
import com.blueyonder.bankingapp.service.FundTransferService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/fundtransfers")
public class FundTransferController {

    @Autowired
    FundTransferService service;

    @PostMapping
    public ResponseEntity<ResponseMessage> fundTransfer(@RequestBody @Valid FundTransferVo fundTransferVo) throws FundTransferException {
        boolean status = service.fundTransfer(fundTransferVo);
        ResponseMessage response = status ?
                new ResponseMessage("Success", "Fund Transfer Initiated!!!") :
                new ResponseMessage("Failure", "Fund Transfer Failed!!!");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public Collection<FundTransferVo> getAllFundTransfers() throws FundTransferException {
        return service.getAllFundTransfers();
    }

    @GetMapping("/{id}")
    public FundTransferVo getFundTransfer(@PathVariable(name = "id") int id) throws FundTransferException {
        return service.getFundTransfer(id).orElseThrow(NoFundTransferFoundException::new);
    }

}
