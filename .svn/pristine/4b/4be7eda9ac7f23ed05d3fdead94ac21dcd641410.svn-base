<%@include file="header.jsp" %>
<script>
$(document).ready(function() {
$('#employees').DataTable();
});

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallproject", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('project');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["tranid"] + '">'
						+ abc[i]["projectname"] + '</option>';
			}

		}
	});
});

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallDivision", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('division');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
			ele.innerHTML = ele.innerHTML + '<option value="'+ abc[i]["divisionid"] + '">' + abc[i]["name"]+ '</option>';								
			
			}

		}
	});
});



</script>
<script>
function onChangeEmployeeInformation() {
	 var project=document.getElementById("project").value;
	 var division=document.getElementById("division").value;
	
   	$('#employees').dataTable( {
	   "destroy" : true,
			 "ajax" : {
			"url" : "/HRMS/getAppraisalsEmployeeInformation?project="+project+"&&division="+division,
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
			"columns": [
							{ data: "tranId"},
			 				{ data: "idNumber"},
					 		{ data: "employeeName"},
 							{ data: "dateOfJoining"},
							{ data: "statusCodeForActive"},
							{ data: "hrDepartmentMaster.name"},
							{ data: "divisiondto.name"},
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/rupee.png" height="20" width="20" id="myid"  onclick="fetchToModal()"  > '
				            }
					],
		
		} );
	
} 
</script>
<script>

function fetchToModal() {
    $("#employees").on('click', '#myid', function() {
        var currentRow = $(this).closest("tr");
        var tranid = currentRow.find("td:eq(0)").html();
        var rowData = $("#employees").DataTable().row(currentRow).data();
		var idNumber = rowData.idNumber;
        window.location.href = "#/appraisals/" + tranid+"/"+ idNumber
    });
}
</script>

 <div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
			   <h3 align="center" style="color: #fb8c00">EmployeeListingPage</h3>
            </div>
			<div class="box-content row">
				<div class="form-group has-warning col-md-3">
					<label style="color: Blue" class="control-label" for="inputWarning1">Division
						</label> <select class="form-control" id="division" name="division " >
						<option value="">select</option>
					</select>
			</div>
			<div class="form-group has-warning col-md-3">
					<label  style="color: Blue"  class="control-label" for="inputWarning1">Project</label><br>
					<select class="form-control" id="project" name="project">
						<option value="">select</option>

					</select>
			</div>				
			</div>
			<div align="center">
			       <input type="submit"  value="Show" onclick="onChangeEmployeeInformation()" style="background-color: blue;color:white"	class="btn btn-primary"   >
		    </div>
		</div>
	</div>
</div>
<table id="employees" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		<th>tranId</th>
                <th>idNumber</th>
                <th>employeeName</th>
                <th>dateOfJoining</th>
                <th>employeeStatus</th>
                <th>Department</th>
                <th>Division</th>
              	<th>Increments</th>
                
            </tr>
        </thead>
</table>
    <!-- Modal -->
          <div id="a"> 
</div>  
<script src="resources/dist/js/sidebarmenu.js"></script> 
<%@include file="footer.jsp"%>