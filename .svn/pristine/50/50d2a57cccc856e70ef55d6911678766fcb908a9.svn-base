<%@include file="header.jsp" %>

<script>


function saveUserLoginDetails(){
	var saveUserLoginDetails = {};
	
	saveUserLoginDetails["idno"] = $("#idno").val();
	saveUserLoginDetails["email"] = $("#email").val();
	saveUserLoginDetails["password"] = $("#password").val();
	
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "saveUserDetails", //this is my servlet
	        data : JSON.stringify(saveUserLoginDetails),
	        success: function(data){ 
	        	
	        }
	 });
}



function forDeletion(){
	 $("#employees").on('click', '#deleteId', function() {
			var currentRow = $(this).closest("tr");
		    var tranid = currentRow.find("td:eq(0)").html(); 
		    var name = currentRow.find("td:eq(2)").html(); 
		    var retVal = confirm("would you like to delete this userId "+tranid+" and username is :"+name+"?");
            if( retVal == true ) {
             //  document.write ("User wants to continue!");
               deletedSuccessfully(tranid);
            } else {
               //document.write ("User does not want to continue!");
            }
            empinfo();
	 });
}

function deletedSuccessfully(tranid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteEmployee?tranid="+tranid, //this is my servlet
//	         data: {
//	             visitorname: $('#visitorname').val(),
//	         },
	        success: function(data){  
	        	
	        }
	  });
}

function fetchToModal() {
    $("#employees").on('click', '#myid', function() {
        var currentRow = $(this).closest("tr");
        var tranid = currentRow.find("td:eq(0)").html();
        var rowData = $("#employees").DataTable().row(currentRow).data();
		var idNumber = rowData.idNumber;
        window.location.href = "#/employee/" + tranid+"/"+ idNumber
    });
}

 
</script>

<script>

$(document).ready(function() {
	
   
	$('#employees').dataTable( {
			 "ajax" : {
			"url" : "/DASHBOARD/getEmployeeInformation",
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
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="15" width="15" id="myid"  onclick="fetchToModal()"  > / <input type="image" src="resources/assets/images/delete.png" id="deleteId" height="15" width="15"  onclick="forDeletion() "> /   <input type="image" src="resources/assets/images/usericon.png" height="15" width="15"   data-toggle="modal" data-target="#myModal" onclick=""  >'
				            }
					],
		
		} );
	
} );




</script>

<div><h5>To Add New Employee <a href="#/jobDetails" >Click Here</a></H5></div>
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
              	<th>Edit / Delete / UserReg</th>
                
            </tr>
        </thead>
       
    </table>
    
    
     <!-- Modal -->
          <div id="a">
     
  
  </div>
  
  <!--   UserRegistration Modal box  Starting-->
  
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
		
			<div class="modal-header">
			<h3 style="color: #FF00FF">User Registration</h3>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
 
			<div class="modal-body" align="center">
			
					 <div class="form-group has-warning col-md-8">
						<label  style="color: Blue" class="control-label" for="inputWarning1">Idno</label>
						<input type="text" id="idno" class="form-control">
					</div> 
						
					
					
					<div class="form-group has-warning col-md-8">
						<label  style="color: Blue" class="control-label" for="inputWarning1">EmailID</label> <input
							type="text" id="email" class="form-control">
					</div>

					<div class="form-group has-warning col-md-8">
						<label style="color: Blue" class="control-label" for="inputWarning1">Password</label>
						<input type="password" id="password" class="form-control">
					</div>


					
				</div>

			
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal"
					onclick="saveUserLoginDetails()">Submit</button>
			</div>
			</div>
		</div>
	</div>

<!--   UserRegistration Modal box  ending-->
  <script src="resources/dist/js/sidebarmenu.js"></script>
  
  
  <%@include file="footer.jsp"%>