package com.example.networkingcourse.repository;

import com.example.networkingcourse.model.Author;
import org.springframework.data.repository.Repository;

public interface AuthorRepository extends Repository<Author, Integer>
{

    Author save(Author author);
}
