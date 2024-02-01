package com.example.bank.api.dto;


import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;


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
    private String currency;


}
