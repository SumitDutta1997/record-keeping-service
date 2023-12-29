package com.jar.kiranatransaction.dto;

import com.jar.kiranatransaction.enums.Currency;
import com.jar.kiranatransaction.enums.TransactionStatus;
import com.jar.kiranatransaction.enums.TransactionType;
import lombok.*;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private Integer transactionId;
    private String customerId;
    private Date transactionDate;
    private Double amount;
    private TransactionStatus transactionStatus;
    private Currency currency;
    private TransactionType transactionType;
    private String description;
}
