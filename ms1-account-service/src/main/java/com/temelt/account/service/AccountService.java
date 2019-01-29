package com.temelt.account.service;

import com.temelt.account.entity.Account;
import com.temelt.account.repo.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by temelt on 28.01.2019.
 */
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getById(Long id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Transactional
    public void update(Account account) {
        accountRepository.save(account);
    }
}