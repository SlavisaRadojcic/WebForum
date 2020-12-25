<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="user" class="beans.User" scope="session"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >
<title>Izmena teme</title>
</head>
<body>
<div id="sadrzaj">

<%@ include file="meni.jsp" %>
<p><c:out value="${errMessage}"/></p>
<h1>Izmena podataka za temu:<c:out value="${tema.naslovteme }"/></h1>
<form method="get" action="SacuvajIzmeneTema">
<input type="text" name="novnaslovteme" value='<c:out value="${tema.naslovteme }"/>' size=50/>
<input type="hidden"name="naslovteme" value='<c:out value="${tema.naslovteme }"/>' />
<input type="hidden"name="naziv" value='<c:out value="${naziv}"/>' />
<input type="submit"> 
</form>
<hr><br>
</body>
</html>