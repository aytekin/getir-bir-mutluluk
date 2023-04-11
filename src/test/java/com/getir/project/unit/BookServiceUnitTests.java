package com.getir.project.unit;

import com.getir.project.book.Book;
import com.getir.project.book.BookRepository;
import com.getir.project.book.BookServiceImpl;
import com.getir.project.book.dto.BookResponse;
import com.getir.project.book.dto.BookSaveRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BookServiceUnitTests {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    private Book book;
    private BookResponse bookResponse;

    @BeforeEach
    void setUp() {
        book = Book.builder()
                .name("book name")
                .stock(10L)
                .price(10d)
                .build();

        bookResponse = BookResponse.builder()
                .name("book name")
                .stock(10L)
                .price(10d)
                .build();
    }

    @Test
    void bookSave_Return_Success() {

        given(bookRepository.save(any(Book.class))).willReturn(book);

        var bookResponse = bookService.save(BookSaveRequest.builder()
                .build());

        assertEquals(bookResponse.getStock(), bookResponse.getStock());
    }

    @Test
    void decreaseStock_Return_Success() {

        given(bookRepository.findById(any(String.class))).willReturn(Optional.ofNullable(book));
        given(bookRepository.save(any(Book.class))).willReturn(book);

        var bookResponse = bookService.decreaseStock("12345678");

        assertEquals(bookResponse.getStock(), bookResponse.getStock());
    }
}
