package vn.edu.iuh.fit.week02.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02.models.Customer;
import vn.edu.iuh.fit.week02.services.CustomerService;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CustomerModel {
    private final CustomerService customerService=new CustomerService();
    public Object insertCust(HttpServletRequest request, HttpServletResponse response) throws IOException,InterruptedException{
        String name=request.getParameter("cust_name");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        Customer customer=new Customer(name,email,phone,address);
        customerService.addCustomer(customer);
        return customer;

    }
    public void Listing(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<Customer> list=customerService.getAllCustomer();
        request.setAttribute("cus_list",list);
        request.getRequestDispatcher("customerList.jsp").forward(request,response);
    }
}
