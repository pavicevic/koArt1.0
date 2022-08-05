package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.OrderItemEntity;

public interface OrderItemEntityRepository extends JpaRepository<OrderItemEntity,Integer> {
}
