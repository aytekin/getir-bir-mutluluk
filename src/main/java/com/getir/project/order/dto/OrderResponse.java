package com.getir.project.order.dto;

import com.getir.project.common.enums.OrderStatus;
import com.getir.project.customer.dto.CustomerResponse;
import com.getir.project.orderitem.dto.OrderItemResponse;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderResponse {
    private CustomerResponse customer;

    private Date orderDate;

    private List<OrderItemResponse> orderItems;

    private Long totalCost;

    private OrderStatus orderStatus;

    private Date estimatedDeliveryDate;
}
