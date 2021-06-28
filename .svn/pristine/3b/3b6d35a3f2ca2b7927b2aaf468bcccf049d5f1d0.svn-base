<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.hrms.utitlities.DBUtil"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%HttpSession sess=request.getSession();
String username=(String)sess.getAttribute("username");

%>
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
<h3 style="color:red" align="center"> SALARY STATEMENT </h3>
<%

int division=Integer.parseInt(request.getParameter("division"));
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));
int rows=0;
int slno=1;
if(username!=null){
	Connection con=DBUtil.getConnection();
	Statement stm=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	String sql=null;
	Statement stminner=null;
	sql="select e.empname,e.idno,e.desgn,d.name,h.rbasic,h.rhra,h.rconveyance,h.rotherallowance1,h.rotherallowance2,h.lopdays,h.paiddays,h.mondays from hr_empmonthpay h join hr_empmaster e on e.idno=h.idno join hr_department d on d.deptid=e.workdeptid where h.tmonth="+month+" and h.tyear="+year+" and e.workingdivisionid="+division +" and isarrearsrecord=0" ;
	stm=con.createStatement();
	rs=stm.executeQuery(sql);
	System.out.println(sql);
	int i=1;	
	
	
%>
<table id="tblCustomers" class="nth-table" >

  <tr>
      <th rowspan="2">Slno</th>
	  <th rowspan="2">IDNO</th>
      <th rowspan="2">Employee Name,/Desingnation,Department</th>
	  <th rowspan="2">Pay Days</th>
	  <th rowspan="2">Lop Days</th>
      <th colspan="5" ><----------Earnings----------></th>
      <th colspan="8" ><----------Deductions----------></th>	  
	  <th rowspan="2">NetSalary</th>	  
	</tr>  
  <tr>	  
      <th>Basic</th>
      <th>Hra</th>
	  <th>Conv.Al</th>
	  <th>Other.Al</th>
	  <th>Gross.Total</th>
	  <th>PF</th>
	  <th>P.Tax</th>
	  <th>ESI</th>
	  <th>TDS</th>
	  <th>Insurance</th>
	  <th>Sal.Adv</th>
	  <th>Oth.Ded</th>
	  <th>Total</th>
  </tr>
  <%while(rs.next()){ 
     rows=5;
  %>
   <tr>
      <td rowspan=5><%=slno%></td>
      <td rowspan=5><%=rs.getInt(2) %></td>
      <td rowspan=5>Emp Name: <%=rs.getString(1) %><br>EmpId: <%=rs.getInt(2) %> <br>Designation: <%=rs.getString(3) %> <br>Department: <%=rs.getString(4) %> </td>
	  <td rowspan=5><%=rs.getInt("paiddays")%></td>
	  <td rowspan=5><%=rs.getInt("lopdays")%></td>
	  <%
	  stminner=con.createStatement();
	  String sqlinner="select h.basic,h.hra,h.conveyance,h.otherearnings1,h.otherearnings2,h.grossearnings,h.pfamount,h.ptax,h.esiamount,h.salaryadvance,h.touradvance,h.itax,h.mediclaim,h.otherdeduction1,h.otherdeduction2,h.grossdeductions,h.netamount from hr_empmonthpay h where h.idno="+rs.getInt(2)+" and h.tmonth="+month+" and h.tyear="+year;	  
	 rs1=stminner.executeQuery(sqlinner);
	 while(rs1.next()){
		 
	 
	  %>
	  <td><%=rs1.getInt(1) %></td>
	  <td><%=rs1.getInt(2) %></td>
	  <td><%=rs1.getInt(3) %></td>
	  <td><%=rs1.getInt(4) +rs1.getInt(5)%></td><!-- othererarnings -->
	  <td><%=rs1.getInt(6) %></td>
	  <td><%=rs1.getInt(7) %></td><!-- pf amount -->
	  <td><%=rs1.getInt(8) %></td>
	  <td><%=rs1.getInt(9) %></td><!-- ESI -->
	  <td><%=rs1.getInt(12) %></td>
	 <td><%=rs1.getInt(13) %></td><!-- mediclain -->
	   <td><%=rs1.getInt(10) %></td>
	  <td><%=rs1.getInt(14) +rs1.getInt(15)%></td>
	   <td><%=rs1.getInt(16) %></td>
	   <td><%=rs1.getInt(17) %></td>
	  
  </tr>
  <%    rows=rows-1;
          } 
    while(rows>1){
  %>
   
   <tr>
	  <td> &nbsp </td>
	  <td></td>
	  <td></td>
	  <td></td>
	  <td></td>
	  <td></td>
	  <td></td>
	  <td></td>
	  <td></td>
	  <td></td>
	  <td></td>
	  <td></td>
	  <td></td>
	  <td></td>	  
  </tr>
   <%
       rows=rows-1;
      } %>

   <tr>
	  <td style="color:RED"><%=rs.getInt(5) %></td>
	  <td style="color:RED"><%=rs.getInt(6) %></td>
	  <td style="color:RED"><%=rs.getInt(7) %></td>
	  <td style="color:RED"><%=rs.getInt(8)+rs.getInt(9) %></td>
	  <td style="color:RED"><%=rs.getInt(5)+rs.getInt(6)+rs.getInt(7)+rs.getInt(8)+rs.getInt(9) %></td>
	  <td></td>
	  <td colspan="8">
	  <%if(rs.getInt(10)>0){ %>
	 <font style="color: red"> Lop Days : <%=rs.getInt(10) %>; DOJ : 02/06/2019</font>
	  <%}else{ %>
	  
	  <%} %>
	  </td>
  </tr>
   
<%slno=slno+1;} %>

</table>
    <br />
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
                    pdfMake.createPdf(docDefinition).download("PaySheet");
                }
            });
        });
    </script>
    <%}else{
    	response.sendRedirect("login");
    	}%>
    
</body>
</html>