package vn.edu.iuh.fit.week02.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02.models.Employee;
import vn.edu.iuh.fit.week02.services.EmployeeService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeeModel {
    private final EmployeeService employeeService=new EmployeeService();
    public void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("fullName");
        String address=request.getParameter("address");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String dobString = request.getParameter("dob");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.from(LocalDate.parse(dobString, formatter).atStartOfDay());
        String status = request.getParameter("status");

        employeeService.addEmployee(new Employee( address, dob, email, name, phone, EmployeeStatus.valueOf(status)));
        response.sendRedirect("employee.jsp");

    }
    public void delteEmp(HttpServletRequest request,HttpServletResponse response) throws Exception {
        long id=Long.parseLong(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        response.sendRedirect("employeeList.jsp");
    }
    public void Listing(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<Employee> list=employeeService.getAllEmployees();
        request.setAttribute("emp_list",list);
        request.getRequestDispatcher("employeeList.jsp").forward(request,response);
    }
}
