package com.getir.project.common.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    REFUNDED("REFUNDED"),
    COMPLETED("COMPLETED"),
    CANCELED("CANCELED"),
    PAYMENT_RECEIVED("PAYMENT_RECEIVED");

    private String name;

    OrderStatus(String name) {
        this.name = name;
    }
}
