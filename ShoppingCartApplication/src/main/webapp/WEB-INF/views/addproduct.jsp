
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>AddProducts</title>
</head>
<body>
<%@include file="header.jsp" %>

<div class="container">
  <form:form  class="form-horizontal" action="product" modelAttribute="Product" method="POST" enctype="multipart/form-data">
    <div class="form-group">
      <label class="col-md-4 control-label" for="name">ProductName:</label>
      <div class="col-md-4">
      <input type="text" class="form-control" id="name" name="productName" placeholder="Enter product name">
    </div> 
    </div>
    <div class="form-group">
      <label  class="col-md-4 control-label" for="price">Price:</label>
      <div class="col-md-4">
      <input type="text" class="form-control" id="price" name="price" placeholder="Enter price">
    </div>
    </div>
    <div class="form-group">
    <label  class="col-md-4 control-label" for="quantity">Quantity:</label>
     <div class="col-md-4">
      <input type="text" class="form-control" id="quantity" name="quantity" placeholder="Enter quantity"> 
    </div>
    </div>
     <div class="form-group">
      <label  class="col-md-4 control-label" for="categeryname">Category name:</label>
     <div class="col-md-4">
      <input type="text" class="form-control" id="categoryname" name="categoryName" placeholder="Enter category name">
    </div>
    </div>
     <div class="form-group">
      <label  class="col-md-4 control-label" for="suppliername">Supplier Name:</label>
     <div class="col-md-4">
      <input type="text" class="form-control" id="suppliername" name="supplierName" placeholder="Enter supplier name">
    </div>
    </div>
    <div class="form-group">
      <label  class="col-md-4 control-label" for="image">File:</label>
    <div class="col-md-4">
    <input type="file" class="form-control" id="image" name="image" placeholder="select a file">
<!--     <input type="submit" value="Upload">  -->
     </div>
     </div>
     <div class="form-group">
      <label  class="col-md-4 control-label" for="suppliername">Description:</label>
      <div class="col-md-4">
      <input type="text" class="form-control" id="description" name="description" placeholder="Enter description">
    </div>
    </div>
    <center>
    <button type="submit" class="btn btn-default" >Add</button>
     <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
    
    
    </center>
  </form:form>
</div>
<center><a href="plist">Click Here to see  products</a></center>
<center><a href="disimage">Click Here to see  products images</a></center>

<%@include file="footer.jsp" %>
</body>
</html>