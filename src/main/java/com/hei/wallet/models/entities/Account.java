package com.hei.wallet.models.entities;

import com.hei.wallet.models.types.AccountName;
import com.hei.wallet.models.types.AccountTypes;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private int idAccount;

    private AccountName accountName;

    private BigDecimal balance;

    private LocalDateTime lastUpdateDateTime;

    private AccountTypes accountType;

    private int id_currency;

}