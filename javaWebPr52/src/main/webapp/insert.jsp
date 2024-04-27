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
	<form action="insert" method="post">
			<label>Name</label> 
			<input type="text" name="nameProduct"
				id="exampleInputEmail1" aria-describedby="emailHelp">
		
		<br>
			<label>Price</label>
			<input type="number" name="priceProduct">
	<br>
		<button type="submit" class="btn btn-primary">Submit</button>
		<a href="demo" class="btn btn-primary">Home</a>
	</form>
	
</body>
</html>

