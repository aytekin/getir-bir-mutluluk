package com.getir.project.orderitem;

import com.getir.project.book.Book;
import com.getir.project.common.entity.BaseEntityId;
import com.getir.project.order.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "t_order_item")
public class OrderItem extends BaseEntityId {

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private Long amount;

}
