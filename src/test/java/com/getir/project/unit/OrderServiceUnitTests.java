package com.getir.project.unit;

import com.getir.project.book.Book;
import com.getir.project.book.BookService;
import com.getir.project.book.dto.BookResponse;
import com.getir.project.common.enums.OrderStatus;
import com.getir.project.customer.Customer;
import com.getir.project.order.Order;
import com.getir.project.order.OrderRepository;
import com.getir.project.order.OrderServiceImpl;
import com.getir.project.order.dto.OrderSaveRequest;
import com.getir.project.orderitem.OrderItem;
import com.getir.project.orderitem.OrderItemRepository;
import com.getir.project.security.SecurityUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OrderServiceUnitTests {

    @InjectMocks
    private OrderServiceImpl orderService;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private BookService bookService;
    @Mock
    private OrderItemRepository orderItemRepository;
    @Mock
    private SecurityUtil securityUtil;
    private Order order;
    private OrderSaveRequest orderSaveRequest;
    private Customer customer;
    private BookResponse bookResponse;

    private List<OrderItem> orderItems;

    @BeforeEach
    void setUp() {

        var book = Book.builder()
                .name("Book")
                .stock(10L)
                .price(100D)
                .build();
        book.setId("Id");

        orderItems = Collections.singletonList(OrderItem.builder()
                .amount(100L)
                .book(book)
                .build());

        order = Order.builder()
                .orderStatus(OrderStatus.COMPLETED)
                .orderItems(orderItems)
                .orderDate(new Date(System.currentTimeMillis()))
                .totalCost(500d)
                .customer(null)
                .build();

        customer = new Customer();
        customer.setName("Test customer service");
        customer.setEmail("test@test.com");

        orderSaveRequest = OrderSaveRequest.builder()
                .totalCost(500d)
                .orderItems(Collections.singletonList(OrderItem.builder()
                        .amount(100L)
                        .book(book)
                        .build()))
                .build();

        bookResponse = BookResponse.builder()
                .name("book name")
                .stock(10L)
                .price(10d)
                .build();
    }

    @Test
    void orderSave_Success_Test() {

        given(orderRepository.save(any(Order.class))).willReturn(order);
        given(orderItemRepository.saveAll(any())).willReturn(orderItems);
        given(securityUtil.getCurrentUser()).willReturn(customer);
        given(bookService.decreaseStockWithAmount(any(String.class), any(Long.class))).willReturn(bookResponse);

        var response = orderService.save(orderSaveRequest);

        assertEquals(order.getTotalCost(), response.getTotalCost().doubleValue());
    }
}
