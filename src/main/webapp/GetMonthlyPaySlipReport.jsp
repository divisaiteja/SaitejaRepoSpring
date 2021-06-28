<%-- <%@include file="header.jsp" %>
<%@page import="com.hrms.utitlities.constants"%>
<%@page import="com.hrms.utitlities.DBUtil"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%HttpSession sess=request.getSession(); 
String username=(String)sess.getAttribute("username");
%>
<head>
    <title></title>
     <style>
.nth-table {
    border-collapse: collapse;
    border: 1px solid #400040;
  }
 .nth-table tr:nth-child(even){
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
if(username!=null){
int division=Integer.parseInt(request.getParameter("division"));
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));
int idNumber=Integer.parseInt(request.getParameter("idNumber"));

Connection connection=DBUtil.getConnection();
Statement statement=null;
ResultSet rs=null;
statement=connection.createStatement();

String sql="select e.idno,e.empname,e.desgn,d.name,em.rbasic,em.rhra,em.rconveyance,em.rotherallowance1,em.rlta,em.rmedical,em.rotherallowance2,em.netamount, em.remarks,r.grosssalary,sum(h.present),sum(h.wh),sum(h.od),sum(h.ph),sum(h.leaves),sum(h.lop), em.paiddays,"
+"p.accountnumber,p.bankname,p.bankBranch,p.pancardnumber,r.uannumber,r.esinumber,"
+"sum(em.basic),sum(em.hra),sum(em.conveyance),sum(em.otherearnings1+em.otherearnings2),sum(em.grossearnings),"
+"sum(em.ptax),sum(em.pfamount),sum(em.esiamount),sum(em.itax),sum(em.salaryadvance),sum(em.mediclaim),sum(em.otherdeduction1),sum(em.grossdeductions),sum(em.loanamount),sum(em.touradvance),sum(em.otherdeduction2) "
+"from hr_empmaster e join hr_empmonthpay em  on e.idno=em.idno join hr_rateofpay r on  e.idno=r.idno join hr_department d on d.deptid=e.workdeptid "
+"join hr_muster h on h.idno=e.idno join hr_personaldetails p on p.parentid = e.idno where em.tmonth="+month+" and em.tyear="+year+" and e.workingdivisionid="+division+" and h.tmon=em.tmonth and h.tyear=em.tyear  group by h.idno order by h.idno";
 
rs=statement.executeQuery(sql);
int idno=0;

%>
<input type="hidden" id="division" value="<%=division%>">
<input type="hidden" id="month" value="<%=month%>">
<input type="hidden" id="year" value="<%=year%>">
<input type="hidden" id="idNumber" value="<%=idNumber%>">


