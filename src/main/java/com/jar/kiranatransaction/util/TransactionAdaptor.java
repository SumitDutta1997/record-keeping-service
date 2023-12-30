package com.jar.kiranatransaction.util;

import com.jar.kiranatransaction.dto.TransactionDto;
import com.jar.kiranatransaction.entity.Transaction;
import io.micrometer.common.util.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.Date;

@UtilityClass
public class TransactionAdaptor {

    public Transaction getTransactionEntity(TransactionDto transactionDto) {

        return Transaction.builder()
                .transactionDate(new Date())
                .transactionStatus(transactionDto.getTransactionStatus())
                .transactionType(transactionDto.getTransactionType())
                .currency(transactionDto.getCurrency())
                .customerId(transactionDto.getCustomerId())
                .amount(transactionDto.getAmount())
                .description(StringUtils.isNotEmpty(transactionDto.getDescription()) ? transactionDto.getDescription() : null)
                .build();
    }
}
