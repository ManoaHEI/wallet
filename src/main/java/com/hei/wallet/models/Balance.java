package com.hei.wallet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Data
@AllArgsConstructor
public class Balance {
    private Date dateTime;
    private BigDecimal balanceEntry;

    public Balance() {

    }

    public void setBalance(BigDecimal currentBalance) {
    }

    public void setDateTime(LocalDateTime transactionDate) {
    }
}
