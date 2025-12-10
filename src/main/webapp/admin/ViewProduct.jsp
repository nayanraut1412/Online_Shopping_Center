<%@page import="java.util.Iterator"%>
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
		AdminBean ab=(AdminBean)session.getAttribute("AdminBean");
		ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("ProductList");
	
		out.println("Hello "+ab.getFname()+" these are your product details <br><br>");
		
		if(al.size()==0)
		{
			out.println("Product Inventory empty");
		}
		else
		{
			Iterator<ProductBean> i=al.iterator();
			while(i.hasNext())
			{
				ProductBean pb=i.next();
				out.println(pb.getPcode()+" "+pb.getPname()+" "+pb.getPcompany()+" "+pb.getPprice()+" "+pb.getPqty()
				+" " +"<a href='edit?pcode="+pb.getPcode()+"'>Edit</a>"
				+" "+"<a href='delete?pcode="+pb.getPcode()+"'>Delete</a>"+"<br><br>");
			}
		
		}
		
		
	
	%>
</h1>


</body>
</html>