package vn.edu.iuh.fit.week02.services;

import vn.edu.iuh.fit.week02.repositories.OrderDetailRepository;

public class OrderDetailService {
    private OrderDetailRepository orderDetailRepository;

    public OrderDetailService() {
        orderDetailRepository=new OrderDetailRepository();
    }
    public double calcTotalPrice(long orderID){
        return orderDetailRepository.calcTotalPrice(orderID);
    }
}
