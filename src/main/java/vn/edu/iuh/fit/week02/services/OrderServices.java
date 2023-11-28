package vn.edu.iuh.fit.week02.services;

import vn.edu.iuh.fit.week02.models.Order;
import vn.edu.iuh.fit.week02.models.OrderDetail;
import vn.edu.iuh.fit.week02.repositories.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class OrderServices {
    private OrderRepository orderRepository;

    public OrderServices() {
       orderRepository = new OrderRepository();
    }
    public boolean addOrder(Order order, OrderDetail orderDetail){
        return  orderRepository.add(order, orderDetail);
    }
    public Map<LocalDateTime,Long> getOrderByDate(){
        return orderRepository.getOrderByDate();
    }
    public Map<String,Long> getOrderByMonth() {
        return orderRepository.getOrderByMonth();
    }
    public Map<String,Long> getOrderByEmployeeForMonth(){
        return orderRepository.getOrderByEmployeeForMonth();

    }
    public List<Order> getAllOrder()
    {
        return orderRepository.getAllOrder();
    }
}
