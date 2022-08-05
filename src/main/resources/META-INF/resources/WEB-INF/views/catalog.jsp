<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
	<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
	
	<title>Catalog</title>

    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="styles/online-retailer.css">
    
    <script src="jquery/jquery-1.12.4.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>	
</head>
<body>

	<div class="container">

		<div class="banner col-xs-12">
			Catalog
			<a href="showCart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a>
		</div>
	    
	    <c:forEach var="item" items="${catalog}">
			<div class="thumbnail col-xs-6 col-md-4 col-lg-3">
			    <img src="images/${item.value.id}.jpg">
			    <div class="caption">
			        <h3>${item.value.description}</h3>
			        <p>&pound;${item.value.price}</p>
					<form action="addItemToCart">
						<input type="hidden" name="id" value="${item.value.id}">
						<input type="number" name="quantity" placeholder="Quantity">
						<button>Add to cart</button>
					</form> 
			    </div>
			</div>
	    </c:forEach>

		<c:if test="${!empty message}">
			<div class="banner col-xs-12">${message}</div>
		</c:if>
		
	</div>

</body>
</html>