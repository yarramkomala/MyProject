<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>products</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="row">
<%@include file="header.jsp"%>
 <c:forEach  items="${productList}" var="product"> 
 <div class="col-xs-3">
 <div class="thumbnail zoom" id="exi">
 <img  src="<c:url value="/Resources/images/${product.productName}.jpg"/>" class="img-responsive">
<center> ${product.productName}
</center>
</div>
 </div>
</c:forEach>

</div>


<%@include file="footer.jsp"%>
</body>
</html>