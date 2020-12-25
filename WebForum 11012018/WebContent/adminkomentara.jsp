<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <jsp:useBean id="user" class="beans.User" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >
<title>Insert title here</title>
</head>
<body>
<div id="sadrzaj">
<%@ include file="meni.jsp" %>
<h1>Administracija komentara </h1>
<p><a href="ListaKomentara?naslovteme=<%=request.getParameter("naslovteme")%>">Povratak</a></p>
<table>
<tr>
<th>id</th>
<th>Autor</th>
<th>Komentar</th>
<th>Obrisan</th>
</tr>
<c:forEach items="${spisakKomentara}" var="komentar" >
<tr>
<td>${komentar.idkomentara}</td>
<td>${komentar.autor}</td>
<td>${komentar.tekstkomentara}</td>
<td>${komentar.obrisan}</td>
<td>
<form action="ObrisatiKomentar">
<input type="hidden" name="idkomentara" value=${komentar.idkomentara}>
<input type="hidden" name="naslovteme" value="${komentar.tema}">
<input type="submit" value="izmeniti"></form></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>