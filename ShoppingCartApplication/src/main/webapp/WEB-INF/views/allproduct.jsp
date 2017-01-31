<%@include file="header.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<style>
.div1 {
	width: 350px;
	height: 380px;
	border: 2px solid black;
	box-sizing: border-box;
}
</style>
</head>
<body>

	<c:if test="${!empty productList}">

		<div class="container">
			<div class="row">
				<h2>Products</h2>

				<div class="row text-center">
					<c:forEach items="${productList}" var="product">


						<div class="col-md-4">

							<a href="#"><div class="div1">
									<img  src="<c:url value="/Resources/images/${product.productName}.jpg"/>" class="img-responsive"
										alt="Tv" class="img-responsive"
										style="width: 4000px; height: 370px" />
								</div></a> <br>
							<sec:authorize access="hasRole('ROLE_USER')"><a href="viewDetails?pdt1=${admin.productid}">
								<button type="button" class="btn btn-info">View
									Details</button>
							</a></sec:authorize>
							<h2>${product.productName}</h2>
							<h3>&#x20B9 ${product.price}</h3>
							
<!-- 							<h2> -->
<%-- 							<sec:authorize access="hasRole('ROLE_ADMIN')"> --%>
<%-- 								<a href="delete1?id22=${admin.pid}"><button --%>
<!-- 										type="button" class="btn btn-danger">Delete</button></a> -->
<%-- 							</sec:authorize> --%>
<!-- 						</h2> -->
							
							
							<!-- <button type="button" class="btn btn-default">Add to
									Cart</button>

								<button type="button" class="btn btn-default">Buy Now</button> -->
							

							<%-- <h3>${admin.productdescription}</h3> --%>
						</div>
					</c:forEach>
				</div>

			</div>

		</div>

	</c:if>
</body>
</html>