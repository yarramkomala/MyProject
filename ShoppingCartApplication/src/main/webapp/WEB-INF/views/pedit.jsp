<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update products</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <form:form action="pupdate" modelAttribute="product" method="post">
     <table width="400px" height="150px">
    <tr>
     <td><form:label path="productName">ProductName</form:label></td>
     <td><form:input path="productName" value="${productObject.productName}" /></td>
    </tr>
    <tr>
     <td><form:label path="price">Price</form:label></td>
     <td><form:input path="price" value="${productObject.price}"/></td>
    </tr>
    <tr>
     <td><form:label path="quantity">Quantity</form:label></td>
     <td><form:input path="quantity" value="${productObject.quantity}"/></td>
    </tr>
    <tr>
     <td><form:label path="categoryName">CategoryName</form:label></td>
     <td><form:input path="categoryName" value="${productObject.categoryName}"/></td>
     
     <td><form:label path="supplierName">SupplierName</form:label></td>
     <td><form:input path="supplierName" value="${productObject.supplierName}"/></td>
     
    </tr>
    <tr>
     <td></td>
     <td><input type="submit" value="Update" />
     </td>
    </tr>
   </table>
  </form:form>
 
</div>
</body>
</html>