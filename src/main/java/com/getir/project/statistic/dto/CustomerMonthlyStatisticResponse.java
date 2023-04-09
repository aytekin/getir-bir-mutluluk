package com.getir.project.statistic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


public interface CustomerMonthlyStatisticResponse {
    String getMonth();

    Long getTotalBookCount();

    Long getTotalOrderCount();

    BigDecimal getTotalCost();
}
