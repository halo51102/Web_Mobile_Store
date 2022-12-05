<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css"> 
</head>
<body>
    <header>
        <h2 class="logo">Mobile Store</h2>
        <nav>
            <ul class="header">
            	<li><a href="home" method="post">Home</a></li>
            	<div class="dropdown">
				<li><a class="dropbtn">Category</a>
					<div class="dropdown-content">
						<a href="product.html">Mobile Phone</a>
						<a href="#">Accessory</a>
						<a href="#">?</a>
					</div>
				</li>
				</div>
				<li><a href=#sale>Sale</a></li>
				<div class="dropdown">
				<li><a class="dropbtn">Info</a>
					<div class="dropdown-content">
						<a href="#">Contact</a>
						<a href="#About">About</a>
					</div>
				</li>
				</div>
                <li><a href="cart" method="post">Cart</a></li>
                <li><a href="login" method="post">Sign In</a></li>
                <li><a href="sign-up" method="post">Sign Up</a></li>                
            </ul>
        </nav>
    </header>
    
</body>
</html>