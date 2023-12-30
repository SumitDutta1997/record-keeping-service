package com.jar.kiranatransaction.dto;

import com.jar.kiranatransaction.enums.Currency;
import com.jar.kiranatransaction.enums.TransactionStatus;
import com.jar.kiranatransaction.enums.TransactionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    @NotBlank(message = "customerId is mandatory")
    private String customerId;

    @Min(value = 0, message = "amount must be positive")
    private Double amount;

    @NotNull(message = "TransactionStatus is mandatory")
    private TransactionStatus transactionStatus;

    @NotNull(message = "Currency is mandatory")
    private Currency currency;

    @NotNull(message = "TransactionType is mandatory")
    private TransactionType transactionType;

    private String description;
}
