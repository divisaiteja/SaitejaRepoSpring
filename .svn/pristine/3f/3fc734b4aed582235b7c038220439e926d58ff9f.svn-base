<%@include file="header.jsp" %>
<script>


function gradeEdit(){
	var gradeEditData = {};
	gradeEditData["gradeno"] = $("#gradeno").val();
	gradeEditData["code"] = $("#code").val();
	gradeEditData["description"] = $("#description").val();
	gradeEditData["cadrecode"] = $("#cadrecode").val();
	gradeEditData["statusCodeForActive"] = $("#isactive").val();
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editGrade", //this controller url
        data : JSON.stringify(gradeEditData),
        success: function(data){  
        	gradesList();
         
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

</script>
<%
int gradeno=Integer.parseInt(request.getParameter("gradeno"));
String code=request.getParameter("code");
String description=request.getParameter("description");
String cadrecode=request.getParameter("cadrecode");
String statusCodeForActive=request.getParameter("isactive");

%><div>
<br>
<h3 align="center" style="color:#fb8c00">Edit Grade</h3>
<br>
				<div class="box-content row">
						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">GradeNo</label> 
							<input type="text"  name="gradeno" id="gradeno" value="<%out.println(gradeno); %>" class="form-control"
							readonly="readonly"	>

						</div>
						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">Code
								</label> <input type="text"  id="code" value="<%out.println(code); %>"  name="code"
								class="form-control" >

						</div>
						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">Description
								</label> <input type="text"  id="description" value="<%out.println(description); %>"  name="description"
								class="form-control" >

						</div>

						 <div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">Cadrecode
								</label> <input type="text"  id="cadrecode" value="<%out.println(cadrecode); %>"  name="cadrecode"
								class="form-control" >

						</div>

						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">Status
								</label> <input type="text" name="isactive" id="isactive" value="<%out.println(statusCodeForActive); %>"class="form-control"
								>

						</div>



					
						</div>
						
		
		<div align="center">
		<input type="submit" class="btn btn-success" onclick="gradeEdit()"  >
		<input type="submit" class="btn btn-success" onclick="gradesList()" value="back" >
		</div>
		</div>
		<%@include file="footer.jsp" %>