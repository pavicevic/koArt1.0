package pavicevic.koArtwebshop.mapper;

import org.mapstruct.Mapper;
import pavicevic.koArtwebshop.dto.UserDTO;
import pavicevic.koArtwebshop.entity.User;


@Mapper(componentModel = "spring")
public interface UserMapper{


    User convertToEntity(UserDTO userDTO);

    UserDTO convertToDTO(User user);


}


