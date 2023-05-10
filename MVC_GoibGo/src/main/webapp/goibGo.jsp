<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>YOUR BILL</title>
</head>
<body>
<%
   String from= (String) request.getAttribute("from");
   String to =(String) request.getAttribute("to");
   double price= (double) request.getAttribute("price");
   int no= (int) request.getAttribute("no");
%>
<h1>Tickit Booked</h1>
<h3>From: <%=from %>  To: <%=to %></h3>
<h3>Number of tikict : <%=no %></h3>
<h3> Total bill: <%=price %></h3> 
</body>
</html>