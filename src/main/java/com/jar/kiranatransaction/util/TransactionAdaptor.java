package com.jar.kiranatransaction.util;

import com.jar.kiranatransaction.dto.CustomerTransactionDto;
import com.jar.kiranatransaction.dto.TransactionDto;
import com.jar.kiranatransaction.entity.Customer;
import com.jar.kiranatransaction.entity.Transaction;
import com.jar.kiranatransaction.enums.Currency;
import com.jar.kiranatransaction.enums.TransactionStatus;
import com.jar.kiranatransaction.enums.TransactionType;
import io.micrometer.common.util.StringUtils;
import lombok.experimental.UtilityClass;

import java.util.Date;

@UtilityClass
public class TransactionAdaptor {

    public Transaction getTransactionEntity(TransactionDto transactionDto) {

        return Transaction.builder()
                .transactionDate(DateUtil.convertToLocalDate(new Date()))
                .transactionStatus(transactionDto.getTransactionStatus())
                .transactionType(transactionDto.getTransactionType())
                .currency(transactionDto.getCurrency())
                .customerId(transactionDto.getCustomerId())
                .amount(transactionDto.getAmount())
                .description(StringUtils.isNotEmpty(transactionDto.getDescription()) ? transactionDto.getDescription() : null)
                .build();
    }

    public static CustomerTransactionDto getCustomerTransactionDto(Transaction transaction, Customer customer) {

        return CustomerTransactionDto.builder()
                .transactionId(transaction.getTransactionId())
                .amount(transaction.getAmount())
                .transactionStatus(transaction.getTransactionStatus())
                .currency(transaction.getCurrency())
                .transactionType(transaction.getTransactionType())
                .description(transaction.getDescription())
                .customerId(customer.getCustomerId())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .email(customer.getEmail())
                .build();
    }
}
