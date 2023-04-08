package com.example.demo.book;

import com.example.demo.book.dto.BookResponse;
import com.example.demo.book.dto.BookSaveRequest;
import com.example.demo.common.exception.EntityNotFound;
import com.example.demo.common.exception.GetirException;
import com.example.demo.common.utils.ObjectMappers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookResponse save(@RequestBody @Valid BookSaveRequest request) {
        bookRepository.findByName(request.getName()).orElseThrow(() -> new GetirException("Book already exist with name " + request.getName()));
        return ObjectMappers.map(bookRepository.save(ObjectMappers.map(request, Book.class)), BookResponse.class);
    }


    @Override
    public BookResponse decreaseStock(@RequestParam String id) {
        Book book = bookRepository.findById(id).orElseThrow(EntityNotFound::new);
        book.setStock(book.getStock() - 1);
        return ObjectMappers.map(bookRepository.save(book), BookResponse.class);
    }
}
