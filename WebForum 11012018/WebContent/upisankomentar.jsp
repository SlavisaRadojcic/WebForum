<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" class="beans.User" scope="session"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >
<title>Nov komentar</title>
</head>
<body>
<div id="sadrzaj">
<%@ include file="meni.jsp" %>
<h2>Ostavili ste komentar za temu: </h2><h1> <%=request.getParameter("naslovteme")%></h1>
<p style="color:maroon">
<%=(request.getAttribute("errMessage") == null) ? ""
: request.getAttribute("errMessage")%>
</p>
<a href="ListaKomentara?naslovteme=<%=request.getParameter("naslovteme")%>">Povratak</a>

</body>
</html>