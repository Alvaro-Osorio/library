package com.app.ao.Controllers;


import com.app.ao.Controllers.DTO.CategoryDTO;
import com.app.ao.Entities.Category;
import com.app.ao.Service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Category> categoryOptional = categoryService.findById(id);

        if (categoryOptional.isPresent()){
            Category category =categoryOptional.get();

            CategoryDTO categoryDTO = CategoryDTO.builder()
                            .id(category.getId())
                            .name(category.getName())
                            .books(category.getBooks())
                    .build();
            return ResponseEntity.ok(categoryDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<Category> categoryList = categoryService.findAll();

        List<CategoryDTO> categoryDTOS = categoryList.stream()
                .map(category -> CategoryDTO.builder()
                        .name(category.getName())
                        .books(category.getBooks())
                        .build()
                ).toList();
        return ResponseEntity.ok(categoryDTOS);
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CategoryDTO categoryDTO) throws URISyntaxException {

        if (categoryDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        categoryService.save(Category.builder()
                .name(categoryDTO.getName())
                .build());
        return ResponseEntity.created(new URI("/api/category/save")).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
        Optional<Category> categoryOptional = categoryService.findById(id);

        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            category.setName(categoryDTO.getName());

            return ResponseEntity.ok("Actualizado");
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (id != null) {
            categoryService.deleteById(id);

            return ResponseEntity.ok("Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
