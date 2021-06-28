<%@page import="com.hrms.utitlities.DBUtil"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
     <style>
.nth-table {
    border-collapse: collapse;
    border: 1px solid #400040;
  }
 .nth-table tr:nth-child(odd){
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
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));
int iYear = year;
int iMonth = month-1; // 1 (months begin with 0)
int iDay = 1;

// Create a calendar object and set year and month
Calendar mycal = new GregorianCalendar(iYear, iMonth, iDay);

// Get the number of days in that month
int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
Connection con=DBUtil.getConnection();
Statement stm=null;
ResultSet rs=null;
String sql=null;
//select  e.empname,e.desgn,d.name,31,sum(h.present),sum(h.od),sum(h.wh),sum(h.leaves),sum(h.leaves),sum(h.leaves),sum(h.leaves),sum(h.ph),sum(h.lop),31-sum(h.lop) from hr_muster h join hr_empmaster e on e.idno=h.idno join hr_department d on d.deptid=e.workdeptid where tmon=6 and tyear=2019 ;
stm=con.createStatement();
sql="select  e.idno,e.empname,e.desgn,d.name,"+daysInMonth+",sum(h.present),sum(h.od),sum(h.wh),sum(h.leaves),sum(h.leaves),sum(h.leaves),sum(h.leaves),sum(h.ph),0,sum(h.lop),sum(h.lop),31-sum(h.lop),'Remarks' from hr_muster h join hr_empmaster e on e.idno=h.idno join hr_department d on d.deptid=e.workdeptid where h.tmon="+month+" and h.tyear="+year ;
rs=stm.executeQuery(sql);
int i=1;
%>
<div align="right">
    <input type="button" id="btnExport" value="Export" >
    </div>
    <h3 align="center">MonthlyReport</h3>
     <table id="tblCustomers" class="nth-table">
  		<tr>
      <th rowspan="2">Sno</th>
      <th rowspan="2">IDNO</th>
      <th rowspan="2">EmployeeName</th>
      <th rowspan="2">Designation</th>
	  <th rowspan="2">Department</th>
      <th rowspan="2">MonthDays</th>
      <th colspan="2">Present</th>
	  <th rowspan="2">WOff</th>
	  <th colspan="4">Leaves</th>
	  <th rowspan="2">PH</th>
	  <th colspan="3">Absent/Lop</th>
	  <th rowspan="2">PayDays</th>
	  <th rowspan="2">Remarks</th>
  </tr>
  <tr>
	  <th>PHY</th>
	  <th>OD</th>
	  <th>CL</th>
	  <th>SL</th>
	  <th>EL</th>
	  <th>CO</th>
	  <th>PREV-MON</th>
	  <th>CURR-MON</th>
	  <th>TOTAL</th>
  </tr>  
 <%while(rs.next()){ %>
  <tr>
	<td><%=i%></td>
	<td><%=rs.getInt(1) %></td>
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
	<td><%=rs.getInt(5) %></td>
	<td><%=rs.getFloat(6) %></td>
	<td><%=rs.getFloat(7) %></td>
	<td><%=rs.getFloat(8) %></td>
	<td><%=rs.getFloat(9) %></td>
	<td><%=rs.getFloat(10) %></td>
	<td><%=rs.getFloat(11) %></td>
	<td><%=rs.getFloat(12) %></td>
	<td><%=rs.getFloat(13) %></td>
	<td><%=rs.getFloat(14) %></td>
	<td><%=rs.getFloat(15) %></td>
	<td><%=rs.getFloat(16) %></td>
	<td><%=rs.getFloat(17) %></td>
	<%
	stm=con.createStatement();
	sql="select day(attdate) from hr_muster where idno="+rs.getInt(1)+" and tmon="+month+" and tyear="+year+" and lop>0";
	ResultSet rsForRemarks=stm.executeQuery(sql);
	StringBuilder sb=new StringBuilder();
	while(rsForRemarks.next()){
		sb.append(rsForRemarks.getInt(1)+",");
	}
	%>
	<td><%=sb %></td>
     </tr>
   <%
 i=i+1;  
 } %>
</div>


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
                    pdfMake.createPdf(docDefinition).download("MonthlyAttendence.pdf");
                }
            });
        });
    </script>
    <%con.close(); %>
</body>
</html>