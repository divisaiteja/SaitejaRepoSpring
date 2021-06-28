/* Employee Shifts Sheduledropdown with json */
$(document).ready(function() {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getAllHrShifts", // this is my servlet
				success : function(data) {
					var abc = data;
					var mon = document.getElementById('monday');
					var tue = document.getElementById('tuesday');
					var wed = document.getElementById('wednesday');
					var thur = document.getElementById('thursday');
					var fri = document.getElementById('friday');
					var sat = document.getElementById('saturday');
					var sun = document.getElementById('sunday');

					for (var i = 0; i < abc.length; i++) {
						// POPULATE SELECT ELEMENT WITH JSON.
						mon.innerHTML = mon.innerHTML + '<option value="'
								+ abc[i]["shiftid"] + '">' + abc[i]["name"] + "["+abc[i]["starttime"]+ "-"+abc[i]["endtime"]+"]" 
								+ '</option>';

						tue.innerHTML = tue.innerHTML + '<option value="'
								+ abc[i]["shiftid"] + '">' + abc[i]["name"] + "["+abc[i]["starttime"]+ "-"+abc[i]["endtime"]+"]"
								+ '</option>';

						wed.innerHTML = wed.innerHTML + '<option value="'
								+ abc[i]["shiftid"] + '">' + abc[i]["name"] + "["+abc[i]["starttime"]+ "-"+abc[i]["endtime"]+"]"
								+ '</option>';

						thur.innerHTML = thur.innerHTML + '<option value="'
								+ abc[i]["shiftid"] + '">' + abc[i]["name"] + "["+abc[i]["starttime"]+ "-"+abc[i]["endtime"]+"]"
								+ '</option>';

						fri.innerHTML = fri.innerHTML + '<option value="'
								+ abc[i]["shiftid"] + '">' + abc[i]["name"] + "["+abc[i]["starttime"]+ "-"+abc[i]["endtime"]+"]"
								+ '</option>';

						sat.innerHTML = sat.innerHTML + '<option value="'
								+ abc[i]["shiftid"] + '">' + abc[i]["name"] + "["+abc[i]["starttime"]+ "-"+abc[i]["endtime"]+"]"
								+ '</option>';

						sun.innerHTML = sun.innerHTML + '<option value="'
								+ abc[i]["shiftid"] + '">' + abc[i]["name"] + "["+abc[i]["starttime"]+ "-"+abc[i]["endtime"]+"]"
								+ '</option>';

					}

				}
			});
		});
$(document).ready(function() {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getalljobtype", // this is my servlet

				success : function(data) {
					var abc = data;
					var ele = document.getElementById('jobtype');
					for (var i = 0; i < abc.length; i++) {
						// POPULATE SELECT ELEMENT WITH JSON.
						ele.innerHTML = ele.innerHTML + '<option value="'
								+ abc[i]["tranid"] + '">'
								+ abc[i]["jobDescription"] + '</option>';
					}

				}
			});
		});

$(document).ready(function() {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getalljobstatus", // this is my servlet

				success : function(data) {
					var abc = data;
					var ele = document.getElementById('jobstatus');
					for (var i = 0; i < abc.length; i++) {
						ele.innerHTML = ele.innerHTML + '<option value="'
								+ abc[i]["jobstatusid"] + '">'
								+ abc[i]["description"] + '</option>';
					}

				}
			});
		});
//Designationdropdown
$(document).ready(function() {
	$.ajax({
	       type: "GET",
	       contentType : "application/json",
	       url: "getallDesignationdropdown",
	       success: function(data){ 
	       	var abc=data;
	       	var ele = document.getElementById('desgnpop');
	           for (var i = 0; i < abc.length; i++) {
	               ele.innerHTML = ele.innerHTML +
	                   '<option value="' + abc[i]["Designation"] + '">' + abc[i]["Designation"] + '</option>';
	                 
	           }
	       	
	       }
	});
});
//cadre*********************************************************

