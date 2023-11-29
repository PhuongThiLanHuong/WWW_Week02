<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week02.models.Employee" %>
<%@ page import="vn.edu.iuh.fit.week02.services.EmployeeService" %><%--
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
    <title>Employee List</title>
</head>
<body>
<%
    EmployeeService employeeService=new EmployeeService();
    List<Employee> list=employeeService.getAllEmployees();
%>
<div class="container">
    <table class="table table-hove">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>DOB</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Status</th>
            <th colspan="2"><a href="insertEmployee.jsp">Insert</a></th>
        </tr>
            <%for(Employee employee:list){
            long id =employee.getId();
            String delete_string = "controls?action=delete_employee&id="+id;
            String edit_string = "updateEmployee.jsp?id="+id;
        %>
        <tr>
            <td><%=employee.getId()%></td>
            <td><%=employee.getFullname()%></td>
            <td><%=employee.getDob()%></td>
            <td><%=employee.getEmail()%></td>
            <td><%=employee.getPhone()%></td>
            <td><%=employee.getAddress()%></td>
            <td><%=employee.getStatus()%></td>
            <td><a href=<%=edit_string%>>Update</a> </td>
            <td><a href=<%=delete_string%>>Delete</a> </td>

        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
