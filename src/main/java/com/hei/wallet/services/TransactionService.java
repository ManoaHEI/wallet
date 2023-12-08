package com.hei.wallet.services;

import com.hei.wallet.database.DbConnection;
import com.hei.wallet.models.entities.Account;
import com.hei.wallet.models.entities.Currency;
import com.hei.wallet.models.entities.Transaction;
import com.hei.wallet.repository.AccountRepository;
import com.hei.wallet.repository.CurrencyRepository;
import com.hei.wallet.repository.TransactionRepository;
import com.hei.wallet.repository.CrudOperation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionService implements CrudOperation<Transaction>, TransactionRepository {

    private Transaction mapTransaction(ResultSet resultSet) throws SQLException {
        return new Transaction(
                resultSet.getInt("id_transaction"),
                TransactionTypes.valueOf(resultSet.getString("type")),
                resultSet.getBigDecimal("amount"),
                (Account) accountRepository.findById(resultSet.getInt("id_receiver")),
                (Currency) currencyRepository.findById(resultSet.getInt("id_receiver_currency")),
                (Account) accountRepository.findById(resultSet.getInt("id_sender")),
                (Currency) currencyRepository.findById(resultSet.getInt("id_sender_currency"))
        );
    }

    private final AccountRepository accountRepository;
    private final CurrencyRepository currencyRepository;

    public TransactionService(AccountRepository accountRepository, CurrencyRepository currencyRepository) {
        this.accountRepository = accountRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = new ArrayList<>();

        try {
            Connection connection = DbConnection.getConnection();
            String sql = "SELECT * FROM transaction;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                transactions.add(mapTransaction(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return transactions;
    }

    @Override
    public List<Transaction> findById(int id) {
        List<Transaction> transactions = new ArrayList<>();

        try {
            Connection connection = DbConnection.getConnection();
            String sql = "SELECT * FROM transaction WHERE id_transaction = " + id + ";";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                transactions.add(mapTransaction(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return transactions;
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> toSave) {
        return null;
    }

    @Override
    public Transaction save(Transaction toSave) {
        return null;
    }

    @Override
    public String deleteById(int id) {
        return null;
    }

    @Override
    public Transaction findByTransactionType(TransactionTypes type) {
        return null;
    }
    @Override
    public Transaction findByReceiverId(int id_receiver) {
        return null;
    }
    @Override
    public Transaction findBySenderId(int id_sender) {
        return null;
    }
}
