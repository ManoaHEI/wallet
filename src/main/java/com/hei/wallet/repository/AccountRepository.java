package com.hei.wallet.repository;

import com.hei.wallet.models.Account;

public interface AccountRepository {

    Account findByBalance(float balance);

    Account findByCurrencyId(int id);

    Account findByCurrencyName(String name);

}