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
				<a href="update?id=${product.getId()}" class="btn btn-primary">Update</a>
				<a href="delete?id=${product.getId()}" class="btn btn-primary">Delete</a>
				
				
			</div>
		</div>
		</c:forEach>
		
		
	</div>
	<br>
	<a href="demo" >Home</a>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">
	</script>
</body>
</html>