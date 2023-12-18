package com.hei.wallet.services;

import com.hei.wallet.DAO.TransactionDAO;
import com.hei.wallet.models.Transaction;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TransactionService implements CrudOperation<Transaction> {

    private final TransactionDAO transactionDAO;

    public TransactionService() {
        this.transactionDAO = new TransactionDAO();
    }

    @Override
    public List<Transaction> findAll() throws SQLException {
        return transactionDAO.getAllTransactions();
    }

    @Override
    public Transaction findById(int id) {
        return null;
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> transactions){
        return null;
    }

    @Override
    public Transaction save(Transaction transaction){
        return null;
    }

    @Override
    public boolean update(Transaction transaction){
        return false;
    }
}

