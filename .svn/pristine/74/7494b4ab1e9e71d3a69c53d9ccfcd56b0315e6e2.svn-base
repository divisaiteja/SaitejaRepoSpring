<%@include file="header.jsp" %>
<script>


function empEdit(){
	var empEditData = {};
	empEditData["empstatusid"] = $("#empstatusid").val();
	empEditData["description"] = $("#description").val();
	empEditData["statusCodeForActive"] = $("#isactive").val();
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editEmpstatus", //this controller url
        data : JSON.stringify(empEditData),
        success: function(data){  
        	empstatus();
        }
    });
}
</script>
<%
int empstatusid=Integer.parseInt(request.getParameter("empstatusid"));

String description=request.getParameter("description");
String statusCodeForActive=request.getParameter("isactive");

%><div>
<br>
<h3 align="center" style="color:#fb8c00">Edit EmpStatus</h3>
<br>
				<div class="box-content row">
						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">EmpStatusid</label> 
							<input type="text"  name="empstatusid" id="empstatusid" value="<%out.println(empstatusid); %>" class="form-control"
							readonly="readonly"	>

						</div>

						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">Description
								</label> <input type="text"  id="description" value="<%out.println(description); %>"  name="description"
								class="form-control" >

						</div>

						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">Status
								</label> <input type="text" name="statusCodeForActive" id="isactive" value="<%out.println(statusCodeForActive); %>"class="form-control"
								>

						</div>



					
						</div>
						
		
		<div align="center">
		<input type="submit" class="btn btn-success" onclick="empEdit()"  >
		<input type="submit" class="btn btn-success" onclick="empstatus()" value="back" >
		</div>
		</div>
		<%@include file="footer.jsp" %>