<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="header.jsp"%>
	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
<script>
$(document).ready(function(){
	   // $("#warnings").hide();
	    $("#jobtypesavesuccess").hide();
	    $("#jobtypeEditsuccess").hide();
	   
	});
</script>
<script>
	$(document).ready(function(){
		$('#jobtype').dataTable({
							"ajax" : {
							"url" : "/HRMS/getjobtype",
							"dataSrc" : "dataBean",
							"type" : "GET",
							},
							"columns" : [{data : "tranid"},
										{data : "jobTypeCode"},
										{data : "jobDescription"},
									   {data : "statusCodeForActive"},
										{
									     	data : null,
											className : "center",
											defaultContent : '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="JobtypeEditing" >   <input type="image" src="resources/assets/images/delete.png" id="JobtypeDelete" height="25" width="25"  onclick="JobTypeDeletion()">'
													} ],
										});
					});
</script>
<script>
	$("#jobtype").on('click','#JobtypeEditing',function() {
		var currentRow = $(this).closest("tr");
		var rowData = $("#jobtype").DataTable().row(currentRow).data();
		var tranid = rowData.tranid;
		retrieve:true,
		$.ajax({
	contentType : "application/json",
	"url" : "/HRMS/getjobType?tranid="+ tranid,
	"dataSrc" : "dataBean",
	"type" : "GET",
	success : function(data) {
	for (var i = 0; i < data.length; i++) {
	$("#tranid").val(data[i].tranid);
	$("#jobtypecode").val(data[i].jobTypeCode);
	$("#jobdescription ").val(data[i].jobDescription);
	$("#isactive").val(data[i].isactive);
}

	selectedRecord = data;
},
});
$('#JobTypeModal').modal('show');

	});
	</script>
	<script>
	function JobTypeDeletion(){
		 $("#jobtype").on('click', '#JobtypeDelete', function() {
				var currentRow = $(this).closest("tr");
			    var tranid = currentRow.find("td:eq(0)").html(); 
			    var retVal = confirm("would you like to delete this tranid "+tranid);
	           if( retVal == true ) {
	            //  document.write ("User wants to continue!");
	              deletedSuccessfully(tranid);
	           } else {
	              //document.write ("User does not want to continue!");
	           }
	         
		 });
	}

	function deletedSuccessfully(tranid){
		 $.ajax({
		        type: "post",
		        contentType : "application/json",
		        url: "deletejobtype?tranid="+tranid, //this is my servlet
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
function editjobtype(){
					
						var editjobtype = {};
						var tranid = document.getElementById("tranid").value;
						editjobtype["tranid"] = $("#tranid").val();
						editjobtype["jobTypeCode"] = $("#jobtypecode").val();
						editjobtype["jobDescription"] = $("#jobdescription").val();
						editjobtype["statusCodeForActive"] = $("#isactive").val();
						$.ajax({
							type : "post",
							contentType : "application/json",
							url : "editJobType", //this is my servlet
							data : JSON.stringify(editjobtype),
							success : function(data) {
								 $("#jobtypeEditstrong").html(data["successMessage"]);
								 $("#jobtypeEditsuccess").show();
							        setInterval(function(){
							        	window.location.reload(); // this will run after every 5 seconds
							        }, 2000);
							}
						});

				}
	
</script>
<script>
function savejobType(){
		var savejobtype = {};
		savejobtype["jobTypeCode"] = $("#savejobtypecode").val();
		savejobtype["jobDescription"] = $("#savejobdescription").val();
		
		$.ajax({
			type: "post",
			contentType : "application/json",
			url: "saveJobType", //this is my servlet
			data : JSON.stringify(savejobtype),
			success: function(data){ 
		        $("#jobtypeStrong").html(data["successMessage"]);
		    	$("#jobtypesavesuccess").show();
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);
			}
		});
	}

</script>

</head>
<body>
	<div>
	<h5 align="center">
		To Add New JobType <a data-toggle="modal"
			data-target="#myModal"  href="#">Click
			Here</a>
	</h5>
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>
	<table id="jobtype" class="display" style="width: 100%" border="1">
		<thead>
			<tr>
				<th>Tranid</th>
				<th>JobTypeCode</th>
				<th>JobDescription</th>
				<th>Status</th>
				<th>Action</th>

			</tr>
		</thead>
	</table>
	
<!--***************************** Edit JobType model box *******************************-->
	
	
	 <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="JobTypeModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="jobtypeEditsuccess" style="text-align:center">
  		<strong id="jobtypeEditstrong" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5">JobType Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "jobtypevalidation">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="tranid">TranId</label>
						<input type="text" id="tranid" name="tranid" class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="jobtypecode">JobTypeCode</label>
						<input type="text" id="jobtypecode" name="jobtypecode" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="inputWarning1">jobDescription</label>
						<input type="text" id="jobdescription" name="jobdescription" class="form-control">
					</div>
	    

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">Status</label>
						<input type = "text"  id="isactive" name="isactive" class="form-control">
					
					</div>
					<div align="center">
					<button type="button"id="submitjobtype" class="btn btn-primary" >
					Submit
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>
    
	

<!-- ***************************** save jobtype model box ************************** -->

<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			<div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" >Adding New JobType </h4>
		   </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div align="center">
			<div class="alert alert-success " id="jobtypesavesuccess" style="text-align:center">
  	           <strong id="jobtypeStrong" ></strong> 
	            </div>
	            </div>
<form id="savejobtypevalidation">
			<h3 align="center" style="color: green" id="jobtypedisplaymsg"></h3>

			<div class="modal-body">
				<div class="box-content row">
					<!-- <div class="form-group has-warning col-md-3">
						<label class="control-label" for="inputWarning1">ParentID</label>
						<input type="text" id="parentid" class="form-control">
					</div> -->
						
					
					<div class="form-group has-warning col-md-6">
						<label class="control-label" for="inputWarning1">JobTypeCode</label> <input
							type="text" id="savejobtypecode" name="savejobtypecode"  class="form-control">
					</div>

					<div class="form-group has-warning col-md-6">
						<label class="control-label" for="inputWarning1">JobDescription</label>
						<input type="text" id="savejobdescription" name="savejobdescription"  class="form-control">
					</div>
				</div>
                 
			</div>
			
			<div class="modal-footer">
			<div class="container" align="center">
				<button type="button" class="btn btn-default"  id="submitsavejobtype">Submit</button>
			</div>
			</div>
			</form>
		</div>
		
		
	</div>
	</div>

<script src="resources/validation/bootstrapValidator.min.js"></script>

<script>
 $('#jobtypevalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
             jobtypecode: {
                     validators: {
                         notEmpty: {
                             message: 'jobtypecode required ',
                          },
                        }
                  },
			 
			 jobdescription: {
                     validators: {
                         notEmpty: {
                             message: 'jobdescription required ',
                          },
                        }
                  },
                  isactive: {
                      validators: {
                          notEmpty: {
                              message: 'IsActive required ',
                           },
                         }
                   }

             }

         });
</script>
<script>

$("#submitjobtype").on("click", function(){

$('#jobtypevalidation').data('bootstrapValidator').validate();
if($('#jobtypevalidation').data('bootstrapValidator').isValid()){
	editjobtype();
}

});
</script>
<script>
 $('#savejobtypevalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	 savejobtypecode: {
                     validators: {
                         notEmpty: {
                             message: 'jobtypecode required ',
                          },
                        }
                  },
			 
			savejobdescription: {
                     validators: {
                         notEmpty: {
                             message: 'jobdescription required ',
                          },
                        }
                  },
			

             }

         });
</script>
<script>

$("#submitsavejobtype").on("click", function(){

$('#savejobtypevalidation').data('bootstrapValidator').validate();
if($('#savejobtypevalidation').data('bootstrapValidator').isValid()){
	savejobType();
}

});
</script>
</body>
	<script src="resources/dist/js/sidebarmenu.js"></script>

<%@include file="footer.jsp"%>
</html>