package com.hei.wallet.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import java.util.Date;


@Getter
@Data
@AllArgsConstructor
public class TransferHistory {
    private Long id;
    private Long debitTransactionId;
    private Long creditTransactionId;
    private Date transferDate;

}

