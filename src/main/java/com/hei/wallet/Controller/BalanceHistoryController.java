package com.hei.wallet.Controller;

import com.hei.wallet.models.Balance;
import com.hei.wallet.services.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/balance-history")
public class BalanceHistoryController {

    private final AccountBalanceService accountBalanceService;

    @Autowired
    public BalanceHistoryController(AccountBalanceService accountBalanceService) {
        this.accountBalanceService = accountBalanceService;
    }

    @GetMapping("/balance/{accountId}")
    public BigDecimal getBalanceAtDateTime(@PathVariable Long accountId, @RequestParam Date dateTime) throws SQLException {
        return accountBalanceService.getBalanceAtDateTime(accountId, dateTime);
    }

    @GetMapping("/history/{accountId}")
    public List<Balance> getBalanceHistory(@PathVariable Long accountId, @RequestParam Date startDate, @RequestParam Date endDate) throws SQLException {
        return accountBalanceService.getBalanceHistory(accountId, startDate, endDate);
    }
}
