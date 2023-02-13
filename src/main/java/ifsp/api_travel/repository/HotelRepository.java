package ifsp.api_travel.repository;

import ifsp.api_travel.model.Hotel;
import ifsp.api_travel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Database repository interface responsible for handling operations provided for AppArsenal. */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    //  /** Exemplo de busca pelo campo username. */
    //  User findByUsername(String username);
    //
    //  /** Exemplo de query JPQL. */
    //  @Query("SELECT * FROM USER WHERE Username LIKE %?1")
    //  User findByUserBeginningWith(String username);
    //
    //  /** Exemplo de busca pelo campo username. */
    //  List<User> findByType(String type);
    //
    //  /** Exemplo de query JPQL. */
    //  @Query("SELECT * FROM USER WHERE Type LIKE %?1")
    //  User findByUserBeginningWithType(String type);

}
