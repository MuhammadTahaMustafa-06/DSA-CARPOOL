package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.User;

public class UserDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public UserDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void createUser(User user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
    }

    public User getUserById(String userId) {
        return entityManager.find(User.class, userId);
    }

    // Other methods for user-related operations

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
