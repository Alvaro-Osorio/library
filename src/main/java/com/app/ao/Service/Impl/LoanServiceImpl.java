package com.app.ao.Service.Impl;

import com.app.ao.Entities.Loan;
import com.app.ao.Repository.LoanRepository;
import com.app.ao.Service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements ILoanService {
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
