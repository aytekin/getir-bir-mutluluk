package com.example.demo.order.dto;

import com.example.demo.orderitem.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderSaveRequest {

    private List<OrderItem> orderItems;

    private Double totalCost;
}
