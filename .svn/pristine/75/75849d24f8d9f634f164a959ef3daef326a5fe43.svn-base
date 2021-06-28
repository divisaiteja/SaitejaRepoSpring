<%@include file="header.jsp"%>
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
	border:;
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
	padding:;
	font-size: 15px;
	color: #444;
	background: #66C2E0;
}

td {
	padding:;
	height: 35px;
}

.search-table-outter {
	overflow-x: scroll;
}

th, td {
	min-width:;
}
</style>
<script>
$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallproject", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('salaryproject');
			var standarddeductionproject=document.getElementById('standardproject');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["tranid"] + '">'
						+ abc[i]["projectname"] + '</option>';
						
				standarddeductionproject.innerHTML = standarddeductionproject.innerHTML + '<option value="'
						+ abc[i]["tranid"] + '">'
						+ abc[i]["projectname"] + '</option>';
			
			}

		}
	});
});


$(document).ready(function(){
	   // $("#warnings").hide();
	    $("#success").hide();
	    $("#successinedit").hide();
	   
	});

</script>
<script>
	$(document).ready(function() {
			var today = new Date();
			var month = today.getMonth() + 1;//
			var year = today.getFullYear()
			if (month > 12) {
				month = 1;
				}
			//document.getElementsById("cYear").value = month;
			$("#cMonth").val(month);
			$("#cYear").val(year);
			var test_1 = document.getElementsByName('test');

			if (test_1[0].checked) {
		 // document.getElementById('testing').style.visibility = "hidden";
			document.getElementById('standarddeduction').style.display = "none";
			document.getElementById('salarydeduction').style.display = "block";
			// var tmonth= document.getElementsById("cMonth").value;
			// var tyear= document.getElementsById("cYear").value;
			//   var SA = {};
				var division = "1";
				var project  ="1";
				//var tmonth="1";
				// var tyear="2019";
				commonFunctionToGetSalaryInfo(division, month, year,project)	
						}
					});

function onChangeToGetSalaryInfo() {
		var tmonth = document.getElementById('tmonth').value;
		var tyear = document.getElementById('tyear').value;
		var division = document.getElementById('division').value;
		var project = document.getElementById('salaryproject').value;

		commonFunctionToGetSalaryInfo(division, tmonth, tyear,project)
}

function commonFunctionToGetSalaryInfo(division, tmonth, tyear,project) {
		$.ajax({
					url : "/HRMS/getSalaryDeductionInformation?division="
							+ division + "&&tmonth=" + tmonth + "&&tyear="
							+ tyear+ "&&project="+ project,

					success : function(data, textStatus, jqXHR) {
						var table_data = data.dataBean;
						var table = $('#salaryDeductions').DataTable(
										{
											"destroy" : true,
											data : table_data,
											//dataSrc:data,
											//"dataSrc" : "data",
											columns : [
													{
														data : "tranid"
													},
													{
														data : "idno"
													},
													{
														data : "empName"
													},
													{
														data : "desgn"
													},
													{
														data : "department"
													},
													{
														data : "mobilecharges"
													},
													{
														data : "salaryadvance"
													},
													{
														data : "otherdeduction1"
			
													},
													{
														data : "otherdeduction2"
													},
													{
														data : null,
														className : "center",
														defaultContent : '<input type="image" src="resources/assets/images/edit-icon.png" height="15" width="15"   id="salaryId"   >  '
													} ],
										//  searching : false
										});
					}
				});
	}

function getSalary() {
		var test_1 = document.getElementsByName('test');
		if (test_1[0].checked) {
			// document.getElementById('testing').style.visibility = "hidden";
			document.getElementById('standarddeduction').style.display = "none";
			document.getElementById('salarydeduction').style.display = "block";
			var today = new Date();
			var month = today.getMonth() + 1;//
			var year = today.getFullYear()
			if (month > 12) {
				month = 1;
			}
			var division = 1;
			commonFunctionToGetSalaryInfo(division, month, year)
		} else {
			//document.getElementById('testing').style.visibility = "visible";
			document.getElementById('standarddeduction').style.display = "block";
			document.getElementById('salarydeduction').style.display = "none";
			onChangeStandardDeduction();

		}
		
}

