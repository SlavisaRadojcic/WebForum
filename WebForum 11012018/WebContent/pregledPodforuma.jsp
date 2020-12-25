<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="user" class="beans.User" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link  rel = "stylesheet"   type = "text/css"    href = "stil.css" >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Spisak svih podforuma</title>
</head>
<body>
<div id="sadrzaj">

<%@ include file="meni.jsp" %>

<h1>Pregled svih podforuma</h1>


<hr><br>
<table border="1" >
       <tr>
          <th>ikona</th>
          <th>naziv</th>
         <th>opis</th>
         <th>obrisi</th>
         <th>sacuvaj</th>
         
       </tr>
       <c:forEach items="${spisakPodforuma}" var="podforum" >
          <tr>
          <td><img src='slike/${podforum.ikonica}' alt="ikonica" class="ikonica"></td>
             <td><a href="ListaTema?naziv=${podforum.naziv}"> ${podforum.naziv}</a></td>
             <td>${podforum.opis}</td>
          	<td><button class="admin" att1="${podforum.odgovornimoderator}" onclick='location.href="DeletePodforum?nazivpodforuma=${podforum.naziv}"'>Obrisi</button></td>
          <td><button class="prijavljen" onclick='location.href="SacuvajPodforum?naziv=${podforum.naziv}&user=<%=user.getUsername()%>"'>Sacuvaj</button></td>
          </tr>
         
       </c:forEach>
    </table>
   
   <p style="color:orange">
<%=(request.getAttribute("errMessage") == null) ? ""
: request.getAttribute("errMessage")%>
</p>
   
 <div id="novpodforum">
 <h2>Napravi nov podforum</h2>
 <form action="Upis" method="post" enctype="multipart/form-data">
 Naslov podforuma: <input type="text" name="naziv" required 
 oninvalid="this.setCustomValidity('Unesite naziv podforuma ime ovde')" oninput="setCustomValidity('')"
 ><br>
 Opis podforuma: <input type="text" name="opis" required 
 oninvalid="this.setCustomValidity('Unesite opis podforuma ovde')" oninput="setCustomValidity('')"
 ><br>
 <input type="hidden"  name="odgovornimoderator" value=<%=user.getUsername() %>><br>
 <input type="hidden"  name="ad" value=<%=user.getUloga() %>><br>
 Postavi ikonicu:<input type="file" name="ikonica" required 
 oninvalid="this.setCustomValidity('dodajte ikonicu podforuma')" oninput="setCustomValidity('')"
 ><br>
 <input type="submit" value="nov podforum"><br>
 </form>
 </div>
</div>
 
 <script>
 
 	var $us="<%=user.getUloga()%>";
 	if($us=="administrator" || $us=="moderator"){
    document.getElementById("novpodforum").style.display="block";}
   
 
 if($us=="administrator"){
  var x = document.getElementsByClassName("admin");
 var i;
 for (i = 0; i < x.length; i++) {
     x[i].style.visibility = "visible";
 }
 
  }
 else{
 var x = document.getElementsByClassName("admin");
 var i;
 var $om;
 var $un="<%=user.getUsername()%>";
 for (i = 0; i < x.length; i++) {
	 $om=x[i].getAttribute("att1");
 		if($om==$un) x[i].style.visibility = "visible";
 }
 }
 
 
 
 </script>
</body>
</html>