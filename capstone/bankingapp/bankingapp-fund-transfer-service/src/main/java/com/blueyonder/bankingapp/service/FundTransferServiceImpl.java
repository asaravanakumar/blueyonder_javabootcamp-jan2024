package com.blueyonder.bankingapp.service;

import com.blueyonder.bankingapp.exception.FundTransferException;
import com.blueyonder.bankingapp.model.FundTransferStatus;
import com.blueyonder.bankingapp.model.FundTransferVo;
import com.blueyonder.bankingapp.repo.FundTransferRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class FundTransferServiceImpl implements FundTransferService {

    @Autowired
    FundTransferRepository fundTransferRepo;

    @Autowired
    private KafkaTemplate<String, FundTransferVo> kafkaTemplate;

    @Value("${bankingapp.kafka.topic.fund-transfers}")
    private String topicName;

    @Override
    public boolean fundTransfer(FundTransferVo fundTransferVo) throws FundTransferException {
        fundTransferVo.setStatus(FundTransferStatus.PENDING);
        log.info("Saving fund transfer event - {}", fundTransferVo.toString());

        FundTransferVo savedObj = fundTransferRepo.save(fundTransferVo);

        log.info("Publishing fund transfer event - {}", fundTransferVo.toString());
        CompletableFuture future = kafkaTemplate.send(topicName, fundTransferVo);
        log.info("Published fund transfer event successfully - {}", fundTransferVo.toString());
        return savedObj != null ? true : false;
    }

    @KafkaListener(topics = {"fund-transfers"}, groupId = "fund-transfers-group")
    public boolean processFundTransfer(FundTransferVo fundTransferVo) {
        log.info("Received Fund Transfer Event. {}", fundTransferVo);
        // TODO: Process the request
        return true;
    }

    @Override
    public Optional<FundTransferVo> getFundTransfer(int id) throws FundTransferException {
        return fundTransferRepo.findById(id);
    }

    @Override
    public Collection<FundTransferVo> getAllFundTransfers() throws FundTransferException {
        return fundTransferRepo.findAll();
    }
}
