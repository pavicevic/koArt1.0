package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.ProductEntity;

public interface ProductEntityRepository extends JpaRepository<ProductEntity,Integer> {
}
