package vn.edu.iuh.fit.week02.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02.models.*;
import vn.edu.iuh.fit.week02.services.OrderDetailService;
import vn.edu.iuh.fit.week02.services.OrderServices;

import java.io.IOException;
import java.util.List;

public class OrderModel {
    private final OrderServices orderService= new OrderServices();
    private final OrderDetailService orderDetailService=new OrderDetailService();
    public void calcPriceOfCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long ordID= Long.parseLong(request.getParameter("orderCode"));
        double total =orderDetailService.calcTotalPrice(ordID);
        request.setAttribute("orderTotal", total);
        List<OrderDetail> orderDetails =orderDetailService.getOrderDetailByOrderID(ordID);
        request.setAttribute("orderDetails", orderDetails);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }








}
