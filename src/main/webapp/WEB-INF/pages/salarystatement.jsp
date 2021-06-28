<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title></title>
     <style>
.nth-table {
    border-collapse: collapse;
    border: 1px solid #400040;
  }
 .nth-table tr:nth-child(){
        background: #ebf7d4;
        
    }
.nth-table th{
    border: 1px dotted #460046;
    color: #000;
    padding:5px;
    background-color:#AFD8D8;
  }
.nth-table td{
    border: 1px dashed #000;
    color: #002F5E;
    padding:5px;
    width:100px;
  }
  
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script>
$(document).ready(function() {
	 $("#image").hide();
	 $("#data").hide();
	
	 
});

$(document).ready(function() {
	
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallproject", 

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('project');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["tranid"] + '">'
						+ abc[i]["projectname"] + '</option>';
			}

		}
	});
});

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallDivision", // this is my servlet
                        success : function(data) {
			var abc = data;
			var ele = document.getElementById('division');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
			ele.innerHTML = ele.innerHTML + '<option value="'+ abc[i]["divisionid"] + '">' + abc[i]["name"]+ '</option>';								
                    }
			}
                     });
 });
 
 function salarystatement(){
	 $("#image").show();
	 $("#data").show();
	    var year=document.getElementById("year").value;
		var project=document.getElementById("project").value;
 		var division=document.getElementById("division").value;
 		var month=document.getElementById("month").value;
 		displaysalarystatement(division,month,year,project);
	//	window.location.href='#/getsalarystatement/'+year+'/'+project+'/'+division+'/'+month;
 }
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
 function displaysalarystatement(division,month,year,project){
		xmlHttp = GetXmlHttpObject();
		var url = "getsalarystatement?division="+division+"&&month="+month+"&&year="+year+"&&project="+project;
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


<div class="row">
	   <div class="box col-md-12">
		<div class="box-inner">
      		<div class="row">
      		<div class="form-group has-warning    col-md-3">
			<label class="control-label"  style="color: Blue" for="inputWarning1">Division</label><br>                    
			<select class="form-control" id="division" name="division" style="border:1px solid #696969">
			<option value=''>Select </option>
			</select>                       
		</div>
    		<div class="form-group has-warning    col-md-3">
			<label class="control-label"  style="color: Blue" for="inputWarning1">Project</label><br>                    
			<select class="form-control" id="project" name="project" style="border:1px solid #696969">
			<option value=''>Select </option>
			</select>                       
		</div>
		<div class="form-group has-warning    col-md-3">
			<label class="control-label" style="color: Blue" for="inputWarning1">Month</label> <select
			class="form-control" id="month" name="month" style="border:1px solid #696969">
			<option value=''>Select Month</option>
			<option value='1'>Janaury</option>
			<option value='2'>February</option>
			<option value='3'>March</option>
			<option value='4'>April</option>
			<option value='5'>May</option>
			<option value='6'>June</option>
			<option value='7'>July</option>
			<option value='8'>August</option>
			<option value='9'>September</option>
			<option value='10'>October</option>
			<option value='11'>November</option>
			<option value='12'>December</option>

		</select>
			                    
		</div>
		<div class="form-group has-warning    col-md-3">
			<label class="control-label"  style="color: Blue" for="inputWarning1">Year</label><br>                    
			  <select class="form-control" id="year" name="year" style="border:1px solid #696969">
			<option value=''>Select Year</option>
			<option value='2020'>2020</option>
			<option value='2019'>2019</option>
			<option value='2018'>2018</option>
			</select>                    
		</div>
                </div>
</div>
        <div align ="center">
		      <button  type="submit"  onclick="salarystatement()" style="background-color: blue;color:white" class="btn btn-primary"> Submit</button> 
		</div>
</div>
</div>

<div id="data" style="overflow: scroll; height : 90%; max-height:500px;
      overflow-y : auto; overflow-x : scroll ">
<div align="center"><img src="resources/img/reload.gif" id="image"></div>
</div>

</body>
<script src="resources/dist/js/sidebarmenu.js"></script>
<%@ include file="footer.jsp" %>
<script type="text/javascript" src="resources/Pdf&Excel&Print/jspdf.js"></script>  
<script type="text/javascript" src="resources/Pdf&Excel&Print/pdfFromHTML.js"></script>  
<script type="text/javascript" src="resources/Pdf&Excel&Print/print.js"></script>
<script type="text/javascript" src="resources/Pdf&Excel&Print/excel.js"></script>  
 
</html>







