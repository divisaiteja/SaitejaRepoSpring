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
	document.getElementById("biometric_id").disabled = true;
//	document.getElementById("emp_btn").disabled = true;
	document.getElementById("isTechnical").disabled = true;        
	document.getElementById("isReportee").disabled = true;                
    document.getElementById("skillid").disabled = true; 
    document.getElementById("EmailId").disabled = true;  
    document.getElementById("MobileNumber").disabled = true;   
    $("#emp_btn").hide();
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
document.getElementById("isTechnical").disabled = false;        
document.getElementById("isReportee").disabled = false;                
document.getElementById("skillid").disabled = false;                
document.getElementById("EmailId").disabled = false;  
document.getElementById("MobileNumber").disabled = false; 
if($("#bioidasidno").val() ==  0){
      document.getElementById("biometric_id").disabled = false;
}

//document.getElementById("emp_btn").disabled = false;
$("#emp_btn").show();
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
	document.getElementById("ifsccode").disabled = true;
	document.getElementById("accountnumber").disabled = true;
	document.getElementById("cardnumber").disabled = true;
	document.getElementById("presentaddress").disabled = true;
	document.getElementById("permanentaddress").disabled = true;
	document.getElementById("bloodgroup").disabled = true;
	document.getElementById("doBirth").disabled = true;
	document.getElementById("tranid").disabled = true;
	document.getElementById("city").disabled = true;
	document.getElementById("district").disabled = true;
	document.getElementById("state").disabled = true;
//	document.getElementById("personal_update").disabled = true;
        $("#personal_update").hide();
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
	document.getElementById("ifsccode").disabled = false;
	document.getElementById("accountnumber").disabled = false;
	document.getElementById("cardnumber").disabled = false;
	document.getElementById("presentaddress").disabled = false;
	document.getElementById("permanentaddress").disabled = false;
	document.getElementById("bloodgroup").disabled = false;
	document.getElementById("doBirth").disabled = false;
    document.getElementById("tranid").disabled = false;
    document.getElementById("city").disabled = false;
	document.getElementById("district").disabled = false;
    document.getElementById("state").disabled = false;
//	document.getElementById("personal_update").disabled = false;
        $("#personal_update").show();

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
//	document.getElementById("shiftshedulesubmit").disabled = true;
        $("#shiftshedulesubmit").hide();
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
// document.getElementById("shiftshedulesubmit").disabled = false;
$("#shiftshedulesubmit").show();
}

function disableOtherDetails(){
    document.getElementById("languages").disabled = true;
    document.getElementById("qualification").disabled = true;
    document.getElementById("previousexperience").disabled = true;
    document.getElementById("currentexperience").disabled = true;
    $("#saveotherdetails").hide();    
    
}
function enableOtherDetails(){
    
    document.getElementById("languages").disabled = false;
    document.getElementById("qualification").disabled = false;
    document.getElementById("previousexperience").disabled = false;
    document.getElementById("currentexperience").disabled = false;
    $("#saveotherdetails").show();        
    
}

function disableSalary(){
    	if($("#autocalc").val() ==  1){	
		document.getElementById("autocalc").checked = true;
        }else{
            		document.getElementById("autocalc").checked = false;
        }
document.getElementById("wef").disabled = true;
document.getElementById("da").disabled = true;
document.getElementById("hra").disabled = true;
document.getElementById("conveyance").disabled = true;
document.getElementById("others1").disabled = true;
document.getElementById("grosssalary").disabled = true;
document.getElementById("esinumber").disabled = true;
document.getElementById("pfpercentage").disabled = true;
document.getElementById("pfamount").disabled = true;
document.getElementById("employercontribution").disabled = true;
document.getElementById("vpfpercentage").disabled = true;
document.getElementById("basic").disabled = true;
document.getElementById("lta").disabled = true;
document.getElementById("medical").disabled = true;
document.getElementById("bonus").disabled = true;
document.getElementById("ctc").disabled = true;
document.getElementById("esipercentage").disabled = true;
document.getElementById("esiamount").disabled = true;
document.getElementById("uannumber").disabled = true;
document.getElementById("epscontribution").disabled = true;
document.getElementById("others2").disabled = true;
document.getElementById("salarytranid").disabled = true;
//document.getElementById("salary_submit").disabled = true;
document.getElementById("pfamount").disabled=true;
document.getElementById("dailywage").disabled=true;
$("#salary_submit").hide();
}
  
function  checkenableSalary()
{
//	if($("#autocalc").val() ==  0){
//		document.getElementById("uannumber").enabled = true;
		enableSalary();
//	}
	
}

function enableSalary(){
	if($("#autocalc").val() ==  1){	
		document.getElementById("autocalc").checked = true;
	    document.getElementById("wef").disabled = false;
		document.getElementById("grosssalary").disabled = false;
		document.getElementById("esinumber").disabled = false;
		document.getElementById("vpfpercentage").disabled = false;
		document.getElementById("uannumber").disabled = false;
		document.getElementById("epscontribution").disabled = false;		
		document.getElementById("others2").disabled = false;
//		document.getElementById("salary_submit").disabled = false;		
		document.getElementById("pfpercentage").disabled = false;                
		document.getElementById("esipercentage").disabled = false;                
	}else{
	    document.getElementById("wef").disabled = false;
		document.getElementById("da").disabled = false;
		document.getElementById("hra").disabled = false;
		document.getElementById("conveyance").disabled = false;
		document.getElementById("others1").disabled = false;
		//document.getElementById("grosssalary").disabled = false;
		document.getElementById("esinumber").disabled = false;
		document.getElementById("pfpercentage").disabled = false;
		document.getElementById("employercontribution").disabled = false;
		document.getElementById("vpfpercentage").disabled = false;
		document.getElementById("basic").disabled = false;
		document.getElementById("lta").disabled = false;
		document.getElementById("medical").disabled = false;
		document.getElementById("bonus").disabled = false;
		//document.getElementById("ctc").disabled = false;
		document.getElementById("esipercentage").disabled = false;
		document.getElementById("uannumber").disabled = false;
		document.getElementById("epscontribution").disabled = false;
		document.getElementById("others2").disabled = false;
		document.getElementById("salarytranid").disabled = false;
//		document.getElementById("salary_submit").disabled = false;		
	}
        $("#salary_submit").show(); 
}