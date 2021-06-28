<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.hrms.utitlities.DBUtil"%>
<%@page import="java.sql.Connection"%>
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
<%
Connection connection=DBUtil.getConnection();
Statement statement=null;
String sql=null;
ResultSet rs=null;
statement=connection.createStatement();
sql="";
rs=statement.executeQuery(sql);
int i=1;

%>


<div align="right">
    <input type="button" id="btnExport" value="Export" >
    </div>
    <h3 align="center">Daily Attendance </h3>

<table id="tblCustomers" class="nth-table" >

  <tr>
      <th rowspan="3">Sno</th>
      <th rowspan="3">Department/section</th>
      <th colspan="15">Attendance Status</th>	
	  <th colspan="2" rowspan="2">Ot.Hours</th>
	  <th rowspan="3">Remarks</th>	  
	</tr>  
  <tr>	  
      <th colspan="2">ShiftA</th>
      <th colspan="2">ShiftB</th>
	  <th colspan="2">ShiftC</th>
      <th colspan="2">General</th>
      <th colspan="2">TotalPresent</th>
	  <th rowspan="2">OD</th>
	  <th rowspan="2">W-Off</th>
	  <th rowspan="2">leave</th>
	  <th rowspan="2">Ph</th>
	  <th rowspan="2">Lop</th>
	  
	  
  </tr>
  <tr>
	  <th>Emp</th>
	  <th>Cont</th>
	  <th>Emp</th>
	  <th>Cont</th>
	  <th>Emp</th>
	  <th>Cont</th>
	  <th>Emp</th>
	  <th>Cont</th>
	  <th>Emp</th>
	  <th>Cont</th>
	  <th>Emp</th>
	  <th>Cont</th>
  </tr>
  
  <%while(rs.next()) { %>
   <tr>
      <td><%=i %></td>
      <td><% %></td>
      <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <td><% %></td>
	  <% 
	  i=i+1;
      }
	  %>
  </tr>
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
</body>
</html>