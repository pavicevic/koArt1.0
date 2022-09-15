package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pavicevic.koArtwebshop.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findByTitle(String title);
    Category findCategoryById(Integer id);
//    @Query("SELECT p FROM CategoryEntity p WHERE "+
//            "p.title LIKE CONCAT('%', :query, '%')")
//    Page<CategoryEntity> searchCategory(String query, Pageable pageable);
}
