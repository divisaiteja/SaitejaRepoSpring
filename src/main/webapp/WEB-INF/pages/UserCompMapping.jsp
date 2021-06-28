<%@include file="header.jsp" %>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >

<script>
$(document).ready(function() {
	
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/HRMS/getloginuser", //this is my servlet
      
        success: function(data){ 
        	
        	var abc=data;
        	var ele = document.getElementById('sel');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                ele.innerHTML = ele.innerHTML +
                    '<option value="' + abc[i]["uid"] + '">' + abc[i]["username"] + '</option>';
            }
        	
        }
 });
});



</script>
<script>

$(document).ready(function() {
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/HRMS/getloginactivity", //this is my servlet
      
        success: function(data){ 
        	
        	var abc=data;
        	var act = document.getElementById('activity');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                act.innerHTML = act.innerHTML +
                    '<option value="' + abc[i]["itemid"] + '">' + abc[i]["itemname"] + '</option>';
            }
        	
        }
 });
});

function populateSelect(){
	var a=document.getElementById("activity").value;
	
}

</script>

<script>
function alllist(){
	var idno = document.getElementById("sel").value;
	
	$('#useraccesslist').dataTable( {
		destroy: true,
		 "ajax" : {

		"url" : "/HRMS/getuseraccesslist?idno="+idno,
		"dataSrc" : "dataBean",
		"type" : "GET",
	
	       },
		"columns": [
						{ data: "itemname"},
						{ data: "iscreate"},
						{ data: "isupdate"},
		 				{ data: "isview"},
				 		{ data: "isdelete"},
				 		{ data: "level1"},
				 		{ data: "level2"},
				 		{ data: "level3"},
				 		{ data: "level4"},
						
						{
			                data: null,
			                className: "center",
			                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25"  id = "reportaccess"  >   '
			            }
				],
	
	} );
}
</script>
<script>

function saveUserAccessList(){ 
	var saveUserAccessList = {};
	saveUserAccessList["idno"] = $("#sel").val();
	saveUserAccessList["menuitemid"] = $("#activity").val();
	
	saveUserAccessList["iscreate"] = $("#iscreate").val();
	saveUserAccessList["isupdate"] = $("#isupdate").val();
	saveUserAccessList["isview"] = $("#isview").val();
	saveUserAccessList["isdelete"] = $("#isdelete").val();
	saveUserAccessList["level1"] = $("#level1").val();
	saveUserAccessList["level2"] = $("#level2").val();
	saveUserAccessList["level3"] = $("#level3").val();
	saveUserAccessList["level4"] = $("#level4").val();
	
	 $.ajax({
		 
	        type: "POST",
	        contentType : "application/json",
	        url: "savenewactivity", //this is my servlet
	        data : JSON.stringify(saveUserAccessList),
	        
//	        
	        success: function(data){ 
	        	$("#successmsg").html(data["successMessage"]);
				$("#success").show();	
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);

	        }
	 });
}
</script>
<script>
	
	$("#useraccesslist").on('click', '#reportaccess', function() {
		
		var currentRow = $(this).closest("tr");
		
		var rowData = $("#useraccesslist").DataTable().row(currentRow).data();

	   var tranid = rowData.tranid;
	  
	   retrieve:true,
		$.ajax({
					contentType : "application/json",
					"url" : "/HRMS/getAccessUpdateByTranid?tranid="
							+ tranid,
					"dataSrc" : "dataBean",
					"type" : "GET",

					success : function(data) {
						console.log(data);
						for (var i = 0; i < data.length; i++) {
							$("#Tranid").val(data[i].tranid);
							
							$("#divisionid").val(
									data[i].divisions);
							$("#deptid ").val(
									data[i].departments);
							$("#tranid ").val(
									data[i].projects);
							$("#isCreate ").val(
									data[i].iscreate);
							if(data[i].iscreate==1){
                                                            $("#isCreate ").attr("checked","checked");
                                                        }                                                                
							$("#isUpdate ").val(
									data[i].isupdate);
							if(data[i].isupdate==1){
                                                            $("#isUpdate").attr("checked","checked");
                                                        }
							$("#isView").val(
									data[i].isview);
							if(data[i].isview==1){
                                                            $("#isView").attr("checked","checked");
                                                        }                                                                
							$("#isDelete ").val(
									data[i].isdelete);
							if(data[i].isdelete==1){
                                                            $("#isDelete ").attr("checked","checked");
                                                        }                                                                
							$("#Level1 ").val(
									data[i].level1);
							$("#Level2 ").val(
									data[i].level2);
							$("#Level3 ").val(
									data[i].level3);
							$("#Level4 ").val(
									data[i].level4);
							
						}

						selectedRecord = data;

					},

				});


	
	   var currentRow = $(this).closest("tr");
		
		var rowData = $("#useraccesslist").DataTable().row(currentRow).data();

	   var tranid = rowData.tranid;
	   console.log(tranid);
	      $.ajax({
					type : "GET",
					contentType : "application/json",
					url : "/HRMS/getdivisionBytranid?tranid="+ tranid, // this is my servlet
					success : function(data) {
						console.log(data);
	                    document.getElementById("divisionid").value = data[0]["divisions"]
	                    $.each(data[0]["divisions"].split(','), function(index, element){
	                        $('#division').find('option[value="'+element+'"]').attr('Selected', 'Selected');

	                    });

					}
				});
	      var currentRow = $(this).closest("tr");
			
			var rowData = $("#useraccesslist").DataTable().row(currentRow).data();
		        var tranid = rowData.tranid;                                               
		   console.log(tranid);
	      $.ajax({
				type : "GET",
				contentType : "application/json",
				url : "/HRMS/getdeprtmentBytranid?tranid="+ tranid, // this is my servlet
				success : function(data) {
					console.log(data);
                  document.getElementById("workdeptid").value = data[0]["departments"]
                  $.each(data[0]["departments"].split(','), function(index, element){
                      $('#department').find('option[value="'+element+'"]').attr('Selected', 'Selected');

                  });

				}
			});
	      var currentRow = $(this).closest("tr")	
			var rowData = $("#useraccesslist").DataTable().row(currentRow).data();
		   var tranid = rowData.tranid;
		   console.log(tranid);
	      $.ajax({
				type : "GET",
				contentType : "application/json",
				url : "/HRMS/getprojectBytranid?tranid="+ tranid, // this is my servlet
				success : function(data) {
					console.log(data);
                  document.getElementById("tranid").value = data[0]["projects"]
                  $.each(data[0]["projects"].split(','), function(index, element){
                      $('#project').find('option[value="'+element+'"]').attr('Selected', 'Selected');

                  });

				}
			});
	      $('#grademodal').modal('show');
              
	 });

