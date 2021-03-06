<%@include file="header.jsp" %>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
 <style>
.search-table-outter {
	overflow-x: scroll;
}
</style>     
<style type="text/css">
    .box{
        color: #2C3E50;
        padding: 20px;
        display: none;
        margin-top: 20px;
    }
    .permission{ background:#D5D8DC; }
    .passel{ background: #D5D8DC; }
    .passsl{ background: #D5D8DC; }
    .passcl{ background:#D5D8DC; }
    .passleave{ background: #D5D8DC; }
    .forgetpunch{ background: #D5D8DC; }
    .lopintimation{ background: #D5D8DC; }
</style>
<script type="text/javascript">
$(document).ready(function(){
    $("select").change(function(){
        $(this).find("option:selected").each(function(){
            var optionValue = $(this).attr("value");
            if(optionValue){
                $(".box").not("." + optionValue).hide();
                $("." + optionValue).show();
            } else{
                $(".box").hide();
            }
        });
    }).change();
});
</script>
<script>
$(document).ready(function(){
   // $("#warnings").hide();
    $("#success").hide();
    $("#successinedit").hide();
    $("#changeBasedonIdno").hide();
    $("#permissionsList").hide();

});
</script>
<script>
function permissionList() {
	var idno = document.getElementById("idno").value;
	$('#permissionsList').dataTable( {
		"destroy" : true,
			 "ajax" : {
			"url" : "/HRMS/getPermissionsList?idno="+idno,
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
			"columns": [
				            { data: "tranid"},		
							{ data: "infodate"},		 				
					 		{ data: "passel"},
					 		{ data: "passcl"},
					 		{ data: "passsl"},
					 		{ data: "passleave"},
					 		{ data: "forgotpunch"},
					 		{ data: "lopintimation"},
					 		{ data: "permission_mins"},
							{ data: "permissiontype"},	
					 		{ data: "remarks"},
					 		
							{
				                data: null,
				                className: "center",
				                defaultContent: ' <input type="image" src="resources/assets/images/delete.png" id="deleteId" height="15" width="15"  onclick="forDeletion()">'
				            }
					],
		
		} );
} 
</script>
<script>
function forDeletion(){
	 $("#permissionsList").on('click', '#deleteId', function() {
			var currentRow = $(this).closest("tr");
		    var tranid = currentRow.find("td:eq(0)").html(); 
		    var retVal = confirm("would you like to delete this userId "+tranid);
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
	        url: "deletePermission?tranid="+tranid, //this is my servlet
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
	function getDetailsBasedOnIdno(){
		var idno = document.getElementById("idno").value;
		
   $.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/HRMS/getEmployeeInformationBasedOnIdno?idno="+idno,										
		success : function(data) {
			 $("#changeBasedonIdno").show();
			 $("#permissionsList").show();
		document.getElementById("empname").value = data[0]["employeeName"];
		document.getElementById("design").value = data[0]["design"];
		$("#workdeptname").val(data[0].hrDepartmentMaster.name); 
		$("#divisionname").val(data[0].divisiondto.name);
	}
   
});
   permissionList();
   
			}
</script>
<script>
function passel(){
var savePassel = {};
        savePassel["idno"] = $("#idno").val();
        savePassel["infodate"] = $("#eldate").val();
        savePassel["remarks"] = $("#reasonforel").val();
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "savePassel", //this is my servlet
			data : JSON.stringify(savePassel),
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
<script>
function passsl(){
	var savePasssl = {};
	        savePasssl["idno"] = $("#idno").val();
	        savePasssl["infodate"] = $("#sldate").val();
	        savePasssl["remarks"] = $("#reasonforsl").val();
			$.ajax({
				type : "post",
				contentType : "application/json",
				url : "savePasssl", //this is my servlet
				data : JSON.stringify(savePasssl),
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
<script>
function passcl(){
	var savePasscl = {};
	        savePasscl["idno"] = $("#idno").val();
	        savePasscl["infodate"] = $("#cldate").val();
	        savePasscl["remarks"] = $("#reasonforcl").val();
			$.ajax({
				type : "post",
				contentType : "application/json",
				url : "savePasscl", //this is my servlet
				data : JSON.stringify(savePasscl),
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
<script>
function passLeave(){
	var savepassLeave = {};
	      savepassLeave["idno"] = $("#idno").val();
	      savepassLeave["infodate"] = $("#passleavedate").val();
	      savepassLeave["remarks"] = $("#reasonforpassleave").val();
			$.ajax({
				type : "post",
				contentType : "application/json",
				url : "savePassLeave", //this is my servlet
				data : JSON.stringify(savepassLeave),
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
<script>
function forgetPunch(){
	var forgetPunch = {};
	    forgetPunch["idno"] = $("#idno").val();
	    forgetPunch["infodate"] = $("#forgetpunchdate").val();
	    forgetPunch["remarks"] = $("#reasonforforgetpunch").val();

			$.ajax({
				type : "post",
				contentType : "application/json",
				url : "saveForgetPunch", //this is my servlet
				data : JSON.stringify(forgetPunch),
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
<script>
function lopIntimation(){
	var lopIntimation = {};
	    lopIntimation["idno"] = $("#idno").val();
	    lopIntimation["infodate"] = $("#lopintimationdate").val();
	    lopIntimation["remarks"] = $("#reasonforlopintimation").val();
			$.ajax({
				type : "post",
				contentType : "application/json",
				url : "saveLopIntimation", //this is my servlet
				data : JSON.stringify(lopIntimation),
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
<script>
function addPermission(){
	var addPermission = {};
	    addPermission["idno"] = $("#idno").val();
	    addPermission["infodate"] = $("#permissiondate").val();
	    addPermission["fromhrs"] = $("#fromtime").val();
	    addPermission["tohrs"] = $("#totime").val();
	    addPermission["remarks"] = $("#reasonforpermission").val();
	    addPermission["permission_mins"] = $("#noofminutes").val();
	  // addPermission["permissiontype"] = $("#permissiontype").val();
	    var checkBox = document.getElementById("permissiontype");
	    if (checkBox.checked){
	    	addPermission["permissiontype"] = "O";  
	    } else {
	    	addPermission["permissiontype"] = "P";  
	    }
			$.ajax({
				type : "post",
				contentType : "application/json",
				url : "saveAddPermission", //this is my servlet
				data : JSON.stringify(addPermission),
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
<script>
		
function timeCalculating()
{
  var time1 = $("#fromtime").val();
  var time2 = $("#totime").val();
  var time1 = time1.split(':');
  var time2 = time2.split(':');
  var hours1 = parseInt(time1[0], 10), 
  hours2 = parseInt(time2[0], 10),
  mins1 = parseInt(time1[1], 10),
  mins2 = parseInt(time2[1], 10);
  var hours = hours2 - hours1, mins = 0;
  if(hours >= 1){
	 var  min = (hours*60);
  }
  if(mins2 >= mins1) {
      mins = mins2 - mins1;
  }
  else {
    mins = (mins2 + 60) - mins1;
    hours--;
  }
  if(mins < 9)
  {
    mins = '0'+mins;
  }
   
  $("#noofminutes").val(min+mins);
}
</script>
<style>
	
</style>
<div>
    <h3 align="center" style="color: linear-gradient(to bottom, #33ccff 2%, #6666ff 60%)">Permissions</h3>
</div>
	<hr color="blue">
     <div align="left" class="box-content row"  >
		<div  class="form-group has-warning col-md-3">
		    <label data-error="wrong" data-success="right"  style="color: var(--cyan)">Id No:</label>
			<input type="text" id="idno" class="form-control" placeholder="Enter your ID" style="border:1px solid #696969" >
		</div>	
		<div  class="form-group has-warning col-md-1 ">
		  <label data-error="wrong" data-success="right" ></label>
	      <input type="submit"  value="Submit" onclick=" getDetailsBasedOnIdno()" 	class="form-control"  style="background-color: #4d79ff;cursor: pointer;size:auto; 
	color:white;position: relative; top:10px;text-decoration:blod">
		</div>
		</div>
		<div id="changeBasedonIdno" >		
		<div  class="box-content row">
		<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right">EmployeeName</label>
						<input type="text" id="empname" class="form-control" readonly="readonly" >
		</div>
		<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right" >Designation</label>
						<input type="text" id="design" class="form-control" readonly="readonly" >
		</div>
		<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right" >Department</label>
						<input type="text" id="workdeptname" class="form-control" readonly="readonly" >
		</div>
		<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right" >Division</label>
						<input type="text" id="divisionname" class="form-control" readonly="readonly" >
		</div>
		</div>
	<div>	
	<hr color="blue">
		<div  class="form-group has-warning col-md-3">
						<label data-error="wrong" data-success="right" >SelectType</label>
        <select>
            <option>ChooseType</option>
            <option value="permission">Permission</option>
            <option value="passel">PassEL</option>
            <option value="passsl">PassSL</option>
            <option value="passcl">PassCL</option>
            <option value="passleave">PassLeave</option>
            <option value="forgetpunch">ForgetPunch</option>
            <option value="lopintimation">LopIntimatation</option>
        </select>
    </div>
    </div>		
<h5 align="center" id="deletemessage" style="color:red"></h5>

<hr color="blue">
	<div class="permission box"> 
	
					<h3  style="color: #08c">Add Permission</h3>
					<br>
					 <div align="left" class="box-content row" style="background:rgba(255,255,255,0)" >
					
					<div class="form-group has-warning col-md-3" >
							<label class="control-label" for="inputWarning1" style="text-align:centre"> Date:</label> 
							<input type="text" id="permissiondate" name="permissiondate"  class="form-control">
						</div>
						
						<div class="form-group has-warning col-md-3" >
							<label class="control-label" for="inputWarning1"> From Time:</label> 
							 <input type="text" id="fromtime" name="fromtime"  class="form-control" onchange="timeCalculating()"> 	
						</div>
				
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1"> To Time:</label>
							<input type="text" id="totime" name="totime"  class="form-control" onchange="timeCalculating()">
						</div>						
					
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1"> No.of Minutes</label> 
						<input type="text" id="noofminutes"  class="form-control" >
						</div>
						
			           <div class="form-group has-warning col-md-3">
			               <label class="control-label" for="inputWarning1">Reason:</label>
			                  <textarea rows="4" cols="10" id="reasonforpermission"
				                  name="reasonforpermission" class="form-control">
			                  </textarea>
		               </div>
					</div>
                       <div class="form-group has-warning    col-md-3">
			                <label class="control-label" for="inputWarning1">Is It Official</label><br>
			                 <input type="checkbox" id="permissiontype">
		             </div>
					<br>
					<div align="center">
						<input type="button" id="leave_btn" class="btn btn-success" value="submit"  onclick="addPermission()" style="position:relative;top:-35px;left:-20px;" >
					</div>
               </div>
       
    <div class="passel box">
               <h3  style="color: blue">PassEL</h3>
			<br>
				<div  class="box-content row">
               <div class="form-group has-warning col-md-3" >
							<label class="control-label" for="inputWarning1">Date</label> 
							<input type="text" id="eldate" name="eldate"  class="form-control">
						</div>
			  <div class="form-group has-warning col-md-4">
			               <label class="control-label" for="inputWarning1">Reason</label>
			                  <textarea rows="4" cols="10" id="reasonforel"
				                  name="reasonforpermission" class="form-control">
			                  </textarea>
		               </div>
						<div align="center">
						<input type="button" id="leave_btn" class="btn btn-success" value="submit" onclick="passel()" >
					</div>
					</div>
                         </div>
              <div class="passsl box">
                   <h3  style="color: #99b3ff">Pass SL</h3>
			    <br>
			    	<div  class="box-content row">
                   <div class="form-group has-warning col-md-3" >
							<label class="control-label" for="inputWarning1">Date</label> 
							<input type="text" id="sldate" name="sldate"  class="form-control">
						</div>
						
				   <div class="form-group has-warning col-md-4">
			               <label class="control-label" for="inputWarning1">Reason</label>
			                  <textarea rows="4" cols="10" id="reasonforsl"
				                  name="reasonforpermission" class="form-control">
			                  </textarea>
		                </div>
		               
						<div align="center">
						<input type="button" id="leave_btn" class="btn btn-success" value="submit" onclick="passsl()" >
					</div>
					</div>
                       </div>
             <div class="passcl box">
                   <h3  style="color: blue">PassCL</h3>
			    <br>
			    	<div  class="box-content row">
                  <div class="form-group has-warning col-md-3" >
							<label class="control-label" for="inputWarning1">Date</label> 
							<input type="text" id="cldate" name="cldate"  class="form-control">
						</div>
						
				 <div class="form-group has-warning col-md-4">
			               <label class="control-label" for="inputWarning1">Reason</label>
			                  <textarea rows="4" cols="10" id="reasonforcl"
				                  name="reasonforpermission" class="form-control">
			                  </textarea>
		               </div>
		               
						<div align="center">
						<input type="button" id="leave_btn" class="btn btn-success" value="submit"  onclick="passcl()" >
					</div>
					</div>
						</div>
            <div class="passleave box">
                  <h3  style="color: blue">PassLeave</h3>
			  <br>
			  	<div  class="box-content row">
                 <div class="form-group has-warning col-md-3" >
							<label class="control-label" for="inputWarning1">Date</label> 
							<input type="text" id="passleavedate" name="passleavedate"  class="form-control">
						</div>
				 <div class="form-group has-warning col-md-3">
			               <label class="control-label" for="inputWarning1">Reason</label>
			                  <textarea rows="4" cols="10" id="reasonforpassleave"
				                  name="reasonforpermission" class="form-control">
			                  </textarea>
		               </div>		
						<div align="center">
						<input type="button" id="leave_btn" class="btn btn-success" value="submit"  onclick="passLeave()" >
					</div>
					</div>
						</div>
           <div class="forgetpunch box">
                  <h3  style="color: blue">ForgetPunch</h3>
			  <br>
			  	<div  class="box-content row">
                  <div  class="form-group has-warning col-md-3" >
							<label class="control-label" for="inputWarning1">Date</label> 
							<input type="text" id="forgetpunchdate" name="forgetpunchdate"  class="form-control">
						</div>
				  <div class="form-group has-warning col-md-3">
			               <label class="control-label" for="inputWarning1">Reason</label>
			                  <textarea rows="4" cols="10" id="reasonforforgetpunch"
				                  name="reasonforpermission" class="form-control">
			                  </textarea>
		               </div>
						<div align="center">
						<input type="button" id="leave_btn" class="btn btn-success" value="submit" onclick="forgetPunch()" >
					</div>
					</div>
						</div>
           <div class="lopintimation box">
                 <h3  style="color: blue">LopIntimation</h3>
			   <br>
			     	<div  class="box-content row"> 
                  <div class="form-group has-warning col-md-3" >
							<label class="control-label" for="inputWarning1">Date</label> 
							<input type="text" id="lopintimationdate" name="lopintimationtime"  class="form-control">
						  </div>
						  
						   <div class="form-group has-warning col-md-3">
			               <label class="control-label" for="inputWarning1">Reason</label>
			                  <textarea rows="4" cols="10" id="reasonforlopintimation"
				                  name="reasonforpermission" class="form-control">
			                  </textarea>
		               </div>
		               
					      <div align="center">
						    <input type="button" id="leave_btn" class="btn btn-success" value="submit" onclick="lopIntimation()" >
					      </div>
					      </div>
						</div>
<div id="permissiontable"  class="search-table-outter wrapper" >
<table id="permissionsList" class="display" style="width:100%" border="1">
        <thead>
            <tr>
                <th>TranID</th>
           		<th>TransactionDate</th>
                <th>PassEL</th>
              	<th>PassCL</th>
              	<th>PassSL</th>
              	<th>PassLeave</th>
              	<th>ForgetPunch</th>
              	<th>LopIntimation</th>
              	<th>PermissionMinute</th>
                <th>PermissionType</th>
              	<th>PermissionRemarks</th>
              	<th>Delete</th>
                
            </tr>
        </thead>
    </table>
    </div>
						</div>
						
 <script src="resources/validation/bootstrapValidator.min.js"></script>
 <script src="resources/dist/js/sidebarmenu.js"></script> 
 <%@include file="footer.jsp"%>
<script>
jQuery('#eldate').datepicker({
    autoclose: true,
    todayHighlight: true
});

jQuery('#sldate').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#cldate').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#passleavedate').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#forgetpunchdate').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#lopintimationdate').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#permissiondate').datepicker({
    autoclose: true,
    todayHighlight: true
});
</script>
