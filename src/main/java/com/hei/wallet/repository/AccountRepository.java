package com.hei.wallet.repository;

import com.hei.wallet.models.Account;

import java.util.List;

public interface AccountRepository {

    Account findByBalance(float balance);

    Account findByCurrencyId(int id);

    Account findByCurrencyName(String name);

    List<Account> findById(int idReceiver);
}