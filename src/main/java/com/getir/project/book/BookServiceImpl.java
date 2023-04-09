package com.getir.project.book;

import com.getir.project.book.dto.BookResponse;
import com.getir.project.book.dto.BookSaveRequest;
import com.getir.project.common.exception.EntityNotFound;
import com.getir.project.common.exception.GetirException;
import com.getir.project.common.utils.ObjectMappers;
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
        bookRepository.findByName(request.getName()).ifPresent(b -> {
            throw new GetirException("Book already exist with name " + request.getName());
        });
        return ObjectMappers.map(bookRepository.save(ObjectMappers.map(request, Book.class)), BookResponse.class);
    }


    @Override
    public BookResponse decreaseStock(@RequestParam String id) {
        return decreaseStockWithAmount(id, 1L);
    }

    @Override
    public BookResponse decreaseStockWithAmount(String id, Long amount) {
        Book book = bookRepository.findById(id).orElseThrow(EntityNotFound::new);
        if (book.getStock() - amount < 0) {
            throw new GetirException("Stock not enough");
        }
        book.setStock(book.getStock() - amount);
        return ObjectMappers.map(bookRepository.save(book), BookResponse.class);
    }
}
