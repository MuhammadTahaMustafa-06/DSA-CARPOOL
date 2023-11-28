package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Driver;
import model.User;

public class DriverDAO {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public DriverDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pom.xml");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void createDriver(User user, Driver driver) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        driver.setUser(user);
        entityManager.persist(driver);
        transaction.commit();
    }

    // Other methods for driver-related operations

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
