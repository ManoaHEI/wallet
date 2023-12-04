package com.hei.wallet.repository;

import com.hei.wallet.models.Transaction;
import com.hei.wallet.models.TransactionTypes;

public interface TransactionRepository {

    Transaction findByTransactionType(TransactionTypes type);

    Transaction findByReceiverId(int id_receiver);

    Transaction findBySenderId(int id_sender);

}