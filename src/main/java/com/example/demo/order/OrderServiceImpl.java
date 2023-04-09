package com.example.demo.order;

import com.example.demo.book.BookService;
import com.example.demo.common.enums.OrderStatus;
import com.example.demo.common.exception.EntityNotFound;
import com.example.demo.common.exception.GetirException;
import com.example.demo.common.utils.ObjectMappers;
import com.example.demo.customer.Customer;
import com.example.demo.order.dto.OrderDto;
import com.example.demo.order.dto.OrderResponse;
import com.example.demo.order.dto.OrderSaveRequest;
import com.example.demo.orderitem.OrderItemRepository;
import com.example.demo.security.SecurityUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderItemRepository orderItemRepository;

    private final BookService bookService;
    private final SecurityUtil securityUtil;


    @Override
    @Transactional
    public OrderResponse save(OrderSaveRequest request) {
        Date orderDate = new Date();
        OrderDto orderDto = OrderDto.builder()
                .customer(getCustomer())
                .orderDate(orderDate)
                .estimatedDeliveryDate(addDayToDate(orderDate, 3))
                .orderItems(request.getOrderItems())
                .orderStatus(OrderStatus.PAYMENT_RECEIVED)
                .totalCost(request.getTotalCost())
                .build();

        // Save Order.
        Order order = orderRepository.save(ObjectMappers.map(orderDto, Order.class));

        request.getOrderItems().forEach(orderItem -> {
            orderItem.setOrder(order);
            //decrease stock
            bookService.decreaseStockWithAmount(orderItem.getBook().getId(), orderItem.getAmount());
        });

        // Save OrderItems
        orderItemRepository.saveAll(request.getOrderItems());

        return ObjectMappers.map(order, OrderResponse.class);
    }

    @Override
    public OrderResponse findById(String id) {
        Order order = orderRepository.findById(id).orElseThrow(EntityNotFound::new);
        return ObjectMappers.map(order, OrderResponse.class);
    }

    private Date addDayToDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, day);

        return calendar.getTime();
    }

    private Customer getCustomer() {
        Customer customer = securityUtil.getCurrentUser();

        if (ObjectUtils.isEmpty(customer)) {
            throw new GetirException("user not found");
        }

        return customer;
    }

}
