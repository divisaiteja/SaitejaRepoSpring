<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="resources/customjs/editemployeesjs.js?"></script>
<script src="resources/customjs/family.js"></script>
<script src="resources/customjs/education.js?"></script>
<script src="resources/customjs/empexperience.js?"></script>
<script src="resources/customjs/empsalaries.js"></script>
<script src="resources/customjs/EnableDisableTestBoxes.js"></script>
<link rel="stylesheet"
	href="resources/dist/css/icons/font-awesome/css/fontawesome.min.css">
<link rel="stylesheet" type="text/css"
	href="resources/validation/validation.css">

<style type="text/css">
.thumb-image {
	float: left;
	width: 100px;
	position: relative;
	padding: 5px;
}

image-holder
{
    width:25px;
    height:25px;
    background-cover;
    background-repeat:no-repeat;
}
</style>
<script>
	$(document).ready(function() {
		EnableEmpJobDetailsTextBoxes();
	});

	function disableTextBox() {
		DisableEmpJobDetailsTextBoxes();
	}

	$(document).ready(function() {
		disableOtherDetails();
	});

	$(document).ready(function() {
		EnablePersonalInfo();
	});

	function disableTextBox2() {
		DisablePersonalInfo();
	}

	$(document).ready(function() {
		enableEmployeeShiftSch();
	});

	function disableTextBox4() {
		disableEmployeeShiftSch();
	}

	$(document).ready(function() {
		disableSalary();

	});

	function disableTextBox3() {
		checkenableSalary();
		//enableSalary();
	}

	function resetFamilyForm() {
		document.getElementById("familyValidation").reset();
	}

	function reseteducationform() {

		document.getElementById("edu_form").reset();
	}
	function resetExperience() {
		document.getElementById("exp_form").reset();
	}
</script>
<script>
	$(document).ready(function() {
						$("#fileUpload").on('change',function() {
											var countFiles = $(this)[0].files.length;
											var imagesize = this.files[0].size;
											var kbconverter = imagesize / 1024;
											var imgPath = $(this)[0].value;
											var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
											var image_holder = $("#image-holder");
											image_holder.empty();
											if (extn == "jpg") {
												if (typeof (FileReader) != "undefined") {
													//loop for each file selected for uploaded.
													 for (var i = 0; i < countFiles; i++) {
														var reader = new FileReader();
														reader.onload = function(e) {$("<img />",{
																		"src" : e.target.result,
																		"class" : "thumb-image"
																	})
																	.appendTo(image_holder);
														}
														image_holder.show();
														reader
																.readAsDataURL($(this)[0].files[i]);
													} 
												} else {
													alert("This browser does not support FileReader.");
												}
											} else {
												alert("Pls select only images");
												$("#fileUpload").val('');
												window.location.reload();
											}
										});
					});
</script>

<script>
	$(document).ready(function() {
		var parentid = document.getElementById("idNumber").value;
		getImage(parentid);
	});
	
 function getImage(parentid) {
		var empid = parentid;
		//alert("empid     "+empid)
		 $.ajax({
			    bProcessing:true,
		        type: "get",
		        url: "getphotobasedonempid?empid="+empid, //this is my servlet
		        		success : function(data) {
		        	  var image = data.base64Image;
		        	     //console.log(image);
		        	$("#Item").attr("src", "data:image/png;base64," + image);
		        	
				}
		        
		  });
	
} 

	function download() {
		window.location.href = "#/download/";
	}
</script>
<input type="text" value="${tranid}" id="tranid" hidden="hidden" >
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3" align="right"></div>
		<div class="col-md-6">
			<h3 align="center" style="color: #fb8c00;">Employee Information</h3>
		</div>
		<div class="col-md-3" align="right">
     <img  height="70" width="70" class="rounded-circle" id = "Item"/> 
		</div>
	</div>
</div>
<!--  Job Details Start -->
<%
	String bioidasidno = request.getParameter("bioidasidno");
	String pflimit = request.getParameter("pflimit");
	String esilimit = request.getParameter("esilimit");
%>
<div>
	<hr color="00FFFF">
	<div class="box-content row">

		<div class="col-md-6">
			<h4 align="left" style="color: #fb8c00">Job Details</h4>
		</div>
		<input type="text" id="bioidasidno" value="<%=bioidasidno%>"
			hidden="hidden">
		<div class="col-md-6">
			<input type="image" id="image" alt="Login" align="right"
				onclick="disableTextBox()"
				src="resources/assets/images/edit-icon.png" height="15" width="15">

		</div>
	</div>
	<h4 id="jobdetailsUpdateDisplayMessage" style="color: green"
		align="center"></h4>
	<!-- <hr color="00FFFF"> -->
</div>


