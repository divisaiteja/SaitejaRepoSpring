

	$(document).ready(function() {
		var parentid = document.getElementById("idNumber").value;
		$('#education').dataTable(
				{
				"ajax" : {
				"url" : "/DASHBOARD/getEducationInformation?parentid="+ parentid,
				"dataSrc" : "dataBean",
				"type" : "GET",
				},
											"columns" : [
													{
														data : "parentid"
													},
													{
														data : "certificates"
													},
													{
														data : "institutionname"
													},
													{
														data : "address"
													},
													{
														data : "yearofpassing"
													},
													{
														data : "markspercentage"
													},

													{
														data : "remarks"
													},
													{
														data : "tranid"
													},
													{
														data : null,
														className : "center",
														defaultContent : ''
																+ '<a href="#" data-toggle="modal" data-target="#myModal1"><img src="resources/assets/images/edit-icon.png" height="15" width="15" id="educationid"    /></a> /  <input type="image" src="resources/assets/images/delete.png" id="deleteeducation" height="15" width="15"  onclick="forEducationDetailsDeletion()" >'
							} ],

				});

		});

function saveEducationDetails() {
	var tranid = document.getElementById("tranid").value;
	var saveEducation = {};
	saveEducation["parentid"] = $("#Epid").val();
	saveEducation["certificates"] = $("#certificates").val();
	saveEducation["institutionname"] = $("#institutionname").val();
	saveEducation["address"] = $("#Eduaddress").val();
	saveEducation["yearofpassing"] = $("#yearofpassing").val();
	saveEducation["markspercentage"] = $("#markspercentage").val();
	saveEducation["remarks"] = $("#Eduremarks").val();
	//
	if($("#Edutranid").val()== ""){
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "saveEducationDetails", // this is my servlet
			data : JSON.stringify(saveEducation),
			success : function(data) {
				$("#EducationDetailsDisplayMessage").html(data["successMessage"]);
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);
				
			}
		});
	}
	else{
		saveEducation["tranid"] = $("#Edutranid").val();
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "editEducationdetails", // this is my servlet
			data : JSON.stringify(saveEducation),
			success : function(data) {
				$("#EducationDetailsDisplayMessage").html(data["successMessage"]);
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);
				
			}
		});
		//
	}
	
}

	
function forEducationDetailsDeletion() {
	$("#education").on(
			'click',
			'#deleteeducation',
			function() {
				var currentRow = $(this).closest("tr");
				var institutename = currentRow.find("td:eq(2)").html();
				var tranid = currentRow.find("td:eq(7)").html();
				var retVal = confirm("would you like to delete this tranid "
						+ tranid + " and institutename is :" + institutename
						+ "?");
				if (retVal == true) {
					deletedSuccessfullyEducationDetail(tranid);
				} else {
				}
			});
}

function deletedSuccessfullyEducationDetail(tranid) {
	$.ajax({

		type : "post",
		contentType : "application/json",
		url : "deleteEducationDetails?tranid=" + tranid, // this is my
		// servlet
		success : function(data) {
			window.location.reload();
		}
	});

}

function educationEditPage() {
	var parenttranid = document.getElementById("tranid").value;

}

$("#education").on('click', '#educationid', function() {
	var currentRow = $(this).closest("tr");
	//var tranid = currentRow.find("td:eq(7)").html();
	$("#Edutranid").val(currentRow.find("td:eq(7)").html());
	$("#Eduremarks").val(currentRow.find("td:eq(6)").html());
	$("#markspercentage").val(currentRow.find("td:eq(5)").html());
	$("#yearofpassing").val(currentRow.find("td:eq(4)").html());
	$("#Eduaddress").val(currentRow.find("td:eq(3)").html());
	$("#institutionname").val(currentRow.find("td:eq(2)").html());
	$("#certificates").val(currentRow.find("td:eq(1)").html());
});
