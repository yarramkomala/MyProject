<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">WebSiteName</a>
		</div>

		<ul class="nav navbar-nav">
			<li class="active"><a href="home">Home</a></li>
			<li><a href="#">Page 1</a></li>
			<li><a href="#">Page 2</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="register"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>

			<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
				<li><a href="logout">Logout</a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">


				<li><a href="admin">AddProduct</a></li>
				
			</sec:authorize>
			<li><a href="<c:url value='cart'/>">cart</a></li>
		</ul>
		
	</div>
	</nav>
	<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>${pageContext.request.userPrincipal.name}</h2>
		</c:if>
	</sec:authorize>
	
	<%@page
		import="java.util.*, org.springframework.security.core.Authentication,org.springframework.security.core.GrantedAuthority,
org.springframework.security.web.DefaultRedirectStrategy,
org.springframework.security.web.RedirectStrategy,org.springframework.security.core.context.SecurityContextHolder"%>
	<%
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if(auth!=null){
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
out.print(authorities.iterator().next());
		List<String> roles = new ArrayList<String>();
 //		System.out.println(roles.get(1));
out.print(roles);
		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}}
	%>
</body>
</html>