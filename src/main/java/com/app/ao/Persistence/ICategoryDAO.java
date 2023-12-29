package com.app.ao.Persistence;

import com.app.ao.Entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryDAO {

    Optional<Category> findById(Long id);

    List<Category> findAll();

    void save(Category category);

    void deleteById(Long id);
}