$(document).ready(function() {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getallCadre", // this is my servlet

				success : function(data) {
					var abc = data;
					var ele = document.getElementById('cadreid');
					for (var i = 0; i < abc.length; i++) {
						// POPULATE SELECT ELEMENT WITH JSON.
						ele.innerHTML = ele.innerHTML + '<option value="'
								+ abc[i]["tranid"] + '">'
								+ abc[i]["cadredescription"] + '</option>';
					}

				}
			});
		});

//*******************PROJECTS DROPDOWN****************************************************

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallproject", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('project');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["tranid"] + '">'
						+ abc[i]["projectname"] + '</option>';
			}

		}
	});
});


$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getAllIfscCodes", // this is my servlet

		success : function(data) {
			console.log(data);
			var abc = data;
			var ele = document.getElementById('ifsccode');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["tranid"] + '">'
						+ abc[i]["ifsccode"] + '</option>';
			}

		}
	});
});
//*************************getallsection***********************************

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallsection", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('sectionid');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["sectionid"] + '">' + abc[i]["name"]
						+ '</option>';
			}

		}
	});
});

//*************************getallCity***********************************

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getAllCity", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('citydropdown');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["City"] + '">' + abc[i]["City"]
						+ '</option>';
			}

		}
	});
});

//*************************getallDistrict***********************************

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getAllDistrict", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('districtdropdown');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["District"] + '">' + abc[i]["District"]
						+ '</option>';
			}

		}
	});
});
//*******************DEPARTMENT DROPDOWN**********************************8

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallDepartment", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('workdeptid');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["deptid"] + '">' + abc[i]["name"]
						+ '</option>';
			}

		}
	});
});


$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallDivision", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('division');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
			ele.innerHTML = ele.innerHTML + '<option value="'+ abc[i]["divisionid"] + '">' + abc[i]["name"]+ '</option>';								
			
			}

		}
	});
});

$(document).ready(function() {
        var division = document.getElementById('division').value;
        //alert("Division : "+division);
        division=1;
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getAllReportees?division="+division, // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('reportingempid');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'+ abc[i]["idNumber"] + '">'+ abc[i]["employeeName"] + '</option>';
						
			}

		}
	});
});

$(document).ready(function() {
	$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "getallempstatus", // this is my servlet

				success : function(data) {
					var abc = data;
					var ele = document.getElementById('empstatus');
					for (var i = 0; i < abc.length; i++) {
						// POPULATE SELECT ELEMENT WITH JSON.
						ele.innerHTML = ele.innerHTML + '<option value="'
								+ abc[i]["empstatusid"] + '">'
								+ abc[i]["description"] + '</option>';
					}

				}
			});
		});

$(document).ready(function() {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getallempgrade", // this is my servlet
				success : function(data) {
					var abc = data;
					var ele = document.getElementById('gradeId');
					for (var i = 0; i < abc.length; i++) {
						ele.innerHTML = ele.innerHTML + '<option value="'
								+ abc[i]["gradeno"] + '">'
								+ abc[i]["description"] + '</option>';
					}

				}
			});
		});

function deleteDocument() {

	$("#empdoc").on('click','#deleteDocument',function() {
				var currentRow = $(this).closest("tr");
				var tranid = currentRow.find("td:eq(0)").html();
				var filename = currentRow.find("td:eq(3)").html();

				var retVal = confirm("would you like to delete this tranid "
						+ tranid + " and Filename is :" + filename + "?");
				if (retVal == true) {
					deletedSuccessfullydeleteDocument(tranid);
				} else {
					document.write("User does not want to continue!");
				}
				// familysave();

			});
}

function deletedSuccessfullydeleteDocument(tranid) {
	$.ajax({
		type : "post",
		contentType : "application/json",
		url : "deleteDocument?tranid=" + tranid, // this is my servlet
		success : function(data) {
			////alert("Deleted successfully Document")
			window.location.reload();
		}
	});

}

	$("#empdoc").on('click','#downloadFile',function(){
		var currentRow = $(this).closest("tr");
		var tranid = currentRow.find("td:eq(0)").html();
		 window.location='downloadservlet?tranid='+tranid;
		
	});
	

