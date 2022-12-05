<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<h3>MobliePhone</h3>
		<p style="color: red;">${errorString}</p>
		<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
			<th>Category</th>
			<th>Cost</th>
			<th>Amount</th>
			<th>Photos1</th>			
			<th>Photos2</th>			
			<th>Photos3</th>			
			<th>Photos4</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${ProductList}"  var="product" >
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.type}</td>
				<td>${product.category}</td>
				<td>${product.cost}</td>
				<td>${product.amount}</td>
				<td><a href="${product.p1}">Data</a></td>
				<td><a href="${product.p2}">Data</a></td>
				<td><a href="${product.p3}">Data</a></td>
				<td><a href="${product.p4}">Data</a></td>
				<td><a href="#">Edit</a></td>
				<td><a href="#">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>