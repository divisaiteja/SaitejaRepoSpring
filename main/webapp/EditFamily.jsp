<script >


$(document).ready(function() {
	var tranid=document.getElementById("tranids").value;
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "getFamilyInfoByTranid?tranid="+tranid, //this is my servlet
          success: function(data){ 
        document.getElementById("parentid").value =data[0]["parentid"]
        document.getElementById("gender").value =data[0]["gender"]
        document.getElementById("name").value =data[0]["name"]
        document.getElementById("relation").value =data[0]["relation"]
        document.getElementById("dob").value =data[0]["dob"]  
        document.getElementById("adhaarno").value =data[0]["adhaarno"]  
        document.getElementById("qualification").value =data[0]["qualification"] 
        document.getElementById("occupation").value =data[0]["occupation"]  
        document.getElementById("mobileno").value =data[0]["mobileno"] 
        document.getElementById("tranid").value =data[0]["tranid"] 
        
  
        }
 });
		});


</script>
<script>

function editfamilyinfo(){
	
	alert();
	var editfamilyData = {};
	editfamilyData["parentid"] = $("#parentid").val();
	editfamilyData["gender"] = $("#gender").val();
	editfamilyData["name"] = $("#name").val();
	editfamilyData["relation"] = $("#relation").val();
	editfamilyData["dob"] = $("#dob").val();
	editfamilyData["adhaarno"] = $("#adhaarno").val();
	editfamilyData["qualification"] = $("#qualification").val();
	editfamilyData["occupation"] = $("#occupation").val();
	editfamilyData["mobileno"] = $("#mobileno").val();
	editfamilyData["tranid"] = $("#tranid").val();
	
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editFamilydetails", //this is my servlet
        data : JSON.stringify(editfamilyData),
//         data: {
//             visitorname: $('#visitorname').val(),
//         },
        success: function(data){ 
        	
			goback();
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
<div class="box-content row">

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">ParentId</label> <input
				type="text"  id="parentid"class="form-control"
				readonly="readonly">

		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Gender</label> <input
				type="text"  id="gender" class="form-control">

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Name</label> <input
				type="text"  id="name" class="form-control">

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Relation</label> <input
				type="text"  id="relation" class="form-control"	>

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">DateOfBirth</label> <input
				type="text"  id="dob"class="form-control">

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">AdhaarNo</label> <input
				type="text" id="adhaarno"class="form-control">

		</div>
		
		
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">qualification</label> <input
				type="text" id="qualification" class="form-control">

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Occupation</label> <input
				type="text" id="occupation" class="form-control">

		</div>
		
		
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">MobileNo</label> <input
				type="text" id="mobileno"class="form-control">

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">TranId</label> <input
				type="text" id="tranid"class="form-control"
				readonly="readonly">

		</div>
	
	</div>

	<div align="right">
		<input type="submit" class="btn btn-success"    value="update"  onclick="editfamilyinfo()"> 
		<input type="submit" class="btn btn-success" onclick="goback()" value="back">
</div>