//to fetch data job details
$(document).ready(function() {	
  var tranid = document.getElementById("tranid").value;
  //alert(">>Tranid>"+tranid);
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/HRMS/getEmpInfoByTranid?tranid="+ tranid,
		success : function(data) {
		document.getElementById("doj").value = data[0]["dateOfJoining"];
		document.getElementById("empname").value = data[0]["employeeName"];
		document.getElementById("design").value = data[0]["design"];
		document.getElementById("division").value = data[0]["workingDivisionId"];
        document.getElementById("empid").value = data[0]["employeeNumber"];
		document.getElementById("jobtype").value = data[0]["jobtype"];
		document.getElementById("jobstatus").value = data[0]["jobStatus"];
		document.getElementById("gradeId").value = data[0]["gradeId"];
		document.getElementById("cadreid").value = data[0]["cadreId"];
		document.getElementById("sectionid").value = data[0]["sectionId"];
		document.getElementById("workdeptid").value = data[0]["workDeptId"];
		document.getElementById("gender").value = data[0]["gender"];
		document.getElementById("project").value = data[0]["project"];
		document.getElementById("EmailId").value = data[0]["emailId"];
		document.getElementById("MobileNumber").value = data[0]["mobileNumber"];
		document.getElementById("biometric_id").value = data[0]["biometric_id"];
		document.getElementById("idNumber").value = data[0]["idNumber"];
                document.getElementById("pflimit").value = data[0]["settingDTO.pflimit"];
                document.getElementById("esilimit").value = data[0]["settingDTO.esilimit"];
                document.getElementById("skillid").value = data[0]["skillid"];
                //alert("Skill ID : "+data[0]["skillid"]);
                document.getElementById("skillid").SelectedValue = 3;
                if(data[0]["skillid"]==1){
                    document.getElementById("dailywage").value = data[0]["settingDTO.dwskilled"];
                }
                if(data[0]["skillid"]==2){
                    document.getElementById("dailywage").value = data[0]["settingDTO.dwsemiskilled"];
                }
                if(data[0]["skillid"]==3){
                    document.getElementById("dailywage").value = data[0]["settingDTO.dwunskilled"];
                }
                if(data[0]["settingDTO.isTechnical"]==1){
                      $("#isTechnical").attr("checked","checked");
                }
                if(data[0]["settingDTO.isReportee"]==1){
                      $("#isReportee").attr("checked","checked");
                }
                
		$("#bioidasidno").val(data[0].settingDTO.bioidasidno); 
		if(data[0]["cadreId"]==3){
            $("#salary").hide();
            $("#dailywage1").show();
          }
		else{
			
			$("#salary").show();
            $("#dailywage1").hide();
		}
//                $("#esilimit").val(data[0].settingDTO.Esilimit);                
//                $("#pflimit").val(data[0].settingDTO.Pflimit);          

//		document.getElementById("familyidnumber").value = data[0]["idNumber"]
//		document.getElementById("Expid").value = data[0]["idNumber"]
//		document.getElementById("shifschIdNumber").value = data[0]["idNumber"]
//		document.getElementById("Epid").value = data[0]["idNumber"]
//		document.getElementById("Personalparentid1").value = data[0]["idNumber"]

		//openEmpDocs();
		//openPersonal();
		//openFamily();
		//openEducation();
		//openExp();
		//openSalry();
		//openOtherDetails();
		//showImage();

	}
});
});

