<%@ page import="vn.edu.iuh.fit.week02.services.CustomerService" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week02.models.Customer" %><%--
  Created by IntelliJ IDEA.
  User: taejo
  Date: 9/27/2023
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<%
    CustomerService customerService=new CustomerService();
    List<Customer> list=customerService.getAllCustomer();
%>
<div class="container">
    <table class="table table-hove">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th colspan="2"><a href="insertCustomer.jsp">Insert</a></th>
        </tr>
        <%for(Customer customer:list){
          long id=customer.getId();
            String delete_string = "controls?action=delete_customer&id="+id;
            String edit_string = "updateCustomer.jsp?id="+id;
        %>
        <tr>
            <td><%=customer.getId()%></td>
            <td><%=customer.getName()%></td>
            <td><%=customer.getEmail()%></td>
            <td><%=customer.getPhone()%></td>
            <td><%=customer.getAddress()%></td>
            <td><a href=<%=edit_string%>>Update</a> </td>
            <td><a href=<%=delete_string%>>Delete</a> </td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
