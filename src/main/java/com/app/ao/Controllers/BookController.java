package com.app.ao.Controllers;

import com.app.ao.Controllers.DTO.BookDTO;
import com.app.ao.Entities.Book;
import com.app.ao.Service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Book> bookOptional = bookService.findById(id);

        if (bookOptional.isPresent()){
            Book book = bookOptional.get();

            BookDTO bookDTO = BookDTO.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .pages(book.getPages())
                    .units(book.getUnits())
                    .isbn(book.getIsbn())
                    .loanList(book.getLoanList())
                    .author(book.getAuthor())
                    .editorial(book.getEditorial())
                    .category(book.getCategory())
                    .build();

            return ResponseEntity.ok(bookDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<Book> books = bookService.findAll();

        List<BookDTO> booksDTO = books.stream()
                .map(book -> BookDTO.builder()
                        .title(book.getTitle())
                        .pages(book.getPages())
                        .units(book.getUnits())
                        .isbn(book.getIsbn())
                        .loanList(book.getLoanList())
                        .author(book.getAuthor())
                        .editorial(book.getEditorial())
                        .category(book.getCategory())
                        .build()
                ).toList();
        return ResponseEntity.ok(booksDTO);
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody BookDTO bookDTO) throws URISyntaxException {

        if (bookDTO.getTitle().isBlank()){return ResponseEntity.badRequest().build();}
        if (bookDTO.getPages()<1){return ResponseEntity.badRequest().build();}
        if (bookDTO.getUnits()<1){return ResponseEntity.badRequest().build();}
        if (bookDTO.getIsbn().isBlank()){return ResponseEntity.badRequest().build();}
        if (bookDTO.getAuthor() == null){return ResponseEntity.badRequest().build();}
        if (bookDTO.getEditorial() == null){return ResponseEntity.badRequest().build();}
        if (bookDTO.getCategory() == null){return ResponseEntity.badRequest().build();}

        bookService.save(Book.builder()
                        .title(bookDTO.getTitle())
                        .pages(bookDTO.getPages())
                        .units(bookDTO.getUnits())
                        .isbn(bookDTO.getIsbn())
                        .author(bookDTO.getAuthor())
                        .editorial(bookDTO.getEditorial())
                        .category(bookDTO.getCategory())
                        .build());
        return ResponseEntity.created(new URI("/api/book/save")).build();
    }

    public ResponseEntity<?> update(@PathVariable Long id , @RequestBody BookDTO bookDTO){
        Optional<Book> bookOptional =  bookService.findById(id);

        if (bookOptional.isPresent()){
            Book book = bookOptional.get();
            book.setTitle(bookDTO.getTitle());
            book.setPages(bookDTO.getPages());
            book.setUnits(bookDTO.getUnits());
            book.setIsbn(bookDTO.getIsbn());

            return ResponseEntity.ok("Actulizado");
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> delete(@PathVariable Long id){
        if (id != null){
            bookService.deleteById(id);
            return ResponseEntity.ok("Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
