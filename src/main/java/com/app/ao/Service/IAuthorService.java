package com.app.ao.Service;

import com.app.ao.Entities.Author;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {

    Optional<Author> findById(Long id);

    List<Author> findAll();

    void save(Author author);

    void deleteById(Long id);
}
