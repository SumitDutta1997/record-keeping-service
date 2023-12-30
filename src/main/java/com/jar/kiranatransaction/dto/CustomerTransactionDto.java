package com.jar.kiranatransaction.dto;

import com.jar.kiranatransaction.enums.Currency;
import com.jar.kiranatransaction.enums.TransactionStatus;
import com.jar.kiranatransaction.enums.TransactionType;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTransactionDto {

    private Integer transactionId;
    private Double amount;
    private TransactionStatus transactionStatus;
    private Currency currency;
    private TransactionType transactionType;
    private String description;
    private Integer customerId;
    private String name;
    private String phoneNumber;
    private String email;
}
