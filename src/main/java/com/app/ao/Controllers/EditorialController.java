package com.app.ao.Controllers;

import com.app.ao.Controllers.DTO.EditorialDTO;
import com.app.ao.Entities.Editorial;
import com.app.ao.Service.IEditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/editorial")
public class EditorialController {

    @Autowired
    private IEditorialService editorialService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Editorial> editorialOptional = editorialService.findById(id);

        if (editorialOptional.isPresent()){
            Editorial editorial = editorialOptional.get();

            EditorialDTO editorialDTO = EditorialDTO.builder()
                    .id(editorial.getId())
                    .name(editorial.getName())
                    .address(editorial.getAddress())
                    .books(editorial.getBooks())
                    .build();

            return ResponseEntity.ok(editorialDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<Editorial> editorials = editorialService.findAll();

        List<EditorialDTO> editorialsDTO = editorials.stream()
                .map(editorial -> EditorialDTO.builder()
                        .id(editorial.getId())
                        .name(editorial.getName())
                        .address(editorial.getAddress())
                        .build())
                .toList();

        return ResponseEntity.ok(editorialsDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EditorialDTO editorialDTO) throws URISyntaxException {

        if (editorialDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        if (editorialDTO.getAddress().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        editorialService.save(Editorial.builder()
                .name(editorialDTO.getName())
                .address(editorialDTO.getAddress())
                .build());

        return ResponseEntity.created(new URI("/api/editorial/save")).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EditorialDTO editorialDTO){
        Optional<Editorial> editorialOptional = editorialService.findById(id);

        if (editorialOptional.isPresent()){
            Editorial editorial = editorialOptional.get();
            editorial.setName(editorialDTO.getName());
            editorial.setAddress(editorialDTO.getAddress());
            editorialService.save(editorial);

            return ResponseEntity.ok("Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(id != null){
            editorialService.deleteById(id);

            return ResponseEntity.ok("Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
