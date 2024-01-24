package com.app.ao.Controllers;

import com.app.ao.Controllers.DTO.AuthorDTO;
import com.app.ao.Entities.Author;
import com.app.ao.Service.IAuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Author> authorOptional = authorService.findById(id);

        if (authorOptional.isPresent()){
            Author author = authorOptional.get();

            AuthorDTO authorDTO = AuthorDTO.builder()
                    .id(author.getId())
                    .name(author.getName())
                    .lastName(author.getLastName())
                    .nationality(author.getNationality())
                    .books(author.getBooks())
                    .build();

            return ResponseEntity.ok(authorDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<Author> authorList = authorService.findAll();

        List<AuthorDTO> authorsDTO = authorList.stream()
                .map(author -> AuthorDTO.builder()
                        .id(author.getId())
                        .name(author.getName())
                        .lastName(author.getLastName())
                        .nationality(author.getNationality())
                        .books(author.getBooks())
                        .build()
                ).toList();
        return ResponseEntity.ok(authorsDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid AuthorDTO authorDTO) throws URISyntaxException {

        authorService.save(Author.builder()
                .name(authorDTO.getName())
                .lastName(authorDTO.getLastName())
                .nationality(authorDTO.getNationality())
                .build());
        return ResponseEntity.created(new URI("/api/author/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody AuthorDTO authorDTO,@PathVariable Long id){

        Optional<Author> authorOptional = authorService.findById(id);

        if (authorOptional.isPresent()){

            Author author = authorOptional.get();
            author.setName(authorDTO.getName());
            author.setLastName(authorDTO.getLastName());
            author.setNationality(authorDTO.getNationality());
            authorService.save(author);

            return ResponseEntity.ok("Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id != null){
            authorService.deleteById(id);
            return ResponseEntity.ok("Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

}
