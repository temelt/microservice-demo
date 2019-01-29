package com.temelt.account.api;

import com.temelt.account.entity.Account;
import com.temelt.account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by temelt on 28.01.2019.
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@RequestParam(name = "id") Long id) {
        Optional<Account> account = accountService.getById(id);
        return account.isPresent() ? ResponseEntity.ok(account.get()): ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Account account) {
        account = accountService.create(account);
        return ResponseEntity.ok(account);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Account> accounts = accountService.getAll();
        return ResponseEntity.ok(accounts);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Account account) {
        accountService.update(account);
        return ResponseEntity.ok(true);
    }
}
