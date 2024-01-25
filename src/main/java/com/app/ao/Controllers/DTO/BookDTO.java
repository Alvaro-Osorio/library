package com.app.ao.Controllers.DTO;

import com.app.ao.Entities.Author;
import com.app.ao.Entities.Category;
import com.app.ao.Entities.Editorial;
import com.app.ao.Entities.Loan;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    private Long id;

    @NotBlank
    private String title;

    @Min(1)
    @Max(2000)
    private int pages;

    @Min(1)
    @Max(100)
    private int units;

    @Size(min = 10, max = 13, message = "La longitud del ISBN debe ser 10 - 13")
    private String isbn;

    private List<Loan> loanList = new ArrayList<>();

    private Author author;

    private Editorial editorial;

    private Category category;
}
