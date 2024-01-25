package com.app.ao.Controllers.DTO;

import com.app.ao.Entities.Book;
import jakarta.validation.constraints.NotBlank;
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
public class EditorialDTO {

    private Long id;

    @NotBlank
    @Size(min = 3 , max = 12)
    private String name;

    @NotBlank
    @Size(min = 3 , max = 50)
    private String address;

    private List<Book> books = new ArrayList<>();
}
