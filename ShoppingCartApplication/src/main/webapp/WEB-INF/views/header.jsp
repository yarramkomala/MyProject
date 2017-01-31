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
<!-- navigation bar..displays fields -->
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"></a>
		</div>
<!-- display in left side of navigation bar -->
		<ul class="nav navbar-nav">
			<li class="active"><a href="home">Home</a></li>
			<li class="active"><a href="disimage">products</a></li>
	</ul>
	<ul class="nav navbar-nav">
	 <li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
				<ul class="dropdown-menu">

					<c:forEach items="${categoryList}" var="admin">
<%--  						<li><a href="${admin.categoryName}"><c:out  --%>
<%-- 								value="${admin.categoryName}" /> </a></li>   --%>

						<li><a href="allproduct?pdt=${admin.categoryName}">${admin.categoryName}</a></li>
					</c:forEach>
				</ul></li>
                    </ul>
		<!-- displays in right side to navigation bar -->
		<ul class="nav navbar-nav navbar-right">
		<!-- based on logged in user this access will executes-->
		<li><sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>${pageContext.request.userPrincipal.name}</h2>
		</c:if>
	</sec:authorize></li>
	<c:if test="${pageContext.request.userPrincipal.name == null}">
			<li><a href="register"><span
					class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>
					Login</a></li>
</c:if>
			<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
				<li><a href="logout">Logout</a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_ADMIN')">
                 <li><a href="category">Add Category</a></li>
				<li><a href="admin">AddProduct</a></li>
			</sec:authorize>
			<li><a href="<c:url value='cart'/>">cart</a></li>
		</ul>	
	</div>
	</nav>
	
	
	<%@page
		import="java.util.*, org.springframework.security.core.Authentication,org.springframework.security.core.GrantedAuthority,
org.springframework.security.web.DefaultRedirectStrategy,
org.springframework.security.web.RedirectStrategy,org.springframework.security.core.context.SecurityContextHolder"%>
	<%
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if(auth!=null){
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
//out.print(authorities.iterator().next());
		List<String> roles = new ArrayList<String>();
 //		System.out.println(roles.get(1));
//out.print(roles);
		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}}
	%>
</body>
</html>