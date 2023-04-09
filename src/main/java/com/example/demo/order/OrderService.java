package com.example.demo.order;

import com.example.demo.order.dto.OrderResponse;
import com.example.demo.order.dto.OrderSaveRequest;

public interface OrderService {
    OrderResponse save(OrderSaveRequest request);

    OrderResponse findById(String id);
}
