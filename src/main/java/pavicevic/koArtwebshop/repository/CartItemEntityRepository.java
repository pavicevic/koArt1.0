package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.CartItemEntity;

public interface CartItemEntityRepository extends JpaRepository<CartItemEntity, Integer> {
}
