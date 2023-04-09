package com.example.demo.orderitem.dto;

import com.example.demo.book.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {
    private Book book;
    private Long amount;
}
