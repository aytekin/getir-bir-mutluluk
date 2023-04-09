package com.example.demo.book;

import com.example.demo.book.dto.BookResponse;
import com.example.demo.book.dto.BookSaveRequest;

public interface BookService {
    BookResponse save(BookSaveRequest request);

    BookResponse decreaseStock(String id);
    BookResponse decreaseStockWithAmount(String id, Long amount);
}
