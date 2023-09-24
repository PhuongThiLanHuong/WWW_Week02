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

}
