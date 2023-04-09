package com.getir.project.orderitem.dto;

import com.getir.project.book.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {
    private Book book;
    private Long amount;
}
