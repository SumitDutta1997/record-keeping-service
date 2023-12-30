package com.jar.kiranatransaction.repository;

import com.jar.kiranatransaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByTransactionDate(LocalDate date);
}
