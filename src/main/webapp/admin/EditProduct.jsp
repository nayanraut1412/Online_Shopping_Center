<%@page import="com.pack1.model.ProductBean"%>
<%@page import="java.util.ArrayList"%>
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
		AdminBean abean=(AdminBean)session.getAttribute("AdminBean");
		ProductBean pb=(ProductBean)request.getAttribute("pbitem");
		out.println("Hello "+abean.getFname()+" please edit<br>");
		
		
	%>
	
	<form action="update" method="post">
	Product Price <input type="text" name="pprice" value="<%=pb.getPprice() %>" ><br>
	Product Quantity <input type="text" name="pqty" value="<%=pb.getPqty() %>" ><br>
	<input type="hidden" name="pcode" value="<%=pb.getPcode() %>">

	<input type="submit" value="Update">
	</form>
</h1>
</body>
</html>