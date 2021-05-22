package com.elibrary.controller;

import com.elibrary.entity.Author;
import com.elibrary.service.AuthorService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id){
        return authorService.getAuthor(id);
    }

    @PostMapping
    public Author addAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }

    @PostMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author){
        author.setId(id);
        return authorService.updateAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }
}
