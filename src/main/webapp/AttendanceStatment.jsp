<!DOCTYPE html>
<html lang="en">
<head>
    <script type ="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
<script>
$(document).ready(function() {
	
	var division=$("#division").val();	
	displayDailyAttendence(division);
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

 function displayDailyAttendence(division){
	xmlHttp = GetXmlHttpObject();
	//var url = "GetDailyAttendenceReport.jsp?division="+division+"&&project="+project
	var url = "getDailyAttendenceReport?division="+division;
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

%>
<body>
<input type="hidden" id="division" value="<%=division%>">

 <div id="data"></div>

</body>
</html>     

