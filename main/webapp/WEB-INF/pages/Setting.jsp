<%@ include file="header.jsp"%>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >

<script>
$(document).ready(function() {
	
	document.getElementById("tranId").disabled = true;
	document.getElementById("divisionId").disabled = true;
	document.getElementById("weekOfId").disabled = true;
	document.getElementById("manualPostingAllowed").disabled = true;
	document.getElementById("casualLeaveForExecutive").disabled = true;
	document.getElementById("casualLeaveForStaff").disabled = true;
	document.getElementById("casualLeaveForWorkmen").disabled = true;
	document.getElementById("sickLeaveForExecutive").disabled = true;
	document.getElementById("sickLeaveForStaff").disabled = true;
	document.getElementById("sickLeaveForWorkmen").disabled = true;
	document.getElementById("earnedLeaveForStaff").disabled = true;
	document.getElementById("earnedLeaveForWorkmen").disabled = true;
	document.getElementById("earnedLeaveForExecutive").disabled = true;
	document.getElementById("maximumEarnedLeavesForExecutive").disabled = true;
	document.getElementById("maximumEarnedLeavesForStaff").disabled = true;
	document.getElementById("maximumEarnedLeavesForWorkmen").disabled = true;
    document.getElementById("maximumSickLeavesForExecutive").disabled = true;
	document.getElementById("maximumSickLeavesForStaff").disabled = true;
	document.getElementById("maximumSickLeavesForWorkmen").disabled = true;
	document.getElementById("basicPercentage").disabled = true;
	document.getElementById("daPercentage").disabled = true;
	document.getElementById("hraPercentage").disabled = true;
	document.getElementById("conveyancePercentage").disabled = true;
	document.getElementById("ltaPercentage").disabled = true;
	document.getElementById("medicalPercentage").disabled = true;
	document.getElementById("otherAllowancePercentage").disabled = true;
	document.getElementById("bonusOnePercentage").disabled = true;
	document.getElementById("bonusTwoPercentage").disabled = true;
	document.getElementById("pfPercentage").disabled = true;
	document.getElementById("esiPercentage").disabled = true;
	document.getElementById("unionFund").disabled = true;
	document.getElementById("clubFund").disabled = true;
	document.getElementById("paySheetClosingDay").disabled = true;
	document.getElementById("paySheetLockDay").disabled = true;
	document.getElementById("paySheetUnLockDay").disabled = true;
	document.getElementById("setting").disabled = true;
	  
	  });

