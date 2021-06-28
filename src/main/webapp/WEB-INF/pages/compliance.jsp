
 <%@ include file="header.jsp" %>
  <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
	 <script src="resources/validation/bootstrapValidator.min.js"></script>

<script src="resources/dist/js/sidebarmenu.js"></script>
<link rel="stylesheet" href="resources/css/rowReorder.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/font-awesome.min.css">
<!-- <link rel="stylesheet" href="//cdn.datatables.net/rowreorder/1.2.0/css/rowReorder.dataTables.min.css" /> -->
<!--   <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- <style>
.content{
display:none;
}
.preload{
margin:0;
position: absolute;
top: 50%;
left: 50%;
margin-right: -50%;
transformation:translate(-50%,50%);
}

</style> -->
</head>
<!-- <script>
$(function () {
	$(".preload").fadeOut(2000,function(){
		$(".content").fadeIn(1000);
		
	});
});
</script> -->
<!-- <div class ="preload" align="center">
<input type="image" src="resources/assets/images/loading_spinner.gif"  height="50" width="50" id="spinner">
</div> -->
<body>
<!-- <div class="content">
</div> -->
<body>
<script>
$(document).ready(function() {
	 
		 $("#success").hide();
		 $("#successinedit").hide();
		 
	//alert(">>>>>>>>>>"+transactiontranid)
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getownernames", // this is my servlet
		success : function(data) {
			var abc = data;
			var ele = document.getElementById('OwnerName');
			var element = document.getElementById('ownername');
			var saveapprover = document.getElementById('Approvers');
			var editapprover = document.getElementById('approver');
			for (var i = 0; i < abc.length; i++) {
				ele.innerHTML = ele.innerHTML+ '<option value="'+ abc[i]["empname"] + '">'+ abc[i]["empname"] + '</option>';
			}
			for (var i = 0; i < abc.length; i++) {
				element.innerHTML = element.innerHTML+ '<option value="'+ abc[i]["empname"] + '">'+ abc[i]["empname"] + '</option>';
			}
			for (var i = 0; i < abc.length; i++) {
				saveapprover.innerHTML = saveapprover.innerHTML+ '<option value="'+ abc[i]["empname"] + '">'+ abc[i]["empname"] + '</option>';
			}
			for (var i = 0; i < abc.length; i++) {
				editapprover.innerHTML = editapprover.innerHTML+ '<option value="'+ abc[i]["empname"] + '">'+ abc[i]["empname"] + '</option>';
			}
			

		}
	});
});
function reset() {
	$("#complianceform").trigger("reset");
	$("#complianceform").data('bootstrapValidator').resetForm(); 
	
	
}
function editreset() {
	$("#complianceedit").trigger("reset");
	$("#complianceedit").data('bootstrapValidator').resetForm(); 
	
	
}
</script>
<script>
$(document).ready(function() {
 $('#Compliancetable').dataTable( {
		"scrollX": true,
		"scrollY": "200px",
        "paging": true,
        "bSort": true,
			 "ajax" : {
			"url" : "getAllCompliance",
			"dataSrc" : "dataBean",
			"type" : "GET",
		       },
			"columns": [
							{ data: "complianceid"},
							{ data: "title"},
							{ data: "description"},
			 				{ data: "clauseact"},
					 		{ data: "legislativeid"},
					 		{ data: "penality"},
							{ data: "compliancetype"},
							{ data: "frequencyid"},
			 				{ data: "iscriticalstatus"},
					 		{ data: "duedate"},
					 		{ data: "nextduedate"},
					 		{ data: "initiateddate"},
					 		{ data: "duedays"},
					 		{ data: "proofsrequiredstatus"},
					 		{ data: "alertdays"},
					 		{ data:  "ownername"},
					 		{ data:  "approver"},
							{ data: "statusCodeForActive"},
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="complianceEditing"> <input type="image" src="resources/assets/images/delete.png" id="deleteId" height="25" width="25">'
				            }
					],
		} );
} );

/************************************* Compliance editing *****************************************/

