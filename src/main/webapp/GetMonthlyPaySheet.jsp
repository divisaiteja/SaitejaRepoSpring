<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.text.DateFormatSymbols"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ include file="header.jsp" %> --%>

<!DOCTYPE html>
<html>
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
<script>

function openSalaryStatement(){
	var division=	$("#division").val();
	var month=	$("#month").val();
	var year=	$("#year").val();
	//window.open("SalaryStatment.jsp?division="+division+"&&year="+year+"&&month="+month);
	 $.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/HRMS/salarystmt?division="+division+"&&year="+year+"&&month="+month,
		success : function(data) {
					}
				}); 
}
</script>
</head>
<body>

<%
int division=Integer.parseInt(request.getParameter("division"));
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));
%>
<body>

<input type="hidden" id="division" value="<%=division%>">
<input type="hidden" id="month" value="<%=month%>">
<input type="hidden" id="year" value="<%=year%>">


<body> 
<div id="tblCustomers">
<h3 style="color:red" align="center"> PAY SHEET FOR THE MONTH OF  <%=new DateFormatSymbols().getMonths()[month-1] %> <%=year%></h3>
<div align="right">
<input type="submit" value="DetailedView" style="background-color: yellow;border-radius: 50%;width:10%;outline: none;" onclick="openSalaryStatement()">
</div>
<br>
<table  class="nth-table" >
 
  <tr>
      <th rowspan="2">Sno</th>
      <th rowspan="2">Department/Cost Center Name</th>
	  <th rowspan="2" >Count Of Strenth</th>
      <th colspan="5" >Earnings</th>
      <th colspan="8" >Deductions</th>	  
	  <th rowspan="2">NetSalary</th>	
	</tr>  
  <tr>	  
      <th>Basic</th>
      <th>Hra</th>
	  <th>Conv.Al</th>
	  <th>Other.Al</th>
	  <th>Gross.Total</th>
	  <th><a href="PFReport.jsp?division=<%=division%>&&month=<%=month%>&&year=<%=year%>" target="_blank">PF</a></th>
	  <th><a href="Deductions.jsp?division=<%=division%>&&month=<%=month%>&&year=<%=year%>&&fld=ptax" target="_blank">P.Tax</a></th>
	  <th><a href="Deductions.jsp?division=<%=division%>&&month=<%=month%>&&year=<%=year%>&&fld=esi" target="_blank">ESI</a></th>
	  <th><a href="Deductions.jsp?division=<%=division%>&&month=<%=month%>&&year=<%=year%>&&fld=tds" target="_blank">TDS</a></th>
	  <th><a href="Deductions.jsp?division=<%=division%>&&month=<%=month%>&&year=<%=year%>&&fld=insurance" target="_blank">Insurance</a></th>
	  <th><a href="Deductions.jsp?division=<%=division%>&&month=<%=month%>&&year=<%=year%>&&fld=salaryadvance" target="_blank">Sal.Adv</a></th>
	  <th><a href="Deductions.jsp?division=<%=division%>&&month=<%=month%>&&year=<%=year%>&&fld=otherdeductions" target="_blank">Oth.Ded</a></th>
	  <th>Total</th>
        
  </tr>
   <c:choose>
  <c:when test="${not empty pay}">
  <c:forEach var="map" items="${pay}">
    <tr>
      <td>${map.slno}</td>
      <td>${map.name}</td>
      <td>${map.count}</td> <!-- countStrength -->
	  <td>${map.basic}</td> <!-- basic -->
	  <td>${map.hra}</td> <!-- hra -->
	  <td>${map.conveyance}</td>
	  <td>${map.otherearnings}</td>
	  <td>${map.grossearnings}</td>
	  <td>${map.pfamount}</td>
	  <td>${map.ptax}</td><!-- Tax  -->
	  <td>${map.esiamount}</td><!-- ESi  -->
	  <td>${map.esiamount}</td><!-- itax   -->
	  <td>${map.touradvance}</td>
	  <td>${map.itax}</td>
	  <td>${map.mediclaim}</td>
	  <td>${map.otherdeduction}</td><!-- total   -->
	  <td>${map.netamount}</td><!-- netsalary   --> 
  </tr>
  </c:forEach>
  </c:when>
  </c:choose>
</table>
    <br />
    <button>Export</button>
     <script type="text/javascript">
    $(function(){
        $('button').click(function(){
        	var a = document.createElement('a');
        	var data_type='data:application/vnd.ms-excel';
        	a.href=data_type+','+ encodeURIComponent($('#tblCustomers').html()) 
            a.download = 'paysheet.xls';
        	a.click();
            return (a);
        })
    })
      
    </script>
	
	<br>
	<br>
	<table width="100%" id="tblEmpMonthStatus" class="nth-table" >
	
	
    <tr valign="top">
      <td width="50%" colspan="5"><b><u>New Joinings</b></u> <br><br>
	     	<table class="nth-table" width="100%" >
	     	
			   <tr>
			   <td></td>
			  
			   </tr>
			 
	
			</table>
	    
	  </td>
	  
      <td colspan="5"><b><u>Left Employees</b></u> <br><br>
	     	<table  class="nth-table" width="100%">
	    
			   <tr>
			   <td></td>
			  
			   </tr>
			   
			</table>
	    
	  </td>

</tr>
</table>
</body>
</div>
</html>