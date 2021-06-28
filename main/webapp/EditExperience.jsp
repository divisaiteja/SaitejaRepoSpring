<script>



function disableTextBox() {
	document.getElementById("parentid").disabled = false;
	document.getElementById("employeename").disabled = false;
	document.getElementById("address").disabled = false;
	document.getElementById("workperiod").disabled = false;
	document.getElementById("experiencedetails").disabled = false;
	document.getElementById("designation").disabled = false;
	document.getElementById("ctc").disabled = false;
	document.getElementById("remarks").disabled = false;
	document.getElementById("tranid").disabled = false;
	

}


</script>
<script >


	//alert(tranid)
$(document).ready(function() {
	var tranid=document.getElementById("tranids").value;
	alert(tranid);
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "getExperienceInfoByTranid?tranid="+tranid, //this is my servlet
          success: function(data){ 
        document.getElementById("parentid").value =data[0]["parentid"]
        document.getElementById("employeename").value =data[0]["employeename"]
        document.getElementById("address").value =data[0]["address"]
        document.getElementById("workperiod").value =data[0]["workperiod"]
        document.getElementById("experiencedetails").value =data[0]["experiencedetails"]  
        document.getElementById("designation").value =data[0]["designation"]  
        document.getElementById("ctc").value =data[0]["ctc"] 
        document.getElementById("remarks").value =data[0]["remarks"] 
        document.getElementById("tranid").value =data[0]["tranid"] 
        
  
        }
 });
		});




$(document).ready(function() {
	document.getElementById("parentid").disabled = true;
	document.getElementById("employeename").disabled = true;
	document.getElementById("address").disabled = true;
	document.getElementById("workperiod").disabled = true;
	document.getElementById("experiencedetails").disabled = true;
	document.getElementById("designation").disabled = true;
	document.getElementById("ctc").disabled = true;
	document.getElementById("remarks").disabled = true;
	document.getElementById("tranid").disabled = true;
	
});
</script>
<script>

function editexpinfo(){
	
	alert();
	var editexpData = {};
	editexpData["parentid"] = $("#parentid").val();
	editexpData["employeename"] = $("#employeename").val();
	editexpData["address"] = $("#address").val();
	editexpData["workperiod"] = $("#workperiod").val();
	editexpData["experiencedetails"] = $("#experiencedetails").val();
	editexpData["designation"] = $("#designation").val();
	editexpData["ctc"] = $("#ctc").val();
	editexpData["remarks"] = $("#remarks").val();
	editexpData["tranid"] = $("#tranid").val();
	
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editExperiencedetails", //this is my servlet
        data : JSON.stringify(editexpData),
//         data: {
//             visitorname: $('#visitorname').val(),
//         },
        success: function(data){ 
        	goback();
			//empinfo();
        }
 });
	
}

function goback(){
	var tranid=document.getElementById("parenttranid").value;
	openEditPage(tranid);
}



</script>


<div>
<%
	int tranid = Integer.parseInt(request.getParameter("tranid"));
 int parenttranid = Integer.parseInt(request.getParameter("parenttranid"));
%>

<input type="text" id="tranids" value="<%out.println(tranid);%>">
<input type="text" id="parenttranid" value="<%out.println(parenttranid);%>">
		<hr color="00FFFF">
		<div class="box-content row">
			<div class="col-md-6">
				<h4 align="left" style="color: #fb8c00">Experience Details</h4>

			</div>


			<div class="col-md-6">
				<input type="image" id="image" alt="Login" align="right"
					onclick="disableTextBox()"
					src="resources/assets/images/edit-icon.png" height="15" width="15">
			</div>

		</div>
		<!-- <hr color="00FFFF"> -->
  
	</div>

<div class="box-content row">

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">ParentId</label> <input
				type="text"  id="parentid"class="form-control"readonly="readonly">

		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">EmployeeName</label> <input
				type="text"  id="employeename" class="form-control">

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Address</label> <input
				type="text"  id="address"class="form-control">

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">WorkPeriod</label> 
			<input
				type="text"  id="workperiod" class="form-control">

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">ExperienceDetails</label> <input
				type="text"  id="experiencedetails" class="form-control">

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Designation</label> <input
				type="text" id="designation" class="form-control">

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Ctc</label> <input
				type="text"  id="ctc" class="form-control">

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Remarks</label> <input
				type="text" id="remarks" class="form-control">

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Tranid</label> <input
				type="text" id="tranid" class="form-control"readonly="readonly">

		</div>
	
	</div>

	<div align="right">
		<input type="submit" class="btn btn-success"    value="update"  onclick="editexpinfo()"> 
		<input type="submit" class="btn btn-success" onclick="goback()" value="back">


	</div>
