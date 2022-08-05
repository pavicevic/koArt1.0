package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.CategoryEntity;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity,Integer> {
}
