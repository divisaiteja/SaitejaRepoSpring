function EnableEmpJobDetailsTextBoxes(){
	document.getElementById("empid").disabled = true;
	document.getElementById("empname").disabled = true;
	document.getElementById("doj").disabled = true;
	document.getElementById("empstatus").disabled = true;
	document.getElementById("division").disabled = true;
	document.getElementById("design").disabled = true;
	document.getElementById("gradeId").disabled = true;
	document.getElementById("jobstatus").disabled = true;
	document.getElementById("cadreid").disabled = true;
	document.getElementById("workdeptid").disabled = true;
	document.getElementById("gender").disabled = true;
	document.getElementById("sectionid").disabled = true;
	document.getElementById("jobtype").disabled = true;
	document.getElementById("project").disabled = true;
	document.getElementById("reportingempid").disabled = true;
	document.getElementById("emp_btn").disabled = true;
}

function DisableEmpJobDetailsTextBoxes(){
document.getElementById("empid").disabled = false;
document.getElementById("empname").disabled = false;
document.getElementById("doj").disabled = false;
document.getElementById("empstatus").disabled = false;
document.getElementById("division").disabled = false;
document.getElementById("design").disabled = false;
document.getElementById("gradeId").disabled = false;
document.getElementById("jobstatus").disabled = false;
document.getElementById("cadreid").disabled = false;
document.getElementById("workdeptid").disabled = false;
document.getElementById("gender").disabled = false;
document.getElementById("sectionid").disabled = false;
document.getElementById("jobtype").disabled = false;
document.getElementById("project").disabled = false;
document.getElementById("reportingempid").disabled = false;
document.getElementById("emp_btn").disabled = false;
}

function EnablePersonalInfo(){
	document.getElementById("emailid").disabled = true;
	document.getElementById("maritalstatus").disabled = true;
	document.getElementById("mobilenumber").disabled = true;
	document.getElementById("alternatemobilenumber").disabled = true;
	document.getElementById("drivinglicenceno").disabled = true;
	document.getElementById("drivinglicencevalidity").disabled = true;
	document.getElementById("passportnumber").disabled = true;
	document.getElementById("passportvalidity").disabled = true;
	document.getElementById("adhaarnumber").disabled = true;
	document.getElementById("pancardnumber").disabled = true;
	document.getElementById("bankname").disabled = true;
	document.getElementById("bankbranch").disabled = true;
	document.getElementById("branchifsccode").disabled = true;
	document.getElementById("accountnumber").disabled = true;
	document.getElementById("presentaddress").disabled = true;
	document.getElementById("permanentaddress").disabled = true;
	document.getElementById("bloodgroup").disabled = true;
	document.getElementById("doBirth").disabled = true;
	document.getElementById("tranid").disabled = true;
	document.getElementById("personal_update").disabled = true;
}
function DisablePersonalInfo(){
	document.getElementById("emailid").disabled = false;
	document.getElementById("maritalstatus").disabled = false;
	document.getElementById("mobilenumber").disabled = false;
	document.getElementById("alternatemobilenumber").disabled = false;
	document.getElementById("drivinglicenceno").disabled = false;
	document.getElementById("drivinglicencevalidity").disabled = false;
	document.getElementById("passportnumber").disabled = false;
	document.getElementById("passportvalidity").disabled = false;
	document.getElementById("adhaarnumber").disabled = false;
	document.getElementById("pancardnumber").disabled = false;
	document.getElementById("bankname").disabled = false;
	document.getElementById("bankbranch").disabled = false;
	document.getElementById("branchifsccode").disabled = false;
	document.getElementById("accountnumber").disabled = false;
	document.getElementById("presentaddress").disabled = false;
	document.getElementById("permanentaddress").disabled = false;
	document.getElementById("bloodgroup").disabled = false;
	document.getElementById("doBirth").disabled = false;
    document.getElementById("tranid").disabled = false;
	document.getElementById("personal_update").disabled = false;

}


function enableEmployeeShiftSch(){
	document.getElementById("shifschIdNumber").disabled = true;
	document.getElementById("monday").disabled = true;
	document.getElementById("tuesday").disabled = true;
	document.getElementById("wednesday").disabled = true;
	document.getElementById("thursday").disabled = true;
	document.getElementById("friday").disabled = true;
	document.getElementById("saturday").disabled = true;
	document.getElementById("sunday").disabled = true;
	document.getElementById("effectFrom").disabled = true;
	document.getElementById("effectTo").disabled = true;
	document.getElementById("otEligibility").disabled = true;
	document.getElementById("shiftshedulesubmit").disabled = true;
}
function  disableEmployeeShiftSch(){
document.getElementById("shifschIdNumber").disabled = false;
document.getElementById("monday").disabled = false;
document.getElementById("tuesday").disabled = false;
document.getElementById("wednesday").disabled = false;
document.getElementById("thursday").disabled = false;
document.getElementById("friday").disabled = false;
document.getElementById("saturday").disabled = false;
document.getElementById("sunday").disabled = false;
document.getElementById("effectFrom").disabled = false;
document.getElementById("effectTo").disabled = false;
document.getElementById("otEligibility").disabled = false;
//document.getElementById("isActive").disabled = false;
 document.getElementById("shiftshedulesubmit").disabled = false;
}


function disableSalary(){
document.getElementById("wef").disabled = true;
document.getElementById("da").disabled = true;
document.getElementById("hra").disabled = true;
document.getElementById("conveyance").disabled = true;
document.getElementById("others1").disabled = true;
document.getElementById("grosssalary").disabled = true;
document.getElementById("esinumber").disabled = true;
document.getElementById("pfpercentage").disabled = true;
document.getElementById("employercontribution").disabled = true;
document.getElementById("vpfpercentage").disabled = true;
document.getElementById("basic").disabled = true;
document.getElementById("lta").disabled = true;
document.getElementById("medical").disabled = true;
document.getElementById("bonus").disabled = true;
document.getElementById("ctc").disabled = true;
document.getElementById("esipercentage").disabled = true;
document.getElementById("uannumber").disabled = true;
document.getElementById("epscontribution").disabled = true;
document.getElementById("others2").disabled = true;
document.getElementById("idno").disabled = true;
document.getElementById("salarytranid").disabled = true;
 document.getElementById("salary_submit").disabled = true;
}
  
function enableSalary(){
 document.getElementById("wef").disabled = false;
	document.getElementById("da").disabled = false;
	document.getElementById("hra").disabled = false;
	document.getElementById("conveyance").disabled = false;
	document.getElementById("others1").disabled = false;
	document.getElementById("grosssalary").disabled = false;
	document.getElementById("esinumber").disabled = false;
	document.getElementById("pfpercentage").disabled = false;
	document.getElementById("employercontribution").disabled = false;
	document.getElementById("vpfpercentage").disabled = false;
	document.getElementById("basic").disabled = false;
	document.getElementById("lta").disabled = false;
	document.getElementById("medical").disabled = false;
	document.getElementById("bonus").disabled = false;
	document.getElementById("ctc").disabled = false;
	document.getElementById("esipercentage").disabled = false;
	document.getElementById("uannumber").disabled = false;
	document.getElementById("epscontribution").disabled = false;
	document.getElementById("others2").disabled = false;
	document.getElementById("idno").disabled = false;
	document.getElementById("salarytranid").disabled = false;
	document.getElementById("salary_submit").disabled = false;
}