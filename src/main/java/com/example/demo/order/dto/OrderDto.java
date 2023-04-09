package com.example.demo.order.dto;

import com.example.demo.common.enums.OrderStatus;
import com.example.demo.customer.Customer;
import com.example.demo.orderitem.OrderItem;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class OrderDto {

    private Customer customer;

    private Date orderDate;

    private List<OrderItem> orderItems;

    private Double totalCost;

    private OrderStatus orderStatus;

    private Date estimatedDeliveryDate;
}
