<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" class="beans.User" scope="session"/>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >
<title>Pregled komentara</title>
<style>
a.prijavljen {
font-family:"Arial";
font-size:12px;
background-color:#eeeeee;
color:#000000;
text-decoration:none; 
padding:2px;
margin:2px; 
border:1px solid #888888;
}
</style>
<script>
var $tema;
var $roid;
function prikazi(x){
	
	document.getElementById("podkomentar"+x).style.display = "block";
	document.getElementById("test").style.color="red";
}
</script>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	var $user="${user.username}";
	// $(".tablediv").hide();
	$("#komentari").on("click",".poz", function(event){
		
		var $id=$(this).attr('att2');
		
	//	alert("+glas je kliknut "+$id);
		$.get('GlasoviPozitivniKomentar',{idkomentara:$id,username:$user},function(responseText){
	//		 alert("da li radi alert");
			//$('#w').text("neki"+responseText);    
			$('#pglasovi'+$id).text(responseText+"+");    
		});
		if(document.getElementById("pg"+$id) !== null){
		document.getElementById("pg"+$id).style.display="none";
		document.getElementById("ng"+$id).style.display="none";
		}
	});
$("#komentari").on("click",".neg", function(event){
		
		var $id=$(this).attr('att3');
		//alert("-glas je kliknut "+$id);
		$.get('GlasoviNegativniKomentar',{idkomentara:$id,username:$user},function(responseText){
			 
			//$('#w').text("neki"+responseText);    
			$('#nglasovi'+$id).text(responseText+"-");    
		});
		if(document.getElementById("pg"+$id) !== null){
		document.getElementById("pg"+$id).style.display="none";
		document.getElementById("ng"+$id).style.display="none";
		}
	});
	     $("#komentari").on("click",".showTable", function(event){
	    	
	    	 var $us = "<%=user.getUsername() %>";
	    	// alert("dugme je kliknuto " +$us);
	    	 var $rid=$(this).attr('att1');
	    	 var $br=$rid;
	    	 $(this).css('display','none');
	           $.get('PopulateTable',{roditeljskikomentar:$rid},function(responseJson) {
	        	   
	            if(responseJson!=null){
	            
	               
	                            
	                $.each(responseJson, function(key,value) { 
	                	var i=value.izmenjen;
	                	var s="";
	                	if(i==true){s="izmenjen";}
	                	var stavka=$("<li>"+value.autor+", "+value.tekstkomentara+
	                			'<br><span id="pglasovi'+value.idkomentara+'">'+value.pozitivniglasovi+'+</span><button id="pg'+value.idkomentara+'" class="poz" att2="'+value.idkomentara+'" >+</button>,'+
	                			'<span id="nglasovi'+value.idkomentara+'">'+value.negativniglasovi+'-</span><button id="ng'+value.idkomentara+'" class="neg" att3="'+value.idkomentara+'" >-</button>'+ 
	                			
	                			'<a class="prijavljen" href="izmenakomentara.jsp?idkomentara='+value.idkomentara+'&tekstkomentara='+value.tekstkomentara+'&naslovteme='+value.tema+'">Izmeni komentar</a>  '+
	                			'<a style="" class="prijavljen" href="SacuvajKomentar?naslovteme='+value.tema+'&idkomentara='+value.idkomentara+'&rid='+value.roditeljskikomentar+'&tekstkomentara='+value.tekstkomentara+'&user=<%=user.getUsername()%>'+'">Sacuvaj</a>'+
	                			'<input type="button" value="Prikazi Podkomentare" class="showTable" att1="'+value.idkomentara +'" />'+
	                			
	                			
	                			
	                			'<p align="right">'+s+'</p>'+
	                			'<div class="tablediv">'+
	                			'<ul id="moja'+value.idkomentara +'"></ul></div>'+
	                			'<div onclick="prikazi('+value.idkomentara+')" style="color:blue;cursor:pointer;" class="prijavljen">Komentarisi</div>'+
	                			'<form name="novpodkomentar" id="podkomentar'+value.idkomentara+'" method="get" action="UpisKomentara" style="display:none;">'+
	                			' <input type="text" name="tekstkomentara" size="40">'+
	                			'<input type="hidden" name="naslovteme" value="'+value.tema+'" size="40">'+
	                			'<input type="hidden" name="autor"  value="<%=user.getUsername() %>">'+
	                			 '<input type="hidden" name="roditeljskikomentar"  value="'+value.idkomentara+'">'+
	                			 '<input type="submit" value="Objavi"><br></form>'+
	                			 "</li><hr>");
	                	
	                	 	 stavka.appendTo("#moja"+$br);
	                	 	
                });
	                <%if (user.getUsername()== null){
	                	
	                	   
	                    
	                	 %>
	                document.getElementById("novkomentar").style.display="none";
	                var x = document.getElementsByClassName("prijavljen");
	                var y = document.getElementsByClassName("poz");
	                var z = document.getElementsByClassName("neg");
	                var i;
	                for (i = 0; i < x.length; i++) {
	                    x[i].style.display="none";
	                }
	                for (i = 0; i < y.length; i++) {
	                    y[i].style.display="none";
	                }
	                for (i = 0; i < z.length; i++) {
	                    z[i].style.display="none";
	                }
	                <% }%>
	                var glasovi=[];
	                glasovi=${user.pozitivnikomentari}.concat(${user.negativnikomentari});
	                //alert("senka" +glasovi);
	                if(glasovi == null) glasovi = [];
	                else{
	                fLen = glasovi.length;
	                for (i = 0; i < fLen; i++) {
	                	if(document.getElementById("pg"+glasovi[i]) !== null){
	                	//alert("pg" +glasovi[i]);
	                	document.getElementById("pg"+glasovi[i]).style.display="none";
	                	document.getElementById("ng"+glasovi[i]).style.display="none";}
	                }
	                }
	                
	                }
                
	         
            });
       //     $(".tablediv").show();          
  });      
});
</script>
</head>
<body>
<div id="sadrzaj">
<%@ include file="meni.jsp" %>
<a id="admin" style="display:none;" href="ListaKomentaraBrisanje?naslovteme<%=request.getParameter("naslovteme")%>">Administracija</a>

