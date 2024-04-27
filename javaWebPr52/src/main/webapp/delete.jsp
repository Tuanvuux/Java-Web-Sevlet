

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

    <form action="delete" method="post">
    <input type="hidden" name="id" value="${product.getId()}">
	<a href="demo" class="btn btn-primary">Home</a>
</form>
	
</body>
</html>

