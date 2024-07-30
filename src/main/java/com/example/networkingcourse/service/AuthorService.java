package com.example.networkingcourse.service;

import com.example.networkingcourse.model.Author;
import com.example.networkingcourse.model.Book;
import com.example.networkingcourse.repository.AuthorRepository;
import com.example.networkingcourse.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService
{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Transactional
    public Author save(Author author)
    {
        for (Book book : author.getBooks())
        {
            bookRepository.save(book);
        }

        return authorRepository.save(author);
    }
}
