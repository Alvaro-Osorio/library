package com.app.ao.Persistence.Impl;

import com.app.ao.Entities.Author;
import com.app.ao.Persistence.IAuthorDAO;
import com.app.ao.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorDAOImpl implements IAuthorDAO {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return ((List<Author>) authorRepository.findAll());
    }

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
