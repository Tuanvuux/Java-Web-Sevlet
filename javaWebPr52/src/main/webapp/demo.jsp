<%@page import="service.ProductService"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<form action="search" method="post">
	<div class="div">
    <a href="list?id=1">áo</a>
    <a href="list?id=2">quần</a>
    <a href="list?id=3">mũ</a>
    <a href="list?id=4">giày</a>
  </div>
			<label>Name</label> 
			<input type="text" name="name"
				id="exampleInputEmail1" aria-describedby="emailHelp">
		<button type="submit" class="btn btn-primary">search</button>
		<a href="insert" class="btn btn-primary">insert</a>
	</form>	
	
	
	<div class="d-flex align-items-stretch">
		<c:forEach items="${products}" var="product">
			<div class="card" style="width: 18rem;">
			
			<img src="https://cf.shopee.vn/file/130f781f7c0b552757d7bba99779f982"
				class="card-img-top" alt="...">
				
			<div class="card-body">
				<h5 class="card-title">
					${product.getName()}
				</h5>
				<h3 class="card-title">
					${product.getPrice()}
				</h3>
				<p class="card-text">
				</p>
				<a href="detail?id=${product.getId()}" class="btn btn-primary">Detail</a>
				<br>
				<a href="update?id=${product.getId()}" class="btn btn-primary">Update</a>
				<br>
				<a href="delete?id=${product.getId()}" class="btn btn-primary">Delete</a>
				
				
			</div>
			
			
		</div>
		</c:forEach>
		
	</div>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">
	</script>
</body>
</html>