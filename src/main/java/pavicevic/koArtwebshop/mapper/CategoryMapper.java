package pavicevic.koArtwebshop.mapper;

import org.mapstruct.Mapper;
import pavicevic.koArtwebshop.dto.CategoryDTO;

import pavicevic.koArtwebshop.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category convertToEntity(CategoryDTO categoryDTO);

    CategoryDTO convertToDTO(Category category);
}
