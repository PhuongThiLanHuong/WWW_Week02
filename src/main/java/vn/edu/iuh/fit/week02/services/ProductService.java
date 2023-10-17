package vn.edu.iuh.fit.week02.services;

import vn.edu.iuh.fit.week02.enums.ProductStatus;
import vn.edu.iuh.fit.week02.models.Product;
import vn.edu.iuh.fit.week02.repositories.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
        productRepository=new ProductRepository();
    }
    public boolean addProduct(Product product){
        if((product.getStatus()!= ProductStatus.ACTIVE)&&(product.getStatus()!=ProductStatus.IN_ACTIVE)&&(product.getStatus()!=ProductStatus.TERMINATED)) return false;
        return productRepository.add(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    public Product getProductByID(long id) {
        return productRepository.get(id);
    }
    public boolean updateProduct(Product product) {
        if((product.getStatus()!= ProductStatus.ACTIVE)&&(product.getStatus()!=ProductStatus.IN_ACTIVE)&&(product.getStatus()!=ProductStatus.TERMINATED)) return false;
        return productRepository.update(product);
    }
    public boolean deleteProduct(long id) {
        return productRepository.detele(id);
    }

    public void activateProduct(long id,ProductStatus status) {
        productRepository.updateStatus(id, status);
    }



}
