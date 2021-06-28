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
    
    
String division=(request.getParameter("division"));
String flds=request.getParameter("flds");
String cadre=(request.getParameter("cadre"));
String grade=(request.getParameter("grade"));
String dept=(request.getParameter("dept"));
String section=(request.getParameter("section"));
String jobstatus=(request.getParameter("jobstatus"));
String empstatus=(request.getParameter("empstatus"));
String project=(request.getParameter("project"));
String idnumber=(request.getParameter("idno"));


int iYear = 2019;
int iMonth = 7; // 1 (months begin with 0)
int iDay = 1;

/// filter string formation
String fltrString = "";

if (!division.isEmpty()){
    fltrString = fltrString + " and workingdivisionid in ("+division+") ";
}
if (!cadre.isEmpty()){
    fltrString = fltrString + " and cadreid in ("+cadre+") ";
}
if (!grade.isEmpty()){
    fltrString = fltrString + " and gradeid in ("+grade+") ";
}
if (!jobstatus.isEmpty()){
    fltrString = fltrString + " and jobstatus in ("+jobstatus+") ";
}
if (!empstatus.isEmpty()){
    fltrString = fltrString + " and empstatus in ("+empstatus+") ";
}
if (!dept.isEmpty()){
    fltrString = fltrString + " and workdeptid in ("+dept+") ";
}
if (!section.isEmpty()){
    fltrString = fltrString + " and sectionid in ("+section+") ";
}
if (!project.isEmpty()){
    fltrString = fltrString + " and project in ("+project+") ";
}
if (!idnumber.isEmpty()){
    fltrString = fltrString + " and e.idno="+Integer.parseInt(request.getParameter("idno"))+" ";
}



//setting display fields

        
String[] dispFld = new String[50];
String fldName="";
int i=0;
int j=100;


if (flds.contains("Employee Code")){
    fldName=fldName+",EmpNo";
    dispFld[i]="EmpNo";
    i=i+1;
}
if (flds.contains("Date of Joining")){
    fldName=fldName+",DOJ";
    dispFld[i]="DOJ";
    i=i+1;
}
if (flds.contains("Grade")){
    fldName=fldName+",gradeid";
    dispFld[i]="Grade";
    i=i+1;
}
if (flds.contains("Project")){
    fldName=fldName+",projectname";
    dispFld[i]="Project";
    i=i+1;
}
if (flds.contains("Mobile Number")){
    fldName=fldName+",mobilenumber";
    dispFld[i]="Mobile No";
    i=i+1;
}
if (flds.contains("e-Mail")){
    fldName=fldName+",pr.emailid";
    dispFld[i]="e-Mailt";
    i=i+1;
}
if (flds.contains("Blood Group")){
    fldName=fldName+",bloodgroup";
    dispFld[i]="Blood Group";
    i=i+1;
}
if (flds.contains("Retirement")){
    fldName=fldName+",(DOB+58*365) RDate";
    dispFld[i]="Retirement Date";
    i=i+1;
}

if (flds.contains("Marital Status")){
    fldName=fldName+",maritalstatus";
    dispFld[i]="Marital Status";
    i=i+1;
}

if (flds.contains("Section")){
    fldName=fldName+",sectionid";
    dispFld[i]="Section";
    i=i+1;
}
if (flds.contains("Reporting To")){
    fldName=fldName+",reportingempid";
    dispFld[i]="Reporting To";
    i=i+1;
}
if (flds.contains("Date of Birth")){
    fldName=fldName+",dob";
    dispFld[i]="DOB";
    i=i+1;
}
if (flds.contains("Gender")){
    fldName=fldName+",gender";
    dispFld[i]="Gender";
    i=i+1;
}
if (flds.contains("Aadhar No")){
    fldName=fldName+",adhaarnumber";
    dispFld[i]="Aadhar No";
    i=i+1;
}

if (flds.contains("PF-UAN Number")){
    fldName=fldName+",PfNumber";
    dispFld[i]="UAN Number";
    i=i+1;
}
if (flds.contains("ESI Number")){
    fldName=fldName+",ESINumber";
    dispFld[i]="ESI Number";
    i=i+1;
}
if (flds.contains("Qualification")){
    fldName=fldName+",qualification";
    dispFld[i]="Qualification";
    i=i+1;
}

if (flds.contains("Basic")){
    fldName=fldName+",basic";
    dispFld[i]="Basic";
    i=i+1;
}
if (flds.contains("HRA")){
    fldName=fldName+",hra";
    dispFld[i]="HRA";
    i=i+1;
}
if (flds.contains("DA")){
    fldName=fldName+",da";
    dispFld[i]="DA";
    i=i+1;
}

if (flds.contains("Conveyance")){
    fldName=fldName+",Conveyance";
    dispFld[i]="Conv";
    i=i+1;
}
if (flds.contains("LTA")){
    fldName=fldName+",lta";
    dispFld[i]="LTA";
    i=i+1;
}
if (flds.contains("Medical")){
    fldName=fldName+",medical";
    dispFld[i]="Medical";
    i=i+1;
}
if (flds.contains("Other Allowance")){
    fldName=fldName+",(others1+Others2) Others ";
    dispFld[i]="Oth.Allowance";
    i=i+1;
}
if (flds.contains("W.E.F")){
    fldName=fldName+",wef";
    dispFld[i]="WEF";
    i=i+1;
}
if (flds.contains("CTC")){
    fldName=fldName+",(basic+hra+conveyance+lta+medical+others1+others2+da) ctc";
    dispFld[i]="CTC";
    i=i+1;
}
if (flds.contains("Gross Salary")){
    fldName=fldName+",grosssalary";
    dispFld[i]="Gross Salary";
    i=i+1;
}

j=i;
i=0;
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
sql="select e.idno,empname,desgn,dp.name "+ fldName +" from hr_empmaster e,hr_department dp,hr_division dv,hr_rateofpay r,hr_projects p,hr_personaldetails pr,hr_otherdetails od where e.idno=pr.parentid and e.idno=od.idno and e.project=p.tranid and e.idno=r.idno and e.workdeptid=dp.deptid and e.workingdivisionid=dv.divisionid "+fltrString ;
System.out.println(sql);
rs=stm.executeQuery(sql);
int vslno=1;
%>
<div align="right">
    <input type="button" id="btnExport" value="Export" >
    </div>
    <h3 align="center">Employee's List</h3>
     <table id="tblCustomers" class="nth-table">
  		<tr>
      <th>Sno</th>
      <th>IDNo</th>
      <th>EmployeeName</th>
      <th>Designation</th>
      <th>Department</th>
      <%while (i<j){%>
      <th><%=dispFld[i]%></th>
      <%i=i+1;}%>
  </tr>

         <%while(rs.next()){ %>
  <tr>
	<td align="center"><%=vslno%></td>
	<td align="center"><%=rs.getInt(1) %></td>
	<td><%=rs.getString(2) %></td>
	<td><%=rs.getString(3) %></td>
	<td><%=rs.getString(4) %></td>
            <%i=0;while (i<j){%>
                <td><%=rs.getString(i+5)%></td>
            <%i=i+1;}%>        
     </tr>
   <%
 vslno=vslno+1;  
 } %>

  
     </div>


</table>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script type="text/javascript">       
//        	  $("#image").show();
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
                    pdfMake.createPdf(docDefinition).download("EmployeeList.pdf");
                }
            });
//            	  $("#image").hide();
        });
    </script>
    <%con.close(); %>
</body>
</html>