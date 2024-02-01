package com.bank.client.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
@Builder
@Getter
@Setter
public class Transaction implements Serializable {

    private Long id;
    private BigDecimal amount;
    private Long sourceAccountId;
    private Long targetAccountId;
    private String currency;

}