<br>
<form id="emp_form">
	<div class="box-content row">

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Division Id</label>
			<!-- <input
			type="text" class="form-control"> -->
			<select class="form-control" id="division" name="division"
				onchange="getAllReportees()">
			</select>
		</div>

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">ID No</label> <input
				type="text" name="idNumber" id="idNumber" value="${idNumber}"
				class="form-control" readonly="readonly">

		</div>

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Employee
				Code</label> <input type="text" id="empid" name="empid" class="form-control">

		</div>

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Employee
				Name</label> <input type="text" name="employeeName" id="empname"
				class="form-control">

		</div>

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">BiometricId
			</label> <input type="text" name="biometric_id" id="biometric_id"
				class="form-control">

		</div>

		<div class="form-group has-warning   col-md-3">
			<label class="control-label" for="inputWarning1">Gender</label> <select
				class="form-control" id="gender" name="gender">
				<option value="male">Male</option>
				<option value="Female">Female</option>
				<option value="Other">Other</option>
			</select>
		</div>

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1"> Date Of
				Joining</label> <input placeholder="YYYY-MM-DD" type="text" name="doj"
				id="doj" class="form-control">

		</div>

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Designation</label>
			<input list="desgnpop" id="design" name="design" class="form-control">
			<datalist id="desgnpop">
			</datalist>

		</div>

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">EmpLoyee
				Status</label> <select class="form-control" id="empstatus" name="empstatus">
			</select>
		</div>

		<div class="form-group has-warning   col-md-3">
			<label class="control-label" for="inputWarning1">JobType</label> <select
				class="form-control" id="jobtype" name="jobtype">

			</select>
		</div>

		<div class="form-group has-warning   col-md-3">
			<label class="control-label" for="inputWarning1">JobStatus</label> <select
				class="form-control" id="jobstatus" name="jobstatus">
			</select>
		</div>

		<div class="form-group has-warning   col-md-3">
			<label class="control-label" for="inputWarning1">Grade</label> <select
				class="form-control" id="gradeId" name="gradeId">

			</select>

		</div>

		<div class="form-group has-warning   col-md-3">
			<label class="control-label" for="inputWarning1">Cadre</label> <select
				class="form-control" id="cadreid" name="cadreid">

			</select>
		</div>
		<div class="form-group has-warning   col-md-3">
			<label class="control-label" for="inputWarning1">Department</label> <select
				class="form-control" id="workdeptid" name="workdeptid">

			</select>
		</div>

		<div class="form-group has-warning   col-md-3">
			<label class="control-label" for="inputWarning1">Section</label> <select
				class="form-control" id="sectionid" name="sectionid">
				<option value="0">select</option>
			</select>
		</div>

		<div class="form-group has-warning    col-md-3">
			<label class="control-label" for="inputWarning1">Project</label><br>
			<select class="form-control" id="project" name="project">
			</select>
		</div>

		<div class="form-group has-warning    col-md-3">
			<label class="control-label" for="inputWarning1">Reporting To</label>
			<select class="form-control" id="reportingempid"
				name="reportingempid">
				<option value="0">select</option>
			</select>
		</div>


		<div class="form-group has-warning   col-md-3">
			<label class="control-label" for="inputWarning1">Skill Set</label> <select
				class="form-control" id="skillid" name="skillid">
				<option value="0">Select</option>
				<option value="1">Skilled</option>
				<option value="2">Semi-Skilled</option>
				<option value="3">Un-Skilled</option>
			</select>
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">EmailId </label> <input
				type="text" id="EmailId" name="EmailId" class="form-control">

		</div>

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">MobileNumber
			</label> <input type="text" id="MobileNumber" name="MobileNumber"
				class="form-control">

		</div>

		<div class="form-group has-warning    col-md-3">
			<label class="control-label" for="inputWarning1">Is Reportee</label><br>
			<label> <input type="checkbox" id="isReportee">
			</label><br>
		</div>

		<div class="form-group has-warning    col-md-3">
			<label class="control-label" for="inputWarning1">Is Technical</label><br>
			<label> <input type="checkbox" id="isTechnical">
			</label><br>
		</div>

	</div>

	<div align="right">
		<input type="button" value="update" id="emp_btn"
			class="btn btn-success">


	</div>
</form>
<hr color="00FFFF">
<!--  Job Details End -->

<!-- ShiftShedule Start  -->
<script>
	
</script>


<div class="col-md-12">
	<input type="image" id="" alt="Login" align="right"
		onclick="disableTextBox4()"
		src="resources/assets/images/edit-icon.png" height="15" width="15">
</div>
<h4 id="empShiftsDisplayMessage" style="color: green" align="center"></h4>


<form id="employeeshiftschedule_form">
	<div class="box-content row">
		<div class="col-md-6">
			<h4 align="left" style="color: #fb8c00">Employee Shift Schedule</h4>

		</div>


	</div>

	<br>
	<div class="box-content row">
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">ParentID</label> <input
				type="text" id="shifschIdNumber" value="${idNumber}"
				class="form-control" readonly="readonly">

		</div>

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Monday</label> <select
				class="form-control" id="monday">

			</select>

		</div>

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Tuesday</label> <select
				class="form-control" id="tuesday">

			</select>

		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Wednesday</label> <select
				class="form-control" id="wednesday">

			</select>

		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Thursday</label> <select
				class="form-control" id="thursday">

			</select>

		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Friday</label> <select
				class="form-control" id="friday">


			</select>

		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Saturday</label> <select
				class="form-control" id="saturday">


			</select>

		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Sunday</label> <select
				class="form-control" id="sunday">


			</select>

		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">EffectFrom</label> <input
				type="text" id="effectFrom" class="form-control"
				placeholder="YYYY-MM-DD">


		</div>

		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">EffectTo</label> <input
				type="text" id="effectTo" class="form-control"
				placeholder="YYYY-MM-DD">

		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">OtEligibility</label>
			<select class="form-control" id="otEligibility" readonly="readonly">
				<option value="0">No</option>
				<option value="1">Yes</option>
			</select>
			<!-- <input type="text"  id="otEligibility"
			class="form-control"> -->

		</div>
		<!-- 
	<div class="form-group has-warning col-md-3" >
		<label class="control-label" for="inputWarning1">IsActive</label>
		<input type="hide"  id="isActive"
			class="form-control">

	</div> -->
	</div>
	<div align="right">
		<input type="submit" value="update" id="shiftshedulesubmit"
			class="btn btn-success" onclick="editEmployeeShifts()">
	</div>
