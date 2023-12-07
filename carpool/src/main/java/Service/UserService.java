package Service;
import Repository.UserRepository;
import jakarta.transaction.Transactional;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }


    @Transactional
    public void deleteUser(String userID) {
        userRepository.deleteByUserID(userID);
    }

}
