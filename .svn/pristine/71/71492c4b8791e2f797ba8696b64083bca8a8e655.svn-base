<%@include file="header.jsp" %>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
<script>
$(document).ready(function(){
	   // $("#warnings").hide();
	    $("#savesuccess").hide();
	    $("#empstatusedit").hide();
	   
	});
	
function saveEmpStatus(){
	var saveempstatus = {};
	saveempstatus["description"] = $("#description").val();
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "saveNewEmpstatus", //this is my servlet
	        data : JSON.stringify(saveempstatus),
	        success: function(data){ 
	        	$("#successmsg").html(data["successMessage"]);
	        	 $("#savesuccess").show();
				 setInterval(function(){
			        	window.location.reload(); // this will run after every 5 seconds
			     }, 2000); 
				
	        }
	 });
} 
</script>
<script>
function EmpstatusDeletion(){
	 $("#empstatus").on('click', '#statusdeleteId', function() {
			var currentRow = $(this).closest("tr");
		    var empstatusid = currentRow.find("td:eq(0)").html(); 
		    var retVal = confirm("would you like to delete this empstatusid "+empstatusid);
           if( retVal == true ) {
            //  document.write ("User wants to continue!");
              deletedSuccessfully(empstatusid);
           } else {
              //document.write ("User does not want to continue!");
           }
           empstatus();
	 });
}

function deletedSuccessfully(empstatusid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteEmpStatus?empstatusid="+empstatusid, //this is my servlet

	        success: function(data){  
	        	$("#delejobstatus").html("DeletedSucessFully");
	        	 setInterval(function(){
	 	        	window.location.reload(); // this will run after every 5 seconds
	 	        }, 2000);
	        }
	  });
}
</script>
<script>
$(document).ready(function() {
	$('#empstatus').dataTable( {
			 "ajax" : {
			"url" : "/HRMS/getEmpStatus",
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
			"columns": [
							{ data: "empstatusid"},
			 				{ data: "description"},
					 		{ data: "statusCodeForActive"},
 							
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="myidstatus">   <input type="image" src="resources/assets/images/delete.png" id="statusdeleteId" height="25" width="25"  onclick="EmpstatusDeletion()">'
				                
				            }
					],
		
		} );
	
} );
</script>
<script>
$("#empstatus")
		.on('click','#myidstatus',function() {
					var currentRow = $(this).closest("tr");
					var rowData = $("#empstatus").DataTable().row(currentRow).data();
					var empstatusid = rowData.empstatusid;
					retrieve:true,
							$.ajax({contentType : "application/json",
										"url" : "/HRMS/employeStatusByStatusId?empstatusid="+ empstatusid,
										"dataSrc" : "dataBean",
										"type" : "GET",
										success : function(data) {
											for (var i = 0; i < data.length; i++) {
												$("#empstatusid").val(data[i].empstatusid);
												$("#EmpDescription ").val(data[i].description);
												$("#isactive").val(data[i].isactive);
											}
											selectedRecord = data;
										},

									});

					$('#editempstatus_form').modal('show');

				});
</script>
<script>
function editEmployeeStatus(){
	var editEmployeeStatus = {};
	editEmployeeStatus["empstatusid"] = $("#empstatusid").val();
	editEmployeeStatus["description"] = $("#EmpDescription").val();
	editEmployeeStatus["isactive"] = $("#isactive").val();
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editEmpstatus", //this controller url
        data : JSON.stringify(editEmployeeStatus),
        success: function(data){ 
        	 $("#empstatusedit").show();
        	 $("#successmsginedit").html(data["successMessage"]);
			 setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		     }, 2000); 
        }
    });
}
</script>
<div>
<h5 align="center">
		To Add New EmplyeeStatus  <a data-toggle="modal"
			data-target="#newEmpStatus" href="#">ClickHere</a>
	</h5>
	<h5 align="center" id="delejobstatus" style="color:red"></h5>
	
</div>
<table id="empstatus" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		 <th>Empstatusid</th>
                <th>Description</th>
                <th>Status</th>
                
              	<th>Action</th>
                
            </tr>
        </thead>
       
    </table>
    
    
<!-- ********Employee Status save Modal******* -->
     
   <div class="modal fade" id="newEmpStatus" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
			<div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" >Adding New EmployeeStatus </h4>
		   </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="alert alert-success " id="savesuccess" style="text-align:center">
  	<strong id="successmsg" ></strong> 
	</div>
       <form id="emp_status_form">
			<div class="modal-body">
				<div class="box-content row">
				
				<div class="form-group has-warning col-md-12">
					<label class="control-label" for="inputWarning1">Description</label>
					<input type="text" id="description" name="description" class="form-control" placeholder="">
				</div>
				

			</div>
			</div>
			
			<div class="modal-footer">
			<div class="container" align="center">
				<button type="button" class="btn btn-default"  id="emp_status_btn" >Submit</button>
			</div>
			</div>
			</form>
		</div>
		
		</div>
	</div>
	
	 <!-- ********Employee Status Edit Modal******* -->
	 
	 <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="editempstatus_form" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="empstatusedit" style="text-align:center">
  		<strong id="successmsginedit" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5">Employee Status Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "editemp_status_form">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="gradeno">EmpStatusid</label>
						<input type="text" id="empstatusid" name="empstatusid" class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="inputWarning1">Description</label>
						<input type="text" id="EmpDescription" name="EmpDescription" class="form-control">
					</div>
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">Status</label>
						<input type = "text" id="isactive" name="isactive" class="form-control">
					
					</div>
					<div align="center">
					<button type="button"id="emp_edit_btn" class="btn btn-primary" >
						Submit 
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>
	
  <script src="resources/validation/bootstrapValidator.min.js"></script>
<script>
 $('#emp_status_form').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
             
				  description: {
                     validators: {
                         notEmpty: {
                             message: 'description is required ',
                          },
                        }
                  },
             }
         });
        $("#emp_status_btn").click(function(){
$('#emp_status_form').data('bootstrapValidator').validate();
if($('#emp_status_form').data('bootstrapValidator').isValid()){
	saveEmpStatus();
}
});
</script>

<script>
$('#editemp_status_form').bootstrapValidator({
    //container: '#messages',
     feedbackIcons: {
         valid: 'glyphicon glyphicon-ok',
         invalid: 'glyphicon glyphicon-remove',
         validating: 'glyphicon glyphicon-refresh'
     },
     fields: {
		  EmpDescription: {
             validators: {
                 notEmpty: {
                     message: 'description is required ',
                  },
                }
          },
          isactive: {
              validators: {
                  notEmpty: {
                      message: 'IsActive is required ',
                   },
                 }
           },
     }

 });
$("#emp_edit_btn").click(function(){
$('#editemp_status_form').data('bootstrapValidator').validate();
if($('#editemp_status_form').data('bootstrapValidator').isValid()){
	editEmployeeStatus();
}
});
</script>
 <script src="resources/dist/js/sidebarmenu.js"></script>
  
 <%@include file="footer.jsp"%>