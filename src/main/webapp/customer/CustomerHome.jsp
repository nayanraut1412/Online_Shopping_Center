<%@page import="com.pack1.model.CustomerBean"%>
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
	 	 CustomerBean cb=(CustomerBean)session.getAttribute("CustomerBeam");
	 	 out.println("Welcome "+cb.getFname()+"<br><br>");
	 %>
	 
	 <a href="view">View Product</a><br>
	<a href="logout">Logout</a>
</h1>

	
</body>
</html>