<%@page import="com.hrms.utitlities.constants"%>
<%@page import="com.hrms.utitlities.DBUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*"%>
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
            int division = Integer.parseInt(request.getParameter("division"));
            int vmonth = Integer.parseInt(request.getParameter("month"));
            int vyear = Integer.parseInt(request.getParameter("year"));

            %>
        <input type="hidden" id="division" value="<%=division%>">
            <input type="hidden" id="month" value="<%=vmonth%>">
                <input type="hidden" id="year" value="<%=vyear%>">
                        <div id="tblCustomers">
                            <h3 align="center">PF STATEMENT</h3>
                            <table  class="nth-table" >
                                <tr>
                                    <th width="300" >Slno</th>
                                    <th width="300" >UAN NUMBER</th>
                                    <th width="300" >MEMBER NAME</th>
                                    <th width="300" >GROSS WAGE</th>
                                    <th width="300" > EPF WAGE</th>
                                    <th width="300" >EPS WAGE</th>	  
                                    <th width="300" >EDLI WAGE</th>
                                    <th width="300" >EPF CONTRI REMITTED</th>	  
                                    <th width="300" >EPS CONTRI REMITTED</th>	  
                                    <th width="300" >EPF & EPS DIFF CONTRI REMITTED</th>
                                    <th width="300" >NCP DAYS</th>
                                    <th width="300" >REFUND OF ADVANCES</th>
                                </tr> 

        <%
            String strPath = "D:\\example.txt";
            File strFile = new File(strPath);
            boolean fileCreated = strFile.createNewFile();
            //File appending
            Writer objWriter = new BufferedWriter(new FileWriter(strFile));

            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select sum(m.grossearnings) as grossearnings,sum(m.basic) as basic,sum(m.pfamount) as pf,sum(m.vpfamount) as vpf,sum(lopdays) as lopdays,m.idno,left(gender,1) as gender,empname,doj,dob,dol,empstatus,workingdivisionid,uannumber,monthid,doc,empleft,pfpercentage,0 as PensionFund from hr_empmonthpay m,hr_empmaster e,hr_personaldetails p,hr_rateofpay r  " +
                " where m.idno=r.idno and m.idno=p.parentid and  m.idno=e.idno and tmonth=" + vmonth + " and tyear=" + vyear + " and  pfper>0 and workingdivisionid="+division+" group by r.idno,gender,empname,doc,doj,dob,dol,empstatus,empleft,workingdivisionid,monthid,pfpercentage,uannumber order by uannumber ";
            //String sql = "select r.uannumber,r.epscontribution,empname,basic from hr_empmonthpay r join hr_empmaster e on r.idno=e.idno join hr_empmonthpay em on em.idno=r.idno where  em.tmonth=" + vmonth + "  and em.tyear=" + vyear + " and  e.workingdivisionid=" + division + " and e.project=" + project;
            ResultSet rs = statement.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                                
            int arrearepfwage = 0;
            int arrearepfeeshare = 0;
            int arrearepfershare = 0;
            int arrearepsshare = 0;
            int tarrearepfwage=0;
            int tarrearepfeeshare=0;
            int totpf=0;
            int eps=0;
            float epsper=8.33f;            
            int totepfbas=0;
            int totepsbas=0;
            int totedlibas=0;
            int totepscont=0;
            int totlopdays=0;
            
            int vGrossEar = rs.getInt("grossearnings");
            int EPFbasic = rs.getInt("basic");
