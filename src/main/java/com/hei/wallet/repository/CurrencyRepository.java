package com.hei.wallet.repository;

import com.hei.wallet.models.entities.Currency;

import java.util.List;

public interface CurrencyRepository {

    Currency findCurrencyByName(String name);

    Currency deleteCurrencyByName(String name);

    List<Currency> findById(int idReceiverCurrency);
}