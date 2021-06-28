	
	$(document).ready(function() {
		var parentid = document.getElementById("idNumber").value;
				$('#experience').dataTable(
								
										{

											"ajax" : {
												"url" : "/DASHBOARD/getExperienceInformation?parentid="
														+ parentid,
												"dataSrc" : "dataBean",
												"type" : "GET",

											},
											"columns" : [
													{
														data : "parentid"
													},
													{
														data : "employeename"
													},
													{
														data : "address"
													},
													{
														data : "workperiod"
													},
													{
														data : "experiencedetails"
													},
													{
														data : "designation"
													},
													{
														data : "ctc"
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
																+ '<a href="#" data-toggle="modal" data-target="#myModal"> <img src="resources/assets/images/edit-icon.png" height="15" width="15" id="experienceid"   > </a> /  <input type="image" src="resources/assets/images/delete.png" id="deleteId" height="15" width="15"  onclick="forexperienceDetailsDeletion()" >'
													} ],

										});

					});

function saveExperince() {
	var tranid = document.getElementById("tranid").value;
	var saveExperience = {};
	saveExperience["parentid"] = $("#Expid").val();
	saveExperience["employeename"] = $("#employeename").val();
	saveExperience["address"] = $("#address").val();
	saveExperience["workperiod"] = $("#workperiod").val();
	saveExperience["experiencedetails"] = $("#experiencedetails").val();
	saveExperience["designation"] = $("#designation").val();
	saveExperience["ctc"] = $("#Experiencectc").val();
	saveExperience["remarks"] = $("#remarks").val();
	if($("#Exptranid").val()==""){
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "saveExperienceDetails", // this is my servlet
			data : JSON.stringify(saveExperience),
			success : function(data) {
				$("#ExperiencedetailsDisplayMessage").html(data["successMessage"]);
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);
			}
		});
	}
	else{
		saveExperience["tranid"] = $("#Exptranid").val();
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "editExperiencedetails", // this is my servlet
			data : JSON.stringify(saveExperience),
			success : function(data) {
				$("#ExperiencedetailsDisplayMessage").html(data["successMessage"]);
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);
			}
		});
	}
	
	
}




	
function forexperienceDetailsDeletion() {
	$("#experience").on(
			'click',
			'#deleteId',
			function() {
				var currentRow = $(this).closest("tr");
				var tranid = currentRow.find("td:eq(8)").html();
				var employeename = currentRow.find("td:eq(1)").html();

				var retVal = confirm("would you like to delete this tranId "
						+ tranid + " and username is :" + employeename + "?");
				if (retVal == true) {
					deletedSuccessfully(tranid);
				} else {
				}
				expsave();
			});
}

// use this function for delete the record from the table
function deletedSuccessfully(tranid) {
	$.ajax({
		type : "post",
		contentType : "application/json",
		url : "deleteExperienceDetails?tranid=" + tranid, // this is my
		// servlet
		success : function(data) {

		}
	});

}

function experienceEditPage() {
	var parenttranid = document.getElementById("tranid").value;

}
$("#experience").on('click', '#experienceid', function() {
	var currentRow = $(this).closest("tr");
	//var tranid = currentRow.find("td:eq(8)").html();
	$("#employeename").val(currentRow.find("td:eq(1)").html());
	$("#address").val(currentRow.find("td:eq(2)").html());
	$("#workperiod").val(currentRow.find("td:eq(3)").html());
	$("#experiencedetails").val(currentRow.find("td:eq(4)").html());
	$("#designation").val(currentRow.find("td:eq(5)").html());
	$("#Experiencectc").val(currentRow.find("td:eq(6)").html());
	$("#remarks").val(currentRow.find("td:eq(7)").html());
	$("#Exptranid").val(currentRow.find("td:eq(8)").html());
});