$(document).ready(function() {
	$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getallDivision",

				success : function(data) {
					var abc = data;
					var ele = document.getElementById('division');
					var divisionForStandard = document.getElementById('divisionForStandard');
					for (var i = 0; i < abc.length; i++) {
					// POPULATE SELECT ELEMENT WITH JSON.
					ele.innerHTML = ele.innerHTML + '<option value="' + abc[i]["divisionid"] + '">'
					     + abc[i]["name"]
					     + '</option>';

					divisionForStandard.innerHTML = divisionForStandard.innerHTML + '<option value="' + abc[i]["divisionid"] + '">'
						 + abc[i]["name"]
						 + '</option>';

										}

									}
								});
					});

$(document).ready(function() {
		$.ajax({
					type : "GET",
					contentType : "application/json",
					url : "getCandPMonths",

					success : function(data) {
						var abc = data;
						var ele = document.getElementById('tmonth');
						var divisionForStandard = document.getElementById('divisionForStandard');
						for (var i = 0; i < abc.length; i++) {
						// POPULATE SELECT ELEMENT WITH JSON.
					ele.innerHTML = ele.innerHTML + '<option value="' + abc[i]["monthid"] + '">'
										+ abc[i]["monthName"]
										+ '</option>';

										}

									}
								});
					});

$(document).ready(function() {
     $.ajax({
    	 type : "GET",
		 contentType : "application/json",
		 url : "getallStandardDeductions", //this is my servlet

		success : function(data) {
			var abc = data;
			var fieldname = document.getElementById('fieldName');
			var saveDeduction= document.getElementById('savefieldName'); 
			for (var i = 0; i < abc.length; i++) {
					// POPULATE SELECT ELEMENT WITH JSON.
				fieldname.innerHTML = fieldname.innerHTML + '<option value="' + abc[i]["tranid"] + '">'
											+ abc[i]["fieldName"]
											+ '</option>';
	            saveDeduction.innerHTML = saveDeduction.innerHTML + '<option value="' + abc[i]["tranid"] + '">'
											+ abc[i]["fieldName"]
											+ '</option>';
						}

				}
     });
});
function saveStandardDeductions(){
	//alert($("#savewef").val());
	var saveStandardDeductions = {};
	saveStandardDeductions["standardfieldtype"] = $("#savefieldName").val();
	//alert($("#savefieldName").val());
	saveStandardDeductions["idno"] = $("#saveidno").val();
	//alert($("#saveidno").val());
	saveStandardDeductions["remarks"] = $("#saveremarks").val();
	//alert($("#saveremarks").val());
	saveStandardDeductions["noofemi"] = $("#savenoofemi	").val();
	//alert($("#savenoofemi").val());
	saveStandardDeductions["emiamount"] = $("#saveemiamount").val();
	//alert($("#saveemiamount").val());
	saveStandardDeductions["wef"] = $("#savewef").val();
	$.ajax({
		type : "post",
		contentType : "application/json",
		url : "saveNewStandardDeductions", //this is my servlet
		data : JSON.stringify(saveStandardDeductions),
		success : function(data) {
			
			$("#successmsg").html(data["successMessage"]);
			$("#success").show();	
	        setInterval(function(){
	        	window.location.reload(); // this will run after every 5 seconds
	        }, 2000);

		}
	});
}
	
function onChangeStandardDeduction() {
 
	var fieldId = document.getElementById("fieldName").value;
	 
		var stdDivisionId = document.getElementById("divisionForStandard").value;
		var standardproject = document.getElementById("standardproject").value;
		commonFunctionForStandardDeduction(fieldId, stdDivisionId,standardproject)
}

