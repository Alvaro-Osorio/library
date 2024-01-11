package com.app.ao.Controllers.DTO;

import com.app.ao.Entities.Book;
import com.app.ao.Entities.Partner;
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
    private String loanDate;
    private String returnDate;
    private Book book;
    private Partner partner;
}
