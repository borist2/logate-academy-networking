package com.example.networkingcourse.repository;

import com.example.networkingcourse.model.Book;
import org.springframework.data.repository.Repository;

public interface BookRepository extends Repository<Book, Integer>
{
    Book save(Book book);
}