function commonFunctionForStandardDeduction(fieldId, stdDivisionId,standardproject) {

		$.ajax({
					//url: '/DASHBOARD/getDropdowns',
					url : "/HRMS/getStandardDeductionInformation?standardDeductionFieldId="
							+ fieldId + "&&divisionid=" + stdDivisionId + "&&standardproject=" + standardproject,

					success : function(data, textStatus, jqXHR) {
						var table_data = data.dataBean;
						// //alert(table_data[punchcod]);
						var table = $('#standardDeductions')
								.DataTable(
										{
											"destroy" : true,
											data : table_data,
											//dataSrc:data,
											//"dataSrc" : "data",
											columns : [
													{
														data : "tranid"
													},
													{
														data : "idno"
													},
													{
														data : "empName"
													},
													{
														data : "desgn"
													},
													{
														data : "department"
													},
													{
														data : "standardDeductionFieldsMaster.fieldName"
													},
													{
														data : "emiamount"
													},
													{
														data : "infodate"
													},
													{
														data : "noofemi"
													},
													{
														data : "wef"
													},
													{
														data : "remarks"
													},

													{
														data : null,
														className : "center",
														defaultContent : '<input type="image" src="resources/assets/images/edit-icon.png" height="15" width="15"   id="deductions"   >  '
													} ],
										//  searching : false
										});
					}
				});
	}
</script>
<script>
	$("#salaryDeductions").on('click','#salaryId',function() {
			var currentRow = $(this).closest("tr");
			var rowData = $("#salaryDeductions").DataTable().row(currentRow).data();
			var tranid = rowData.tranid;                        
				////alert(idno);
				retrieve:true,
					$.ajax({
								contentType : "application/json",
								url : "/HRMS/getSalaryDeductionInformationByIdno?tranid="+ tranid,
											//dataSrc : "dataBean",
								type : "GET",
								success : function(data) {
								  for (var i = 0; i < data.length; i++) {
										////alert(data.empName);
										$("#empname").val(data[i].empName);
										$("#desgn ").val(data[i].desgn);
										$("#department ").val(data[i].department);
										$("#mobilecharges").val(data[i].mobilecharges);
										$("#salaryadvance ").val(data[i].salaryadvance);
										$("#otherdeduction1 ").val(data[i].otherdeduction1);
										$("#otherdeduction2 ").val(data[i].otherdeduction2);
										$("#idno").val(data[i].idno);
										$("#tranid").val(data[i].tranid);
												}
								  //$("#empname ").val(data["empName"]);

												selectedRecord = data;

											},

										});

						$('#salaryDeductionsModalEdit').modal('show');

					});
</script>
<script>
	function editSalaryDeductions() {
		////alert(editSalaryDeductions);
		var editSalaryDeductions = {};
		editSalaryDeductions["empname"] = $("#empname").val();
		editSalaryDeductions["desgn"] = $("#desgn").val();
		editSalaryDeductions["department"] = $("#department").val();
		editSalaryDeductions["mobilecharges"] = $("#mobilecharges").val();
		editSalaryDeductions["salaryadvance"] = $("#salaryadvance").val();
		editSalaryDeductions["otherdeduction1"] = $("#otherdeduction1").val();
		editSalaryDeductions["otherdeduction2"] = $("#otherdeduction2").val();
		editSalaryDeductions["tranid"] = $("#tranid").val();

		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "editSalaryDeductions", //this is my servlet
			data : JSON.stringify(editSalaryDeductions),
			success : function(data) {

				$("#successmsg").html(data["successMessage"]);
				$("#success").show();	
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);

			}
		});

	}
