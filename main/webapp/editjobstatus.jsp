<%@include file="header.jsp" %>
<script>
function jobEdit(){
	var jobEditData = {};
	jobEditData["jobstatusid"] = $("#jobstatusid").val();
	jobEditData["description"] = $("#description").val();
	jobEditData["statusCodeForActive"] = $("#isactive").val();
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editJobstatus", //this controller url
        data : JSON.stringify(jobEditData),
        success: function(data){  
        	
        }
   
    });
   
}

</script>
<%
int jobstatusid=Integer.parseInt(request.getParameter("jobstatusid"));

String description=request.getParameter("description");
String statusCodeForActive=request.getParameter("isactive");
//int isactive=Integer.parseInt(request.getParameter("isactive"));

%><div>
<br>
<h3 align="center" style="color:#fb8c00">Edit Jobstatus</h3>
<br>
				<div class="box-content row">
						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">JobStatusId</label> 
							<input type="text"  name="jobstatusid" id="jobstatusid" value="<%out.println(jobstatusid); %>" class="form-control"
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
		<input type="submit" class="btn btn-success" onclick="jobEdit()"  >
		<input type="submit" class="btn btn-success" onclick="jobstatus()" value="back" >
		</div>
		</div>
		<%@include file="footer.jsp" %>