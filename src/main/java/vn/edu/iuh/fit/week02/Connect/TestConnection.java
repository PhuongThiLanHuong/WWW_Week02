package vn.edu.iuh.fit.week02.Connect;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestConnection {
    public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("week02");
            EntityManager entityManager = emf.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            try {
                transaction.begin();
                System.out.print("Connected Successfully");
                transaction.commit();
            }
            catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }
            entityManager.close();
        }

}
