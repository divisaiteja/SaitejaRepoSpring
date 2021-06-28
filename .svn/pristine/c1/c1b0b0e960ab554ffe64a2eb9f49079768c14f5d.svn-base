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
int division=Integer.parseInt(request.getParameter("division"));
String fromdate=request.getParameter("fromdate");
String fldValue=request.getParameter("fld");
String fldCondition="";

if(fldValue.equalsIgnoreCase("PRESENT")){
	
	fldCondition=" and m.present>0";
}
  
if(fldValue.equalsIgnoreCase("OD")){
	
	fldCondition=" and m.od>0";
	
}
if(fldValue.equalsIgnoreCase("W-OFF")){
	
	fldCondition=" and m.wh>0 ";
	
}
if(fldValue.equalsIgnoreCase("LEAVE")){
	
	fldCondition=" and m.leaves>0";
	
}
if(fldValue.equalsIgnoreCase("PH")){
	
	fldCondition=" and m.ph>0";
	
}
if(fldValue.equalsIgnoreCase("LOP")){
	
	fldCondition="and m.lop>0";
	
}
if(fldValue.equalsIgnoreCase("OVERTIME")){
	
	fldCondition=" and m.overtime>0";
	
}

 Connection connection=DBUtil.getConnection(); 
Statement statement=connection.createStatement();
String sql="select e.idno,e.empname,e.desgn,d.name,p.projectname from hr_empmaster e join hr_muster m on e.idno=m.idno join hr_projects p on p.tranid=e.project join hr_department d on d.deptid=e.workdeptid and m.attdate='"+fromdate+"' and  e.workingdivisionid="+division+" "+fldCondition+"  order by e.jobtype,e.idno";
ResultSet rs=statement.executeQuery(sql); 
int i=1;
%>
<input type="hidden" id="division" <%=division %>>
<input type="hidden" id="fromdate" <%=fromdate %>>
<h3 style="color:gray" align="center"> EMPLOYEE <%=fldValue%>  AS ON <%=fromdate %></h3>
<table id="tblCustomers" class="nth-table" >
   <tr>
   
      <th width="200">Slno</th>
	  <th width="200">IDNO</th>
      <th width="200">Employee Name</th>
	  <th width="200">Designation</th>
	  <th width="200">Department</th>
      <th width="200">Project</th> 
	  
	</tr> 
<%while(rs.next()) {%>
 <tr>
      <td><%=i %></td>
      <td><%=rs.getInt("idno") %></td>
      <td><%=rs.getString("empname") %></td>
	  <td><%=rs.getString("desgn") %></td>
	  <td><%=rs.getString("name") %></td>
	  <td><%=rs.getString("projectname") %></td>
	  <%i=i+1; %>
  </tr>
  <%}%>
</table>
    <br/>
    <input type="button" id="btnExport" value="Export" />
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
                    pdfMake.createPdf(docDefinition).download("<%=fldValue%>");
                }
            });
        });
    </script>
</body>
</html>