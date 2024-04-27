<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<form action="update" method="post">
    <!-- Trường ẩn để chứa giá trị id -->
    <input type="hidden" name="id" value="${product.getId()}">
    <label for="name">Name:</label>
    <input type="text" id="name" value="${product.getName()}" name="nameProduct" >
    <br>
    <label for="price">Price:</label>
    <input type="number" id="price" value="${product.getPrice()}" name="priceProduct">
    <br>
    <button type="submit" class="btn btn-primary">Update</button>
	<a href="demo" class="btn btn-primary">Home</a>
</form>
	
</body>
</html>

