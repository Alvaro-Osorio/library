package com.app.ao.Entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prestamo")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int partnerId;

    @Column
    private int bookId;

    @Column
    private String loanDate;

    @Column
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)
    private Book book;
}
