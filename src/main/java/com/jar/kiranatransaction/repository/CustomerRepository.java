package com.jar.kiranatransaction.repository;

import com.jar.kiranatransaction.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