function disableTextBox() {
	
	document.getElementById("tranId").disabled = false;
	document.getElementById("divisionId").disabled = false;
	document.getElementById("weekOfId").disabled = false;
	document.getElementById("manualPostingAllowed").disabled = false;
	document.getElementById("casualLeaveForExecutive").disabled = false;
	document.getElementById("casualLeaveForStaff").disabled = false;
	document.getElementById("casualLeaveForWorkmen").disabled = false;
	document.getElementById("sickLeaveForExecutive").disabled = false;
	document.getElementById("sickLeaveForStaff").disabled = false;
	document.getElementById("sickLeaveForWorkmen").disabled = false;
	document.getElementById("earnedLeaveForStaff").disabled = false;
	document.getElementById("earnedLeaveForWorkmen").disabled = false;
	document.getElementById("earnedLeaveForExecutive").disabled = false;
	document.getElementById("maximumEarnedLeavesForExecutive").disabled = false;
	document.getElementById("maximumEarnedLeavesForStaff").disabled = false;
	document.getElementById("maximumEarnedLeavesForWorkmen").disabled = false;
    document.getElementById("maximumSickLeavesForExecutive").disabled = false;
	document.getElementById("maximumSickLeavesForStaff").disabled = false;
	document.getElementById("maximumSickLeavesForWorkmen").disabled = false;
	document.getElementById("basicPercentage").disabled = false;
	document.getElementById("daPercentage").disabled = false;
	document.getElementById("hraPercentage").disabled = false;
	document.getElementById("conveyancePercentage").disabled = false;
	document.getElementById("ltaPercentage").disabled = false;
	document.getElementById("medicalPercentage").disabled = false;
	document.getElementById("otherAllowancePercentage").disabled = false;
	document.getElementById("bonusOnePercentage").disabled = false;
	document.getElementById("bonusTwoPercentage").disabled = false;
	document.getElementById("pfPercentage").disabled = false;
	document.getElementById("esiPercentage").disabled = false;
	document.getElementById("unionFund").disabled = false;
	document.getElementById("clubFund").disabled = false;
	document.getElementById("paySheetClosingDay").disabled = false;
	document.getElementById("paySheetLockDay").disabled = false;
	document.getElementById("paySheetUnLockDay").disabled = false;
	document.getElementById("setting").disabled = false;

}
</script>
<script>
$(document).ready(function() {
	/* Not Selected */
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getallDivision", //this is my servlet
     
       success: function(data){ 
       	var abc=data;
       	var ele = document.getElementById('division');
           for (var i = 0; i < abc.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["divisionid"] + '">' + abc[i]["name"] + '</option>';
           }
       	
       }
});
});
</script>
<script>
$(document).ready(function() {
	
	var division=document.getElementById("division").value;
	var division=1;
	//getHRDetails(division);
	// alert(data[0]["manualPostingAllowed"]);
	commonFunctionForOnChangeDivisionSettings(division);
	});
	
	function commonFunctionForOnChangeDivisionSettings(division){
		//alert("commonfunctiontogetSettingFile"+division);
		$.ajax({
	        type: "GET",
	        contentType : "application/json",
	        url: "/DASHBOARD/getAllSetting?division="+division, //this is my servlet
	          success: function(data){ 
	        	  var json=data;
	        	  $("#tranId").val(json.dataBean[0].tranId);
	        	  $("#weekOfId").val(json.dataBean[0].weekOfId);
	        	  $("#casualLeaveForExecutive").val(json.dataBean[0].casualLeaveForExecutive);
	        	  $("#casualLeaveForStaff").val(json.dataBean[0].casualLeaveForStaff);
	        	  $("#casualLeaveForWorkmen").val(json.dataBean[0].casualLeaveForWorkmen);
	        	  $("#sickLeaveForExecutive").val(json.dataBean[0].sickLeaveForExecutive);
	        	  $("#sickLeaveForStaff").val(json.dataBean[0].sickLeaveForStaff);
	        	  $("#sickLeaveForWorkmen").val(json.dataBean[0].sickLeaveForWorkmen);
	        	  $("#earnedLeaveForWorkmen").val(json.dataBean[0].earnedLeaveForWorkmen);
	        	  $("#earnedLeaveForExecutive").val(json.dataBean[0].earnedLeaveForExecutive);
	        	  $("#earnedLeaveForStaff").val(json.dataBean[0].earnedLeaveForStaff);
	        	  $("#earnedLeaveForWorkmen").val(json.dataBean[0].earnedLeaveForWorkmen);
	        	  $("#maximumEarnedLeavesForExecutive").val(json.dataBean[0].maximumEarnedLeavesForExecutive);
	        	  $("#maximumEarnedLeavesForStaff").val(json.dataBean[0].maximumEarnedLeavesForStaff);
	        	  $("#maximumEarnedLeavesForWorkmen").val(json.dataBean[0].maximumEarnedLeavesForWorkmen);
	        	  $("#maximumSickLeavesForExecutive").val(json.dataBean[0].maximumSickLeavesForExecutive);
	        	  $("#maximumSickLeavesForStaff").val(json.dataBean[0].maximumSickLeavesForStaff);
	        	  $("#maximumSickLeavesForWorkmen").val(json.dataBean[0].maximumSickLeavesForWorkmen);       	  
	        	  $("#basicPercentage").val(json.dataBean[0].basicPercentage);        	          	  
				  $("#daPercentage").val(json.dataBean[0].daPercentage);
	           	  $("#hraPercentage").val(json.dataBean[0].hraPercentage);
	        	  $("#conveyancePercentage").val(json.dataBean[0].conveyancePercentage);
	        	  $("#ltaPercentage").val(json.dataBean[0].ltaPercentage);
	        	  $("#medicalPercentage").val(json.dataBean[0].medicalPercentage);        	  
	        	  $("#otherAllowancePercentage").val(json.dataBean[0].otherAllowancePercentage);        	  
	        	  $("#bonusOnePercentage").val(json.dataBean[0].bonusOnePercentage);
	        	  $("#bonusTwoPercentage").val(json.dataBean[0].bonusTwoPercentage);
	        	  $("#pfPercentage").val(json.dataBean[0].pfPercentage);
	        	  $("#esiPercentage").val(json.dataBean[0].esiPercentage);        	  
	        	  $("#unionFund").val(json.dataBean[0].unionFund);       	  
	        	  $("#clubFund").val(json.dataBean[0].clubFund);
	        	  $("#paySheetClosingDay").val(json.dataBean[0].paySheetClosingDay);
	        	  $("#paySheetLockDay").val(json.dataBean[0].paySheetLockDay);
	        	  $("#paySheetUnLockDay").val(json.dataBean[0].paySheetUnLockDay);
	        }
	 });
		
		
	}
	