$("#Compliancetable").on('click','#complianceEditing',function() {
	var currentRow = $(this).closest("tr");
	var rowData = $("#Compliancetable").DataTable().row(currentRow).data();
	var complianceid = rowData.complianceid;
	alert(">>>>"+complianceid)
	retrieve:true,
	$.ajax({
	contentType : "application/json",
		"url" : "complianceByComplianceid?complianceid="+complianceid,
		"dataSrc" : "dataBean",
		"type" : "GET",
         success : function(data) {
		for (var i = 0; i < data.length; i++) {
		  $("#complianceid").val(data[i].complianceid);
		  $("#title").val(data[i].title);
		  $("#description").val(data[i].description);
		  $("#clauseact").val(data[i].clauseact);
		  $("#legislative").val(data[i].legislativeid);
		  $("#penality").val(data[i].penality);
		  $("#compliancetype").val(data[i].compliancetype);
		  $("#frequency").val(data[i].frequencyid);
		  $("#iscritical").val(data[i].iscritical);
		  $("#duedate").val(data[i].duedate);
		  $("#initiateddate").val(data[i].initiateddate);
		  $("#nextduedate").val(data[i].nextduedate);
		  $("#duedays").val(data[i].duedays);
		  $("#alertdays").val(data[i].alertdays);
		  $("#proofsrequired").val(data[i].proofsrequired);
		  $("#ownername").val(data[i].ownername);
		  $("#approver").val(data[i].approver);
		  $("#isactive").val(data[i].isactive);
						}
             selectedRecord = data;
                },
                  });
              $('#compliancemodal').modal('show');

				});


/************************************* Compliance Delete *****************************************/

$("#Compliancetable").on('click', '#deleteId', function() {

	var currentRow = $(this).closest("tr");
    var complianceid = currentRow.find("td:eq(0)").html(); 
    var retVal = confirm("would you like to delete this complianceid "+complianceid);
   if( retVal == true ) {
    //  document.write ("User wants to continue!");
      deletedSuccessfully(complianceid);
   } else {
      //document.write ("User does not want to continue!");
   }
});
function deletedSuccessfully(complianceid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteCompliance?complianceid="+complianceid, //this is my servlet
	        success: function(data){  
	        	$("#deletemessage").html("Deleted SucessFully");
	        	 setInterval(function(){
	 	        	window.location.reload(); // this will run after every 5 seconds
	 	        }, 2000);
	        }
	  });
}
</script>

<script>

$(document).ready(function() {
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "AllLegislativedropdown", //this is my servlet
      
        success: function(data){ 
        	var abc=data;
        	var ele = document.getElementById('LegislativeId');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                ele.innerHTML = ele.innerHTML +
                    '<option value="' + abc[i]["legislativeid"] + '">' + abc[i]["legislativedescription"] + '</option>';
            }
            var element = document.getElementById('legislative');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                element.innerHTML = element.innerHTML +
                    '<option value="' + abc[i]["legislativeid"] + '">' + abc[i]["legislativedescription"] + '</option>';
            }
        	
        }
 });
});
$(document).ready(function() {
	
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "Allfrequencydropdown", //this is my servlet
      
        success: function(data){ 
        	var abc=data;
        	var ele = document.getElementById('FrequencyId');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                ele.innerHTML = ele.innerHTML +
                    '<option value="' + abc[i]["frequencyid"] + '">' + abc[i]["frequency_description"] + '</option>';
            }
            var element = document.getElementById('frequency');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                element.innerHTML = element.innerHTML +
                    '<option value="' + abc[i]["frequencyid"] + '">' + abc[i]["frequency_description"] + '</option>';
            }
        	
        }
 });
});
</script>
<script>
function saveonchangeownerandapprover() {
	var OwnerName = document.getElementById('OwnerName').value;
	var Approvers = document.getElementById('Approvers').value;
	if(OwnerName==Approvers){
	alert("Please select different names for Ownername and Approver")
	document.getElementById('Approvers').value="";
	}
}

