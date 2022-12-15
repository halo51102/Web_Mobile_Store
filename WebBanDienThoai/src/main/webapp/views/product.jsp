<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product</title>
    <link rel="stylesheet" href="/WebBanDienThoai/views/style.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
</head>
<body>
    <!-- HEADER -->
		<jsp:include page="/views/_header.jsp"></jsp:include>


    <div class="container-product container-product-page" style="margin-top:150px;">
        <div class="row row-head">
            <h2>Products</h2>
            <select>
                <option>Default Shorting</option>
                <option>Short by price</option>
                <option>Short by popularity</option>
                <option>Short by sale</option>
            </select>
        </div>


		<div class="row">
			<c:forEach items="${ProductList}" var="product">
				<div class="col-4"
					onclick="window.location.href='productdetail?productid=${product.id}'">
					<img src="${product.p1}" alt="">
					<h4>${product.name}</h4>
					<div></div>
					<p>${product.cost}</p>
				</div>
			</c:forEach>
		</div>




		<!-- FOOTER -->
	<footer>
        <div>
   	 	@Copyright 2022
   	 	<p>SĐT liên hệ: 09xxxxxxxx</p>
   	 	<p>Địa chỉ: Số 1 Võ Văn Ngân, Thủ Đức</p>
    	</div>
    </footer>
</body>
</html>