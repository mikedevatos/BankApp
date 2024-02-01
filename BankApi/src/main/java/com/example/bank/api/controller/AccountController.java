package com.example.bank.api.controller;

import com.example.bank.api.dto.TransactionDto;
import com.example.bank.api.dto.TransactionResponse;
import com.example.bank.api.exception.AccountNotFoundException;
import com.example.bank.api.exception.InsufficientFundsException;
import com.example.bank.api.exception.SameAccountException;
import com.example.bank.api.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/account")
@Slf4j
public class AccountController {

    @Autowired
    AccountService acoountService;

    @PostMapping()
    public ResponseEntity<?> transferFunds(@RequestBody TransactionDto transactionDto) {

        try {
            acoountService.transferFunds(transactionDto.getSourceAccountId(),
                    transactionDto.getTargetAccountId(),
                    transactionDto.getAmount(), transactionDto.getCurrency());
        } catch (InsufficientFundsException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (AccountNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (SameAccountException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

           TransactionResponse transactionRes = new TransactionResponse();
        transactionRes.setSourceAccountBalance(acoountService.getAcoountBalanceById(transactionDto.getSourceAccountId()).getBalance());

        TransactionResponse transactionResponse = TransactionResponse.builder().id(transactionDto.getId())
                .targetAccountId(transactionDto.getTargetAccountId())
                .sourceAccountId(transactionDto.getSourceAccountId())
                .amount(transactionDto.getAmount())
                .currency(transactionDto.getCurrency())
                .sourceAccountBalance(acoountService.getAcoountBalanceById(transactionDto.getSourceAccountId()).getBalance()).build();


        return new ResponseEntity<>(transactionResponse, HttpStatus.OK);

    }


}