/* EmployeeShiftsShedule start */
$(document).ready(function() {
		var parentid = document.getElementById("idNumber").value;
			$.ajax({
						type : "GET",
						contentType : "application/json",
						url : "/HRMS/getAllEmployeeShiftsSchedule?idno="+ parentid,
						// this is my servlet
						success : function(data) {
							document.getElementById("shifschIdNumber").value = data[0]["idno"]
							document.getElementById("monday").value = data[0]["monday"]
							document.getElementById("tuesday").value = data[0]["tuesday"]
							document.getElementById("wednesday").value = data[0]["wednesday"]
							document.getElementById("thursday").value = data[0]["thursday"]
							document.getElementById("friday").value = data[0]["friday"]
							document.getElementById("saturday").value = data[0]["saturday"]
							document.getElementById("sunday").value = data[0]["sunday"]
							document.getElementById("effectFrom").value = data[0]["effectFrom"]
							document.getElementById("effectTo").value = data[0]["effectTo"]
							document.getElementById("otEligibility").value = data[0]["otEligibility"]
						  //document.getElementById("isActive").value = data[0]["isActive"]
									}
								});
					});


/* EmployeeShiftsShedule End */
	$(document).ready(function() {
						var tranid = document.getElementById("tranid").value;
						var parentid = document.getElementById("idNumber").value;
						var selectedRecord;
						var branchifsccode;
						$.ajax({
									type : "GET",
									contentType : "application/json",
									url : "/HRMS/getpersonalInfoByParentid?parentid="+ parentid,
											 // this is my servlet
									success : function(data) {
										console.log(data);
										
										document.getElementById("emailid").value = data[0]["emailid"]
										document.getElementById("maritalstatus").value = data[0]["maritalstatus"]
										document.getElementById("mobilenumber").value = data[0]["mobilenumber"]
										document.getElementById("alternatemobilenumber").value = data[0]["alternatemobilenumber"]
										document.getElementById("drivinglicenceno").value = data[0]["drivinglicenceno"]
										document.getElementById("drivinglicencevalidity").value = data[0]["drivinglicencevalidity"]
										document.getElementById("passportnumber").value = data[0]["passportnumber"]
										document.getElementById("passportvalidity").value = data[0]["passportvalidity"]
										document.getElementById("adhaarnumber").value = data[0]["adhaarnumber"]
										document.getElementById("pancardnumber").value = data[0]["pancardnumber"]
										document.getElementById("bankname").value = data[0]["bankname"]
										document.getElementById("bankbranch").value = data[0]["bankbranch"]
										document.getElementById("ifsccode").value = data[0]["branchifsccode"]
										document.getElementById("accountnumber").value = data[0]["accountnumber"]
										document.getElementById("cardnumber").value = data[0]["cardnumber"]
										document.getElementById("presentaddress").value = data[0]["presentaddress"]
										document.getElementById("permanentaddress").value = data[0]["permanentaddress"]
										document.getElementById("personalinfotranid").value = data[0]["tranid"]
										document.getElementById("bloodgroup").value= data[0]["bloodgroup"]
										document.getElementById("doBirth").value = data[0]["doBirth"]
										document.getElementById("city").value = data[0]["city"]
									//	alert(data[0]["city"]);
										document.getElementById("district").value = data[0]["district"]
										document.getElementById("state").value = data[0]["state"]
									}
								});
					
		});

	$(document).ready(function() {
	   var parentid = document.getElementById("idNumber").value;
        var cadreid = document.getElementById("cadreid").value;
        var skill = document.getElementById("skillid").value;

						$.ajax({
									type : "GET",
									contentType : "application/json",
									url : "/HRMS/getsalaryInfoByTranid?parentid="+ parentid,
											 // this is my servlet
									success : function(data) {
										document.getElementById("wef").value = data[0]["wef"];
										document.getElementById("da").value = data[0]["da"];
										document.getElementById("hra").value = data[0]["hra"];
										document.getElementById("conveyance").value = data[0]["conveyance"];
										document.getElementById("others1").value = data[0]["others1"];
										document.getElementById("grosssalary").value = data[0]["grosssalary"];
										document.getElementById("esinumber").value = data[0]["esinumber"];
										document.getElementById("pfpercentage").value = data[0]["pfpercentage"];
                                        document.getElementById("pfamount").value = data[0]["pfamount"];
										document.getElementById("employercontribution").value = data[0]["employercontribution"];
										document.getElementById("vpfpercentage").value = data[0]["vpfpercentage"];
										document.getElementById("basic").value = data[0]["basic"];
										document.getElementById("lta").value = data[0]["lta"];
										document.getElementById("medical").value = data[0]["medical"];
										document.getElementById("bonus").value = data[0]["bonus"];
										document.getElementById("ctc").value = data[0]["ctc"];
										document.getElementById("esipercentage").value = data[0]["esipercentage"];
                                        document.getElementById("esiamount").value = data[0]["esiamount"];
										document.getElementById("uannumber").value = data[0]["uannumber"];
										document.getElementById("epscontribution").value = data[0]["epscontribution"];
										document.getElementById("others2").value = data[0]["others2"];
										document.getElementById("salarytranid").value = data[0]["tranid"];
										document.getElementById("autocalc").value = data[0]["autocalc"];
										document.getElementById("dailywage").value = data[0]["dailywage"];
										document.getElementById("wefdailywage").value = data[0]["wef"];
                                    

									}
								});
					});