<% while(rs.next()){ %>
    

<table align="center" id="tblCustomers" width="100%"  >
<tr>
      <td rowspan="3" width="70%" style="border-top:1px solid;border-right:1px solid">
	  <center><img src="resources/assets/images/booklogo.png"  height="75" width="150"></center></img></td>
	  <th style="border-top:1px solid;border-right:1px solid" bgcolor="lightsteelblue">PAYSLIP FOR THE MONTH</th>
	  </tr>
	  <tr><th style="border-top:1px solid;border-right:1px solid" align="center"><%=new DateFormatSymbols().getMonths()[month-1] %>-<%=year %></th>
	  <!-- Integer id=0; -->
	  <tr><th style="border-top:1px solid;border-right:1px solid" align="right"><%=rs.getInt(1)%><br><%=rs.getString(2)%><br><%=rs.getString(3)%>,<%=rs.getString(4)%></th>
	  <!--<input type="hidden" id="idno" value="<%=rs.getInt(1)%>">--> 
	  	  
<!--	  <script type="text/javascript" src="resources/customjs/GetMonthlyPaySlipLeavebalance.js">
	  		var idno = $("#idno").val();
	  </script>-->
	  <!--<tr><td  style="border-top:1px solid;border-right:1px solid" colspan="2"> &nbsp </tr>-->
	
</table>

<table align="center"  class="nth-table" width="100%">
<tr>
<td width="25%">
<table align="center"  class="nth-table"  width="100%">
    <tr><th colspan="2" bgcolor="lightsteelblue">RATE OF PAY <img src="resources/assets/images/rupee.png" height="20" width="20"></img></th></tr>  
	  <tr><td><b>BASIC PAY</b></td><td align="center"><%=rs.getFloat(5) %></td>
      <tr><td><b>HRA</th><td align="center"><%=rs.getFloat(6) %></td>
	  <tr><td><b>CONVEYANCE</th><td align="center"><%=rs.getFloat(7) %></td>
	  <tr><td><b>OTHER ALLOWENCE</th><td align="center"><%=rs.getFloat(8)%></td>
	  <tr><td><b>LTA</th><td align="center"><%=rs.getFloat(9) %></td>
	  <tr><td><b>MEDICAL</th><td align="center"><%=rs.getFloat(10)%></td>
	  <tr><td><b>SPL.ALLOWENCE</th><td align="center"><%=rs.getFloat(11)%></td>
	  <tr><td><b>BONUS/EXGRETIA</th><td align="center">0.0</td>
	  <tr><td><b> &nbsp;</th><td align="center"></td>
	  <tr><td><b>&nbsp; </th><td align="center"></td>
	  <tr><td><b>&nbsp; </th><td align="center"></td>
	  <tr><td><b>GRASS SALARY </th><td align="center"><%=rs.getString(14)%></td>
</table>
<table align="center"  class="nth-table"  width="100%">
<tr>
      <th colspan="8" width="1400">LEAVE BALANCES</th><br>
</tr>  
  <tr>	  
      <th>CL</th>
      <th>SL</th>
	  <th>EL</th>
	  <th>C-Off</th>
  </tr>

<tr align="center">
    <td><label id="cl" size="5px" ><%=Float.valueOf(constants.getLeaveBalance(rs.getInt(1), "2019-08-31", 1))%></label></td>
    <td><label id="sl" size="5px" ><%=Float.valueOf(constants.getLeaveBalance(rs.getInt(1), "2019-08-31", 2))%></label></td>
	  <td><label id="el" size="5px" ><%=Float.valueOf(constants.getLeaveBalance(rs.getInt(1), "2019-08-31", 3))%></label></td>
	  <td><label id="co" size="5px" ><%=Float.valueOf(constants.getLeaveBalance(rs.getInt(1), "2019-08-31", 4))%></label></td>
  </tr>  
</table>  

<table align="center"  class="nth-table"  width="100%">

<tr>
      <td colspan="8" width="1400">Bank A/c.<%=rs.getString(22)%> @ <%=rs.getString(23)%>[<%=rs.getString(24) %>]</td>
</tr>  

  <tr>	  
      <th>PF-UAN</th>
      <th>PAN Card</th>
	  <th>ESI No</th>
  </tr>
  
<tr align="center">	  
	  <td><%=rs.getString(26) %> </td>
	  <td><%=rs.getString(25) %> </td>
	  <td><%=rs.getString(27) %> </td>
  </tr> 
   
</table>  

</td>

<td width="75%" valign="top">
<table align="center"  class="nth-table"  width="100%">
<tr>
      <th colspan="8" width="1400">ATTENDENCE STATUS</th><br>

</tr>  
  <tr>	  
      <th>ATT</th>
      <th>WH</th>
	  <th>OD</th>
	  <th>PH</th>
	  <th>LEAVES</th>
	  <th>LOP</th>
	  <th>PREV.MONTH LOP</th>
	  <th>PAID DAYS</th>
  </tr>
 
<tr align="center">	 

      <td><%=rs.getFloat(15) %></td>
      <td><%=rs.getFloat(16) %></td>
	  <td><%=rs.getFloat(17) %></td>
	  <td><%=rs.getFloat(18) %></td>
	  <td><%=rs.getFloat(19) %></td>
	  <td><%=rs.getFloat(20) %></td>
	  <td>0.0</td>
	  <td><%=rs.getFloat(21)%></td>
  </tr> 

 </table>
 <table align="center"  class="nth-table"  width="100%">
<tr>
      <th colspan="10" width="1400">E A R N I N G S</th><br>

</tr>  
  <tr>	  
      <th>Basic</th>
      <th>HRA</th>
	  <th>CONV.Al</th>
	  <th>OTHERS</th>
	  <th>GRASS EARNING</th>
  </tr>
 
<tr align="center">	  
      <td><%=rs.getFloat(28) %></td>
      <td><%=rs.getFloat(29) %></td>
	  <td><%=rs.getFloat(30) %></td>
	  <td><%=rs.getFloat(31) %></td>
	  <td><%=rs.getFloat(32) %></td>
	  
  </tr> 
 
 </table>
 
 <table align="center"  class="nth-table"  width="100%">
<tr>
      <th colspan="11" width="1400">D E D U C T I O N S</th><br>

</tr>  
  <tr>	  
      <th>PROF<br>TAX</th>
      <th>PROV<br>FUND</th>
	  <th>ESI</th>
	  <th>TDS</th>
	  <th>INSURANCE</th>
	  <th>LOAN AMOUNT</th>
	  <th>TOUR ADV</th>
	  <th>SAL.ADV</th>
	  <th>OTH-DED-1</th>
	  <th>OTH-DED-2</th>	  
	  <th>GRASS DEDUCTION</th>
  </tr>
 
<tr align="center">	  

      <td><%=rs.getFloat(33) %></td>
      <td><%=rs.getFloat(34) %></td>
	  <td><%=rs.getFloat(35) %></td>
	  <td><%=rs.getFloat(36) %></td>
	  <td><%=rs.getFloat(38) %></td>
	  <td><%=rs.getFloat(41) %></td>
	  <td><%=rs.getFloat(42) %></td>
	  <td><%=rs.getFloat(37) %></td>
	  <td><%=rs.getFloat(39) %></td>
	  <td><%=rs.getFloat(43)%></td>
	  <td><%=rs.getFloat(40)%></td>
  </tr>  
 </table> 

<table align="center"  class="nth-table"  width="100%">
<tr>
      <th colspan="8" width="1400">N E T  P A Y</th><br>

</tr>  
 
<tr align="center">	  
      <td> Rs.<%=rs.getFloat(12) %>/-</th>
</tr>  

<tr>
      <td align="left"><u>Remarks : </u><br> <%=rs.getString(13) %> <br><br><br></td>

</tr>  
 
<tr align="center">	  
      <td align="center">This is system generated...No Signature required</th>
  </tr>  
 </table>
 </td>   
 </tr>
 </td>
 </tr>
</table>
      <br>
      <br>
          <br>
  <% } %>

  
