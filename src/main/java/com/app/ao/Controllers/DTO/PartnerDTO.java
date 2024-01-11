package com.app.ao.Controllers.DTO;

import com.app.ao.Entities.Loan;
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
    private String name;
    private String lastName;
    private String address;
    private List<Loan> loanList = new ArrayList<>();
}
