<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>MobliePhone</h3>
		<c:if test="${not empty editpr}">
		<form method="POST" action="${pageContext.request.contextPath}/editProduct">
            <input type="hidden" name="idpr" value="${editpr.id}" />
            <table border="0">
               <tr>
                  <td>ID</td>
                  <td style="color:red;">${editpr.id}</td>
               </tr>
               <tr>
                  <td>Name</td>
                  <td><input type="text" name="namepr" value="${editpr.name}"/></td>
               </tr>
               <tr>
                  <td>Type</td>
                  <td><input type="text" name="typepr" value="${editpr.type}"/></td>
               </tr>
               <tr>
                  <td>Cost</td>
                  <td><input type="text" name="costpr" value="${editpr.cost}"/></td>
               </tr>
               <tr>
                  <td>Amount</td>
                  <td><input type="text" name="amountpr" value="${editpr.amount}"/></td>
               </tr>
               <tr>
                  <td>P1</td>
                  <td><input type="text" name="prp1" value="${editpr.p1}"/></td>
               </tr>
               <tr>
                  <td>P2</td>
                  <td><input type="text" name="prp2" value="${editpr.p2}"/></td>
               </tr>
               <tr>
                  <td>P3</td>
                  <td><input type="text" name="prp3" value="${editpr.p3}"/></td>
               </tr>
               <tr>
                  <td>P4</td>
                  <td><input type="text" name="prp4" value="${editpr.p4}"/></td>
               </tr>
               <tr>
                  <td>Describe</td>
                  <td><input type="text" name="despr" value="${editpr.describe}"/></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/productList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
		</c:if>
		
		
</body>
</html>