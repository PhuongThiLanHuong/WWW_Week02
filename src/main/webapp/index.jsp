<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Please to work you want to do " %>
</h1>
<br/>
<a href="insertEmployee.jsp">Insert new Employee</a><br/>
<a href="insertCustomer.jsp">Insert new Customer</a><br/>
<a href="insertProduct.jsp">Insert new Product</a><br/>
<a href="controls?action=emp_list">Employee List</a><br/>
<a href="controls?action=cust_list">Customer List</a><br/>
<a href="controls?action=pro_list">Product List</a><br/>
</body>
</html>