function getHRDetails(division){ 
	var division=document.getElementById("division").value;
	alert("getHRDetails"+division);
	commonFunctionForOnChangeDivisionSettings(division);
}

</script>
<script>
$(document).ready(function() {

	$('#professionaltax').dataTable({
      "ajax" : {
			"url" : "/DASHBOARD/getAllProfessionalTax",
			"dataSrc" : "dataBean",
			"type" : "GET",
             },
       "columns" : [
		{
		    data : "tranId"
		},
		{
			data : "minimumAmount"
		},
		{
			data : "maximumAmount"
		},
		{
			data : "taxRates"
		},
		{
			data : "isActive"
		},
		{
			data : null,
			className : "center",
			defaultContent : '<input type="image" src="resources/assets/images/edit-icon.png" height="15" width="15" id="professional" >'
		} ],

          });
								
		});
	 	

</script>
<script>

	$("#professionaltax").on('click', '#professional', function(){
		 var currentRow = $(this).closest("tr");
			var rowData = $("#professionaltax").DataTable().row(currentRow).data();
		   var tranId  = rowData.tranId;
	   retrieve: true,
	   $.ajax({
		 contentType : "application/json",
		"url" : "/DASHBOARD/getProfessionalTaxInformationByTranId?tranId="+tranId,
		"dataSrc" : "dataBean",
		"type" : "GET",
       
		success: function(data){
			alert(data.isActive);
			for (var i = 0; i < data.length; i++) {
				$("#tranId").val(data[i].tranId);
				$("#minimumAmount ").val(data[i].minimumAmount);
		    	$("#maximumAmount ").val(data[i].maximumAmount);
		    	$("#taxRates").val(data[i].taxRates);
		    	$("#isActive ").val(data[i].isActive); 	
			}
			selectedRecord = data;	
	},

});

$('#professionalTaxModalEdit').modal('show');

});
</script>
<script>
function SettingEdit(){
	var SettingEdit={};
	var tranId=document.getElementById("tranId").value;
	SettingEdit["tranId"] = $("#tranId").val();
	//SettingEdit["divisionId"] = $("#divisionId").val();
	SettingEdit["weekOfId"] = $("#weekOfId").val();
	SettingEdit["manualPostingAllowed"] = $("#manualPostingAllowed").val();
	SettingEdit["casualLeaveForExecutive"] = $("#casualLeaveForExecutive").val();
	SettingEdit["casualLeaveForStaff"] = $("#casualLeaveForStaff").val();
	SettingEdit["casualLeaveForWorkmen"] = $("#casualLeaveForWorkmen").val();
	SettingEdit["sickLeaveForExecutive"] = $("#sickLeaveForExecutive").val();
	SettingEdit["sickLeaveForStaff"] = $("#sickLeaveForStaff").val();
	SettingEdit["sickLeaveForWorkmen"] = $("#sickLeaveForWorkmen").val();
	SettingEdit["earnedLeaveForExecutive"] = $("#earnedLeaveForExecutive").val();
	SettingEdit["earnedLeaveForStaff"] = $("#earnedLeaveForStaff").val();
	SettingEdit["earnedLeaveForWorkmen"] = $("#earnedLeaveForWorkmen").val();
	SettingEdit["maximumEarnedLeavesForExecutive"] = $("#maximumEarnedLeavesForExecutive").val();
	SettingEdit["maximumEarnedLeavesForStaff"] = $("#maximumEarnedLeavesForStaff").val();
	SettingEdit["maximumEarnedLeavesForWorkmen"] = $("#maximumEarnedLeavesForWorkmen").val();
	SettingEdit["maximumSickLeavesForExecutive"] = $("#maximumSickLeavesForExecutive").val();
	SettingEdit["maximumSickLeavesForStaff"] = $("#maximumSickLeavesForStaff").val();
	SettingEdit["maximumSickLeavesForWorkmen"] = $("#maximumSickLeavesForWorkmen").val();
	SettingEdit["basicPercentage"] = $("#basicPercentage").val();
	SettingEdit["daPercentage"] = $("#daPercentage").val();
	SettingEdit["hraPercentage"] = $("#hraPercentage").val();
	SettingEdit["conveyancePercentage"] = $("#conveyancePercentage").val();
	SettingEdit["ltaPercentage"] = $("#ltaPercentage").val();
	SettingEdit["medicalPercentage"] = $("#medicalPercentage").val();
	SettingEdit["otherAllowancePercentage"] = $("#otherAllowancePercentage").val();
	SettingEdit["bonusOnePercentage"] = $("#bonusOnePercentage").val();
	SettingEdit["bonusTwoPercentage"] = $("#bonusTwoPercentage").val();
	SettingEdit["pfPercentage"] = $("#pfPercentage").val();
	SettingEdit["esiPercentage"] = $("#esiPercentage").val();
	SettingEdit["unionFund"] = $("#unionFund").val();
	SettingEdit["clubFund"] = $("#clubFund").val();
	SettingEdit["paySheetClosingDay"] = $("#paySheetClosingDay").val();
	SettingEdit["paySheetLockDay"] = $("#paySheetLockDay").val();
	SettingEdit["paySheetUnLockDay"] = $("#paySheetUnLockDay").val();
	
	$.ajax({
        type: "post",
        contentType : "application/json",
        url: "settingEdit", 
        data : JSON.stringify(SettingEdit),
        success: function(data){ 
        	alert("succesfully updated");
        }
 });
}
</script>
<script>
function editProfessionalTax(){
	var editProfessionalTax = {};
	editProfessionalTax["tranId"] = $("#tranId").val();
	editProfessionalTax["minimumAmount"] = $("#minimumAmount").val();
	editProfessionalTax["maximumAmount"] = $("#maximumAmount").val();
	editProfessionalTax["taxRates"] = $("#taxRates").val();
	editProfessionalTax["isActive"] = $("#isActive").val();
	
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editProfessionalTax", //this is my servlet
        data : JSON.stringify(editProfessionalTax),
        success: function(data){ 
        	alert("succesfully updated");
        }
 });
 
}
</script>
<div>
	<div class="box-content row">
		<div class="form-group has-warning  col-md-6">
			<label class="control-label" for="inputWarning1">Division</label> <select
				id="division" class="form-control" onchange="getHRDetails()">

			</select>
		</div>
	</div>
	<hr color="00FFFF">
	<div class="col-md-12">
		<div class="box-content row">
			<div class="form-group has-warning  col-md-6">
				<h4 align="left" style="color: #fb8c00">Attendance</h4>
			</div>
			<div class="form-group has-warning  col-md-6">
				<input align="right" type="image" id="image" alt="Login"
					onclick="disableTextBox()"
					src="resources/assets/images/edit-icon.png" height="25" width="25">
			</div>
		</div>
	</div>
	<form id="setting_form">
	<div class="box-content row">
		<div class="form-group has-warning  col-md-6">
			<label class="control-label" for="inputWarning1">ManualPostingAllowed</label>
			<select id="manualPostingAllowed" class="form-control" >
				<option value="1">YES</option>
				<option value="0">NO</option>
			</select>
		</div>
		<div class="form-group has-warning  col-md-6">
			<label class="control-label" for="inputWarning1">Week-off</label> <input
				type="text" id="weekOfId" name="weekOfId" class="form-control">
		</div>
	</div>

	<div class="col-md-12">
		<h4 align="left" style="color: #fb8c00">Leaves</h4>
	</div>
	<div class="box-content row">
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">CasualLeaveForExecutive
			</label> <input type="text" class="form-control" name="casualLeaveForExecutive"  id="casualLeaveForExecutive">
		</div>
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">CasualLeaveForStaff</label>
			<input type="text" class="form-control" name="casualLeaveForStaff" id="casualLeaveForStaff">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">CasualLeaveForWorkmen</label>
			<input type="text" class="form-control" name="casualLeaveForWorkmen" id="casualLeaveForWorkmen">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">SickLeaveForExecutive</label>
			<input type="text" class="form-control" id="sickLeaveForExecutive" name="sickLeaveForExecutive">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">SickLeaveForStaff</label>
			<input type="text" class="form-control" id="sickLeaveForStaff" name="sickLeaveForStaff">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">SickLeaveForWorkmen</label>
			<input type="text" class="form-control" id="sickLeaveForWorkmen" name="sl_female">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">EarnedLeaveForExecutive</label>
			<input type="text" class="form-control" id="earnedLeaveForExecutive" name="el_exc">
		</div>
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">EarnedLeaveForStaff</label>
			<input type="text" class="form-control" id="earnedLeaveForStaff" name="el_staff">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">EarnedLeaveForWorkmen</label>
			<input type="text" class="form-control" id="earnedLeaveForWorkmen" name="el_fmale">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">MaximumEarnedLeavesForExecutive</label>
			<input type="text" class="form-control" id="maximumEarnedLeavesForExecutive" name="max_el_exe">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">MaximumEarnedLeavesForStaff</label>
			<input type="text" class="form-control" name="max_el_staff"  id="maximumEarnedLeavesForStaff">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">MaximumEarnedLeavesForWorkmen</label>
			<input type="text" class="form-control" name="max_el_fmale" id="maximumEarnedLeavesForWorkmen">
		</div>
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">MaximumSickLeavesForExecutive</label>
			<input type="text" class="form-control" name="max_sl_exe" id="maximumSickLeavesForExecutive">
		</div>
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">MaximumSickLeavesForStaff</label>
			<input type="text" class="form-control" name="max_sl_staff" id="maximumSickLeavesForStaff">
		</div>
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">MaximumSickLeavesForWorkmen</label>
			<input type="text" class="form-control" name="max_sl_fmale" id="maximumSickLeavesForWorkmen">
		</div>

	</div>


	<div class="col-md-12">
		<h4 align="left" style="color: #fb8c00">Salaries</h4>
	</div>
	<div class="box-content row">
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">BasicPercentage</label>
			<input type="text" class="form-control" id="basicPercentage" name="basic_per">
		</div>
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">DaPercentage</label>
			<input type="text" class="form-control" id="daPercentage" name="da_per">
		</div>
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">HraPercentage</label>
			<input type="text" class="form-control" id="hraPercentage" name="hra_per">
		</div>
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">ConveyancePercentage</label>
			<input type="text" class="form-control" id="conveyancePercentage" name="con_per">
		</div>
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">LtaPercentage</label>
			<input type="text" class="form-control" id="ltaPercentage" name="lta_Per">
		</div>
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">MedicalPercentage</label>
			<input type="text" class="form-control" id="medicalPercentage" name="medical_per">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">OtherAllowedPercentage</label>
			<input type="text" class="form-control" id="otherAllowancePercentage" name="other_allow_per">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">BonusOnePercentage</label>
			<input type="text" class="form-control" id="bonusOnePercentage" name="bonus1_per">
		</div>
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">BonusTwoPercentage</label>
			<input type="text" class="form-control" id="bonusTwoPercentage" name="bonus2_per">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">PfPercentage</label>
			<input type="text" class="form-control" id="pfPercentage" name="pf_per">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">ESIPercentage</label>
			<input type="text" class="form-control" id="esiPercentage" name=esi_per">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">UnionFund</label> <input
				type="text" id="unionFund" class="form-control" name="union_fund">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">ClubFund</label> <input
				type="text" id="clubFund" name="clubFund" class="form-control">
		</div>

	</div>



	<div class="col-md-6">
		<h4 align="left" style="color: #fb8c00">AttendenceClosingDay</h4>
	</div>

	<div class="box-content row">
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">PaySheetClosingDay</label>
			<input type="text" class="form-control" id="paySheetClosingDay" name="paySheetClosingDay">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">PaySheetLockDay</label>
			<input type="text" class="form-control" id="paySheetLockDay" name="paySheetLockDay">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">PaySheetUnLockDay</label>
			<input type="text" class="form-control" id="paySheetUnLockDay" name="paySheetUnLockDay">
		</div>
	</div>
	<div align="right">
		<input type="submit" value="update" id="setting" class="btn btn-success" > 
		<input type="submit" class="btn btn-success" onclick=" " value="back">
	</div>
