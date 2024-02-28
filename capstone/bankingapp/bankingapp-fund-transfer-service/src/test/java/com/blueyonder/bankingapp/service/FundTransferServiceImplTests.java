package com.blueyonder.bankingapp.service;

import com.blueyonder.bankingapp.exception.FundTransferException;
import com.blueyonder.bankingapp.model.FundTransferStatus;
import com.blueyonder.bankingapp.model.FundTransferVo;
import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka
//@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:7091", "port=7091" })
@Slf4j
public class FundTransferServiceImplTests {

    @Autowired
    FundTransferService fundTransferService;

    @Autowired
    KafkaTemplate<String, FundTransferVo> producer;

    @Test
    public void testFundTransfer() throws FundTransferException {
        log.info(fundTransferService.toString());
        FundTransferVo fundTransferVo = new FundTransferVo();
        fundTransferVo.setSourceAccountId(1);
        fundTransferVo.setTargetAccoundId(2);
        fundTransferVo.setAmount(1000.0);
        fundTransferVo.setDescription("Testing");

        boolean status = fundTransferService.fundTransfer(fundTransferVo);
        assertTrue(status);
    }

    @Test
    public void testProcessFundTransfer() throws FundTransferException {
        FundTransferVo fundTransferVo = new FundTransferVo();
        fundTransferVo.setSourceAccountId(1);
        fundTransferVo.setTargetAccoundId(2);
        fundTransferVo.setAmount(1000.0);
        fundTransferVo.setDescription("Testing");

//        producer.send("fund-transfers", fundTransferVo);

        boolean status = fundTransferService.processFundTransfer(fundTransferVo);
        assertFalse(status);

    }
}