</script>
<script>
	$("#standardDeductions").on('click','#deductions',function() {
			var currentRow = $(this).closest("tr");
			var rowData = $("#standardDeductions").DataTable().row(
					currentRow).data();
						////alert(rowData);
					var idno = rowData.idno;
						////alert("idno   " + idno);
					var tranid = rowData.tranid;
						////alert(" tranid   " + tranid);
						retrieve:true,
						    $.ajax({
										contentType : "application/json",
										"url" : "/HRMS/getStandardDeductionInformationByIdno?tranid="+ tranid,
										"dataSrc" : "dataBean",
										"type" : "GET",

									     success : function(data) {
											for (var i = 0; i < data.length; i++) {
												$("#empname").val(data[i].empName);
												$("#desgn ").val(data[i].desgn);
												$("#department ").val(data[i].department);
												$("#description").val(data[i].standardDeductionFieldsMaster.fieldName);
												$("#infodate").val(data[i].infodate);
												$("#emiamount ").val(data[i].emiamount);
												$("#noofemi ").val(data[i].noofemi);
												$("#wef ").val(data[i].wef);
												$("#remarks ").val(data[i].remarks);
											    $("#idno").val(data[i].idno);
												$("#Standardtranid").val(data[i].tranid);
												}
												selectedRecord = data;
											},
										});
						$('#standardDeductionsModalEdit').modal('show');
					});
	//}
</script>
<script>
$("#editStandardDeductions").on('click',function() {
		var editStandardDeductions = {};
		var infodate = document.getElementById("infodate").value;
		////alert("infodate " + infodate);
		var emiamount = document.getElementById("emiamount").value;
		////alert("emiamount " + emiamount);
		var wef = document.getElementById("wef").value;
		////alert("wef   " + wef);
		/* var desciption=document.getElementById("desciption").value;
		   //alert("desciption   "+desciption);  */
		var remarks = document.getElementById("remarks").value;
		////alert("remarks   " + remarks);
		var Standardtranid = document.getElementById("Standardtranid").value;
		////alert("Standardtranid  " + Standardtranid);
				editStandardDeductions["empname"] = $("#empname").val();
				editStandardDeductions["desgn"] = $("#desgn").val();
				editStandardDeductions["department"] = $("#department").val();
				editStandardDeductions["standardDeductionFieldsMaster.fieldName"] = $("#desciption").val();
				editStandardDeductions["infodate"] = $("#infodate").val();
				editStandardDeductions["emiamount"] = $("#emiamount").val();
				editStandardDeductions["noofemi"] = $("#noofemi").val();
				editStandardDeductions["wef"] = $("#wef").val();
				editStandardDeductions["remarks"] = $("#remarks").val();
				editStandardDeductions["tranid"] = $("#Standardtranid").val();
						$.ajax({
							type : "post",
							contentType : "application/json",
							url : "editStandardDeductions", //this is my servlet
							data : JSON.stringify(editStandardDeductions),
							success : function(data) {

								$("#successmsg").html(data["successMessage"]);
								$("#success").show();	
						        setInterval(function(){
						        	window.location.reload(); // this will run after every 5 seconds
						        }, 2000);
							}
						});

					});
	
function generatePaySheets(){
		//var paysheet={};
		var tmonth=document.getElementById("tmonth").value;
		var tyear=document.getElementById("tyear").value;
		var division=document.getElementById("division").value;
		
		//generatePaySheetsPage(division,tmonth,tyear)
		//window.location.href="/generatepaysheetpage/"
	    window.location.href='#/generatepaysheetpage/'+division+'/'+tmonth+'/'+tyear;
		}
	
</script>
<input type="text" id="cMonth" hidden="hidden">
<input type="text" id="cYear" hidden="hidden">
<b>SALARYDEDUCTION</b>
&nbsp;&nbsp;
<input type="radio" name="test" title="yes" onclick="getSalary()"
	value="Y" checked="checked">
&nbsp;&nbsp;
<b>STANDARDDEDUCTON</b>
&nbsp;&nbsp;
<input type="radio" name="test" title="NO" onclick="getSalary()"value="N">
<div align="right">
<button type="button" onclick="generatePaySheets()"  class="btn btn-primary" value="Generate PaySheet">Generate PaySheet</button>
</div>	
	
