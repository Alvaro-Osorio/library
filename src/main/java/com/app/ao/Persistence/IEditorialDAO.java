package com.app.ao.Persistence;

import com.app.ao.Entities.Editorial;

import java.util.List;
import java.util.Optional;

public interface IEditorialDAO {

    Optional<Editorial> findById(Long id);

    List<Editorial> findAll();

    void save(Editorial editorial);

    void deleteById(Long id);
}
