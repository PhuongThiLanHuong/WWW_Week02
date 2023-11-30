<%@ page import="vn.edu.iuh.fit.week02.repositories.OrderRepository" %>
<%@ page import="vn.edu.iuh.fit.week02.models.Order" %>
<%@ page import="vn.edu.iuh.fit.week02.repositories.OrderDetailRepository" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: taejo
  Date: 11/30/2023
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Order List</title>
</head>
<body>
<div class="container">
    <h2>Order List</h2>
    <table class="table table-hover">
        <thead class="table-header">
        <tr>
            <th scope="col">Date</th>
            <th scope="col">Price</th>
            <th scope="col">Customer</th>
            <th scope="col">Employee</th>
            <th colspan="2"><a href="insertOrder.jsp">Insert</a> </th>
        </tr>
        </thead>
        <tbody>
        <%
            OrderRepository orderRepository = new OrderRepository();
            List<Order> orders = orderRepository.getAll();
            OrderDetailRepository orderDetailRepository = new OrderDetailRepository();
            if (orders != null) {
                for (Order o : orders) {%>
        <tr>
            <td><%=o.getOrderDate() %>
            </td>
            <td><%=orderDetailRepository.calcTotalPrice(o.getOrder_id()) %>
            </td>
            <td><%=o.getCustomer().getName() %>
            </td>
            <td><%=o.getEmployee().getFullname() %>
            </td>

        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