//function openOtherDetails() {
						$(document).ready(function() {
						//var tranid = document.getElementById("tranid").value;
						var parentid = document.getElementById("idNumber").value;
                          $.ajax({
									type : "GET",
									contentType : "application/json",
									url : "/HRMS/getOtherDetailsInfoByTranid?parentid="+ parentid, // this is my servlet
									success : function(data) {
                                        document.getElementById("languages").value = data[0]["languagesknown"]
										document.getElementById("qualification").value = data[0]["qualification"]
										document.getElementById("previousexperience").value = data[0]["previousexperience"]
										document.getElementById("currentexperience").value = data[0]["currentexperience"]
                                        
                                        $.each(data[0]["languagesknown"].split(','), function(index, element){
                                            $('#languages').find('option[value="'+element+'"]').attr('Selected', 'Selected');

                                        });

									}
								});
					});
//}

						//for image
						
						
						
						
function storeDocDetails() {
	debugger
	alert("storeDocDetails");
	var tranid = document.getElementById("tranid").value;
	var idno = document.getElementById("idNumber").value;
	var fileDescription = document.getElementById("fileDescription").value;
	var filecover = document.getElementById("doc").files[0];
	alert("filecover "+filecover );
	var formdata = new FormData();
	formdata.append("fileDescription", fileDescription);
	formdata.append("filecover", filecover);

	$.ajax({
		type : "post",
		// contentType: false,
		url : "storeDocDetails?idno=" + idno, // this controller url
		//url : "storeDocDetails1",
		data : formdata,
		processData : false,
		contentType : false,
		success : function(data) {
			 window.location.reload();
			
		}

	});

}
function storeExcelDocDetails() {
	debugger
	alert("storeDocDetails");
	var tranid = document.getElementById("tranid").value;
	var idno = document.getElementById("idNumber").value;
	var fileDescription = document.getElementById("fileDescription").value;
	var filecover = document.getElementById("doc").files[0];
	alert("filecover "+filecover );
	var formdata = new FormData();
	formdata.append("fileDescription", fileDescription);
	formdata.append("filecover", filecover);

	$.ajax({
		type : "post",
		// contentType: false,
		url : "storeDocDetails?idno=" + idno, // this controller url
		//url : "storeDocDetails1",
		data : formdata,
		processData : false,
		contentType : false,
		success : function(data) {
			 window.location.reload();
			
		}

	});

}

function storeDocDetails1() {

	var idno = document.getElementById("idNumber").value;
	var fileDescription = document.getElementById("fileDescription").value;
	var filecover = document.getElementById("doc").files[0];
	var formdata = new FormData();
	formdata.append("fileDescription", fileDescription);
	formdata.append("filecover", filecover);

	$.ajax({
		type : "post",
		// contentType: false,
		url : "storeDocDetails?idno=" + idno, // this controller url
		//url : "storeDocDetails1",
		data : formdata,
		processData : false,
		contentType : false,
		success : function(data) {
			 window.location.reload();
			
		}

	});

}


