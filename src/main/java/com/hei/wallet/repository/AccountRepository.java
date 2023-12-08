package com.hei.wallet.repository;

import com.hei.wallet.models.entities.Account;
import com.hei.wallet.models.entities.Currency;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository {

    List<Account> findByBalance(BigDecimal balance);

    List<Account> findByCurrencyId(Currency currency);

    List<Account> findById(int idReceiver);

    List<Account> findByCurrencyId(int currencyId);

}