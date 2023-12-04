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

    private int id_transaction;

    private TransactionTypes type;

    private float amount;

    private Account receiver;

    private Currency receiver_currency;

    private Account sender;

    private Currency sender_currency;

}