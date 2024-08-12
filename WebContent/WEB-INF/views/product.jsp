<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="add-product" method="post" style="border:1px solid #ccc">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

	<label for="ProductId"><b>ProductId</b></label>
    <input type="text" placeholder="ProductId" name="productId" required>

    <label for="Name"><b>Name</b></label>
    <input type="text" placeholder="Name" name="productName" required>

    <label for="price"><b>price</b></label>
    <input type="number" placeholder="price" name="price" required>

    <label for="categoryName"><b>categoryName</b></label>
    <input type="text" placeholder="categoryName" name="categoryName" required>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form></body>
</html>