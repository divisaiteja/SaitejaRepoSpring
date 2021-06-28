<%@ include file="header.jsp"%>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
 <script>
$(document).ready(function(){
    $("#warnings").hide();
    $("#success").hide();
    $("#successinedit").hide();
    $("#setting_form").hide();
    $("#professionalid").hide();

});
</script>
 <script>
$(document).ready(function() {
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
	function commonFunctionForOnChangeDivisionSettings(division){
		 
		  if($("#division").val()==0){
			  $("#setting_form").hide();
			    $("#professionalid").hide();	  
		  }
		  else{
			  retrieve: true,
		$.ajax({
	        type: "GET",
	        contentType : "application/json",
	        url: "/HRMS/getAllSetting?division="+division, //this is my servlet
	          success: function(data){ 
	        	  var json=data;
	        	  $("#tranId").val(json.dataBean[0].tranId);
	        	  $("#weekOfId").val(json.dataBean[0].weekOfId);
	        	  $("#bioidasidno").val(json.dataBean[0].bioidasidno);
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
                  $("#pflimit").val(json.dataBean[0].pflimit);
                  $("#esilimit").val(json.dataBean[0].esilimit);
                  $("#dwskilled").val(json.dataBean[0].dwSkilled);
                  $("#dwsemiskilled").val(json.dataBean[0].dwSemiSkilled);
                  $("#dwunskilled").val(json.dataBean[0].dwUnSkilled);
	        }
	 });
		  }	
		
	}
 function getHRDetails(division){
    $("#setting_form").show();
    $("#professionalid").show();
	var division=document.getElementById("division").value;
	    commonFunctionForOnChangeDivisionSettings(division);
	    professionaltax();
} 
</script>
<script>
function professionaltax(){
	$('#professionaltax').dataTable({
		"destroy" : true,
      "ajax" : {
			"url" : "/HRMS/getAllProfessionalTax",
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
			data : "statusCodeForActive"
		},
		{
			data : null,
			className : "center",
			defaultContent : '<input type="image" src="resources/assets/images/edit-icon.png" height="15" width="15" id="professional" >'
		} ],

          });
								
		}
	 	

</script>
<script>
	$("#professionaltax").on('click', '#professional', function(){
		 var currentRow = $(this).closest("tr");
			var rowData = $("#professionaltax").DataTable().row(currentRow).data();
		   var tranId  = rowData.tranId;
	   retrieve: true,
	   $.ajax({
		 contentType : "application/json",
		"url" : "/HRMS/getProfessionalTaxInformationByTranId?tranId="+tranId,
		"dataSrc" : "dataBean",
		"type" : "GET",
       
		success: function(data){
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
	SettingEdit["bioidasidno"] = $("#bioidasidno").val();
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
    SettingEdit["pflimit"] = $("#pflimit").val();
    SettingEdit["esilimit"] = $("#esilimit").val();
    SettingEdit["dwSkilled"] = $("#dwskilled").val();
    SettingEdit["dwSemiSkilled"] = $("#dwsemiskilled").val();
    SettingEdit["dwUnSkilled"] = $("#dwunskilled").val();
	
	$.ajax({
        type: "post",
        contentType : "application/json",
        url: "settingEdit", 
        data : JSON.stringify(SettingEdit),
        success: function(data){ 
        	setInterval(function(){
        		$("#successmsg").html(data["successMessage"]);
				$("#success").show();	
	        	window.location.reload(); // this will run after every 5 seconds
	        }, 2000);

        }
 });
}
</script>
<script>
function editProfessionalTax(){
	var editProfessionalTax = {};
	var tranId = document.getElementById("tranId").value;
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

function saveTaxRate(){
		var savetaxrate = {};
		savetaxrate["minimumAmount"] = $("#minamount").val();
		savetaxrate["maximumAmount"] = $("#maxamount").val();
		savetaxrate["taxRates"] = $("#taxrate").val();
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "saveNewTaxRate", //this is my servlet
			data : JSON.stringify(savetaxrate),
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
<div>
	<div class="box-content row">
		<div class="form-group has-warning  col-md-6">
			<label class="control-label" for="inputWarning1">Division</label> 
			<select
				id="division" class="form-control" onchange="getHRDetails()">
				<option value ="0">Select Division</option>

			</select>
		</div>
	</div>
	<hr color="00FFFF">
	<div id="onchange">
    <form id="setting_form">
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
        	<hr color="00FFFF">


	<div class="box-content row">
		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">Manual Posting</label>
			<select id="manualPostingAllowed" class="form-control" >
				<option value="1">YES</option>
				<option value="0">NO</option>
			</select>
		</div>
		<div class="form-group has-warning  col-md-3" hidden>
			<label class="control-label" for="inputWarning1">W-off ID</label> <input
				type="text" id="weekOfId" name="weekOfId" class="form-control">
		</div>
		
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Biometric ID Same As Employee ID</label>
			<select id="bioidasidno" class="form-control" >
				<option value="1">YES</option>
				<option value="0">NO</option>
			</select> 
		</div>
	</div>

        	<hr color="00FFFF">
                
	<div class="col-md-12">
		<h4 align="left" style="color: #fb8c00">Casual Leaves</h4>
	</div>
        	<hr color="00FFFF">
                
            <div class="col-md-12">
                <h6 align="left" style="color: darkblue"><u>Annual Credits</u></h6>
            </div>

            <div class="box-content row">
                
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Executives
			</label> <input type="text" class="form-control" name="casualLeaveForExecutive"  id="casualLeaveForExecutive">
		</div>
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Staff</label>
			<input type="text" class="form-control" name="casualLeaveForStaff" id="casualLeaveForStaff">
		</div>

		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Workmen</label>
			<input type="text" class="form-control" name="casualLeaveForWorkmen" id="casualLeaveForWorkmen">
		</div>
            </div>

        	<hr color="00FFFF">
	<div class="col-md-12">
		<h4 align="left" style="color: #fb8c00">Sick Leaves</h4>
	</div>
        	<hr color="00FFFF">
                
            <div class="col-md-12">
                <h6 align="left" style="color: darkblue"><u>Annual Credits</u></h6>
            </div>
                        
            <div class="box-content row">                
                
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Executives</label>
			<input type="text" class="form-control" id="sickLeaveForExecutive" name="sickLeaveForExecutive">
		</div>

		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Staff</label>
			<input type="text" class="form-control" id="sickLeaveForStaff" name="sickLeaveForStaff">
		</div>

		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Workmen</label>
			<input type="text" class="form-control" id="sickLeaveForWorkmen" name="sl_female">
		</div>
            </div>
            
            <div class="col-md-12">
                <h6 align="left" style="color: darkblue"><u>Maximum Credits</u></h6>
            </div>
           
                <div class="box-content row">                    
                
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Executives</label>
			<input type="text" class="form-control" name="max_sl_exe" id="maximumSickLeavesForExecutive">
		</div>
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Staff</label>
			<input type="text" class="form-control" name="max_sl_staff" id="maximumSickLeavesForStaff">
		</div>
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Workmen</label>
			<input type="text" class="form-control" name="max_sl_fmale" id="maximumSickLeavesForWorkmen">
		</div>

            </div>
            
                        	<hr color="00FFFF">
	<div class="col-md-12">
		<h4 align="left" style="color: #fb8c00">Earn/Paid Leaves</h4>
	</div>
                                        	<hr color="00FFFF">
                                                
            <div class="col-md-12">
                <h6 align="left" style="color: darkblue"><u>Annual Credits</u></h6>
            </div>
                
            <div class="box-content row">            
               
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Executives</label>
			<input type="text" class="form-control" id="earnedLeaveForExecutive" name="el_exc">
		</div>
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Staff</label>
			<input type="text" class="form-control" id="earnedLeaveForStaff" name="el_staff">
		</div>

		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Workmen</label>
			<input type="text" class="form-control" id="earnedLeaveForWorkmen" name="el_fmale">
		</div>

            <div class="col-md-12">
                <h6 align="left" style="color: darkblue"><u>Maximum Credits</u></h6>
            </div>
                
                
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Executives</label>
			<input type="text" class="form-control" id="maximumEarnedLeavesForExecutive" name="max_el_exe">
		</div>

		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Staff</label>
			<input type="text" class="form-control" name="max_el_staff"  id="maximumEarnedLeavesForStaff">
		</div>

		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Workmen</label>
			<input type="text" class="form-control" name="max_el_fmale" id="maximumEarnedLeavesForWorkmen">
		</div>

	</div>

        	<hr color="00FFFF">
	<div class="col-md-12">
		<h4 align="left" style="color: #fb8c00">Salary</h4>
	</div>
                        	<hr color="00FFFF">
                                
	<div class="box-content row">
		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">Basic%</label>
			<input type="text" class="form-control" id="basicPercentage" name="basic_per">
		</div>
		<div class="form-group has-warning  col-md-1" hidden>
			<label class="control-label" for="inputWarning1">DA%</label>
			<input type="text" class="form-control" id="daPercentage" name="da_per">
		</div>
		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">HRA%</label>
			<input type="text" class="form-control" id="hraPercentage" name="hra_per">
		</div>
		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">Site Al%</label>
			<input type="text" class="form-control" id="conveyancePercentage" name="con_per">
		</div>

		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">Spl.Al%</label>
			<input type="text" class="form-control" id="otherAllowancePercentage" name="other_allow_per">
		</div>
		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">LTA%</label>
			<input type="text" class="form-control" id="ltaPercentage" name="lta_Per">
		</div>
		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">Medical%</label>
			<input type="text" class="form-control" id="medicalPercentage" name="medical_per">
		</div>

		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">Bonus-1%</label>
			<input type="text" class="form-control" id="bonusOnePercentage" name="bonus1_per">
		</div>
		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">Bonus-2%</label>
			<input type="text" class="form-control" id="bonusTwoPercentage" name="bonus2_per">
		</div>

		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">PF%</label>
			<input type="text" class="form-control" id="pfPercentage" name="pf_per">
		</div>
		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">PF Limit</label>
			<input type="text" class="form-control" id="pflimit" name="pflimit">
		</div>

		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">ESI%</label>
			<input type="text" class="form-control" id="esiPercentage" name=esi_per">
		</div>
		<div class="form-group has-warning  col-md-1">
			<label class="control-label" for="inputWarning1">ESI Limit</label>
			<input type="text" class="form-control" id="esilimit" name=esilimit">
		</div>

		<div class="form-group has-warning  col-md-1" hidden>
			<label class="control-label" for="inputWarning1">UnionFund</label> <input
				type="text" id="unionFund" class="form-control" name="union_fund">
		</div>

		<div class="form-group has-warning  col-md-1" hidden>
			<label class="control-label" for="inputWarning1">Club Fund</label> <input
				type="text" id="clubFund" name="clubFund" class="form-control">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">Pay-Sheet Closing Day</label>
			<input type="text" class="form-control" id="paySheetClosingDay" name="paySheetClosingDay">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">Pay-Sheet Lock Day</label>
			<input type="text" class="form-control" id="paySheetLockDay" name="paySheetLockDay">
		</div>

		<div class="form-group has-warning  col-md-3">
			<label class="control-label" for="inputWarning1">Pay-Sheet UnLock Day</label>
			<input type="text" class="form-control" id="paySheetUnLockDay" name="paySheetUnLockDay">
		</div>
	</div>

        	<hr color="00FFFF">
	<div class="col-md-12">
		<h4 align="left" style="color: #fb8c00">Daily-Wage Rate</h4>
	</div>
                        	<hr color="00FFFF">
                                
	<div class="box-content row">
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Skilled @</label>
			<input type="text" class="form-control" id="dwskilled" name="dwskilled">
		</div>
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Semi-Skilled @</label>
			<input type="text" class="form-control" id="dwsemiskilled" name="dwsemiskilled">
		</div>
		<div class="form-group has-warning  col-md-4">
			<label class="control-label" for="inputWarning1">Un-skilled @</label>
			<input type="text" class="form-control" id="dwunskilled" name="dwunskilled">
		</div>
	</div>



 <hr color="00FFFF">
                                
	<div align="right">
<!-- 		<input type="submit" value="update" id="setting" class="btn btn-success" > 
 -->		<button type="button"id="setting" class="btn btn-primary" >
						Update 
					</button>
		
	</div>
</form>
</div>
<div id="professionalid">
<hr color="00FFFF">
<div class="col-md-12">
	<h4 align="left" style="color: #fb8c00">ProfessionalTaxes</h4>
</div>
<div>
<h5 align="center">
		To Add New Tax Rate <a data-toggle="modal"
			data-target="#newTaxRate" href="#">ClickHere</a>
	</h5>
</div>
<div >
	<table id="professionaltax" class="display" style="width: 100%"
		border="1">
		<thead>
			<tr>
				<th>Slab No</th>
				<th>Minimum Amount</th>
				<th>Maximum Amount</th>
				<th>Tax Rate</th>
				<th>IsActive</th>
				<th>Action</th>
			</tr>
		</thead>

	</table>
</div>
</div>
<!-- save modal -->
<div class="modal fade" id="newTaxRate" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			<div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" > Adding New Tax Rate</h4>
		   </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="alert alert-success " id="success" style="text-align:center">
  	<strong id="successmsg" ></strong> 
	</div>
       <form id="taxrate_form">
			<div class="modal-body">
				<div class="box-content row">
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="minamount">Minimum Amount</label> <input
						type="text" id="minamount" name="minamount" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="maxamount">Maximum Amount</label>
					<input type="text" id="maxamount" name="maxamount"
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="taxrate">Tax Rate</label>
					<input type="text" id="taxrate" name="taxrate"
						class="form-control">
				</div>

			</div>
			</div>
			
			<div class="modal-footer" >
			<div class="container" align="center">
				<button type="button" class="btn btn-primary"  id="tax_btn" >Submit</button>
			</div>
			<h5 align="center" id="warnings" style="color:red"></h5>
			</div>
			</form>
		</div>
		
		</div>
	</div>
	</div>
<!-- editing box -->
<div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="professionalTaxModalEdit" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="successinedit" style="text-align:center">
  		<strong id="successmsginedit" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5">  Editing Professional Tax Slabs
						</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "edit_form">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="tranId">tranId</label>
						<input type="text" id="tranId" class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="minimumAmount">MinimumAmount</label>
						<input type="text" id="minimumAmount" name="minimumAmount" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="maximumAmount">MaximumAmount</label>
						<input type="text" id="maximumAmount" name="maximumAmount" class="form-control">
					</div>
	              <div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="taxRates">TaxRates</label>
						<input type="text" id="taxRates" name="taxRates" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isActive">Status</label>
<!-- 						<input type = "text"  id="isActive" name="isActive" class="form-control">
 -->					
 	                  <select id ="isActive" name =  "isActive" >
 	                      <option value = "0"> InActive</option>
 	                      <option value = "1">Active</option>
                       </select>
					
					</div>
					<div align="center">
					<button type="button"id="profedit" class="btn btn-primary" >
						Submit 
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
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
            
            bioidasidno: {
                validators: {
                    notEmpty: {
                        message: 'bioidasidno is required ',

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
            dwskilled: {
                validators: {
                    notEmpty: {
                        message: 'Daily wage for Skilled is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            dwsemiskilled: {
                validators: {
                    notEmpty: {
                        message: 'Daily wage for Semi-Skilled is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },
            dwunskilled: {
                validators: {
                    notEmpty: {
                        message: 'Daily wage for Un-Skilled is required ',

                    }, 
                    integer: {
                        message: 'The value is not an integer'
                    }
                }
            },


        }

    });


  $("#setting").on("click", function(){
$('#setting_form').data('bootstrapValidator').validate();
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


        	minimumAmount: {
                validators: {
                    notEmpty: {
                        message: 'minimumAmount is required ',
                    },
                    integer: {
                        message: 'The value is an integer'
                    }
                }
            },
            maximumAmount: {
                validators: {
                    notEmpty: {
                        message: 'maximumAmount is required ',
                    },
                    integer: {
                        message: 'The value is an integer'
                    }
                }
            },
            taxRates: {
                validators: {
                    notEmpty: {
                        message: 'taxRates is required ',
                    }
                    
                }
            },
            isActive: {
                validators: {
                    notEmpty: {
                        message: 'Isactive is required ',
                    },
                  
                }
            },

        }

    });


$("#profedit").on("click", function() {  
    $('#edit_form').data('bootstrapValidator').validate();
    if ($('#edit_form').data('bootstrapValidator').isValid()) {
        editProfessionalTax();
    }

}); 
</script>
<script>
 $('#taxrate_form').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
             minamount: {
                     validators: {
                         notEmpty: {
                             message: 'minamount is required ',
                          },
                        }
                  },
				  maxamount: {
                     validators: {
                         notEmpty: {
                             message: 'maxamount is required ',
                          },
                        }
                  },
				  taxrate: {
                     validators: {
                         notEmpty: {
                             message: 'taxrate is required ',
                          },
                        }
                  },
				  

             }

         });
        $("#tax_btn").click(function(){
$('#taxrate_form').data('bootstrapValidator').validate();
if($('#taxrate_form').data('bootstrapValidator').isValid()){
	saveTaxRate();
}


});

</script>

      	    <script src="resources/dist/js/sidebarmenu.js"></script>
