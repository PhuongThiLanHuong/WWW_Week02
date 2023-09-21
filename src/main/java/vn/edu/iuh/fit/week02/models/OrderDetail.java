package vn.edu.iuh.fit.week02.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable{

    @Column(name = "note", length = 255)
    private String note;
    @Column(name = "price", columnDefinition = "DOUBLE", nullable = false)
    private double price;
    @Column(name = "quantity", columnDefinition = "DOUBLE", nullable = false)
    private double quantity;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public OrderDetail(String note, double price, double quantity) {
        this.note = note;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDetail(String note, double price, double quantity, Order order, Product product) {
        this.note = note;
        this.price = price;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "note='" + note + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}