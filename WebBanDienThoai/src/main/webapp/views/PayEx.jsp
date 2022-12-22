<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><form method="POST" action="${pageContext.request.contextPath}/payment?idb=${NewBill.idb}">
<h4>Số hóa đơn: ${NewBill.idb}</h4>
            <table border="0">
               <tr>
                  <td>Tài khoản</td>
                  <td>${NewBill.username}</td>
               </tr>
               <tr>
                  <td>ID Sản phẩm</td>
                  <td>${NewBill.idpr}</td>
               </tr>
               <tr>
                  <td>Tên sản phẩm</td>
                  <td>${NewBill.tenpr}</td>
               </tr>
               <tr>
                  <td>Số lượng mua</td>
                  <td>${NewBill.slpr}</td>
               </tr>
               <tr>
                  <td>Tổng tiền</td>
                  <td>${NewBill.sumpaid}</td>
               </tr>
               <tr>
                  <td>Ngày mua</td>
                  <td>${NewBill.date}</td>
               </tr>
               <tr>
                  <td>Trạng thái</td>
                  <td>${NewBill.status}</td>
               </tr>
               <tr>
                  <td>Tên khách hàng</td>
                  <td><input type="text" name="tenkh" value="${NewBill.tenkh}"/></td>
               </tr>
               <tr>
                  <td>SĐT người nhận</td>
                  <td><input type="text" name="sdt" value="${NewBill.sdt}"/></td>
               </tr>
               <tr>
                  <td>Địa chỉ nhận</td>
                  <td><input type="text" name="address" value="${NewBill.address}"/></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/home">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
</body>
</html>