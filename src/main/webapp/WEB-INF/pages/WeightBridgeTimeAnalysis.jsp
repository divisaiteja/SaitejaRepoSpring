<%@ include file="header.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
$(document).ready(function() {
	$.ajax({
		type: "GET",
		contentType : "application/json",
		 url: "FilterMaterial", //this is my servlet
		success: function(data){ 
			var abc=data;
			//alert(data[0]);
			var ele = document.getElementById('filtermaterial');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML +
				'<option value="' + abc[i]["materialname"] + '">' + abc[i]["materialname"] + '</option>';
			}
		}
	});
});
$(document).ready(function() {
	$.ajax({
		type: "GET",
		contentType : "application/json",
		 url: "FilterCustomer", //this is my servlet
		success: function(data){ 
			var abc=data;
			//alert(data[0]);
			var ele = document.getElementById('filtercustomer');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML +
				'<option value="' + abc[i]["supcustname"] + '">' + abc[i]["supcustname"] + '</option>';
			}
		}
	});
});

$(document).ready(function() {
	$.ajax({
		type: "GET",
		contentType : "application/json",
		 url: "FilterTransporter", //this is my servlet
		success: function(data){ 
			var abc=data;
			//alert(data[0]);
			var ele = document.getElementById('filtertransporter');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML +
				'<option value="' + abc[i]["transporter"] + '">' + abc[i]["transporter"] + '</option>';
			}
		}
	});
});

$(document).ready(function() {
	$.ajax({
		type: "GET",
		contentType : "application/json",
		 url: "FilterSources", //this is my servlet
		success: function(data){ 
			var abc=data;
			//alert(data[0]);
			var ele = document.getElementById('filtersources');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML +
				'<option value="' + abc[i]["soudest"] + '">' + abc[i]["soudest"] + '</option>';
			}
		}
	});
});
</script>
 <script>
$( document ).ready(function()  {
	  // var Filter=""; 
	   var Material="";
		var Customer="";
		var Transporter="";
		var Sources="";
   	$('#weightBridgeTimeAnalysis').dataTable( {
	   "destroy" : true,
			 "ajax" : {
				 "url" : "weightBridgeTimeAnalysis?Material="+Material+"&Customer="+Customer+"&Transporter="+Transporter+"&Sources="+Sources,
			   "dataSrc" : "dataBean",
			   "type" : "GET",
		       },
			"columns": [
							{ data: "sno"},
			 				{ data: "inwardno"},
					 		{ data: "truckno"},
							{ data: "netwt"},
							{ data: "securityin"},
							{ data: "securityout"},
							{data:"duration"},
							{ data: "status"},
					],
					dom: 'Bfrtip',
			        buttons: [
			                  {
			                      extend: 'pdf',
			                      orientation: 'landscape',
				                  pageSize: 'LEGAL',
			                      title:'WeightBridgeTimeAnalysisReport',
			                      text: 'pdf'
			                     
			                  },
			                  {
			                      extend: 'excel',
			                      title:'WeightBridgeTimeAnalysisReport',
			                      text:'excel'
			                  },
			                  {
			                      extend: 'csv',
			                      title:'WeightBridgeTimeAnalysisReport',
			                      text:'csv'
			                  },
			                  {
			                      extend: 'print',
			                      title:'WeightBridgeTimeAnalysisReport',
			                      text:'print'
			                  },
			                  {
			                      extend: 'copy',
			                      title:'WeightBridgeTimeAnalysisReport',
			                      text:'copy'
			                  }
			                  
			        ]
		} );
} );
</script> 
  

<script>
 function Filter(){
	// alert("Filter");
	 var Material=document.getElementById("filtermaterial").value;
     var Customer=document.getElementById("filtercustomer").value;
	 var Transporter=document.getElementById("filtertransporter").value;
	 var Sources=document.getElementById("filtersources").value; 
	 commonFunction(Material, Customer, Transporter,Sources);
}

