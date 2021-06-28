<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.search-table-outter{
overflow-x:scroll;
overflow-y:scroll;
}
</style>
</head>
<script>
$(document).ready(function() {
	 $("#autoScroll").hide();
});
</script>
 <script>
function qualityreport() {
	//alert("qualityreport");
	var infodate = document.getElementById("date").value;
	//alert(infodate);
	$.ajax({
		url : "QualityReport?infodate="+infodate,
		success : function(data, textStatus, jqXHR) {
			 $("#autoScroll").show();
			//location.reload();
			var table_data = data.dataBean;
			var table = $('#QualityReport').DataTable(
							{
								"destroy" : true,
								data : table_data,
								columns : [
								{ data: "orderno"},
				 				{ data: "inwardno"},
						 		{ data: "supcustname"},
								{ data: "inwarddate"},
								{ data: "netwt"},
								{ data: "rate"},
								{data:"preoil"},
								{ data: "preffa"},
								{ data: "premoisture"},
								{data:"postoil"},
								{ data: "postffa"},
								{ data: "postmoisture"},
								{data:"weighbridgeffa"},
								{ data: "weighbridgemoisture"},
								{ data: "weighbridgeremarks"},
								{data:"unloadingffa"},
								{ data: "unloadingmoisture"},
								{ data: "unloadingremarks"},
								{ data: "lessamount"},
								{ data: "signature"},
								
								
						],
						dom: 'Bfrtip',
				        buttons: [
				                  {
				                      extend: 'pdf',
				                      orientation: 'landscape',
					                  pageSize: 'LEGAL',
				                      title:'AP INVOICELAB REGISTER',
				                      text: 'pdf'
				                     
				                  },
				                  {
				                      extend: 'excel',
				                      title:'AP INVOICELAB REGISTER',
				                      text:'excel'
				                  },
				                  {
				                      extend: 'csv',
				                      title:'AP INVOICELAB REGISTER',
				                      text:'csv'
				                  },
				                  {
				                      extend: 'print',
				                      title:'AP INVOICELAB REGISTER',
				                      text:'print'
				                  },
				                  {
				                      extend: 'copy',
				                      title:'AP INVOICELAB REGISTER',
				                      text:'copy'
				                  }
				                  
				        ]
			} );
	
} 
	} );
}
</script>


<body>
<h3 align="center"><b>KALLAMAGROPRODUCTS & PRIVATE LIMITED</b></h3>
<br><br>
<div class="row">
	<div class="box col-md-8">
		<div class="box-inner">
			<div class="box-content row">
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Date</label>
					<input type="text" id="date" name="date"  autocomplete="off" onchange="qualityreport()" class="form-control">
				</div>
			</div>
		</div>
	</div>
</div>


</body>
<div class="search-table-outter wrapper" id="autoScroll">
<table id="QualityReport" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		<th rowspan="2">INVOICE NO</th>
                <th rowspan="2">INWARD NO</th>
                <th rowspan="2"> PARTY NAME</th>
                <th rowspan="2"> DATE</th>
                <th rowspan="2">QUANTITY</th>
                <th rowspan="2">RATE</th>
                <th colspan="3">PRE TEST</th>
                <th colspan="3">POST TEST</th>
                <th colspan="3">WEIGHTMENT</th>
                <th colspan="3">UNLOADING</th>
                <th rowspan="2">LESS AMOUNT</th>
                <th rowspan="2"> SIGNATURE</th>
            </tr>
            <tr>
              <th>OIL</th>
              <th>FFA</th>
              <th>MOISTURE</th>
              <th>OIL</th>
              <th>FFA</th>
              <th>MOISTURE</th>
              <th>FFA</th>
              <th>MOISTURE</th>
              <th>REMARKS</th>
             <th>FFA</th>
             <th>MOISTURE</th>
             <th>REMARKS</th>
            </tr>
        </thead>
       
    </table>
    </div>
    <script src="resources/dist/js/sidebarmenu.js"></script>
<%@include file="footer.jsp" %>
<script type="text/javascript" src="resources/report/dataTables.buttons.min.js"></script>  
<script type="text/javascript" src="resources/report/buttons.print.min.js"></script>  
<script type="text/javascript" src="resources/report/buttons.html5.min.js"></script>   
<script type="text/javascript" src="resources/report/pdfmake.min.js"></script>
<script type="text/javascript" src="resources/report/jszip.min.js"></script>
<script type="text/javascript" src="resources/report/vfs_fonts.js"></script> 
<script>

jQuery('#date').datepicker({
    autoclose: true,
    format:'dd-mm-yyyy',
    todayHighlight: true
    
});
</script> 
</html>