</form>
</div>
<hr color="00FFFF">
<div class="col-md-12">
	<h4 align="left" style="color: #fb8c00">ProfessionalTaxes</h4>
</div>

<div>
	<table id="professionaltax" class="display" style="width: 100%"
		border="1">
		<thead>
			<tr>
				<th>Slab No</th>
				<th>MinimumAmount</th>
				<th>MaximumAmount</th>
				<th>TaxRate</th>
				<th>IsActive</th>
				<th>Action</th>
			</tr>
		</thead>

	</table>
</div>



<!-- Edit professional model Box -->

<div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="professionalTaxModalEdit"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<form id="edit_form">
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
						<label data-error="wrong" data-success="right" for="tranId">TranId</label>
						<input type="text" class="form-control" id="tranId" class="form-control validate"
							readonly="readonly">
					</div>
					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="minimumAmount">MinimumAmount</label>
						<input type="text" class="form-control" id="minimumAmount" name="min_amt" 
							class="form-control validate">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="maximumAmount">MaximumAmount</label>
						<input type="text" class="form-control" id="maximumAmount"
							class="form-control validate" name="max_amt">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="taxRates">TaxRates</label>
						<input type="text" class="form-control" id="taxRates" name="tax_rate" class="form-control validate">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="isActive">IsActive</label>
						<input type="text" class="form-control" id="isActive" name="is_active" class="form-control validate">
					</div>


					<div class="modal-footer d-flex justify-content-center editInsideWrapper">
						
						<button id="edit_btn" type="button">UpdateDetails</button>
						<button class="btn btn-outline-secondary btn-block editInside" type="button">
							Update Details <i class="fas fa-paper-plane-o ml-1" ></i>
						</button>
					</div>
				</div>
			</div>
		</div>
