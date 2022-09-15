package pavicevic.koArtwebshop.mapper;

import org.mapstruct.Mapper;
import pavicevic.koArtwebshop.dto.CartDTO;
import pavicevic.koArtwebshop.entity.Cart;

@Mapper(componentModel = "spring")
public interface CartMapper {
    Cart convertToEntity(CartDTO cartDTO);

    CartDTO convertToDTO(Cart cart);
}
