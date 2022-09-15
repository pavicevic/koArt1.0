package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview,Integer> {
}
