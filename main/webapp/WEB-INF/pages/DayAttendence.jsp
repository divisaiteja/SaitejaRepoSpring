<%@page import="java.sql.*"%>
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
Statement stm=null;
ResultSet rs=null;
String sql=null;
stm=connection.createStatement();
sql="";
rs=stm.executeQuery(sql);
int i=1;
%>
<div align="right">
    <input type="button" id="btnExport" value="Export" >
    </div>
    <h3 align="center">DayAttendance </h3>
<table id="tblCustomers" class="nth-table" >
   <tr>
      <th width="300" >Slno</th>
	  <th width="300" >IDNO</th>
      <th width="300" >Employee Name</th>
	  <th width="300" >Designation</th>
	  <th width="300" >Department</th>
      <th width="300" >Attended Shifts</th>
      <th width="300" >In-punch Count</th>	  
	  <th width="300" >Out-punch Count</th>
      <th width="300" >Duty Hour</th>	  
	  <th width="300" >OT Hour</th>	  
	  <th width="300" >Remarks</th>
	  
	</tr> 
<%while(rs.next())  { %>
     <tr>
      <td><%=i%></td>
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
                    pdfMake.createPdf(docDefinition).download("DayAttendence");
                }
            });
        });
    </script>
</body>
</html>