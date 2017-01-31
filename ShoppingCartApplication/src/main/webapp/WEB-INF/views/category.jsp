<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="wpathth=device-wpathth, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Category Page</title>
<style>
body {
	background-image: url("resources/images/sports.jpg");
	background-color: #cccccc;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Category Details</h2>

		<div>
			<form:form action="categoryadd" method="POST" commandName="category"
				enctype="multipart/form-data">


				<%-- <div class="form-group">
					<form:label class="control-label col-sm-2" path="categoryid">Category ID:</form:label>
					<div class="col-sm-10">
						<form:input path="categoryid" class="form-control" required="true"
							placeholder="Category Id" />
					</div>
				</div> --%>

				<div class="form-group">
					<form:label class="control-label col-sm-2" path="categoryName">Enter Category Name:</form:label>
					<div class="col-sm-10">
						<form:input type="text" path="categoryName" class="form-control"
							required="true" placeholder="Enter Category Name" />
					</div>
				</div>



				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-default" name="action"
							value="Add" />
					</div>
				</div>

				<!-- <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">

						<input type="submit" class="btn btn-default" name="action"
							value="Edit" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">

						<input type="submit" class="btn btn-default" name="action"
							value="Delete" />
					</div>
				</div> -->
			</form:form>

		</div>
	</div>
</body>
</html>