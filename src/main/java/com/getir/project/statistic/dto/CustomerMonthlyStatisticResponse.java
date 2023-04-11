package com.getir.project.statistic.dto;

import java.math.BigDecimal;


public interface CustomerMonthlyStatisticResponse {
    String getMonth();

    Long getTotalBookCount();

    Long getTotalOrderCount();

    BigDecimal getTotalCost();
}
