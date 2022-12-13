var slideIndex = 0;
var cart = new Array();
showSlides();     // show các sản phẩm trong giỏ hàng

function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) { slideIndex = 1 }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex - 1].style.display = "block";
    dots[slideIndex - 1].className += " active";
    setTimeout(showSlides, 2000); // Chuyển ảnh sau 2 giây
}


function addToCart(x) {
    var boxPro = x.parentElement.parentElement.children;
    var img = boxPro[0].children[0].src;
    var price = boxPro[1].children[1].children[0].innerText;
    var proName = boxPro[1].children[0].innerText;
    var amount = boxPro[1].children[3].value;
    var pro = new Array(img, proName, price, amount);
    cart.push(pro);
    console.log(cart);

    sessionStorage.setItem("cart",JSON.stringify(cart));
    
}

function showCart() {
    var cart = sessionStorage.getItem("cart");
    cart = JSON.parse(cart);

    var infor = "";
    for (let i = 0; i < cart.length; i++) {
        var proTotalPrice = parseInt(cart[i][2]) * parseInt(cart[i][3]);
        infor += '<tr>' +
            '<td>' +
            '<div class="cart-info">' +
            '<img src="' + cart[i][0] + '" alt="">' +
            '<div>' +
            '<p class="product-name">' + cart[i][1] + '</p>' +
            '<small class="price">Price: $' + cart[i][2] + '</small>' +
            '<a href="">Remove</a>' +
            '</div>' +
            '</div>' +
            '</td>' +
            '<td><input type="number" value="' + cart[i][3] + '"></td>' +
            '<td>$' + proTotalPrice + '</td>' +
            '</tr>';
    }
    document.getElementById("mycart").innerHTML += infor;
}
