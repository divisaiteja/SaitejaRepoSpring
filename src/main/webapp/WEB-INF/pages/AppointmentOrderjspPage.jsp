<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
.div1 {
    float: left;
    font-weight: bold;
}

.div2 {
    float:right;
     font-weight: bold;
}
 #justify {
    width: 100%;
} 
#justify p {
    max-width: 70%;
    list-style: disc outside none; 
    text-align: justify;
    display: list-item;
}
ul.a{
list-style-type: lower-alpha;
}
li{
text-align: left ;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 70%;
  
}

td, th {
  text-align: center;
  padding: 0px;
}
</style>
</head>
<body>
  <input type="button" id="btnExport" value="Generate Pdf" />
<div id="tblCustomers">
    <c:forEach var="AppointmentOrderjspPage" items="${AppointmentOrderjspPage}">
	<h3 align="center">APPOINTMENT ORDER</h3>
	<p align="right"><b> <span>DATE :<c:out value="${AppointmentOrderjspPage.sysdate }"/>.</span></b></p>
	<p align="left">Dear <u><b><span><c:out value="${AppointmentOrderjspPage.empname }"/> ,</span></b></u></p>
<p align="center"><b>APPOINTMENT ORDER FOR THE POST OF <u><span><c:out value="${AppointmentOrderjspPage.desgn }"/></span> </u></b></p>
<div id="justify">
<p style=" margin: 0 auto; ">With Reference to your application and the subsequent interview you had with us, we are pleased to appoint you as <b><u><span><c:out value="${AppointmentOrderjspPage.desgn }"/></span> </u></b> to Greenfields Project in our organization. You are advised to report on <b><u><span><c:out value="${AppointmentOrderjspPage.doj }"/></span> </u></b>  at our site after which you will be at same, further works, subject to the following terms & conditions.</p>
<br>
<p style=" margin: 0 auto; "><b>PROBATIONARY PERIOD:</b><br>
You will be on probation for a period of 3 months from the date of your joining. This period of probation will be liable to such extension, as management may deem fit and at its sole discretion and unless an order in writing confirming you are given, you will not deemed to have been made permanent<b>.</b>
</p>
<br>
<p style=" margin: 0 auto; "><b>DUTIES AND RESPONSIBILITIES:</b><br>
a)You will have the responsibility for an efficient , satisfactory and economical discharge of the duties entrusted to you from time to time.<br>
b) During this period of employment, you shall not secure any other employment, engage in any profession or trade or pursue any course of study or work part time without the managements previous consent in writing.<br>
c) You will behave and conduct your-self in an orderly manner and shall not remain absent from the place of work without the prior consent in writing.<br>
d) You will be reporting to the Project In charge or any other person nominated by him in this regard for the performance of your duties.<br>
e)You should maintain all the records which are happening at site like installation works, material received to site, documentation, billing for the particular sites.<br>
f)You should maintain the client coordination every time & the same should be coordinate with our office management.<br>
</p>
<br>
<p style=" margin: 0 auto; "><b>SECRECY :</b><br>
You will not at any time during your employment and thereafter divulge any information, plans, know how, etc. Regarding business or affairs of the company or those of the companies clients and associates to any person, firm or company except with prior consent of the company in writing<b>.</b>
</p>
<br>
<p style=" margin: 0 auto; "><b>REMUNERATION:</b><br>
During the probation period you will be paid the following salary per month in grade 04.<br>
</p>
<table>
  <tr>
    <td>Basic Salary</td>
    <td><c:out value="${AppointmentOrderjspPage.basic }"/></td>
  </tr>
  <tr>
    <td>House Rent Allowance</td>
    <td><c:out value="${AppointmentOrderjspPage.hra }"/></td>
  </tr>
  <tr>
    <td>Special Allowance</td>
    <td><c:out value="${AppointmentOrderjspPage.conveyance }"/></td>
  </tr>
  <tr>
    <td>Site Allowance</td>
    <td><c:out value="${AppointmentOrderjspPage.others1 }"/></td>
  </tr>
  <tr>
    <td>Gross Salary Rs</td>
    <td><c:out value="${AppointmentOrderjspPage.grosssalary }"/></td>
  </tr> 
  <tr><th>Standard Deductions</th></tr>
  <tr>
    <td>PF</td>
    <td><c:out value="${AppointmentOrderjspPage.pfamount }"/></td>
  </tr>
  <tr>
    <td>PT</td>
    <td><c:out value="${AppointmentOrderjspPage.taxrate }"/></td>
  </tr>
  <tr>
    <td>Net Salary Rs</td>
    <td><c:out value="${AppointmentOrderjspPage.netsalary }"/></td>
  </tr>
</table>
<br>
<p style=" margin: 0 auto; ">
a)Sanction of further increments and promotion to the next grade will depend on satisfactory discharge of your duties.<br>
b)On confirmation of your services you will be entitled to LTA, leave facilities, etc, as per company rules.
</p>

<br>
<P style=" margin: 0 auto; "><b>RESIGNATION /TERMINATION OF SERVICES</b><br>
a)	Notwithstanding to any of the clauses herein, the management reserves the right to terminate your services without any notice and without liability for any compensation during the probationary period.<br>
b)	In case you choose to leave the employment during the probation you shall give notice, there of at least one month prior to relief. After completion of the probationary period satisfactorily.
</P>

<p style=" margin: 0 auto; "><b> VERFICATION REPORT</b><br>
This appointment is issued on the information furnished by you to us in your application, bio-data form and otherwise, and will be null & void if a material error (in the company opinion) is discovered therein at any time. During your services you will be governed by the rules and regulation framed by the company from time to time. Your appointment will be given effect from the date of your joining duties. We are sending the Letter of appointment to you in duplicate. Please sign the duplicate copy of this letter of appointment in token of your acceptance and return the same to us immediately for our records. This offer of appointment shall cease to be valid if your acceptance is not received in this office within six days of receipt of this letter.
</p><br><br>
<p  align="left"><b>Thanking You</b>,</p><br>
<div>
    <div class="div1">For M/s Yalavarti Projects Pvt Ltd</div>
    <div class="div2">Received and accepted</div>
</div>
<br><br>
<div>
    <div class="div1">Authorized Signature</div>
    <div class="div2">(Signature)</div>
</div>
</div>
</c:forEach>
	</div>
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
                            width:500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("AppointmentOrder");
                }
            });
        });
    </script>
	

</body>


</html>