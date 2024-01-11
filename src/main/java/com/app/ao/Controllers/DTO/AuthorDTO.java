package com.app.ao.Controllers.DTO;

import com.app.ao.Entities.Book;
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
public class AuthorDTO {

    private Long id;
    private String name;
    private String lastName;
    private String nationality;
    private List<Book> books = new ArrayList<>();
}