<%connection.close();%>
<%}else{
	response.sendRedirect("login");
}
	%>
    <br />
   <!--  <input type="button" id="btnExport" value="Export" /> -->
   <button>Click me</button>
 
    <script type="text/javascript">
    $(function(){
        $('button').click(function(){
        	var a = document.createElement('a');
        	var data_type='data:application/vnd.ms-excel';
        	a.href=data_type+','+ encodeURIComponent($('#tblCustomers').html()) 
            a.download = 'payslip.xls';
        	a.click();
            return (a);
        })
    })
      
    </script>
    </div>
</body>

</html>  --%>
 <%@include file="header.jsp" %>
<%@page import="com.hrms.utitlities.constants"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
     <style>
.nth-table {
    border-collapse: collapse;
    border: 1px solid #400040;
  }
 .nth-table tr:nth-child(even){
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
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));

int idno=0;
%>
<input type="hidden" id="division" value="<%=division%>">
<input type="hidden" id="month" value="<%=month%>">
<input type="hidden" id="year" value="<%=year%>">

<c:choose>
<c:when test="${not empty payslip} ">
<c:forEach var="map" items="payslip">
<h1>HHHHHHHHHHHHHHHHHHHHHHH</h1>

<table align="center" id="tblCustomers" width="100%"  >

<tr>
      <td rowspan="3" width="70%" style="border-top:1px solid;border-right:1px solid">
	  <center><img src="resources/assets/images/booklogo.png"  height="75" width="150"></center></img></td>
	  <th style="border-top:1px solid;border-right:1px solid" bgcolor="lightsteelblue">PAYSLIP FOR THE MONTH</th>
	  </tr>
	  <tr><th style="border-top:1px solid;border-right:1px solid" align="center"><%=new DateFormatSymbols().getMonths()[month-1] %>-<%=year %></th>
	  <!-- Integer id=0; -->
	 
	  <tr><td style="border-top:1px solid;border-right:1px solid" align="right">${map.idno} <br>${map.empname}<br>${map.desgn},${map.name}</th> 
</table>

<table align="center"  class="nth-table" width="100%">
<tr>
<td width="25%">
<table align="center"  class="nth-table"  width="100%">
    <tr><th colspan="2" bgcolor="lightsteelblue">RATE OF PAY <img src="resources/assets/images/rupee.png" height="20" width="20"></img></th></tr>  

	  <tr><td><b>BASIC PAY</b></td><td align="center">${map.rbasic}</td>
      <tr><td><b>HRA</th><td align="center">${map.rhra}</td>
	  <tr><td><b>CONVEYANCE</th><td align="center">${map.rconveyance}</td>
	  <tr><td><b>OTHER ALLOWENCE</th><td align="center">${map.rotherallowance1}</td>
	  <tr><td><b>LTA</th><td align="center">${map.rlta}</td>
	  <tr><td><b>MEDICAL</th><td align="center">${map.1rmedical}</td>
	  <tr><td><b>SPL.ALLOWENCE</th><td align="center">${map.rotherallowance2}</td>
	  <tr><td><b>BONUS/EXGRETIA</th><td align="center">0.0</td>
	  <tr><td><b> &nbsp;</th><td align="center"></td>
	  <tr><td><b>&nbsp; </th><td align="center"></td>
	  <tr><td><b>&nbsp; </th><td align="center"></td>
	  <tr><td><b>GRASS SALARY </th><td align="center">${map.grosssalary}</td>
</table>
<table align="center"  class="nth-table"  width="100%">
<tr>
      <th colspan="8" width="1400">LEAVE BALANCES</th><br>
