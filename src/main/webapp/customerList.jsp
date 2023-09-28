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
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<%
    CustomerService customerService=new CustomerService();
    List<Customer> list=customerService.getAllCustomer();
%>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th colspan="2"><a href="insertCustomer.jsp">Insert</a></th>
    </tr>
    <%for(Customer customer:list){%>
    <tr>
        <td><%=customer.getCusId()%></td>
        <td><%=customer.getCustName()%></td>
        <td><%=customer.getEmail()%></td>
        <td><%=customer.getPhone()%></td>
        <td><%=customer.getAddress()%></td>

    </tr>
</table>
</body>
</html>
