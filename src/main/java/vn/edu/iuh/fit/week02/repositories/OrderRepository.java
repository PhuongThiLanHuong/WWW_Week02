package vn.edu.iuh.fit.week02.repositories;

import jakarta.persistence.*;
import vn.edu.iuh.fit.week02.converters.OrderByDate;
import vn.edu.iuh.fit.week02.converters.OrderByEmployeeMonth;
import vn.edu.iuh.fit.week02.converters.OrderByMonth;
import vn.edu.iuh.fit.week02.models.Order;
import vn.edu.iuh.fit.week02.models.OrderDetail;
import vn.edu.iuh.fit.week02.models.ProductPrice;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class OrderRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private Logger LoggerFactory;
    private final Logger logger=LoggerFactory.getLogger(this.getClass().getName());
    public OrderRepository()
    {
        em= Persistence.createEntityManagerFactory("week02")
                .createEntityManager();
        transaction=em.getTransaction();
    }
    public boolean add(Order order, OrderDetail orderDetail)
    {
        ProductPrice pp = new ProductPrice();
        EntityTransaction tr=em.getTransaction();
        double price=0;
        tr.begin();
        try {
            //thêm order
            em.merge(order);
            //lấy thông tin giá của product để gán cho price của orderdetail
            String nativeQuery = "SELECT *\n" +
                    "FROM productprice \n" +
                    "WHERE productprice.ProductID =? \n" +
                    "AND productprice.PriceDate = (\n" +
                    "    SELECT MAX(productprice.PriceDate)\n" +
                    "    FROM productprice\n" +
                    "    WHERE productprice.ProductID =? \n" +
                    ");";
            Query query = em.createNativeQuery(nativeQuery, ProductPrice.class);
            query.setParameter(1, orderDetail.getProduct().getProduct_id());
            query.setParameter(2, orderDetail.getProduct().getProduct_id());
            pp= (ProductPrice) query.getSingleResult();
            price= (double) pp.getPrice();
            OrderDetail ord=new OrderDetail();
            em.persist(ord);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean updateOrder(Order order)
    {
        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            em.merge(order);
            tr.commit();
            return true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public Optional<Order> findbyId(Long id) {
        TypedQuery<Order> query = em.createQuery("select o from Orders o where o.OrderID=:id", Order.class);
        query.setParameter("id", id);
        Order order = query.getSingleResult();
        return order == null ? Optional.empty() : Optional.of(order);
    }



    public List<Order> getAllEmployee(){
        String sql = "select * from order";
        List<Order> list= em.createNativeQuery(sql, Order.class).getResultList();
        return list;
    }
    public Map<LocalDateTime,Long> getOrderByDate(){
        Map<LocalDateTime,Long> map= new HashMap<>();
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        try {
            String nativeQuery= "SELECT DATE(OrderDate) AS OrderDay, COUNT(*) AS TotalOrders\n" +
                    "FROM orders\n" +
                    "GROUP BY DATE(OrderDate)\n" +
                    "ORDER BY OrderDay;";
            List<OrderByDate> list= em.createNativeQuery(nativeQuery, OrderByDate.class).getResultList();
            for (OrderByDate objects : list) {
                map.put(objects.getOrderDay(), objects.getTotalOrders());
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            // TODO: handle exception
        }
        return map;

    }
    public Map<String,Long> getOrderByMonth(){
        Map<String,Long> map= new HashMap<>();
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        try {
            String nativeQuery= "SELECT DATE_FORMAT(OrderDate, '%Y-%m') AS OrderMonth, COUNT(*) AS TotalOrders\n" +
                    "FROM orders\n" +
                    "GROUP BY OrderMonth\n" +
                    "ORDER BY OrderMonth";
            List<OrderByMonth> list= em.createNativeQuery(nativeQuery, OrderByMonth.class).getResultList();
            for (OrderByMonth objects : list) {
                map.put(objects.getOrderMonth(), objects.getTotalOrders());
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            // TODO: handle exception
        }
        return map;

    }
    public Map<String,Long> getOrderByEmployeeForMonth(){
        Map<String,Long> map= new HashMap<>();
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        try {
            String nativeQuery= "SELECT employee.EmployeeID, employee.FullName, COUNT(orders.OrderID) AS TotalOrders\n" +
                    "FROM employee \n" +
                    "INNER JOIN orders ON employee.EmployeeID = orders.EmployeeID\n" +
                    "GROUP BY employee.EmployeeID, employee.FullName\n" +
                    "ORDER BY TotalOrders DESC;";
            List<OrderByEmployeeMonth> list= em.createNativeQuery(nativeQuery, OrderByEmployeeMonth.class).getResultList();
            for (OrderByEmployeeMonth objects : list) {
                map.put(objects.getFullName(), objects.getTotalOrders());
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            // TODO: handle exception
        }
        return map;

    }
}
