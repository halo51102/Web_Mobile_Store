<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<script type="text/javascript">         
    function testConfirmDialog(id)  {
   	 
        var result = confirm("Bạn chắc chắn muốn xóa môn học này?");

        if(result)  {            	
      	  window.location.href= "deleteProduct?idpr=" + id;
      	 
        } else {
            return false;
        }
   }  
      </script>

</head>
<body>
<div>
		<h3>MobliePhone</h3>
		
		<form method="POST" action="${pageContext.request.contextPath}/productList"
          name="addProduct" onsubmit="return validateForm()" >
            <table border="0">
               <tr>
                  <td>ID</td>
                  <td><input type="text" name="idpr"/></td>
               </tr>
               <tr>
                  <td>Name</td>
                  <td><input type="text" name="namepr" /></td>
               </tr>
               <tr>
                  <td>Type</td>
                  <td><input type="text" name="typepr"/></td>
               </tr>
               <tr>
                  <td>Cost</td>
                  <td><input type="text" name="costpr"/></td>
               </tr>
               <tr>
                  <td>Amount</td>
                  <td><input type="text" name="amountpr"/></td>
               </tr>
               <tr>
                  <td>P1</td>
                  <td><input type="text" name="prp1"/></td>
               </tr>
               <tr>
                  <td>P2</td>
                  <td><input type="text" name="prp2"/></td>
               </tr>
               <tr>
                  <td>P3</td>
                  <td><input type="text" name="prp3"/></td>
               </tr>
               <tr>
                  <td>P4</td>
                  <td><input type="text" name="prp4"/></td>
               </tr>
               <tr>
                  <td>Describe</td>
                  <td><input type="text" name="despr"/></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/productList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
		
		
		
		<p style="color: red;">${errorString}</p>
		<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
			<th>Category</th>
			<th>Cost</th>
			<th>Amount</th>
			<th>Photos1</th>			
			<th>Photos2</th>			
			<th>Photos3</th>			
			<th>Photos4</th>
			<th>Describe</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${ProductList}"  var="product" >
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.type}</td>
				<td>${product.category}</td>
				<td>${product.cost}</td>
				<td>${product.amount}</td>
				<td><a href="${product.p1}">Data</a></td>
				<td><a href="${product.p2}">Data</a></td>
				<td><a href="${product.p3}">Data</a></td>
				<td><a href="${product.p4}">Data</a></td>
				<td>${product.describe}</td>
				<td><a href="editProduct?idpr=${product.id}">Edit</a></td>
				<td><a href="#" onclick="testConfirmDialog(${product.id});">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>