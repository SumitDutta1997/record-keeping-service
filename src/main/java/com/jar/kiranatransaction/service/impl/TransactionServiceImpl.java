package com.jar.kiranatransaction.service.impl;

import com.jar.kiranatransaction.util.TransactionAdaptor;
import com.jar.kiranatransaction.dto.TransactionDto;
import com.jar.kiranatransaction.entity.Transaction;
import com.jar.kiranatransaction.repository.TransactionRepository;
import com.jar.kiranatransaction.service.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    @Transactional
    public String recordTransaction(TransactionDto transactionRequestDto) {

        Transaction transaction = TransactionAdaptor.getTransactionEntity(transactionRequestDto);
        transaction = transactionRepository.save(transaction);
        log.info("Transaction recorded successfully :: transaction: {}", transaction);
        return "Transaction recorded successfully";
    }
}
