package com.app.ao.Service.Impl;

import com.app.ao.Entities.Editorial;
import com.app.ao.Persistence.IEditorialDAO;
import com.app.ao.Service.IEditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialServiceImpl implements IEditorialService {
    @Autowired
    private IEditorialDAO editorialDAO;

    @Override
    public Optional<Editorial> findById(Long id) {
        return editorialDAO.findById(id);
    }

    @Override
    public List<Editorial> findAll() {
        return editorialDAO.findAll();
    }

    @Override
    public void save(Editorial editorial) {
        editorialDAO.save(editorial);
    }

    @Override
    public void deleteById(Long id) {
        editorialDAO.deleteById(id);
    }
}
