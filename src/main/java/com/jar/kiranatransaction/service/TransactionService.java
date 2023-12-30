package com.jar.kiranatransaction.service;

import com.jar.kiranatransaction.dto.TransactionDto;

public interface TransactionService {

    String recordTransaction(TransactionDto transactionRequestDto);
}
