package com.hei.wallet.DAO;

import com.hei.wallet.database.DbConnection;
import com.hei.wallet.models.Account;
import com.hei.wallet.models.Transaction;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class AccountDAO {

    private final Connection connection;
    private TransactionDAO transactionDAO;

    public AccountDAO() {
        this.connection = DbConnection.getConnection();
    }

    public List<Account> findAll() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM account";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getLong("id"));
                account.setName(resultSet.getString("name"));
                account.setBalanceAmount(resultSet.getBigDecimal("balance_amount"));
                account.setBalanceLastUpdate(new Date(resultSet.getTimestamp("balance_last_update").getTime()));
                accounts.add(account);
            }
        }
        return accounts;
    }

    public List<Account> saveAll(List<Account> accounts) throws SQLException {
        List<Account> savedAccounts = new ArrayList<>();
        String sql = "INSERT INTO account (name, balance_amount, balance_last_update, currency_id, type) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            for (Account account : accounts) {
                statement.setString(1, account.getName());
                statement.setBigDecimal(2, account.getBalanceAmount());
                statement.setTimestamp(3, new Timestamp(account.getBalanceLastUpdate().getTime()));
                statement.setLong(4, account.getCurrency().getId());
                statement.setString(5, account.getType());

                int affectedRows = statement.executeUpdate();
                if (affectedRows > 0) {
                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            account.setId(generatedKeys.getLong(1));
                            savedAccounts.add(account);
                        }
                    }
                }
            }
        }

        return savedAccounts;
    }

    public Account save(Account account) throws SQLException {
        String sql = "INSERT INTO account (name, balance_amount, balance_last_update, currency_id, type) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, account.getName());
            statement.setBigDecimal(2, account.getBalanceAmount());
            statement.setTimestamp(3, new Timestamp(account.getBalanceLastUpdate().getTime()));
            statement.setLong(4, account.getCurrency().getId());
            statement.setString(5, account.getType());

            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        account.setId(generatedKeys.getLong(1));
                        return account;
                    }
                }
            }
        }

        return null;
    }

    public boolean update(Account account) throws SQLException {
        String sql = "UPDATE account SET name = ?, balance_amount = ?, balance_last_update = ?, currency_id = ?, type = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, account.getName());
            statement.setBigDecimal(2, account.getBalanceAmount());
            statement.setTimestamp(3, new Timestamp(account.getBalanceLastUpdate().getTime()));
            statement.setLong(4, account.getCurrency().getId());
            statement.setString(5, account.getType());
            statement.setLong(6, account.getId());

            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        }
    }

    public Account findById(Long id) {
        return null;
    }


}

