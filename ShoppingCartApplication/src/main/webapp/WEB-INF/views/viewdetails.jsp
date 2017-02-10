<%@include file="header.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<%-- <c:forEach items="${productList}" var="admin"> --%>
			<div class="col-xs-4 col-sm-3">
				<div class="thumbnail">
					<a href="#"><img
						src="<c:url value='Resources/images/${product.productName}.jpg'/>"
						alt="Tv" class="img-responsive"
						style="width: 4000px; height: 370px" /></a>
					
					<h1>&#x20B9 ${product.price}</h1>
					
					<p>
					Available products<h2>${product.quantity}</h2>
					</p>
					<p>
					<h3>${product.description}</h3>
					</p>
					<sec:authorize access="hasRole('ROLE_USER')">
					<a href="addtocart?cart=${product.id}"><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</button></a>

					<button type="button" class="btn btn-danger">Buy Now</button></sec:authorize>
				</div>
			</div>
			<%-- </c:forEach> --%>
		</div>
	</div>
</body>
</html>