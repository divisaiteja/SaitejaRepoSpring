<!DOCTYPE html>
<html lang="en">
<head>
    <script type ="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
<script>
$(document).ready(function() {
	var division=	$("#division").val();
	var month=	$("#month").val();
	var year=	$("#year").val();
	displayMonthlyAttenedenceReport(division,month,year);
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

function displayMonthlyAttenedenceReport(division,month,year){
	xmlHttp = GetXmlHttpObject();
	var url = "GetMonthlyAttendenceReport.jsp?division="+division+"&&month="+month+"&&year="+year;
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
<%
int division=Integer.parseInt(request.getParameter("division"));
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));

%>
<body>
<input type="hidden" id="division" value="<%=division%>">
<input type="hidden" id="month" value="<%=month%>">
<input type="hidden" id="year" value="<%=year%>">

<div id="data"></div>

</body>
</html>     

