<%@include file="header.jsp" %>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
<script>
$(document).ready(function(){
	    $("#jobstatuseditsucess").hide();
	    $("#savejobstatussuccess").hide();
	   
	});

function forjobDeletion(){
	 $("#jobstatus").on('click', '#deleteId', function() {
			var currentRow = $(this).closest("tr");
		    var jobstatusid = currentRow.find("td:eq(0)").html(); 
		    var retVal = confirm("would you like to delete this jobstatusid "+jobstatusid);
           if( retVal == true ) {
              deletedSuccessfully(jobstatusid);
           } else {
              //document.write ("User does not want to continue!");
           }
          
	 });
}
function deletedSuccessfully(jobstatusid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteJobstatus?jobstatusid="+jobstatusid, //this is my servlet
	        success: function(data){  
	        	$("#deletejobstatus").html("DeletedSucessFully");
	        	 setInterval(function(){
	 	        	window.location.reload(); // this will run after every 5 seconds
	 	        }, 2000);
	        }
	  });
}

</script>
<script>
	$("#jobstatus")
			.on('click','#myid',function() {
						var currentRow = $(this).closest("tr");
						var rowData = $("#jobstatus").DataTable().row(currentRow).data();
						var jobstatusid = rowData.jobstatusid;
						retrieve:true,
								$.ajax({contentType : "application/json",
											"url" : "/HRMS/getjobStatus?jobstatusid="+ jobstatusid,
											"dataSrc" : "dataBean",
											"type" : "GET",
											success : function(data) {
												for (var i = 0; i < data.length; i++) {
													$("#jobstatusid").val(data[i].jobstatusid);
													$("#Description ").val(data[i].description);
													$("#isactive").val(data[i].isactive);
												}
												selectedRecord = data;
											},

										});

						$('#editstatus_form').modal('show');

					});
	</script>
<script>
$(document).ready(function() {
	  // Edit record
   
	$('#jobstatus').dataTable( {
			 "ajax" : {
			"url" : "/HRMS/getjobstatus",
			"dataSrc" : "dataBean",
			"type" : "POST",
		
		       },
			"columns": [
							{ data: "jobstatusid"},
			 				{ data: "description"},
					 		{ data: "statusCodeForActive"},
 							
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="myid"    >   <input type="image" src="resources/assets/images/delete.png" id="deleteId" height="25" width="25"  onclick="forjobDeletion()">'
				            }
					],
		
		} );
	
} );
</script>
<script>
function saveJobStatus(){
	var savejobstatus = {};
	savejobstatus["description"] = $("#description").val();
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "saveNewjobstatus", //this is my servlet
	        data : JSON.stringify(savejobstatus),
	        success: function(data){ 
	        	 $("#savejobstatussuccess").show();
				 $("#jobstatusStrong").html(data["successMessage"]);
		           setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);
	        }
	 });
}
</script>
<script>
function jobEdit(){
	var jobEditData = {};
	jobEditData["jobstatusid"] = $("#jobstatusid").val();
	jobEditData["description"] = $("#Description").val();
	jobEditData["isactive"] = $("#isactive").val();
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editJobstatus", //this controller url
        data : JSON.stringify(jobEditData),
        success: function(data){  
        	 $("#jobstatuseditsucess").show();
			 $("#jobstatusEditStrong").html(data["successMessage"]);
	           setInterval(function(){
	        	window.location.reload(); // this will run after every 5 seconds
	        }, 2000);
        }
   
    });
   
}

</script>
<div>
<h5 align="center">
		To Add New Job Status <a data-toggle="modal"
			data-target="#newStatus"  href="#">ClickHere</a>
	</h5>
	<h5 align="center" id="deletejobstatus" style="color:red"></h5>
</div>
<table id="jobstatus" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		 <th>Jobstatusid</th>
                <th>Description</th>
                <th>Status</th>
                <th>Action</th>
                
            </tr>
        </thead>
       
    </table>
    
 <!--*************************************Save JobStatus Model box***************************************** -->
   
    <div class="modal fade" id="newStatus" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
			<div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" > Adding New JobStatus </h4>
		   </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div align="center">
			<div class="alert alert-success " id="savejobstatussuccess" style="text-align:center">
  		    <strong id="jobstatusStrong" ></strong> 
		    </div>
			</div>
       <form id="status_form">
			<div class="modal-body">
				<div class="box-content row">
				<div class="form-group has-warning col-sm-12">
					<label class="control-label" for="inputWarning1">Description</label>
					<input type="text" id="description" name="description" class="form-control">
				</div>
			</div>
			</div>
			
			<div class="modal-footer">
			<div class="container" align="center">
				<button type="button" class="btn btn-default btn-primary"  id="status_btn" >Submit</button>
			</div>
			</div>
			</form>
		</div>
		
		</div>
	</div>
	
	<!--**************************************** Edit JobStatus model box*************************************** -->
	
	<div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="editstatus_form" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="jobstatuseditsucess" style="text-align:center">
  		<strong id="jobstatusEditStrong" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5">JobStatus Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "edit_form">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="jobstatusid">JobStatusId</label>
						<input type="text" id="jobstatusid" name="jobstatusid" class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="Description">Description</label>
						<input type="text" id="Description" name="Description" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="inputWarning1">Status</label>
						<input type="text" id="isactive" name="isactive" class="form-control">
					</div>
					<div align="center">
					<button type="button"id="edit_btn" class="btn btn-primary" >
					Submit
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>
    
  <script src="resources/dist/js/sidebarmenu.js"></script>
 <%@include file="footer.jsp"%>
 <script src="resources/validation/bootstrapValidator.min.js"></script>

<script>
 $('#status_form').bootstrapValidator({
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
                  }
             }

         });
        $("#status_btn").click(function(){
$('#status_form').data('bootstrapValidator').validate();
if($('#status_form').data('bootstrapValidator').isValid()){
	saveJobStatus();
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
            	 isactive : {
                    validators: {
                        notEmpty: {
                            message: 'status is required ',
                         }, 
                       }
                 },
                 
                 Description: {
                     validators: {
                         notEmpty: {
                             message: 'Description is required ',
                          }, 
                        }
                  }
            }

         });
        $("#edit_btn").click(function(){
$('#edit_form').data('bootstrapValidator').validate();
if($('#edit_form').data('bootstrapValidator').isValid()){
	jobEdit();
}


});
        
</script>