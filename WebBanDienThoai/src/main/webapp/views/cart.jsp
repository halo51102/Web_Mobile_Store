<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cart</title>
<link rel="stylesheet" href="/WebBanDienThoai/views/style.css">

</head>
<body class="cart-body">
	<!-- HEADER -->
	<jsp:include page="_header.jsp"></jsp:include>
	
	<c:if test="${empty ssid}">
		<h2>Đăng nhập đi ạ :)</h2>
	</c:if>
	<c:if test="${not empty ssid}">
		<div class="container-cart-page">
			<div class="small-container cart-page">
				<table>
					<tr>
						<th>Sản Phẩm</th>
						<th>Số lượng</th>
						<th>Tổng</th>
					</tr>
					<c:forEach items="${CartList}" var="cart">
						<tr>

							<td>
								<div class="cart-info">
									<img
										src="https://www.nanodog.net/web/image/product.template/104/image_256/%5BAPP-IPH-12-64GB-MGJ53%5D%20iPhone%2012%20%7C%2064GB%20%7C%20Black?unique=43d7214"
										alt="">
									<div>
										<p class="product-name">${cart.tenpr}</p>
										<small class="price">Price: ${cart.cost} VND</small> <a
											href="">Remove</a>
									</div>
								</div>
							</td>
							<td><input type="number" value="${cart.slpr}"></td>
							<td>##</td>

						</tr>

					</c:forEach>
				</table>


			</div>
		</div>
	</c:if>
	<footer>
		<div>@Copyright 2022</div>
	</footer>


</body>
</html>