package com.app.ao.Service.Impl;

import com.app.ao.Entities.Author;
import com.app.ao.Persistence.IAuthorDAO;
import com.app.ao.Service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private IAuthorDAO authorDAO;

    @Override
    public Optional<Author> findById(Long id) {

        return authorDAO.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Override
    public void save(Author author) {

        authorDAO.save(author);
    }

    @Override
    public void deleteById(Long id) {
        authorDAO.deleteById(id);
    }
}
