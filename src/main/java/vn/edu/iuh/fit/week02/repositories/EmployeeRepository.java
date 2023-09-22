package vn.edu.iuh.fit.week02.repositories;

import jakarta.persistence.*;
import vn.edu.iuh.fit.week02.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02.models.Employee;

import java.util.List;
import java.util.Optional;
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
    public boolean createEmployee(Employee employee){
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.persist(employee);
            tr.commit();
            return true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public void setStatus(Employee employee, EmployeeStatus status) {
        employee.setStatus(status);
    }
    public boolean updateEmployee(Employee employee)
    {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(employee);
            tr.commit();
            return true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public Optional<Employee> findbyId(String id) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.emp_id=:id", Employee.class);
        query.setParameter("id", id);
        Employee emp = query.getSingleResult();
        return emp == null ? Optional.empty() : Optional.of(emp);
    }


    public List<Employee> getAllEmp() {
        return em.createNamedQuery("employee.findAll", Employee.class)
                .setParameter(1, EmployeeStatus.ACTIVE)
                .getResultList();
    }
    public List<Employee> getAllEmployee(){
        String sql = "select * from employee";
        List<Employee> list= em.createNativeQuery(sql, Employee.class).getResultList();
        return list;
    }
}
