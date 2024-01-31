package com.example.bank.api.repo;

import com.example.bank.api.model.Account;
import com.example.bank.api.projection.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo  extends JpaRepository<Account, Long> {



    Optional<AccountInfo> getAccountById(Long id);
    @Override
    Optional<Account> findById(Long id);
}