</form>
<!--ShiftShedule End -->
<hr color="00FFFF">
<!-- Personal Information Start-->
<div>
	<h3 id="personalDetailsDisplayMessage" align="center"
		style="color: green"></h3>
	<div>
		<h3 align="left" style="color: #fb8c00">Personal Information</h3>
		<input align="right" type="image" id="image" alt="Login"
			onclick="disableTextBox2()"
			src="resources/assets/images/edit-icon.png" height="25" width="25">
	</div>
	<br>
	<form id="personal_form">
		<div class="box-content row">
			<div class="form-group has-warning col-md-3" hidden>
				<label class="control-label" for="inputWarning1">ParentID</label> <input
					type="text" name="Personalparentid" id="Personalparentid1"
					value="${idNumber}" class="form-control" readonly="readonly">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Email ID</label> <input
					type="text" name="emailid" id="emailid" class="form-control">

			</div>

			<div class="form-group has-warning    col-md-3">
				<label class="control-label" for="inputWarning1">Marital
					Status</label><br> <select class="form-control" id="maritalstatus"
					name="maritalstatus">
					<option value="">Select</option>
					<option value="Maried">Married</option>
					<option value="UnMaried">UnMarried</option>

				</select>
			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Mobile No</label> <input
					type="text" name="mobile" id="mobilenumber" class="form-control">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Alternate
					Mobile No</label> <input type="text" name="altmobile"
					id="alternatemobilenumber" class="form-control">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Driving
					License No</label> <input type="text" name="drivinglicenceno"
					id="drivinglicenceno" class="form-control">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Driving
					License Validity</label> <input type="text" name="drivinglicencevalidity"
					id="drivinglicencevalidity" class="form-control"
					placeholder="YYYY-MM-DD">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Date of
					Birth</label> <input type="text" name="doBirth" id="doBirth"
					class="form-control" placeholder="YYYY-MM-DD">

			</div>
			<div class="form-group has-warning    col-md-3">
				<label class="control-label" for="inputWarning1">Blood Group</label><br>
				<select class="form-control" id="bloodgroup" name="bloodgroup">
					<option value="">Select</option>
					<option value="A +ve">A +ve</option>
					<option value="B +ve">B +ve</option>
					<option value="O +ve">O +ve</option>
					<option value="AB +ve">AB +ve</option>
					<option value="A -ve">A -ve</option>
					<option value="B -ve">B -ve</option>
					<option value="O -ve">O -ve</option>
					<option value="AB -ve">AB -ve</option>

				</select>
			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Passport No</label>
				<input type="text" name="passportnumber" id="passportnumber"
					class="form-control">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Passport
					Validity</label> <input type="text" name="passportvalidity"
					id="passportvalidity" class="form-control" placeholder="YYYY-MM-DD">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Adhaar No</label> <input
					type="text" name="adhaar_number" id="adhaarnumber"
					class="form-control">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">PAN Card No</label>
				<input type="text" name="pancard" id="pancardnumber"
					class="form-control">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Bank IFSC</label>
				<!-- <input type="text" name="branchifsccode" id="branchifsccode"
				class="form-control"> -->
				<select id="ifsccode" name="branchifsccode" class="form-control"
					onchange="getBDetailsByIfsc()">

				</select>
			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Bank Name</label> <input
					type="text" name="bankname" id="bankname" class="form-control"
					readonly="readonly">
			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Bank Branch</label>
				<input type="text" name="bankbranch" id="bankbranch"
					class="form-control" readonly="readonly">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Account No</label>
				<input type="text" name="accountnumber" id="accountnumber"
					class="form-control">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Ref.Number</label>
				<input type="text" name="cardnumber" id="cardnumber"
					class="form-control">

			</div>


			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">City</label> <input
					list="citydropdown" id="city" name="city" class="form-control" />
				<datalist id="citydropdown">
				</datalist>
			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">District</label> <input
					list="districtdropdown" id="district" name="district"
					class="form-control" />
				<datalist id="districtdropdown">
				</datalist>

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">State</label> <select
					class="form-control" id="state" name="state">
					<option value="">Select</option>
					<option value="AndhraPradesh">AndhraPradesh</option>
					<option value="ArunachalPradesh">ArunachalPradesh</option>
					<option value="Assam">Assam</option>
					<option value="Bihar">Bihar</option>
					<option value="Chhattisgarh">Chhattisgarh</option>
					<option value="Goa">Goa</option>
					<option value="Gujarat">Gujarat</option>
					<option value="Haryana">Haryana</option>
					<option value="HimachalPradesh">HimachalPradesh</option>
					<option value="Jammuandkashmir">Jammuandkashmir</option>
					<option value="Ladakh">Ladakh</option>
					<option value="Jharkhand">Jharkhand</option>
					<option value="Karnataka">Karnataka</option>
					<option value="Kerala">Kerala</option>
					<option value="MadhyaPradesh">MadhyaPradesh</option>
					<option value="Maharashtra">Maharashtra</option>
					<option value="Manipur">Manipur</option>
					<option value="Meghalaya">Meghalaya</option>
					<option value="Mizoram">Mizoram</option>
					<option value="Nagaland">Nagaland</option>
					<option value="Odisha">Odisha</option>
					<option value="Punjab">Punjab</option>
					<option value="Rajasthan">Rajasthan</option>
					<option value="Sikkim">Sikkim</option>
					<option value="TamilNadu">TamilNadu</option>
					<option value="Telangana">Telangana</option>
					<option value="Tripura">Tripura</option>
					<option value="Uttarakhand">Uttarakhand</option>
					<option value="UttarPradesh">UttarPradesh</option>
					<option value="WestBengal">WestBengal</option>
				</select>

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Present
					Address</label>
				<textarea rows="4" cols="10" id="presentaddress"
					name="presentaddress" class="form-control">
			</textarea>

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Permanent
					Address</label>
				<textarea rows="4" cols="10" id="permanentaddress"
					name="permanentaddress" class="form-control">
			 </textarea>

			</div>


			<div class="form-group has-warning col-md-3" hidden>
				<label class="control-label" for="inputWarning1">TranId</label> <input
					type="text" name="personalinfotranid" id="personalinfotranid"
					class="form-control" readonly="readonly">

			</div>
		</div>
		<div align="right">
			<input type="button" value="update" id="personal_update"
				class="btn btn-success">
		</div>
	</form>
	<hr color="00FFFF">
	<!-- Personal Information End-->
</div>

<!--   Family Details    Start-->
<div>
	<h3 align="left" style="color: #fb8c00">Family Details</h3>

</div>
<br>
<div>
	<h5 align="center">
		To Add New Family Details <a data-toggle="modal"
			data-target="#myModal2" id="familyid" onclick="" href="#">Click
			Here</a>
	</h5>
</div>
<div>
	<table id="family" class="display" style="width: 100%" border="1">
		<thead>
			<tr>
				<th>ParentId</th>
				<th>Gender</th>
				<th>Name</th>
				<th>Relation</th>
				<th>DateOfBirth</th>
				<th>AdhaarNo</th>
				<th>Qualification</th>
				<th>Occupation</th>
				<th>MobileNo</th>
				<th>TranId</th>
				<th>Action</th>
			</tr>
		</thead>

	</table>
