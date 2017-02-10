<%@include file="header.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <title></title>
  <style>
  .card-container.card {
	max-width: 350px;
	padding: 40px 40px;
}

.profile-name-card {
	font-size: 16px;
	font-weight: bold;
	text-align: center;
	margin: 10px 0 0;
	min-height: 1em;
}

  </style>
</head>
<body>

<div class="container">	<div class="card card-container">
<p id="profile-name" class="profile-name-card"></p>
      <div class="well well-sm">
 <center><b> <h2>PAYMENT</h2><hr></b></center>
 <b> <p>Please Select the Payment Method</p></b>
  <form>
    <label class="radio-inline">
      <input type="radio" name="optradio">Debit card & Online Banking
    </label>
    <br>
    <label class="radio-inline">
      <input type="radio" name="optradio">Credit cards
    </label>
    <br>
    <label class="radio-inline">
      <input type="radio" name="optradio">Cash On Delivery or COD
    </label>
    <br>
     <label class="radio-inline">
      <input type="radio" name="optradio">Prepaid Cash Cards
    </label>
   <br>
     <label class="radio-inline">
      <input type="radio" name="optradio">Pay Through DD or Demand Draft
    </label>
   <br>
   
      <label class="radio-inline">
      <input type="radio" name="optradio">Mobile Payment
    </label>
   <br>
   
  </form>
 <a href="<c:url value="thanks"/>"><button type="button" class="btn btn-success">Submit</button></a>
 </div>
</div>
</div>

</body>

</html>
<%@include file="footer.jsp"%>