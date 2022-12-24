<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	crossorigin="anonymous">
<link rel="stylesheet" href="/WebBanDienThoai/views/css/admin/admin.css">
<script src="/WebBanDienThoai/views/script.js"></script>
</head>
<body>
	<header>
		<h2>Mobile Store - Admin</h2>
	</header>

	<!-- Menu -->
	<c:if test="${not empty ssid2}">
		<aside class="sidebar">
			<ul class="nav">
				<li class="nav-title">MENU</li>
				
				<li class="nav-item"><a class="nav-link"><i
						class="fa fa-mobile"></i> Điện Thoại</a></li>
				<li class="nav-item"><a class="nav-link"><i
						class="fa fa-headphones"></i> Phụ Kiện</a></li>
				<li class="nav-item"><a class="nav-link"><i
						class="fa fa-gift"></i> Voucher</a></li>
				<li class="nav-item"><a class="nav-link"><i
						class="fa fa-file-text-o"></i> Đơn Hàng</a></li>
				<li class="nav-item"><a class="nav-link"><i
						class="fa fa-address-book-o"></i> Tài Khoản</a></li>
				<li class="nav-item">
					<hr>
				</li>
				<li class="nav-item"><a href="home" class="nav-link"
					> <i
						class="fa fa-arrow-left"></i> Đăng xuất
				</a></li>
			</ul>
		</aside>

		<!-- KHUNG HIỂN THỊ -->
		<div class="main">

			<!-- Điện thoại -->
			<div class="dienthoai">
				<table class="table-header">
					<tr>
						<!-- Theo độ rộng của table content -->
						
						<th title="Sắp xếp" style="width: 15%"
							onclick="sortProductsTable('masp')">Mã</th>
						<th title="Sắp xếp" style="width: 40%"
							onclick="sortProductsTable('ten')">Tên</th>
						<th title="Sắp xếp" style="width: 15%"
							onclick="sortProductsTable('gia')">Giá</th>
						<th title="Sắp xếp" style="width: 15%"
							onclick="sortProductsTable('khuyenmai')">Danh mục</th>
						<th style="width: 15%">Hành động</th>
					</tr>
				</table>
		
				<div class="table-content">
					<table class="table-outline hideImg">

						<c:forEach items="${ProductList}" var="product">
							<tr>
								
								<td style="width: 15%">${product.id}</td>
								<td style="width: 40%">${product.name}</td>
								<td style="width: 15%">${product.cost}</td>
								<td style="width: 15%">${product.type}</td>
								<td style="width: 15%">
								    
									<div class="tooltip">
										<i class="fa fa-wrench" onclick="document.getElementById('khungSuaSanPham').style.transform = 'scale(1)'"></i> <span
											class="tooltiptext">Sửa</span>
									</div>
									
									<div class="tooltip">
										<i class="fa fa-trash" onclick="xoaSanPham(${product.id})"></i> <span
											class="tooltiptext">Xóa</span>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>

				<div class="table-footer">
					<select name="kieuTimSanPham">
						<option value="ma">Tìm theo mã</option>
						<option value="ten">Tìm theo tên</option>
					</select> <input type="text" placeholder="Tìm kiếm..."
						onkeyup="timKiemSanPham(this)">
					<button
						onclick="document.getElementById('khungThemSanPham').style.transform = 'scale(1)'; autoMaSanPham()">
						<i class="fa fa-plus-square"></i> Thêm điện thoại
					</button>
				</div>

				<div id="khungThemSanPham" class="overlay">
					<span class="close"
						onclick="this.parentElement.style.transform = 'scale(0)';">&times;</span>
					<form method="POST"
						action="${pageContext.request.contextPath}/productList"
						name="addProduct" onsubmit="return validateForm()">					
						<table
							class="overlayTable table-outline table-content table-header">
							<tr>
								<th colspan="2">Thêm Sản Phẩm</th>
							</tr>
							<tr>
								<td>Mã sản phẩm:</td>
								<td><input type="text" name="idpr"></td>
							</tr>
							<tr>
								<td>Tên sản phẩm:</td>
								<td><input type="text" name="namepr"></td>
							</tr>
							<tr>
								<td>Danh mục:</td>
								<td><select name="typepr"
									onchange="autoMaSanPham(this.value)">
										<script>
                                    var company = ["Apple", "Samsung", "Oppo", "Nokia", "Huawei", "Xiaomi","Realme", "Vivo", "Philips", "Mobell", "Mobiistar", "Itel","Coolpad", "HTC", "Motorola"];
                                    for(var c of company) {
                                        document.writeln(`<option value="`+c+`">`+c+`</option>`);
                                    }
                                </script>
								</select></td>
							</tr>
							<tr>
								<td>Giá tiền:</td>
								<td><input type="text" name="costpr"></td>
							</tr>
							<tr>
								<td>Số lượng:</td>
								<td><input type="text" name="amountpr"></td>
							</tr>
							<tr>
								<td>Link Hình 1:</td>
								<td><input type="text" name="prp1"></td>
							</tr>
							<tr>
								<td>Link Hình 2:</td>
								<td><input type="text" name="prp2"></td>
							</tr>
							<tr>
								<td>Link Hình 3:</td>
								<td><input type="text" name="prp3"></td>
							</tr>
							<tr>
								<td>Link Hình 4:</td>
								<td><input type="text" name="prp4"></td>
							</tr>
							<tr>
								<td>Mô tả:</td>
								<td><input type="text" name="despr"></td>
							</tr>
							<tr>
								<td colspan="2" class="table-footer">
									<button onclick="themSanPham()">THÊM</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div id="khungSuaSanPham" class="overlay">
					<span class="close"
						onclick="this.parentElement.style.transform = 'scale(0)';">&times;</span>
					<form method="POST"
						action="${pageContext.request.contextPath}/editProduct"
						name="editProduct" onsubmit="return validateForm()">
						<table
							class="overlayTable table-outline table-content table-header">
							<tr>
								<th colspan="2">Sửa Sản Phẩm</th>
							</tr>
							<tr>
								<td>Mã sản phẩm:</td>
								<td><input type="text" name="idpr"></td>
							</tr>
							<tr>
								<td>Tên sản phẩm:</td>
								<td><input type="text" name="namepr"></td>
							</tr>
							<tr>
								<td>Danh mục:</td>
								<td><select name="typepr"
									onchange="autoMaSanPham(this.value)">
										<script>
                                    var company = ["Apple", "Samsung", "Oppo", "Nokia", "Huawei", "Xiaomi","Realme", "Vivo", "Philips", "Mobell", "Mobiistar", "Itel","Coolpad", "HTC", "Motorola"];
                                    for(var c of company) {
                                        document.writeln(`<option value="`+c+`">`+c+`</option>`);
                                    }
                                </script>
								</select></td>
							</tr>
							<tr>
								<td>Giá tiền:</td>
								<td><input type="text" name="costpr"></td>
							</tr>
							<tr>
								<td>Số lượng:</td>
								<td><input type="text" name="amountpr"></td>
							</tr>
							<tr>
								<td>Link Hình 1:</td>
								<td><input type="text" name="prp1"></td>
							</tr>
							<tr>
								<td>Link Hình 2:</td>
								<td><input type="text" name="prp2"></td>
							</tr>
							<tr>
								<td>Link Hình 3:</td>
								<td><input type="text" name="prp3"></td>
							</tr>
							<tr>
								<td>Link Hình 4:</td>
								<td><input type="text" name="prp4"></td>
							</tr>
							<tr>
							<tr>
								<td>Mô tả:</td>
								<td><input type="text" name="despr"></td>
							</tr>
							<tr>
								<td colspan="2" class="table-footer">
									<button onclick="themSanPham()">SỬA</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<!-- // dienthoai ----------------------------------------------------------------------------------->


			<!-- Phụ kiện --------------------------------------------------------------------------------------->
			<div class="phukien">
				<table class="table-header">
					<tr>
						<!-- Theo độ rộng của table content -->
						
						<th title="Sắp xếp" style="width: 15%"
							onclick="sortProductsTable('masp')">Mã</th>
						<th title="Sắp xếp" style="width: 40%"
							onclick="sortProductsTable('ten')">Tên</th>
						<th title="Sắp xếp" style="width: 15%"
							onclick="sortProductsTable('gia')">Giá</th>
						<th title="Sắp xếp" style="width: 15%"
							onclick="sortProductsTable('khuyenmai')">Danh mục</th>
						<th style="width: 15%">Hành động</th>
					</tr>
				</table>
				<!-- //Load database ở đây, nhớ chừa lại cái Hành động để t chỉnh tiếp -->
				<div class="table-content">
					<table class="table-outline hideImg">

						<c:forEach items="${AccessoryList}" var="product">
							<tr>
								
								<td style="width: 15%">${product.id}</td>
								<td style="width: 40%">${product.name}</td>
								<td style="width: 15%">${product.cost}</td>
								<td style="width: 15%">${product.type}</td>
								<td style="width: 15%">
									<div class="tooltip">
										<i class="fa fa-wrench" onclick="document.getElementById('khungSuaPhuKien').style.transform = 'scale(1)'"></i> <span
											class="tooltiptext">Sửa</span>
									</div>
									<div class="tooltip">
										<i class="fa fa-trash" onclick="xoaSanPham(${product.id})"></i> <span
											class="tooltiptext">Xóa</span>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>

				<div class="table-footer">
					<select name="kieuTimSanPham">
						<option value="ma">Tìm theo mã</option>
						<option value="ten">Tìm theo tên</option>
					</select> <input type="text" placeholder="Tìm kiếm..."
						onkeyup="timKiemSanPham(this)">
					<button
						onclick="document.getElementById('khungThemPhuKien').style.transform = 'scale(1)'; autoMaSanPham()">
						<i class="fa fa-plus-square"></i> Thêm phụ kiện
					</button>
				</div>

				<div id="khungThemPhuKien" class="overlay">
					<span class="close"
						onclick="this.parentElement.style.transform = 'scale(0)';">&times;</span>
					<form method="POST"
						action="${pageContext.request.contextPath}/accessoryList"
						name="addProduct" onsubmit="return validateForm()">
						<table
							class="overlayTable table-outline table-content table-header">
							<tr>
								<th colspan="2">Thêm Phụ Kiện</th>
							</tr>
							<tr>
								<td>Mã phụ kiện:</td>
								<td><input type="text" name="idpr"></td>
							</tr>
							<tr>
								<td>Tên phụ kiện:</td>
								<td><input type="text" name="namepr"></td>
							</tr>
							<tr>
								<td>Danh mục:</td>
								<td><select name="typepr"
									onchange="autoMaSanPham(this.value)">
										<script>
                                    var company = ["Apple", "Samsung", "Oppo", "Nokia", "Huawei", "Xiaomi","Realme", "Vivo", "Philips", "Mobell", "Mobiistar", "Itel","Coolpad", "HTC", "Motorola"];
                                    for(var c of company) {
                                        document.writeln(`<option value="`+c+`">`+c+`</option>`);
                                    }
                                </script>
								</select></td>
							</tr>
							<tr>
								<td>Giá tiền:</td>
								<td><input type="text" name="costpr"></td>
							</tr>
							<tr>
								<td>Số lượng:</td>
								<td><input type="text" name="amountpr"></td>
							</tr>
							<tr>
								<td>Link Hình 1:</td>
								<td><input type="text" name="prp1"></td>
							</tr>
							<tr>
								<td>Link Hình 2:</td>
								<td><input type="text" name="prp2"></td>
							</tr>
							<tr>
								<td>Link Hình 3:</td>
								<td><input type="text" name="prp3"></td>
							</tr>
							<tr>
								<td>Link Hình 4:</td>
								<td><input type="text" name="prp4"></td>
							</tr>
							<tr>
							<tr>
								<td>Mô tả:</td>
								<td><input type="text" name="despr"></td>
							</tr>
							<tr>
								<td colspan="2" class="table-footer">
									<button onclick="themSanPham()">THÊM</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div id="khungSuaPhuKien" class="overlay">
					<span class="close"
						onclick="this.parentElement.style.transform = 'scale(0)';">&times;</span>
					<form method="POST"
						action="${pageContext.request.contextPath}/editProduct"
						name="editProduct" onsubmit="return validateForm()">
						<table
							class="overlayTable table-outline table-content table-header">
							<tr>
								<th colspan="2">Sửa Phụ Kiện</th>
							</tr>
							<tr>
								<td>Mã sản phẩm:</td>
								<td><input type="text" name="idpr" value="${editpr.id}"></td>
							</tr>
							<tr>
								<td>Tên sản phẩm:</td>
								<td><input type="text" name="namepr"></td>
							</tr>
							<tr>
								<td>Danh mục:</td>
								<td><select name="typepr"
									onchange="autoMaSanPham(this.value)">
										<script>
                                    var company = ["Apple", "Samsung", "Oppo", "Nokia", "Huawei", "Xiaomi","Realme", "Vivo", "Philips", "Mobell", "Mobiistar", "Itel","Coolpad", "HTC", "Motorola"];
                                    for(var c of company) {
                                        document.writeln(`<option value="`+c+`">`+c+`</option>`);
                                    }
                                </script>
								</select></td>
							</tr>
							<tr>
								<td>Giá tiền:</td>
								<td><input type="text" name="costpr"></td>
							</tr>
							<tr>
								<td>Số lượng:</td>
								<td><input type="text" name="amountpr"></td>
							</tr>
							<tr>
								<td>Link Hình 1:</td>
								<td><input type="text" name="prp1"></td>
							</tr>
							<tr>
								<td>Link Hình 2:</td>
								<td><input type="text" name="prp2"></td>
							</tr>
							<tr>
								<td>Link Hình 3:</td>
								<td><input type="text" name="prp3"></td>
							</tr>
							<tr>
								<td>Link Hình 4:</td>
								<td><input type="text" name="prp4"></td>
							</tr>
							<tr>
							<tr>
								<td>Mô tả:</td>
								<td><input type="text" name="despr"></td>
							</tr>
							<tr>
								<td colspan="2" class="table-footer">
									<button onclick="themSanPham()">SỬA</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<!-- // phukien ---------------------------------------------------------------->

			<!-- Voucher ------------------------------------------------------------------->
			<div class="voucher">
				<table class="table-header">
					<tr>
						<!-- Theo độ rộng của table content -->
						<th title="Sắp xếp" style="width: 10%"
							onclick="sortProductsTable('stt')">Mã voucher</th>
						<th title="Sắp xếp" style="width: 10%"
							onclick="sortProductsTable('masp')">Tên voucher</th>
						<th title="Sắp xếp" style="width: 20%"
							onclick="sortProductsTable('ten')">Guide</th>
						<th title="Sắp xếp" style="width: 10%"
							onclick="sortProductsTable('gia')">TG bắt đầu</th>
						<th title="Sắp xếp" style="width: 10%"
							onclick="sortProductsTable('khuyenmai')">TG kết thúc</th>
						<th title="Sắp xếp" style="width: 5%"
							onclick="sortProductsTable('khuyenmai')">Giảm (%)</th>
						<th title="Sắp xếp" style="width: 10%"
							onclick="sortProductsTable('khuyenmai')">Giảm (VNĐ)</th>
						<th title="Sắp xếp" style="width: 15%"
							onclick="sortProductsTable('khuyenmai')">Điều kiện</th>
						<th title="Sắp xếp" style="width: 5%"
							onclick="sortProductsTable('khuyenmai')">Số lượng</th>
						<th style="width: 5%">Hành động</th>
					</tr>
				</table>
				<!-- //Load database ở đây, nhớ chừa lại cái Hành động để t chỉnh tiếp -->
				<div class="table-content">
					<table class="table-outline hideImg">

						<c:forEach items="${VoucherList}" var="voucher">
							<tr>
								<td style="width: 10%">${voucher.id}</td>
								<td style="width: 10%">${voucher.tenVC}</td>
								<td style="width: 20%">${voucher.HDSD}</td>
								<td style="width: 10%">${voucher.thoiGianBD}</td>
								<td style="width: 10%">${voucher.thoiGianKT}</td>
								<td style="width: 5%">${voucher.tienGiamPT}</td>
								<td style="width: 10%">${voucher.tienGiamDong}</td>
								<td style="width: 15%">${voucher.dieuKien}</td>
								<td style="width: 5%">${voucher.soLuong}</td>
								<td style="width: 5%">
									<div class="tooltip">
										<i class="fa fa-wrench" onclick="addKhungSuaSanPham()"></i> <span
											class="tooltiptext">Sửa</span>
									</div>
									<div class="tooltip">
										<i class="fa fa-trash" onclick="xoaVoucher(${voucher.id})"></i> <span
											class="tooltiptext">Xóa</span>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>

				<div class="table-footer">
					<button
						onclick="document.getElementById('khungThemVoucher').style.transform = 'scale(1)'; autoMaSanPham()">
						<i class="fa fa-plus-square"></i> Thêm voucher
					</button>
				</div>

				<div id="khungThemVoucher" class="overlay">
					<span class="close"
						onclick="this.parentElement.style.transform = 'scale(0)';">&times;</span>
					<form method="POST"
						action="${pageContext.request.contextPath}/voucherList"
						name="addVoucher" onsubmit="return validateForm()">
						<table
							class="overlayTable table-outline table-content table-header">
							<tr>
								<th colspan="2">Thêm Voucher</th>
							</tr>
							<tr>
								<td>Mã voucher:</td>
								<td><input type="text" name="id"></td>
							</tr>
							<tr>
								<td>Tên voucher:</td>
								<td><input type="text" name="TenVC"></td>
							</tr>
							<tr>
								<td>HDSD:</td>
								<td><input type="text" name="HDSD"></td>
							</tr>
							<tr>
								<td>Thời gian bắt đầu:</td>
								<td><input type="text" name="ThoiGianBD"></td>
							</tr>
							<tr>
								<td>Thời gian kết thúc:</td>
								<td><input type="text" name="ThoiGianBD"></td>
							</tr>
							<tr>
								<td>Giảm (%):</td>
								<td><input type="text" name="ThoiGianBD"></td>
							</tr>
							<tr>
								<td>Giảm (VNĐ):</td>
								<td><input type="text" name="ThoiGianBD"></td>
							</tr>
							<tr>
								<td>Điều kiện:</td>
								<td><input type="text" name="ThoiGianBD"></td>
							</tr>
							<tr>
								<td>Số lượng:</td>
								<td><input type="text" name="ThoiGianBD"></td>
							</tr>
							<tr>
								<td colspan="2" class="table-footer">
									<button onclick="themVoucher()">THÊM</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div id="khungSuaVoucher" class="overlay"></div>
			</div>
			<!-- // sanpham -->

			<!-- Đơn Hàng -->
			<div class="donhang">
				<table class="table-header">
					<tr>
						<!-- Theo độ rộng của table content -->

						<th title="Sắp xếp" style="width: 13%"
							onclick="sortDonHangTable('madon')">Mã đơn <i
							class="fa fa-sort"></i></th>
						<th title="Sắp xếp" style="width: 12%"
							onclick="sortDonHangTable('khach')">Khách <i
							class="fa fa-sort"></i></th>
						<th title="Sắp xếp" style="width: 20%"
							onclick="sortDonHangTable('sanpham')">Sản phẩm <i
							class="fa fa-sort"></i></th>
						<th title="Sắp xếp" style="width: 15%"
							onclick="sortDonHangTable('tongtien')">Tổng tiền <i
							class="fa fa-sort"></i></th>
						<th title="Sắp xếp" style="width: 10%"
							onclick="sortDonHangTable('ngaygio')">Ngày giờ <i
							class="fa fa-sort"></i></th>
						<th title="Sắp xếp" style="width: 10%"
							onclick="sortDonHangTable('trangthai')">Trạng thái <i
							class="fa fa-sort"></i></th>
						<th style="width: 10%">Hành động</th>
					</tr>
				</table>

				<div class="table-content">
					<table class="table-outline hideImg">
					<c:forEach items="${BillList}" var="bill">
							<tr>
								<td style="width: 13%">${bill.idb}</td>
								<td style="width: 12%">${bill.username}</td>
								<td style="width: 20%">${bill.tenpr}</td>
								<td style="width: 15%">${bill.sumpaid}</td>
								<td style="width: 10%">${bill.date}</td>
								<td style="width: 10%">${bill.status}</td>
								<td style="width: 10%">
									<div class="tooltip">
										<i class="fa fa-trash" onclick=""></i> <span
											class="tooltiptext">Xóa</span>
									</div>
								</td>
							</tr>
						</c:forEach>
						</table>
				</div>

				<div class="table-footer">
					<div class="timTheoNgay">
						Từ ngày: <input type="date" id="fromDate"> Đến ngày: <input
							type="date" id="toDate">

						<button onclick="locDonHangTheoKhoangNgay()">
							<i class="fa fa-search"></i> Tìm
						</button>
					</div>

					<select name="kieuTimDonHang">
						<option value="ma">Tìm theo mã đơn</option>
						<option value="khachhang">Tìm theo tên khách hàng</option>
						<option value="trangThai">Tìm theo trạng thái</option>
					</select> <input type="text" placeholder="Tìm kiếm..."
						onkeyup="timKiemDonHang(this)">
				</div>

			</div>
			<!-- // don hang -->

			<!-- Tài Khoản -->
			<div class="taikhoan">
				<table class="table-header">
					<tr>
						<!-- Theo độ rộng của table content -->
						
						<th title="Sắp xếp" style="width: 30%"
							onclick="sortKhachHangTable('hoten')">Tài Khoản <i
							class="fa fa-sort"></i></th>
						<th title="Sắp xếp" style="width: 25%"
							onclick="sortKhachHangTable('email')">Mật khẩu <i
							class="fa fa-sort"></i></th>
						<th title="Sắp xếp" style="width: 20%"
							onclick="sortKhachHangTable('taikhoan')">Giới tính <i
							class="fa fa-sort"></i></th>
						<th title="Sắp xếp" style="width: 15%"
							onclick="sortKhachHangTable('matkhau')">Loại <i
							class="fa fa-sort"></i></th>
						<th style="width: 10%">Hành động</th>
					</tr>
				</table>

				<div class="table-content">
					<table class="table-outline hideImg">
						<c:forEach items="${UserList}" var="user">
							<tr>
								
								<td style="width: 30%">${user.name}</td>
								<td style="width: 25%">${user.password}</td>
								<td style="width: 20%">${user.gender}</td>
								<td style="width: 15%">${user.type}</td>
								<td style="width: 10%">
									<div class="tooltip">
										<i class="fa fa-wrench" onclick="addKhungSuaSanPham()"></i> <span
											class="tooltiptext">Sửa</span>
									</div>
									<div class="tooltip">
										<i class="fa fa-trash" onclick="xoaTaiKhoan(${user.name})"></i> <span
											class="tooltiptext">Xóa</span>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>

				
			</div>
			<!-- // khach hang -->
		</div>
		<!-- // main -->
	</c:if>

	<!-- // JS Code -->
	<script>
        addEventChangeTab();
        
        function xoaSanPham(id)  {
            var result = confirm("Bạn chắc chắn muốn xóa sản phẩm này?");
            if(result)  {            	
          	  window.location.href= "deleteProduct?idpr=" + id;
            } else {
                return false;
            }
        }  
        
        function xoaVoucher(id)  {
            var result = confirm("Bạn chắc chắn muốn xóa voucher này?");
            if(result)  {            	
          	  window.location.href= "deleteVoucher?idv=" + id;
            } else {
                return false;
            }
        }  
        
        function xoaPhuKien(id)  {
            var result = confirm("Bạn chắc chắn muốn xóa sản phẩm này?");
            if(result)  {            	
          	  window.location.href= "deleteAccessory?idpr=" + id;
            } else {
                return false;
            }
        }  
        
        function xoaTaiKhoan(id)  {
            var result = confirm("Bạn chắc chắn muốn xóa tài khoản này?");
            if(result)  {            	
          	  window.location.href= "deleteUser?username=" + id;
            } else {
                return false;
            }
        }  
        
        
    </script>
</body>
</html>