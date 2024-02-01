package com.example.bank.api.repo;

import com.example.bank.api.model.Account;
import com.example.bank.api.projection.AccountInfo;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo  extends JpaRepository<Account, Long> {


    Optional<AccountInfo> getAccountBalanceById(Long id);
    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Account> findById(Long id);
}
