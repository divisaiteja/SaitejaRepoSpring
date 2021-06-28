<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-info-sign"></i> Family Details
				</h2>


			</div>


			<div class="box-content row">
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Date Of
						Joining</label> <input type="text" id="dateOfJoining" name="dateOfJoining"
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Designation</label>
					<input type="text" id="design" name="design" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">EmployeeName</label>
					<input type="text" id="employeeName" name="employeeName"
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" name="gradeId" for="inputWarning1">Grade</label>
					<select class="form-control" id="gradeId">
						<option value="">select</option>
						<option value="1">Manager</option>
						<option value="2">Dy.Manager</option>
						<option value="3">Asst.Manager</option>
						<option value="4">DGM</option>
						<option value="5">AGM</option>
						<option value="6">Sr.Manager</option>
						<option value="7">Sr.Supervisor</option>
						<option value="8">Jr.Assistant</option>
						<option value="9">Supervisor</option>
						<option value="10">Vice-President</option>
						<option value="11">CEO</option>
						<option value="12">Fitter</option>
						<option value="13">Welder</option>
					</select>

				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" name="jobStatus" for="inputWarning1">JobStatus</label>
					<select class="form-control" id="jobStatus">
						<option value="">select</option>
						<option value="1">Permanent</option>
						<option value="2">Probation</option>
						<option value="3">Temporary</option>
						<option value="4">Retainer</option>
						<option value="5">Training</option>

					</select>

				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" name="cadreId" for="inputWarning1">Cadre</label>
					<select class="form-control" id="cadreId">
						<option value="">select</option>
						<option value="1">Executive</option>
						<option value="2">Supervisor</option>
						<option value="3">Workmen</option>
						<option value="4">Trainee</option>
					</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" name="" for="inputWarning1">Department</label>
					<select class="form-control" id="workDeptId">
						<option value="">select</option>
						<option value="2">Hr-Admin</option>
						<option value="3">Electrical</option>
						<option value="4">Finance&Accounts</option>
						<option value="5">MaterialProcurement</option>
						<option value="7">Production&QualityControl</option>
						<option value="8">Mines&Metalergy</option>
						<option value="9">Sales&Marketing</option>

					</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Gender</label> <select
						class="form-control" id="gender">
						<option value="">select</option>
						<option value="male">Male</option>
						<option value="Female">Female</option>
						<option value="Other">Other</option>
					</select>
				</div>

				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Section</label> <select
						class="form-control" id="sectionId">
						<option value="">select</option>
						<option value="1">HumanResource</option>
						<option value="2">Administration</option>
						<option value="3">Safety</option>
						<option value="4">Security</option>
						<option value="5">TimeOffice</option>
						<option value="6">Dispensary</option>
						<option value="7">Horticulture</option>
						<option value="8">Stores</option>
						<option value="9">RawMaterials</option>
						<option value="10">Procurement</option>
					</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">JobType</label> <select
						class="form-control" id="jobtype">
						<option value="">select</option>
						<option value="permanent">permanent</option>
						<option value="temporary">temporary</option>
					</select>
				</div>

				<!-- <div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">ReportingTo</label>
					<select class="form-control">
						<option value="">select</option>
						<option value="HR">HR</option>
						<option value="Manager">Manager
						</option>
					</select>
				</div>
				 -->
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Project</label><br>
					<select class="form-control" id="project">
						<option value="Project1">Project1</option>
						<option value="Project2">Project2</option>
						<option value="Project3">Project3</option>
						<option value="Project4">Project4</option>
					</select>
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" id="isTechnical" for="inputWarning1">IsTechnical</label><br>
					<label> <input type="checkbox" value="1">Yes
					</label><br>
				</div>

			</div>


		</div>
		<div align="center">
			<input type="submit" class="btn btn-success" value=" Add"
				onclick="saveJobDetails1()">
		</div>

	</div>

</div>
      	    <script src="resources/dist/js/sidebarmenu.js"></script>

</body>

</html>