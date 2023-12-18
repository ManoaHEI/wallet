package com.hei.wallet.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Data
@AllArgsConstructor


public class BalanceHistory {
    private Long accountId;
    private List<Balance> entries;
}