</div>

<hr color="00FFFF">

<!-- Family  Details  End-->

<!-- Education Details  Start-->

<div>
	<h3 align="left" style="color: #fb8c00">Education Details</h3>

</div>
<br>
<div>
	<h5 align="center">
		To Add New Education Details <a data-toggle="modal"
			data-target="#myModal1" id="educationid" onclick="" href="#">Click
			Here</a>
	</H5>
</div>
<table id="education" class="display" style="width: 100%" border="1">
	<thead>
		<tr>
			<th>ParentId</th>
			<th>Certificate</th>
			<th>Institution Name</th>
			<th>Address</th>
			<th>YearOfPassing</th>
			<th>Marks%</th>
			<th>Remarks</th>
			<th>TranId</th>
			<th>Action</th>

		</tr>
	</thead>

</table>
<hr color="00FFFF">
<!--   Education  Details End -->

<!--   Experience Details  Start -->

<div>
	<h3 align="left" style="color: #fb8c00">Experience Details</h3>

</div>
<br>
<div>
	<h5 align="center">
		To Add Experience Details <a data-toggle="modal"
			data-target="#myModal" id="experienceid" href="#">Click Here</a>
	</H5>
</div>
<div>
	<table id="experience" class="display" style="width: 100%" border="1">
		<thead>
			<tr>
				<th>ParentId</th>
				<th>Employer Name</th>
				<th>Address</th>
				<th>WorkPeriod</th>
				<th>ExperienceDetails</th>
				<th>Designation</th>
				<th>CTC</th>
				<th>Remarks</th>
				<th>TranId</th>
				<th>Action</th>

			</tr>
		</thead>

	</table>
</div>
<hr color="00FFFF">
<!--   Experience Details  End -->

<!-- Salary Details Start -->

<div>
	<h3 align="left" style="color: #fb8c00">Rate of Pay</h3>
	<input type="checkbox" id="autocalc">Autocalc <input
		align="right" type="image" id="image" alt="Login"
		onclick="disableTextBox3()"
		src="resources/assets/images/edit-icon.png" height="25" width="25">
</div>

<br>
<form id="salary_form">
	<div id="salary">
		<div class="box-content row">
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">W.E.F</label> <input
					type="text" id="wef" name="wef" class="form-control"
					placeholder="YYYY-MM-DD">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Basic</label> <input
					type="text" id="basic" class="form-control" name="basic"
					onkeyup="salaryCalc()">

			</div>
			<div class="form-group has-warning col-md-3" hidden>
				<label class="control-label" for="inputWarning1">DA</label> <input
					type="text" name="da" id="da" class="form-control"
					onkeyup="salaryCalc()">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">HRA</label> <input
					type="text" name="hra" id="hra" class="form-control"
					onkeyup="salaryCalc()">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Site
					Allowance</label> <input type="text" id="conveyance" name="conveyance"
					class="form-control" onkeyup="salaryCalc()">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Spl.Allowance</label>
				<input type="text" name="others1" id="others1" class="form-control"
					onkeyup="salaryCalc()">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Others</label> <input
					type="text" name="others2" id="others2" class="form-control"
					onkeyup="salaryCalc()">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Gross
					Salary</label> <input type="text" name="grosssalary" id="grosssalary"
					onkeyup="salaryCalcBasedonGrossSalary()" class="form-control">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Medical</label> <input
					type="text" name="medical" id="medical" class="form-control"
					onkeyup="salaryCalc()">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">LTA</label> <input
					type="text" id="lta" name="lta" class="form-control"
					onkeyup="salaryCalc()">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Bonus </label> <input
					type="text" name="bonus" id="bonus" class="form-control"
					onkeyup="salaryCalc()">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">PF-UAN
					Number</label> <input type="text" name="uannumber" id="uannumber"
					class="form-control">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">PF%</label> <input
					type="text" name="pfpercentage" id="pfpercentage"
					onkeyup="salaryCalcOnPFChange()" class="form-control"><input
					type="hidden" id="pflimit" class="form-control"
					value="<%=pflimit%>">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">PF Amount</label> <input
					type="text" name="pfamount" id="pfamount" class="form-control">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">VPF%</label> <input
					type="text" id="vpfpercentage" name="vpfpercentage"
					class="form-control">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">CTC</label> <input
					type="text" name="ctc" id="ctc" class="form-control"
					readonly="readonly">

			</div>


			<div class="form-group has-warning col-md-3" hidden>
				<label class="control-label" for="inputWarning1">Employer
					Contribution</label> <input type="text" name="employercontribution"
					id="employercontribution" class="form-control">

			</div>
			<div class="form-group has-warning col-md-3" hidden>
				<label class="control-label" for="inputWarning1">EPS
					Contribution</label> <input type="text" name="epscontribution"
					id="epscontribution" class="form-control">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">ESI Number</label>
				<input type="text" name="esinumber" id="esinumber"
					class="form-control">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">ESI%</label> <input
					type="text" name="esipercentage" id="esipercentage"
					onkeyup="salaryCalcOnESIChange()" class="form-control"><input
					type="hidden" id="esilimit" class="form-control"
					value="<%=esilimit%>">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">ESI Amount</label>
				<input type="text" name="esiamount" id="esiamount"
					class="form-control">

			</div>

			<div class="form-group has-warning col-md-3" hidden>
				<label class="control-label" for="inputWarning1">Tranid</label> <input
					type="text" name="salarytranid" id="salarytranid"
					readonly="readonly" class="form-control">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">ParentID</label> <input
					type="text" name="salaryparentid" id="salaryparentid"
					value="${idNumber}" class="form-control" hidden="hidden">

			</div>
		</div>
	</div>
	<div id="dailywage1">
		<div class="box-content row">
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">W.E.F</label> <input
					type="text" id="wefdailywage" name="wefdailywage"
					class="form-control" placeholder="YYYY-MM-DD" readonly="readonly">
			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Daily-Wage
				</label> <input type="text" name="dailywage" id="dailywage"
					class="form-control">
			</div>
		</div>
	</div>
	<div align="right">
		<input type="submit" value="update" id="salary_submit"
			class="btn btn-success">

	</div>
