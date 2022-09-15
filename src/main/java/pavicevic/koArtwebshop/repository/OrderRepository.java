package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
