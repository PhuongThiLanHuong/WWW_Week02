package vn.edu.iuh.fit.week02.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02.model.CustomerModel;
import vn.edu.iuh.fit.week02.model.EmployeeModel;
import vn.edu.iuh.fit.week02.model.OrderModel;
import vn.edu.iuh.fit.week02.model.ProductModel;

import java.io.IOException;

@WebServlet("/controls")
public class ControlServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProductModel productModel = new ProductModel();
            CustomerModel customerModel = new CustomerModel();
            EmployeeModel employeeModel = new EmployeeModel();
            OrderModel orderModel=new OrderModel();
            Object action = req.getParameter("action");
            if (action.equals("insertEmp")) {
                employeeModel.insertEmp(req, resp);
            } else if (action.equals("insertCust")) {
                customerModel.insertCust(req,resp);
            } else if (action.equals("insertPro")) {
                productModel.insertProduct(req,resp);
            } else if (action.equals("updatePro")) {
                productModel.updateProduct(req, resp);
            } else if (action.equals("updateCust")) {
                customerModel.updateCustomer(req,resp);
            } else if (action.equals("updateEmp")) {
               employeeModel.updateEmployee(req,resp);
            }else {
                    resp.sendRedirect("index.jsp");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
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
                } else if (action.equals("order_list")) {
                    resp.sendRedirect("orderList.jsp");
                }else if(action.equals("delete_emp")){
                    EmployeeModel employeeModel=new EmployeeModel();
                    employeeModel.deleteEmp(req,resp);
                }else if (action.equals("delete_product")){
                    ProductModel pm=new ProductModel();
                    pm.deleteProduct(req, resp);
                }else if (action.equals("delete_cus")){
                    ProductModel pm=new ProductModel();
                    pm.deleteProduct(req, resp);
                }
                else if(action.equals("caclPrice")){
                    OrderModel orderModel= new OrderModel();
                    orderModel.calcPriceOfCart(req, resp);
                }

                else {
                    resp.sendRedirect("index.jsp");
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