function storeEmpImages() {
	alert("storeEmpImages")
	//var tranid = document.getElementById("tranid").value;
	var idno = document.getElementById("idNumber").value;
	var filecover = document.getElementById("fileUpload").files[0];
	var formdata = new FormData();
	formdata.append("filecover", filecover);

	$.ajax({
		type : "post",
		// contentType: false,
		url : "storephotodetails?idno=" + idno, // this controller url
		data : formdata,
		processData : false,
		contentType : false,
		success : function(data) {
			window.location.reload();
			//openEditPage(tranid)
		}

	});

}

function editempinfo() {
	var editData = {};
	editData["employeeNumber"] = $("#empid").val();
	editData["employeeName"] = $("#empname").val();
	editData["idNumber"] = $("#idNumber").val();
	editData["dateOfJoining"] = $("#doj").val();
	editData["design"] = $("#design").val();
	editData["employeeStatus"] = $("#empstatus").val();
	editData["workingDivisionId"] = $("#division").val();
	editData["gradeId"] = $("#gradeId").val();
	editData["jobStatus"] = $("#jobstatus").val();
	editData["cadreId"] = $("#cadreid").val();
    editData["workDeptId"] = $("#workdeptid").val();
	editData["gender"] = $("#gender").val();
	editData["reportingEmpId"] = $("#reportingempid").val();
	editData["project"] = $("#project").val();
	editData["sectionId"] = $("#sectionid").val();
	editData["jobtype"] = $("#jobtype").val();
    editData["skillid"] = $("#skillid").val();
    editData["emailId"] = $("#EmailId").val();
    editData["mobileNumber"] = $("#MobileNumber").val();
        if(document.getElementById("isTechnical").checked){
            editData["isTechnical"] = 1;
        }else{
            editData["isTechnical"] = 0;
        }
        if(document.getElementById("isReportee").checked){
            editData["isReportee"] = 1;
        }else{
            editData["isReportee"] = 0;
        }

	editData["biometric_id"] = $("#biometric_id").val();
	
	$.ajax({
		type : "post",
		contentType : "application/json",
		url : "editEmployee", // this is my servlet
		data : JSON.stringify(editData),
		success : function(data) {
			$("#jobdetailsUpdateDisplayMessage").html(data["successMessage"]);
	        setInterval(function(){
	        	window.location.reload(); // this will run after every 5 seconds
	        }, 5000);
			//empinfo();
		}
	});

}


/* update Employee Shifts Start */
function editEmployeeShifts() {
	var editemployeeshifts = {};
	editemployeeshifts["idno"] = $("#shifschIdNumber").val();
	editemployeeshifts["monday"] = $("#monday").val();
	editemployeeshifts["tuesday"] = $("#tuesday").val();
	editemployeeshifts["wednesday"] = $("#wednesday").val();
	editemployeeshifts["thursday"] = $("#thursday").val();
	editemployeeshifts["friday"] = $("#friday").val();
	editemployeeshifts["saturday"] = $("#saturday").val();
	editemployeeshifts["sunday"] = $("#sunday").val();
	editemployeeshifts["effectFrom"] = $("#effectFrom").val();
	editemployeeshifts["effectTo"] =  $("#effectTo").val();
	editemployeeshifts["otEligibility"] = $("#otEligibility").val();
	//editemployeeshifts["isActive"] = $("#isActive").val();
	$.ajax({
		type : "post",
		contentType : "application/json",
		url : "updateemployeeshifts", // this is my servlet
		data : JSON.stringify(editemployeeshifts),
		success : function(data) {
			 $("#empShiftsDisplayMessage").html(data["successMessage"]);
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 5000);
		}
	});

}
/* update Employee Shifts End */
///////////////////////////////////////////pending///////////////////////

