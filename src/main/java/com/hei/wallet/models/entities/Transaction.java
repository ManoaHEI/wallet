package com.hei.wallet.models.entities;

import com.hei.wallet.models.types.TransactionTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private int idTransaction;

    private String label;

    private BigDecimal amount;

    private LocalDateTime transactionDateTime;

    private TransactionTypes transactionType;

}