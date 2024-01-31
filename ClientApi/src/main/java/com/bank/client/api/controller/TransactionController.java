package com.bank.client.api.controller;


import com.bank.client.api.model.Transaction;
import com.bank.client.api.model.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api/transaction")
public class TransactionController {
    @Autowired
    RestTemplate restTemplate;

    private final String apiUrl = "http://localhost:8082/api/account";


    @PostMapping
    public ResponseEntity<?> transferMoney(@RequestBody Transaction transaction) {
        ResponseEntity<TransactionResponse> responseEntity = null;
        HttpEntity<Transaction> request =
                new HttpEntity<Transaction>(transaction);
        try {
            responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, request, TransactionResponse.class);
        } catch (HttpClientErrorException ex) {
            // Handle 400 Bad Request (e.g., InsufficientFundsException)
            if (ex.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
                return ResponseEntity.badRequest().body(ex.getResponseBodyAsString());
            }
            if (ex.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                return ResponseEntity.badRequest().body(ex.getResponseBodyAsString());
            }
            String abc = "abc";
        }
        return responseEntity;

    }

}
