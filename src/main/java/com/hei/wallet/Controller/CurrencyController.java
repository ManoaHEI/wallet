package com.hei.wallet.Controller;
import com.hei.wallet.DAO.CurrencyDAO;
import com.hei.wallet.models.Currency;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    private final CurrencyDAO currencyDAO;

    public CurrencyController(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    @GetMapping
    public List<Currency> getAllCurrencies() throws SQLException {
        return currencyDAO.findAll();
    }

    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Long id) throws SQLException {
        return currencyDAO.findById(id);
    }

    @PostMapping("/saveAll")
    public java.util.Currency saveAllCurrencies(@RequestBody List<Currency> currencies) throws SQLException {
        return currencyDAO.saveAll(currencies);
    }

    @PostMapping("/save")
    public Currency saveCurrency(@RequestBody Currency currency) throws SQLException {
        return currencyDAO.save(currency);
    }

    @PutMapping("/update")
    public boolean updateCurrency(@RequestBody Currency currency) throws SQLException {
        return currencyDAO.update(currency);
    }

}

