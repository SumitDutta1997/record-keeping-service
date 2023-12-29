package com.jar.kiranatransaction.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Currency {

    INR("INR"),
    USD("USD");

    private final String CurrencyValues;
}
