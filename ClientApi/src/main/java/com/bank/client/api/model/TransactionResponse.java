package com.bank.client.api.model;


import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse implements Serializable {

    private Long id;
    private BigDecimal amount;
    private Long sourceAccountId;
    private Long targetAccountId;
    private BigDecimal sourceAccountBalance;
    private Timestamp createdAt;


}