function commonFunction(Material, Customer, Transporter,Sources) {
	//alert("we are in commonFunction function");
	$.ajax({
		url : "weightBridgeTimeAnalysis?Material="+Material+"&Customer="+Customer+"&Transporter="+Transporter+"&Sources="+Sources,
		success : function(data, textStatus, jqXHR) {
			//location.reload();
			var table_data = data.dataBean;
			var table = $('#weightBridgeTimeAnalysis').DataTable(
							{
								"destroy" : true,
								data : table_data,
								columns : [
								{ data: "sno"},
				 				{ data: "inwardno"},
						 		{ data: "truckno"},
								{ data: "netwt"},
								{ data: "securityin"},
								{ data: "securityout"},
								{data:"duration"},
								{ data: "status"},
						],
						dom: 'Bfrtip',
				        buttons: [
				                  {
				                      extend: 'pdf',
				                      title:'WeightBridgeTimeAnalysisReport',
				                      text: ' pdf'
				                     
				                  },
				                  {
				                      extend: 'excel',
				                      title:'WeightBridgeTimeAnalysisReport',
				                      text:' excel'
				                  },{
				                      extend: 'csv',
				                      title:'WeightBridgeTimeAnalysisReport',
				                      text:' csv'
				                  },
				                  {
				                      extend: 'print',
				                      title:'WeightBridgeTimeAnalysisReport',
				                      text:' print'
				                  },
				                  {
				                      extend: 'copy',
				                      title:'WeightBridgeTimeAnalysisReport',
				                      text:' copy'
				                  }
				                  
				        ]
			} );
	
} 
	} );
	
}

</script>
<body>

<h3 align="center">WeightBridgeTimeAnalysis</h3><br><br>
<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-content row">
				<div class="form-group has-warning col-md-3">
					<label style="color: Blue" class="control-label" for="inputWarning1">Material
						</label> <select class="form-control" id="filtermaterial" name="filtermaterial" onchange="Filter()" style="border:1px solid #696969;">
						<option value="">select</option>
					</select>
				</div>
				<div class="form-group has-warning col-md-3">
					<label  style="color: Blue"  class="control-label" for="inputWarning1">Customer</label><br>
					<select class="form-control" id="filtercustomer" name="filtercustomer" onchange="Filter()" style="border:1px solid #696969;">
						<option value="">select</option>
					</select>
				</div>				
				
				<div class="form-group has-warning col-md-3">
					<label  style="color: Blue"  class="control-label" for="inputWarning1">Transporter</label><br>
					<select class="form-control" id="filtertransporter" name="filtertransporter" onchange="Filter()" style="border:1px solid #696969;">
						<option value="">select</option>
					</select>
				</div>
				<div class="form-group has-warning col-md-3">
					<label  style="color: Blue"  class="control-label" for="inputWarning1">Sources</label><br>
					<select class="form-control" id="filtersources" name="filtersources" onchange="Filter()" style="border:1px solid #696969;">
						<option value="">select</option>
					</select>
				</div>
			</div>
			 <!-- <div align="center">
			       <input type="submit"  value="Show" onclick="submit()" style="background-color: blue;color:white"	class="btn btn-primary"   >
		      </div> -->
		</div>
	</div>
</div>

<table id="weightBridgeTimeAnalysis" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		<th>sno</th>
                <th>Gpno</th>
                <th>vechicleNo</th>
                <th>Quantity</th>
                <th>InTime</th>
                <th>OutTime</th>
                <th>Duration</th>
                <th>Status</th>
            </tr>
        </thead>
       
    </table>
    <script src="resources/dist/js/sidebarmenu.js"></script>
</body>
<%@ include file="footer.jsp" %>
<script type="text/javascript" src="resources/report/dataTables.buttons.min.js"></script>  
 <script type="text/javascript" src="resources/report/buttons.print.min.js"></script>  
 <script type="text/javascript" src="resources/report/buttons.html5.min.js"></script>   
<script type="text/javascript" src="resources/report/pdfmake.min.js"></script>
<script type="text/javascript" src="resources/report/jszip.min.js"></script>
<script type="text/javascript" src="resources/report/vfs_fonts.js"></script> 
</html>

