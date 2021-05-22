package com.elibrary.service;

import com.elibrary.dao.AuthorDao;
import com.elibrary.entity.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorDao authorDao;

    public AuthorService(AuthorDao authorDao){
        this.authorDao = authorDao;
    }

    public Author getAuthor(Long id){
        return authorDao.get(id);
    }

    public Author saveAuthor(Author author){
        return authorDao.save(author);
    }

    public Author updateAuthor(Author author){
        return authorDao.update(author);
    }

    public void deleteAuthor(Long id){
        authorDao.delete(id);
    }
}
