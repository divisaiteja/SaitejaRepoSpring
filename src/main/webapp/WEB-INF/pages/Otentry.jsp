<%@include file="header.jsp" %>
<script>
$(document).ready(function() {

	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getallDivision", //this is my servlet
     
       success: function(data){ 
       	var abc=data;
       	var ele = document.getElementById('division');
           for (var i = 0; i < abc.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["divisionid"] + '">' + abc[i]["name"] + '</option>';
           }
       	
       }
});
});

$(document).ready(function() {
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getallproject", //this is my servlet
     
       success: function(data){ 
       	var a=data;
       	var proj = document.getElementById('project');
           for (var i = 0; i < a.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               proj.innerHTML = proj.innerHTML +
                   '<option value="' + a[i]["tranid"] + '">' + a[i]["projectname"] + '</option>';
           }
       	
       }
});
});
</script>
<script>
/* function getDivisionList(division) {
	console.log("gfdj");
	commonFunctionForList();
}
function getProject(project){
	console.log("dhsd");
	commonFunctionForList();
} */

	
function commonFunctionForList() {
	var division=document.getElementById("division").value;
 	var project = document.getElementById("project").value;
 	console.log(project);
	var otdate = document.getElementById("otdate").value;
	 $.ajax({
			"url" : "/HRMS/getAllEmployeeAndDepartment?division="+division+"&&otdate="+otdate+"&&project="+project,
			 success : function(data, textStatus, jqXHR) {
		 	        var table_data = data.dataBean;
		 	       // //alert(table_data[punchcod]);
		 	        var table = $('#employeedivision').DataTable( {
		 	        	"destroy": true,
		 	            data: table_data,
		 	            //dataSrc:data,
		 	            //"dataSrc" : "data",
			"columns": [
							{ data: "idno"},
			 				{ data: "empname"},
			 				{ data: "desgn"},
			 				{ data: "name"},
							{data : "ot_hours"},
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="othredit" >   <input type="image" src="resources/assets/images/delete.png" id="" height="25" width="25"  onclick="()">'
                                                //<button id ="" type ="button" color="green" >OT</button> 
				            }
					],
		
		} );
	
			 }
	 })
}
</script>
<script>
	$("#employeedivision").on('click','#othredit',function() {
		
						var currentRow = $(this).closest("tr");
						var rowData = $("#employeedivision").DataTable().row(currentRow).data();
						var idno = rowData.idno;
						var othrs = rowData.ot_hours;
						$("#idno").val(idno);
						$("#othrs").val(othrs);
						var otdate = $("#otdate").val();						
						$('#grademodal').modal('show');

					});
	</script>
<script>

function otEdit(){
	var otHourEdit = {};
	var idno = document.getElementById("idno").value;
	otHourEdit["idNumber"] = $("#idno").val();
	otHourEdit["otHours"] = $("#othrs").val();
	otHourEdit["otdate"] = $("#otdate").val();
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editOtHr", //this controller url
        data : JSON.stringify(otHourEdit),
        success: function(data){
        	 $("#successinedit").show();
        	 $("#successmsginedit").html(data["successMessage"]);
        	setInterval(function(){
	        	window.location.reload(); // this will run after every 2 seconds
	        }, 2000);
        }
   
    });
    
} 

</script>
<div>
	<h3 align="center" style="color: #fb8c00">EmployeeOTEntry</h3>
</div>
<hr color="00FFFF">
<form id = "otupdate">
<div class="box-content row">
<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Division</label>
                     <select class="form-control" id="division"  name = "division">
					<option value="">select</option>
                     </select>
				</div>
				<div class = "form-group has-warning col-md-4">
                       <label class="control-label" for="inputWarning1">Project</label>
                        <select class="form-control" id="project" name = "project">
						<option value="">select</option>
					</select>
				</div>

				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Date
						</label> <input type="text" id="otdate" name = "otdate" class="form-control">

				</div>
				</div>
				<div align ="center">
				<input  type="button"  id ="submitot" style="background-color: blue;color:white" class="btn btn-primary" value = "Show" > 
				</div>
				</form>

<hr color="00FFFF">

<div>
<table id="employeedivision" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           	    <th>idNumber</th>
                <th>employeeName</th>
                <th>Designation</th>
                <th>Department</th>
             	<th>OT Hours</th>
              	<th>Action</th>
                
            </tr>
        </thead>
       
    </table>
</div>
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
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Edit OT Hours</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "gradeeditvalidation">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12" hidden = "hidden">
						<label data-error="wrong" data-success="right" for="idno">idNumber</label>
						<input type="text" id="idno" class="form-control"
							hidden="hidden">
					</div>

					<div  class="form-group has-warning col-md-12" hidden = " hidden">
						<label data-error="wrong" data-success="right" for="otdate">OT Date</label>
						<input type="text" id="otdate" name="otdate" class="form-control" hidden = "hidden">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="othrs">OT Hours</label>
						<input type="text" id="othrs" name="othrs" class="form-control">
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
    
<script src="resources/dist/js/sidebarmenu.js"></script>
<%@include file="footer.jsp" %>
<script>
jQuery('#otdate').datepicker({
    autoclose: true,
    todayHighlight: true
});
</script>
 <script src="resources/validation/bootstrapValidator.min.js"></script>
<script>
 $('#gradeeditvalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	   othrs: {
                       validators: {
                           notEmpty: {
                               message: 'ot hours required ',
                            },
                          }
                    },
             }

         });


$("#submitgrade").on("click", function(){
$('#gradeeditvalidation').data('bootstrapValidator').validate();
if($('#gradeeditvalidation').data('bootstrapValidator').isValid()){
	otEdit();
}

});
</script>
<script>
 $('#otupdate').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	   division: {
                       validators: {
                           notEmpty: {
                               message: 'please select division ',
                            },
                          }
                    },
                    project: {
                        validators: {
                            notEmpty: {
                                message: 'please select project ',
                             },
                           }
                     },
                     otdate: {
                         validators: {
                             notEmpty: {
                                 message: 'please select date ',
                              },
                            }
                      }, 
             }

         });


$("#submitot").on("click", function(){
$('#otupdate').data('bootstrapValidator').validate();
if($('#otupdate').data('bootstrapValidator').isValid()){
	commonFunctionForList();
}

});
</script>