</form>
<hr color="00FFFF">
<!-- Salary Details End -->

<!--  Others Details start  -->

<div>
	<h3 align="left" style="color: #fb8c00">Others Details</h3>
	<input align="right" type="image" id="image" alt="Login"
		onclick="enableOtherDetails()"
		src="resources/assets/images/edit-icon.png" height="25" width="25">
</div>
<br>

<div class="box-content row">

	<div class="form-group has-warning col-md-3">
		<label class="control-label" for="inputWarning1">Languages
			Known</label>
		<%-- <input
			type="text" name="" id="" value="<%out.println();%>"
			class="form-control"> --%>
		<select class="form-control" id="languages" multiple>
			<option value="">Select</option>
			<option value="English">English</option>
			<option value="Telugu">Telugu</option>
			<option value="Hindi">Hindi</option>
			<option value="Tamil">Tamil</option>
			<option value="Malayalam">Malayalam</option>
			<option value="French">French</option>
			<option value="German">German</option>

		</select>

	</div>

	<div class="form-group has-warning col-md-3">
		<label class="control-label" for="inputWarning1">Qualification</label>
		<%-- <input
			type="text" name="" id="" value="<%out.println();%>"
			class="form-control"> --%>
		<select class="form-control" id="qualification">
			<option value="">Select</option>

			<option value="10">Below Six</option>
			<option value="20">Below Tenth</option>
			<option value="30">Tenth</option>
			<option value="40">Intermediate</option>
			<option value="50">Graduate</option>
			<option value="50">Post Graduate</option>


		</select>

	</div>
	<div class="form-group has-warning col-md-3">
		<label class="control-label" for="inputWarning1">Previous
			Experience</label> <input type="text" name="" id="previousexperience"
			value="" class="form-control">

	</div>
	<div class="form-group has-warning col-md-3">
		<label class="control-label" for="inputWarning1">Current
			Experience</label> <input type="text" name="" id="currentexperience" value=""
			class="form-control">

	</div>

</div>

<div align="right">
	<input type="submit" value="update" class="btn btn-success"
		id="saveotherdetails">

</div>
<hr color="00FFFF">



<!-- Documents start-->
<div>
	<h3 align="left" style="color: #fb8c00">Documents</h3>
	<form id="doc_form">
		<div class="row">
			<div class="form-group has-warning col-sm-5">
				<label class="control-label" for="inputWarning1">Document
					Name:</label> <input type="text" id="fileDescription" name="docname"
					class="form-control">
			</div>
			<div class="form-group has-warning col-sm-5">
				<label class="control-label" for="inputWarning1">Choose
					File:</label> <input type="file" id="doc" name="doc" class="form-control"
					accept="application/pdf" >
			</div>
			<div class="form-group has-warning col-sm-2"
				style='margin-top: 28px;'>
				<input type="submit" id="doc_submit" value="Submit"
					class="btn btn-success">
			</div>
		</div>
	</form>
</div>

<div>
<!-- 	Excel Documents only -->
	<form id="docxl_form">
		<div class="row">
			<div class="form-group has-warning col-sm-5">
				<label class="control-label" for="inputWarning1">Choose Excel
					File:</label> <input type="file" id="docxl" name="docxl" class="form-control"
					accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" >
			</div>
			<div class="form-group has-warning col-sm-2"
				style='margin-top: 28px;'>
				<input type="submit" id="docxl_submit" value="Submit"
					class="btn btn-success">
			</div>
		</div>
	</form>
</div>
<br>
<hr color="00FFFF">
<br>
<div>


	<table id="empdoc" class="display" style="width: 100%" border="1">
		<thead>
			<tr>
				<th>TranId</th>
				<th>IDNo</th>
				<th>File Name</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
		</thead>

	</table>
</div>
<hr color="00FFFF">
<div>
	<h3 align="left" style="color: #fb8c00">Photo</h3>
	<form id="photo_form">
		<div  class="form-group has-warning" id="wrapper" style="margin-top: 20px;">
			<input  accept="image/*" type="file"  id="fileUpload" name="fileUpload" />
			<div id="image-holder">
			</div>
		</div>
		<div class="form-group has-warning col-sm-2"
				style='margin-top: 28px;'>
				<input type="submit" id="photo_submit" value="Submit"
					class="btn btn-success">
			</div>
	</form>
</div>
<!--  Others Details  end  -->

<hr color="00FFFF">
<div>
	<div>
		<h3 align="left" style="color: #fb8c00">Downloads</h3>

	</div>
	<br>

	<div align="left">
		<input type="submit" value="OfferLetter" onclick="getJoiningDetails()"
			style="background-color: blue; color: white" class="btn btn-primary">

	</div>
	<br>

	<div align="left">
		<input type="submit" value="AppointmentOrder"
			onclick="getAppointmentDetails()"
			style="background-color: blue; color: white" class="btn btn-primary">
	</div>

</div>
<!--  All Modal Boxes -->


<!--   Experience Modal box  Starting-->
<div class="modal fade" id="myModal" role="dialog">

	<div class="modal-dialog modal-lg">

		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"
					align="center">Experience Details</h4>
				<button type="button" class="close" data-dismiss="modal"
					onClick="resetExperience()">&times;</button>

			</div>
			<h3 id="ExperiencedetailsDisplayMessage" align="center"
				style="color: green"></h3>
			<form id="exp_form">
				<div class="modal-body">
					<div class="box-content row">
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">ParentId</label>
							<input type="text" id="Expid" value="${idNumber}"
								class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Employer
								Name</label> <input type="text" id="employeename" name="employeename"
								class="form-control">
						</div>

						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Address</label>
							<input type="text" id="address" name="comp_address"
								class="form-control">
						</div>

						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Work
								Duration</label> <input type="text" id="workperiod" name="workperiod"
								class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Job
								Description </label> <input type="text" id="experiencedetails"
								class="form-control" name="experiencedetails">
						</div>

						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Designation</label>
							<input type="text" id="designation" name="c_design"
								class="form-control">
						</div>

						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">CTC</label> <input
								type="text" id="Experiencectc" name="c_ctc" class="form-control">
						</div>

						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Remarks</label>
							<input type="text" id="remarks" name="c_remarks"
								class="form-control">
						</div>

						<div class="form-group has-warning col-md-3" hidden>
							<label class="control-label" for="inputWarning1">Exptranid</label>
							<input type="text" id="Exptranid" name="Exptranid"
								class="form-control" readonly="readonly">
						</div>
					</div>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="exp_btn">Submit</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--   Experience Modal box  end -->


