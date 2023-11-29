<%@ page import="vn.edu.iuh.fit.week02.services.CustomerService" %>
<%@ page import="vn.edu.iuh.fit.week02.models.Customer" %>
<%@ page import="java.util.Optional" %><%--
  Created by IntelliJ IDEA.
  User: taejo
  Date: 11/29/2023
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
      integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
      crossorigin="anonymous" referrerpolicy="no-referrer"/>
<html>
<head>
    <title>Update Customer</title>
</head>
<body>
<div class="container p-4">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <p class="fs-3 text-center">Edit Customer</p>
            <%
                CustomerService customerService=new CustomerService();
                long id = Long.parseLong(request.getParameter("id"));
                System.out.println(id);
                Optional<Customer> optional = customerService.findById(id);
                Customer customer= optional.orElseThrow(IllegalAccessError::new);
            %>
            <form action="controls?action=updateCust" method="post">
                <div class="mb-3">
                    <label class="form-label">Name</label>
                    <input name="name"
                           type="text" class="form-control"
                           value="<%= customer.getName() %>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Address</label>
                    <input type="text" name="address"
                           class="form-control"
                           value="<%= customer.getAddress() %>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Phone</label>
                    <input name="phone"
                           type="text" class="form-control"
                           value="<%= customer.getPhone() %>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input name="email"
                           type="text" class="form-control"
                           value="<%= customer.getEmail() %>">
                </div>
                <input type="hidden" name="id" value="<%= customer.getId()%>">
                <button type="submit" class="btn btn-primary col-md-12">Update</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
