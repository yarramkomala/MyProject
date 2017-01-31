<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list</title>
</head>
<body>


		<div class="content">
			<fieldset>
				<legend>Confirm Details</legend>
				<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
				
				<sf:form modelAttribute="userinfo">
				<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /><br />
					<sf:label path="username">UserName:</sf:label>${userinfo.username}
					<br /><br />
					<sf:label path="password">PassWord:</sf:label>${userinfo.password}
					<br /><br />
					<sf:label path="fname">FirstName:</sf:label>${userinfo.fname}
					<br /><br />
					<sf:label path="lname">LastName:</sf:label>${userinfo.lname}
					<br></br>
					<sf:label path="address">Address:</sf:label>${userinfo.address}
					<br></br>
					<sf:label path="contactnumber">ContactNumber:</sf:label>${userinfo.contactnumber}
					<br></br>
					
					<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					<input name="_eventId_edit" type="submit" value="Edit" /> 
					<input name="_eventId_submit" type="submit" value="Confirm Details" /><br>
				</sf:form>
			</fieldset>
		</div>
	
</body>
