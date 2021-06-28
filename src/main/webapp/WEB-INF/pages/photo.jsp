<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<body>
<h1>Photo</h1>
<div align="center">
   
     <h3><c:out value="${getphotobasedonempid.empid}" /></h3>
    <img src="data:image/*;base64,${getphotobasedonempid.base64Image}" width="240" height="300"/>
    
     
</div>
</body>
</html>