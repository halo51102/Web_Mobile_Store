<%@page import="bean.Login" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/WebBanDienThoai/views/style.css">
</head>
<body>
	<!-- HEADER -->
	<jsp:include page="/views/_header.jsp"></jsp:include>
	

	<!-- SALE -->
	<div class="sale" id="sale">
		<html>
<meta name="viewport" content="width=device-width, initial-scale=1">

<body>

<div class="slideshow-container">

    <div class="mySlides fade">
    <div class="numbertext">1 / 4</div>
    <img src="https://previews.123rf.com/images/vasilyrosca/vasilyrosca1711/vasilyrosca171100016/89052835-super-sale-smartphone-banner-mobile-phone-clearance-sale-discount-poster-web-banner-big-promotion-.jpg?fj=1" >
    <div class="text"></div>
    </div>

    <div class="mySlides fade">
    <div class="numbertext">2 / 4</div>
    <img src="https://www.91-cdn.com/hub/wp-content/uploads/2022/07/flipkart-sp-deal-1.png" 
        >
    <div class="text"></div>
    </div>

    <div class="mySlides fade">
    <div class="numbertext">3 / 4</div>
    <img src="https://www.91-cdn.com/hub/wp-content/uploads/2022/09/best-phone-deals-under-rs-20000-feat.png" 
        >
    <div class="text"></div>
    </div>
    
    <div class="mySlides fade">
    <div class="numbertext">4 / 4</div>
    <img src="https://www.91-cdn.com/hub/wp-content/uploads/2022/09/These-are-the-best-smartphone-deals.jpg" >
    <div class="text"></div>
    </div>

</div>
<br>

<div style="text-align:center">
  <span class="dot"></span>
  <span class="dot"></span>
  <span class="dot"></span>
  <span class="dot"></span>
</div>



</body>
	    </html>
	<script src="WebBanDienThoai/views/script.js"></script>
	</div>
	
	<!-- PRODUCT -->
    <div class="product">
        <div>
            <h2>Best Seller</h2>
        </div>
        <div class="container-product">    
            <div class="row">
                <div class="col-4">
                    <img src="data:image/jpeg;base64,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" 
                        alt="">
                    <h4>Product name</h4>
                    <div class="rating">
                        4/5
                    </div>
                    <p>$50.00</p>
                </div>
                <div class="col-4">
                    <img src="data:image/jpeg;base64,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" 
                        alt="">
                    <h4>Product name</h4>
                    <div class="rating">
                        4/5
                    </div>
                    <p>$50.00</p>
                </div>
                <div class="col-4">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQzwpS-foXxAzV8QUaD_wmUoXeDuCvGgPaAw&usqp=CAU" 
                        alt="">
                    <h4>Product name</h4>
                    <div class="rating">
                        4/5
                    </div>
                    <p>$50.00</p>
                </div>
                <div class="col-4">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYCmi3g4KOM6p68LSO3FQ6eyhIVRe6ULz0iw&usqp=CAU" 
                        alt="">
                    <h4>Product name</h4>
                    <div class="rating">
                        4/5
                    </div>
                    <p>$50.00</p>
                </div>
            </div>
        </div>
    </div>
	

	<!-- ABOUT -->
	<div class="about" id="about" style="color:black">
	
		<h1 id="About" style="color: white;font-size:50px;display: flex;justify-content: space-around; margin:50px;">About</h1>
		<div class="grid-container">
		<div class="item1">Ứng dụng được xây dựng chủ yếu phục vụ 2 đối tượng là người mua hàng và người bán hàng
	</div>
		<div class="item2">Khách vãng lai:
Có thể tra cứu sản phẩm trực tiếp trên sản phẩm, có thể xem các thông tin về sản phẩm như tên, mẫu mã, giá, bài giới thiệu…
Đăng ký tài khoản để trở khách hàng, thực hiện các bước mua hàng và thanh toán
</div>		
		<div class="item3">Khách hàng:
Đăng nhập tài khoản trên ứng dụng để tiến hành mua hàng, thanh toán
Đăng xuất tài khoản
Tra cứu sản phẩm, xem thông tin sản phẩm
Xem tình trạng đơn hàng
Chỉnh sửa thông tin cá nhân
Giỏ hàng
		</div>
		
		</div>
	
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