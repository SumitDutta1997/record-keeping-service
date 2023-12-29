package com.jar.kiranatransaction.entity;

import com.jar.kiranatransaction.enums.Currency;
import com.jar.kiranatransaction.enums.TransactionStatus;
import com.jar.kiranatransaction.enums.TransactionType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", unique = true, nullable = false)
    private Integer transactionId;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "transaction_status", nullable = false)
    private TransactionStatus transactionStatus;

    @Column(name = "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Column(name = "transaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "description")
    private String description;
}
