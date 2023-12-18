package com.hei.wallet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
 public class Transaction {
        private Long id;
        private String label;
        private BigDecimal amount;
        private Date dateTime;
        private String type;
        private Long accountId;
        private TransactionCategory category;

    public void setTransactionDate(Date transactionDate) {
    }

    public LocalDateTime getTransaction_date() {
        return null;
    }

    public String getTransaction_type() {
        return null;
    }
}