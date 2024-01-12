package com.app.ao.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="autor")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String nationality;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL, fetch = FetchType.LAZY , orphanRemoval = true)
    @JsonIgnore
    private List<Book> books = new ArrayList<>();
}
