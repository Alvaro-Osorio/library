package com.app.ao.Persistence.Impl;


import com.app.ao.Entities.Loan;
import com.app.ao.Persistence.ILoanDAO;
import com.app.ao.Repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LoanDAOImpl implements ILoanDAO {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Optional<Loan> findById(Long id) {
        return loanRepository.findById(id);
    }

    @Override
    public List<Loan> findAll() {
        return ((List<Loan>) loanRepository.findAll());
    }

    @Override
    public void save(Loan loan) {
        loanRepository.save(loan);
    }

    @Override
    public void deleteById(Long id) {
        loanRepository.deleteById(id);
    }
}
