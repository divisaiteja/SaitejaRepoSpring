<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>

</script>

 
<!-- <button onclick="exceller()">EXCEL</button>  -->
<input type="image" src="resources/assets/images/excel.png" height="30" width="30" onclick="exceller()" >   
 &nbsp; &nbsp;
<!-- <input type='button' id='btn' value='Print' onclick='printDiv();'> -->
<input type="image" src="resources/assets/images/printer.png" height="30" width="30" onclick="printDiv()" >   
 &nbsp; &nbsp; 
<!-- <button onclick="HTMLtoPDF()">Download PDF</button> -->
<input type="image" src="resources/assets/images/pdf.png" height="30" width="30" onclick="HTMLtoPDF()" >   
 &nbsp; &nbsp;
<div id="dvContainer" style="overflow: scroll; height : 90%; max-height:500px;
      overflow-y : auto; overflow-x : scroll ">
<h3 align="center">WeightBridgeRegister</h3>
<table id="weightRegister" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		<th>ReportNum</th>
                <th>Gpno</th>
                <th>vechicleNo</th>
                <th>GrassWeight</th>
                <th>TareWeight</th>
                <th>NetWeight</th>
                <th>Grossdt</th>
                <th>Taredt</th>
                <th>Status</th>
                
                
            </tr>
        </thead>
       <c:choose>
  <c:when test="${not empty weightBridgeRegister}">
  <c:forEach var="map" items="${weightBridgeRegister}">
    <tr>
      <td>${map.ReportNum}</td>
      <td>${map.inwardno}</td>
      <td>${map.truckno}</td> 
	  <td>${map.grosswt}</td> 
	  <td>${map.tarewt}</td> 
	  <td>${map.netwt}</td>
	  <td>${map.grossdt}</td>
	  <td>${map.taredt}</td>
	  <td>${map.status}</td>
	  
  </tr>
  </c:forEach>
  </c:when>
  </c:choose>
       
    </table>
   
    </div>

 
 <script src="resources/dist/js/sidebarmenu.js"></script>
</body>
<%@ include file="footer.jsp" %>
<script type="text/javascript" src="resources/Pdf&Excel&Print/jspdf.js"></script>  
<script type="text/javascript" src="resources/Pdf&Excel&Print/pdfFromHTML.js"></script>  
<script type="text/javascript" src="resources/Pdf&Excel&Print/print.js"></script>
<script type="text/javascript" src="resources/Pdf&Excel&Print/excel.js"></script>  
 </html>

