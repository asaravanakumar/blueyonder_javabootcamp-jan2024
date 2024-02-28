package com.blueyonder.bankingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FundTransferVo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    private int sourceAccountId;
    @NotNull
    private int targetAccoundId;
    @NotNull
    @Positive
    private double amount;
    private String description;
    @Enumerated(EnumType.STRING)
    private FundTransferStatus status;
}
