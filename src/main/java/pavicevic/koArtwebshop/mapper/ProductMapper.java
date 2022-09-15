package pavicevic.koArtwebshop.mapper;

import org.mapstruct.Mapper;
import pavicevic.koArtwebshop.dto.ProductDTO;

import pavicevic.koArtwebshop.entity.Product;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product convertToEntity(ProductDTO productDTO);

    ProductDTO convertToDTO(Product product);
}
