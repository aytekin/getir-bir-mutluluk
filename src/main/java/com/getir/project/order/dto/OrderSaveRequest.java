package com.getir.project.order.dto;

import com.getir.project.orderitem.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSaveRequest {

    private List<OrderItem> orderItems;

    private Double totalCost;
}
