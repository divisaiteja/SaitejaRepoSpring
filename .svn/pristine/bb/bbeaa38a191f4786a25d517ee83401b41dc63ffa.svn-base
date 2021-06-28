<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="header.jsp"%>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
<title>JobtypeList</title>
<script>
 $(document).ready(function(){
	   // $("#warnings").hide();
	    $("#savesuccess").hide();
	    $("#successinedit").hide();
	   
	});
 </script>
<script>
	$(document).ready(function() {
      $('#departmenttable').dataTable({
						"ajax" : {
						"url" : "/HRMS/getdepartment",
						"dataSrc" : "dataBean",
						"type" : "GET",
							},
						"columns" : [
								{
									data : "deptId"
								},
								{
									data : "name"
								},
								{
									data : "shortName"
								},
								{
									data : "costCenterId"
								},
								{
									data : "statusCodeForActive"
								},
								{
									data : null,
									className : "center",
									defaultContent : '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="departmentediting" >   <input type="image" src="resources/assets/images/delete.png" id="departmentdelete" height="25" width="25"  onclick="DepartmentDeletion()">'
								} ],
										});
					});
</script>
<script>
	$("#departmenttable").on('click','#departmentediting',function() {
						var currentRow = $(this).closest("tr");
						var rowData = $("#departmenttable").DataTable().row(currentRow).data();
						var deptid = rowData.deptId;
						retrieve:true,
								$.ajax({
											contentType : "application/json",
											"url" : "/HRMS/getdeptByDeptId?deptid="
													+ deptid,
											"dataSrc" : "dataBean",
											"type" : "GET",

											success : function(data) {
												for (var i = 0; i < data.length; i++) {
													$("#deptid").val(data[i].deptId);
													$("#name").val(data[i].name);
													$("#shortname ").val(data[i].shortName);
													$("#costcenterid ").val(data[i].costCenterId);
													$("#isactive").val(data[i].isactive);
												}
												selectedRecord = data;
											},
										});
						$('#Departmenteditmodal').modal('show');
					});
	</script>
	<script>
	function DepartmentDeletion(){
		 $("#departmenttable").on('click', '#departmentdelete', function() {
				var currentRow = $(this).closest("tr");
			    var deptId = currentRow.find("td:eq(0)").html(); 
			    var retVal = confirm("would you like to delete this deptid "+deptId);
	           if( retVal == true ) {
	            //  document.write ("User wants to continue!");
	              deletedSuccessfully(deptId);
	           } else {
	              //document.write ("User does not want to continue!");
	           }
	         
		 });
	}

	function deletedSuccessfully(deptId){
		 $.ajax({
		        type: "post",
		        contentType : "application/json",
		        url: "deleteDepartment?deptid="+deptId, //this is my servlet
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
function editDept(){
            var editdepartment = {};
			var deptid = document.getElementById("deptid").value;
			editdepartment["deptId"] = $("#deptid").val();
			editdepartment["name"] = $("#name").val();
		    editdepartment["shortName"] = $("#shortname").val();
			editdepartment["costCenterId"] = $("#costcenterid").val();
			editdepartment["statusCodeForActive"] = $("#isactive").val();
				$.ajax({
					type : "post",
					contentType : "application/json",
					url : "editDepartment", //this is my servlet
					data : JSON.stringify(editdepartment),
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
function saveDepartment(){
		var savedepartment = {};
		savedepartment["name"] = $("#Name").val();
		savedepartment["shortName"] = $("#Shortname").val();
		savedepartment["costCenterId"] = $("#Costcenterid").val();
		  $.ajax({
			type: "post",
			contentType : "application/json",
			url: "saveDepartment", //this is my servlet
			data : JSON.stringify(savedepartment),
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
</head>
<body>
	<div>
	<h5 align="center">
		To Add New Department <a data-toggle="modal"
			data-target="#myModal" href="#">ClickHere</a>
	</h5>
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>
	<table id="departmenttable" class="display" style="width: 100%" border="1">
		<thead>
			<tr>
				<th>DeptId</th>
				<th>Name</th>
				<th>ShortName</th>
				<th>CostCenterId</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
	</table>
	
<!--****************************Edit department model*******************************-->
	               
	                <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id=Departmenteditmodal tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="successinedit" style="text-align:center">
  		<strong id="successmsginedit" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5">Department Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "departmenteditvalidation">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="deptid">DepartmentID</label>
						<input type="text" id="deptid" name="deptid" class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="name">Name</label>
						<input type="text" id="name" name="name" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="inputWarning1">ShortName</label>
						<input type="text" id="shortname" name="shortname" class="form-control">
					</div>
	              <div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="cadrecode">CostCenterId</label>
						<input type="text" id="costcenterid" name="costcenterid" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">Status</label>
						<input type = "text"  id="isactive" name="isactive" class="form-control">
					
					</div>
					<div align="center">
					<button type="button"id="submitedit" class="btn btn-primary" >
						Submit 
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>

  <!--*************************save department model***************************-->
              
              
<div class="modal fade" id="myModal" role="dialog">	
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			<div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" >Adding New Department </h4>
		   </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="alert alert-success " id="savesuccess" style="text-align:center">
  	         <strong id="savesuccessmsg" ></strong> 
  	         </div>
<form id="savedepartmentvalidation">
			<h3 align="center" style="color: green" id="Departmentdispalymsg"></h3>
			<div class="modal-body">
				<div class="box-content row">
					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">Name</label> <input
							type="text" id="Name" name="Name" class="form-control">
					</div>
					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">ShortName</label>
						<input type="text" id="Shortname" name="Shortname" class="form-control">
					</div>
					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">CostCenterId</label>
						<input type="text" id="Costcenterid"  name="Costcenterid"  class="form-control">
					</div>
				</div>
			</div>
			<div class="modal-footer">
			<div class="container" align="center">
				<button type="button" class="btn btn-default"  id="submitsavedepartment">Submit</button>
			</div>
			</div>
			</form>
		</div>	
	</div>
	</div>
<script src="resources/validation/bootstrapValidator.min.js"></script>
<script>
 $('#departmenteditvalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
             name: {
                     validators: {
                         notEmpty: {
                             message: 'name required ',
                          },
                        }
                  },
			 
			shortname: {
                     validators: {
                         notEmpty: {
                             message: 'shortname required ',
                          },
                        }
                  },
                  costcenterid: {
                      validators: {
                          notEmpty: {
                              message: 'costcenterid required ',
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
$("#submitedit").on("click", function(){
$('#departmenteditvalidation').data('bootstrapValidator').validate();
if($('#departmenteditvalidation').data('bootstrapValidator').isValid()){
	editDept();
}

});
</script>
<script>
 $('#savedepartmentvalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
                 Name: {
                     validators: {
                         notEmpty: {
                             message: 'name required ',
                          },
                        }
                  },
			 
			Shortname: {
                     validators: {
                         notEmpty: {
                             message: 'shortname required ',
                          },
                        }
                  },
                  Costcenterid: {
                      validators: {
                          notEmpty: {
                              message: 'costcenterid required ',
                           },
                         }
                   },

			

             }

         });
$("#submitsavedepartment").on("click", function(){
$('#savedepartmentvalidation').data('bootstrapValidator').validate();
if($('#savedepartmentvalidation').data('bootstrapValidator').isValid()){
	saveDepartment();
}
});
</script>
</body>
<script src="resources/dist/js/sidebarmenu.js"></script>
<%@include file="footer.jsp"%>
</html>