<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.week02.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: taejo
  Date: 9/27/2023
  Time: 1:57 PM
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
    <title>Employee List</title>
</head>
<body>
<%
     List<Employee> list= (List<Employee>) request.getAttribute("emp_list");
     if(list==null)
     {
         response.sendRedirect("index.jsp");
     }
     else{
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
        </thead>
        <tr>
            <%for(Employee employee:list){%>
            <td><%=employee.getEmp_id()%></td>
            <td><%=employee.getFull_name()%></td>
            <td><%=employee.getDob()%></td>
            <td><%=employee.getEmail()%></td>
            <td><%=employee.getPhone()%></td>
            <td><%=employee.getAddress()%></td>
            <td><%=employee.getStatus()%></td>
            <td><a href="controls?actiion=uodate_emp">Update</a> </td>
            <td><a href="controls?action=delete_emp&id=<%employee.getEmp_id();%>">Delete</a> </td>
            <%}%>
        </tr>
    </table>
</div>
<%}%>
</body>
</html>
