<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<script>
	$(document).ready(function() {
	
		 var idNumber = $("#idNumber").val();
		  window.location.href ="#/leaves/" +idNumber
 });
</script>

</head>
<body>
    <input type="text" value="${idNumber}" id="idNumber" >
</body>
</html>