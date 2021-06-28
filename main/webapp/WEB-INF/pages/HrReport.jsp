<%@include file="header.jsp"%>

<script src="resources/customjs/reports.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/validation/validation.css">
<link rel="stylesheet" href="resources/bootstrapCSS/datepicker.css" />
      <script src="resources/customjs/bootstrap-datepicker.js"></script> 


<script>
$(document).ready(function() {
	$("#errormessages").hide();
});
</script>
<script>
	$(function() {
		$("#fromdate").datepicker({
			dateFormat : "dd-mm-yy",
		});
		$("#todate").datepicker({
			dateFormat : "dd-mm-yy",
		});


	});
</script>
<div>

	<h3 align="center">HR REPORT CENTER</h3>
</div>
<hr color="00FFFF">
<div class="col-md-6">
	<h4 align="left" style="color: #fb8c00">HeaderInformation</h4>
</div>
<div class="box-content row">

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">Division</label> <select
			class="form-control" id="division" multiple>
		</select>
	</div>

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">Cadre</label> <select
			class="form-control" id="cadreid" multiple>
		</select>
	</div>

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">Grade</label> <select
			class="form-control" id="gradeId" multiple>
		</select>
	</div>

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">Departement</label> <select
			class="form-control" id="workdeptid" multiple>
		</select>
	</div>

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">Section</label> <select
			class="form-control" id="sectionid" multiple>
		</select>
	</div>

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">JobStatus</label> <select
			class="form-control" id="jobstatus" multiple>
		</select>
	</div>


	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">Employee
			Status</label> <select class="form-control" id="empstatus" multiple>
		</select>
	</div>

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">ID No</label> <input
			type="text" id="idNumber" class="form-control">

	</div>

	<div class="form-group has-warning  col-md-3">
		<label class="control-label" for="inputWarning1">Left Employee</label>
		<label> <input type="checkbox" id="" value="1">Yes
		</label><br>
	</div>


	<div class="form-group has-warning col-md-3">
		<label class="control-label" for="inputWarning1">Retirement
			Date</label> <label> <input type="checkbox" id="" value="1">Yes
		</label><br>
	</div>




</div>
<hr color="00FFFF">
<!-- Period Start -->

<div class="col-md-6">
	<h4 align="left" style="color: #fb8c00">Period</h4>

</div>

<div class="box-content row">

	<div class="form-group has-warning   col-md-2">
		<label class="control-label" for="inputWarning1">Final Year</label> <select
			class="form-control" id="">
			<option value=''>Select Year</option>
			<option value='1'>2019-2020</option>

		</select>
	</div>

	<div class="form-group has-warning   col-md-2">
		<label class="control-label" for="inputWarning1">Calender Year</label>
		<select class="form-control" id="year">
			<option value=''>Select Year</option>
			<option value='2019'>2019</option>
		</select>


	</div>

	<div class="form-group has-warning   col-md-3">
		<label class="control-label" for="inputWarning1">Month</label> <select
			class="form-control" id="month">
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

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">From Date </label> <input
			type="text" id="fromdate" placeholder="click here" class="form-control">

	</div>

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">To Date </label> <input
			type="text" id="todate" placeholder="click here" class="form-control">

	</div>

</div>
<hr color="00FFFF">
<!-- Display option -->

<div class="col-md-6">
	<h4 align="left" style="color: #fb8c00">Display Option</h4>

</div>

<div class="box-content row">

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">Employee
			Details</label> <select class="form-control" id="" multiple>
		</select>
	</div>

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">Salary
			Details </label> <select class="form-control" id="" multiple>
		</select>
	</div>

	<div class="form-group has-warning   col-md-2">
		<label class="control-label" for="inputWarning1">Order By</label> <select
			class="form-control" id="">

		</select>
	</div>




</div>
<hr color="00FFFF">

<!-- Result -->
<div class="alert alert-danger" id="errormessages">
  <strong>ErrorMessage!</strong> <p id="msg"></p>
</div>
<div class="col-md-6">
	<h4 align="left" style="color: #fb8c00">Result</h4>

</div>
<div class="box-content row">
	<div class="form-group has-warning    col-md-3">
		<label class="control-label" for="inputWarning1">Report Name</label><br>
		<select class="form-control" id="itemname">
		</select>
	</div>


	
</div>
<div align="center">
		<input type="submit" value="show"  id="showreports" class="btn btn-primary">
	 
</div>

<!-- modal Box -->
<%-- <%
int item=Integer.parseInt(request.getParameter("itemid"));
%>
 --%>

