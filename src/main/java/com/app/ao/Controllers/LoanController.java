package com.app.ao.Controllers;

import com.app.ao.Service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private ILoanService loanService;
}
