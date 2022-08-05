package pavicevic.koArtwebshop.service;

import pavicevic.koArtwebshop.entity.ProductEntity;
import pavicevic.koArtwebshop.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();

    UserEntity findById(Integer id);
}
