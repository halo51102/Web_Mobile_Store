<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
<div>
Đây là trang Admin

	<h2>Manager</h2>

	<div>
		<nav>
			<ul>
				<li><a href="admin">Home</a></li>
				<li><a href="productList" method="post">MobilePhone</a></li>
				<li><a href="accessoryList" method="post">Accessory</a></li>
				<li><a>Sale</a></li>
				<li><a>Bill</a></li>
				<li><a href="home">Homepage Website MobilePhone</a></li>
			</ul>
		</nav>
	</div>
</div>
</body>
</html>