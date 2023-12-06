package com.hei.wallet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private int idTransaction;

    private TransactionTypes type;

    private float amount;

    private Account receiver;

    private Currency receiverCurrency;

    private Account sender;

    private Currency senderCurrency;

}