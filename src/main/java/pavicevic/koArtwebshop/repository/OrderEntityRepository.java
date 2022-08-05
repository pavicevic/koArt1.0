package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity,Integer> {
}
