<%@page import="com.hrms.utitlities.DBUtil"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@ include file="header.jsp" %>
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
<script>
function getStatutoryReport(){
	var division=	$("#division").val();
	var month=	$("#month").val();
	var year=	$("#year").val();
	//window.open("SalaryStatment.jsp?division="+division+"&&year="+year+"&&month="+month);
	 $.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/HRMS/getStatutoryReport?division="+division+"&&year="+year+"&&month="+month,
		success : function(data) {
					}
				}); 
}

</script>
</head>
 

<body> 
<div id="tblCustomers">
<% 

//Filter String 
//String =request.getParameter("");

String filterString="";

int division=Integer.parseInt(request.getParameter("division"));
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));
String fldValue = request.getParameter("fld");
String fldName="";
String fldCondition="";
String fldHeading="";

if(fldValue.equalsIgnoreCase("ptax")){
	fldName=" ,sum(em.ptax) as dispFld ";
	fldCondition=" and em.ptax>0 ";
	fldHeading="Professional Tax";
}
if(fldValue.equalsIgnoreCase("esi")){
	fldName=" ,sum(em.esiamount) as dispFld ";
	fldCondition=" and em.esiamount>0 ";
	fldHeading="ESI Amount";
	
}

if(fldValue.equalsIgnoreCase("tds")){
	fldName=" ,sum(em.itax) as dispFld ";
	fldCondition=" and em.itax>0 ";
	fldHeading="Income Tax (TDS)";
}
if(fldValue.equalsIgnoreCase("insurance")){
	fldName=" ,sum(em.mediclaim) as dispFld ";
	fldCondition=" and em.mediclaim>0 ";
	fldHeading="Insurance/Mediclaim";
}
if(fldValue.equalsIgnoreCase("salaryadvance")){
	fldName=" ,sum(em.salaryadvance) as dispFld ";
	fldCondition=" and em.salaryadvance>0 ";
	fldHeading="Salary Advance";
}
if(fldValue.equalsIgnoreCase("otherdeductions")){
	fldName=" ,sum(em.otherdeduction1) as dispFld,sum(em.otherdeduction2) as dispFld1 ";
	fldCondition=" and (em.otherdeduction1+em.otherdeduction2)>0 ";
	fldHeading="Other Deduction-1</th><th width='300' >Other Deduction-2";
}

Connection connection=DBUtil.getConnection();
Statement statement=connection.createStatement();
String sql="select e.idno,e.empname,e.desgn,de.name "+fldName+" from hr_empmaster e join hr_department de on e.workdeptid=de.deptid join hr_empmonthpay em on em.idno=e.idno where e.workingdivisionid="+division+" and  em.tmonth="+month+" and em.tyear="+year+fldCondition+" group by e.idno";
ResultSet rs=statement.executeQuery(sql);


int i=1;
%>
<input type="hidden" id="division" value="<%=division %>">
<input type="hidden" id="month" value="<%=month %>">
<input type="hidden" id="year" value = "<%=year %>">
<input type="hidden" id="fld" value ="<%=fldValue %>">



<script>

function newEsiRegistration(){
	alert(">>openSalaryStatement2>>");
	var division=$("#division").val();
	var month=$("#month").val();
	var year=$("#year").val();
	//var fldValue=$("#fld").val();
	
	 $.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/HRMS/newEsiRegistration?division="+division+"&&year="+year+"&&month="+month,
		success : function(data) {
			alert("SUCCESSFULLY");
					}
				}); 
}
</script>
<h3 style="color:red" align="center"> DEDUCTION FOR THE <%=month%> Month</h3>
 <div align="right">
<input type="submit" value="ESI REGISTRATION"  onclick="newEsiRegistration()">
</div> 
	<a  align="right" onclick="getStatutoryReport()">StatutoryReport</a>
	
<table id="tblCustomers" class="nth-table" >
   <tr>
   
      <th width="300" >Slno</th>
	  <th width="300" >IDNO</th>
      <th width="300" >Employee Name</th>
	  <th width="300" >Designation</th>
	  <th width="300" >Department</th>
      <th width="300" ><%=fldHeading%></th>
	  
	</tr> 
	
<%float totValue=0;float totValue1=0;while(rs.next()) {%>
 <tr>
      <td><%=i%></td>
      <td><%=rs.getInt("idno") %></td>
      <td><%=rs.getString("empname") %></td>
	  <td><%=rs.getString("desgn") %></td>
	  <td><%=rs.getString("name") %></td>
	  <td align="right"><%=rs.getFloat("dispFld") %></td>
	  <%if(fldValue.equalsIgnoreCase("otherdeductions")){ %>
	  <td align="right"><%=rs.getFloat("dispFld1") %></td>
	  <%totValue1=totValue1+rs.getFloat("dispFld1"); %>
	  <%}%>
	  <%totValue=totValue+rs.getFloat("dispFld"); %> 	  
	   <%i=i+1; %>
  </tr>
  <% }%>
  <tr>
      <th colspan="5">*** Totals ***</td>
      <th align="right"><%=totValue %></th>
	  <%if(fldValue.equalsIgnoreCase("otherdeductions")){ %>
	  <th align="right"><%=totValue1 %></th>
	  <%}%>      
  </tr>
</table>
</div>
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