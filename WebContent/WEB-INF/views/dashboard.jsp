<%@page import="com.wu.ecommerce.dto.Product"%>
<%@page import="java.util.List"%>
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
<h1>hello i am idk
</h1> 
<table style="border:1px black solid">
<%
User user = (User) session.getAttribute("user");
out.print(user);

List<Product> productList = (List<Product>)application.getAttribute("productList");
%>
<thead>
<th  style="border:1px black solid">ProductID</td>
<th style="border:1px black solid">ProductName</td>
<th  style="border:1px black solid">Price</td>
<th  style="border:1px black solid">Category Name</td>
</thead>
<%
for(Product pro:productList){
%>


<tr>
<td  style="border:1px black solid; text-align: center;"><%out.println(pro.getProductId()); %></td>
<td style="border:1px black solid;text-align: center;"><%out.println(pro.getProductName()); %></td>
<td  style="border:1px black solid;text-align: center;"><%out.println(pro.getPrice()); %></td>
<td  style="border:1px black solid;text-align: center;"><%out.println(pro.getCategoryName()); %></td>
</tr>
<%} %>
</table>


<h2><a href="logout">logout</a></h2>
</body>
</html>