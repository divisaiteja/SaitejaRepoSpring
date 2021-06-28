<script>

function disableTextBox() {
	document.getElementById("parentid").disabled = false;
	document.getElementById("certificates").disabled = false;
	document.getElementById("institutionname").disabled = false;
	document.getElementById("address").disabled = false;
	document.getElementById("yearofpassing").disabled = false;
	document.getElementById("markspercentage").disabled = false;
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
        url: "getEducationInfoByTranid?tranid="+tranid, //this is my servlet
          success: function(data){ 
        document.getElementById("parentid").value =data[0]["parentid"]
        document.getElementById("certificates").value =data[0]["certificates"]
        document.getElementById("institutionname").value =data[0]["institutionname"]
        document.getElementById("address").value =data[0]["address"]
        document.getElementById("yearofpassing").value =data[0]["yearofpassing"]  
        document.getElementById("markspercentage").value =data[0]["markspercentage"]  
        document.getElementById("remarks").value =data[0]["remarks"] 
        document.getElementById("tranid").value =data[0]["tranid"] 
        
  
        }
 });
		});




$(document).ready(function() {
	document.getElementById("parentid").disabled = true;
	document.getElementById("certificates").disabled = true;
	document.getElementById("institutionname").disabled = true;
	document.getElementById("address").disabled = true;
	document.getElementById("yearofpassing").disabled = true;
	document.getElementById("markspercentage").disabled = true;
	document.getElementById("remarks").disabled = true;
	document.getElementById("tranid").disabled = true;
	
});
</script>



<script >
function editeduinfo() {
	alert("educationEditinfo");
		var educationEditData = {};
		educationEditData["parentid"] = $("#parentid").val();
		educationEditData["certificates"] = $("#certificates").val();
		educationEditData["institutionname"] = $("#institutionname").val();
		educationEditData["address"] = $("#address").val();
		educationEditData["yearofpassing"] = $("#yearofpassing").val();
		educationEditData["markspercentage"] = $("#markspercentage").val();
		educationEditData["remarks"] = $("#remarks").val();
		educationEditData["tranid"] = $("#tranid").val();
		
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "editEducationdetails", //this controller url
			data : JSON.stringify(educationEditData),
			success : function(data) {
				goback();

				//           	$('#processedData').html(data);
				// 			$('#displayDiv').show();

				// 			alert();
				// 			$('#myModal').modal({
				// 			    backdrop: 'static',
				// 			    keyboard: true
				// 			})
			}

		});

	}
	
	
	
		 function goback(){
				var tranid=document.getElementById("parenttranid").value;
				openEditPage(tranid);
			}

	 
</script>
<%-- <% 

	int parentid = Integer.parseInt(request.getParameter("parentid"));
	String certificates = request.getParameter("certificate");
	String institutionname = request.getParameter("institutename");
	String address = request.getParameter("address");
	String yearofpassing = request.getParameter("yearofpassing");
	float markspercentage =Float.parseFloat(request.getParameter("markspercentage"));
	String remarks = request.getParameter("remarks");
	int tranid = Integer.parseInt(request.getParameter("tranid"));
	

%>
 --%>
 <%
	int tranid = Integer.parseInt(request.getParameter("tranid"));
 int parenttranid = Integer.parseInt(request.getParameter("parenttranid"));
 
%>
 
 <input type="text" id="tranids" value="<%out.println(tranid);%>">
 <input type="text" id="parenttranid" value="<%out.println(parenttranid);%>">
 
		<hr color="00FFFF">
		<div class="box-content row">
			<div class="col-md-6">
				<h4 align="left" style="color: #fb8c00">Education Details</h4>

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
				type="text"  id="parentid" class="form-control"
				readonly="readonly">

		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Certificates</label> <input
				type="text"  id="certificates" class="form-control">

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">InstitutionName</label> <input
				type="text"  id="institutionname" class="form-control">

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Address</label> <input
				type="text"  id="address" class="form-control">

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">YearOfPassing</label> <input
				type="text"  id="yearofpassing" class="form-control">

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">MarksPercentage</label> <input
				type="text" id="markspercentage" class="form-control">

		</div>
		
		
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Remarks</label> <input
				type="text" id="remarks" class="form-control">

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">TranId</label> <input
				type="text" id="tranid" class="form-control" readonly="readonly">

		</div>
	
	</div>

	<div align="right">
		<input type="submit" class="btn btn-success"    value="update"  onclick="editeduinfo()"> 
		<input type="submit" class="btn btn-success" onclick="goback()" value="back">
</div>

