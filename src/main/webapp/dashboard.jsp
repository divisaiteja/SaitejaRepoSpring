<!DOCTYPE html>
<html>
<head>

<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<%@include file="header.jsp"%>

<script src="resources/highcharts/highcharts.js"></script>
<script src="resources/highcharts/exporting.js"></script>
<script src="resources/highcharts/export-data.js"></script>
 <script type="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script> 

</head>
<script>
$(document).ready(function() {
	xmlHttp = GetXmlHttpObject();
    var url = "openDashBoard";
    xmlHttp.onreadystatechange = showmenudata1;
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);

});
function showmenudata1()
{
	if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
	{
		$("#data").html(xmlHttp.responseText);
	}
}
</script>
<body>
            <div class="card-body">                               
            <div id="data"></div>                                          
             </div>
	
	
	 <%@include file="footer.jsp" %>
   <script src="resources/dist/js/sidebarmenu.js"></script> 
</body>

</html>
