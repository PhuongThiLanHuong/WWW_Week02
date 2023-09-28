package vn.edu.iuh.fit.week02.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02.model.CustomerModel;
import vn.edu.iuh.fit.week02.model.EmployeeModel;
import vn.edu.iuh.fit.week02.model.ProductModel;

import java.io.IOException;

@WebServlet("/controls")
public class ControlServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try
        {
            Object actionObject=req.getParameter("action");
            if(actionObject!=null)
            {
                String action=actionObject.toString();
                if(action.equals("insertEmp")){
                    EmployeeModel employeeModel=new EmployeeModel();
                    employeeModel.insertEmp(req,resp);
                }else if(action.equals("insertCust")){
                    CustomerModel customerModel=new CustomerModel();
                    customerModel.insertCust(req, resp);
                }else if(action.equals("insertPro")){
                    ProductModel productModel=new ProductModel();
                    productModel.insertPro(req, resp);
                }else{
                    resp.sendRedirect("customerList");
                }
            }
        }catch (Exception e)
        {
            throw  new RuntimeException();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Object actionObject=req.getParameter("action");
            if(actionObject!=null)
            {
                String action=actionObject.toString();
                if(action.equals("cust_list"))
                {
                    resp.sendRedirect("customerList.jsp");
                } else if (action.equals("pro_list")) {
                    resp.sendRedirect("productList.jsp");
                }else if(action.equals("emp_list")) {
                    resp.sendRedirect("employeeList.jsp");
                }else if(action.equals("delete_emp")){
                    EmployeeModel employeeModel=new EmployeeModel();
                    employeeModel.delteEmp(req,resp);
                }else {
                    resp.sendRedirect("test.jsp");
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
