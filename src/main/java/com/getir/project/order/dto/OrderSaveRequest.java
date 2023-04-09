package com.getir.project.order.dto;

import com.getir.project.orderitem.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderSaveRequest {

    private List<OrderItem> orderItems;

    private Double totalCost;
}
