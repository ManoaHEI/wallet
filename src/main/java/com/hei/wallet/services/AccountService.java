package com.hei.wallet.services;

import com.hei.wallet.database.DbConnection;
import com.hei.wallet.models.Account;
import com.hei.wallet.models.Currency;
import com.hei.wallet.repository.AccountRepository;
import com.hei.wallet.repository.CrudOperation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountService implements CrudOperation<Account>, AccountRepository {

    private Account mapAccount(ResultSet resultSet) throws SQLException {
        return new Account(
                resultSet.getInt("id_account"),
                resultSet.getFloat("balance"),
                (Currency) resultSet.getObject("currency")
        );
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();

        try {
            Connection connection = DbConnection.getConnection();
            String sql = "SELECT * FROM account;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                accounts.add(mapAccount(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    @Override
    public List<Account> findById(int id) {
        List<Account> accounts = new ArrayList<>();

        try {
            Connection connection = DbConnection.getConnection();
            String sql = "SELECT * FROM account WHERE id_account = " + id + ";";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                accounts.add(mapAccount(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) {
        return null;
    }

    @Override
    public Account save(Account toSave) {
        return null;
    }

    @Override
    public Account update(int id, Account toUpdate) {
        return null;
    }

    @Override
    public Account deleteById(int id) {
        return null;
    }

    @Override
    public Account findByBalance(float balance) {
        return null;
    }

    @Override
    public Account findByCurrencyId(int id) {
        return null;
    }

    @Override
    public Account findByCurrencyName(String name) {
        return null;
    }

}