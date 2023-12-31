package com.hei.wallet.repository;

import com.hei.wallet.models.Account;
import com.hei.wallet.models.Currency;

import java.util.List;

import java.util.List;

public interface AccountRepository {

    List<Account> findByBalance(float balance);

    List<Account> findByCurrencyId(Currency currency);

    List<Account> findById(int idReceiver);

    List<Account> findByCurrencyId(int currencyId);
}