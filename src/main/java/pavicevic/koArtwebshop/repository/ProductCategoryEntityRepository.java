package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.ProductCategoryEntity;

public interface ProductCategoryEntityRepository extends JpaRepository<ProductCategoryEntity,Integer> {
}
