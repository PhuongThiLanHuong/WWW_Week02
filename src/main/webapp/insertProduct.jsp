<%--
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
    <title>Insert Product</title>

</head>
<body>
<h2>Insert new product</h2>
<form action="controls?action=insertPro" method="post">
    <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="form-group">
        <label for="description">Description:</label>
        <textarea class="form-control" id="description" name="description" required></textarea>
    </div>
    <div class="form-group">
        <label for="unit">Unit:</label>
        <input type="text" class="form-control" id="unit" name="unit" required>
    </div>
    <div class="form-group">
        <label for="manufacturerName">Manufacturer:</label>
        <input type="text" class="form-control" id="manufacturerName" name="manufacturerName" required>
    </div>
    <div class="form-group">
        <label for="status">Status:</label>
        <select class="form-control" id="status" name="status" required>
            <option value="1">ACTIVE</option>
            <option value="0">IN_ACTIVE</option>
            <option value="-1">TERMINATED</option>
        </select>
    </div>
    <input type="hidden" name="action" value="add">
    <button type="submit" class="btn btn-primary">Add product</button>
</form>

</body>
</html>
