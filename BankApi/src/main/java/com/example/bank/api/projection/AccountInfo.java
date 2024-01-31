package com.example.bank.api.projection;

import com.example.bank.api.model.Account;

import java.math.BigDecimal;

/**
 * Projection for {@link Account}
 */


public interface AccountInfo {
    BigDecimal getBalance();
}