<!--   Education Modal box  Starting-->
<div class="modal fade" id="myModal1" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"
					align="center">Education Details</h4>
				<button type="button" class="close" data-dismiss="modal"
					onClick="reseteducationform()">&times;</button>
			</div>
			<h3 id="EducationDetailsDisplayMessage" align="center"
				style="color: green"></h3>
			<form id="edu_form">
				<div class="modal-body">
					<div class="box-content row">
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">ParentId</label>
							<input type="text" id="Epid" value="${idNumber}" name="Epid"
								class="form-control">
						</div>

						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Course/Class/Certificate</label>
							<input type="text" id="certificates" name="certificates"
								class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Institute/University
								Name</label> <input type="text" id="institutionname"
								name="institutionname" class="form-control">
						</div>

						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Address</label>
							<input type="text" id="Eduaddress" name="Eduaddress"
								class="form-control">
						</div>


						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Year Of
								Passing</label> <input type="text" id="yearofpassing"
								name="yearofpassing" class="form-control">
						</div>

						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Marks%</label> <input
								type="text" id="markspercentage" name="markspercentage"
								class="form-control">
						</div>

						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Remarks</label>
							<input type="text" id="Eduremarks" name="Eduremarks"
								class="form-control">
						</div>
						<div class="form-group has-warning col-md-3" hidden>
							<label class="control-label" for="inputWarning1">Edutranid</label>
							<input type="text" id="Edutranid" name="Edutranid"
								readonly="readonly" class="form-control">
						</div>


					</div>

				</div>
				<div class="modal-footer">
					<button type="button" id="edu_button" class="btn btn-default">Submit</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--   Education Modal box  ending-->


<!--   Family Modal box  Starting-->

<div class="modal fade" id="myModal2" role="dialog">

	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"
					align="center">Family Details</h4>
				<button type="button" class="close" data-dismiss="modal"
					onClick="resetFamilyForm()">&times;</button>
			</div>
			<h3 id="FamilyDetailsDisplayMessage" align="center"
				style="color: green"></h3>
			<form id="familyValidation">
				<div class="modal-body">
					<div class="box-content row">
						<!-- <div class="form-group has-warning col-md-3">
						<label class="control-label" for="inputWarning1">ParentID</label>
						<input type="text" id="parentid" class="form-control">
					</div> -->

						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Gender</label> <input
								type="text" id="familyidnumber" value="${idNumber}"
								class="form-control" hidden="hidden">
							<!-- <input
							type="text" id="gender" class="form-control"> -->
							<select class="form-control" id="familygender" name="gender">
								<!-- <option value="">Select</option> -->
								<option value="Male">Male</option>
								<option value="Female">Female</option>
								<option value="Other">Other</option>
							</select>
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Name</label> <input
								type="text" id="name" name="name" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Relation</label>
							<input type="text" id="relation" name="relation"
								class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Date Of
								Birth</label> <input type="text" id="dob" name="dob"
								class="form-control" placeholder="YYYY-MM-DD">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Adhaar
								No</label> <input type="text" id="adhaarno" name="adhaarno"
								class="form-control">
						</div>

						<div class="form-group has-warning col-md-3" hidden>
							<label class="control-label" for="inputWarning1">Qualification</label>
							<input type="text" id="familyqualification" name="qualification"
								class="form-control">
						</div>

						<div class="form-group has-warning col-md-3" hidden>
							<label class="control-label" for="inputWarning1">Occupation</label>
							<input type="text" id="occupation" name="occupation"
								class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Mobile
								NO</label> <input type="text" id="mobileno" name="mobileno"
								class="form-control">
						</div>

						<div class="form-group has-warning    col-md-3">
							<label class="control-label" for="inputWarning1">IsNominee</label>
				           <input type="checkbox" id="isnominee" name="isnominee"><br>
						</div>

						<div class="form-group has-warning col-md-3" hidden>
							<label class="control-label" for="inputWarning1">familytranid</label>
							<input type="text" id="familytranid" name="familytranid"
								readonly="readonly" class="form-control">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default"
						id="submitFamilyDetails">Submit</button>
				</div>
			</form>
		</div>
	</div>

</div>


<!--   Family Modal box  ending-->


