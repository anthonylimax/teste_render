package atividade_marcio_03.com.example.atividade_marcio_03.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import atividade_marcio_03.com.example.atividade_marcio_03.models.Category;
import atividade_marcio_03.com.example.atividade_marcio_03.services.CategoryService;

import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return category != null ? new ResponseEntity<>(category, HttpStatus.OK)
                                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Category category = categoryService.findById(id);
        if (category != null) {
            category.setName(categoryDetails.getName());
            categoryService.save(category);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/name")
    public ResponseEntity<Category> getCategoryByName(@RequestParam String name) {
        Category category = categoryService.findByName(name);
        return category != null ? new ResponseEntity<>(category, HttpStatus.OK)
                                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

