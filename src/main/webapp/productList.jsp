
<%@ page import="vn.edu.iuh.fit.week02.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week02.services.ProductService" %><%--
  Created by IntelliJ IDEA.
  User: taejo
  Date: 9/27/2023
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<%
    ProductService productServices =new ProductService();
    List<Product> lst = productServices.getAllProduct();
%>
<div class="container">
    <table class="table table-hove">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Unit</th>
            <th>Manufacturer:</th>
            <th>Status</th>
            <th colspan="2"><a href="insertProduct.jsp">Insert</a> </th>
        </tr>
        <%for(Product product: lst){
            long id =product.getProduct_id();
            String delete_string = "controls?action=delete_product&id="+id;
            String edit_string = "updateProduct.jsp?id="+id;
        %>
        <tr>
            <td><%=id%></td>
            <td><%=product.getName()%></td>
            <td><%=product.getDescription()%></td>
            <td><%=product.getUnit()%></td>
            <td><%=product.getManufacturer()%></td>
            <td><%=product.getStatus()%></td>
            <td><a href=<%=edit_string%>>Update</a> </td>
            <td><a href=<%=delete_string%>>Delete</a> </td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
