package com.app.ao.Controllers.DTO;

import com.app.ao.Entities.Book;
import com.app.ao.Entities.Partner;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanDTO {

    private Long id;

    @FutureOrPresent
    private String loanDate;

    @Future
    private String returnDate;

    private Book book;

    private Partner partner;
}
