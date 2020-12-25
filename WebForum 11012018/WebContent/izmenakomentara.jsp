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
<script>
var id=<%= request.getParameter("idkomentara") %>;
var tekst="<%= request.getParameter("tekstkomentara") %>";
alert(tekst);
</script>
<h1>Izmena komentara:</h1>
<form method="get" action="SacuvajIzmeneKomentar">
<input type="text" name="tekstkomentara" value='<%= request.getParameter("tekstkomentara") %>' size=50/>
<input type="hidden"name="idkomentara" value='<%= request.getParameter("idkomentara") %>' />
<input type="hidden"name="naslovteme" value='<%= request.getParameter("naslovteme") %>' />

<input type="submit" value="sacuvaj izmene"> 

</form>
</div>
</body>
</html>