//            arrearepfwage = genLib.getFieldValue("Group", "select sum(basic) from hr_emp_monthpay where tmon=" & vMonth & " and tyear=" & vYear & " and arrrecord>4 and pf>0 and idno=" & rs("IDNo"), 0);
//            arrearepfeeshare = genLib.getFieldValue("Group", "select sum(PF) from hr_emp_monthpay where tmon=" & vMonth & " and tyear=" & vYear & " and arrrecord>4 and pf>0 and idno=" & rs("IDNo"), 0);
//            arrearepfwage = arrearepfwage + genLib.getFieldValue("Group", "select sum(basic) from HR_Emp_IncrArrearsPay where tmon=" & vMonth & " and tyear=" & vYear & " and pf>0 and idno=" & rs("IDNo");, 0)
//            arrearepfeeshare = arrearepfeeshare + genLib.getFieldValue("Group", "select sum(PF) from HR_Emp_IncrArrearsPay where tmon=" & vMonth & " and tyear=" & vYear & " and pf>0 and idno=" & rs("IDNo"), 0);

            arrearepfwage = rs.getInt("basic");
            arrearepfeeshare = rs.getInt("pf");
            int vEStat = Integer.valueOf(constants.getFieldValue("Group", "select ifnull(empstatus,0) from hr_empmaster where idno=" + rs.getInt("IDno"), 0));
            int vBasic = Integer.valueOf(constants.getFieldValue("Group", "select ifnull(basic,0) from hr_rateofpay where idno=" + rs.getInt("IDno"), 0));

		if(arrearepfwage > 15000){
		     arrearepsshare = Math.round((15000 * epsper)/100);
                }
                else{
                     arrearepsshare = Math.round((arrearepfwage * epsper)/100);
                }

		int	lm=0;
		int	ly=0;
               lm=6; //rs.getDate("DOJ").getMonth();
               ly=2019; //rs.getDate("DOJ").getYear();
               Date chkDate = new SimpleDateFormat("YYYY-MM-dd").parse("2014-09-01"); 
               //int dDiff=dateDiff();
    
		// if ((vEStat == 3 && rs.getInt("empleft")==0) || (vEStat == 3 && rs.getInt("Empleft")==1 && lm != vmonth && ly != vyear) || (rs.getDate("DOJ").compareTo(chkDate)>0 && vBasic >=15000 && rs.getString("PFUANNo")==' ')) {
                if (((vEStat == 3) && (rs.getInt("empleft")==0)) || ((vEStat == 3) && (rs.getInt("Empleft")==1) && (lm != vmonth) && (ly != vyear)) || ((vBasic >=15000) && (rs.getString("uannumber").isEmpty()) && (rs.getDate("DOJ").compareTo(chkDate)>0) )) {
                    arrearepsshare=0;
            }

            arrearepfershare = arrearepfeeshare - arrearepsshare;
            tarrearepfwage = tarrearepfwage + arrearepfwage;
            tarrearepfeeshare = tarrearepfeeshare + arrearepfeeshare;

            int EPSbasic = EPFbasic;
            int EDLIbasic = EPFbasic;
            if (EPFbasic > 15000) {
                EPSbasic = 15000;
                        }
            
            if (EDLIbasic > 15000){
                EDLIbasic = 15000;
            }

            int epf = rs.getInt("pf") + rs.getInt("vPF");
            int vpf = rs.getInt("vPF");
            totpf = totpf + epf;

            if (EPSbasic > 0) {
                eps = Math.round((EPSbasic * epsper)/100);
            }
            else{
                eps = 0;
            }

		lm=0;
		ly=0;
           /*  if (rs.getInt("EmpLeft")==1){
               lm=rs.getDate("dol").getMonth();
               ly=rs.getDate("dol").getYear();
            } */

            //if (((vEStat == 3) && (rs.getInt("Empleft")=0)) || ((vEStat == 3) && (rs.getInt("Empleft")==1) && (lm!=vmonth)  && (ly!=vyear)) || ((rs.getInt("PensionFund")==0))) {
           if (((vEStat == 3))) {                
                eps = 0;
                EPSbasic = 0;
            }
            int diffepfeps = epf - eps;
            int lopdays = Integer.valueOf(rs.getInt("lopdays"));

            if (lopdays < 1) {
                lopdays = 0;
            }
            if (rs.getInt("Empleft") == 1){
                lopdays = 0;
            }

            int refundofadv = 0;
            
            String vFatherName = constants.getFieldValue("Group", "select name from hr_familydetails where parentid=" + rs.getInt("IDNo") + " and upper(relation)='FATHER'", 0);
            String vRelation = "F";
            String vGender = rs.getString("gender");
            Date vDateofbirth = (rs.getDate("DOB"));
            Date vDateofjoining = rs.getDate("DOJ");
            Date vDateofleaving = rs.getDate("DOL");
            Date vDateofDOC = rs.getDate("DOC");

            String vReasonforleaving="";
            if (rs.getInt("EmpStatus") == 8) {
                vReasonforleaving = "D";}
            else if(rs.getInt("EmpStatus") == 3){			   
                vReasonforleaving = "R";}
            else{
                vReasonforleaving = "C";}


            totepfbas = totepfbas + EPFbasic;
            totepsbas = totepsbas + EPSbasic;
            totedlibas = totedlibas + EDLIbasic;
            totepscont = totepscont + eps;
            totlopdays = totlopdays + lopdays;


	    String pfLine = "";
            String pftag="";

            pftag = pftag + "<tr align='right'>";
            pftag = pftag + "<td align='center' style='border-top:1px solid;border-right:1px solid'>" + i;
            pftag = pftag + "<td align='left' style='border-top:1px solid;border-right:1px solid'>" + rs.getString("uannumber"); 
            pfLine = pfLine + rs.getString("uannumber");
            
            pftag = pftag + "<td style='border-top:1px solid;border-right:1px solid' align='left'>" + rs.getString("EmpName");
            pfLine = pfLine + "#~#" + (rs.getString("EmpName"));

            pftag = pftag + "<td style='border-top:1px solid;border-right:1px solid'>" + vGrossEar;
            pfLine = pfLine + "#~#" + vGrossEar;
                    
            pftag = pftag + "<td style='border-top:1px solid;border-right:1px solid'>" + EPFbasic;
            pfLine = pfLine + "#~#" + EPFbasic;
                    
            pftag = pftag + "<td style='border-top:1px solid;border-right:1px solid'>" + EPSbasic;
            pfLine = pfLine + "#~#" + EPSbasic;
                    
            pftag = pftag + "<td style='border-top:1px solid;border-right:1px solid'>" + EDLIbasic;
            pfLine = pfLine + "#~#" + EDLIbasic;
                    
            pftag = pftag + "<td style='border-top:1px solid;border-right:1px solid'>" + epf;
            pfLine = pfLine + "#~#" + epf;

            pftag = pftag + "<td style='border-top:1px solid;border-right:1px solid'>" + eps;
            pfLine = pfLine + "#~#" + eps;

            pftag = pftag + "<td style='border-top:1px solid;border-right:1px solid'>" + (diffepfeps - vpf);
            pfLine = pfLine + "#~#" + (diffepfeps - vpf);

            pftag = pftag + "<td style='border-top:1px solid;border-right:1px solid'>" + lopdays;
            pfLine = pfLine + "#~#" + lopdays;
            
	    pftag = pftag + "<td style='border-top:1px solid;border-right:1px solid'>" + refundofadv;
            pfLine = pfLine + "#~#" + refundofadv;
//            pfLine = pfLine + String.format("%n");
            // writing output to text file
            objWriter.write(pfLine);
            objWriter.write(String.format("%n"));
            objWriter.flush();
            
            i = i + 1;
        %>                   
                             
        <tr>        <%=pftag%></tr>
                                <% }            
objWriter.close();
%> 

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
                                            pdfMake.createPdf(docDefinition).download("PFStatement");
                                        }
                                    });
                                });
                            </script>
                            </body>
                            </html>