function editonchangeownerandapprover() {
	var ownername = document.getElementById('ownername').value;
	var approver = document.getElementById('approver').value;
	if(ownername==approver){
	alert("Please select different names for Ownername and Approver")
	document.getElementById('approver').value="";
	}
}
	function saveCompliance() {
		//alert("saveCompliance");
		var	 saveCompliance = {};
		saveCompliance["title"] = $("#Title").val();
		saveCompliance["description"] = $("#Description").val();
		saveCompliance["clauseact"] = $("#Clause").val();
		saveCompliance["legislativeid"] = $("#LegislativeId").val();
		saveCompliance["penality"] = $("#Penality").val();
		saveCompliance["compliancetype"] = $("#ComplianceType").val();
		saveCompliance["frequencyid"] = $("#FrequencyId").val();
		saveCompliance["iscritical"] = $("#IsCritical").val();
		saveCompliance["duedate"] = $("#DueDate").val();
		saveCompliance["initiateddate"] = $("#InitiatedDate").val();
		saveCompliance["nextduedate"] = $("#NextDueDate").val();
		saveCompliance["duedays"] = $("#DueDays").val();
		saveCompliance["alertdays"] = $("#AlertDays").val();
		saveCompliance["proofsrequired"] = $("#ProofRequired").val();
		saveCompliance["ownername"] = $("#OwnerName").val();
		saveCompliance["approver"] = $("#Approvers").val();
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "saveNewCompliance", //this is my servlet
			data : JSON.stringify(saveCompliance),
			success : function(data) {
				$("#successmsg").html(data["successMessage"]);
				$("#success").show();	
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);

			}
		});
	}
	function editCompliance() {
		debugger;
		var editCompliance = {};
		editCompliance["complianceid"] = $("#complianceid").val();
		editCompliance["title"] = $("#title").val();
		editCompliance["description"] = $("#description").val();
		editCompliance["clauseact"] = $("#clauseact").val();
		editCompliance["legislativeid"] = $("#legislative").val();
		editCompliance["penality"] = $("#penality").val();
		editCompliance["compliancetype"] = $("#compliancetype").val();
		editCompliance["frequencyid"] = $("#frequency").val();
		editCompliance["iscritical"] = $("#iscritical").val();
		editCompliance["duedate"] = $("#duedate").val();
		editCompliance["initiateddate"] = $("#initiateddate").val();
		editCompliance["nextduedate"] = $("#nextduedate").val();
		editCompliance["duedays"] = $("#duedays").val();
		editCompliance["alertdays"] = $("#alertdays").val();
		editCompliance["proofsrequired"] = $("#proofsrequired").val();
		editCompliance["ownername"] = $("#ownername").val();
		editCompliance["approver"] = $("#approver").val();
		editCompliance["isactive"] = $("#isactive").val();
	    $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "editCompliance", //this controller url
	        data : JSON.stringify(editCompliance),
	        success: function(data){  
	        	 $("#successinedit").show();
	        	 $("#successmsginedit").html(data["successMessage"]);
	        	setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);
	         
	        }
	   
	    });
		
	}
	function generateTransaction() {
		alert("generateTransaction");
		 $.ajax({
			type : "post",
			contentType : "application/json",
			url : "generateTransaction", //this is my servlet
			success : function(data) {
					alert("SUCCESSFULLY GENERATED");
		       

			}
		}); 
		
	}
	
</script>

<h3 align="center">Compliance Master</h3>
<br><br>
<!-- <div class="row">
<h5 align="left">
		 Add New   <a data-toggle="modal"
			data-target="#newCompliance" href="#"><input type="image" src="resources/assets/images/add.png" height="40" width="40"></a>
	</h5>
	<div align="right">
<button type="button" onclick="generateTransaction()"  class="btn btn-primary" value="generateTransaction"> Generate Transaction</button>
</div>	
</div> -->

<div id="header">
    <h4 style="float: left; width: 50%; text-align: left;">
    
		 Add New   <a data-toggle="modal"
			data-target="#newCompliance" href="#"><input type="image" src="resources/assets/images/add.png" height="40" width="40"></a>
	</h4>
    <h4 style="float: left; width: 50%; text-align: center;"> <button type="button" onclick="generateTransaction()"  class="btn btn-primary" value="generateTransaction"> <b>Generate Transaction </b></button></h4>
    
