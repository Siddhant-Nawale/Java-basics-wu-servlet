<%@page import="com.wu.ecommerce.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>hello i am 
<% 
User user = (User) session.getAttribute("user");
out.print(user);
%>
</h1>
<h1> Welcome <%= user.getUserId() %></h1>

<h2><a href="logout">logout</a></h2>
</body>
</html>