package com.hei.wallet.models;

import lombok.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Account {
    private Long id;
    private String name;
    private BigDecimal balanceAmount;
    private List<Transaction> transactions;
    private Currency currency;
    private String type;

    public void setBalanceLastUpdate(Date balanceLastUpdate) {
    }

    public Date getBalanceLastUpdate() {
        return null;
    }
}
