<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >
<title>Profil korisnika</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>

<body>
<div id="sadrzaj">
	<%@ include file="meni.jsp" %>
	<h1>Profil korisnika</h1>
	<p>${korisnik.ime} ${korisnik.prezime}, ${korisnik.username}</p>
	<p><b>Uloga:</b> ${korisnik.uloga}</p>
	<p><b>Datum registracije:</b> ${korisnik.datumregistracije}</p>
	<p><b>Sacuvani podforumi:</b> ${korisnik.sacuvanipodforumi}</p>
	<p><b>Sacuvane teme:</b> ${korisnik.sacuvaneteme}</p>
	<p><b>Pozitivni glasovi:</b> ${korisnik.pozitivniteme}</p>
	<p><b>Negativni glasovi:</b> ${korisnik.negativniteme}</p>
	<br>
	<p><b>Sacuvani komentari:</b> ${korisnik.sacuvanikomentari}</p>
	<p><b>Pozitivni glasovi:</b> ${korisnik.pozitivnikomentari}</p>
	<p><b>Negativni glasovi:</b> ${korisnik.negativnikomentari}</p>
	<p></p>
	
	
</div>
</body>
</html>