package pavicevic.koArtwebshop.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import pavicevic.koArtwebshop.dto.ProductCartDTO;
import pavicevic.koArtwebshop.entity.ProductCart;

@Component
@Mapper(componentModel = "spring")
public interface ProductCartMapper {

    ProductCart convertToEntity(ProductCartDTO productCartDTO);

    ProductCartDTO convertToDTO(ProductCart productCart);
}
