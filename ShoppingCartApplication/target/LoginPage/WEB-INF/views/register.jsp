
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign up</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<%@include file="header.jsp"%>
	<div class="row">
		<div class="col-md-6 col-md-offset-4">

			<div class="jumbotron" style="width: 500px; height: 450px">
				<div class="container">
					<fieldset>
						<div class="col-md-6 col-md-offset-4">
							<h3>
								<span class="glyphicon glyphicon-pencil"></span> SignUp
							</h3>
						</div>
						<form:form modelAttribute="userinfo">
							<!-- action="addUser" -->
							<div class="form-group">
								<!-- style="width:370px" -->
								<label class="col-md-4 control-label">UserName</label>
								<div class="input-group col-md-7">
									<form:input path="username" size="60" maxlength="255"
										pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
										placeholder="Username" required="true" title="ex1@ex.com"
										class="form-control" />
									<form:errors path="username" cssClass="error" />
									<%-- 									<span style="color: red"></span> --%>
									<c:forEach
										items="${flowRequestContext.messageContext.getMessagesBySource('username')}"
										var="err">

										<span style="color: red">${err.text}</span>

									</c:forEach>
									<br />
								</div>
							</div>
							<div class="form-group">
								<!-- style="width:370px" -->
								<label class="col-md-4 control-label">Password</label>
								<div class="input-group col-md-7">
									<form:input path="password" type="password" maxlength="255"
										pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required="true"
										title="at least one number and one uppercase and lowercase letter, and maximum  8 characters"
										placeholder="PassWord" class="form-control" />
									<%-- <span style="color: red"></span> --%>
									<form:errors path="password" cssClass="error" />
									<c:forEach
										items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
										var="err">

										<span style="color: red">${err.text}</span>

									</c:forEach>
									<br />
								</div>
							</div>
							<div class="form-group">
								<!-- style="width:370px" -->
								<label class="col-md-4 control-label">First Name</label>
								<div class="input-group col-md-7">
									<form:input path="fname" maxlength="255"
										pattern="[a-zA-Z\s]{3,30}" required="true"
										placeholder="Firstname" title="Size Must Be 3-30 "
										class="form-control" />
									<!--         <span style="color:red"> </span>  -->
									<form:errors path="fname" cssClass="error" />
									<c:forEach
										items="${flowRequestContext.messageContext.getMessagesBySource('fname')}"
										var="err">
										<span style="color: red">${err.text}</span>
									</c:forEach>
									<br />
								</div>
							</div>
							<div class="form-group">
								<!-- style="width:370px" -->
								<label class="col-md-4 control-label">Last Name</label>
								<div class="input-group col-md-7">
									<form:input path="lname" maxlength="255"
										pattern="[a-zA-Z\s]{1,30}" required="true"
										placeholder="lastname" title="Size Must Be 1-30 "
										class="form-control" />
									<%--         <span style="color:red"> </span> --%>
									<form:errors path="lname" cssClass="error" />
									<c:forEach
										items="${flowRequestContext.messageContext.getMessagesBySource('lname')}"
										var="err">
										<span style="color: red">${err.text}</span>
									</c:forEach>
									<br />
								</div>
							</div>
							<div class="form-group">
								<!-- style="width:370px" -->
								<label class="col-md-4 control-label">Address</label>
								<div class="input-group col-md-7">
									<form:input path="address" placeholder=" Complete Address"
										name="address" pattern="[a-zA-Z\s]{3,60}" required="true"
										title="Size Must Be 3-60 " class="form-control" />
									<%--         <span style="color:red"> --%>
									<form:errors path="address" cssClass="error" />
									<c:forEach
										items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
										var="err">
										<span style="color: red">${err.text}</span>
									</c:forEach>
									<br />
								</div>
							</div>
							<div class="form-group">
								<!-- style="width:370px" -->
								<label class="col-md-4 control-label">Contact Number</label>
								<div class="input-group col-md-7">
									<form:input path="contactnumber" required="true"
										placeholder="Contact number" pattern="[0-9\s]{1,10}"
										title="PhoneNumber Starts with Either 7,8 or 9.Length Must Be 10"
										class="form-control" />
									<%--         <span style="color:red"> </span> --%>
									<form:errors path="contactnumber" cssClass="error" />
									<c:forEach
										items="${flowRequestContext.messageContext.getMessagesBySource('contactnumber')}"
										var="err">
										<span style="color: red">${err.text}</span>
									</c:forEach>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 col-md-offset-4">
									<div class="form-group">
										<!--  <input type="submit"  value="Add"/> -->

										<input name="_eventId_submit" type="submit" value="Submit"
											class="btn btn-danger" style="width: 200px" />
									</div>
								</div>
							</div>

						</form:form>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>