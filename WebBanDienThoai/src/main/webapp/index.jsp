<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>HomePage</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/WebBanDienThoai/views/style.css">
</head>
<body>
	<img src="./images/nenInfoSP.jpg" style="width:100%;height:100%;position:absolute;z-index:-1;" alt="">
	<jsp:include page="/views/_header.jsp"></jsp:include>
	<jsp:include page="/views/sale.jsp"></jsp:include>
	<!-- ABOUT -->
	<div style="color:white">
	
		<h1 id="About" style="font-size:70px;display: flex;justify-content: space-around; margin:50px;">About</h1>
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
	

	<jsp:include page="/views/_footer.jsp"></jsp:include>
	
</body>
</html>