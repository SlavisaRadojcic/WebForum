<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >
<style>

</style>
<title>Forum Login</title>
</head>
<body>
<div id="sadrzaj">
<%@ include file="meni.jsp" %>
<h1>Prijava korisnika</h1>
<form action="Login" method="post" name="login">
Username <input type="text" name="username"><br>
Password <input type="password" name="password">
<input type="submit" value="Login"><br>
</form>
</div>
</body>
</html>