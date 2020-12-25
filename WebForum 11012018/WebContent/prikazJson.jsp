<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJAX JsonArray Example</title>
<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<style type="text/css">
table, td, th
{
border:1px solid green;
font-family: 'Oxygen', sans-serif;
border-collapse: collapse;
}
th
{
background-color:green;
color:white;
}
body
{
 text-align: center;
}
.container
{
 margin-left: auto;
 margin-right: auto;
 width: 40em;
}
</style>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	 $("#tablediv").hide();
	     $("#showTable").click(function(event){
	           $.get('PopulateTable',function(responseJson) {
	        	   
	            if(responseJson!=null){
	            
	                $("#countrytable").find("tr:gt(0)").remove();
	                var table1 = $("#countrytable");
	                $.each(responseJson, function(key,value) { 
	                	 var red=$("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
	                	 red.children().eq(0).text(value.tema);
	                	 red.children().eq(1).text(value.autor);
	                	 red.children().eq(2).text(value.idkomentara); 
	                     red.children().eq(3).text(value.roditeljskikomentar); 
	                     red.children().eq(4).text(value.tekstkomentara); 
	                     red.children().eq(5).text(value.pozitivniglasovi); 
	                     red.children().eq(6).text(value.negativniglasovi); 
	                     red.children().eq(7).text(value.izmenjen); 
	                	 red.appendTo("#moja");
                    
                });
                }
	            else{alert("prazan");}
            });
            $("#tablediv").show();          
  });      
});
</script>

</head>
<body class="container">
<h1>AJAX Retrieve Data from Database in Servlet and JSP using JSONArray</h1>
<input type="button" value="Show Table" id="showTable"/>

<div id="tablediv">
<table id="moja">
<tr> 
        <th scope="col">tema</th> 
        <th scope="col">autor</th> 
        <th scope="col">id komantara</th> 
        
        <th scope="col">roditeljski komentar</th> 
         <th scope="col">tekst komentara</th> 
        <th scope="col">pozitivni glasovi</th> 
        <th scope="col">negativni glasovi</th>   
        <th scope="col">izmenjen</th>        
    </tr> 
</table>
</div>

</body>
</html>
