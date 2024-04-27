<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    String error = request.getParameter("error");
    if (error != null && error.equals("true")) {
%>
        <p style="color: red;">Sai tên đăng nhập hoặc mật khẩu.</p>
<%
    }
%>
    <h1>Login</h1>
	<form action="login" method="post">
	<label for="">Username</label>
	<input type="text" name= "username">
	<br>
	<label for="">Password</label>
	<input type="text" name= "password" >
	<br>
	<button type="submit">Login</button>
	<a href="register">Register</a>
</form>
</body>
</html>