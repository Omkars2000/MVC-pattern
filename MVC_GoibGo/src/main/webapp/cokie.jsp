<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your All Cookies</title>
</head>
<body>
<%
Cookie[] data=  request.getCookies();

for(int i=0;i<data.length;i++){
	String name=data[i].getName();
	String val=data[i].getValue();
	%>
	<h2><%=name%>  <%=val %></h2>
	<% 
}
%>
</body>
</html>