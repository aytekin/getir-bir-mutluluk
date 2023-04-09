package com.getir.project.order;

import com.getir.project.order.dto.OrderResponse;
import com.getir.project.order.dto.OrderSaveRequest;
import com.getir.project.statistic.dto.CustomerMonthlyStatisticResponse;

import java.util.Date;
import java.util.List;

public interface OrderService {
    OrderResponse save(OrderSaveRequest request);

    OrderResponse findById(String id);

    List<OrderResponse> findAllByIdAndDateBetween(String id, Date startDate, Date endDate);

    List<CustomerMonthlyStatisticResponse> customerMonthlyStatistics(String id);
}
