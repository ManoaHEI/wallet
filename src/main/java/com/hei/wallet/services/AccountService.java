package com.hei.wallet.services;

import com.hei.wallet.DAO.AccountDAO;
import com.hei.wallet.models.Account;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;

@Service
public class AccountService implements CrudOperation<Account> {

    private final AccountDAO accountDAO;

    public AccountService() {
        this.accountDAO = new AccountDAO();
    }

    @Override
    public List<Account> findAll() throws SQLException {
        return accountDAO.findAll();
    }

    @Override
    public Account findById(int id){
        return null;
    }

    @Override
    public List<Account> saveAll(List<Account> accounts) {
        try {
            return accountDAO.saveAll(accounts);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account save(Account account){
        try {
            return accountDAO.save(account);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Account account){
        try {
            return accountDAO.update(account);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

