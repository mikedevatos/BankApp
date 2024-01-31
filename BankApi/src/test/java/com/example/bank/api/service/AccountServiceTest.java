package com.example.bank.api.service;

import com.example.bank.api.model.Account;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountServiceTest {


    @Mock
    AccountService accountService;

    @Test
    public void testGetAccountByIdAndExpectSuccess() {

        LocalDateTime localTime1 = LocalDateTime.of(2024, Month.JANUARY, 31, 13, 2, 8, 792);

        Long accountId = 1L;
        Account mockAccount = new Account(accountId,
                                           new BigDecimal("100.00"),
                                   "EUR",
                                            localTime1);
        Mockito.when(accountService.getAccountById(accountId)).thenReturn(mockAccount);

        Account result = accountService.getAccountById(accountId);

        assertEquals(mockAccount, result);
    }



}