<script>


	
$(document).ready(function() {
	$("#showreports").on('click', function() {
		var reportname=$("#itemname").val();
		var name = $('#itemname option:selected').text();
	    	alert(reportname);
		
		//32 number is coming from Database
		if(reportname=="32"){
			$('#listemployees').dataTable({
				retrieve: true,
				"ajax" : {
					"url" : "/DASHBOARD/getEmployeeInformation",
					"dataSrc" : "dataBean",
					"type" : "GET",

				},
				"columns" : [

				{
					data : "idNumber"
				}, {
					data : "employeeName"
				}, {
					data : "design"
				}, {
					data : "hrDepartmentMaster.name"
				},

				],

			});
			$('#employeeListModal').modal('show');
		}
		 // 33 number is coming from Database
		if(reportname=="33"){
			$('#DailyAttendenceList').dataTable({
				retrieve: true,
				"ajax" : {
					"url" : "/DASHBOARD/",
					"dataSrc" : "dataBean",
					"type" : "GET",

				},
				"columns" : [

				{
					data : ""
				}, {
					data : ""
				}, {
					data : ""
				}, {
					data : ""
				},

				],

			});
			$('#DailyAttendenceReportModel').modal('show');
		}
		//34 number is coming from Database

		if(reportname=="34"){
		var division=	$("#division").val();
		var month=	$("#month").val();
		var year=	$("#year").val();
		alert(division+""+month+""+year);
		if(division== "" || month== "" || year== ""){
			 $("#msg").html("Please select Above mandatory fields from division,month and year ");
			$("#errormessages").show();
		}else{
			window.open('MonthlyAttendenceReports.jsp?division='+division+'&&month='+month+'&&year='+year);
		}
			
		}
		//35 number is coming from Database

		if(reportname=="35"){
			$('#LeaveRegisterList').dataTable({
				retrieve: true,
				"ajax" : {
					"url" : "/DASHBOARD/",
					"dataSrc" : "dataBean",
					"type" : "GET",

				},
				"columns" : [

				{
					data : ""
				}, {
					data : ""
				}, {
					data : ""
				}, {
					data : ""
				},

				],

			});
			$('#LeaveRegisterModel').modal('show');
		}
		
		if(reportname=="46"){
			//var division=	$("#division").val();
			//var month=	$("#month").val();
			//var year=	$("#year").val();
			//alert(division+""+month+""+year);
			//if(division== "" || month== "" || year== ""){
				// $("#msg").html("Please select Above mandatory fields from division,month and year ");
			//	$("#errormessages").show();
			//}else{
				window.open('monthlypayslip.jsp');
			//}
				
			}
		
		 });
	});
	

</script>


<!--  EmployeeListModal-->
<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="employeeListModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title" align="center">Employee List</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<table id="listemployees" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
							<th>Idno</th>
							<th>Employee Name</th>
							<th>Designation</th>
							<th>Department</th>
						</tr>
						</thead>
					</table>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>

<!-- DailyAttendenceReport -->
<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="DailyAttendenceReportModel">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title" align="center">DailyAttendenceReport</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<table id="DailyAttendenceList" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
							<th></th>
							<th> </th>
							<th></th>
							<th></th>
						</tr>
						</thead>
					</table>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>

<!-- Monthly Attendance Report -->
<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="monthlyAttendanceModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title" align="center">Monthly Attendance Report</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
				<div class="search-table-outter wrapper">
					<table id="monthlyAttendanceList" class="display">
						<thead>
						<tr>
							<th>Idno</th>
							<th>empname</th>
							<th>desgn</th>
							<th>Department</th>
							<th>Month Days</th>
							<th >present</th>	
							<th>W-Off</th>	
							<th >Leaves</th>
							<th>PH	</th>
							<th>Absent/LOP</th>
							<th>DaysRecommend</th>	
							<th>Remarks</th>
	<!-- Phy	OD		CL	SL	EL	C-Off		Prev Mon	Curr Mon	Total -->		
							
						</tr>
						</thead>
					</table>
				</div>
</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>

<!-- Leave Register -->
<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="LeaveRegisterModel">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title" align="center">LeaveRegister</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<table id="LeaveRegisterList" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
							<th></th>
							<th> </th>
							<th></th>
							<th></th>
						</tr>
						</thead>
					</table>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>
      	      
<%@include file="footer.jsp"%>
	<script src="resources/dist/js/sidebarmenu.js"></script>