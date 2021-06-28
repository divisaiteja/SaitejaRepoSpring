<%@include file="header.jsp" %>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
<script>
$(document).ready(
		function() {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getallCadre", // this is my servlet

				success : function(data) {
					var abc = data;
					var savecadre = document.getElementById('savecadreid');
					var editcadre = document.getElementById('editcadreid');
					
					for (var i = 0; i < abc.length; i++) {
						// POPULATE SELECT ELEMENT WITH JSON.
						savecadre.innerHTML = savecadre.innerHTML + '<option value="'
								+ abc[i]["tranid"] + '">'
								+ abc[i]["cadredescription"] + '</option>';
								
						editcadre.innerHTML = editcadre.innerHTML + '<option value="'
								+ abc[i]["tranid"] + '">'
								+ abc[i]["cadredescription"] + '</option>';
					}

				}
			});
		});

</script>
<script>
$(document).ready(function(){
   // $("#warnings").hide();
    $("#success").hide();
    $("#successinedit").hide();
   
});
function forDeletion(){
	 $("#gradesList").on('click', '#deleteId', function() {
			var currentRow = $(this).closest("tr");
		    var gradeno = currentRow.find("td:eq(0)").html(); 
		    
		    ////alert(gradeno);
		    
		    var retVal = confirm("would you like to delete this Gradeno "+gradeno);
           if( retVal == true ) {
            //  document.write ("User wants to continue!");
              deletedSuccessfully(gradeno);
           } else {
              //document.write ("User does not want to continue!");
           }
          
	 });
}

function deletedSuccessfully(gradeno){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteGrade?gradeno="+gradeno, //this is my servlet

	        success: function(data){  
	        	$("#deletemessage").html("DeletedSucessFully");
	        	 setInterval(function(){
	 	        	window.location.reload(); // this will run after every 5 seconds
	 	        }, 2000);
	        }
	  });
}


</script>

<script>
	$("#gradesList").on('click','#gradeEditing',function() {
						var currentRow = $(this).closest("tr");
						var rowData = $("#gradesList").DataTable().row(currentRow).data();
						var gradeno = rowData.gradeno;
						retrieve:true,
								$.ajax({
											contentType : "application/json",
											"url" : "/HRMS/getgradebygradeno?gradeno="
													+ gradeno,
											"dataSrc" : "dataBean",
											"type" : "GET",

											success : function(data) {
												for (var i = 0; i < data.length; i++) {
													$("#gradeno").val(
															data[i].gradeno);
													$("#code").val(
															data[i].code);
													$("#description ").val(
															data[i].description);
													$("#editcadreid ").val(
															data[i].cadrecode);
													$("#isactive").val(
															data[i].isactive);

												}

												selectedRecord = data;

											},

										});

						$('#grademodal').modal('show');

					});
	</script>
<script>

function gradeEdit(){
	var gradeEditData = {};
	var gradeno = document.getElementById("gradeno").value;
	gradeEditData["gradeno"] = $("#gradeno").val();
	gradeEditData["code"] = $("#code").val();
	gradeEditData["description"] = $("#description").val();
	gradeEditData["cadrecode"] = $("#editcadreid").val();
	gradeEditData["isactive"] = $("#isactive").val();
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editGrade", //this controller url
        data : JSON.stringify(gradeEditData),
        success: function(data){  
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
$(document).ready(function() {
	  // Edit record
   
	$('#gradesList').dataTable( {
			 "ajax" : {
			"url" : "/HRMS/getgrade",
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
			"columns": [
							{ data: "gradeno"},
							{ data: "code"},
							{ data: "description"},
			 				{ data: "cadreDTO.cadredescription"},
					 		{ data: "statusCodeForActive"},
 							
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="gradeEditing"  >   <input type="image" src="resources/assets/images/delete.png" id="deleteId" height="25" width="25"  onclick="forDeletion()">'
				            }
					],
		
		} );
	
} );
</script>
<script>
	function saveGradeList() {
		var saveGrade = {};
		saveGrade["code"] = $("#Code").val();
		saveGrade["description"] = $("#Description").val();
		saveGrade["cadrecode"] = $("#savecadreid").val();
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "saveNewGrade", //this is my servlet
			data : JSON.stringify(saveGrade),
			success : function(data) {
				
				$("#successmsg").html(data["successMessage"]);
				$("#success").show();	
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);

			}
		});
	}
