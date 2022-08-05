package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity,Integer> {

}
