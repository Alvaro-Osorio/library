package com.app.ao.Controllers.DTO;

import com.app.ao.Entities.Loan;
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
public class PartnerDTO {

    private Long id;

    @NotBlank
    @Size(min = 3, max = 15)
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 50)
    private String address;

    private List<Loan> loanList = new ArrayList<>();
}
