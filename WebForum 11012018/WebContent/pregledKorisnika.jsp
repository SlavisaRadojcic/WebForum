<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="user" class="beans.User" scope="session"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
</head>
<body>
<div id="sadrzaj">

<%@ include file="meni.jsp" %>
<h1>Pregled korisnika</h1>
<hr><br>
<p style="color:maroon">
<%=(request.getAttribute("errMessage") == null) ? ""
: request.getAttribute("errMessage")%>
</p>
<table border=1>
<tr>
	<th>korisnicko ime</th>
	<th>sifra</th>
	<th>uloga</th>
	<th>ime</th>
	<th>datum registracije</th>
<c:forEach items="${spisakKorisnika}" var="korisnik">
<tr>
<td><a href="Korisnik?ime=${korisnik.username}">${korisnik.username}</a></td>
<td>${korisnik.password}</td>
<td>${korisnik.uloga} <button class="admin" onclick='location.href="IzmenaKorisnika?username=${korisnik.username}"'>Izmeni</button></td>
<td>${korisnik.ime}</td>
<td>${korisnik.datumregistracije}</td>
</tr>
</c:forEach>
</table>
</div>
<script>
 var $us="<%=user.getUloga()%>";
 if($us=="administrator"){
  var x = document.getElementsByClassName("admin");
 var i;
 for (i = 0; i < x.length; i++) {
     x[i].style.visibility = "visible";
 }
 }
 </script>
</body>
</html>