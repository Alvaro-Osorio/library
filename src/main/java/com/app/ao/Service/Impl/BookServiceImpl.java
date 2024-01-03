package com.app.ao.Service.Impl;

import com.app.ao.Entities.Book;
import com.app.ao.Persistence.IBookDAO;
import com.app.ao.Service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    private IBookDAO bookDAO;

    @Override
    public Optional<Book> findById(Long id) {
        return bookDAO.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public void save(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookDAO.deleteById(id);
    }
}
