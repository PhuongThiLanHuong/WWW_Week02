package vn.edu.iuh.fit.week02.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.week02.Connect.ConnectDatabase;
import vn.edu.iuh.fit.week02.models.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailRepository {
    private EntityManager em;
    public OrderDetailRepository() {
        em = ConnectDatabase.getInstance().getEmf().createEntityManager();
    }
    public double calcTotalPrice(long orderID){
        double totalPrice=0;
        List<OrderDetail> list= new ArrayList<>();
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        try {
            String nativeQuery= "SELECT * \n" +
                    "FROM orderdetail\n" +
                    "WHERE OrderID=?";
            Query query = em.createNativeQuery(nativeQuery, OrderDetail.class);
            query.setParameter(1, orderID);
            list=query.getResultList();
            for (OrderDetail orderDetail:list) {
                totalPrice+=orderDetail.getPrice()*orderDetail.getQuantity();
            }

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            // TODO: handle exception
        }
        return totalPrice;

    }
    public List<OrderDetail> getOrderDetailByOrderID(long orderID){
        List<OrderDetail> list= new ArrayList<>();
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        try {
            String nativeQuery= "SELECT * \n" +
                    "FROM orderdetail\n" +
                    "WHERE OrderID=?";
            Query query = em.createNativeQuery(nativeQuery, OrderDetail.class);
            query.setParameter(1, orderID);
            list=query.getResultList();

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            // TODO: handle exception
        }
        return list;

    }
}
