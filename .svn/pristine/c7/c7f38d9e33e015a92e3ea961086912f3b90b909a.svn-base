<%@include file="header.jsp" %>

<script>


function bgroupEdit(){
	var bgroupEditData = {};
	bgroupEditData["tranid"] = $("#tranid").val();
	bgroupEditData["bloodgroup"] = $("#bloodgroup").val();
	
	
	
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editbgroup", //this controller url
        data : JSON.stringify(bgroupEditData),
        success: function(data){  
        	bgroup();

        }
   
    });
   
}

</script>
<%
int tranid=Integer.parseInt(request.getParameter("tranid"));

String bloodgroup=request.getParameter("bloodgroup");


%><div>
<br>
<h3 align="center" style="color:#fb8c00">Edit BloodGroup</h3>
<br>
				<div class="box-content row">
						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">Tranid</label> 
							<input type="text"  name="tranid" id="tranid" value="<%out.println(tranid); %>" class="form-control"
							readonly="readonly"	>

						</div>

						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">BloodGroup
								</label> <input type="text"  id="bloodgroup" value="<%out.println(bloodgroup); %>"  name="bloodgroup"
								class="form-control" >

						</div>

						


					
						</div>
						
		
		<div align="center">
		<input type="submit" class="btn btn-success" onclick="bgroupEdit()"  >
		<input type="submit" class="btn btn-success" onclick="bgroup()" value="back" >
		</div>
		</div>
		<%@include file="footer.jsp" %>