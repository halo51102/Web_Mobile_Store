<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Scriptlet</title>
</head>
<body>
<p>
<% String message ="JSP Scriptlet"; %>
<% out.print(message); %>
</p>
<p>Today's date: <%= (new java.util.Date()).toLocaleString() %></p>

<form action="login" method="post">
Username: <input type="text" name ="name" ><br>
Password: <input type="password" name="password"><br>
<input type="submit" value="login" >
</form>
</body>
</html>