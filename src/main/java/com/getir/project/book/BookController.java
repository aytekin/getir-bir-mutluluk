package com.getir.project.book;

import com.getir.project.book.dto.BookResponse;
import com.getir.project.book.dto.BookSaveRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/book/")
@AllArgsConstructor
public class BookController {

    private BookService bookService;

    @PostMapping("save")
    public BookResponse save(@RequestBody @Valid BookSaveRequest request) {
        return bookService.save(request);
    }

    @PatchMapping("decrease-stock")
    public BookResponse decreaseStock(@RequestParam String id) {
        return bookService.decreaseStock(id);
    }
}
