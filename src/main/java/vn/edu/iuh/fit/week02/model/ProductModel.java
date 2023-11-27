package vn.edu.iuh.fit.week02.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02.enums.ProductStatus;
import vn.edu.iuh.fit.week02.models.Product;
import vn.edu.iuh.fit.week02.services.ProductService;

public class ProductModel {
    private final ProductService productService =new ProductService();
    public void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        String unit = req.getParameter("unit");
        String manu = req.getParameter("manu");
        String status = req.getParameter("status");

        Product product =new Product(name,desc,unit,manu, ProductStatus.valueOf(status));
        productService.insert(product);
        resp.sendRedirect("productList.jsp");
    }

    public void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        long id =Long.parseLong(req.getParameter("id"));
        productService.updateStatus(id, ProductStatus.IN_ACTIVE);
        resp.sendRedirect("productList.jsp");
    }
}