package com.jar.kiranatransaction.repository;

import com.jar.kiranatransaction.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByCustomerIdIn(Set<Integer> customerIds);
}
