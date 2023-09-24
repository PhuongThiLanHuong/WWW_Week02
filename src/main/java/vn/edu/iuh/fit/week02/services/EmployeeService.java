package vn.edu.iuh.fit.week02.services;

import vn.edu.iuh.fit.week02.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02.models.Employee;
import vn.edu.iuh.fit.week02.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository repository;
    public EmployeeService() {
        repository=new EmployeeRepository();
    }
    public List<Employee> getAllEmployees() {
        return repository.getAll();
    }

    public Employee getEmployeeById(long id) {
        return repository.get(id);
    }

    public boolean addEmployee(Employee employee) {
        if((employee.getStatus()!=EmployeeStatus.ACTIVE)&&(employee.getStatus()!=EmployeeStatus.IN_ACTIVE)&&(employee.getStatus()!=EmployeeStatus.TERMINATED)) return false;
        return repository.add(employee);
    }

    public boolean updateEmployee(Employee employee) {
        if((employee.getStatus()!=EmployeeStatus.ACTIVE)&&(employee.getStatus()!=EmployeeStatus.IN_ACTIVE)&&(employee.getStatus()!=EmployeeStatus.TERMINATED)) return false;
        return repository.update(employee);
    }

    public boolean deleteEmployee(long id) {
        return repository.detele(id);
    }

    public boolean activateEmployee(long id) {
        return repository.activeEmp(id);
    }

}
