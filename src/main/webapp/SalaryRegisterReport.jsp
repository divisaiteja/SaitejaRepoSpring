<!DOCTYPE html>
<html lang="en">
<head>
    <script type ="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
<script>
$(document).ready(function() {
	var month=	$("#month").val();
	var year=	$("#year").val();
	DisplaySalaryRegisterReport(month,year);

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

function DisplaySalaryRegisterReport(month,year){
	xmlHttp = GetXmlHttpObject();
	var url = "getSalaryRegister?month="+month+"&&year="+year;
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
int month=Integer.parseInt(request.getParameter("month"));
int year=Integer.parseInt(request.getParameter("year"));
%>
<body>
    <div align="center"><img src="resources/img/reload.gif" id="image"></div>
<input type="hidden" id="month" value="<%=month%>">
<input type="hidden" id="year" value="<%=year%>">
<div id="data"></div>
</body>
</html>     

