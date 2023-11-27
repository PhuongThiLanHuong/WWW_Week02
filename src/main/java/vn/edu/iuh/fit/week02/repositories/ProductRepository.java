package vn.edu.iuh.fit.week02.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.week02.enums.ProductStatus;
import vn.edu.iuh.fit.week02.models.Product;

import java.util.List;

public class ProductRepository {
    private EntityManager em;
    private EntityTransaction tr;
    public ProductRepository()
    {
        em= Persistence.createEntityManagerFactory("week02")
                .createEntityManager();
        tr=em.getTransaction();
    }
    public boolean add(Product p)
    {
        tr=em.getTransaction();
        tr.begin();
        try {
            em.persist(p);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean update(Product p )
    {
        tr=em.getTransaction();
        tr.begin();
        try {
            em.merge(p);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public Product get(long id)
    {
        tr=em.getTransaction();
        tr.begin();
        try {
            return em.find(Product.class,id);
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }
    public List<Product> getAll()
    {
        tr=em.getTransaction();
        tr.begin();
        try {
            return em.createQuery("select p from Product p", Product.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }
    public boolean detele(long id)
    {
        tr=em.getTransaction();
        tr.begin();

        try {
            Product p=em.find(Product.class,id);
            p.setStatus(ProductStatus.IN_ACTIVE);
            em.merge(p);;
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public void updateStatus(long id, ProductStatus status) {
        TypedQuery<Product> q = em.createNamedQuery("Product.findById", Product.class)
                .setParameter(1, id);
        Product product = q.getSingleResult();
        product.setStatus(status);
        try {
            tr.begin();
            em.merge(product);
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
        }
    }
}