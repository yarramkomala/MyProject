
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
<style>
body {
	background-image: url("Resources/images/bgrp.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;
	background-size: 100% 100%;
}

.mycolor {
	color: #72c02c;
}

.myborder {
	padding: 20px;;
	border: 1px solid #ccc;
	border-radius: 4px;
	-webkit-box-shadow: 0px 0px 3px 0px #72c02c;
	-moz-box-shadow: 0px 0px 3px 0px #72c02c;
	box-shadow: 0px 0px 3px 0px #72c02c;
}

.mybutton {
	position: relative;
	left: 50%;
	top: 193px;
}

.margin-bottom-20 {
	margin-bottom: 20px;
}

.btn-u:hover {
	background: #5fb611;
}

.btn-u:hover, .btn-u:focus, .btn-u:active, .btn-u.active, .open .dropdown-toggle.btn-u
	{
	background: #5fb611;
}

.btn-u:hover {
	color: #fff;
	text-decoration: none;
	-webkit-transition: all 0.3s ease-in-out;
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
}

.btn-u {
	background: #72c02c;
}

.btn-u {
	white-space: nowrap;
	border: 0;
	color: #fff;
	font-size: 14px;
	cursor: pointer;
	font-weight: 400;
	padding: 6px 13px;
	position: relative;
	background: #72c02c;
	display: inline-block;
	text-decoration: none;
}

.input-group-addon {
	border-right: 0;
	/*color: #b3b3b3;*/
	font-size: 14px;
	background: #fff;
	padding: 6px 12px;
	font-size: 14px;
	font-weight: 400;
	line-height: 1;
	color: #555;
	text-align: center;
	background-color: #eee;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.input-group .form-control {
	float: left;
	width: 100%;
	margin-bottom: 0;
}

.form-control {
	box-shadow: none;
}

.form-control {
	display: block;
	width: 100%;
	height: 34px !important;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.428571429;
	color: #555;
	background-color: #fff;
	background-image: none;
	border: 1px solid #72c02c !important;
	border-radius: 4px;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075);
	-webkit-transition: border-color ease-in-out .15s, box-shadow
		ease-in-out .15s;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
}
</style>
</head>
<body>
	<%-- 	<%@include file="header.jsp"%> --%>
	<br />
	<form:form modelAttribute="userinfo">
		<a href="${flowExecutionUrl}&_eventId_home">Home</a>
		<div class="container">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="row myborder">
					<h4 style="color: #7EB59E; margin: initial; margin-bottom: 10px;">Sign
						Up Now</h4>
					<hr>
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user mycolor"></i></span> <input size="60"
							maxlength="255" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
							required="true" title="ex1@ex.com" "class="form-control"
							placeholder="User Name" name="username" path="username"
							type="email">
					</div>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('username')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					<br />
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock mycolor"></i></span> <input size="60"
							maxlength="255" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
			required="true" title="at least one number and one uppercase and lowercase letter, and maximum  8 characters"
							placeholder="PassWord" name="password" path="password" type="password">
					</div>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					<br />
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user mycolor"></i></span> <input size="60"
							maxlength="255" pattern="[a-zA-Z\s]{3,30}" required="true"
							title="Size Must Be 3-30 " class="form-control"
							placeholder="First Name" name="fname" path="fname" type="text">
					</div>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('fname')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					<br />
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user mycolor"></i></span> <input size="60"
							maxlength="255" pattern="[a-zA-Z\s]{3,30}" required="true"
							title="Size Must Be 3-30 "
							class="form-control" placeholder="Last Name" name="lname"
							path="lname" type="text">
					</div>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('lname')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					<br />
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-envelope mycolor"></i></span> <input
							size="60" maxlength="255" class="form-control"
							placeholder="Address" name="address"  pattern="[a-zA-Z\s]{3,30}" required="true"
							title="Size Must Be 3-30 "  path="address" type="text">
					</div>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					<br />
					<div class="input-group margin-bottom-20">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-phone mycolor"></i></span> <input size="60"
							maxlength="255" required="true"
							title="PhoneNumber Starts with Either 7,8 or 9.Length Must Be 10"
							class="form-control" placeholder="Contact Number"
							name="contactnumber" path="contactnumber" type="text">
					</div>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('contactnumber')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					<br />
					<div class="row">
						<div class="col-md-12">

							<input name="_eventId_submit" type="submit" value="Submit" /><br>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</form:form>

	<%@include file="footer.jsp"%>
</body>
</html>