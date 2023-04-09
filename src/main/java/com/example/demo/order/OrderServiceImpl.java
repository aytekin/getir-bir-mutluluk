package com.example.demo.order;

import com.example.demo.common.exception.EntityNotFound;
import com.example.demo.common.utils.ObjectMappers;
import com.example.demo.order.dto.OrderResponse;
import com.example.demo.order.dto.OrderSaveRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public OrderResponse save(OrderSaveRequest request) {
        return null;
    }

    @Override
    public OrderResponse findById(String id) {
        Order order = orderRepository.findById(id).orElseThrow(EntityNotFound::new);
        return ObjectMappers.map(order, OrderResponse.class);
    }
}
