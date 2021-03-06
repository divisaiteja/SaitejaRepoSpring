
	$(document).ready(function() {
		var parentid = document.getElementById("idNumber").value;
		$('#family').dataTable(
		{
		"ajax" : {
	"url" : "/DASHBOARD/getFamilyInformation?parentid="+ parentid,		
	"dataSrc" : "dataBean",
	"type" : "GET",
},
	"columns" : [
	{data : "parentid"},
	{data : "gender"},	
	{data : "name"},
	{data : "relation"},
	{data : "dob"},
	{data : "adhaarno"},
	{data : "qualification"},
    {data : "occupation"},
    {data : "mobileno"},
    {data : "tranid"},
    {data : null,
	className : "center",
   defaultContent : ''
         + ' <a href="#" data-toggle="modal" data-target="#myModal2"> <img src="resources/assets/images/edit-icon.png" height="15" width="15" id="familyid"> </a>/  <input type="image" src="resources/assets/images/delete.png" id="deletefamily" height="15" width="15"  onclick="forFamilyDetailsDeletion()" >'
      } ],
     });
   });


function saveFamilyDetails() {
	
	var saveFamilyDetails = {};
	var tranid = document.getElementById("tranid").value;
	// var pid=document.getElementById("pid").value;
	saveFamilyDetails["parentid"] = $("#familyidnumber").val();
	saveFamilyDetails["gender"] = $("#familygender").val();
	saveFamilyDetails["name"] = $("#name").val();
	saveFamilyDetails["relation"] = $("#relation").val();
	saveFamilyDetails["dob"] = $("#dob").val();
	saveFamilyDetails["adhaarno"] = $("#adhaarno").val();
	saveFamilyDetails["qualification"] = $("#familyqualification").val();
	saveFamilyDetails["occupation"] = $("#occupation").val();
	saveFamilyDetails["mobileno"] = $("#mobileno").val();
	if($("#familytranid").val() == ""){
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "saveFamilyDetails", // this is my servlet
			data : JSON.stringify(saveFamilyDetails),
			success : function(data) {
				$("#FamilyDetailsDisplayMessage").html(data["successMessage"]);
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);
			}
		});
	}
	else{
		saveFamilyDetails["tranid"] = $("#familytranid").val();
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "editFamilydetails", // this is my servlet
			data : JSON.stringify(saveFamilyDetails),
			success : function(data) {
				$("#FamilyDetailsDisplayMessage").html(data["successMessage"]);
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);
			}
		});
	}
	
	
	
}




function forFamilyDetailsDeletion() {

	$("#family").on('click','#deletefamily',function() {
				var currentRow = $(this).closest("tr");
				var name = currentRow.find("td:eq(2)").html();
				var tranid = currentRow.find("td:eq(9)").html();

				var retVal = confirm("would you like to delete this tranid "
						+ tranid + " and relationname is :" + name + "?");
				if (retVal == true) {
					deletedSuccessfullyFamilyDetails(tranid);
				} else {
					document.write("User does not want to continue!");
				}
				// familysave();

			});
}

function deletedSuccessfullyFamilyDetails(tranid) {
	$.ajax({

		type : "post",
		contentType : "application/json",
		url : "deleteFamilyDetails?tranid=" + tranid, // this is my servlet
		success : function(data) {
			window.location.reload();
		}
	});

}

function familyEditPage() {
	var parenttranid = document.getElementById("tranid").value;

}

$("#family").on('click', '#familyid', function() {
	var currentRow = $(this).closest("tr");
	var tranid = currentRow.find("td:eq(9)").html();
	$("#gender").val(currentRow.find("td:eq(1)").html());
	$("#name").val(currentRow.find("td:eq(2)").html());
	$("#relation").val(currentRow.find("td:eq(3)").html());
	$("#dob").val(currentRow.find("td:eq(4)").html());
	$("#adhaarno").val(currentRow.find("td:eq(5)").html());
	$("#familyqualification").val(currentRow.find("td:eq(6)").html());
	$("#occupation").val(currentRow.find("td:eq(7)").html());
	$("#mobileno").val(currentRow.find("td:eq(8)").html());
	$("#familytranid").val(currentRow.find("td:eq(9)").html());
});