<br>
<hr style="background-color: red">
<br>
<div id="salarydeduction" style="display: none;" class="answer_list">
	<h3 style="color: blue;">SALARY DEDUCTIONS</h3>
	<div class="row">
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Division</label> <select
				class="form-control" id="division"
				onchange="onChangeToGetSalaryInfo()">

			</select>
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Project</label> <select
				class="form-control" id="salaryproject"
				onchange="onChangeToGetSalaryInfo()">

			</select>
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Month</label> <select
				class="form-control" id="tmonth"
				onchange="onChangeToGetSalaryInfo()">

			</select>
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Year</label> <select
				class="form-control" id="tyear" onchange="onChangeToGetSalaryInfo()">
				<option value="2019">2019</option>
				<option value="2018">2018</option>


			</select>
		</div>
</div>
<div class="search-table-outter wrapper">
		<table id="salaryDeductions" class="display" style="width: 100%"
			border="1">
			<thead>
				<tr>
					<th>TranId</th>
					<th>IdNo</th>
					<th>Name</th>
					<th>Designation</th>
					<th>Department</th>
					<th>MobileCharges</th>
					<th>SalaryAdv</th>
					<th>OtherDedu-1</th>
					<th>OtherDedu-2</th>
					<th>Action</th>

				</tr>
			</thead>

		</table>

	</div>
</div>

<div id="standarddeduction" style="display: none;" class="answer_list">
<div>
<h5 align="center">
		To Add New Standard Deduction <a data-toggle="modal"
			data-target="#newstandarddeduction" href="#">ClickHere</a>
	</h5>
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>
<br>
<br>
	<h3 style="color: blue;">STANDARD DEDUCTIONS</h3>
	<div class="row">
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">StandardDeduction</label>
			<select class="form-control" id="fieldName"
				onchange="onChangeStandardDeduction()">
				<option value="0">select</option>
			</select>
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Division</label> <select
				class="form-control" id="divisionForStandard"
				onchange="onChangeStandardDeduction()">
				<option value="0">select</option>
			</select>
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Project</label> <select
				class="form-control" id="standardproject"
				onchange="onChangeStandardDeduction()">
				<option value="0">select</option>
			</select>
		</div>
	</div>
<div id="standardOnChange">
		<div class="search-table-outter wrapper">
			<table id="standardDeductions" class="display" style="width: 100%"
				border="1">
				<thead>
					<tr>
						<th>TranId</th>
						<th>IdNo</th>
						<th>Name</th>
						<th>Designation</th>
						<th>Department</th>
						<th>Description</th>
						<th>EmiAmount</th>
						<th>TransactionDate</th>
						<th>NoOfEmis</th>
						<th>WithEffectFrom</th>
						<th>Remarks</th>
						<th>Action</th>

					</tr>
				</thead>

			</table>
		</div>
	</div>
</div>

<div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="salaryDeductionsModalEdit"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			    <div align="center">
			      <div class="alert alert-success " id="successinedit" style="text-align:center">
  		             <strong id="successmsginedit" ></strong> 
		          </div>
			    </div>
				<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5">Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body mx-3">
					<div class="md-form mb-3">
						<label data-error="wrong" data-success="right" for="tranid">TranId</label>
						<input type="text" id="tranid" class="form-control validate"
							readonly="readonly">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="empname">EmployeeName</label>
						<input type="text" id="empname" class="form-control validate"
							readonly="readonly">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="desgn">Designation</label>
						<input type="text" id="desgn" class="form-control validate"
							readonly="readonly">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="department">Department></label>
						<input type="text" id="department" class="form-control validate"
							readonly="readonly">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="mobilecharges">MobileCharges</label>
						<input type="text" id="mobilecharges"
							class="form-control validate">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="salaryadvance">SalaryAdvance</label>
						<input type="text" id="salaryadvance"
							class="form-control validate">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right"
							for="otherdeduction1">OtherDeduction1</label> <input type="text"
							id="otherdeduction1" class="form-control validate">
					</div>
					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right"
							for="otherdeduction2">OtherDeduction2</label> <input type="text"
							id="otherdeduction2" class="form-control validate">
					</div>

				</div>
				<div
					class="modal-footer d-flex justify-content-center editInsideWrapper">
					<button class="btn btn-outline-secondary btn-block editInside"
						data-dismiss="modal" onclick="editSalaryDeductions()">
						Edit form <i class="fas fa-paper-plane-o ml-1"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
