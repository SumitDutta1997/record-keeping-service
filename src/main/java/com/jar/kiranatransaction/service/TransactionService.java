package com.jar.kiranatransaction.service;

import com.jar.kiranatransaction.dto.CustomerTransactionDto;
import com.jar.kiranatransaction.dto.TransactionDto;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {

    String recordTransaction(TransactionDto transactionRequestDto);

    List<CustomerTransactionDto> getListOfTransactions(LocalDate date);
}
