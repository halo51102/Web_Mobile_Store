<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detail</title>
    <link rel="stylesheet" href="/WebBanDienThoai/views/style.css">
</head>
<body>
    <!-- HEADER -->
    
	<jsp:include page="/views/_header.jsp"></jsp:include>
    
   
    <div class="container-product container-prodetails">
        <section id="prodetails" class="section-p1">
        
            <div class="single-pro-img">
                <img src="${product.p1}" 
                id="MainImg" alt="">
    
                <div class="small-img-group">
                    <div class="small-img-col">
                        <img src="${product.p1}" 
                        alt="" class="small-img">
                    </div>
                    <div class="small-img-col">
                        <img src="${product.p2}" 
                        alt="" class="small-img">
                    </div>
                    <div class="small-img-col">
                        <img src="${product.p3}" 
                        alt="" class="small-img">
                    </div>
                    <div class="small-img-col">
                        <img src="${product.p4}" 
                        alt="" class="small-img">
                    </div>
                </div>
            </div>
    
            <div class="single-pro-details">
            <form method="POST" action="${pageContext.request.contextPath}/cart?username=${ssid}"
          name="addProductToCart" onsubmit="return validateForm()" >
          		<input type="hidden" name="idpr" value="${product.id}" />
          		<input type="hidden" name="tenpr" value="${product.name}" />
          		<input type="hidden" name="cost" value="${product.cost}" />
                <h2>${product.name}</h2>
                <h3>${product.cost}</h3>
                <input type="number" name="slpr" value="1">
                <button >Add to Cart</button>
                <h4>Product Details</h4>
                <span>${product.describe}</span>
            </form>
            </div>
           
        </section>
    </div>

    <!-- FOOTER -->
	<footer>
        <div>
   	 	@Copyright 2022
   	 	<p>SĐT liên hệ: 09xxxxxxxx</p>
   	 	<p>Địa chỉ: Số 1 Võ Văn Ngân, Thủ Đức</p>
    	</div>
    </footer>

    <script>
        var MainImg=document.getElementById("MainImg");
        var smallimg=document.getElementsByClassName("small-img");

        smallimg[0].onclick=function(){
            MainImg.src=smallimg[0].src;
        }
        smallimg[1].onclick=function(){
            MainImg.src=smallimg[1].src;
        }
        smallimg[2].onclick=function(){
            MainImg.src=smallimg[2].src;
        }
        smallimg[3].onclick=function(){
            MainImg.src=smallimg[3].src;
        }
    </script>
</body>
</html>