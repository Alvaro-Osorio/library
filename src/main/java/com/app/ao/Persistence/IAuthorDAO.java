package com.app.ao.Persistence;

import com.app.ao.Entities.Author;

import java.util.List;
import java.util.Optional;

public interface IAuthorDAO {

    Optional<Author> findById(Long id);

    List<Author> findAll();

    void save(Author author);

    void deleteById(Long id);
}
