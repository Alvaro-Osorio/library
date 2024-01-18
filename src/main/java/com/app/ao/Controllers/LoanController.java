package com.app.ao.Controllers;

import com.app.ao.Controllers.DTO.LoanDTO;
import com.app.ao.Entities.Loan;
import com.app.ao.Service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private ILoanService loanService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Loan> loanOptional = loanService.findById(id);

        if (loanOptional.isPresent()){
            Loan loan = loanOptional.get();

            LoanDTO loanDTO = LoanDTO.builder()
                    .loanDate(loan.getLoanDate())
                    .returnDate(loan.getReturnDate())
                    .book(loan.getBook())
                    .partner(loan.getPartner())
                    .build();

            return ResponseEntity.ok(loanDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
       List<Loan> loanList = loanService.findAll();

       List<LoanDTO> loansDTO = loanList.stream()
               .map(loan -> LoanDTO.builder()
                       .loanDate(loan.getLoanDate())
                       .returnDate(loan.getReturnDate())
                       .book(loan.getBook())
                       .partner(loan.getPartner())
                       .build())
               .toList();

       return ResponseEntity.ok(loansDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody LoanDTO loanDTO) throws URISyntaxException {
        if (loanDTO.getLoanDate().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        if (loanDTO.getReturnDate().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        if (loanDTO.getBook().getId() < 1){
            return ResponseEntity.badRequest().build();
        }
        if (loanDTO.getPartner().getId()<1){
            return ResponseEntity.badRequest().build();
        }

        loanService.save(Loan.builder()
                .loanDate(loanDTO.getLoanDate())
                .returnDate(loanDTO.getReturnDate())
                .book(loanDTO.getBook())
                .partner(loanDTO.getPartner())
                .build());
        return ResponseEntity.created(new URI("/api/loan/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody LoanDTO loanDTO){
        Optional<Loan> loanOptional = loanService.findById(id);

        if (loanOptional.isPresent()){
            Loan loan = loanOptional.get();
            loan.setLoanDate(loanDTO.getLoanDate());
            loan.setReturnDate(loanDTO.getReturnDate());
            loanService.save(loan);
            return ResponseEntity.ok("Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if (id != null){
            loanService.deleteById(id);
            return ResponseEntity.ok("Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
