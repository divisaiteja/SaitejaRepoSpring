<%@page import="com.fasterxml.jackson.annotation.JsonFormat.Value"%>
<%@page import="java.util.*"%>
<%@page import ="java.text.SimpleDateFormat"%>
<html>
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
 String fromdate=request.getParameter("fromdate");
 String todate=request.getParameter("todate");
 java.sql.Date startdate=java.sql.Date.valueOf(fromdate);
 java.sql.Date enddate=java.sql.Date.valueOf(todate);
 SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
 int rspan=0;
 String cname="";
 String ci="";
 
 
%> 
<%
	  List<Object> list = (List<Object>)request.getAttribute("dateAndDayName");
      if(request.getAttribute("dateAndDayName")!=null){
    
	for(Object name: list){
	   System.out.println(name);
	  cname+="<th>"+name+ "</th> ";
	  rspan+=1;
	}
 }
 int cspan=20+rspan;     
 %>
<table id="tblCustomers" class="nth-table" >
 <tr>
   <th colspan=<%=cspan%>> FORM &nbsp;12&&nbsp;25 X, V REGISTER &nbsp; OF &nbsp; ADULT &nbsp; WORKER &nbsp; UNDER &nbsp; RULE &nbsp; 80&nbsp; & &nbsp;103 &nbsp; OF &nbsp; THE  &nbsp; REGISTER &nbsp; OF &nbsp; WAGES(RULE &nbsp; OF &nbsp; M.W.ACT) 

<br>
WAGES &nbsp PERIOD &nbsp FROM  <%=format.format(startdate)%>   &nbsp&nbsp    TO   <%=format.format(enddate)%>
   </th>
 </tr>
 
  <tr>
      <th rowspan="2">S.NO</th>
      <th rowspan="2">NAME OF THE WORKER</th>
	  <th rowspan="2" >M/F</th>
	  <th rowspan="2">FATHER NAME</th>
	  <th rowspan="2">NATURE OF THE WORK</th>
	  <th rowspan="2">LETTER OF GROUP AS IN FORM NO.XI</th>
	  <th rowspan="2">NO.OF RELY IF WORKING IN SHIFT</th>
      <th colspan="2">WORKING HOURS</th>
	  <th colspan="2" >NO. & DATE CERTIFICATE ANY ADOLES </th>
      <th colspan= "<%=rspan%>">DAYS OF WEEK</th>	  
	  <th rowspan="2">TOTAL WEEKLY HOURS</th>
      <th rowspan="2">NO OF DAYS WHICH WAGES CALCULATED</th>
     <th rowspan="2">RATE OF WAGES</th>	  
	   <th rowspan="2">OTHER ALLOWENCE</th>	 
     <th rowspan="2">OT</th>	
    <th rowspan="2">GROSS AMOUNT OF WAGES EARNED</th>
   <th rowspan="2">TOTAL DEDUCTIONS DUE TO ADVANCE ETC</th>
    <th rowspan="2">NET AMOUNT OF WAGES PAID</th>
<th rowspan="2">DATE OF PAYMENT OF WAGES & SIGNATURE OF WORKER</th>			 
	</tr>  
	
  <tr>	  
      <th>FROM</th>
      <th>TO</th>
	  <th>NO.OF CERTIFICATE AND DATE</th>
	  <th>TOKEN NO.GIVEN REFERENCE TO THE</th>
	   <%=cname%>
  </tr>
  
   <c:choose>
  <c:when test="${not empty getFormTwelve }">
  <c:forEach var="map" items="${getFormTwelve}">
  
   <tr>
      <td>${map.slno}</td>
      <td>${map.employeename}</td>
      <td>${map.Father}</td>
	  <td>${map.desgn}</td>
	  <td>${map.GroupNo}</td>
	  <td>${map.RelayNo}</td>
	  <td>${map.From}</td>
	  <td>${map.To}</td>
	  <td>0</td>
	  <td>0</td>
	   <td>0</td>
  <c:forEach var="map1" items="${map}">
 <%  
	for(int i=1;i<=rspan;i++){
		ci+="<td>"+i+ "</td> ";
	}   
 %> 
    </c:forEach>
	  <td>0</td>
	  <td>0</td>
	  <td>0</td>
	  <td>0</td>
	  <td>0</td>
	  <td>0</td>
	  <td>0</td>
	  <td>0</td>      
  </tr>
  </c:forEach>
  </c:when>
  </c:choose>
    
</table>

    <br />
	<input type="button" value="Print" id="dvContainer" onclick="window.print()" /> 

	<br>
	<br>
</body>
</html>