package vn.edu.iuh.fit.week02.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02.models.Customer;
import vn.edu.iuh.fit.week02.services.CustomerService;


import java.io.IOException;

public class CustomerModel {
    private final CustomerService customerService=new CustomerService();
    public void insertCust(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        Customer customer=new Customer(name,email,phone,address);
        customerService.addCustomer(customer);
        response.sendRedirect("customerList.jsp");
    }
    public void updateCustomer(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
       Customer customer=new Customer(name,email,phone,address);
       customerService.updateCustomer(customer);
       response.sendRedirect("customerList.jsp");
    }
}
