package vn.edu.iuh.fit.week02.converters;

import java.time.LocalDateTime;

public class OrderByDate {
    private LocalDateTime orderDay;
    private Long totalOrders;

    // Getter và Setter


    public OrderByDate() {
    }

    public OrderByDate(LocalDateTime orderDay, Long totalOrders) {
        this.orderDay = orderDay;
        this.totalOrders = totalOrders;
    }

    public LocalDateTime getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(LocalDateTime orderDay) {
        this.orderDay = orderDay;
    }

    public Long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Long totalOrders) {
        this.totalOrders = totalOrders;
    }

    @Override
    public String toString() {
        return "OrderByDateDTO{" +
                "orderDay=" + orderDay +
                ", totalOrders=" + totalOrders +
                '}';
    }
}
