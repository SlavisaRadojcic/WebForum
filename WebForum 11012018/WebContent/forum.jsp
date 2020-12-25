<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >
<title>Forum</title>
</head>
<body>
<div id="sadrzaj">
<%@ include file="meni.jsp" %>
<h1>Pokretenje foruma</h1>
<p>potrebno je da na racunaru na c disku postoji forlder new i klikom na sledece linkove ce se napraviti prazni fajlovi za
cuvanje podataka o podforumima, korisnicicima, temama i komentarima.</p>
<p><a href="UpisKorinsikPocetakServlet">korisnik</a></p>
<p><%=(request.getAttribute("porukakorisnici") == null) ? ""
: request.getAttribute("porukakorisnici")%></p>
<p><a href="NovPodforumServlet">podforum</a></p>
<p><%=(request.getAttribute("porukapodforumi") == null) ? ""
: request.getAttribute("porukapodforumi")%></p>
<p><a href="TemaServletPocetak">tema</a></p>
<p><%=(request.getAttribute("porukateme") == null) ? ""
: request.getAttribute("porukateme")%></p>
<p><a href="UpisKomentarPocetakServlet">komentar</a></p>
<p><%=(request.getAttribute("porukakomentari") == null) ? ""
: request.getAttribute("porukakomentari")%></p>
</div>
</body>
</html>