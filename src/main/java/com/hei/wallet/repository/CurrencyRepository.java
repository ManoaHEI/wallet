package com.hei.wallet.repository;

import com.hei.wallet.models.Currency;

public interface CurrencyRepository {

    Currency findCurrencyByName(String name);

    Currency deleteCurrencyByName(String name);

}