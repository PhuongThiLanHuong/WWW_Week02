package vn.edu.iuh.fit.week02.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02.enums.ProductStatus;
import vn.edu.iuh.fit.week02.models.Product;
import vn.edu.iuh.fit.week02.services.ProductService;

import java.io.IOException;

public class ProductModel {
    private final ProductService productService =new ProductService();
    public void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        String unit = req.getParameter("unit");
        String manu = req.getParameter("manu");

        Product product =new Product(name,desc,unit,manu, ProductStatus.ACTIVE);
        productService.insert(product);
        resp.sendRedirect("productList.jsp");
    }

    public void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        long id =Long.parseLong(req.getParameter("id"));
        productService.updateStatus(id, ProductStatus.IN_ACTIVE);
        resp.sendRedirect("productList.jsp");
    }
    public void updateProduct(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String dec = request.getParameter("dec");
        String manufacturer = request.getParameter("manu");
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        Product product = new Product(name,dec,unit,manufacturer,ProductStatus.ACTIVE);
       productService.update(product);
        response.sendRedirect("productList.jsp");
    }
}