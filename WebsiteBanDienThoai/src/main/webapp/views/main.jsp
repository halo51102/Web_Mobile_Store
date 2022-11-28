<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<img src="./nenInfoSP.jpg" style="width:100%;height:100%;position:absolute;z-index:-1;" alt="">
	<jsp:include page="_header.jsp"></jsp:include>	
	<div style="display:flex;height:532px;">
	<jsp:include page="index.jsp"></jsp:include>
	<jsp:include page="product.jsp"></jsp:include>
	</div>
	<jsp:include page="_footer.jsp"></jsp:include>
	
</body>
</html>