</head>
<body>
	 <script src="resources/validation/bootstrapValidator.min.js"></script> 
	<script>
		$('#familyValidation').bootstrapValidator({
			//container: '#messages',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				gender : {
					validators : {
						notEmpty : {
							message : 'Gender required ',
						},
					}
				},

				name : {
					validators : {
						notEmpty : {
							message : 'Name required ',
						},
					}
				},
				relation : {
					validators : {
						notEmpty : {
							message : 'Relation required ',
						},
					}
				},
				dob : {
					validators : {
						notEmpty : {
							message : 'Date Of Birth id required ',
						},
					}
				},
				adhaarno : {
					validators : {
						notEmpty : {
							message : 'Adhaar number required ',
						},
					}
				},
				qualification : {
					validators : {
						notEmpty : {
							message : 'Qualification  required ',
						},
					}
				},
				occupation : {
					validators : {
						notEmpty : {
							message : 'Occupation  required ',
						},
					}
				},
				mobileno : {
					validators : {
						notEmpty : {
							message : 'Mobile Number required ',
						},
					}
				},
				isnominee : {
					validators : {
						notEmpty : {
							message : 'isNominee is required ',
						},
					}
				},

			}

		});
	</script>
	<script>
		$('#doc_form').bootstrapValidator({
			//container: '#messages',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				docname : {
					validators : {
						notEmpty : {
							message : 'Name is required ',
						},
					}
				},
				doc : {
					validators : {
						notEmpty : {
							message : 'Select a valid file to upload'
						},
						file : {
							extension : 'pdf,jpeg,png',
							type : 'application/pdf,image/jpeg,image/png',
							maxSize : 2048 * 1024,
							message : 'The selected file is not valid'
						}
					}
				},

			}

		});

		
	</script>
	
	<script>
		$('#docxl_form').bootstrapValidator({
			//container: '#messages',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				
				docxl : {
					validators : {
						notEmpty : {
							message : 'Select a valid file to upload'
						},
						file : {
							extension : 'xlsx',
							type : 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet',
							maxSize : 2048 * 1024,
							message : 'The selected file is not valid'
						}
					}
				},

			}

		});

		
	</script>
	<script>
		$("#submitFamilyDetails").on("click", function() {
			$('#familyValidation').data('bootstrapValidator').validate();

			if ($('#familyValidation').data('bootstrapValidator').isValid()) {
				saveFamilyDetails();
			}
		});

		$("#doc_submit").click(function() {
			alert("doc_submit");
			$('#doc_form').data('bootstrapValidator').validate();
			if ($('#doc_form').data('bootstrapValidator').isValid()) {
				storeDocDetails();
			}

		});
		</script>
		
		
		<script>
		$("#docxl_submit").click(function() {
			alert("docxl_submit");
			$('#docxl_form').data('bootstrapValidator').validate();
			if ($('#docxl_form').data('bootstrapValidator').isValid()) {
				storeExcelDocDetails();
			}

		});
		</script>
		
		<script>
		function storeExcelDocDetails() {
			alert("storeExcelDocDetails");
			var filecover = document.getElementById("docxl").files[0];
			alert("filecover "+filecover );
			var formdata = new FormData();
			formdata.append("filecover", filecover);

			$.ajax({
				type : "post",
				// contentType: false,
				url : "storeExcelDocDetails", // this controller url
				//url : "storeDocDetails1",
				data : formdata,
				processData : false,
				contentType : false,
				success : function(data) {
					 window.location.reload();
					
				}

			});

		}
		</script>
