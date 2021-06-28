<%@page import="java.text.DateFormatSymbols"%>
<%@page import ="java.time.YearMonth" %>
<%@page import="java.time.LocalDate"%>
<%@page import ="java.text.SimpleDateFormat"%>
<html >
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
</style>
</head>
<body>  
<%
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));

YearMonth yearMonth = YearMonth.of( year, month );  // January of 2015.
LocalDate first = yearMonth.atDay( 1 );
LocalDate last = yearMonth.atEndOfMonth();
java.sql.Date startdate=java.sql.Date.valueOf(first);
java.sql.Date enddate=java.sql.Date.valueOf(last);
SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
%>
<input type="image"  src="resources/assets/images/excel.png" height="30" width="30" onclick="exceller()" >  &nbsp; &nbsp;  
<input type="image" src="resources/assets/images/printer.png" height="30" width="30" onclick="window.print()" > &nbsp; &nbsp;
<div id="dvContainer">
<table id="excel" class="nth-table" >
<th colspan="24">FORM &nbsp &nbsp&nbsp 10  &nbsp&nbsp&nbsp&nbsp SALARY &nbsp REGISTER <br>  <%=new DateFormatSymbols().getMonths()[month-1] %> &nbsp;<%=year%>   &nbsp; &nbsp;  FROM DATE: <%=format.format(startdate) %>   &nbsp; &nbsp; &nbsp; &nbsp;   TO DATE:<%=format.format(enddate) %> </th>
  <tr>
      <th rowspan="2">S.NO</th>
      <th rowspan="2">ID.NO</th>
	  <th rowspan="2" >NAME</th>
	  <th rowspan="2">FATHER /HUSBAND </th>
	  <th rowspan="2">DESIGNATION</th>
	  <th colspan="2">ACTUAL PAY SALARY</th>
	  <th colspan="2">DECIDED  PAY SALARY</th>
	  <th rowspan="2">PRESENT DAYS</th>
      <th rowspan="2">EARNED MONEY</th>
	 <th rowspan="2">ADDITIONAL WORKING DAYS</th>
	  <th rowspan="2">NET SALARY</th>
	  <th colspan="7" >DEDUCTIONS</th>
	  <th rowspan="2" >GROSS</th>
	   <th rowspan="2" >PAYSLIP DATE</th>
	    <th rowspan="2" >SALARY DATE</th>
		 <th rowspan="2" >WORKER SIGNATURE</th>
	  
      	
	</tr>  
	
  <tr>	  
      <th>BASIC</th>
      <th>ALLOWANCE</th>
	  <th>BASIC</th>
      <th>ALLOWANCE</th>
	  <th>PF</th>
	  <th>ESI</th>
	   <th>PTAX</th>
	   <th>ELETRIC CHARGES</th>
	    <th>SALARY ADVANCE</th>
		<th>HRA</th>
	  <th>TOTAL</th>
	  
        
  </tr>
  <c:choose>
  <c:when test="${not empty getSalaryRegister}">
  <c:forEach var="map" items="${getSalaryRegister}">
   <tr>
      <td>${map.slno}</td>
      <td>${map.idno}</td>
      <td>${map.empname}</td>
	  <td>${map.Father}</td>
	  <td>${map.desgn}</td>
	  <td>${map.basic}</td>
	  <td>${map.allowance1}</td>
	  <td>${map.rbasic}</td>
	  <td>${map.allowance2}</td>
	  <td>${map.presentdays}</td>
	  <td>${map.earnedmoney}</td>
	  <td>${map.additonalworkingdays}</td>
	  <td>${map.netsalary}</td>
	  <td>${map.pfamount}</td>
	  <td>${map.esiamount}</td>
	  <td>${map.ptax}</td>
	  <td>${map.mobilededuction}</td>
	   <td>${map.salaryadvance}</td>
	  <td>${map.hra}</td>
	   <td>${map.total}</td>
	  <td>${map.gross}</td>
	  <td>${map.payslipdate}</td>
	   <td>${map.salarydate}</td>
	    <td>${map.signature}</td>
  </tr>
  </c:forEach>
  </c:when>
  </c:choose>
</table>
    </div>
	<br>
	<br>
</body>

<script type="text/javascript" src="resources/Pdf&Excel&Print/excel.js"></script> 
</html>