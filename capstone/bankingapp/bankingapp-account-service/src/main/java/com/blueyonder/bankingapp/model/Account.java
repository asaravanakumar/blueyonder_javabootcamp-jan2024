package com.blueyonder.bankingapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Positive
    private double balance;
    @Positive
    private double roi;
    private boolean active;
    LocalDateTime createTimestamp;
    LocalDateTime updateTimestamp;
}
