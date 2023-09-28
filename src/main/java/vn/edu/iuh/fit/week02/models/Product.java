package vn.edu.iuh.fit.week02.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.week02.enums.ProductStatus;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @Column(name="ProductID")
    private long product_id;
    @Column(name="Description",columnDefinition = "nvarchar(1000)")
    private String description;
    @Column(name="Manufacturer",columnDefinition = "nvarchar(100)")
    private String manufacturer;
    @Column(name="Name",columnDefinition = "nvarchar(100)")
    private String name;
    @Column(name="Status")
    private ProductStatus status;
    @Column(name="Unit",columnDefinition = "nvarchar(100)")
    private String unit;
    public Product(long product_id, String description, String manufacturer, String name,ProductStatus status, String unit) {
        this.product_id = product_id;
        this.description = description;
        this.manufacturer = manufacturer;
        this.name = name;
        this.status = status;
        this.unit = unit;
    }
    public Product( String description, String manufacturer, String name,ProductStatus status, String unit) {
        this.description = description;
        this.manufacturer = manufacturer;
        this.name = name;
        this.status = status;
        this.unit = unit;
    }

    public Product() {
    }

    public Product(long product_id) {
        this.product_id = product_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", unit='" + unit + '\'' +
                '}';
    }
}
