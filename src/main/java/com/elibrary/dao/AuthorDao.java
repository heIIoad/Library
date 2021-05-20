package com.elibrary.dao;

import com.elibrary.entity.Author;

public interface AuthorDao {
    Author get(Long id);
    Author save(Author author);
    Author update(Author author);
    void delete(Long id);
}
