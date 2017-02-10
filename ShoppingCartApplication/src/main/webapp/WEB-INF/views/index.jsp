<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>home page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<style>
body{
/*  background-image: url("Resources/images/bg1.jpg");  */
 background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
     background-size: 100% 100%;
	}
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	
	margin: auto;
	hieght:100%;
	width: 70%;

}
</style>
</head>
<body>

	<%@include file="header.jsp"%>
<%-- 	 Welcome ${userinfo.fname } --%>
	<div>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<!-- 					<img class="img-responsive" src="Resources/images/cr1.jpg" alt="Chania"  width="500" height="200" > -->
					<img src="Resources/images/image1.jpg" class="img-fluid" 
						alt="Responsive image" style=" height: 370px">
				</div>

				<div class="item">
					<!-- 					<img  class="img-responsive" src="Resources/images/2.jpg" alt="Chania"  > -->
					<img src="Resources/images/image2.jpg" class="img-fluid"
						alt="Responsive image" style=" height: 370px">
				</div>
				<div class="item">
					<!-- 					<img class="img-responsive" src="Resources/images/3.jpg" alt="Flower"  > -->
					<img src="Resources/images/cro.jpg" class="img-fluid"
						alt="Responsive image" style=" height: 370px">
				</div>


				<div class="item">
					<!-- 					<img class="img-responsive" src="Resources/images/4.jpg" alt="Flower"  > -->
					<img src="Resources/images/cr.jpg" class="img-fluid"
						alt="Responsive image" style=" height: 370px">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<div class="container-fluid">
	<center>
			<h1>New Arrivals</h1>
		</center>
		<div class="row">
			<div class="col-xs-6 col-sm-4" >
				<a href="allproduct?pdt=FootBall"><img src="<c:url value='/Resources/images/Sony.jpg'/>"
					alt="football" class="img-responsive"
					style="width: 4000px; height: 370px" /></a>
			</div>
			<div class="col-xs-6 col-sm-4" >
				<img src="<c:url value='/Resources/images/sony1.jpg'/>" alt="cricket"
					class="img-responsive" alt="Chania"
					style="width: 4000px; height: 370px" />
			</div>
			<div class="col-xs-6 col-sm-4" >
				<img src="<c:url value='/Resources/images/2.jpg'/>" alt="cricket"
					class="img-responsive" alt="Chania"
					style="width: 4000px; height: 400px" />
			</div>
			</div>
	<%@include file="footer.jsp"%>
<c:if test="not empty ${error}">
<jsp:include page="userLogin.jsp"></jsp:include>
</c:if>
</body>
</html>