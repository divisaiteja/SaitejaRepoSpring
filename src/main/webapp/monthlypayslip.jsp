 <!DOCTYPE html>
<html lang="en">
<head>
    <script type ="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
<script>
$(document).ready(function() {
	
	var division=$("#division").val();
	var month=$("#month").val();
	var year=$("#year").val();
	/* var idNumber=$("#idNumber").val(); */
	displayMonthlyPaySlip(division,month,year);
});

function GetXmlHttpObject()
{
	var xmlHttp = null;
	if (window.XMLHttpRequest) {
		xmlHttp = new window.XMLHttpRequest;
	} else {
		try {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (ex) {
			return null;
		}
	}
	return xmlHttp;
}//GetXmlHttpObject

 function displayMonthlyPaySlip(division,month,year){
	xmlHttp = GetXmlHttpObject();
	//var url = "GetMonthlyPaySlipReport.jsp?division="+division+"&&month="+month+"&&year="+year+"&&idNumber="+idNumber;
	var url = "getMontlyPayslip?division="+division+"&&month="+month+"&&year="+year;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}
 
function showmenudata1()
{
	if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
	{
		$("#data").html(xmlHttp.responseText);
	}
}
</script>
<body>
<%

int division=Integer.parseInt(request.getParameter("division"));
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));
/* int idNumber=Integer.parseInt(request.getParameter("idNumber")); */
%>
<body>
<input type="hidden" id="division" value="<%=division%>">
<input type="hidden" id="month" value="<%=month%>">
<input type="hidden" id="year" value="<%=year%>">
<%-- <input type="hidden" id="idNumber" value="<%=idNumber%>"> --%>
 <div id="data"></div>

</body>
</html>     

