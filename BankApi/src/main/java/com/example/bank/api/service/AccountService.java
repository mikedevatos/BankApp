package com.example.bank.api.service;

import com.example.bank.api.exception.AccountNotFoundException;
import com.example.bank.api.exception.InsufficientFundsException;
import com.example.bank.api.exception.SameAccountException;
import com.example.bank.api.model.Transaction;
import com.example.bank.api.projection.AccountInfo;
import com.example.bank.api.repo.AccountRepo;
import com.example.bank.api.model.Account;
import com.example.bank.api.repo.TransactionRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AccountService {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    TransactionRepo transactionRepo;

    public Account getAccountById(Long id) {
        return accountRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Account with ID " + id + " not found"));
    }


    public AccountInfo getAcoountBalanceById(Long id) {
        return accountRepo.getAccountBalanceById(id).orElseThrow(() -> new NoSuchElementException("Account with ID " + id + " not found"));
    }

    private boolean accountExist(Long accountId) {
        return accountRepo.existsById(accountId);
    }


    @Transactional
    public void transferFunds(Long sourceAccountId, Long targetAccountId, BigDecimal amount,String currency) {
        if (accountExist(sourceAccountId) && accountExist(targetAccountId)) {


            Account sourceAccount = getAccountById(sourceAccountId);
            Account targetAccount = getAccountById(targetAccountId);
            //  Case AC
            if (sourceAccount.getBalance().compareTo(amount) >= 0 && sourceAccount != targetAccount) {
                targetAccount.setBalance(targetAccount.getBalance().subtract(amount));
                sourceAccount.setBalance(sourceAccount.getBalance().add(amount));
//                accountRepo.save(sourceAccount);
//                accountRepo.save(targetAccount);
                Transaction transaction = Transaction.builder().targetAccount(targetAccount)
                                                                .sourceAccount(sourceAccount)
                                                     .amount(amount).currency(currency).build();
               transactionRepo.save(transaction);

            } else {
                // AC3
                if (sourceAccount == targetAccount) {
                    throw new SameAccountException("Operation between same account not permitted");
                }  // AC2
                else if (sourceAccount.getBalance().compareTo(amount) <= 0) {
                    throw new InsufficientFundsException("You balance is not sufficient to make this transfer");
                }

            }


        } else {
            throw new AccountNotFoundException("Account not found");

        }
    }

}
