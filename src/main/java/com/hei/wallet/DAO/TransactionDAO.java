package com.hei.wallet.DAO;

import com.hei.wallet.database.DbConnection;
import com.hei.wallet.models.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TransactionDAO {

    private final Connection connection;

    public TransactionDAO() {
        this.connection = DbConnection.getConnection();
    }

    public List<Transaction> getAllTransactions() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transaction";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getLong("id"));
                transaction.setLabel(resultSet.getString("label"));
                transaction.setAmount(resultSet.getBigDecimal("amount"));
                transaction.setTransactionDate(new Date(resultSet.getTimestamp("transaction_date").getTime()));
                transactions.add(transaction);
            }
        }

        return transactions;
    }


    public List<Transaction> findAll() {
        return null;
    }

    public Transaction findById(Long id) {
        return null;
    }

    public List<Transaction> saveAll(List<Transaction> transactions) {
        return transactions;
    }

    public Transaction save(Transaction transaction) {
        return transaction;
    }

    public boolean update(Transaction transaction) {
        return false;
    }

    public List<Transaction > getTransactionsUntilDateTime(Long accountId, Date dateTime) {
        return null;
    }

    public List<Transaction> getTransactionsInDateRange(Long accountId, Date startDate, Date endDate) {
        return null;
    }
}

