<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="header.jsp" %>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
<script>
$(document).ready(function(){
    $("#sectioneditsucess").hide();
    $("#savesectionsuccess").hide();
   
});
</script>
<script>
$(document).ready(function() {
	$('#sections').dataTable( {
			 "ajax" : {
			"url" : "/DASHBOARD/getsections",
			"dataSrc" : "dataBean",
			"type" : "GET",
		},
			"columns": [
							{ data: "sectionid"},
			 				{ data: "name"},
					 		{ data: "statusCodeForActive"},
 							{ data: "costcenterid"},
							{ data: "parentid"},
							
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="SectionEditing" >   <input type="image" src="resources/assets/images/delete.png" id="SectionDelete" height="25" width="25"  onclick="SectionDelete()">'
				            }
					],
		
		} );
	
} );
</script>
<script>
	$("#sections").on('click','#SectionEditing',function() {
						var currentRow = $(this).closest("tr");
						var rowData = $("#sections").DataTable().row(currentRow).data();
                        var sectionid = rowData.sectionid;
						retrieve:true,
								$.ajax({
										contentType : "application/json",
										"url" : "/DASHBOARD/getSectionbysectionid?sectionid="+ sectionid,
											"dataSrc" : "dataBean",
											"type" : "GET",

											success : function(data) {
												for (var i = 0; i < data.length; i++) {
													$("#sectionid").val(data[i].sectionid);
													$("#name").val(data[i].name);
													$("#isactive").val(data[i].isactive);
													$("#costcenterid").val(data[i].costcenterid);
													$("#parentid").val(data[i].parentid);
													}
                                       selectedRecord = data;

											},

										});

						$('#SectionTypeModal').modal('show');

					});
	</script>
<script>
	function SectionDelete(){
		 $("#sections").on('click', '#SectionDelete', function() {
				var currentRow = $(this).closest("tr");
			    var sectionid = currentRow.find("td:eq(0)").html(); 
			    var retVal = confirm("would you like to delete this sectionid "+sectionid);
	           if( retVal == true ) {
	            //  document.write ("User wants to continue!");
	              deletedSuccessfully(sectionid);
	           } else {
	              //document.write ("User does not want to continue!");
	           }
	         
		 });
	}

	function deletedSuccessfully(sectionid){
		 $.ajax({
		        type: "post",
		        contentType : "application/json",
		        url: "deleteSection?sectionid="+sectionid, //this is my servlet
		        success : function(data) {
		        	$("#sectiondelete").html("DeletedSucessFully");
		        	 setInterval(function(){
		 	        	window.location.reload(); // this will run after every 5 seconds
		 	        }, 2000);
				}
		        
		  });
	}
</script>
<script>
function editSection(){
                        var editSection = {};
					    editSection["sectionid"] = $("#sectionid").val();
                        editSection["name"] = $("#name").val();
						editSection["isactive"] = $("#isactive").val();
						editSection["costcenterid"] = $("#costcenterid").val();
						$.ajax({
							type : "post",
							contentType : "application/json",
							url : "editSection", //this is my servlet
							data : JSON.stringify(editSection),
							success : function(data) {
								 $("#sectioneditsucess").show();
								 $("#EditsectionStrong").html(data["successMessage"]);
						           setInterval(function(){
						        	window.location.reload(); // this will run after every 5 seconds
						        }, 2000); 
								
							}
						});
}
	
</script>
<script>
function saveSection(){
		var saveSection = {};
		var Name=document.getElementById("Name").value;
		saveSection["name"] = $("#Name").val();
		saveSection["costcenterid"] = $("#Costcenterid").val();
		$.ajax({
			type: "post",
			contentType : "application/json",
			url: "saveSection", //this is my servlet
			data : JSON.stringify(saveSection),
			success: function(data){ 
				 $("#savesectionsuccess").show();
				 $("#sectionStrong").html(data["successMessage"]);
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
		To Add New Section <a data-toggle="modal"
			data-target="#mySection" id="" onclick="" href="#">Click
			Here</a>
	</h5>
	<h5 align="center" id="sectiondelete" style="color:red"></h5>
</div>
<table id="sections" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		<th>SectionID</th>
                <th>Name</th>
                <th>IsActive</th>
                <th>CostcenterId</th>
                <th>ParentId</th>
                <th>Edit / Delete </th>
             </tr>
        </thead>
       
    </table>
    
 <!--***************************** Section Edit Model Box *********************************-->
     
      <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="SectionTypeModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="sectioneditsucess" style="text-align:center">
  		<strong id="EditsectionStrong" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5">Section Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "editsectionvalidation">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="gradeno">SectionID</label>
						<input type="text"  id="sectionid" name="sectionid" class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="name">Name</label>
						<input type="text" id="name" name="name" class="form-control">
					</div>

	              <div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="cadrecode">CostcenterId</label>
						<input type="text" id="costcenterid" name="costcenterid" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">Status</label>
						<input type = "text"  id="isactive" name="isactive" class="form-control">
					
					</div>
					<div align="center">
					<button type="button"id="submitsection" class="btn btn-primary" >
						Submit
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>

  <!--**************************** Section Save Model Box ********************************-->
    
    <div class="modal fade" id="mySection" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			<div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" >Adding New Section </h4>
		   </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
		 <div align="center">
			<div class="alert alert-success " id="savesectionsuccess" style="text-align:center">
  		    <strong id="sectionStrong" ></strong> 
		    </div>
			</div>
<form id="savesectionvalidation">
			<div class="modal-body">
				<div class="box-content row">
					 
					<div class="form-group has-warning col-md-6">
						<label class="control-label" for="inputWarning1">Name</label> <input
							type="text" id="Name" name="Name"  class="form-control">
					</div>
                    
                    <div class="form-group has-warning col-md-6">
						<label class="control-label" for="inputWarning1">CostcenterId</label> <input
							type="text" id="Costcenterid" name="Costcenterid"  class="form-control">
					</div>
                    
				</div>
                 
			</div>
			
			<div class="modal-footer">
			<div class="container" align="center">
				<button type="button" class="btn btn-default"  id="submitsavesection">Submit</button>
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
	$('#editsectionvalidation').bootstrapValidator({
		feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	name:{
        		validators: {
                    notEmpty: {
                        message: 'name required ',
                     },
                   }	
        	},
        	isactive:{
        		validators: {
                    notEmpty: {
                        message: 'isactive required ',
                     },
                   }	
        	},
        	costcenterid:{
        		validators: {
                    notEmpty: {
                        message: 'costcenterid required ',
                     },
                   }	
        	},
        }
	})
	
	$("#submitsection").on("click", function(){
    $('#editsectionvalidation').data('bootstrapValidator').validate();
	if($('#editsectionvalidation').data('bootstrapValidator').isValid()){
			editSection();
		}

		});
	</script>
	
	<script>
	$('#savesectionvalidation').bootstrapValidator({
		feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	Name:{
        		validators: {
                    notEmpty: {
                        message: 'name required ',
                     },
                   }	
        	},
        	Isactive:{
        		validators: {
                    notEmpty: {
                        message: 'isactive required ',
                     },
                   }	
        	},
        	Costcenterid:{
        		validators: {
                    notEmpty: {
                        message: 'costcenterid required ',
                     },
                   }	
        	},
        }
	})
	
	$("#submitsavesection").on("click", function(){
		$('#savesectionvalidation').data('bootstrapValidator').validate();
		if($('#savesectionvalidation').data('bootstrapValidator').isValid()){
			saveSection();
		}

		});
	</script>
	</body>
	
	</html>
	
	
	
	
	
	
	
	
	
	
	
	
