<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list</title>
</head>
<body>
<table border="1">
	<th>first name</th>
	<th>last name</th>
	<th>address</th>
	<th>contact number</th>
<c:forEach items="${userlist}" var="userinfo">
		<tr>
			<td>${userinfo.fname}</td>
			<td>${userinfo.lname}</td>
			<td>${userinfo.address}</td>
			<td>${userinfo.contactnumber}</td>
		</tr>
	</c:forEach>

</table>
</body>