//editactivity
</script>
<script>
$(document).ready(function() {
	var division = [];
	$.each($("#division option:selected"), function() {
		division.push($(this).val());
	});
	var division = division.join(",");
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


$("#division").change(function () {
    var selectedValue = $(this).val();
    $("#divisionid").val($("#division").val())
});

</script>
<script>
$(document).ready(function() {
	var project = [];
	$.each($("#project option:selected"), function() {
		project.push($(this).val());
	});
	var project = project.join(",");
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
$("#project").change(function () {
    var selectedValue = $(this).val();
    $("#tranid").val($("#project").val())
});
</script>
<script>
$(document).ready(function() {
	var department = [];
	$.each($("#workdeptid option:selected"), function() {
		department.push($(this).val());
	});
	var department = department.join(",");
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getallDepartment", //this is my servlet
     
       success: function(data){ 
       	var abc=data;
       	var ele = document.getElementById('workdeptid');
           for (var i = 0; i < abc.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["deptid"] + '">' + abc[i]["name"] + '</option>';
           }
       	
       }
});
});
$("#workdeptid").change(function () {
    var selectedValue = $(this).val();
    $("#deptid").val($("#workdeptid").val())
});

</script>

<script>
function userAccessEdit(){
	var menuedit = {};
	var tranid = document.getElementById("tranid").value;
	console.log(tranid);
	menuedit["tranid"] = $("#Tranid").val();
	menuedit["divisions"] = $("#divisionid").val();
	menuedit["departments"] = $("#deptid").val();
	menuedit["projects"] = $("#tranid").val();
	
	if(document.getElementById("isCreate").checked){
            menuedit["iscreate"] = 1;
        }else{
            menuedit["iscreate"] = 0;
        }
	if(document.getElementById("isUpdate").checked){
            menuedit["isupdate"] = 1;
        }else{
            menuedit["isupdate"] = 0;
        }
	if(document.getElementById("isView").checked){
            menuedit["isview"] = 1;
        }else{
            menuedit["isview"] = 0;
        }
	if(document.getElementById("isDelete").checked){
            menuedit["isdelete"] = 1;
        }else{
            menuedit["isdelete"] = 0;
        }
	menuedit["level1"] = $("#Level1").val();
	menuedit["level2"] = $("#Level2").val();
	menuedit["level3"] = $("#Level3").val();
	menuedit["level4"] = $("#Level4").val();


	
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editactivity", //this controller url
        data : JSON.stringify(menuedit),
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
/* $('.preference').each(function(e){	
    if($("#isCreate").val() == 1){
        $("#isCreate").attr("checked", "checked");
        console.log( $(this).attr("checked", "checked"));
    }else{
    	$("#isCreate").removeAttr("checked");
    	console.log($("#isCreate").removeAttr("checked"));
    }
}); */

	</script>
<!--	<script>
	
	    	$('#isUpdate').on('change', function(){
	    		 this.value = this.checked ? 1 : 0 ;
	    	}).change();

	</script>-->
	<!-- <script>
	$('.preference').each(function(e){	
	    if($(this).val() == 1){
	        $(this).attr("checked", "checked");
	        console.log( $(this).attr("checked", "checked"));
	    }else{
	    	$('#isView').on('change', function(){
	    		 this.value = this.checked ? 0 : 1 ;
	    	}).change();
	    }
	});
	</script>
	<script>
	$('.preference').each(function(e){	
	    if($(this).val() == 1){
	        $(this).attr("checked", "checked");
	        console.log( $(this).attr("checked", "checked"));
	    }else{
	    	$('#isDelete').on('change', function(){
	    		 this.value = this.checked ? 0 : 1 ;
	    	}).change();
	    }
	});
</script> -->

<br>
<h4 style = "color:blue;text-align:center">USER ACCESS RIGHTS MAPPING</h4>
<hr>
<div class="box-content row">
<div class="form-group has-warning col-md-3">
			<label class="control-label" style="color:blue">User</label> 
            <select id="sel" onchange ="alllist()" class="form-control">
                  <option value="">select</option>
             </select>
		</div>
</div>
<hr>

<div class="form-group has-warning col-md-3">
			<label class="control-label" style="color:blue">Activity</label> 
            <select id="activity" class="form-control">
                  <option value="">select</option>
             </select>
		</div>
<div><h5>To Add New Activity ... Select Activity <input type="button" class="save" style="background-color: green;color:white" class="btn btn-primary" onclick="saveUserAccessList()"  value="Click Here"></h5></div>
<table id="useraccesslist" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		 <th>Activity</th>
                <th>Create</th>
                <th>Update</th>
                <th>View</th>
                <th>Delete</th>
                <th>Level1</th>
                 <th>Level2</th>
                 <th>Level3</th>
                 <th>Level4</th>
                 
                
              	<th>Action</th>
                
            </tr>
        </thead>
       
    </table>
    
    
     <!-- Modal -->
 <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="grademodal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-xl" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="successinedit" style="text-align:center">
  		<strong id="successmsginedit" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Access Rights Update</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "menuaccessvalidation">
				<div class="modal-body">
				<div class="box-content row">
				<input type = "text" id = "Tranid" hidden>
                  <div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1" style="color:blue">Division
						</label><br>

                    <select  class="form-control" id="division"  name = "divisionid" style = "border-color:blue" multiple size =5 >
						<option value="">select</option>

					</select><br>
				<input type = "text"  id = "divisionid" class = "form-control" readonly = "readonly">

				</div>
			
				<div class="form-group has-warning   col-md-3">
					<label class="control-label"  for="inputWarning1" style="color:blue">Department</label>
					<select multiple="multiple" class="form-control" id="workdeptid" name="workdeptid" size="5">
						<option value="">select</option>
					</select><br>
					<input type = "text" id = "deptid"  class = "form-control" readonly = "readonly">
					
				</div>
				
				
				<div class = "form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1" style="color:blue">Project
						</label>
                    <select multiple="true" size="5" class="form-control" id="project" name = "project">
						<option value="">select</option>
					</select><br>
					<input type = "text" id = "tranid" class = "form-control" readonly = "readonly">
					
				</div>
				</div>
			<div class="box-content row">
                                        <div  class="form-group has-warning col-md-2">
						<label data-error="wrong" data-success="right" for="isCreate">
						 <input type="checkbox" id = "isCreate">Create</label>		
                                        </div> 
					<div  class="form-group has-warning col-md-2">
						<label data-error="wrong" data-success="right" for="isUpdate">
						<input type="checkbox" id = "isUpdate"  >Update</label>
					</div>
					<div  class="form-group has-warning col-md-2">
						<label data-error="wrong" data-success="right" for="isView">
						<input type="checkbox" id = "isView" >View</label>
					</div>
					<div  class="form-group has-warning col-md-2">
						<label data-error="wrong" data-success="right" for="isDelete" >
						<input type="checkbox" id = "isDelete" >Delete</label>
					</div>
					</div>
					<div class="box-content row">
					<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right" for="Level1">Level1</label>
						<input type="text" id="Level1" name="Level1" class="form-control">
					</div>
					<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right" for="Level2">Level2</label>
						<input type="text" id="Level2" name="Level2" class="form-control">
					</div>
					<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right" for="Level3">Level3</label>
						<input type="text" id="Level3" name="Level3" class="form-control">
					</div>
					<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right" for="Level4">Level4</label>
						<input type="text" id="Level4" name="Level4" class="form-control">
					</div>
					
                   </div>

										<div align="center">
					<button type="button"id="submitacces" class="btn btn-primary" >
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
      	     <script src="resources/validation/bootstrapValidator.min.js"></script>
      	    <script>
 $('#menuaccessvalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	   divisionid: {
                       validators: {
                           notEmpty: {
                               message: 'code required ',
                            },
                          }
                    },
             }

         });


$("#submitacces").on("click", function(){
$('#menuaccessvalidation').data('bootstrapValidator').validate();
if($('#menuaccessvalidation').data('bootstrapValidator').isValid()){
	userAccessEdit();
}

});
</script>

<%@include file="footer.jsp"%>