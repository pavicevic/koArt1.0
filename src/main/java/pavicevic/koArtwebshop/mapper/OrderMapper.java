package pavicevic.koArtwebshop.mapper;

import org.mapstruct.Mapper;
import pavicevic.koArtwebshop.dto.OrderDTO;
import pavicevic.koArtwebshop.entity.Order;


@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order convertToEntity(OrderDTO orderDTO);

    OrderDTO convertToDTO(Order order);
}
