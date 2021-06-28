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

.nth-table tr:nth-child() {
	background: #ebf7d4;
}

.nth-table th {
	border: 1px dotted #460046;
	color: #000;
	padding: 5px;
	background-color: #AFD8D8;
}

.nth-table td {
	border: 1px dashed #000;
	color: #002F5E;
	padding: 5px;
	width: 100px;
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
  sql="select em.idno, em.empname,pe.accountnumber,pm.netamount from hr_empmaster em join hr_personaldetails pe join hr_empmonthpay pm where em.idno and pe.parentid and pm.idno";
  rs=stm.executeQuery(sql);
int i=1;

%>
	<div align="right">
		<input type="button" id="btnExport" value="Export">
	</div>
	<h3 align="center">Bank Statement</h3>
	<table id="tblCustomers" class="nth-table">
		<tr>
			<th width="300">SLNO</th>
			<th width="300">IDNO</th>
			<th width="300">EMPLOYEE NAME</th>
			<th width="300">BANK ACCOUNT</th>
			<th width="300">NET AMOUNT</th>
		</tr>
		<%while(rs.next()){ %>
		<tr>
			<td><%=i%></td>
			<td><%=rs.getInt("idno") %></td>
			<td><%=rs.getString("empname")%></td>
			<td><%=rs.getString("accountnumber") %></td>
			<td><%=rs.getFloat("netamount")%></td>
			<% 
	  i=i+1;
	  }
	  %>
		</tr>
	</table>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
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
                    pdfMake.createPdf(docDefinition).download("BankStatement.pdf");
                }
            });
        });
    </script>
	<%connection.close(); %>
</body>
</html>