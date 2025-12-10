<%@page import="com.pack1.model.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<center>
	
	<h1>
			<%
				AdminBean ab=(AdminBean)session.getAttribute("AdminBean");
				out.println("WelCome "+ab.getFname()+"<br><br>");
			%>
			
			<a href="AddProduct.html">Add Product</a> <br>
			<a href="view1">View Product</a> <br>
			<a href="logout">Logout</a> <br>
	</h1>
</body>
</html>