</script>
<div>
<h5 align="center">
		To Add New Grade <a data-toggle="modal"
			data-target="#newGrade" href="#">ClickHere</a>
	</h5>
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>
<table id="gradesList" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		<th>GradeNo</th>
                <th>Code</th>
                <th>Description</th>
                <th>CadreCode</th>
                <th>Status</th>
              	<th>Action</th>
                
            </tr>
        </thead>
    </table>
    
<!-- ************************************* Grade Edit Model Box *************************************-->
   
    <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="grademodal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="successinedit" style="text-align:center">
  		<strong id="successmsginedit" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Grade Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "gradeeditvalidation">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="gradeno">GradeNo</label>
						<input type="text" id="gradeno" class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="code">Code</label>
						<input type="text" id="code" name="code" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="inputWarning1">Description</label>
						<input type="text" id="description" name="description" class="form-control">
					</div>
	              <div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="cadrecode">CadreCode</label>
					 <select  id="editcadreid" name="editcadreid" class="form-control">
						
						</select> 
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">Status</label>
						<input type = "text"  id="isactive" name="isactive" class="form-control">
					
					</div>
					<div align="center">
					<button type="button"id="submitgrade" class="btn btn-primary" >
						Submit 
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>
    
     <!-- ************************************* Grade Save Model Box *************************************-->
     
  <div class="modal fade" id="newGrade" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			   <div class="container">
		         <h4 align="center" style="color: #0B1907" class="modal-title" > Adding New Grade</h4>
		       </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="alert alert-success " id="success" style="text-align:center">
  	            <strong id="successmsg" ></strong> 
	        </div>
       <form id="grade_form">
			<div class="modal-body">
				<div class="box-content row">
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Code</label> <input
						type="text" id="Code" name="Code" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Description</label>
					<input type="text" id="Description" name="Description"
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">CadreCode</label>
					<select  id="savecadreid" name="savecadreid" class="form-control">
						<option value="">select</option>
						</select>
				</div>

			</div>
			</div>
			
			<div class="modal-footer" >
			<div class="container" align="center">
				<button type="button" class="btn btn-primary"  id="grade_btn" >Submit</button>
			</div>
			</div>
			</form>
		</div>
		
		</div>
	</div>
  
  
 
 <script src="resources/validation/bootstrapValidator.min.js"></script>

<script>
 $('#grade_form').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
             Code: {
                     validators: {
                         notEmpty: {
                             message: 'Code is required ',
                          },
                        }
                  },
				  Description: {
                     validators: {
                         notEmpty: {
                             message: 'description is required ',
                          },
                        }
                  },
                  savecadreid: {
                     validators: {
                         notEmpty: {
                             message: 'Cadrecode id required ',
                          },
                        }
                  },
				  

             }

         });
        $("#grade_btn").click(function(){
$('#grade_form').data('bootstrapValidator').validate();
if($('#grade_form').data('bootstrapValidator').isValid()){
	saveGradeList();
}


});

</script>
<script>
 $('#gradeeditvalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	   code: {
                       validators: {
                           notEmpty: {
                               message: 'code required ',
                            },
                          }
                    },
  			 
                    editcadreid: {
                     validators: {
                         notEmpty: {
                             message: 'cadrecode required ',
                          },
                        }
                  },
			 
			description: {
                     validators: {
                         notEmpty: {
                             message: 'description required ',
                          },
                        }
                  },
                  isactive: {
                      validators: {
                          notEmpty: {
                              message: 'isActive required ',
                           },
                         }
                   },
			

             }

         });


$("#submitgrade").on("click", function(){
$('#gradeeditvalidation').data('bootstrapValidator').validate();
if($('#gradeeditvalidation').data('bootstrapValidator').isValid()){
	gradeEdit();
}

});
</script>
<script src="resources/dist/js/sidebarmenu.js"></script>
  
 <%@include file="footer.jsp"%>