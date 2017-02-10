<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style>
	body {
    background-image: url("Resources/images/cr4.jpg");
     background-repeat: no-repeat;
    background-attachment: fixed;
    background-position: center; 
     background-size: 100% 100%;
    
    }
     body {
    color: red;
}
    
    </style>
</head>
<body onload='document.loginForm.username.focus();'>

	<h1> Login Form</h1>

	<div id="login-box">

		
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST' id="target">

			<div class="form-group">
      <label for="email">Username:</label>
      <input type="email" class="form-control" name="username" color="black"required="true" message="username required" placeholder="Enter email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" name="password" color="black" required="true" placeholder="Enter password">
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
    <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			
		</form>
		
	
	</div>

</body>
</html>