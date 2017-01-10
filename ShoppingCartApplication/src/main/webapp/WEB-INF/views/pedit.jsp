<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>update products</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<center>
<div class="container">
  <form:form action="pupdate" modelAttribute="product" method="post">
     <table width="400px" height="150px">
    <tr>
    <div class="form-group">
     <td><form:label path="productName">ProductName</form:label></td>
     <td><form:input path="productName" class="form-control" value="${productObject.productName}" /></td>
     </div>
    </tr>
    <tr>
    <div class="form-group">
     <td><form:label path="price">Price</form:label></td>
     <td><form:input path="price" class="form-control" value="${productObject.price}"/></td>
    </div>
    </tr>
    <tr>
    <div class="form-group">
     <td><form:label path="quantity">Quantity</form:label></td>
     <td><form:input path="quantity" class="form-control" value="${productObject.quantity}"/></td>
   </div>
    </tr>
    <tr>
    <div class="form-group">
     <td><form:label path="categoryName">CategoryName</form:label></td>
     <td><form:input path="categoryName"  class="form-control" value="${productObject.categoryName}"/></td>
     </div>
     </tr>
     <tr>
     <div class="form-group">
     <td><form:label path="supplierName">SupplierName</form:label></td>
     <td><form:input path="supplierName" class="form-control" value="${productObject.supplierName}"/></td>
     </div>
     </tr>
       <tr>
    <div class="form-group">
     <td><form:label path="description">Description</form:label></td>
     <td><form:input path="description" class="form-control" value="${productObject.description}"/></td>
     </div>
      </tr>
    <tr>
     <td></td>
     <td><input type="submit" value="Update" />
     </td>
    </tr>
   </table>
 
  </form:form>
 
</div>
  </center>
  <%@include file="footer.jsp" %>
</body>
</html>