<script>
$('#photo_form').bootstrapValidator({
	//container: '#messages',
	feedbackIcons : {
		valid : 'glyphicon glyphicon-ok',
		invalid : 'glyphicon glyphicon-remove',
		validating : 'glyphicon glyphicon-refresh'
	},
	fields : {
		fileUpload : {
			validators : {
				notEmpty : {
					message : 'Select a valid file to upload'
				},
				file : {
					extension : 'jpeg,png,jpg',
					type : 'image/jpeg,image/png,image/jpg',
					maxSize : 20480 * 1024,
					message : 'The selected file is not valid'
				}
			}
		},

	}

});

		$("#photo_submit").click(function() {
			alert("photo_submit");
			debugger;
			$('#photo_form').data('bootstrapValidator').validate();
			if ($('#photo_form').data('bootstrapValidator').isValid()) {
				alert("photo_submit2");
				storeEmpImages();
			}

		});
	</script>

	<script>
		$('#emp_form').bootstrapValidator({
			//container: '#messages',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				idNumber : {
					validators : {
						notEmpty : {
							message : 'IdNumber is required ',

						}
					}
				},
				division : {
					validators : {
						notEmpty : {
							message : 'Divison is required ',

						}
					}
				},
				empid : {
					validators : {
						notEmpty : {
							message : 'IdNumber is required ',

						}
					}
				},
				employeeName : {
					validators : {
						notEmpty : {
							message : 'Name is required ',

						}
					}
				},
				gender : {
					validators : {
						notEmpty : {
							message : 'Gender is required ',

						}
					}
				},
				doj : {
					validators : {
						notEmpty : {
							message : 'DOJ is required ',

						}
					}
				},
				design : {
					validators : {
						notEmpty : {
							message : 'Designation is required ',

						}
					}
				},
				empstatus : {
					validators : {
						notEmpty : {
							message : 'Status is required ',

						}
					}
				},
				jobtype : {
					validators : {
						notEmpty : {
							message : 'JobType is required ',

						}
					}
				},
				jobstatus : {
					validators : {
						notEmpty : {
							message : 'Jobstatus is required ',

						}
					}
				},
				gradeId : {
					validators : {
						notEmpty : {
							message : 'Grade is required ',

						}
					}
				},
				cadreid : {
					validators : {
						notEmpty : {
							message : 'Cadre is required ',

						}
					}
				},
				workdeptid : {
					validators : {
						notEmpty : {
							message : 'Department is required ',

						}
					}
				},
				//				sectionid : {
				//					validators : {
				//						notEmpty : {
				//							message : 'Section is required ',
				//
				//						}
				//					}
				//				},
				project : {
					validators : {
						notEmpty : {
							message : 'Project is required ',

						}
					}
				},
			//				 reportingempid : {
			//					validators : {
			//						notEmpty : {
			//							message : 'Reporting To Field is required ',
			//
			//						}
			//					}
			//				},

			}

		});
		$("#emp_btn").click(function() {

			$('#emp_form').data('bootstrapValidator').validate();
			if ($('#emp_form').data('bootstrapValidator').isValid()) {
				////alert();
				editempinfo();
			}

		});
	</script>

	<script>
		$('#personal_form').bootstrapValidator({
			//container: '#messages',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {

				emailid : {
					validators : {
						notEmpty : {
							message : 'Email is required ',

						},
						regexp : {
							regexp : '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
							message : 'Please enter valid email address.'
						}
					}
				},
				maritalstatus : {
					validators : {
						notEmpty : {
							message : 'Maritial Status is required ',

						}
					}
				},
				//				altmobile : {
				//					validators : {
				//						notEmpty : {
				//							message : 'Alternate Mobile is required ',
				//
				//						}
				//					}
				//				},
				mobile : {
					validators : {
						notEmpty : {
							message : 'Mobile is required ',

						}
					}
				},
				//				drivinglicenceno : {
				//					validators : {
				//						notEmpty : {
				//							message : 'Driving License is required ',
				//
				//						}
				//					}
				//				},
				//				drivinglicencevalidity : {
				//					validators : {
				//						notEmpty : {
				//							message : 'Driving License Validity is required ',
				//
				//						}
				//					}
				//				},
				doBirth : {
					validators : {
						notEmpty : {
							message : 'DOB is required ',

						}
					}
				},
				bloodgroup : {
					validators : {
						notEmpty : {
							message : 'Blood Group is required ',

						}
					}
				},
				//				passportnumber : {
				//					validators : {
				//						notEmpty : {
				//							message : 'Passport is required ',
				//
				//						}
				//					}
				//				},
				//				passportvalidity : {
				//					validators : {
				//						notEmpty : {
				//							message : 'Avaiblity is required ',
				//
				//						}
				//					}
				//				},
				adhaar_number : {
					validators : {
						notEmpty : {
							message : 'Aadhar is required ',

						}
					}
				},
				//				pancard : {
				//					validators : {
				//						notEmpty : {
				//							message : 'PAN is required ',
				//
				//						}
				//					}
				//				},
				bankname : {
					validators : {
						notEmpty : {
							message : 'Bankname is required ',

						}
					}
				},
				bankbranch : {
					validators : {
						notEmpty : {
							message : 'Branch is required ',

						}
					}
				},
				accountnumber : {
					validators : {
						notEmpty : {
							message : 'Acc Number is required ',

						}
					}
				},
				branchifsccode : {
					validators : {
						notEmpty : {
							message : 'IFSC code is required ',

						}
					}
				},
				presentaddress : {
					validators : {
						notEmpty : {
							message : 'Present Address is required ',

						}
					}
				},
				permanentaddress : {
					validators : {
						notEmpty : {
							message : 'Permanent Address is required ',

						}
					}
				},
				personalinfotranid : {
					validators : {
						notEmpty : {
							message : 'TranId is required ',

						}
					}
				}

			}

		});

		$("#personal_update").click(function() {
			$('#personal_form').data('bootstrapValidator').validate();
			if ($('#personal_form').data('bootstrapValidator').isValid()) {
				editpersonalinfo();
			}

		});
	</script>
	<script>
		$('#salary_form').bootstrapValidator({
			//container: '#messages',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {

				wef : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				basic : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				da : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				lta : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				hra : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				medical : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				conveyance : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				bonus : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				others1 : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				//				others2 : {
				//					validators : {
				//						notEmpty : {
				//							message : 'Field is required ',
				//
				//						}
				//					}
				//				},
				grosssalary : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				ctc : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				esipercentage : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				pfpercentage : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				//				uannumber : {
				//					validators : {
				//						notEmpty : {
				//							message : 'Field is required ',
				//
				//						}
				//					}
				//				},
				employercontribution : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
			//				epscontribution : {
			//					validators : {
			//						notEmpty : {
			//							message : 'Field is required ',
			//
			//						}
			//					}
			//				},
			//				vpfpercentage : {
			//					validators : {
			//						notEmpty : {
			//							message : 'Field is required ',
			//
			//						}
			//					}
			//				},

			}

		});
		$("#salary_submit").click(function(event) {
			event.preventDefault();
			$('#salary_form').data('bootstrapValidator').validate();
			if ($('#salary_form').data('bootstrapValidator').isValid()) {
				editsalaryinfo();
			}

		});
	</script>
	<script>
		$('#edu_form').bootstrapValidator({
			//container: '#messages',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				//				Eduremarks : {
				//					validators : {
				//						notEmpty : {
				//							message : 'Field is required ',
				//
				//						}
				//					}
				//				},
				markspercentage : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				yearofpassing : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				Eduaddress : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				institutionname : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				certificates : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},

			}

		});

		$("#edu_button").on("click", function() {

			$('#edu_form').data('bootstrapValidator').validate();

			if ($('#edu_form').data('bootstrapValidator').isValid()) {
				saveEducationDetails();
			}

		});
	</script>

	<script>
		$('#exp_form').bootstrapValidator({
			//container: '#messages',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				employeename : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				comp_address : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				workperiod : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				experiencedetails : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				c_design : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
				c_ctc : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
			//				c_remarks : {
			//					validators : {
			//						notEmpty : {
			//							message : 'Field is required ',
			//
			//						}
			//					}
			//				},

			}

		});

		$("#exp_btn").on("click", function() {

			$('#exp_form').data('bootstrapValidator').validate();

			if ($('#exp_form').data('bootstrapValidator').isValid()) {
				saveExperince();
			}

		});
	</script>
	<script>
		$('#employeeshiftschedule_form').bootstrapValidator({
			//container: '#messages',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				effectfrom : {
					validators : {
						notEmpty : {
							message : 'Field is required ',

						}
					}
				},
			//				effectto : {
			//					validators : {
			//						notEmpty : {
			//							message : 'Field is required ',
			//
			//						}
			//					}
			//				},
			}

		});

		$("#shiftshedulesubmit").on(
				"click",
				function() {

					$('#employeeshiftschedule_form').data('bootstrapValidator')
							.validate();

					if ($('#employeeshiftschedule_form').data(
							'bootstrapValidator').isValid()) {
						editEmployeeShifts();
					}

				});
	</script>

	<script>
		
	</script>
</head>
<body>
<script src="resources/dist/js/sidebarmenu.js"></script>
	<%@include file="footer.jsp"%>
	
	<script>
		jQuery('#effectTo').datepicker({
			autoclose : true,
			todayHighlight : true
		});
		jQuery('#doBirth').datepicker({
			autoclose : true,
			todayHighlight : true
		});
		jQuery('#dob').datepicker({
			autoclose : true,
			todayHighlight : true
		});
		jQuery('#doj').datepicker({
			autoclose : true,
			todayHighlight : true
		});
		jQuery('#wef').datepicker({
			autoclose : true,
			todayHighlight : true
		});
		jQuery('#effectFrom').datepicker({
			autoclose : true,
			todayHighlight : true
		});
	</script>