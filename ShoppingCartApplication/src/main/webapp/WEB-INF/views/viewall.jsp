

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.8/angular.min.js">
</script>
<script>
	angular.module('myApp', []).controller('MyController',
			[ '$scope', '$http', function($scope, $http) {

				$http.get("angularview").success(function(data) {
					$scope.person = data;
					
				});

			} ]);
</script>
<!-- <style>
body {
	background-image: url("resources/bg5.jpg");
	
}
</style> -->
</head>
<body>
<%@include file="header.jsp"%>
	<div class="container" ng-app="myApp" ng-controller="MyController">
		<div class="row">

			<!-- <form>
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="fa fa-search"></i>
						</div> -->

			<input type="text" class="form-control"
				placeholder="Search for Products" ng-model="searchProduct">
			<!-- 
					</div>
				</div>
			</form> -->

			<h2>Products</h2>

			<div class="row text-center">
				<div ng-repeat="pro in person | filter:searchProduct">


					<div class="col-md-4">

						<!-- <a href="viewall"> -->
						<div class="div1">
							<h2>{{pro.categoryname}}</h2>
							<img
								src="<c:url value='Resources/images/{{pro.productName}}.jpg'/>"
								alt="Tv" class="img-responsive"
								style="width: 4000px; height: 370px" />
						</div>
						<!-- </a> -->
						<br>
						<h2>
							<sec:authorize access="hasRole('ROLE_USER')">
								<a href="viewDetails?pdt1={{pro.id}}"><button
										type="button" class="btn btn-info">View Details</button></a>
							</sec:authorize>
						</h2>
						<h2>
							<sec:authorize access="hasRole('ROLE_ADMIN')">
								<a href="delete?id1={{pro.id}}"><button
										type="button" class="btn btn-danger">Delete</button></a>
							</sec:authorize>
						</h2>
						<!-- <button type="button" class="btn btn-default">Add to Cart</button>

						<button type="button" class="btn btn-default">Buy Now</button> -->
						<h2>{{pro.productname}}</h2>
						<h3>&#x20B9 {{pro.price}}</h3>

						<%-- <h3>${admin.productdescription}</h3> --%>
					</div>

				</div>
			</div>

		</div>

	</div>
</body>
</html>

