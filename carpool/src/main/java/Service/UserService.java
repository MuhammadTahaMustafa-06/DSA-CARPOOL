package Service;

import model.User;

public interface UserService {

    User getUserById(String userId);

    User saveUser(User user);

    // Add other methods as needed
}