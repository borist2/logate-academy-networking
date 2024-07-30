package com.example.networkingcourse.service;

import com.example.networkingcourse.model.Author;
import com.example.networkingcourse.model.Book;
import com.example.networkingcourse.repository.AuthorRepository;
import com.example.networkingcourse.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService
{
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Book save(Book book)
    {
        for (Author author : book.getAuthors())
        {
            authorRepository.save(author);
        }
        return bookRepository.save(book);
    }
}
