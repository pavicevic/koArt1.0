package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.CartEntity;

public interface CartEntityRepository extends JpaRepository<CartEntity,Integer> {
}