</div>
<br><br><br>
	<h5 align="center" id="deletemessage" style="color:red"></h5>
	<table id="Compliancetable" class="display" style="width: 100%" border="1">
		<thead>
			<tr>
			
				<th>ComplianceId</th>
				<th>Title</th>
				<th>Description</th>
				<th>Clause</th>
				<th>Legislative</th>
				<th>Penalty</th>
				<th>Compliance</th>
				<th>Frequency</th>
				<th>IsCritical</th>
				<th>DueDate</th>
				<th>NextDueDate</th>
				<th>InitiatedDate</th>
				<th>Duedays</th>
				<th>ProffRequired</th>
				<th>AlertDay</th>
				<th>OwnerName</th>
				<th>Approver</th>
				<th>Status</th>
				<th>Action</th>

			</tr>
		</thead>
	</table>
	
	<!--****************************Save Compliance model box ***********************************-->
	<div class="modal fade" id="newCompliance" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			   <div class="container">
		         <h4 align="center" style="color: #0B1907" class="modal-title" > Adding New Compliance</h4>
		       </div>
				<button type="button" class="close" data-dismiss="modal" onclick="reset()">&times;</button>
			</div>
			<div class="alert alert-success " id="success" style="text-align:center">
  	            <strong id="successmsg" ></strong> 
	        </div>
       <form id="complianceform">
			<div class="modal-body">
				<div class="box-content row">
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Title</label> <input
						type="text" id="Title" name="Title" autocomplete="off"  class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Description</label>
					<input type="text" id="Description" name="Description" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Clause</label>
					<input type="text" id="Clause" name="Clause" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">LegislativeId</label>
					<select  id="LegislativeId" name="LegislativeId" class="form-control">
						<option value="">select</option>
						</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Penality</label>
					<input type="text" id="Penality" name="Penality" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">ComplianceType</label>
					<select  id="ComplianceType" name="ComplianceType" class="form-control">
						<option value="">select</option>
						<option value="ComplianceType1">ComplianceType1</option>
						<option value="ComplianceType2">ComplianceType2</option>
						<option value="ComplianceType3">ComplianceType3</option>
						</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">FrequencyId</label>
					<select  id="FrequencyId" name="FrequencyId" autocomplete="off"  class="form-control">
						<option value="">select</option>
						</select>
				</div>
				
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">OwnerName</label>
					<select  id="OwnerName" name="OwnerName" onchange="saveonchangeownerandapprover()" autocomplete="off"  class="form-control">
						<option value="">select</option>
						</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Approver</label>
					<select  id="Approvers" name="Approvers" onchange="saveonchangeownerandapprover()" autocomplete="off"  class="form-control">
						<option value="">select</option>
						</select>
				</div>
				 <div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">IsCritical</label>
					<select  id="IsCritical" name="IsCritical"  class="form-control">
						<option value="">select</option>
						<option value="0">No</option>
						<option value="1">Yes</option>
						</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">DueDate</label>
					<input type="text" id="DueDate" name="DueDate" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">InitiatedDate</label>
					<input type="text" id="InitiatedDate" name="InitiatedDate" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">NextDueDate</label>
					<input type="text" id="NextDueDate" name="NextDueDate" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">DueDays</label>
					<input type="text" id="DueDays" name="DueDays" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">AlertDays</label>
					<input type="text" id="AlertDays" name="AlertDays" autocomplete="off" 
						class="form-control">
				</div>
                  <div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">ProofRequired</label>
					<select  id="ProofRequired" name="ProofRequired" class="form-control">
						<option value="">select</option>
						<option value="0">No</option>
						<option value="1">Yes</option>
						</select>
				</div>
				
			</div>
			</div>
			<div class="modal-footer" >
			 <div class="container" align="center">
				  <button type="button"  class="btn btn-primary"  id="compliancebtn" >Submit</button> 
			</div> 
			</div>
			</form>
		</div>
		</div>
	</div>
	
	
	<!-- ************************************* Compliance Edit Model Box *************************************-->
   <div class="modal fade" id="compliancemodal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			   <div class="container">
		         <h4 align="center" style="color: #0B1907" class="modal-title" > Edit Compliance</h4>
		       </div>
				<button type="button" class="close" data-dismiss="modal" onclick="editreset()">&times;</button>
			</div>
			<div class="alert alert-success " id="successinedit" style="text-align:center">
  	            <strong id="successmsginedit" ></strong> 
	        </div>
       <form id="complianceedit">
			<div class="modal-body">
				<div class="box-content row">
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">ComplianceId</label> <input
						type="text" id="complianceid" name="complianceid" readonly="readonly"  class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Title</label> <input
						type="text" id="title" name="title" autocomplete="off"  class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Description</label>
					<input type="text" id="description" name="description" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Clause</label>
					<input type="text" id="clauseact" name="clauseact" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">LegislativeId</label>
					<select  id="legislative" name="legislative" class="form-control">
						<option value="">select</option>
						</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Penality</label>
					<input type="text" id="penality" name="penality" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">ComplianceType</label>
					<select  id="compliancetype" name="compliancetype" class="form-control">
						<option value="">select</option>
						<option value="ComplianceType1">ComplianceType1</option>
						<option value="ComplianceType2">ComplianceType2</option>
						<option value="ComplianceType3">ComplianceType3</option>
						</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">FrequencyId</label>
					<select  id="frequency" name="frequency" autocomplete="off"  class="form-control">
						<option value="">select</option>
						</select>
				</div>
				
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">OwnerName</label>
					<select  id="ownername" name="ownername"  autocomplete="off"  onchange="editonchangeownerandapprover()" class="form-control">
						<option value="">select</option>
						</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Approver</label>
					<select  id="approver" name="approver" autocomplete="off" onchange="editonchangeownerandapprover()" class="form-control">
						<option value="">select</option>
						</select>
				</div>
				 <div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">IsCritical</label>
					<select  id="iscritical" name="iscritical"  class="form-control">
						<option value="">select</option>
						<option value="0">No</option>
						<option value="1">Yes</option>
						</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">DueDate</label>
					<input type="text" id="duedate" name="duedate" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">InitiatedDate</label>
					<input type="text" id="initiateddate" name="initiateddate" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">NextDueDate</label>
					<input type="text" id="nextduedate" name="nextduedate" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">DueDays</label>
					<input type="text" id="duedays" name="duedays" autocomplete="off" 
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">AlertDays</label>
					<input type="text" id="alertdays" name="alertdays" autocomplete="off" 
						class="form-control">
				</div>
                  <div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">ProofRequired</label>
					<select  id="proofsrequired" name="proofsrequired" class="form-control">
						<option value="">select</option>
						<option value="0">No</option>
						<option value="1">Yes</option>
						</select>
				</div>
				<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">Status</label>
					<select  id="isactive" name="isactive" class="form-control">
						<option value="">select</option>
						<option value="0">InActive</option>
						<option value="1">Active</option>
						</select>
				</div>
			</div>
			</div>
			<div class="modal-footer" >
			 <div class="container" align="center">
				  <button type="button"  class="btn btn-primary"  id="editcompliancebtn" >Submit</button> 
			</div> 
			</div>
			</form>
		</div>
		</div>
	</div>
	
	<!-- ****************************Compliance Edit validation********************************* -->
