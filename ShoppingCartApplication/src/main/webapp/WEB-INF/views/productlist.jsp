<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>product list</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="header.jsp" %>

<c:if test="${!empty productList}">  
<div class="container">
             
  <table class="table table-striped">
    <thead>
      <tr>
      <th>Id</th>
        <th>ProductName</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Category Name</th>
         <th>Supplier Name</th>
         <th>Description</th>
      </tr>
       <c:forEach items="${productList}" var="product">
       <tr>
       <td><c:out value="${product.id}" />
      </td>
    <td><c:out value="${product.productName}" />
      </td>
      <td><c:out value="${product.price}" />
      </td>
      <td><c:out value="${product.quantity}" />
      </td>
      <td><c:out value="${product.categoryName}" /></td>
      
      <td><c:out value="${product.supplierName}" />
      </td>
      <td><c:out value="${product.description}" />
      </td>
      <td><a href="pedit?id=${product.id}">Edit</a></td>
      <td><a href="pdelete?id=${product.id}">Delete</a></td>
      
      </tr>
      </c:forEach>
  </table>
</div>
</c:if>
<a href="admin">Click Here to add new User</a>
<%@include file="footer.jsp" %>
</body>
</html>