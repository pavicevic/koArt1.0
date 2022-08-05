package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.ProductTagEntity;

public interface ProductTagEntityRepository extends JpaRepository<ProductTagEntity,Integer> {
}
