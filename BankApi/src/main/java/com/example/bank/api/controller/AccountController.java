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
                        transactionDto.getAmount());
            } catch (InsufficientFundsException ex) {
                // Handle InsufficientFundsException
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
            } catch (AccountNotFoundException ex) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
            } catch (SameAccountException ex) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
            }




        TransactionResponse transactionResponse = TransactionResponse.builder().id(transactionDto.getId())
                .targetAccountId(transactionDto.getTargetAccountId())
                .sourceAccountId(transactionDto.getSourceAccountId())
                .amount(transactionDto.getAmount())
                .createdAt(transactionDto.getCreatedAt())
                .sourceAccountBalance(acoountService.getAcoountBalanceById(transactionDto.getSourceAccountId()).getBalance()).build();


//        log.debug("showing   customers page  "+page +"  and size  " + size);
        return new ResponseEntity<>(transactionResponse, HttpStatus.OK);

    }


}
