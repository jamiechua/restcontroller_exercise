<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
	<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
	
	<title>Cart</title>

    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="styles/online-retailer.css">
    
    <script src="jquery/jquery-1.12.4.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>	
</head>
<body>

	<div class="container">

		<div class="banner col-xs-12">
			Cart
			<a href="/"><span class="glyphicon glyphicon-home"></span> Home</a>
		</div>
	    
	    <c:forEach var="item" items="${cart}"> 
			<div class="item">
			    <div class="remove">
			    	<a href="removeItemFromCart?id=${item.key}"><span class="glyphicon glyphicon-trash"></span></a>
			    </div>
			    <div class="quantity">${item.value}</div>
			    <div class="details">${catalog[item.key].description} @ £${catalog[item.key].price}</div>
			</div>
	    </c:forEach>
		
		<div>
			<div>Cart cost: <b>${cartCost}</b></div>
			<div>Sales tax: <b>${salesTax}</b></div>
			<div>Delivery charge: <b>${deliveryCharge}</b></div>
		</div>
	</div>

</body>
</html>