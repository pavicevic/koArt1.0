package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.ProductReviewEntity;

public interface ProductReviewEntityRepository extends JpaRepository<ProductReviewEntity,Integer> {
}
