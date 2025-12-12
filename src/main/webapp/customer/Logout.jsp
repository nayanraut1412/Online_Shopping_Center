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


	<%
		session.invalidate();
		out.println("<h1>Customer Logout Sucessfully!!</h1><br><br>");
	
	%>
	
<h1>
	 <a href="${pageContext.request.contextPath}/admin/AdminLogin.html">Admin Login</a><br>
     <a href="${pageContext.request.contextPath}/customer/CustomerLogin.html">Customer Login</a>
 
</h1>

</body>
</html>