package com.hei.wallet.services;

import com.hei.wallet.database.DbConnection;
import com.hei.wallet.models.entities.Account;
import com.hei.wallet.models.entities.Currency;
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
                resultSet.getBigDecimal("balance"),
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
    public List<Account> findByCurrencyId(int currencyId) {
        return null;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) {
        StringBuilder sql = new StringBuilder("INSERT INTO account(balance, id_currency) VALUES(");
        for (int i = 0; i < toSave.size(); i++) {
            sql
                    .append(toSave.get(i).getBalance())
                    .append(",")
                    .append(toSave.get(i).getCurrency().getIdCurrency())
                    .append(")");
            if (i != toSave.size() - 1) {
                sql.append(",(");
            } else {
                sql.append(";");
            }
        }

        try {
            Connection connection = DbConnection.getConnection();

            Statement statement = connection.createStatement();
            statement.executeUpdate(String.valueOf(sql));

            System.out.println("All account has been saved.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return toSave;
    }

    @Override
    public Account save(Account toSave) {

        String sql = "INSERT INTO account(id_account, balance, id_currency) " +
                     "VALUES(" + toSave.getIdAccount() + "," + toSave.getBalance() + ", " + toSave.getCurrency().getIdCurrency() + ")" +
                     "ON CONFLICT (id_account)" +
                     "DO UPDATE SET balance = EXCLUDED.balance, id_currency = EXCLUDE.id_currency;";

        try {
            Connection connection = DbConnection.getConnection();

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

            System.out.println("Account successfully saved.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return toSave;
    }

    @Override
    public String deleteById(int id) {
        String sql = "IF EXISTS (SELECT * FROM account WHERE id_account = " + id + ") DELETE FROM account WHERE id_account = " + id + ";";

        try {
            Connection connection = DbConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Account with id: " + id + " as deleted successfully.";
    }

    @Override
    public List<Account> findByBalance(float balance) {
        List<Account> accounts = new ArrayList<>();

        try {
            Connection connection = DbConnection.getConnection();
            String sql = "SELECT * FROM account WHERE id_account = " + balance + ";";

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
    public List<Account> findByCurrencyId(Currency currency) {
        List<Account> accounts = new ArrayList<>();

        try {
            Connection connection = DbConnection.getConnection();
            String sql = "SELECT * FROM account WHERE id_account = " + currency.getIdCurrency() + ";";

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

}