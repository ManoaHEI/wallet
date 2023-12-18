package com.hei.wallet.services;
import com.hei.wallet.DAO.CurrencyDAO;
import org.springframework.stereotype.Service;
import java.util.Currency;
import java.util.List;

@Service
public class CurrencyService implements CrudOperation<Currency> {

    private final CurrencyDAO currencyDAO;

    public CurrencyService() {
        this.currencyDAO = new CurrencyDAO();
    }

    @Override
    public List<Currency> findAll(){
        return currencyDAO.getAllCurrencies();
    }

    @Override
    public Currency findById(int id){
        return null;
    }

    @Override
    public List<Currency> saveAll(List<Currency> currencies){
        return null;
    }

    @Override
    public Currency save(Currency currency){
        return null;
    }

    @Override
    public boolean update(Currency currency){
        return false;
    }
}

