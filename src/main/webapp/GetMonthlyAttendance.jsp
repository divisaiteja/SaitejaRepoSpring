<%@page import="java.text.DateFormatSymbols"%>
<%@page import ="java.time.YearMonth" %>
<%@page import="java.time.LocalDate"%>
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
int division=Integer.parseInt(request.getParameter("division"));
int project=Integer.parseInt(request.getParameter("project"));
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));

YearMonth yearMonth = YearMonth.of( year, month );  // January of 2015.
LocalDate first = yearMonth.atDay( 1 );
LocalDate last = yearMonth.atEndOfMonth();
java.sql.Date startdate=java.sql.Date.valueOf(first);
java.sql.Date enddate=java.sql.Date.valueOf(last);
SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
%>

<input type="hidden" id="division" value="<%=division%>">
<input type="hidden" id="month" value="<%=month%>">
<input type="hidden" id="year" value="<%=year%>">
<input type="hidden" id="project" value="<%=project%>">

<input type="image"  src="resources/assets/images/excel.png" height="30" width="30" onclick="exceller()" >  &nbsp; &nbsp;  
 <input type="image" src="resources/assets/images/printer.png" height="30" width="30"  onclick="window.print()" >    &nbsp; &nbsp;<div id="dvContainer">
<table id="excel" class="nth-table" >
 <tr>
 <th colspan="50"><B>MUSTER ROLL FORM 25 UNDER RULE 103 WAGES</B></th>
 </tr>
  <tr>
      <th rowspan="2">S.NO</th>
      <th rowspan="2">ID.NO</th>
	  <th rowspan="2">NAME OF THE WORKER</th>
	  <th rowspan="2">FATHER NAME</th>
	  <th rowspan="2">DESIGNATION</th>
	  <th rowspan="2">GROUP NO</th>
	  <th rowspan="2">RELYNO</th>
      <th colspan="4">HOUR OF WORKING</th>
	  <th colspan="31">MONTH :  <%=new DateFormatSymbols().getMonths()[month-1] %> &nbsp;<%=year%>   &nbsp; &nbsp;  FROM DATE: <%=format.format(startdate) %>   &nbsp; &nbsp; &nbsp; &nbsp;   TO DATE:<%=format.format(enddate) %> </th>
      <th rowspan="2" >NO.OF DAYS WORKED</th>	  
	  <th rowspan="2">RATE OF WAGES</th>	
	  <th rowspan="2">GROSS AMOUN WAGES EARNED</th>	
	  <th rowspan="2">TOTAL DEDUCTION DUE TO ADVANCE ETC</th>
     <th rowspan="2">NET AMOUNT</th>
     <th rowspan="2">SIGNATURE OF EMPLOYEE</th>	  
	</tr>  
	
  <tr>	  
      <th>FROM</th>
      <th>TO</th>
	  <th>FROM</th>
	  <th>TO</th>
	  <th>1</th>
	  <th>2</th>
	  <th>3</th>
	  <th>4</th>
	  <th>5</th>
	  <th>6</th>
	  <th>7</th>
	  <th>8</th>
	  <th>9</th>
	  <th>10</th>
	  <th>11</th>
	  <th>12</th>
	  <th>13</th>
	  <th>14</th>
	  <th>15</th>
	  <th>16</th>
	  <th>17</th>
	  <th>18</th>
	  <th>19</th>
	  <th>20</th>
	  <th>21</th>
	  <th>22</th>
	  <th>23</th>
	  <th>24</th>
	  <th>25</th>
	  <th>26</th>
	  <th>27</th>
	  <th>28</th>
	  <th>29</th>
	  <th>30</th>
	  <th>31</th>
        
  </tr>
  <c:choose>
  <c:when test="${not empty monthlyAttendence }">
  <c:forEach var="map" items="${monthlyAttendence}">
   <tr>
      <td>${map.slno}</td>
      <td>${map.idno}</td>
      <td>${map.employeename}</td>
	  <td>${map.Father}</td>
	  <td>${map.desgn}</td>
	  <td>${map.GroupNo}</td>
	  <td>${map.RelayNo}</td>
	  <td>${map.From}</td>
	  <td>${map.To}</td>
	  <td>${map.From}</td>
	  <td>${map.To}</td>
	 <%--  while(d1<=d2){
	  <td>${map.d1}</td>
	  d1=d1+1;
	  } --%>
	  <td>${map.c2}</td>
	  <td>${map.c3}</td>
	  <td>${map.c4}</td>
	  <td>${map.c5}</td>
	  <td>${map.c6}</td>
	  <td>${map.c7}</td>
	  <td>${map.c8}</td>
	  <td>${map.c9}</td>
	  <td>${map.c10}</td>
	   <td>${map.c11}</td>
	  <td>${map.c12}</td>
	   <td>${map.c13}</td>
	  <td>${map.c14}</td>
       <td>${map.c15}</td>
	   <td>${map.c16}</td>
	  <td>${map.c17}</td>
	   <td>${map.c18}</td>
	  <td>${map.c19}</td>
	   <td>${map.c20}</td>
	   <td>${map.c21}</td>
	  <td>${map.c22}</td>
	   <td>${map.c23}</td>
	  <td>${map.c24}</td>
	   <td>${map.c25}</td>
	   <td>${map.c26}</td>
	  <td>${map.c27}</td>
	   <td>${map.c28}</td>
	  <td>${map.c29}</td>
	   <td>${map.c30}</td>
	   <td>${map.c31}</td>
	  <td>${map.TPre}</td>
	   <td>${map.rateofwages}</td>
	  <td>${map.gross}</td>
	   <td>${map.total}</td>
	   <td>${map.netamount}</td>
	    <td>${map.signature}</td>
	  
  </tr>
  </c:forEach>
  </c:when>
  </c:choose>
</table>
</div>
</body>

<script type="text/javascript" src="resources/Pdf&Excel&Print/excel.js"></script> 
</html>