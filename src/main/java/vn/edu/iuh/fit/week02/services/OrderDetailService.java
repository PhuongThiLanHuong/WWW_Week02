package vn.edu.iuh.fit.week02.services;

import vn.edu.iuh.fit.week02.models.OrderDetail;
import vn.edu.iuh.fit.week02.repositories.OrderDetailRepository;

import java.util.List;

public class OrderDetailService {
    private OrderDetailRepository orderDetailRepository;

    public OrderDetailService() {
        orderDetailRepository=new OrderDetailRepository();
    }
    public double calcTotalPrice(long orderID){
        return orderDetailRepository.calcTotalPrice(orderID);
    }
    public List<OrderDetail> getOrderDetailByOrderID(long orderID){
        return orderDetailRepository.getOrderDetailByOrderID(orderID);
    }

}
