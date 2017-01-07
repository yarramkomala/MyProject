
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>AddProducts</title>
</head>
<body>
<div class="container">
  <form:form action="insertproduct" modelAttribute="product" method="post">
    <div class="form-group">
      <label for="name">ProductName:</label>
      <input type="text" class="form-control" id="name" name="productName" placeholder="Enter product name">
    </div> 
    <div class="form-group">
      <label for="price">Price:</label>
      <input type="text" class="form-control" id="price" name="price" placeholder="Enter price">
    </div>
    <div class="form-group">
    <label for="quantity">Quantity:</label>
      <input type="text" class="form-control" id="quantity" name="quantity" placeholder="Enter quantity"> 
    </div>
     <div class="form-group">
      <label for="categeryname">Category name:</label>
      <input type="text" class="form-control" id="categoryname" name="categoryName" placeholder="Enter category name">
    </div>
     <div class="form-group">
      <label for="suppliername">Supplier Name:</label>
      <input type="text" class="form-control" id="suppliername" name="supplierName" placeholder="Enter supplier name">
    </div>
    <button type="submit" class="btn btn-default">Add</button>
  </form:form>
</div>
<a href="plist">Click Here to see  products</a>
</body>
</html>