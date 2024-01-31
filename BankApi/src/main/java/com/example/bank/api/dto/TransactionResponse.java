package com.example.bank.api.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
public class TransactionResponse implements Serializable {

    private Long id;
    private BigDecimal amount;
    private Long sourceAccountId;
    private Long targetAccountId;
    private BigDecimal sourceAccountBalance;
    private Timestamp createdAt;


}
