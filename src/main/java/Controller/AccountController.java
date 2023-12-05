package Controller;

import com.hei.wallet.models.Account;
import com.hei.wallet.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController() {
        this.accountService = new AccountService();
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public List<Account> getAccountById(@PathVariable int id) {
        return accountService.findById(id);
    }

    @PostMapping("/create")
    public List<Account> createAccounts(@RequestBody List<Account> accounts) {
        return accountService.saveAll(accounts);
    }

    @PostMapping("/createSingle")
    public Account createAccount(@RequestBody Account account) {
        return accountService.save(account);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable int id, @RequestBody Account account) {
        return accountService.update(id, account);
    }

    @DeleteMapping("/{id}")
    public String deleteAccountById(@PathVariable int id) {
        return accountService.deleteById(id);
    }

    @GetMapping("/byBalance/{balance}")
    public List<Account> getAccountsByBalance(@PathVariable float balance) {
        return accountService.findByBalance(balance);
    }

    @GetMapping("/byCurrencyId/{currencyId}")
    public List<Account> getAccountsByCurrencyId(@PathVariable int currencyId) {

        return accountService.findByCurrencyId(currencyId);
    }
}

