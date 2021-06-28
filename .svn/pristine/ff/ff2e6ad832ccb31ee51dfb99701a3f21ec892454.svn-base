<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HI this Edit page</h1>
<script>
	function ExperienceEditinfo() {
		
		var experienceEditData = {};
		experienceEditData["parentid"] = $("#parentid").val();
		experienceEditData["employeename"] = $("#employeename").val();
		experienceEditData["address"] = $("#address").val();
		experienceEditData["workperiod"] = $("#workperiod").val();
		experienceEditData["experiencedetails"] = $("#experiencedetails").val();
		experienceEditData["designation"] = $("#designation").val();
		experienceEditData["ctc"] = $("#ctc").val();
		experienceEditData["remarks"] = $("#remarks").val();
		experienceEditData["tranid"] = $("#tranid").val();

		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "editExperiencedetails", //this controller url
			data : JSON.stringify(experienceEditData),
			success : function(data) {
				//empinfo();

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
	int parentid = Integer.parseInt(request.getParameter("parentid"));
	
	//name,dateofjoining,dateOfBirth,employeeStatus
	String employeename = request.getParameter("employeename");
	String address = request.getParameter("address");
	String workperiod = request.getParameter("workperiod");
	String experiencedetails = request.getParameter("experiencedetails");
	String designation = request.getParameter("designation");
	String ctc = request.getParameter("ctc");
	String remarks = request.getParameter("remarks");
	int tranid = Integer.parseInt(request.getParameter("tranid"));
	

%>
<div class="box-content row">

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">ParentId</label> <input
				type="text"  id="sl"
				value="<%out.println(parentid);%>" class="form-control"
				readonly="readonly">

		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">EmployeeName</label> <input
				type="text"  id="employeename"
				value="<%out.println(employeename);%>" class="form-control"
				>

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Address</label> <input
				type="text"  id="address"
				value="<%out.println(address);%>" class="form-control"
			>

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">WorkPeriod</label> <input
				type="text"  id="workperiod"
				value="<%out.println(workperiod);%>" class="form-control"
				>

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">ExperienceDetails</label> <input
				type="text"  id="experiencedetails"
				value="<%out.println(experiencedetails);%>" class="form-control"
				>

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Designation</label> <input
				type="text" id="designation"
				value="<%out.println(designation);%>" class="form-control"
				>

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Ctc</label> <input
				type="text"  id="ctc"
				value="<%out.println(ctc);%>" class="form-control"
				>

		</div>
		
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Remarks</label> <input
				type="text" id="remarks"
				value="<%out.println(remarks);%>" class="form-control"
				>

		</div>
		
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">TranId</label> <input
				type="text" id="idno"
				value="<%out.println(tranid);%>" class="form-control"
				readonly="readonly">

		</div>
		
		
		

		
		


		

	</div>




	<div align="right">
		<input type="submit" value="update" class="btn btn-success"
			onclick="empEdit()"> <input type="submit"
			class="btn btn-success" onclick="empinfo()" value="back">


	</div>

</body>
      	    <script src="resources/dist/js/sidebarmenu.js"></script>

</html>