package com.example.networkingcourse.controllers;

import com.example.networkingcourse.model.Book;
import com.example.networkingcourse.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController
{
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody Book book)
    {
       bookService.save(book);

       return ResponseEntity.ok().build();
    }
}
