package com.jar.kiranatransaction.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransactionStatus {

    INITIATED("INITIATED"),
    PENDING("PENDING"),
    SUCCESS("SUCCESS"),
    FAIL("FAIL"),
    ABORTED("ABORTED"),
    REFUNDED("REFUNDED"),
    CANCELLED("CANCELLED");

    private final String TransactionStatusValues;
}
