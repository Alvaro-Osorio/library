package com.app.ao.Persistence;

import com.app.ao.Entities.Book;

import java.util.List;
import java.util.Optional;

public interface IBookDAO {

    Optional<Book> findById(Long id);

    List<Book> findAll();

    void save(Book book);

    void deleteById(Long id);
}
