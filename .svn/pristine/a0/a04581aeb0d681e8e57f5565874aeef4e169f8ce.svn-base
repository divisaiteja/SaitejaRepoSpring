<!DOCTYPE html>
<html lang="en">
<head>
    <script type ="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
<script>
$(document).ready(function() {
	//var division=	$("#division").val();
	//var month=	$("#month").val();
	//var year=	$("#year").val();
	displayMonthlyPaySlip();
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

function displayMonthlyPaySlip(){
	xmlHttp = GetXmlHttpObject();
	var url = "GetMonthlyPaySlipReport.jsp";
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

<div id="data"></div>

</body>
</html>     

