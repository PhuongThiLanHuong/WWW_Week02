package vn.edu.iuh.fit.week02.services;

import vn.edu.iuh.fit.week02.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02.models.Employee;
import vn.edu.iuh.fit.week02.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepository repository;
    public EmployeeService() {
        repository = new EmployeeRepository();
    }
    public void insertEmp(Employee employee) {
        repository.createEmployee(employee);
    }
    public Optional<Employee> findById(String id) {
        return repository.findbyId(id);
    }

    public boolean activeEmp(String id) {
        Optional<Employee> op = findById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public List<Employee> getAll() {
        return null;
    }
}
