package com.hei.wallet.repository;

import com.hei.wallet.models.entities.Transaction;

public interface TransactionRepository {

    Transaction findByTransactionType(TransactionTypes type);

    Transaction findByReceiverId(int id_receiver);

    Transaction findBySenderId(int id_sender);

}