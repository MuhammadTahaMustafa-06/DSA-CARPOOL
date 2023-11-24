package Service;

import model.User;

public interface UserService {

    User getUserById(String userId);

    User createUser(User user);

//    boolean checkId(String id);
    // Add other methods as needed
}