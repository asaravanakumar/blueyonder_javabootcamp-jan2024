package com.blueyonder.bankingapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private int id;
    private double amount;
    private String description;
    private int accountId;
    private TransactionType type;
}
