package com.app.ao.Controllers.DTO;

import com.app.ao.Entities.Author;
import com.app.ao.Entities.Category;
import com.app.ao.Entities.Editorial;
import com.app.ao.Entities.Loan;
import jakarta.persistence.*;
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
    private String title;
    private int pages;
    private int units;
    private String isbn;
    private List<Loan> loanList = new ArrayList<>();
    private Author author;
    private Editorial editorial;
    private Category category;
}
