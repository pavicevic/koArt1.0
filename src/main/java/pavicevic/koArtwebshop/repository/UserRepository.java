package pavicevic.koArtwebshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pavicevic.koArtwebshop.entity.User;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByName(String name);

    @Query(value = "select * from user_table where id= :id",nativeQuery = true)
    User findUserByIdDTO(
    @Param("id") Integer id);


    Optional<User> findUserById(Integer id);
}