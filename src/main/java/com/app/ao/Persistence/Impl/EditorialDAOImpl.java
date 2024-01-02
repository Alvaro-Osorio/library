package com.app.ao.Persistence.Impl;

import com.app.ao.Entities.Editorial;
import com.app.ao.Persistence.IEditorialDAO;
import com.app.ao.Repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EditorialDAOImpl implements IEditorialDAO {

    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public Optional<Editorial> findById(Long id) {
        return editorialRepository.findById(id);
    }

    @Override
    public List<Editorial> findAll() {
        return (List<Editorial>) editorialRepository.findAll();
    }

    @Override
    public void save(Editorial editorial) {
        editorialRepository.save(editorial);
    }

    @Override
    public void deleteById(Long id) {
        editorialRepository.deleteById(id);
    }
}
