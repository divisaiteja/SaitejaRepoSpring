<!DOCTYPE html>
<html lang="en">
<head>
    <script type ="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
<script>
$(document).ready(function() {
	var division=$("#division").val();
	var project=$("#project").val();
	var fromdate=	$("#fromdate").val();
	var todate=	$("#todate").val();
	FormTwelve(division,fromdate,todate,project);

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

function FormTwelve(division,fromdate,todate,project){
	xmlHttp = GetXmlHttpObject();
	var url = "GetFormTwelve?division="+division+"&&fromdate="+fromdate+"&&todate="+todate+"&&project="+project;
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
String fromdate=request.getParameter("fromdate");
String todate=request.getParameter("todate");

%>
<body>
  <div align="center"><img src="resources/img/reload.gif" id="image"></div>
<input type="hidden" id="division" value="<%=division%>">
<input type="hidden" id="fromdate" value="<%=fromdate%>">
<input type="hidden" id="todate" value="<%=todate%>">
<input type="hidden" id="project" value="<%=project%>">
<div id="data"></div>
</body>
</html>     

