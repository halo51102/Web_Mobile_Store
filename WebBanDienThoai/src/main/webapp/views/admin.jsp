<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
        crossorigin="anonymous">
<link rel="stylesheet" href="/WebBanDienThoai/views/css/admin/admin.css">
<script src="views/script.js"></script>
</head>
<body>
	<header>
        <h2>Mobile Store - Admin</h2>
    </header>

    <!-- Menu -->
    <aside class="sidebar">
        <ul class="nav">
            <li class="nav-title">MENU</li>
            <li class="nav-item"><a class="nav-link active"><i class="fa fa-home"></i> Trang Chủ</a></li>
            <li class="nav-item"><a class="nav-link"><i class="fa fa-th-large"></i> Sản Phẩm</a></li>
            <li class="nav-item"><a class="nav-link"><i class="fa fa-file-text-o"></i> Đơn Hàng</a></li>
            <li class="nav-item"><a class="nav-link"><i class="fa fa-address-book-o"></i> Khách Hàng</a></li>
            <li class="nav-item">
                <hr>
            </li>
            <li class="nav-item">
                <a href="" class="nav-link" onclick="logOutAdmin(); return true;">
                    <i class="fa fa-arrow-left"></i>
                    Đăng xuất (về Trang chủ)
                </a>
            </li>
        </ul>
    </aside>

    <div class="main">
        <div class="home">
            <div class="canvasContainer">
                <canvas id="myChart1"></canvas>
            </div>

            <div class="canvasContainer">
                <canvas id="myChart2"></canvas>
            </div>

            <div class="canvasContainer">
                <canvas id="myChart3"></canvas>
            </div>

            <div class="canvasContainer">
                <canvas id="myChart4"></canvas>
            </div>
        </div>

        <!-- Sản Phẩm -->
        <div class="sanpham">
            <table class="table-header">
                <tr>
                    <!-- Theo độ rộng của table content -->
                    <th title="Sắp xếp" style="width: 5%" onclick="sortProductsTable('stt')">Stt</th>
                    <th title="Sắp xếp" style="width: 10%" onclick="sortProductsTable('masp')">Mã</th>
                    <th title="Sắp xếp" style="width: 40%" onclick="sortProductsTable('ten')">Tên</th>
                    <th title="Sắp xếp" style="width: 15%" onclick="sortProductsTable('gia')">Giá</th>
                    <th title="Sắp xếp" style="width: 15%" onclick="sortProductsTable('khuyenmai')">Danh mục</th>
                    <th style="width: 15%">Hành động</th>
                </tr>
            </table>

            <!-- //Load database ở đây, nhớ chừa lại cái Hành động để t chỉnh tiếp -->
            <div class="table-content">
                <table class="table-outline hideImg">
                    <tr>
                        <td style="width: 5%"> STT </td>
                        <td style="width: 10%"> Mã SP </td>
                        <td style="width: 40%">
                            <a title="Xem chi tiết" target="_blank" href=""> Tên SP </a>
                            <img src=""></img>
                        </td>
                        <td style="width: 15%"> Giá </td>
                        <td style="width: 15%"> Danh mục </td>
                        <td style="width: 15%">
                            <div class="tooltip">
                                <i class="fa fa-wrench" onclick="addKhungSuaSanPham()"></i>
                                <span class="tooltiptext">Sửa</span>
                            </div>
                            <div class="tooltip">
                                <i class="fa fa-trash" onclick="xoaSanPham()"></i>
                                <span class="tooltiptext">Xóa</span>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>

            <div class="table-footer">
                <select name="kieuTimSanPham">
                    <option value="ma">Tìm theo mã</option>
                    <option value="ten">Tìm theo tên</option>
                </select>
                <input type="text" placeholder="Tìm kiếm..." onkeyup="timKiemSanPham(this)">
                <button onclick="document.getElementById('khungThemSanPham').style.transform = 'scale(1)'; autoMaSanPham()">
                    <i class="fa fa-plus-square"></i>
                    Thêm sản phẩm
                </button>
            </div>

            <div id="khungThemSanPham" class="overlay">
                <span class="close" onclick="this.parentElement.style.transform = 'scale(0)';">&times;</span>
                <table class="overlayTable table-outline table-content table-header">
                    <tr>
                        <th colspan="2">Thêm Sản Phẩm</th>
                    </tr>
                    <tr>
                        <td>Mã sản phẩm:</td>
                        <td><input type="text" id="maspThem"></td>
                    </tr>
                    <tr>
                        <td>Tên sản phẩm:</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>Danh mục:</td>
                        <td>
                            <select name="chonCompany" onchange="autoMaSanPham(this.value)">
                                <script>
                                    var company = ["Apple", "Samsung", "Oppo", "Nokia", "Huawei", "Xiaomi","Realme", "Vivo", "Philips", "Mobell", "Mobiistar", "Itel","Coolpad", "HTC", "Motorola"];
                                    for(var c of company) {
                                        document.writeln(`<option value="`+c+`">`+c+`</option>`);
                                    }
                                </script>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Giá tiền:</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>Số lượng:</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>Hình 1:</td>
                        <td>
                            <img class="hinhDaiDien" id="anhDaiDienSanPhamThem" src="">
                            <input type="file" accept="image/*" onchange="capNhatAnhSanPham(this.files, 'anhDaiDienSanPhamThem')">
                        </td>
                    </tr>
                    <tr>
                        <td>Hình 2:</td>
                        <td>
                            <img class="hinhDaiDien" id="anhDaiDienSanPhamThem" src="">
                            <input type="file" accept="image/*" onchange="capNhatAnhSanPham(this.files, 'anhDaiDienSanPhamThem')">
                        </td>
                    </tr>
                    <tr>
                        <td>Hình 3:</td>
                        <td>
                            <img class="hinhDaiDien" id="anhDaiDienSanPhamThem" src="">
                            <input type="file" accept="image/*" onchange="capNhatAnhSanPham(this.files, 'anhDaiDienSanPhamThem')">
                        </td>
                    </tr>
                    <tr>
                        <td>Hình 4:</td>
                        <td>
                            <img class="hinhDaiDien" id="anhDaiDienSanPhamThem" src="">
                            <input type="file" accept="image/*" onchange="capNhatAnhSanPham(this.files, 'anhDaiDienSanPhamThem')">
                        </td>
                    </tr>
                    <tr>
                        <td>Mô tả:</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="table-footer"> <button onclick="themSanPham()">THÊM</button> </td>
                    </tr>
                </table>
            </div>
            <div id="khungSuaSanPham" class="overlay"></div>
        </div> <!-- // sanpham -->

        <!-- Đơn Hàng -->
        <div class="donhang">
            <table class="table-header">
                <tr>
                    <!-- Theo độ rộng của table content -->
                    <th title="Sắp xếp" style="width: 5%" onclick="sortDonHangTable('stt')">Stt <i class="fa fa-sort"></i></th>
                    <th title="Sắp xếp" style="width: 13%" onclick="sortDonHangTable('madon')">Mã đơn <i class="fa fa-sort"></i></th>
                    <th title="Sắp xếp" style="width: 7%" onclick="sortDonHangTable('khach')">Khách <i class="fa fa-sort"></i></th>
                    <th title="Sắp xếp" style="width: 20%" onclick="sortDonHangTable('sanpham')">Sản phẩm <i class="fa fa-sort"></i></th>
                    <th title="Sắp xếp" style="width: 15%" onclick="sortDonHangTable('tongtien')">Tổng tiền <i class="fa fa-sort"></i></th>
                    <th title="Sắp xếp" style="width: 10%" onclick="sortDonHangTable('ngaygio')">Ngày giờ <i class="fa fa-sort"></i></th>
                    <th title="Sắp xếp" style="width: 10%" onclick="sortDonHangTable('trangthai')">Trạng thái <i class="fa fa-sort"></i></th>
                    <th style="width: 10%">Hành động</th>
                </tr>
            </table>

            <div class="table-content">
            </div>

            <div class="table-footer">
                <div class="timTheoNgay">
                    Từ ngày: <input type="date" id="fromDate">
                    Đến ngày: <input type="date" id="toDate">

                    <button onclick="locDonHangTheoKhoangNgay()"><i class="fa fa-search"></i> Tìm</button>
                </div>

                <select name="kieuTimDonHang">
                    <option value="ma">Tìm theo mã đơn</option>
                    <option value="khachhang">Tìm theo tên khách hàng</option>
                    <option value="trangThai">Tìm theo trạng thái</option>
                </select>
                <input type="text" placeholder="Tìm kiếm..." onkeyup="timKiemDonHang(this)">
            </div>

        </div> <!-- // don hang -->

        <!-- Khách hàng -->
        <div class="khachhang">
            <table class="table-header">
                <tr>
                    <!-- Theo độ rộng của table content -->
                    <th title="Sắp xếp" style="width: 5%" onclick="sortKhachHangTable('stt')">Stt <i class="fa fa-sort"></i></th>
                    <th title="Sắp xếp" style="width: 15%" onclick="sortKhachHangTable('hoten')">Họ tên <i class="fa fa-sort"></i></th>
                    <th title="Sắp xếp" style="width: 20%" onclick="sortKhachHangTable('email')">Email <i class="fa fa-sort"></i></th>
                    <th title="Sắp xếp" style="width: 20%" onclick="sortKhachHangTable('taikhoan')">Tài khoản <i class="fa fa-sort"></i></th>
                    <th title="Sắp xếp" style="width: 10%" onclick="sortKhachHangTable('matkhau')">Mật khẩu <i class="fa fa-sort"></i></th>
                    <th style="width: 10%">Hành động</th>
                </tr>
            </table>

            <div class="table-content">
            </div>

            <div class="table-footer">
                <select name="kieuTimKhachHang">
                    <option value="ten">Tìm theo họ tên</option>
                    <option value="email">Tìm theo email</option>
                    <option value="taikhoan">Tìm theo tài khoản</option>
                </select>
                <input type="text" placeholder="Tìm kiếm..." onkeyup="timKiemNguoiDung(this)">
                <button onclick="openThemNguoiDung()"><i class="fa fa-plus-square"></i> Thêm người dùng</button>
            </div>
        </div> <!-- // khach hang -->
    </div> <!-- // main -->
    
    <!-- // JS Code -->
    <script>
        addEventChangeTab();
    </script>
</body>
</html>