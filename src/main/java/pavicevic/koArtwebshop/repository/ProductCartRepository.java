package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pavicevic.koArtwebshop.entity.ProductCart;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart,Integer> {

}
