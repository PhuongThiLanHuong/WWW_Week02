package vn.edu.iuh.fit.week02.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.logging.Logger;


public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private Logger LoggerFactory;
    private final Logger logger=LoggerFactory.getLogger(this.getClass().getName());
    public EmployeeRepository()
    {
        em= Persistence.createEntityManagerFactory("week02")
                .createEntityManager();
        transaction=em.getTransaction();
    }
}