<script>
var $us="<%=user.getUloga()%>";
if($us=="administrator" || $us=="moderator"){
document.getElementById("admin").style.display="block";}
</script>
<h2>Pregled komentara za temu:</h2><h1> <%=request.getParameter("naslovteme")%></h1>
<p id="w"></p>
<hr><br>
<div id="test" onclick="prikazi()"> </div>
<ul id="komentari">
<c:forEach items="${spisakKomentara}" var="komentar">
<li style="background-color:#bbddbb; border-radius:6px; margin:5px; padding:5px">
<span style="color:grey">${komentar.autor}</span> ${komentar.tekstkomentara}. 



<br><span id="pglasovi${komentar.idkomentara}">${komentar.pozitivniglasovi}+</span><button id="pg${komentar.idkomentara}" class="poz" att2="${komentar.idkomentara}" >+</button>,
<span id="nglasovi${komentar.idkomentara}">${komentar.negativniglasovi}-</span><button id="ng${komentar.idkomentara}" class="neg" att3="${komentar.idkomentara}" >-</button> 
<input type="button" value="izmeni komentar" class="prijavljen" onclick='location.href="izmenakomentara.jsp?idkomentara=${komentar.idkomentara}&tekstkomentara=${komentar.tekstkomentara}&naslovteme=${komentar.tema}"'>
<input type="button" value="prikazi podkomentare" class="showTable" att1="${komentar.idkomentara}"/>
<button class="prijavljen" onclick='location.href="SacuvajKomentar?naslovteme=${komentar.tema}&idkomentara=${komentar.idkomentara}&rid=${komentar.roditeljskikomentar}&tekstkomentara=${komentar.tekstkomentara}&user=<%=user.getUsername()%>"'>Sacuvaj</button>
<p align="right"><script>var i=${komentar.izmenjen }; if(i==true){ document.write("izmenjen");}</script></p>
<div class="tablediv">
<ul id="moja${komentar.idkomentara}"></ul></div>
<div onclick="prikazi(${komentar.idkomentara})" style="color:blue;cursor:pointer;" class="prijavljen">Komentarisi</div>
<div id="unos${komentar.idkomentara}">
<form name="novpodkomentar" id="podkomentar${komentar.idkomentara}" method="get" action="UpisKomentara" style="display:none;">
 <input type="text" name="tekstkomentara" size="40">
 <input type="hidden" name="naslovteme" value="<%=request.getParameter("naslovteme")%>" size="40">
 <input type="hidden" name="autor"  value=<%=user.getUsername() %>>
 <input type="hidden" name="roditeljskikomentar"  value="${komentar.idkomentara}">
 <input type="submit" value="Objavi"><br>
</form>
</div>

</li>
</c:forEach>
</ul>
<p style="color:maroon">
<%=(request.getAttribute("errMessage") == null) ? ""
: request.getAttribute("errMessage")%>
</p>
<div id="novkomentar">
 <h2>Dodaj nov komentar</h2>
 <form action="UpisKomentara" method="get">
 Tekst komentara: <input type="text" name="tekstkomentara" size="40">
 <input type="hidden" name="naslovteme" value="<%=request.getParameter("naslovteme")%>" size="40">
 <input type="hidden" name="autor"  value=<%=user.getUsername() %>>
 <input type="hidden" name="roditeljskikomentar"  value=0 >
 
 <input type="submit" value="Obajvi"><br>
 </form>
 </div>
</div>

<%if (user.getUsername()== null){
    	
   
      
 %>
 <script>
 
    document.getElementById("novkomentar").style.display="none";
    var x = document.getElementsByClassName("prijavljen");
    var y = document.getElementsByClassName("poz");
    var z = document.getElementsByClassName("neg");
    var i;
    for (i = 0; i < x.length; i++) {
        x[i].style.display="none";
    }
    for (i = 0; i < y.length; i++) {
        y[i].style.display="none";
    }
    for (i = 0; i < z.length; i++) {
        z[i].style.display="none";
    }
    
    </script>
   <% }%>


<script>
var glasovi=[];
glasovi=${user.pozitivnikomentari}.concat(${user.negativnikomentari});
//alert("senka" +glasovi);
if(glasovi == null) glasovi = [];
else{
fLen = glasovi.length;
for (i = 0; i < fLen; i++) {
	if(document.getElementById("pg"+glasovi[i]) !== null){
	//alert("pg" +glasovi[i]);
	document.getElementById("pg"+glasovi[i]).style.display="none";
	document.getElementById("ng"+glasovi[i]).style.display="none";}
}
}
</script>
</body>
</html>