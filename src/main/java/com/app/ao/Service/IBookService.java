package com.app.ao.Service;

import com.app.ao.Entities.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    Optional<Book> findById(Long id);

    List<Book> findAll();

    void save(Book book);

    void deleteById(Long id);
}
