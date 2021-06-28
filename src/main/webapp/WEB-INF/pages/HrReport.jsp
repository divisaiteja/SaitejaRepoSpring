  <%@include file="header.jsp"%> 
  <!-- <script src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script> 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script> 
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/pdfmake.min.js"></script> 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.32/vfs_fonts.js"></script> 
 <script src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.html5.min.js"></script> 
 <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.print.min.js"></script>  -->
<script>
function reload() {
	location.reload(true);
}
</script>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid black;
	text-align: left;
	padding: 6px;
}

.search-table-outter {
	border:1px;
}

.search-table {
	table-layout: fixed;
	margin: 40px auto 0px auto;
}

.search-table, td, th {
	border-collapse: collapse;
	border: 1px solid #777;
}

th {
	padding:0px;
	font-size: 15px;
	color: #444;
	background: #66C2E0;
}

td {
	padding:0px;
	height: 35px;
}

.search-table-outter {
	overflow-x: scroll;
}

th, td {
	min-width:0px;;
}

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
  @media print {
  .header-print {
    display: table-header-group;
  }
}
</style>
<script src="resources/customjs/reports.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/validation/validation.css">

<script>
$(document).ready(function() {
	$("#errormessages").hide();
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
		<label class="control-label" for="inputWarning1">Project</label> <select
			class="form-control" id="project" multiple>
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
		<label class="control-label" for="inputWarning1">Fin.Year</label> <select
			class="form-control" id="">
			<option value=''>Select Fin.Year</option>
			<option value='1'>2019-2020</option>

		</select>
	</div>

	<div class="form-group has-warning   col-md-2">
		<label class="control-label" for="inputWarning1">Calender Year</label>
		<select class="form-control" id="year">
			<option value=''>Select Year</option>
			<option value='2020'>2020</option>
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
			Details</label> <select class="form-control" id="displayFields" multiple>
			<option value="Employee Code">Employee Code</option>                        
			<option value="Date of Joining">Date of Joining</option>                        
			<option value="Grade">Grade</option>                           
			<option value="Gender">Gender</option>                                                   
			<option value="Project">Project</option>                            
			<option value="Section">Section</option>                        
			<option value="Reporting To">Reporting To</option>                        
			<option value="Date of Birth">Date of Birth</option>                        
			<option value="Mobile Number">Mobile Number</option>                        
                        <option value="e-Mail">e-Mail</option>                        
			<option value="Blood Group">Blood Group</option>                        
			<option value="Marital Status">Marital Status</option>                        
			<option value="Aadhar">Aadhar No</option>                        
			<option value="Bank Details">Bank Details</option>                        
			<option value="Qualifications">Qualifications</option>                        
			<option value="PF-UAN Number">PF-UAN Number</option>                                                
			<option value="ESI Number">ESI Number</option>                                                
                        <option value="Retirement">Retirement Date</option>                                                                        
		</select>
	</div>

	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">Salary
			Details </label> <select class="form-control" id="displayEarnings" multiple>
			<option value="Basic">Basic</option>                                                
			<option value="DA">DA</option>                                                
			<option value="HRA">HRA</option>                                                
			<option value="Conveyance">Conveyance</option>                                                
			<option value="LTA">LTA</option>                                                
			<option value="Medical">Medical</option>                                                
			<option value="Other Allowance">Other Allowance</option>                                                
			<option value="Gross Salary">Gross Salary</option>                                                
			<option value="CTC">CTC</option>
			<option value="WEF">W.E.F.</option>                                                
		</select>
	</div>

	<div class="form-group has-warning   col-md-2">
		<label class="control-label" for="inputWarning1">Order By</label> <select
			class="form-control" id="">

		</select>
	</div>




</div>
<hr color="00FFFF">

<div class="col-md-6">
	<h4 align="left" style="color: #fb8c00">Result</h4>

</div>
<div class="box-content row">
	<div class="form-group has-warning    col-md-3">
		<label class="control-label" for="inputWarning1">Report Name</label><br>
		<select class="form-control" id="itemname">
                <option value="0"><----Select Report----></option>                       
		</select>
	</div>


	
</div>
<div align="center">
		<input type="submit" value="show"  id="showreports" class="btn btn-primary">
	 
</div>
<!-- Result -->
<div class="alert alert-danger" id="errormessages">
  <strong>ErrorMessage!</strong> <p id="msg"></p>
</div>
<script>
$(document).ready(function() {
	
	$("#showreports").on('click', function() {
		var reportname=$("#itemname").val();
		var name = $('#itemname option:selected').text();
                    var division=$("#division").val();           
                    var cadre=$("#cadreid").val();                               
                    var grade=$("#gradeId").val();
                    var dept=$("#workdeptid").val();
                    var section=$("#sectionid").val();
                    var jobstatus=$("#jobstatus").val();
                    var empstatus=$("#empstatus").val();
                    var project=$("#project").val();
                    var idno=$("#idNumber").val();
                    var fromdate=$("#fromdate").val();
        		//32 number is coming from Database

		if(reportname=="32"){

                    var flds="";

                    if ($("#displayFields").val()!="") {
                        flds = $("#displayFields").val();
                    }
                    if ($("#displaySalary").val()!="") {
                        flds = flds + $("#displayEarnings").val();
                    }
                    	window.open('EmployeeListingReport.jsp?division='+division+'&&flds='+flds+'&&cadre='+cadre+'&&grade='+grade+'&&dept='+dept+'&&section='+section+'&&jobstatus='+jobstatus+'&&empstatus='+empstatus+'&&project='+project+'&&idno='+idno);
                    }
		//50 number is coming from Database
		if(reportname=="50"){
			$('#listsalary').dataTable({
				 
				 retrieve: true, 
				 paging: true,
				"ajax" : {
					"url" : "/HRMS/getSalaryDetails?division="+division+"&&project="+project,
					"dataSrc" : "dataBean",
					"type" : "GET",

				},
				columns : [

				{
					data : "idno"
				}, {
					data : "wef"
				}, {
					data : "basic"
				}, {
					data : "da"
				}, {
					data : "lta"
                }, {
					data : "hra"
				}, {
					data : "medical"
				}, {                         
					data : "conveyance"
				}, {                         
					data : "bonus"
				}, {                         
					data : "others1"
				}, {
					data : "others2"                                        
                }, {                         
					data : "grosssalary"
				}, {
					data : "pfpercentage"  }                                      
               
                
				],
				
				 dom: 'Bfrtip',
			        buttons: [
			        	{
		                     extend: 'pdf',
		                     orientation: 'landscape',
		                     pageSize: 'LEGAL',
		                     title:'Salary Details Report'
		                 },
		                 {
		                     extend: 'excel',
		                     title:'Salary Details  Report'
		                 },
		                 {
		                     extend: 'csv',
		                     title:'Salary Details Report'
		                 },{
		                     extend: 'print',
		                     title:'Salary Details Report'
		                 },
		                 {
		                     extend: 'copy',
		                     title:'Salary Details Report'
		                 }
			        ]
			});
			$('#salaryListModal').modal('show');
		}
        		
		//51 number is coming from Database
		if(reportname=="51"){
			$('#listemployee').dataTable({
				 retrieve: true, 
				"ajax" : {
					"url" : "/HRMS/getEmpJobDetails?division="+division+"&&project="+project,
					"dataSrc" : "dataBean",
					"type" : "GET",

				},
			destroy:true,
				
				"columns" : [

				{
					data : "idNumber"
				}, {
					data : "employeeName"
				}, {
					data : "design"
				}, {
					data : "hrDepartmentMaster.name"
				}, {
					data : "sectionDTO.name"
                }, {
					data : "dateOfJoining"
				}, {
					data : "divisiondto.name"
				}, {                         
					data : "jobstatusDTO.description"
				}, {                         
					data : "cadreDTO.cadredescription"
				}, {                         
					data : "gradeDTO.description"
				}, {
					data : "statusCodeForActive"                                        
                },                                
				],
				dom: 'Bfrtip',
		        buttons: [
		        	{
	                     extend: 'pdf',
	                     orientation: 'landscape',
	                     pageSize: 'LEGAL',
	                     title:'Job Details Report'
	                 },
	                 {
	                     extend: 'excel',
	                     title:'Job Details Report'
	                 },
	                 {
	                     extend: 'csv',
	                     title:'Job Details Report'
	                 },{
	                     extend: 'print',
	                     title:'Job Details Report'
	                 },
	                 {
	                     extend: 'copy',
	                     title:'Job Details Report'
	                 }
		                  
		        ]

			});
			$('#employeeListModal').modal('show');
		}
		
		// 52 number is coming from Database
		if(reportname=="52"){
			
		$('#listpersonal').dataTable({
			 retrieve: true, 
			"ajax" : {
				"url" : "/HRMS/getPersonlDetails?division="+division+"&&project="+project,
				"dataSrc" : "dataBean",
				"type" : "GET",

			},
			"columns" : [

			{
				data : "personalparentid"
			}, {
				data : "emailid"
			}, {
				data : "maritalstatus"
			}, {
				data : "mobilenumber"
			}, {
				data : "alternatemobilenumber"
           }, {
				data : "drivinglicenceno"
			}, {
				data : "drivinglicencevalidity"
			}, {                         
				data : "passportnumber"
			}, {                         
				data : "passportvalidity"
			}, {                         
				data : "adhaarnumber"
			}, {
				data : "pancardnumber"                                        
            },  {
				data : "bankname"
			}, {
				data : "bankbranch"
			}, {
				data : "branchifsccode"
			}, {
				data : "accountnumber"
			}, {
				data : "cardnumber"
            }, {
				data : "presentaddress"
			}, {
				data : "permanentaddress"
			}, {                         
				data : "bloodgroup"
			}, {                         
				data : "doBirth"
			},  
			],
			dom: 'Bfrtip',
	        buttons: [
	                  
	        	 {
                     extend: 'pdf',
                     orientation: 'landscape',
                     pageSize: 'LEGAL',
                     title:'Personl Details Report'
                 },
                 {
                     extend: 'excel',
                     title:'Personl Details  Report'
                 },
                 {
                     extend: 'csv',
                     title:'Personl Details Report'
                 },{
                     extend: 'print',
                     title:'Personl Details Report'
                 },
                 {
                     extend: 'copy',
                     title:'Personl Details Report'
                 }
	        ]
			
		});
		
		$('#personalListModal').modal('show');
	}
	//53 number is coming from Database
		if(reportname=="53"){
			
			$('#listfamily').dataTable({
				 retrieve: true, 
				"ajax" : {
					"url" : "/HRMS/getFamilyDetails?division="+division+"&&project="+project,
					"dataSrc" : "dataBean",
					"type" : "GET",

				},
				"columns" : [

				{
					data : "parentid"
				}, {
					data : "gender"
				}, {
					data : "name"
				}, {
					data : "relation"
				}, {
					data : "dob"
	           }, {
					data : "adhaarno"
				}, {
					data : "qualification"
				}, {                         
					data : "occupation"
				}, {                         
					data : "mobileno"
				},
				],
				dom: 'Bfrtip',
		        buttons: [
		        	{
	                     extend: 'pdf',
	                     orientation: 'landscape',
	                     pageSize: 'LEGAL',
	                     title:'Family Details Report'
	                 },
	                 {
	                     extend: 'excel',
	                     title:'Family Details  Report'
	                 },
	                 {
	                     extend: 'csv',
	                     title:'Family Details Report'
	                 },{
	                     extend: 'print',
	                     title:'Family Details Report'
	                 },
	                 {
	                     extend: 'copy',
	                     title:'Family Details Report'
	                 }
		        ]

			});
			$('#familyListModal').modal('show');
		}
		
	//54 number is coming from Database
		if(reportname=="54"){
			
			$('#listexperience').dataTable({
				 retrieve: true, 
				"ajax" : {
					"url" : "/HRMS/getExperienceDetails?division="+division+"&&project="+project,
					"dataSrc" : "dataBean",
					"type" : "GET",

				},
				"columns" : [

				{
					data : "parentid"
				}, {
					data : "employeename"
				}, {
					data : "address"
				}, {
					data : "workperiod"
				}, {
					data : "designation"
	           }, {
					data : "ctc"
				}, {
					data : "remarks"
				}, {                         
					data : "experiencedetails"
				}, 
				],
				dom: 'Bfrtip',
		        buttons: [
		        	{
	                     extend: 'pdf',
	                     orientation: 'landscape',
	                     pageSize: 'LEGAL',
	                     title:'Experience Details Report'
	                 },
	                 {
	                     extend: 'excel',
	                     title:'Experience Details  Report'
	                 },
	                 {
	                     extend: 'csv',
	                     title:'Experience Details Report'
	                 },{
	                     extend: 'print',
	                     title:'Experience Details Report'
	                 },
	                 {
	                     extend: 'copy',
	                     title:'Experience Details Report'
	                 }
		        ]

			});
			$('#experienceListModal').modal('show');
		}
	
		//55 number is coming from Database
           if(reportname=="55"){
			$('#listeducation').dataTable({
				 retrieve: true, 
				"ajax" : {
					"url" : "/HRMS/getEducationDetails?division="+division+"&&project="+project,
					"dataSrc" : "dataBean",
					"type" : "GET",

				},
				"columns" : [

				{
					data : "parentid"
				}, {
					data : "certificates"
				}, {
					data : "institutionname"
				}, {
					data : "address"
				}, {
					data : "yearofpassing"
	           }, {
					data : "markspercentage"
				}, {
					data : "remarks"
				},  
				],
				dom: 'Bfrtip',
		        buttons: [
		        	{
	                     extend: 'pdf',
	                     orientation: 'landscape',
	                     pageSize: 'LEGAL',
	                     title:'Education Details Report'
	                 },
	                 {
	                     extend: 'excel',
	                     title:'Education Details  Report'
	                 },
	                 {
	                     extend: 'csv',
	                     title:'Education Details Report'
	                 },{
	                     extend: 'print',
	                     title:'Education Details Report'
	                 },
	                 {
	                     extend: 'copy',
	                     title:'Education Details Report'
	                 }
		        ]

			});
			$('#educationListModal').modal('show');
		}
	
		//56 number is coming from Database
		
           if(reportname=="56"){
        	   
   			$('#listemployeeshifts').dataTable({
   				 retrieve: true, 
   				"ajax" : {
   					"url" : "/HRMS/getEmployeeShiftsDetails?division="+division+"&&project="+project,
   					"dataSrc" : "dataBean",
   					"type" : "GET",

   				},
   				"columns" : [

   				{
   					data : "idno"
   				}, {
   					data : "monday"
   				}, {
   					data : "tuesday"
   				}, {
   					data : "wednesday"
   				}, {
   					data : "thursday"
   	           }, {
   					data : "friday"
   				}, {
   					data : "saturday"
   				},  {
   					data:  "sunday"
   				},{
   					data:  "effectFrom"
   				},{
   					data:  "effectTo"
   				},{
   					data:  "otEligibility"
   				},{
   					data:  "statusCodeForActive"
   				},
   				],
   				dom: 'Bfrtip',
		        buttons: [
		        	{
	                     extend: 'pdf',
	                     orientation: 'landscape',
	                     pageSize: 'LEGAL',
	                     title:'Employee Shifts Report'
	                 },
	                 {
	                     extend: 'excel',
	                     title:'Employee Shifts  Report'
	                 },
	                 {
	                     extend: 'csv',
	                     title:'Employee Shifts Report'
	                 },{
	                     extend: 'print',
	                     title:'Employee Shifts Report'
	                 },
	                 {
	                     extend: 'copy',
	                     title:'Employee Shifts Report'
	                 }
		        ]

   			});
   			$('#employeeshiftsListModal').modal('show');
   		}
           if(reportname=="62"){
   			var division=$("#division").val();
   			var project=$("#project").val();
   			var tmon=$("#month").val();                    
                           var tyear=$("#year").val();
   			$('#MusterRoleReportList').dataTable({
   				retrieve: true,
   				"ajax" : {
   					"url" : "getDailyAttendenceReport?division="+division+"&&tmon="+tmon+"&&tyear="+tyear+"&&project="+project,
   					"dataSrc" : "dataBean",
   					"type" : "GET",
   				},
   				"columns" : [
                                   {               
   					data : "slno"
   				},                                    
                                   {
   					data : "idno"
   				}, 
                                   {
   					data : "EmployeeName"
   				}, 
                                   {       data : "C1"},{data : "C2"},{data : "C3"},{data : "C4"},{data : "C5"},                                          
                                   {       data : "C6"},{data : "C7"},{data : "C8"},{data : "C9"},{data : "C10"},                                          
                                   {       data : "C11"},{data : "C12"},{data : "C13"},{data : "C14"},{data : "C15"},                                          
                                   {       data : "C16"},{data : "C17"},{data : "C18"},{data : "C19"},{data : "C20"},                                          
                                   {       data : "C21"},{data : "C22"},{data : "C23"},{data : "C24"},{data : "C25"},                                          
                                   {       data : "C26"},{data : "C27"},{data : "C28"},{data : "C29"},{data : "C30"},                                          
                                   {       data : "C31"},{data : "TPre"},{data : "Remarks"},                                          
   				],
   				dom: 'Bfrtip',
   		        buttons: [
   		        	{
                        extend: 'pdf',
                        orientation: 'landscape',
                        pageSize: 'LEGAL',
                        title:'Muster-Role'
                    },
                    {
                        extend: 'excel',
                        title:'Muster-Role'
                    },
                    {
                        extend: 'csv',
                        title:'Muster-Role'
                    },{
                        extend: 'print',
                        title:'Muster-Role'
                    },
                    {
                        extend: 'copy',
                        title:'Muster-Role'
                    }
   		        ]

   			});
   			$('#MusterRoleReportModel').modal('show');
   			$.ajax({
   				type : "get",
   				url :"getDailyAttendenceReportcount?division="+division+"&&tmon="+tmon+"&&tyear="+tyear+"&&project="+project ,
   				processData : false,
   				contentType : false,
   				success : function(data) {	
   					document.getElementById("presentcount").value=data.dataBean["present"];
   					document.getElementById("leavescount").value=data.dataBean["leaves"];
   					document.getElementById("lopcount").value=data.dataBean["lop"];
   					document.getElementById("phcount").value=data.dataBean["ph"];
   					document.getElementById("whcount").value=data.dataBean["wh"];
   				}
   			})
   		}
   	
   	
		
		 // 33 number is coming from Database
		if(reportname=="33"){
			var division=$("#division").val();
			var fromdate=$("#fromdate").val();
			alert(division+"-"+fromdate);
			if(division=="" || fromdate==""){
				 $("#msg").html("Please select Above mandatory fields from division,fromdate");
					$("#errormessages").show();
			}
				else{
					window.open("DailyAttendenceConsolidatedReport.jsp?division="+division+"&&fromdate="+fromdate);
					//window.location.href='#/getReport/'+division+'/'+project;
				}
			}
			/* $('#DailyAttendenceList').dataTable({
				retrieve: true,
				"ajax" : {
					"url" : "/HRMS/",
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
			$('#DailyAttendenceReportModel').modal('show'); */
		
		//34 number is coming from Database

		if(reportname=="34"){
		var month=	$("#month").val();
		var year=	$("#year").val();
		//alert(division+""+month+""+year);
		if(division== "" || month== "" || year== ""){
			 $("#msg").html("Please select Above mandatory fields from division,month and year ");
			$("#errormessages").show();
		}else{
			window.open('MonthlyAttendenceReports.jsp?division='+division+'&&month='+month+'&&year='+year);
		}
			
		}
			
		if(reportname=="72"){
			var division=$("#division").val();
			var project=$("#project").val();
			var month=	$("#month").val();
			var year=	$("#year").val();
			if(division== "" || month== "" || year== ""||project==""){
				 $("#msg").html("Please select Above mandatory fields from division,project,month and year ");
				$("#errormessages").show();
			}else{
				window.open('salarystatementreport.jsp?division='+division+'&&month='+month+'&&year='+year+'&&project='+project);
			}
				
			}
		if(reportname=="73"){
			var division=$("#division").val();
			var project=$("#project").val();
			var month=	$("#month").val();
			var year=	$("#year").val();
			if(division== "" || month== "" || year== ""||project==""){
				 $("#msg").html("Please select Above mandatory fields from division,project,month and year ");
				$("#errormessages").show();
			}else{
				window.open('MonthlyAttendence.jsp?division='+division+'&&month='+month+'&&year='+year+'&&project='+project);
			}
				
			}
		if(reportname=="74"){
			var month=	$("#month").val();
			var year=	$("#year").val();
			if( month== "" ||year==""){
				 $("#msg").html("Please select Above mandatory fields from month,year");
				$("#errormessages").show();
			}else{
				window.open('SalaryRegisterReport.jsp?month='+month+'&&year='+year);
			}
				
			}
		if(reportname=="75"){
			var division=$("#division").val();
			var project=$("#project").val();
			var fromdate=$("#fromdate").val();
			var todate=$("#todate").val();
			
			
			if(division== "" || fromdate== "" || todate== ""||project==""  ){
				 $("#msg").html("Please select Above mandatory fields from division,project,month and year ");
				$("#errormessages").show();
			}else{
				window.open('FormTwelve.jsp?division='+division+'&&todate='+todate+'&&fromdate='+fromdate+'&&project='+project);
			}
				
			}
		//35 number is coming from Database

		if(reportname=="35"){
			var division=$("#division").val();
			var fromdate=$("#fromdate").val();
			var todate=$("#todate").val();                    
                        
			$('#LeaveRegisterList').dataTable({
				retrieve: true,
				"ajax" : {
					"url" : "/HRMS/getEmployeeLeaveRegister?division="+division+"&&project="+project+"&&fromdate="+fromdate+"&&todate="+todate,
					"dataSrc" : "dataBean",
					"type" : "GET",

				},
				"columns" : [
/* 
				{
					data : "sno"
				}, */ {
					data : "idno"
				}, {
					data : "empname"
				}, {
					data : "desgn"
				},
				{
					data : "name"
				},
				{
					data : "fromdate"
				},
				{
					data : "todate"
				},

				{
					data : "CL"
				}, {
					data : "EL"
				}, {
					data : "SL"
				}, {
					data : "CO"
				},
				],

			});
			$('#LeaveRegisterModel').modal('show');
		}
		
		if(reportname=="46"){
			var division=	$("#division").val();
			var month=	$("#month").val();
			var year=	$("#year").val();
			var idNumber=$("#idNumber").val();
			//alert(division+"-"+month+"-"+year);
			if(division== "" || month== "" || year== ""){
				 $("#msg").html("Please select Above mandatory fields from division,month and year ");
				$("#errormessages").show();
			}else{
				window.open('monthlypayslip.jsp?division='+division+'&&month='+month+'&&year='+year);
			}
				
			}
		if(reportname=="47"){
			var month=	$("#month").val();
			var year=	$("#year").val();
			var division=$("#division").val();

			if(division== "" || month== "" || year== "" ){
				 $("#msg").html("Please select Above mandatory fields from division,month and year ");
				$("#errormessages").show();
			}else{
				window.open('monthlypaysheet.jsp?division='+division+'&&month='+month+'&&year='+year);
			}	
			}
		if(reportname=="48"){
			var month=	$("#month").val();
			var year=	$("#year").val();
			var division=$("#division").val();
			if(division== "" || month== "" || year== "" ){
				 $("#msg").html("Please select Above mandatory fields from division,month and year");
					$("#errormessages").show();
			}
				else{
					window.open('PFReport.jsp?division='+division+'&&month='+month+'&&year='+year);
				}
			
		}
		if(reportname=="49"){
			var month=	$("#month").val();
			var year=	$("#year").val();
			var division=$("#division").val();
			if(division== "" || month== "" || year== "" ){
				 $("#msg").html("Please select Above mandatory fields from division,month and year");
					$("#errormessages").show();
			}
				else{
					window.open('Esi.jsp?division='+division+'&&month='+month+'&&year='+year);
				}
			
		}
		
		if(reportname=="63"){
			alert(">>"+reportname)
			var idno=	$("#idNumber").val();
			
			if( idno== "" ){
				 $("#msg").html("Please select  mandatory field IDNO");
					$("#errormessages").show();
			}
				else{
					$.ajax({
				        type: "get",
				        contentType : "application/json",
				        url: "Form11BasedOnIdno?idno="+idno, //this is my servlet

				        success: function(data){ 
				        	openingForm11pdffile();
				        	//alert("YES");
				        }
				  });
				}
			
		}
		
		if(reportname=="64"){
			var division=$("#division").val();
			var fromdate=$("#fromdate").val();
			var todate=$("#todate").val();                    
		                
			$('#Dailypuncheslist').dataTable({
				retrieve: true,
				"ajax" : {
					"url" : "/HRMS/getDailypuncheslist?division="+division+"&&project="+project+"&&fromdate="+fromdate,
					"dataSrc" : "dataBean",
					"type" : "GET",

				},
				"columns" : [
		/* 
				{
					data : "sno"
				}, */ {
					data : "idno"
				}, {
					data : "empname"
				}, {
					data : "desgn"
				},
				{
					data : "name"
				},
				{
					data : "fromdate"
				},
				{
					data : "todate"
				},

				{
					data : "CL"
				}, {
					data : "EL"
				}, {
					data : "SL"
				}, {
					data : "CO"
				},
				],

			});
			$('#DailypuncheslistModel').modal('show');
		}

		if(reportname=="0"){
			
				 $("#msg").html("Please select Report Name.... ");
				$("#errormessages").show();
			
			}
		
		 });
	});
	
	

</script>
<!--*****************************  SalaryListModal *******************************-->
<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="salaryListModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
				<div class="container">
					<h4 class="modal-title" align="center">Salary Details</h4>
					</div>
					<button type="button" class="close" data-dismiss="modal" onclick="reload()">&times;</button>
				</div>
    
				<!-- Modal body -->
				<div class="modal-body">
				<div class="search-table-outter wrapper">
				<div>
		   <!--  <button class="dt-button buttons-excel buttons-html5" tabindex="0" aria-controls="listsalary" type="button"><span>Excel</span></button> -->
				</div>
					<table id="listsalary" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
						     <th>Idno</th>
							 <th>Wef</th>
							 <th>Basic</th>
							 <th>DA</th>                                                        
                             <th>LTA</th>
                             <th>HRA</th>
                             <th>Medical</th>
                             <th>Conveyance</th>
                             <th>Bonus</th>
                             <th>Other1</th>
                             <th>Other2</th>
                             <th>Grass<br>Salary</th>
                             <th>Pf%</th>
						</tr>
						</thead>
					</table>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="reload()">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>

<!--*****************************  EmployeeListModal *******************************-->

<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="employeeListModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
				<div class="container">
					<h4 class="modal-title" align="center">Job Details Report</h4>
					</div>
					<button type="button" class="close" data-dismiss="modal" onclick="reload()">&times;</button>
				</div>
    
				<!-- Modal body -->
				<div class="modal-body">
				<div class="search-table-outter wrapper">
					<table id="listemployee" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
						
						
						<th>Idno</th>
							<th>Employee Name</th>
							<th>Designation</th>
							<th>Department</th>
							<th>Section</th>                                                        
                             <th>DOJ</th>
                             <th>Division</th>
                             <th>JobStatus</th>
                             <th>Cadre</th>
                             <th>Grade</th>
                             <th>Technical</th>
						</tr>
						</thead>
					</table>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="reload()">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>

<!-- Personal Details Model Box -->

<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="personalListModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
				<div class="container">
					<h4 class="modal-title" align="center">Personal Details Report</h4>
					</div>
					<button type="button" class="close" data-dismiss="modal" onclick="reload()">&times;</button>
				</div>
    
				<!-- Modal body -->
				<div class="modal-body">
				 <div class="clearfix">
					<div class="pull-right tableTools-container"></div>
						</div>
				<div class="search-table-outter wrapper">
					<table id="listpersonal" class="header-print" cellspacing="0" width="100%" border="1" style="text-align: center;" >
						<thead>
						<!-- <tr>
						
							<th>ParentId</th>
							<th>EmailId</th>
							<th>MaritalStatus</th>
							<th>MobileNumber</th>
							<th>AlternateMobileNumber</th>                                                        
                             <th>DrivingLicenceno</th>
                             <th>DrivingLicenceValidity</th>
                             <th>PasspostNumber</th>
                             <th>PasspostValidity</th>
                             <th>AdhaarNumber</th>
                             <th>PancardNumber</th>
                             <th>BankName</th>
							<th>BankBranch</th>
							<th>BankIfscCode</th>                                                        
                             <th>AccountNumber</th>
                             <th>CardNumber</th>
                             <th>PresentAddress</th>
                             <th>PermanentAddress</th>
                             <th>BloodGroup</th>
                             <th>DOB</th>
                                                        
						</tr> -->
						<tr>
      <th rowspan="3" >Sno</th>
      <th rowspan="3" >Department/section</th>
      <th colspan="15" >Attendance Status</th>	
	  <th colspan="2" rowspan="2">Ot.Hours</th>
	  <th rowspan="3">Remarks</th>	  
	</tr>  
  <tr>	  
      <th colspan="2">ShiftA</th>
      <th colspan="2">ShiftB</th>
	  <th colspan="2">ShiftC</th>
      <th colspan="2">General</th>
      <th colspan="2">TotalPresent</th>
	  <th rowspan="2">OD</th>
	  <th rowspan="2">W-Off</th>
	  <th rowspan="2">leave</th>
	  <th rowspan="2">Ph</th>
	  <th rowspan="2">Lop</th>
	  
	  
  </tr>
  <tr>
	  <th>Emp</th>
	  <th>Cont</th>
	  <th>Emp</th>
	  <th>Cont</th>
	  <th>Emp</th>
	  <th>Cont</th>
	  <th>Emp</th>
	  <th>Cont</th>
	  <th>Emp</th>
	  <th>Cont</th>
	  <th>Emp</th>
	  <th>Cont</th>
  </tr>
						</thead>
					</table>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="reload()">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>

<!-- Family Details Model Box -->
<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="familyListModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
				<div class="container">
					<h4 class="modal-title" align="center">Family Details Report</h4>
					</div>
					<button type="button" class="close" data-dismiss="modal" onclick="reload()">&times;</button>
				</div>
    
				<!-- Modal body -->
				<div class="modal-body">
				<div class="search-table-outter wrapper">
					<table id="listfamily" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
						    <th>ParentId</th>
							<th>Gender</th>
							<th>Name</th>
							<th>Relation</th>
							<th>DateOfBirth</th>                                                        
                            <th>AdhaarNumber</th>
                            <th>Qualification</th>
                            <th>Occupation</th>
                            <th>MobileNumber</th>
                         </tr>
						</thead>
					</table>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="reload()">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>

<!--******************************* Experience Details Model Box *********************************** -->

<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="experienceListModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
				<div class="container">
					<h4 class="modal-title" align="center">Experience Details Report</h4>
					</div>
					<button type="button" class="close" data-dismiss="modal" onclick="reload()">&times;</button>
				</div>
    
				<!-- Modal body -->
				<div class="modal-body">
				<div class="search-table-outter wrapper">
					<table id="listexperience" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
						    <th>ParentId</th>
							<th>Name</th>
							<th>Address</th>
							<th>WorkPeriod</th>                                                        
                            <th>Designation</th>
                            <th>Ctc</th>
                            <th>Remarks</th>
                            <th>ExperienceDetails</th>
                         </tr>
						</thead>
					</table>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="reload()">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>

<!-- *************************** Education Details Model Box ******************************* -->

<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="educationListModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
				<div class="container">
					<h4 class="modal-title" align="center">Education Details Report</h4>
					</div>
					<button type="button" class="close" data-dismiss="modal" onclick="reload()">&times;</button>
				</div>
    
				<!-- Modal body -->
				<div class="modal-body">
				<div class="search-table-outter wrapper">
					<table id="listeducation" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
						    <th>ParentId</th>
							<th>Certificates</th>
							<th>InstitutionName</th>
							<th>Address</th>                                                        
                            <th>YearOfPassing</th>
                            <th>MarksPercentage</th>
                            <th>Remarks</th>  
                         </tr>
						</thead>
					</table>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="reload()">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>

<!--****************************** Employee Shifts Schdule Model Box *********************** -->
<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="employeeshiftsListModal">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
				<div class="container">
					<h4 class="modal-title" align="center">Employee Shifts Report </h4>
					</div>
					<button type="button" class="close" data-dismiss="modal" onclick="reload()">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
				<div class="search-table-outter wrapper">
					<table id="listemployeeshifts" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
							<th>Idno</th>
							<th>Monday</th>
							<th>Tuesday</th>
							<th>Wednesday</th>
							<th>Thursday</th>
							<th>Friday</th>
							<th>Saturday</th>
							<th>Sunday</th>
							<th>EffectFrom</th>
							<th>EffectTo</th>
							<th>OTEligibility</th>
							<th>Status</th>
						</tr>
						</thead>
					</table>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="reload()">Close</button>
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
					<button type="button" class="close" data-dismiss="modal" onclick="reload()">&times;</button>
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
						data-dismiss="modal" onclick="reload()">Close</button>
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
					<button type="button" class="close" data-dismiss="modal" onclick="reload()">&times;</button>
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
						data-dismiss="modal" onclick="reload()">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>

<!-- Leave Register -->
<div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="LeaveRegisterModel">
		<div>
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title" align="center">LeaveRegister (<input
			type="text" id="fromdate">-----<input type="text" id=todate>)</h4>
					<button type="button" class="close" data-dismiss="modal" onclick="reload()">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<table id="LeaveRegisterList" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
							<!-- <th>SLNO</th> -->
							<th>IDNO</th>
							<th>Name</th>
							<th>Designation</th>
							<th>Department</th>	
						        <th>FromDate</th>
							<th>ToDate</th> 
							<th>CL</th>
							<th>EL</th>
							<th>SL</th>	
							<th>CO</th>	
						</tr>
						
						</thead>
					</table>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="reload()">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>
      	  
      	  
      	  <!-- Daily Punches List -->
      	  
      	  <div class="container">
	<!-- The Modal -->
	<div class="modal fade" id="DailypuncheslistModel">
		<div>
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title" align="center">Daily Attendance Report</h4>
					<button type="button" class="close" data-dismiss="modal" onclick="reload()">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<table id="Dailypuncheslist" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
							<th>SLNO</th>
							<th>E.CODE</th>
							<th>NAME</th>
							<th>DESIGNATION</th>	
						    <th>DEPT</th>
							<th>IN-1</th> 
							<th>OUT-1</th>
							<th>IN-2</th>
							<th>OUT-2</th>	
								
						</tr>
						
						</thead>
					</table>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="reload()">Close</button>
				</div>

			</div>
		</div>
	</div>

</div>


<!-- Muster Role Register -->
<div class="modal" id="MusterRoleReportModel" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" align="center">Muster-Roll</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body p-4" id="result">
                    
                    <div class="search-table-outter wrapper">
					<table id="MusterRoleReportList" class="display" style="width: 100%"
						border="1">
						<thead>
						<tr>
                                                        <th>Slno</th>
							<th>Idno</th>
							<th>Name</th>
							<th>1</th>	                                                        
						        <th>2</th>
							<th>3</th> 
							<th>4</th>
							<th>5</th>
							<th>6</th>	
                                                        <th>7</th>
                                                        <th>8</th>
                                                        <th>9</th>
                                                        <th>10</th>
							<th>11</th>	                                                        
						        <th>12</th>
							<th>13</th> 
							<th>14</th>
							<th>15</th>
							<th>16</th>	
                                                        <th>17</th>
                                                        <th>18</th>
                                                        <th>19</th>
                                                        <th>20</th>
							<th>21</th>	                                                        
						        <th>22</th>
							<th>23</th> 
							<th>24</th>
							<th>25</th>
							<th>26</th>	
                                                        <th>27</th>
                                                        <th>28</th>
                                                        <th>29</th>
                                                        <th>30</th>
                                                        <th>31</th>
                                                        <th>Tot<br>Pre</th>
                                                        <th>Remarks</th>                                                        
						</tr>
						
						</thead>
					</table>
				</div>
            </div>
            <div class="modal-footer">
              <div class="row">
					<div class="form-group has-warning  col-md-2">
		            <label class="control-label" for="inputWarning1">lopcount</label>
		               <input type="text" id="lopcount" >		
	                </div>
					<div class="form-group has-warning  col-md-2">
		            <label class="control-label" for="inputWarning1">presentcount</label>
		               <input type="text" id="presentcount" >		
	                </div>
	                <div class="form-group has-warning  col-md-2">
		            <label class="control-label" for="inputWarning1">leavescount</label>
		               <input type="text" id="leavescount" >		
	                </div>
	                <div class="form-group has-warning  col-md-2">
		            <label class="control-label" for="inputWarning1">whcount</label>
		               <input type="text" id="whcount" >		
	                </div>
	                <div class="form-group has-warning  col-md-2">
		            <label class="control-label" for="inputWarning1">phcount</label>
		               <input type="text" id="phcount" >		
	                </div>
	                </div>
	                <div class="form-group has-warning  ">
		          	 <p align="left"><b>Signature1</b></p>
                       <p align="center"><b>Signature1</b></p>
                        <p align="right"><b>Signature1</b></p> 
	                </div>
	               
	             <div class="form-group has-warning">  
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
             </div>
        </div>
    </div>
</div>
   <%@include file="footer.jsp"%>   
 <script type="text/javascript" src="resources/report/dataTables.buttons.min.js"></script>  
 <script type="text/javascript" src="resources/report/buttons.print.min.js"></script>  
 <script type="text/javascript" src="resources/report/buttons.html5.min.js"></script>   
<script type="text/javascript" src="resources/report/pdfmake.min.js"></script>
<script type="text/javascript" src="resources/report/jszip.min.js"></script>
<script type="text/javascript" src="resources/report/vfs_fonts.js"></script> 
	<script src="resources/dist/js/sidebarmenu.js"></script>
	<script>
jQuery('#fromdate').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#todate').datepicker({
    autoclose: true,
    todayHighlight: true
});
</script>

<script>
function openingForm11pdffile() {
	$.ajax({
        type: "get",
        contentType : "application/json",
        url: "openingForm11pdffile", //this is my servlet
        success: function(data){ 
        
        }
  });
}
</script>