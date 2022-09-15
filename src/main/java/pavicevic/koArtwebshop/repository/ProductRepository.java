package pavicevic.koArtwebshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pavicevic.koArtwebshop.dto.ProductDTO;
import pavicevic.koArtwebshop.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {



//    @Query(value = "select product from Product product")
//    Page<Product> findAllProductPageable(Pageable pageable);

//    Page<Product> searchProducts(String query, Pageable pageable);

    List<Product> findProductByTitleOrSummary(String title, String summary);

    Optional<Product> findProductById(Integer id);

//    List<Product>findByCategoryTitleContainingOrTitleContainingOrSummaryContaining(String ProductQuery);

    Product findProductByTitle(String title);
}
