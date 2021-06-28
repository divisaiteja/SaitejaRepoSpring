<%@include file="header.jsp" %>
 <script src="resources/validation/bootstrapValidator.min.js"></script>
  <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
 <script>
 $(document).ready(function(){
	   // $("#warnings").hide();
	    $("#savesuccess").hide();
	    $("#successinedit").hide();
	   
	});
 </script>
<script>
	$(document).ready(function() {
		$('#project').dataTable({
				"ajax" : {
				"url" : "/HRMS/getProjectInformation",
				"dataSrc" : "dataBean",
				"type" : "GET",

				},
			"columns" : [
					{
						data : "tranid"
		            },
		            {
						data : "projectcode"
					},
					{
						data : "projectname"
					},
					{
						data : "statusCodeForActive"
					},
					{
						data : null,
						className : "center",
						defaultContent : '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="projectedit" >   <input type="image" src="resources/assets/images/delete.png" id="projectdelete" height="25" width="25"  onclick="projectDeletion()">'								
					} ],

										});

					});
</script>
<script>
	$("#project").on('click','#projectedit',function() {	
	var currentRow = $(this).closest("tr");
	var rowData = $("#project").DataTable().row(currentRow).data();
	var tranid = rowData.tranid;
	retrieve:true,					
					
	$.ajax({
			contentType : "application/json",
			"url" : "/HRMS/getProjectInfoByTranid?tranid="+ tranid,
					"dataSrc" : "dataBean",
					"type" : "GET",

					success : function(data) {
					for (var i = 0; i < data.length; i++) {
					$("#tranid").val(data[i].tranid);
				    $("#projectcode").val(data[i].projectcode);
					$("#projectname ").val(data[i].projectname);
					$("#isactive").val(data[i].isactive);

					}

					selectedRecord = data;

							},

					});

						$('#projectModalEdit').modal('show');

					});
	</script>
	<script>
	function projectDeletion(){
		 $("#project").on('click', '#projectdelete', function() {
				var currentRow = $(this).closest("tr");
			    var tranid = currentRow.find("td:eq(0)").html(); 
			    var retVal = confirm("would you like to delete this tranid "+tranid);
	           if( retVal == true ) {
	              deletedSuccessfully(tranid);
	           } else {

	           }
	         
		 });
	}

	function deletedSuccessfully(tranid){
		 $.ajax({
		        type: "post",
		        contentType : "application/json",
		        url: "deleteProject?tranid="+tranid, //this is my servlet
		        success : function(data) {
		        	$("#deletemessage").html("DeletedSucessFully");
		        	 setInterval(function(){
		 	        	window.location.reload(); // this will run after every 5 seconds
		 	        }, 2000);
				}
		        
		  });
	}
</script>
<script>
function editProjects(){
				var editproject = {};
				var tranid = document.getElementById("tranid").value;
				editproject["tranid"] = $("#tranid").val();
			    editproject["projectcode"] = $("#projectcode").val();
				editproject["projectname"] = $("#projectname").val();
				editproject["isactive"] = $("#isactive").val();

						$.ajax({
							type : "post",
							contentType : "application/json",
							url : "editProject", //this is my servlet
							data : JSON.stringify(editproject),
							success : function(data) {
								 $("#successinedit").show();
					        	 $("#successmsginedit").html(data["successMessage"]);
					        	setInterval(function(){
						        	window.location.reload(); // this will run after every 5 seconds
						        }, 2000);
							}
						});
	
}
	
</script>
<script>
function saveProject(){
		var saveProject = {};
		saveProject["projectcode"] = $("#saveprojectcode").val();
		saveProject["projectname"] = $("#saveprojectname").val();
		
		$.ajax({
			type: "post",
			contentType : "application/json",
			url: "projectSave", //this is my servlet
			data : JSON.stringify(saveProject),
			success: function(data){ 
				$("#savesuccessmsg").html(data["successMessage"]);
				$("#savesuccess").show();	
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);

			}
		});
	}

</script>
	<div>
	<h5 align="center">To Add New Project <a data-toggle="modal"
			data-target="#myModal" id="projectid" onclick="" href="#">ClickHere</a>
	</h5>
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>
	<table id="project" class="display" style="width: 100%" border="1">
		<thead>
			<tr>
				<th>TranId</th>
				<th>ProjectCode</th>
				<th>ProjectName</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
	</table>
	
<!-- ****************************edit projects model************************************ -->
	           
	           
	            <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="projectModalEdit" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="successinedit" style="text-align:center">
  		<strong id="successmsginedit" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Projects Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "projectvalidation">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="tranid">TranId</label>
						<input type="text" id="tranid" name="tranid" class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="projectcode">ProjectCode</label>
						<input type="text" id="projectcode" name="projectcode" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="inputWarning1">ProjectName</label>
						<input type="text" id="projectname" name="projectname" class="form-control">
					</div>
	           
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">Status</label>
						<input type = "text"  id="isactive" name="isactive" class="form-control">
					
					</div>
					<div align="center">
					<button type="button"id="submitproject" class="btn btn-primary" >
						Submit 
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>
    
	             
	             

 <!--******************************save projects model********************************** -->
          
          
<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
			<div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" > Adding New Projects </h4>
		   </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="alert alert-success " id="savesuccess" style="text-align:center">
  	         <strong id="savesuccessmsg" ></strong> 
  	         </div>
<form id="saveprojectvalidation">
			<div class="modal-body">
				<div class="box-content row">
						<div class="form-group has-warning col-md-6">
						<label class="control-label" for="inputWarning1">ProjectCode</label> <input
							type="text" id="saveprojectcode" name="saveprojectcode"  class="form-control">
					</div>
					<div class="form-group has-warning col-md-6">
						<label class="control-label" for="inputWarning1">ProjectName</label>
						<input type="text" id="saveprojectname" name="saveprojectname"  class="form-control">
					</div>
				</div>   
			</div>
			<div class="modal-footer">
			<div class="container" align="center">
				<button type="button" class="btn btn-default"  id="submitsaveproject">Submit</button>
			</div>
			</div>
			</form>
		</div>	
	</div>
	</div>
<script src="resources/dist/js/sidebarmenu.js"></script>
<%@include file="footer.jsp"%>
<script src="resources/validation/bootstrapValidator.min.js"></script>

<script>
		$('#projectvalidation').bootstrapValidator({
			//container: '#messages',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				projectcode : {
					validators : {
						notEmpty : {
							message : 'Project Code required ',
						},
					}
				},

				projectname : {
					validators : {
						notEmpty : {
							message : 'Project Name required ',
						},
					}
				},	
				isactive : {
					validators : {
						notEmpty : {
							message : 'IsActive required ',
						},
					}
				}
			}
		});

$("#submitproject").on("click", function(){
$('#projectvalidation').data('bootstrapValidator').validate();
if($('#projectvalidation').data('bootstrapValidator').isValid()){
	editProjects();
}

});
</script>
<script>
 $('#saveprojectvalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	 saveprojectcode: {
                     validators: {
                         notEmpty: {
                             message: 'Project Code required ',
                          },
                        }
                  },
			 
                  saveprojectname: {
                     validators: {
                         notEmpty: {
                             message: 'Project Name required ',
                          },
                        }
                  }
             }

         });
 
$("#submitsaveproject").on("click", function(){
$('#saveprojectvalidation').data('bootstrapValidator').validate();
if($('#saveprojectvalidation').data('bootstrapValidator').isValid()){
	saveProject();
}
});
</script>
