package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Rider;
import model.User;

public class RiderDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public RiderDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("your_persistence_unit_name");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void createRider(User user, Rider rider) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        rider.setUser(user);
        entityManager.persist(rider);
        transaction.commit();
    }

    // Other methods for rider-related operations

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
