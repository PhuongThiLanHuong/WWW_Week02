package vn.edu.iuh.fit.week02.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.week02.enums.ProductStatus;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;

    @Column(name = "name", length = 250, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String unit;

    @Column(name = "manufacturer_name", nullable = false)
    private String manufacturerName;

    @Column(name = "status",nullable = false)
    private ProductStatus productStatus;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImageList;


    @OneToMany
    private List<OrderDetail> orderDetails;

    public Product() {
    }
}
