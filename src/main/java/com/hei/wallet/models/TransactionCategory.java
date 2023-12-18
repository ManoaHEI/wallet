package com.hei.wallet.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionCategory {
    private Long id;
    private String name;

    public TransactionCategory() {

    }
}
