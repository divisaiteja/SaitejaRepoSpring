<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.hrms.utitlities.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <%@include file="header.jsp" %> --%>
<html xmlns="http://www.w3.org/1999/xhtml">
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
<div id="tblCustomers">
<% 
int division=Integer.parseInt(request.getParameter("division"));
String fromdate =request.getParameter("fromdate");

%>
<h3 align="center">Daily Attendance :: Strength Report </h3>
<input type="hidden" id="division" value="<%=division%>">
<input type="hidden" id=fromdate value="<%=fromdate%>">

 <div align="right">
    <input type="button" id="btnExport" value="Export" >
    </div>
  
    <table  class="nth-table" >

  <tr>
      <th rowspan="3" >Sno</th>
      <th rowspan="3" >Project</th>
      <th colspan="7" >Attendance Status</th>	
	  <th colspan="2" rowspan="2"><a href="DailyAttendenceIndividual.jsp?division=<%=division %>&&fromdate=<%=fromdate%>&&fld=OVERTIME" target="_blank">Ot.Hours</a></th>
	  <th rowspan="3">Remarks</th>	  
	</tr>  
  <tr>	  
      <th colspan="2"><a href="DailyAttendenceIndividual.jsp?division=<%=division%>&&fromdate=<%=fromdate%>&&fld=PRESENT" target="_blank">Present</a></th>
	  <th rowspan="2"><a href="DailyAttendenceIndividual.jsp?division=<%=division %>&&fromdate=<%=fromdate%>&&fld=OD" target="_blank">OD</a></th>
	  <th rowspan="2"><a href="DailyAttendenceIndividual.jsp?division=<%=division %>&&fromdate=<%=fromdate%>&&fld=W-OFF" target="_blank">W-Off</a></th>
	  <th rowspan="2"><a href="DailyAttendenceIndividual.jsp?division=<%=division %>&&fromdate=<%=fromdate%>&&fld=LEAVE" target="_blank">leave</a></th>
	  <th rowspan="2"><a href="DailyAttendenceIndividual.jsp?division=<%=division %>&&fromdate=<%=fromdate%>&&fld=PH" target="_blank">Ph</a></th>
	  <th rowspan="2"><a href="DailyAttendenceIndividual.jsp?division=<%=division %>&&fromdate=<%=fromdate%>&&fld=LOP" target="_blank">Lop</a></th>
  </tr>
  <tr>
	  <th>Emp</th>
	  <th>Cont</th>
	  <th>Emp</th>
	  <th>Cont</th>
  </tr>
  <c:choose>
  <c:when test="${not empty listEmployees}">
  <c:forEach var="map" items="${listEmployees}">
   <tr align="center">
      <td>${map.slno}</td>
      <td align="left">${map.deptName}</td>
	  <td>${map.empPresent}</td>
	  <td>${map.conPresent}</td>
	  <td>${map.empOD}</td>
	  <td>${map.empWH}</td>
	  <td>${map.empLeaves}</td>
	  <td>${map.empPH}</td>
	  <td>${map.empLOP}</td>
	  <td>${map.empOT}</td>
	  <td>${map.conOT}</td>
	  <td>&nbsp;</td>
  </tr>
  </c:forEach>
  </c:when>
  </c:choose>
</table>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script type="text/javascript">
        $("body").on("click", "#btnExport", function () {
            html2canvas($('#tblCustomers')[0], {
                onrendered: function (canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("DailyAttendenceReport");
                }
            });
        });
    </script>
    </div>
</body>
<%-- <%@include file="footer.jsp" %> --%>
</html>