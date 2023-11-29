package vn.edu.iuh.fit.week02.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02.enums.EmployeeStatus;
import vn.edu.iuh.fit.week02.enums.ProductStatus;
import vn.edu.iuh.fit.week02.models.Employee;
import vn.edu.iuh.fit.week02.models.Product;
import vn.edu.iuh.fit.week02.services.EmployeeService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeeModel {
    private final EmployeeService employeeService=new EmployeeService();
    public void insertEmp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatDob = LocalDate.parse(dob, formatter);
        Employee employee=new Employee(name,formatDob,email,phone,address,EmployeeStatus.ACTIVE);
        employeeService.insertEmp(employee);
        response.sendRedirect("employeeList.jsp");
    }
    public void deleteEmp(HttpServletRequest request,HttpServletResponse response) throws Exception {
        long id=Long.parseLong(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        response.sendRedirect("employeeList.jsp");
    }
    public void Listing(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<Employee> list=employeeService.getAllEmployees();
        request.setAttribute("emp_list",list);
        request.getRequestDispatcher("employeeList.jsp").forward(request,response);
    }

    public void updateEmployee(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatDob = LocalDate.parse(dob, formatter);
        Employee employee=new Employee(name,formatDob,email,phone,address,EmployeeStatus.ACTIVE);
        employeeService.updateEmployee(employee);
        response.sendRedirect("employeeList.jsp");
    }
}
