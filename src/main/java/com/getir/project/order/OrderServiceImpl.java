package com.getir.project.order;

import com.getir.project.book.BookService;
import com.getir.project.common.enums.OrderStatus;
import com.getir.project.common.exception.EntityNotFound;
import com.getir.project.common.exception.GetirException;
import com.getir.project.common.utils.ObjectMappers;
import com.getir.project.customer.Customer;
import com.getir.project.order.dto.OrderDto;
import com.getir.project.order.dto.OrderResponse;
import com.getir.project.order.dto.OrderSaveRequest;
import com.getir.project.orderitem.OrderItemRepository;
import com.getir.project.security.SecurityUtil;
import com.getir.project.statistic.dto.CustomerMonthlyStatisticResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<OrderResponse> findAllByIdAndDateBetween(String id, Date startDate, Date endDate) {
        return orderRepository.findAllByIdAndCreatedDateBetween(id, startDate, endDate)
                .stream().map(order -> ObjectMappers.map(order, OrderResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<CustomerMonthlyStatisticResponse> customerMonthlyStatistics(String id) {
        return orderRepository.customerMonthlyStatistics(id);
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