</form>
	</div>
</div>
<%@ include file="footer.jsp"%>
<script src="resources/validation/bootstrapValidator.min.js"></script>

<script>
    $('#setting_form').bootstrapValidator({
        //container: '#messages',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {

            weekOfId: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            casualLeaveForExecutive: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            casualLeaveForWorkmen: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            casualLeaveForStaff: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            sickLeaveForExecutive: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            sickLeaveForStaff: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            sl_female: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            el_exc: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            el_staff: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            el_fmale: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            max_el_exe: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            max_el_staff: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            max_el_fmale: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            max_sl_exe: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            max_sl_staff: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            max_sl_fmale: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },

            basic_per: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            da_per: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            hra_per: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            con_per: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            lta_Per: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            medical_per: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            other_allow_per: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            bonus1_per: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            bonus1_per: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            pf_per: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            esi_per: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            union_fund: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            clubFund: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            paySheetClosingDay: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            paySheetLockDay: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            paySheetUnLockDay: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },




        }

    });

$("#setting_form").submit(function(event){
event.preventDefault();return false;
$('#setting_form').data('bootstrapValidator').validate();alert();
if($('#setting_form').data('bootstrapValidator').isValid()){
	SettingEdit();
}

});
</script>
<script>
    $('#edit_form').bootstrapValidator({
        //container: '#messages',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {


            min_amt: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',
                    },
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            max_amt: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',
                    },
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            tax_rate: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',
                    },
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            is_active: {
                validators: {
                    notEmpty: {
                        message: 'ReportingTo is required ',
                    },
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },

        }

    });


$("#edit_btn").on("click", function() {  alert();

    $('#edit_form').data('bootstrapValidator').validate();
  
    if ($('#edit_form').data('bootstrapValidator').isValid()) {
        editProfessionalTax();
    }

}); 
</script>

      	    <script src="resources/dist/js/sidebarmenu.js"></script>
