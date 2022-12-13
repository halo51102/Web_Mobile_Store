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
    <div>
	<jsp:include page="/views/_header.jsp"></jsp:include>
    </div>
   
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
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQzwpS-foXxAzV8QUaD_wmUoXeDuCvGgPaAw&usqp=CAU" 
                        alt="" class="small-img">
                    </div>
                    <div class="small-img-col">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYCmi3g4KOM6p68LSO3FQ6eyhIVRe6ULz0iw&usqp=CAU" 
                        alt="" class="small-img">
                    </div>
                </div>
            </div>
    
            <div class="single-pro-details">
                <h2>${product.name}</h2>
                <h3>${product.cost}</h3>
                <select>
                    <option value="">Select Storage</option>
                    <option value="">64GB</option>
                    <option value="">128GB</option>
                    <option value="">256GB</option>
                </select>
                <input type="number" value="1">
                <button>Add to Cart</button>
                <h4>Product Details</h4>
                <span>${product.describe}</span>
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