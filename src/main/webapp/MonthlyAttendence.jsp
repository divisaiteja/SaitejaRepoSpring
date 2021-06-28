<!DOCTYPE html>
<html lang="en">
<head>
    <script type ="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
<script>
$(document).ready(function() {
	var division=$("#division").val();
	var month=	$("#month").val();
	var year=	$("#year").val();
	var project=$("#project").val();
	MonthlyAttendence(division,month,year,project);

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

function MonthlyAttendence(division,month,year,project){
	xmlHttp = GetXmlHttpObject();
	var url = "getMonthlyAttendence?division="+division+"&&month="+month+"&&year="+year+"&&project="+project;
	xmlHttp.onreadystatechange = showmenudata1;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);

}

function showmenudata1()
{
        $("#image").show();        
	if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
	{
		$("#data").html(xmlHttp.responseText);
                  $("#image").hide();        
	}
}
</script>
<%
int division=Integer.parseInt(request.getParameter("division"));
int project=Integer.parseInt(request.getParameter("project"));
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));

%>
<body>
    <div align="center"><img src="resources/img/reload.gif" id="image"></div>
<input type="hidden" id="division" value="<%=division%>">
<input type="hidden" id="month" value="<%=month%>">
<input type="hidden" id="year" value="<%=year%>">
<input type="hidden" id="project" value="<%=project%>">

<div id="data"></div>

</body>
</html>     

