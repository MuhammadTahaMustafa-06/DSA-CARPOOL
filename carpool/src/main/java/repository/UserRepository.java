package repository;

import model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    // Add custom queries if needed
//    boolean existsById(String id);
}
