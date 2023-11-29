package vn.edu.iuh.fit.week02.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week02.models.Customer;


import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager em;
    private EntityTransaction tr;
    public CustomerRepository()
    {
        em= Persistence.createEntityManagerFactory("week02")
                .createEntityManager();
        tr=em.getTransaction();
    }
    public boolean add(Customer customer)
    {
        tr=em.getTransaction();
        tr.begin();
        try {
            em.persist(customer);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean update(Customer customer)
    {
        tr=em.getTransaction();
        tr.begin();
        try {
            em.merge(customer);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean delete(long id)
    {
        tr=em.getTransaction();
        tr.begin();
        try
        {
            em.remove(id);
            tr.commit();
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            tr.rollback();
        }
        return  false;
    }
    public Optional<Customer> findById(long id) {
       Customer rs = em.find(Customer.class, id);
        return rs == null ? Optional.empty() : Optional.of(rs);
    }
    public List<Customer> getAll()
    {
        tr=em.getTransaction();
        tr.begin();
        try {
            return em.createQuery("select c from Customer c", Customer.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }

}
