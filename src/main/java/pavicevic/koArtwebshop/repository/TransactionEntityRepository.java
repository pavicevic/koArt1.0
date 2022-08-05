package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.TransactionEntity;

public interface TransactionEntityRepository extends JpaRepository<TransactionEntity,Integer> {
}
