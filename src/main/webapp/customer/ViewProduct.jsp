<%@page import="com.pack1.model.CustomerBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.pack1.model.ProductBean"%>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("ProductList");
		
		out.println("Welcome "+cb.getFname()+"<br><br>");
		
		if(al.size()==0)
		{
			out.println("No Product Now Currently");
		}
		else
		{
			Iterator<ProductBean> i=al.iterator();
			while(i.hasNext())
			{
				ProductBean pb=i.next();
				out.println(pb.getPcode()+" "+pb.getPname()+" "+pb.getPcompany()+" "+pb.getPprice()+" "+pb.getPqty()
				+" " +"<a href='view?pcode="+pb.getPcode()+"'>Buy</a>"+"<br>"
						);
			}
		
		}
	%>
		<a href="logout">Logout</a>
	
</h1>
</body>
</html>