package com.example.demo.order.dto;

import com.example.demo.common.enums.OrderStatus;
import com.example.demo.customer.Customer;
import com.example.demo.orderitem.dto.OrderItemResponse;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderResponse {
    private Customer customer;

    private Date orderDate;

    private List<OrderItemResponse> orderItems;

    private Long totalCost;

    private OrderStatus orderStatus;

    private Date estimatedDeliveryDate;
}
