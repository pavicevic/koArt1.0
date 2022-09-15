package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pavicevic.koArtwebshop.entity.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media,Integer> {
}
