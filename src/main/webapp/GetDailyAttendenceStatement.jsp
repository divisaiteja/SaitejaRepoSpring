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

%>
<h3 align="center"> Attendance Report </h3>
<input type="hidden" id="division" value="<%=division%>">

 <div align="right">
    <input type="button" id="btnExport" value="Export" >
    </div>
  
<table id="data" class="nth-table" >

  <tr>	  
      <th>Sno</th>
      <th>Employee Name</th>
      <%
          int i=1;
          while(i<32){
              %>
      <th><%=i%></th> 
      <%
         i=i+1; }
      %>
	  <th>Remarks</th>
  </tr>
<!--  <c:choose>
  <c:when test="${not empty listEmployees}">-->
  <c:forEach var="map" items="${listEmployees}">
   <tr align="center">
      <td>${map.slno}</td>
      <td align="left">${map.EmployeeName}</td>           
      <td>${map.C1}</td> 
      <td>${map.C2}</td> 
      <td>${map.C3}</td>
      <td>${map.C4}</td>
      <td>${map.C5}</td>
      <td>${map.C6}</td>
      <td>${map.C7}</td>
      <td>${map.C8}</td>
      <td>${map.C9}</td>
      <td>${map.C10}</td>
      <td>${map.C11}</td>
      <td>${map.C12}</td>
      <td>${map.C13}</td>
      <td>${map.C14}</td>
      <td>${map.C15}</td>
      <td>${map.C16}</td>
      <td>${map.C17}</td>
      <td>${map.C18}</td>
      <td>${map.C19}</td>
      <td>${map.C20}</td>
      <td>${map.C21}</td>
      <td>${map.C22}</td>
      <td>${map.C23}</td>
      <td>${map.C24}</td>      
      <td>${map.C25}</td>
      <td>${map.C26}</td>
      <td>${map.C27}</td>
      <td>${map.C28}</td>
      <td>${map.C29}</td>
      <td>${map.C30}</td>
      <td>${map.C31}</td>
      <td>${map.Remarks}</td>
  </tr>
  </c:forEach>
<!--  </c:when>
  </c:choose>-->

</table>
    <!-- <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
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
    </script> -->
    </div>
</body>
<%-- <%@include file="footer.jsp" %> --%>
</html>