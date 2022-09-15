package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pavicevic.koArtwebshop.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    Cart findCartById(Integer id);

    Cart findCartByUserId(Integer userId);

    void deleteByUserId(Integer userId);
}
