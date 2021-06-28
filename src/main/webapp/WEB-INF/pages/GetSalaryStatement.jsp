<%@ include file="header.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html >
<head>
    <title></title>
     <style>
.nth-table {
    border-collapse: collapse;
    border: 1px solid #400040;
  }
 .nth-table tr:nth-child(){
        background: #ebf7d4;
        
    }
.nth-table th{
    border: 1px dotted #460046;
    color: #000;
    padding:5px;
    background-color:#AFD8D8;
  }
.nth-table td{
    border: 1px dashed #000;
    color: #002F5E;
    padding:5px;
    width:100px;
  }
  @media print
{

</style>
</head>
<body> 
<input type="image" src="resources/assets/images/printer.png" height="30" width="30"  onclick="window.print()" > &nbsp; &nbsp;
<button onclick="exceller()">EXCEL</button> 
 <!-- <input type='button' id='btn' value='Print' onclick='printDiv();'>  -->
<!-- <button onclick="HTMLtoPDF()">Download PDF</button> -->
 <input type="button" onclick="printDiv('dvContainer')" value="print a div!" />
<div id="dvContainer">

<table  class="nth-table" >
<tr>
 <th colspan="25"> <h6 align="center"><B> KALLAM AGRO PRODUCTS & OILS PRIVATE LIMITED</B></h6></th>
 </tr>
 <tr>
 <th colspan="25"><h6 align="center"> <B>DOKIPARRU, GUNTUR-522438.</B></h6></th>
 </tr>
 <tr>
 <th colspan="25"><h6 align="center"> <B>SALARY STATEMENT</B></h6></th>
 </tr>
  <tr>
      <th rowspan="2">S.NO</th>
      <th rowspan="2">ID.NO</th>
	  <th rowspan="2" >NAME</th>
	  <th rowspan="2">WORKING DAYS</th>
	  <th rowspan="2">PRESENT DAYS</th>
	  <th rowspan="2">LOP DAYS WITH INTIMATIO</th>
	  <th rowspan="2">LOP DAYS WITHOUT INTIMATIO</th>
      <th colspan="7">EARNINGS</th>
	  <th colspan="2" >LOAN & ADVANCES BALANCE</th>
      <th colspan="8" >DEDUCTIONS</th>	  
	  <th rowspan="2">NETSALARY</th>	
	</tr>  
	
  <tr>	  
      <th>BASIC</th>
      <th>VDA</th>
	  <th>HRA</th>
	  <th>CA</th>
	  <th>SA</th>
	  <th>LEAVE INCENTIVE</th>
	  <th>TOTAL EARNING</th>
	  <th>SALARY LOAN</th>
	  <th>SALARY ADVANCE</th>
	  <th>PF</th>
	  <th>ELETRIC CHARGES</th>
	  <th>HRA</th>
	  <th>P.TAX</th>
	  <th>SALARY ADVANCE</th>
	  <th>SALARY LOAN</th>
	  <th>LEAVE PENALITY</th>
	  <th>Total</th>
        
  </tr>
  <c:choose>
  <c:when test="${not empty getsalarystatement}">
  <c:forEach var="map" items="${getsalarystatement}">
   <tr>
      <td>${map.slno}</td>
      <td>${map.idno}</td>
      <td>${map.empname}</td>
	  <td>${map.workingdays}</td>
	  <td>${map.presentdays}</td>
	  <td>${map.lopdayswithintimation}</td>
	  <td>${map.lopdayswithoutintimation}</td>
	  <td>${map.basic}</td>
	  <td>${map.vda}</td>
	  <td>${map.hra}</td>
	  <td>${map.ca}</td>
	  <td>${map.sa}</td>
	  <td>${map.leaveincentive}</td>
	  <td>${map.totalearnings}</td>
	  <td>${map.salaryloan}</td>
	  <td>${map.salaryadvance}</td>
	  <td>${map.pfamount}</td>
	  <td>${map.electricitycharges}</td>
	  <td>${map.hra1}</td>
	  <td>${map.ptax}</td>
	  <td>${map.salaryadvance1}</td>
	   <td>${map.salaryloan1}</td>
	  <td>${map.leavepenalty}</td>
	   <td>${map.totaldeduction}</td>
	  <td>${map.netsalary}</td>
	  
  </tr>
    </c:forEach>
    </c:when>
    </c:choose>
</table>
   
	
	
</div>
<script src="resources/dist/js/sidebarmenu.js"></script>
<script>
function printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    var originalContents = document.body.innerHTML;
    document.body.innerHTML = printContents;
    window.print();
    document.body.innerHTML = originalContents;
}
</script>
</body>
<%@ include file="footer.jsp" %>
<script type="text/javascript" src="resources/Pdf&Excel&Print/jspdf.js"></script>  
<script type="text/javascript" src="resources/Pdf&Excel&Print/pdfFromHTML.js"></script>  
<script type="text/javascript" src="resources/Pdf&Excel&Print/print.js"></script>
<script type="text/javascript" src="resources/Pdf&Excel&Print/excel.js"></script>  
</html>