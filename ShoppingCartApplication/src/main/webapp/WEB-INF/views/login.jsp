<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>login page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style>
	body {
    background-image: url("Resources/images/bgln.jpg");
     background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
     background-size: 100% 100%;
    
    }
     body {
    color: blue;
}
    
    </style>

</head>
<body >
<%@include file="header.jsp" %>


	<div class="container" >
   

  <h2>Login Form</h2>
  <form action="validate">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" name="email" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="pwd" placeholder="Enter password">
    </div>
    <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
${successmsg }
<c:if test="${getLogin}">
<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="not empty ${errormsg}">

<jsp:include page="login.jsp"></jsp:include>
</c:if>
${errormsg}

<%-- <c:if test="${showRegistrationPage}"> --%>
<%--  <jsp:include page="registration.jsp"></jsp:include> --%>
<%--   </c:if>  --%>


<%@include file="footer.jsp" %>

		
<%-- 		${fname}<br> --%>
<%-- 		${lname}<br> --%>
<%-- 		${email} --%>
		
		
		
	</center>
</body>
</html>