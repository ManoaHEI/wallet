package Controller;

import com.hei.wallet.models.entities.Currency;
import com.hei.wallet.services.CurrencyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController() {
        this.currencyService = new CurrencyService();
    }

    @GetMapping
    public List<Currency> getAllCurrencies() {
        return currencyService.findAll();
    }

    @GetMapping("/{id}")
    public List<Currency> getCurrencyById(@PathVariable int id) {
        return currencyService.findById(id);
    }

    @PostMapping("/create")
    public List<Currency> createCurrencies(@RequestBody List<Currency> currencies) {
        return currencyService.saveAll(currencies);
    }

    @PostMapping("/createSingle")
    public Currency createCurrency(@RequestBody Currency currency) {
        return currencyService.save(currency);
    }

    @PutMapping("/{id}")
    public Currency updateCurrency(@PathVariable int id, @RequestBody Currency currency) {
        return currencyService.update(id, currency);
    }

    @DeleteMapping("/{id}")
    public String deleteCurrencyById(@PathVariable int id) {
        return currencyService.deleteById(id);
    }

    @GetMapping("/byName/{name}")
    public Currency getCurrencyByName(@PathVariable String name) {
        return currencyService.findCurrencyByName(name);
    }

    @DeleteMapping("/byName/{name}")
    public Currency deleteCurrencyByName(@PathVariable String name) {
        return currencyService.deleteCurrencyByName(name);
    }

    @GetMapping("/byValue/{value}")
    public List<Currency> getCurrenciesByValue(@PathVariable float value) {
        return currencyService.findAll();
    }
}
