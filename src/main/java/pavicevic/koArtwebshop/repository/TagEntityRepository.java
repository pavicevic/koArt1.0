package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.TagEntity;

public interface TagEntityRepository extends JpaRepository<TagEntity,Integer> {
}
