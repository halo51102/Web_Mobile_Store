<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/WebBanDienThoai/views/style.css"> 
</head>
<body>
		<div class="header">
			<h2 class="logo">Mobile Store</h2>
			<div class="nav">
				<ul>
					<li><a id="notdropbtn" href="home">Home</a></li>
					<div class="dropdown">
					<li><a class="dropbtn">Category</a>
						<div class="dropdown-content">
							<a href="product" method="post">Mobile Phone</a>
							<a href="accessory" method="post">Accessory</a>
						</div>
					</li>
					</div>
					<li><a id="notdropbtn" href=home#sale>Sale</a></li>
					<div class="dropdown">
					<li><a id="notdropbtn" href="home#about">About</a></li>
					</li>
					</div>
					<c:if test="${empty ssid}">
					<li><a id="notdropbtn" href="login">Sign In</a></li>				  
       				</c:if>
       				<c:if test="${not empty ssid}">
       				<li><a id="notdropbtn" href="cart?username=${ssid}">Cart</a></li>
       				<li><a id="notdropbtn" href="bill?username=${ssid}">Order</a></li>	
       				<li><a id="notdropbtn" href="logout">Logout</a></li>	
       				</c:if>
				</ul>
			</div>
		</div>
    
</body>
</html>