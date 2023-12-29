package com.jar.kiranatransaction.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransactionType {

    CREDIT("Credit"),
    DEBIT("Debit");

    private final String TransactionTypeValues;
}
