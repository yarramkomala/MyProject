
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="wpathth=device-wpathth, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>AddProducts</title>
</head>
<body>
<%@include file="header.jsp" %>

<div class="container">
  <form:form  class="form-horizontal" action="product" modelAttribute="product" method="POST" enctype="multipart/form-data">
    <div class="form-group">
      <label class="col-md-4 control-label">ProductName:</label>
      <div class="col-md-4">
      <form:input type="text" class="form-control" path="productName"  placeholder="Enter product name"/>
      <form:errors path="productName" cssClass="error" />  
    </div> 
    </div>
    <div class="form-group">
      <label  class="col-md-4 control-label" for="price">Price:</label>
      <div class="col-md-4">
      <form:input type="text" class="form-control" path="price"  placeholder="Enter price"/>
    <form:errors path="price" cssClass="error" />
        </div>
    </div>
    <div class="form-group">
    <label  class="col-md-4 control-label" for="quantity">Quantity:</label>
     <div class="col-md-4">
      
     <form:input type="text" class="form-control" path="quantity"  placeholder="Enter quantity"/> 
    <form:errors path="quantity" cssClass="error" />
    </div>
    </div>
     <div class="form-group">
      <label  class="col-md-4 control-label" for="categeryName">Category name:</label>
     <div class="col-md-4">
      <form:select class="form-control" path="categoryName" text="Category name">
       <form:option value="NONE" label="--- Select Category Name---"/>
      <c:if test="${! empty categoryList }">
      <c:forEach items="${categoryList}" var="list">
      <form:option value="${list.categoryName }"></form:option>
      </c:forEach>
      </c:if>
      </form:select>
      <form:errors path="categoryName" cssClass="error" />
    </div>
    </div>
<%--       <form:option value="NONE" label="--- Select Category Name---"/> --%>
<%--     <form:options items="${categoryList}" itemValue="cid" itemLabel="categoryName"/> --%>
    
<%-- <form:input type="text" class="form-control" path="categoryName"  placeholder="Enter category name"/> --%>
    
     <div class="form-group">
      <label  class="col-md-4 control-label" for="supplierName">Supplier Name:</label>
     <div class="col-md-4">
      <form:input type="text" class="form-control" path="supplierName"  placeholder="Enter supplier name"/>
    <form:errors path="supplierName" cssClass="error" />
    </div>
    </div>
    <div class="form-group">
      <label  class="col-md-4 control-label" for="image">File:</label>
    <div class="col-md-4">
    <form:input type="file" class="form-control" path="image"  placeholder="select a file"/>
     <form:errors path="image" cssClass="error"/>
     </div>
     </div>
     <div class="form-group">
      <label  class="col-md-4 control-label" for="description">Description:</label>
      <div class="col-md-4">
      <form:input type="text" class="form-control" path="description" placeholder="Enter description"/>
    <form:errors path="description" cssClass="error" />
    </div>
    </div>
    <center>
    <button type="submit" class="btn btn-default" >Add</button>
     <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" >
    
    
    </center>
  </form:form>
</div>
<center><a href="plist">Click Here to see  products</a></center>
<center><a href="disimage">Click Here to see  products images</a></center>

<%@include file="footer.jsp" %>
</body>
</html>