package com.elibrary.controller;

import com.elibrary.entity.Book;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("books")
@RestController
public class BookController {

    @GetMapping
    public List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book());
        return books;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return new Book();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return new Book();
    }

    @PostMapping("/{id}")
    public Book updateBook(@PathVariable Long id){
        return new Book();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){

    }

}
