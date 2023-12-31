package vn.edu.iuh.fit.week02.services;

import jakarta.inject.Inject;
import vn.edu.iuh.fit.week02.enums.ProductStatus;
import vn.edu.iuh.fit.week02.models.Product;
import vn.edu.iuh.fit.week02.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
   @Inject
    private ProductRepository repository;
   @Inject
    public ProductService() {
        this.repository = new ProductRepository();
    }

    public boolean insert(Product product){
        return repository.add(product);

    }

    public List<Product>getAllProduct(){
        return repository.getAll();
    }

    public void updateStatus(long id, ProductStatus status) {
        repository.updateStatus(id,status);
    }
    public boolean update(Product product)
    {
        return repository.update(product);
    }
    public Optional<Product> findById(long id)
    {
        return repository.findById(id);
    }
}
