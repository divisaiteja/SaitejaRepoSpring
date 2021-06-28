<!DOCTYPE html>
<html lang="en">
<head>
    <script type ="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script>
<script>
$(document).ready(function() {

	var division=	$("#division").val();
	var flds=	$("#flds").val();        
	var cadre=	$("#cadre").val();                
        var grade=	$("#grade").val();                
        var dept=	$("#dept").val();                        
        var section=	$("#section").val();
        var jobstatus=	$("#jobstatus").val();
        var empstatus=	$("#empstatus").val();
        var project=	$("#project").val();
        var idno=	$("#idno").val();

        displayEmployeeListingReport(division,flds,cadre,grade,dept,section,jobstatus,empstatus,project,idno);

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

function displayEmployeeListingReport(division,flds,cadre,grade,dept,section,jobstatus,empstatus,project,idno){

	xmlHttp = GetXmlHttpObject();
	var url = "GetEmployeeListingReport.jsp?division="+division+"&&flds="+flds+"&&cadre="+cadre+"&&grade="+grade+"&&dept="+dept+"&&section="+section+"&&jobstatus="+jobstatus+"&&empstatus="+empstatus+"&&project="+project+"&&idno="+idno;
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
String division=(request.getParameter("division"));
String flds=request.getParameter("flds");
String cadre=(request.getParameter("cadre"));
String grade=(request.getParameter("grade"));
String dept=(request.getParameter("dept"));
String section=(request.getParameter("section"));
String jobstatus=(request.getParameter("jobstatus"));
String empstatus=(request.getParameter("empstatus"));
String project=(request.getParameter("project"));
String idno=(request.getParameter("idno"));

%>
<body>
    <div align="center"><img src="resources/img/reload.gif" id="image"></div>
<input type="hidden" id="division" value="<%=division%>">
<input type="hidden" id="cadre" value="<%=cadre%>">
<input type="hidden" id="grade" value="<%=grade%>">
<input type="hidden" id="dept" value="<%=dept%>">
<input type="hidden" id="section" value="<%=section%>">
<input type="hidden" id="jobstatus" value="<%=jobstatus%>">
<input type="hidden" id="empstatus" value="<%=empstatus%>">
<input type="hidden" id="project" value="<%=project%>">
<input type="hidden" id="idno" value="<%=idno%>">
<input type="hidden" id="flds" value="<%=flds%>">

<div id="data"></div>

</body>
</html>     

