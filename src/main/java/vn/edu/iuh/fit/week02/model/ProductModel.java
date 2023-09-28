package vn.edu.iuh.fit.week02.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.week02.enums.ProductStatus;
import vn.edu.iuh.fit.week02.models.Product;
import vn.edu.iuh.fit.week02.services.ProductService;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProductModel {
    private final ProductService productService=new ProductService();
    public Object insertPro(HttpServletRequest request, HttpServletResponse response) throws IOException,InterruptedException{
       String description=request.getParameter("Description");
       String manufacture=request.getParameter("Manufacture");
       String name=request.getParameter("Name");
       String unit=request.getParameter("Unit");
        Product product=new Product(description,manufacture,name, ProductStatus.ACTIVE,unit);
        productService.addProduct(product);
        return product;
    }
    public void Listing(HttpServletRequest request,HttpServletResponse response) throws Exception{
        List<Product> list=productService.getAllProducts();
        request.setAttribute("pro_list",list);
        request.getRequestDispatcher("productList.jsp").forward(request,response);
    }
}
