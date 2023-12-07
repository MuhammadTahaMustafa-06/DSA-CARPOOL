package Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import model.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Create/Update methods
    // User save(User entity); // No changes here

    // Read methods
    Optional<User> findById(String UserID);
    List<User> findAll();
    List<User> findAllById(Iterable<String> IDs);
    List<User> findAll(Sort sort);
    Page<User> findAll(Pageable pageable);
    User getOne(String ID);
    boolean existsById(String UserID);
    long count();
    //User delete
    void delete(User entity);
    void deleteAll();
    void deleteAllById(Iterable<? extends String> IDs);
    void deleteAll(Iterable<? extends User> entities);
    void deleteByUserID(String userID);
}
