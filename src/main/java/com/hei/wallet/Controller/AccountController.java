package com.hei.wallet.Controller;

import com.hei.wallet.DAO.AccountDAO;
import com.hei.wallet.models.Account;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountDAO accountDAO;

    public AccountController(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @GetMapping
    public List<Account> getAllAccounts() throws SQLException {
        return accountDAO.findAll();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) throws SQLException {
        return accountDAO.findById(id);
    }

    @PostMapping("/saveAll")
    public List<Account> saveAllAccounts(@RequestBody List<Account> accounts) throws SQLException {
        return accountDAO.saveAll(accounts);
    }

    @PostMapping("/save")
    public Account saveAccount(@RequestBody Account account) throws SQLException {
        return accountDAO.save(account);
    }

    @PutMapping("/update")
    public boolean updateAccount(@RequestBody Account account) throws SQLException {
        return accountDAO.update(account);
    }

}
