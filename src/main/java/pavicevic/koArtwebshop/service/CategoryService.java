package pavicevic.koArtwebshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pavicevic.koArtwebshop.dto.CategoryDTO;
import pavicevic.koArtwebshop.dto.UserDTO;
import pavicevic.koArtwebshop.entity.Cart;
import pavicevic.koArtwebshop.entity.Category;
import pavicevic.koArtwebshop.mapper.CategoryMapper;
import pavicevic.koArtwebshop.repository.CategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryDTO findCategoryByTitle(String title){
        Category category= categoryRepository.findByTitle(title);
        return categoryMapper.convertToDTO(category);
    }

    public void addCategory(CategoryDTO categoryDTO){
        Category category= categoryMapper.convertToEntity(categoryDTO);
        categoryRepository.save(category);

    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();

    }
    public Category updateCategory(Category category){
        return categoryRepository.save(category);
    }
    public void deleteCategory(Integer id){
        categoryRepository.deleteById(id);
    }

}
