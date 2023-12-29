package com.jar.kiranatransaction.repository;

import com.jar.kiranatransaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
