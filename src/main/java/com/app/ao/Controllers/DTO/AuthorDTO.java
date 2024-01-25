package com.app.ao.Controllers.DTO;

import com.app.ao.Entities.Book;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class AuthorDTO {


    private Long id;

    @NotBlank
    @Size(min = 3, max = 15)
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private String nationality;

    private List<Book> books = new ArrayList<>();
}