</tr>  
  <tr>	  
      <th>CL</th>
      <th>SL</th>
	  <th>EL</th>
	  <th>C-Off</th>
  </tr>

<tr align="center">
      <td>0.0</th>
	  <td>1.0</th>
	  <td>1.0</th>
	  <td>0.0</th>
  </tr>  
</table>  

<table align="center"  class="nth-table"  width="100%">

<tr>
      <td colspan="8" width="1400">Bank A/c.${map.accountnumber} @ ${map.bankname}[${map.bankBranch}]</td>
</tr>  

  <tr>	  
      <th>PF-UAN</th>
      <th>PAN Card</th>
	  <th>ESI No</th>
  </tr>
  
<tr align="center">	 
	  <td>${map.uannumber} </td>
	  <td>${map.pancardnumber} </td>
	  <td>${map.esinumber} </td>
  </tr> 
   
</table>  

</td>

<td width="75%" valign="top">
<table align="center"  class="nth-table"  width="100%">
<tr>
      <th colspan="8" width="1400">ATTENDENCE STATUS</th><br>

</tr>  
  <tr>	  
      <th>ATT</th>
      <th>WH</th>
	  <th>OD</th>
	  <th>PH</th>
	  <th>LEAVES</th>
	  <th>LOP</th>
	  <th>PREV.MONTH LOP</th>
	  <th>PAID DAYS</th>
  </tr>
 
<tr align="center">	 

      <td>${map.present}</td>
      <td>${map.wh}</td>
	  <td>${map.od}</td>
	  <td>${map.ph}</td>
	  <td>${map.leaves}</td>
	  <td>${map.lop}</td>
	  <td>0.0</td>
	  <td>${map.paiddays}</td>
  </tr> 

 </table>
 <table align="center"  class="nth-table"  width="100%">
<tr>
      <th colspan="10" width="1400">E A R N I N G S</th><br>

</tr>  
  <tr>	  
      <th>Basic</th>
      <th>HRA</th>
	  <th>CONV.Al</th>
	  <th>OTHERS</th>
	  <th>GRASS EARNING</th>
  </tr>
 
<tr align="center">	  
      <td>${map.basic}</td>
      <td>${map.hra}</td>
	  <td>${map.conveyance}</td>
	  <td>${map.otherearnings}</td>
	  <td>${map.grossearnings}</td>
	  
  </tr> 
 
 </table>
 
 <table align="center"  class="nth-table"  width="100%">
<tr>
      <th colspan="11" width="1400">D E D U C T I O N S</th><br>

</tr>  
  <tr>	  
      <th>PROF<br>TAX</th>
      <th>PROV<br>FUND</th>
	  <th>ESI</th>
	  <th>TDS</th>
	  <th>INSURANCE</th>
	  <th>LOAN AMOUNT</th>
	  <th>TOUR ADV</th>
	  <th>SAL.ADV</th>
	  <th>OTH-DED-1</th>
	  <th>OTH-DED-2</th>	  
	  <th>GRASS DEDUCTION</th>
  </tr>
 
<tr align="center">	  
   
      <td>${map.ptax}</td>
      <td>${map.pfamount}</td>
	  <td>${map.esiamount}</td>
	  <td>${map.itax}</td>
	  <td>${map.mediclaim}</td>
	  <td>${map.loanamount}</td>
	  <td>${map.touradvance}</td>
	  <td>${map.salaryadvance}</td>
	  <td>${map.otherdeduction1}</td>
	  <td>${map.otherdeduction2}</td>
	  <td>${map.grossdeductions}</td>
  </tr>  
 </table> 

<table align="center"  class="nth-table"  width="100%">
<tr>
      <th colspan="8" width="1400">N E T  P A Y</th><br>

</tr>  
 
<tr align="center">	 

      <td> Rs.${map.netamount}/-</th>
</tr>  

<tr>
      <td align="left"><u>Remarks : </u><br> ${map.remarks} <br><br><br></td>

</tr>  
 
<tr align="center">	  
      <td align="center">This is system generated...No Signature required</th>
  </tr>  
 </table>
 </td>   
 </tr>
 </td>
 </tr>
</table>
      <br>
      <br>
          <br>
  </c:forEach>
  </c:when>
  </c:choose>
    <br />
   <button>Click me</button>
 
    <script type="text/javascript">
    $(function(){
        $('button').click(function(){
        	var a = document.createElement('a');
        	var data_type='data:application/vnd.ms-excel';
        	a.href=data_type+','+ encodeURIComponent($('#tblCustomers').html()) 
            a.download = 'payslip.xls';
        	a.click();
            return (a);
        })
    })
      
    </script>
    </div>
</body>

</html> 
 




























