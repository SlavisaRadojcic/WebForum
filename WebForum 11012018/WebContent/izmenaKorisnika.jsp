<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Izmena podataka o korisniku</title>
  <jsp:useBean id="user" class="beans.User" scope="session"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >

</head>
<body>
<div id="sadrzaj">

<%@ include file="meni.jsp" %>
<p><c:out value="${errMessage}"/></p>
<h1>Izmena podataka za korisnika:<c:out value="${userizmena.username }"/></h1>
<form method="get" action="SacuvajIzmeneKorisnik">
<select id="uloga" name="novauloga">
  <option value="korisnik">Korisnik</option>
  <option value="moderator">Moderator</option>
  <option value="administrator">Administrator</option>
</select>
<input type="hidden"name="username" value='${userizmena.username}' />
<input type="submit"> 
</form>
<hr><br>
<script>

    document.getElementById("uloga").value = "${userizmena.uloga }";

</script>
</body>
</html>