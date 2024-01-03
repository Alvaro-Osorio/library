package com.app.ao.Service;

import com.app.ao.Entities.Editorial;

import java.util.List;
import java.util.Optional;

public interface IEditorialService {

    Optional<Editorial> findById(Long id);

    List<Editorial> findAll();

    void save(Editorial editorial);

    void deleteById(Long id);
}
