<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>JobtypeList</title>
<link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >

<script>
$(document).ready(function(){
	   // $("#warnings").hide();
	    $("#cadresave").hide();
	    $("#cadreedit").hide();
	   
	});
</script>

<script>
	$(document).ready(function() {$('#cadretable').dataTable(
		{"ajax" :
		{
			"url" : "/DASHBOARD/getcadre",
            "dataSrc" : "dataBean",
			"type" : "GET",
      },
	"columns" : [
		{data : "tranid"},
		{data : "cadrecode"},
		{data : "cadredescription"},
		{data : "statusCodeForActive"},
        {data : null,
		className : "center",
		defaultContent : '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="CadreEditing" >   <input type="image" src="resources/assets/images/delete.png" id="CadreDelete" height="25" width="25"  onclick="CadreDeletion()">'
		} ],
});

});
</script>
<script>
	$("#cadretable").on('click','#CadreEditing',function() {
	var currentRow = $(this).closest("tr");
	var rowData = $("#cadretable").DataTable().row(currentRow).data();
	var tranid = rowData.tranid;
	retrieve:true,
	$.ajax({
	contentType : "application/json",
	"url" : "/DASHBOARD/getcadrebytranid?tranid="+ tranid,
	"dataSrc" : "dataBean",
	"type" : "GET",
success : function(data) {
	for (var i = 0; i < data.length; i++) {
		$("#tranid").val(data[i].tranid);
		$("#cadrecode").val(data[i].cadrecode);
		$("#cadredescription ").val(data[i].cadredescription);
		$("#isactive").val(data[i].isactive);
       }

	selectedRecord = data;
          },
});
$('#CadreModal').modal('show');
});
	</script>
	<script>
	function CadreDeletion(){
		 $("#cadretable").on('click', '#CadreDelete', function() {
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
		        url: "deleteCadre?tranid="+tranid, //this is my servlet
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
function editCadre(){
	var editcadre = {};
	var tranid = document.getElementById("tranid").value;
       editcadre["tranid"] = $("#tranid").val();
       editcadre["cadrecode"] = $("#cadrecode").val();
	   editcadre["cadredescription"] = $("#cadredescription").val();
	   editcadre["statusCodeForActive"] = $("#isactive").val();
			$.ajax({
				type : "post",
				contentType : "application/json",
				url : "editCadre", //this is my servlet
				data : JSON.stringify(editcadre),
				success : function(data) {
				$("#cadreEditstrong").html(data["successMessage"]);
				$("#cadreedit").show();	
					setInterval(function(){
					window.location.reload(); // this will run after every 5 seconds
					 }, 2000);
                    }
});
}
	
</script>

<script>
function savecadre(){
		var savecadre = {};
		savecadre["cadrecode"] = $("#Cadrecode").val();
		savecadre["cadredescription"] = $("#Cadredescription").val();
		$.ajax({
			type: "post",
			contentType : "application/json",
			url: "saveCadre", //this is my servlet
			data : JSON.stringify(savecadre),
			success: function(data){ 
				 $("#cadreSavestrong").html(data["successMessage"]);
					$("#cadresave").show();	
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
		To Add New Cadre  <a data-toggle="modal"
			data-target="#myModal" href="#">Click
			Here</a>
	</h5>
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>
	<table id="cadretable" class="display" style="width: 100%" border="1">
		<thead>
			<tr>
				<th>Tranid</th>
				<th>CadreCode</th>
				<th>CadreDescription</th>
				<th>Status</th>
				<th>Action</th>

			</tr>
		</thead>
	</table>
	
<!--******************************Edit Cadre model box *********************************-->

	 <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="CadreModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="cadreedit" style="text-align:center">
  		<strong id="cadreEditstrong" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Cadre Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "cadrevalidation">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="tranid">TranId</label>
						<input type="text" id="tranid" name="tranid" class="form-control"
							readonly="readonly">
					</div>

                    <div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="cadrecode">CadreCode</label>
						<input type="text" id="cadrecode" name="cadrecode" class="form-control">
					</div>
               
					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="inputWarning1">CadreDescription</label>
						<input type="text" id="cadredescription" name="cadredescription" class="form-control">
					</div>
	              

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">Status</label>
						<input type = "text"  id="isactive" name="isactive" class="form-control">
					
					</div>
					<div align="center">
					<button type="button"id="submitcadre" class="btn btn-primary" >
						Submit
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>
    
	


<!--****************************Save cadre model box ***********************************-->

<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			<div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" >Adding New Cadre </h4>
		   </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
      <div align="center">
			<div class="alert alert-success " id="cadresave" style="text-align:center">
  		<strong id="cadreSavestrong" ></strong> 
		</div>
			</div>
 <form id="savecadrevalidation">
			<div class="modal-body">
				<div class="box-content row">
					<!-- <div class="form-group has-warning col-md-3">
						<label class="control-label" for="inputWarning1">ParentID</label>
						<input type="text" id="parentid" class="form-control">
					</div> -->
						
					
					<div class="form-group has-warning col-md-6">
						<label class="control-label" for="inputWarning1">CadreCode</label> <input
							type="text" id="Cadrecode" name="Cadrecode" class="form-control">
					</div>

					<div class="form-group has-warning col-md-6">
						<label class="control-label" for="inputWarning1">CadreDescription</label>
						<input type="text" id="Cadredescription" name = "Cadredescription" class="form-control">
					</div>
				</div>
                 
			</div>
			
			<div class="modal-footer">
			<div class="container" align="center">
				<button type="button" class="btn btn-default"  id="submitsavecadre">Submit</button>
			</div>
			</div>
			</form>
		</div>
		
		
	</div>
	</div>

<script src="resources/validation/bootstrapValidator.min.js"></script>

<script>
 $('#cadrevalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
             cadrecode: {
                     validators: {
                         notEmpty: {
                             message: 'cadrecode required ',
                          },
                        }
                  },
			 
			cadredescription: {
                     validators: {
                         notEmpty: {
                             message: 'cadredescription required ',
                          },
                        }
                  },
                  isactive:{
                      validators: {
                          notEmpty: {
                              message: 'IsActive required ',
                           },
                         }
                   }

             }

         });


$("#submitcadre").on("click", function(){

$('#cadrevalidation').data('bootstrapValidator').validate();
if($('#cadrevalidation').data('bootstrapValidator').isValid()){
	editCadre();
}

});
</script>
<script>
 $('#savecadrevalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
                 Cadrecode: {
                     validators: {
                         notEmpty: {
                             message: 'cadrecode required ',
                          },
                        }
                  },
			 
			Cadredescription: {
                     validators: {
                         notEmpty: {
                             message: 'cadredescription required ',
                          },
                        }
                  },
			

			

             }

         });
</script>
<script>

$("#submitsavecadre").on("click", function(){

$('#savecadrevalidation').data('bootstrapValidator').validate();
if($('#savecadrevalidation').data('bootstrapValidator').isValid()){
	savecadre();
}

});
</script>
</body>
<%@include file="footer.jsp"%>
 <script src="resources/dist/js/sidebarmenu.js"></script>
</html>