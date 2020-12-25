<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="user" class="beans.User" scope="session"/>
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
	<h1>Vaš profil</h1>
	<%if (user.getUsername()== null){ %>
	<p>Niste se prijavili, nema podataka za prikazivanje</p>	
	<% }%>
	<%if (user.getUsername()!= null){ %>
	<script type="text/javascript">
	
	$(document).ready(function() {
	
		
		var $u="${user.username}";
		var $p="${user.password}";
		//alert("funkcija je pozvana za korisnika "+ $u);
		$.get('ProfilServlet',{username:$u,password:$p},function(responseJson){
			//alert("nije prazan"+responseJson);
			var obj = JSON.parse(responseJson);
			//alert("objekat je"+obj.username);
			$('#kime').text("Korisnicko ime: "+obj.username);
			$('#teme').text("Sacuvane teme: "+obj.sacuvaneteme);
			$('#komentari').text("Sacuvani komentari: "+obj.sacuvanikomentari);
			$('#podforumi').text("Sacuvani podforumi: "+obj.sacuvanipodforumi.length);
			$('#sifra').text("Password: "+obj.password);
			$('#ime').text("Ime: "+obj.ime);
			$('#prezime').text("Prezime: "+obj.prezime);
			$('#telefon').text("Telefon: "+obj.telefon);
			$('#email').text("Email: "+obj.email);
		});
		   
		});

	</script>
	
	<p id="kime"></p>
	<p id="sifra"></p>
	<p id="ime"></p>
	<p id="prezime"></p>
	<p id="telefon"></p>
	<p id="email"></p>
	<p id="podforumi"></p>
	<p id="teme"></p>
	<p id="komentari"></p>
	
	<% }%>
	
</div>

</body>
</html>