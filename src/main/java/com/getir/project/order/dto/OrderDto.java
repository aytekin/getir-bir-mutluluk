package com.getir.project.order.dto;

import com.getir.project.common.enums.OrderStatus;
import com.getir.project.customer.Customer;
import com.getir.project.orderitem.OrderItem;
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
