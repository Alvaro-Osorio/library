package com.app.ao.Service;

import com.app.ao.Entities.Loan;

import java.util.List;
import java.util.Optional;

public interface ILoanService {
    Optional<Loan> findById(Long id);

    List<Loan> findAll();

    void save(Loan loan);

    void deleteById(Long id);
}
