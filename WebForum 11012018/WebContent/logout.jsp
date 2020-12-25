<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="user" class="beans.User" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >
<title>Logout</title>
</head>
<body>
<div id="sadrzaj">
<%@ include file="meni.jsp" %>
<h1>Odjava</h1>
<% session.invalidate(); %>
<p>Uspešno ste se odjavili.</p>
</div>
</body>
</html>