function editpersonalinfo() {
	var editpersonalData = {};
	editpersonalData["personalparentid"] = $("#Personalparentid1").val();
	editpersonalData["emailid"] = $("#emailid").val();
	editpersonalData["doBirth"] = $("#doBirth").val();
	editpersonalData["maritalstatus"] = $("#maritalstatus").val();
	editpersonalData["mobilenumber"] = $("#mobilenumber").val();
	editpersonalData["alternatemobilenumber"] = $("#alternatemobilenumber").val();
	editpersonalData["drivinglicenceno"] = $("#drivinglicenceno").val();
	editpersonalData["drivinglicencevalidity"] = $("#drivinglicencevalidity").val();
	editpersonalData["passportnumber"] = $("#passportnumber").val();
	editpersonalData["passportvalidity"] = $("#passportvalidity").val();
	editpersonalData["adhaarnumber"] = $("#adhaarnumber").val();
	editpersonalData["pancardnumber"] = $("#pancardnumber").val();
	editpersonalData["bankname"] = $("#bankname").val();
	editpersonalData["bankbranch"] = $("#bankbranch").val();
	editpersonalData["branchifsccode"] = $("#ifsccode").val();
	editpersonalData["accountnumber"] = $("#accountnumber").val();
	editpersonalData["cardnumber"] = $("#cardnumber").val();	
	editpersonalData["presentaddress"] = $("#presentaddress").val();
	editpersonalData["permanentaddress"] = $("#permanentaddress").val();
	editpersonalData["bloodgroup"] = $("#bloodgroup").val();
	editpersonalData["tranid"] = $("#personalinfotranid").val();
	editpersonalData["city"] = $("#city").val();
	//alert("editpersonalData"+editpersonalData["city"]);
	editpersonalData["district"] = $("#district").val();
	editpersonalData["state"] = $("#state").val();
	$.ajax({
		type : "post",
		contentType : "application/json",
		url : "editPersonaldetails", // this is my servlet
		data : JSON.stringify(editpersonalData),
		success : function(data) {
			 $("#personalDetailsDisplayMessage").html(data["successMessage"]);
		        
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 5000);
		}
	});

}
function getBDetailsByIfsc(){
	var ifsccode = document.getElementById("ifsccode").value;
	console.log(ifsccode);
	$.ajax({
		 type : "get",
		contentType : "application/json",
		url : "getBankDetailsByIfsc?ifsccode="+ifsccode, // this is my servlet
		success : function(data) {
			console.log(data);
			document.getElementById("bankname").value = data[0]["bankname"]
			document.getElementById("bankbranch").value = data[0]["branchname"]

		
		}
	});
}
function editsalaryinfo() {
	var gobacktranid = document.getElementById("tranid").value;
	var editsalaryData = {};
	editsalaryData["wef"] = $("#wef").val();
	editsalaryData["da"] = $("#da").val();
	editsalaryData["hra"] = $("#hra").val();
	editsalaryData["conveyance"] = $("#conveyance").val();
	editsalaryData["others1"] = $("#others1").val();
	editsalaryData["grosssalary"] = $("#grosssalary").val();
	editsalaryData["esinumber"] = $("#esinumber").val();
	editsalaryData["pfpercentage"] = $("#pfpercentage").val();
    editsalaryData["pfamount"] = $("#pfamount").val();
	editsalaryData["employercontribution"] = $("#employercontribution").val();
	editsalaryData["vpfpercentage"] = $("#vpfpercentage").val();
	editsalaryData["basic"] = $("#basic").val();
	editsalaryData["lta"] = $("#lta").val();
	editsalaryData["medical"] = $("#medical").val();
	editsalaryData["bonus"] = $("#bonus").val();
	editsalaryData["ctc"] = $("#ctc").val();
	editsalaryData["esipercentage"] = $("#esipercentage").val();
    editsalaryData["esiamount"] = $("#esiamount").val();
	editsalaryData["uannumber"] = $("#uannumber").val();
	editsalaryData["epscontribution"] = $("#epscontribution").val();
	editsalaryData["others2"] = $("#others2").val();
    editsalaryData["dailywage"] = $("#dailywage").val();
	editsalaryData["idno"] = $("#salaryparentid").val();
	editsalaryData["tranid"] = $("#salarytranid").val();
	$.ajax({
		type : "post",
		contentType : "application/json",
		url : "editSalarydetails", // this is my servlet
		data : JSON.stringify(editsalaryData),
		success : function(data) {
			window.location.reload();
		}
	});

}

