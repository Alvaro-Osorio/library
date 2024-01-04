package com.app.ao.Service.Impl;

import com.app.ao.Entities.Loan;
import com.app.ao.Persistence.ILoanDAO;
import com.app.ao.Service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements ILoanService {
    @Autowired
    private ILoanDAO loanDAO;

    @Override
    public Optional<Loan> findById(Long id) {
        return loanDAO.findById(id);
    }

    @Override
    public List<Loan> findAll() {
        return loanDAO.findAll();
    }

    @Override
    public void save(Loan loan) {
        loanDAO.save(loan);
    }

    @Override
    public void deleteById(Long id) {
        loanDAO.deleteById(id);
    }
}
