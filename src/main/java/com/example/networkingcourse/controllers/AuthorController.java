package com.example.networkingcourse.controllers;

import com.example.networkingcourse.model.Author;
import com.example.networkingcourse.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/authors")
public class AuthorController
{
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> saveAuthor(@RequestBody Author author)
    {
        authorService.save(author);
        return ResponseEntity.ok().build();
    }
}
