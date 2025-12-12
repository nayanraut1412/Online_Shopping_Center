<%@page import="com.pack1.model.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
.error {
    color: red;
    font-size: 14px;
}
</style>

<script>
function validateForm() {
    document.getElementById("msg").innerHTML = "";  // clear old messages

    let preq = document.getElementById("preq").value;
    let pqty = parseInt(document.getElementById("pqty").value);

    if (preq === "" || preq == null) {
        document.getElementById("msg").innerHTML = "Required quantity cannot be empty.";
        return false;
    }

    preq = parseInt(preq);

    if (preq <= 0) {
        document.getElementById("msg").innerHTML = "Required quantity must be greater than 0.";
        return false;
    }

    if (preq > pqty) {
        document.getElementById("msg").innerHTML = "Required quantity cannot be more than available quantity (" + pqty + ").";
        return false;
    }

    return true;
}

</script>
</head>
<body>
<center>
<h1>
	<%
		ProductBean pb=(ProductBean)session.getAttribute("pbitem");
		out.println("Buy Product <br><br>");
	%>
<form action="buy" method="post" onsubmit="return validateForm()">
	 Product Code: <input type="text" name="pcode" value="<%=pb.getPcode() %>" readonly><br>
	 Product Name: <input type="text" name="pname" value="<%=pb.getPname() %>" readonly><br>
	 Product Company: <input type="text" name="pcompany" value="<%=pb.getPcompany() %>" readonly><br>
	 Product Price: <input type="text" name="pprice" value="<%=pb.getPprice() %>" readonly><br>
	 Product Quantity: <input type="text"  id="pqty" name="pqty" value="<%=pb.getPqty() %>" readonly><br>
	 Product Req: <input type="text" id="preq" name="preq" onkeyup="showRemaining()" required ><br>
     <p id="msg" class="error"></p> <br>


	<input type=submit value="Buy">
	</form>
	
</h1>
</body>
</html>