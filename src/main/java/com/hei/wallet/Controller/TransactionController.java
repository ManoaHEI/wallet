package com.hei.wallet.Controller;
import com.hei.wallet.DAO.TransactionDAO;
import com.hei.wallet.models.Transaction;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionDAO transactionDAO;

    public TransactionController(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() throws SQLException {
        return transactionDAO.findAll();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) throws SQLException {
        return transactionDAO.findById(id);
    }

    @PostMapping("/saveAll")
    public List<Transaction> saveAllTransactions(@RequestBody List<Transaction> transactions) throws SQLException {
        return transactionDAO.saveAll(transactions);
    }

    @PostMapping("/save")
    public Transaction saveTransaction(@RequestBody Transaction transaction) throws SQLException {
        return transactionDAO.save(transaction);
    }

    @PutMapping("/update")
    public boolean updateTransaction(@RequestBody Transaction transaction) throws SQLException {
        return transactionDAO.update(transaction);
    }

    // Vous pouvez ajouter d'autres méthodes ou endpoints au besoin
}
