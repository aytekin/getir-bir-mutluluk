package com.getir.project.book;

import com.getir.project.book.dto.BookResponse;
import com.getir.project.book.dto.BookSaveRequest;

public interface BookService {
    BookResponse save(BookSaveRequest request);

    BookResponse decreaseStock(String id);
    BookResponse decreaseStockWithAmount(String id, Long amount);
}
