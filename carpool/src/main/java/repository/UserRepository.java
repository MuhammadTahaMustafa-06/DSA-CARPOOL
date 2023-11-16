package repository;

import com.yourpackage.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    // Add custom queries if needed
}
