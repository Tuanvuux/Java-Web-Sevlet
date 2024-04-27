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
    String check = request.getParameter("check");
    if (check != null) {
        if (check.equals("true")) {
%>
            <p style="color: green;">Đăng ký thành công.</p>
<%
        } else if (check.equals("false")) {
%>
            <p style="color: red;">Tài khoản đã tồn tại.</p>
<%
        }
    }
%>
	<h1>Register</h1>
	<form action="register" method="post">
	<label for="">Username</label>
	<input type="text" name= "username">
	<br>
	<label for="">Password</label>
	<input type="text" name= "password" >
	<br>
	<button type="submit">Register</button>
	<a href="login">login</a>
</form>
</body>
</html>