<script>
 $('#complianceedit').bootstrapValidator({
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	 title: {
                     validators: {
                         notEmpty: {
                             message: 'Title is required ',
                          },
                        }
                  },
				  description: {
                     validators: {
                         notEmpty: {
                             message: 'Description is required ',
                          },
                        }
                  },
                  clauseact: {
                      validators: {
                          notEmpty: {
                              message: 'Clause is required ',
                           },
                         }
                   },
                    legislative: {
                       validators: {
                           notEmpty: {
                               message: 'LegislativeId is required ',
                            },
                          }
                    }, 
                    penality: {
                        validators: {
                            notEmpty: {
                                message: 'Penality is required ',
                             },
                           }
                     },
                      compliancetype: {
                         validators: {
                             notEmpty: {
                                 message: 'ComplianceType is required ',
                              },
                            }
                      }, 
                      frequency: {
                          validators: {
                              notEmpty: {
                                  message: 'Frequency is required ',
                               },
                             }
                       },
                       ownername: {
                           validators: {
                               notEmpty: {
                                   message: 'ownername is required ',
                                },
                              }
                        },
                        approver: {
                            validators: {
                                notEmpty: {
                                    message: 'approver is required ',
                                 },
                               }
                         },
                       iscritical: {
                           validators: {
                               notEmpty: {
                                   message: 'IsCritical is required ',
                                },
                              }
                        },
                        duedate: {
                            validators: {
                                notEmpty: {
                                    message: 'DueDate is required ',
                                 },
                               }
                         },
                         initiateddate : {
                             validators: {
                                 notEmpty: {
                                     message: 'InitiatedDate is required ',
                                  },
                                }
                          },
                          nextduedate: {
                              validators: {
                                  notEmpty: {
                                      message: 'NextDueDate is required ',
                                   },
                                 }
                           },
                           duedays: {
                               validators: {
                                   notEmpty: {
                                       message: 'DueDays is required ',
                                    },
                                  }
                            },
                         
                         alertdays: {
                             validators: {
                                 notEmpty: {
                                     message: 'AlertDays is required ',
                                  },
                                }
                          },
                          proofsrequired: {
                     validators: {
                         notEmpty: {
                             message: 'ProofRequired id required ',
                          },
                        }
                  },
             }
         });
        $("#editcompliancebtn").click(function(){
        	//alert("nutton");
$('#complianceedit').data('bootstrapValidator').validate();
if($('#complianceedit').data('bootstrapValidator').isValid()){
	editCompliance();
}
});
	
 $('#complianceform').bootstrapValidator({
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	 Title: {
                     validators: {
                         notEmpty: {
                             message: 'Title is required ',
                          },
                        }
                  },
				  Description: {
                     validators: {
                         notEmpty: {
                             message: 'Description is required ',
                          },
                        }
                  },
                  Clause: {
                      validators: {
                          notEmpty: {
                              message: 'Clause is required ',
                           },
                         }
                   },
                    LegislativeId: {
                       validators: {
                           notEmpty: {
                               message: 'LegislativeId is required ',
                            },
                          }
                    }, 
                    Penality: {
                        validators: {
                            notEmpty: {
                                message: 'Penality is required ',
                             },
                           }
                     },
                      ComplianceType: {
                         validators: {
                             notEmpty: {
                                 message: 'ComplianceType is required ',
                              },
                            }
                      }, 
                      FrequencyId: {
                          validators: {
                              notEmpty: {
                                  message: 'FrequencyId is required ',
                               },
                             }
                       },
                       OwnerName: {
                           validators: {
                               notEmpty: {
                                   message: 'ownername is required ',
                                },
                              }
                        },
                        Approvers: {
                            validators: {
                                notEmpty: {
                                    message: 'approver is required ',
                                 },
                               }
                         },
                       IsCritical: {
                           validators: {
                               notEmpty: {
                                   message: 'IsCritical is required ',
                                },
                              }
                        },
                        DueDate: {
                            validators: {
                                notEmpty: {
                                    message: 'DueDate is required ',
                                 },
                               }
                         },
                         InitiatedDate : {
                             validators: {
                                 notEmpty: {
                                     message: 'InitiatedDate is required ',
                                  },
                                }
                          },
                          NextDueDate: {
                              validators: {
                                  notEmpty: {
                                      message: 'NextDueDate is required ',
                                   },
                                 }
                           },
                           DueDays: {
                               validators: {
                                   notEmpty: {
                                       message: 'DueDays is required ',
                                    },
                                  }
                            },
                         
                         AlertDays: {
                             validators: {
                                 notEmpty: {
                                     message: 'AlertDays is required ',
                                  },
                                }
                          },
                          ProofRequired: {
                     validators: {
                         notEmpty: {
                             message: 'ProofRequired id required ',
                          },
                        }
                  },
             }
         });
        $("#compliancebtn").click(function(){
        	//alert("nutton");
$('#complianceform').data('bootstrapValidator').validate();
if($('#complianceform').data('bootstrapValidator').isValid()){
	saveCompliance();
}
});
</script>
<%@include file="footer.jsp"%> 
 <script>
 $(document).ready(function () {
jQuery('#InitiatedDate').datepicker({
	 format: "dd-mm-yyyy",
    autoclose: true,
    todayHighlight: true
});
jQuery('#NextDueDate').datepicker({
	 format: "dd-mm-yyyy",
    autoclose: true,
    todayHighlight: true
});
jQuery('#DueDate').datepicker({
	 format: "dd-mm-yyyy",
   autoclose: true,
   todayHighlight: true
});

jQuery('#initiateddate').datepicker({
	 format: "dd-mm-yyyy",
   autoclose: true,
   todayHighlight: true
});
jQuery('#nextduedate').datepicker({
	 format: "dd-mm-yyyy",
   autoclose: true,
   todayHighlight: true
});
jQuery('#duedate').datepicker({
	 format: "dd-mm-yyyy",
  autoclose: true,
  todayHighlight: true
});

});
</script> 
 
 