</div>
<!--  SalaryDeductionsModalEdit -->


<div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="standardDeductionsModalEdit"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div  class="modal-dialog modal-lg" role="document" >
			<div class="modal-content">
			  <div align="center">
			    <div class="alert alert-success " id="successinedit" style="text-align:center">
  		           <strong id="successmsginedit" ></strong> 
		        </div>
			  </div>
				<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5">Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body mx-4">
					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right"
							for="Standardtranid">TranId</label> <input type="text"
							id="Standardtranid" class="form-control validate"
							readonly="readonly">
					</div>
					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="description">Description</label>
						<input type="text" id="description" class="form-control validate"
							readonly="readonly">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="infodate">TransactionDate</label>
						<input type="text" id="infodate" class="form-control validate">
					</div>


					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="emiamount">EMIAmount></label>
						<input type="text" id="emiamount" class="form-control validate">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="noofemi">NumberOFEmis</label>
						<input type="text" id="noofemi" class="form-control validate">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="wef">WithEffectFrom</label>
						<input type="text" id="wef" class="form-control validate">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="remarks">Remarks</label>
						<input type="text" id="remarks" class="form-control validate">
					</div>

				</div>
				<div
					class="modal-footer d-flex justify-content-center editInsideWrapper">
					<button class="btn btn-outline-secondary btn-block editInside"
						data-dismiss="modal" id="editStandardDeductions">
						Edit form <i class="fas fa-paper-plane-o ml-1"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
</div>






 <div class="modal fade" id="newstandarddeduction" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
		    <div class="modal-header">
			<div class="container">
		          <h4 align="center" style="color: #0B1907" class="modal-title" >New Standard Deduction</h4>
		        </div>
			<button type="button" class="close" data-dismiss="modal">&times;</button>
		    </div>
		   <div class="alert alert-success " id="success" style="text-align:center">
  	              <strong id="successmsg" ></strong> 
	           </div>
       <form id="save_form">
			<div class="modal-body">
				<div class="box-content row">
			    <div class="form-group has-warning col-md-3">
			        <label class="control-label" for="inputWarning1">StandardDeduction</label>
			         <select class="form-control" id="savefieldName">
				        <option value="0">select</option>
			         </select>
		        </div>
				<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">Idno</label>
					<input type="text" id="saveidno" name="saveidno" class="form-control">
				</div>
				</div>
				<br>
			    <hr style="background-color: blue">
			    <br>
				<div class="box-content row">
				
				<div class="form-group has-warning col-md-3">
					  <label class="control-label" for="inputWarning1">EmiAmount</label> <input
						type="text" id="saveemiamount" name="saveemiamount" class="form-control">
				</div>
				<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">No of Emi's</label>
					<input type="text" id="savenoofemi" name="savenoofemi"
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">With Effect From</label>
					<input type="text" id="savewef" name="savewef"
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">Remarks</label>
					<input type="text" id="saveremarks" name="saveremarks"
						class="form-control">
				</div>

			</div>
			</div>
			
			<div class="modal-footer" >
			<div class="container" align="center">
				<button type="button" class="btn btn-primary"  id="grade_btn" onclick="saveStandardDeductions()">Submit</button>
			</div>
			</div>
			</form>
		</div>
		
		</div>
	</div>


      	    <script src="resources/dist/js/sidebarmenu.js"></script>
<%@include file="footer.jsp"%>
<script>
jQuery('#infodate').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#wef').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#savewef').datepicker({
    autoclose: true,
    todayHighlight: true
});
</script>