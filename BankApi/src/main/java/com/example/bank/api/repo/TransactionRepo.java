package com.example.bank.api.repo;

import com.example.bank.api.model.Account;
import com.example.bank.api.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo   extends JpaRepository<Transaction, Long> {



}
