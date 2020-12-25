<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="beans.User" scope="session"/>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >
<title>Pregled Tema</title>
</head>
<body>
<div id="sadrzaj">

<%@ include file="meni.jsp" %>
<h1>Pregled tema za podforum <%=(request.getParameter("naziv")) %></h1>
<hr><br>

<table border=1>
<tr>
	<th>Podforum</th>
	<th>Tema</th>
	<th>Sadrzaj</th>
	<th>Autor</th>
	<th>Like</th>
	<th>Dislike</th>
	<th></th>
	<th></th>
	<th></th>
<c:forEach items="${spisakTema}" var="tema">
<tr>
<td>${tema.podforum}</td>
<td><a href="ListaKomentara?naslovteme=${tema.naslovteme}">${tema.idteme} ${tema.naslovteme}</a></td>
<td class="tip" att1="${tema.tip}" att2="${tema.sadrzajtip}">${tema.sadrzajtip}</td>
<td >${tema.autor}</td>
<td>${tema.pozitivni}<button class="prijavljen" id="pg${tema.idteme}" onclick='location.href="GlasoviTema?naslovteme=${tema.naslovteme}&glas=1&naziv=${tema.podforum}&idteme=${tema.idteme}&username=${user.username}"'>+</button></td>
<td>${tema.negativni}<button class="prijavljen" id="ng${tema.idteme}" onclick='location.href="GlasoviNegativniTema?naslovteme=${tema.naslovteme}&naziv=${tema.podforum}&idteme=${tema.idteme}&username=${user.username}"'>-</button></td>
<td><button class="admin" onclick='location.href="DeleteTema?naslovteme=${tema.naslovteme}&naziv=${tema.podforum}"'>Obrisi</button></td>
<td><button class="admin" onclick='location.href="IzmenaTema?naslovteme=${tema.naslovteme}&naziv=${tema.podforum}"'>Izmeni</button></td>
<td><button class="prijavljen" onclick='location.href="SacuvajTema?naslovteme=${tema.naslovteme}&naziv=${tema.podforum}&user=<%=user.getUsername()%>"'>Sacuvaj</button></td>
</tr>
</c:forEach>
</table>
<p style="color:maroon">
<%=(request.getAttribute("errMessage") == null) ? ""
: request.getAttribute("errMessage")%>
</p>
<div id="novatema">
 <h2>Dodaj novu temu</h2>
 <form action="UpisTeme2" method="post" id="forma">
 Naslov teme: <input type="text" name="naslovteme" size="40"><br>
 
 Tip teme:
 <select id="tipteme" name="tip" onchange="prikazi()">
 <option value="tekst">Tekst</option>
  <option value="slika">Slika</option>
  <option value="link">Link</option>
 </select><br>
 <span id="to">Tekstualni opis<input type="text" name="sadrzajtekst"><br></span>
<span id="lo"> Link<input type="text" name="sadrzajlink"><br></span>
 <span id="io">Slika<input type="file" name="sadrzajslika" ><br></span>
 <input type="hidden" name="autor"  value=<%=user.getUsername() %>>
 <input type="hidden" name="naziv" value=<%=request.getParameter("naziv")%>>
 <input type="submit" value="Sacuvaj temu"><br>
 </form>
 </div>
</div>
 <%if (user.getUsername()== null){
    	
   
      
 %>
 <script>
 
    document.getElementById("novatema").style.display="none";
    var x = document.getElementsByClassName("prijavljen");
    var i;
    for (i = 0; i < x.length; i++) {
        x[i].style.display="none";
    }
   
    
    </script>
   <% }%>
<script>
var pf="teme<%=request.getParameter("naziv")%>";
alert (pf);
var glasovi=[];

glasovi=${user.pozitivniteme}.concat(${user.negativniteme});
//alert("senka" +"${user.pozitivniteme}");
if(glasovi == null) glasovi = [];
else{
fLen = glasovi.length;

for (i = 0; i < fLen; i++) {
	if(document.getElementById("pg"+glasovi[i]) !== null){
	document.getElementById("pg"+glasovi[i]).style.display="none";
	document.getElementById("ng"+glasovi[i]).style.display="none";
	}
}}

document.getElementById("lo").style.display="none";
document.getElementById("io").style.display="none";

function prikazi(){
	var p = document.getElementById("tipteme").value;
	alert(p);
	if (p=="slika"){
		document.getElementById("lo").style.display="none";
		document.getElementById("to").style.display="none";
		document.getElementById("io").style.display="block";
		
		document.getElementById("forma").enctype = 'multipart/form-data';
		document.getElementById("forma").action="UpisTeme1";
		alert(document.getElementById("forma").enctype +document.getElementById("forma").action);
	} 
	if (p=="link"){
		document.getElementById("lo").style.display="block";
		document.getElementById("to").style.display="none";
		document.getElementById("io").style.display="none";
		
		document.getElementById("forma").enctype="application/x-www-form-urlencoded";
		document.getElementById("forma").action="UpisTeme2";
		alert(document.getElementById("forma").enctype+document.getElementById("forma").action);
	} 
	if (p=="tekst"){
		document.getElementById("lo").style.display="none";
		document.getElementById("to").style.display="block";
		document.getElementById("io").style.display="none";
		
		document.getElementById("forma").enctype="application/x-www-form-urlencoded";
		document.getElementById("forma").action="UpisTeme2";
		alert(document.getElementById("forma").enctype+document.getElementById("forma").action);
	} 
	
}
 var $us="<%=user.getUloga()%>";
 if($us=="administrator"){
  var x = document.getElementsByClassName("admin");
 var i;
 for (i = 0; i < x.length; i++) {
     x[i].style.visibility = "visible";
 }
 }
 
 var y = document.getElementsByClassName("tip");
 var $tip;
 var $sad;
 for (i = 0; i < y.length; i++) {
	$tip= y[i].getAttribute("att1");
	$sad=y[i].getAttribute("att2");
	if($tip=="tekst"){
     y[i].innerHTML = $sad;
	}
	if($tip=="link"){
	     y[i].innerHTML ="<a href="+$sad+">"+$sad+"</a>";
		}
	if($tip=="slika"){
		y[i].innerHTML="<img width='60' src='slike/"+$sad+"' />";
	}
 }
 </script>
</body>
</html>