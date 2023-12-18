package com.hei.wallet.services;

import com.hei.wallet.DAO.AccountDAO;
import com.hei.wallet.DAO.TransactionDAO;
import com.hei.wallet.models.Account;
import com.hei.wallet.models.Balance;
import com.hei.wallet.models.Transaction;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class AccountBalanceService {
    private final AccountDAO accountDAO;
    private final TransactionDAO transactionDAO;

    public AccountBalanceService(AccountDAO accountDAO, TransactionDAO transactionDAO) {
        this.accountDAO = accountDAO;
        this.transactionDAO = transactionDAO;
    }

    public BigDecimal getBalanceAtDateTime(Long accountId, Date dateTime){
        Account account = accountDAO.findById(accountId);
        if (account == null) {
            return null;
        }

        List<Transaction> transactions = transactionDAO.getTransactionsUntilDateTime(accountId, dateTime);

        BigDecimal balance = account.getBalanceAmount();
        for (Transaction transaction : transactions) {
            balance = calculateUpdatedBalance(transaction, balance);
        }

        return balance;
    }

    public List<Balance> getBalanceHistory(Long accountId, Date startDate, Date endDate){
        Account account = accountDAO.findById(accountId);
        if (account == null) {
            return null;
        }

        List<Transaction> transactions = transactionDAO.getTransactionsInDateRange(accountId, startDate, endDate);

        BigDecimal currentBalance = account.getBalanceAmount();
        List<Balance> balanceHistory = new ArrayList<>();

        for (Transaction transaction : transactions) {
            currentBalance = calculateUpdatedBalance(transaction, currentBalance);
            Balance historyEntry = new Balance();
            historyEntry.setDateTime(transaction.getTransaction_date());
            historyEntry.setBalance(currentBalance);
            balanceHistory.add(historyEntry);
        }

        return balanceHistory;
    }

    private BigDecimal calculateUpdatedBalance(Transaction transaction, BigDecimal currentBalance) {
        if ("debit".equalsIgnoreCase(transaction.getTransaction_type())) {
            return currentBalance.subtract(transaction.getAmount());
        } else if ("credit".equalsIgnoreCase(transaction.getTransaction_type())) {
            return currentBalance.add(transaction.getAmount());
        } else {
            return currentBalance;
        }
    }
}
