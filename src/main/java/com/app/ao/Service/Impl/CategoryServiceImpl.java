package com.app.ao.Service.Impl;

import com.app.ao.Entities.Category;
import com.app.ao.Persistence.ICategoryDAO;
import com.app.ao.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryDAO categoryDAO;

    @Override
    public Optional<Category> findById(Long id) {
        return categoryDAO.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public void save(Category category) {
        categoryDAO.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryDAO.deleteById(id);
    }
}
