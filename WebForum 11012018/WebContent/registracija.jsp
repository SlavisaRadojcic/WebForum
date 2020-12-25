<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>Registracija Korisnika</h1>
<p>
<%=(request.getAttribute("errMessage") == null) ? ""
: request.getAttribute("errMessage")%>
</p>

<form action="UpisKorisnik" method="post" >
username <input type="text" name="username" required 
oninvalid="this.setCustomValidity('Unesite korisnicko ime ovde')" oninput="setCustomValidity('')"><br>
password <input type="password" name="password" required
oninvalid="this.setCustomValidity('Unesite šifru ovde')" oninput="setCustomValidity('')"
><br>
ime: <input type="text" name="ime" required 
oninvalid="this.setCustomValidity('Unesite ime ovde')"
    oninput="setCustomValidity('')"><br>
prezime: <input type="text" name="prezime" required 
oninvalid="this.setCustomValidity('Unesite prezime ovde')"
    oninput="setCustomValidity('')"><br>
telefon: <input type="text" name="telefon" required
oninvalid="this.setCustomValidity('Unesite broj telefona ovde')"
    oninput="setCustomValidity('')"
><br>
email: <input type="email" name="email" required
oninvalid="this.setCustomValidity('Unesite email adresu ovde')"
    oninput="setCustomValidity('')"
>
<input type="submit" value="registracija" required> 
</form>
</div>
</body>
</html>