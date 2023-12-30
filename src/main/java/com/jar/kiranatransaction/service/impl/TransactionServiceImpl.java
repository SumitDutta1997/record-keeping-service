package com.jar.kiranatransaction.service.impl;

import com.jar.kiranatransaction.dto.CustomerTransactionDto;
import com.jar.kiranatransaction.entity.Customer;
import com.jar.kiranatransaction.repository.CustomerRepository;
import com.jar.kiranatransaction.util.TransactionAdaptor;
import com.jar.kiranatransaction.dto.TransactionDto;
import com.jar.kiranatransaction.entity.Transaction;
import com.jar.kiranatransaction.repository.TransactionRepository;
import com.jar.kiranatransaction.service.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public String recordTransaction(TransactionDto transactionRequestDto) {

        Transaction transaction = TransactionAdaptor.getTransactionEntity(transactionRequestDto);
        transaction = transactionRepository.save(transaction);
        log.info("Transaction recorded successfully :: transaction: {}", transaction);
        return "Transaction recorded successfully";
    }

    @Override
    public List<CustomerTransactionDto> getListOfTransactions(LocalDate date) {

        List<CustomerTransactionDto> customerTransactionDtos = new ArrayList<>();

        List<Transaction> transactions = transactionRepository.findAllByTransactionDate(date);

        if (CollectionUtils.isEmpty(transactions)) {
            log.info("No transactions found with date: {}", date);
            return new ArrayList<>();
        }

        Set<Integer> customerIds = transactions.stream().map(Transaction::getCustomerId).collect(Collectors.toSet());

        Map<Integer, Customer> customerIdToCustomerEntityMap = customerRepository.findAllByCustomerIdIn(customerIds).stream().collect(Collectors.toMap(Customer::getCustomerId, Function.identity(), (o1, o2) -> o1));

        for (Transaction transaction : transactions) {
            CustomerTransactionDto customerTransactionDto = TransactionAdaptor.getCustomerTransactionDto(transaction,customerIdToCustomerEntityMap.get(transaction.getCustomerId()));
            customerTransactionDtos.add(customerTransactionDto);
        }

        return customerTransactionDtos;
    }
}
