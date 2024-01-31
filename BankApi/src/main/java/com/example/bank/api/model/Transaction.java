package com.example.bank.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
//@Entity
//@Table(name="TransactionProcessor")
@Getter
@Setter
public class Transaction {




//    @Column(name = "id", nullable = false)
    private Long id;

    private BigDecimal amount;
    private Long sourceAccountId;

    private Long targetAccountId;

//    @CreationTimestamp
    private Timestamp createdAt;


}
