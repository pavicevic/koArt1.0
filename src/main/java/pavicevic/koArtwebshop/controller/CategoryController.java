package pavicevic.koArtwebshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pavicevic.koArtwebshop.dto.CategoryDTO;
import pavicevic.koArtwebshop.entity.Category;
import pavicevic.koArtwebshop.entity.User;
import pavicevic.koArtwebshop.repository.CategoryRepository;
import pavicevic.koArtwebshop.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping(value = "api/category/add")
    public ResponseEntity<Void> createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.addCategory(categoryDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "api/category")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @PutMapping(value = "api/category/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        if (category.getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Category updateCategory = categoryService.updateCategory(category);

        return new ResponseEntity<>(updateCategory, HttpStatus.OK);
    }

    @DeleteMapping(value = "api/category/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}