$(document).ready(function() {
	var gobacktranid = document.getElementById("tranid").value;
	$("#saveotherdetails").click(function() {
		var languages = [];
		$.each($("#languages option:selected"), function() {
			languages.push($(this).val());
		});
		var languages = languages.join(",");
		var otherdetails = {};
		otherdetails["idno"] = $("#idNumber").val();
		otherdetails["languagesknown"] = languages;
		otherdetails["qualification"] = $("#qualification").val();
		otherdetails["previousexperience"] = $("#previousexperience").val();
		otherdetails["currentexperience"] = $("#currentexperience").val();
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "editOtherdetails", // this is my servlet
			data : JSON.stringify(otherdetails),
			// data: {
			// visitorname: $('#visitorname').val(),
			// },
			success : function(data) {
				window.location.reload();
			}
		});

	});

});
	$(document).ready(function() {
							var parentid = document.getElementById("idNumber").value;
							$('#empdoc').dataTable(
									{
										"ajax" : {
											"url" : "/HRMS/getEmpDocs?idno="
													+ parentid,
											"dataSrc" : "",
											"type" : "GET",
										},
										"columns" : [
										        {data : "tranid"},
												{data : "idno"},
												{data : "filename"},
												{data : "description"},
                                                 {
													data : null,
													className : "center",
													defaultContent : ' <input type="image" src="resources/assets/images/delete.png" id="deleteDocument" height="15" width="18"  onclick="deleteDocument()" > <input type="image" src="resources/assets/images/download1.jpg" id="downloadFile"  height="30" width="30"  "  >'
												} ],
									});
				});
	$(document).ready(function() {
						var parentid = document.getElementById("idNumber").value;
					//	alert(parentid);
						document.getElementById("myImg").src = "resources\\EmployeeImages\\"
								+ parentid + "\\" + parentid + ".jpg";
					});

	
	function getJoiningDetails(){
		alert("getJoiningDetails");
		
		var idno = document.getElementById("idNumber").value;
	    $.ajax({
					type : "GET",
					contentType : "application/json",
					url : "/HRMS/offerLetter?idno="+ idno, // this is my servlet
					success : function(data) {
						alert("SUCCESSFULLY DOWNLOADED");
						// openingOfferLetterpdffile();
						}

				});
	}

	function getAppointmentDetails(){
		alert("getAppointmentDetails");
		var idno = document.getElementById("idNumber").value;
	    $.ajax({
					type : "GET",
					contentType : "application/json",
					url : "/HRMS/appointmentOrder?idno="+ idno, // this is my servlet
					success : function(data) {
						alert("SUCCESSFULLY DOWNLOADED");
						//openingAppointmentOrderpdffile();
						}

				});
	}
	
	
	
	function openingOfferLetterpdffile() {
		alert("openingOfferLetterpdffile");
		$.ajax({
	        type: "get",
	        contentType : "application/json",
	        url: "openingOfferLetterpdffile", //this is my servlet
	        success: function(data){ 
	        
	        }
	  });
	}
	
	
	
	function openingAppointmentOrderpdffile() {
		alert("openingAppointmentOrderpdffile");
		$.ajax({
	        type: "get",
	        contentType : "application/json",
	        url: "openingAppointmentOrderpdffile", //this is my servlet
	        success: function(data){ 
	        
	        }
	  });
	}
	