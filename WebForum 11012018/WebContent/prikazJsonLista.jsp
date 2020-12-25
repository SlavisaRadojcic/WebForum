<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AJAX JsonArray Example</title>
<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>



<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	 $("#tablediv").hide();
	     $("#showTable").click(function(event){
	    	 var $naslov="Kako funkcionisu servleti";
	    	 var $rid=2;
	           $.get('svi',{naslovteme:$naslov,roditeljskikomentar:$rid},function(responseJson) {
	        	   
	            if(responseJson!=null){
	            
	               
	                var table1 = $("#countrytable");
	               
	                $.each(responseJson, function(key,value) { 
	                	var stavka=$("<li>"+value.autor+", "+value.tekstkomentara+"</li>");
	                	
	                	 	 stavka.appendTo("#moja");
                    
                });
                }
	            
            });
            $("#tablediv").show();          
  });      
});
</script>

</head>
<body class="container">

<input type="button" value="prikazi podkomentare" id="showTable"/>
<div id="tablediv"><ul id="moja"></ul></div>

</body>
</html>
