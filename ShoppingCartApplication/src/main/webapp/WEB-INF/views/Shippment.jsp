
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<%@include file="header.jsp"%>
	<div class="container">
		<h2 style="color: white"> New Order</h2>

		<div>
			<form:form modelAttribute="shippment">
				
				<div class="form-group" >
					<form:label class="control-label col-sm-2" path="name" style="color: black">Enter YourName:</form:label>
					<div class="col-sm-10">
						<form:input type="text" path="name" class="form-control"
							 placeholder="Enter Name" />
						<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('name')}"
					var="err">
					<div>
						<span style="color:red">${err.text}</span>
					</div>
				</c:forEach>
				<br />
					</div>
				</div>


				<div class="form-group">
					<form:label class="control-label col-sm-2" path="address" style="color: black">Enter Address:</form:label>
					<div class="col-sm-10">
						<form:input path="address" class="form-control" 
							type="text" placeholder="Enter Address" />
						<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
					var="err">
					<div>
						<span style="color:red">${err.text}</span>
					</div>
				</c:forEach>
				<br />
					</div>
				</div>


				<div class="form-group">
					<form:label class="control-label col-sm-2" path="city" style="color: black">Enter City</form:label>
					<div class="col-sm-10">
						<form:input type="text" path="city" class="form-control" 
							 placeholder="Enter City" />
						<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('city')}"
					var="err">
					<div>
						<span style="color:red">${err.text}</span>
					</div>
				</c:forEach>
				<br />
					</div>
				</div>

				<div class="form-group">
					<form:label class="control-label col-sm-2" path="state" style="color: black">Enter State:</form:label>
					<div class="col-sm-10">
						<form:input type="text" path="state"
							class="form-control"  placeholder="Enter State" />
						<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('state')}"
					var="err">
					<div>
						<span style="color:red">${err.text}</span>
					</div>
				</c:forEach>
				<br />
					</div>
				</div>

				<div class="form-group">
					<form:label class="control-label col-sm-2" path="pincode" style="color: black">Enter Pincode:</form:label>
					<div class="col-sm-10">
						<form:input type="number" path="pincode"
							class="form-control" 
							placeholder="Enter Pincode" />
						<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('pincode')}"
					var="err">
					<div>
						<span style="color:red">${err.text}</span>
					</div>
				</c:forEach>
				<br />
					</div>
				</div>
				<div class="form-group">
					<form:label class="control-label col-sm-2" path="mobilenumber" style="color: black">Enter Mobile Number:</form:label>
					<div class="col-sm-10">
						<form:input type="number" path="mobilenumber"
							class="form-control" 
							placeholder="Enter Mobile Number" />
						<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('mobilenumber')}"
					var="err">
					<div>
						<span style="color:red">${err.text}</span>
					</div>
				</c:forEach>
				<br />
					</div>
				</div>
				<br>
				<br>
				<br>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input name="_eventId_submit" type="submit" value="Submit" />
						<!-- action name called on switch case -->
					</div>
				</div>

			</form:form>
		</div>
	</div>

</body>
</html>