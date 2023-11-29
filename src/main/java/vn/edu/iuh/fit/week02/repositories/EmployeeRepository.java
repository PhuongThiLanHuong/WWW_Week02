package vn.edu.iuh.fit.week02.repositories;

import jakarta.persistence.*;
import vn.edu.iuh.fit.week02.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02.models.Employee;

import java.util.List;
import java.util.Optional;


public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction tr;
    public EmployeeRepository()
    {
        em= Persistence.createEntityManagerFactory("week02")
                .createEntityManager();
        tr=em.getTransaction();
    }
    public boolean add(Employee emp)
    {
        tr=em.getTransaction();
        tr.begin();
        try {
            em.persist(emp);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean update(Employee emp )
    {
        tr=em.getTransaction();

        try {
            tr.begin();
            em.merge(emp);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public Optional<Employee> findById(long id) {
        Employee rs = em.find(Employee.class, id);
        return rs == null ? Optional.empty() : Optional.of(rs);
    }
    public List<Employee> getAll()
    {
        tr=em.getTransaction();

        try {
            tr.begin();
            return em.createQuery("select c from Employee c", Employee.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }
    public boolean detele(long id)
    {
        tr=em.getTransaction();
        tr.begin();

        try {
            Employee emp=em.find(Employee.class,id);
            emp.setStatus(EmployeeStatus.TERMINATED);
            em.merge(emp);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean activeEmp(long id)
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();

        try {
            Employee emp=em.find(Employee.class,id);
            emp.setStatus(EmployeeStatus.ACTIVE);
            em.merge(emp);;
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

}
