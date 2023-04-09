package com.example.demo.order;

import com.example.demo.book.Book;
import com.example.demo.common.entity.BaseEntityId;
import com.example.demo.common.enums.OrderStatus;
import com.example.demo.customer.Customer;
import com.example.demo.orderitem.OrderItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "t_order")
public class Order extends BaseEntityId {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @OneToMany
    private List<OrderItem> orderItems;

    @Column(name = "total_cost", nullable = false)
    private Double totalCost;

    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "estimated_delivery_time")
    private Date estimatedDeliveryDate;
}
