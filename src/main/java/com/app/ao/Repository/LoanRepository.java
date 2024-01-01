package com.app.ao.Repository;

import com.app.ao.Entities.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loan, Long> {
}
