  <%@include file="header.jsp"%>
    <link rel="stylesheet" href="resources/dist/css/icons/font-awesome/css/fontawesome.min.css">
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->
<script src="resources/customjs/jobdetailsjs.js"></script> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>



</style>
      


<div id="displayDiv">
	<h3 id="processedData" align="center" style="color: red"></h3>
</div>

<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
		<form id="jobDetails">
			<div class="box-header well">
			<h3 align="center" style="color: green" id="jobdetailsDisplayMessage"></h3>
			<h3 align="center" style="color: #fb8c00">Job Details</h3>
            </div>
            <hr color="00FFFF">
            
			<div class="box-content row">

				<div class="form-group has-warning  col-md-3">
					<label class="control-label" for="inputWarning1">JobType</label> <select
						class="form-control" id="jobtype" name="jobtype" onchange= "jobtypeChange()">
						<option value="">select</option>

					</select>
				</div>

		
				<div id="contract" class="form-group has-warning  col-md-3">
					<label class="control-label" for="inputWarning1">Contract Person</label> <select
						class="form-control" id="contractperson" name="contractperson" onchange= "getContractId()" >
						<option value="0">select</option>

					</select>
				</div>
				
				<div class="form-group has-warning col-md-3">
					<label style="color: Blue" class="control-label" for="inputWarning1">Division
						Id</label> <select class="form-control" id="division" name="division" onchange="getCompId()">
						<option value="">select</option>
					</select>
				</div>
				

				<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1"> IDNo </label> <input
						type="text" id="idNumber" name="idNumber" class="form-control" readonly="readonly">

				</div>
								
				<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">Employee
						Code</label> <input type="text" id="empno" name="empno" class="form-control">

				</div>

				<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">Employee
						Name</label> <input type="text" id="empname" name="empname" class="form-control">

				</div>

				<div class="form-group has-warning   col-md-3">
					<label class="control-label" for="inputWarning1">Gender</label> <select
						class="form-control" id="gender" name="gender">
						<option value="">select</option>
						<option value="male">Male</option>
						<option value="Female">Female</option>
						<option value="Other">Other</option>
					</select>
				</div>

				<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1"> Date Of
					Joining</label> <input type="text" id="doj" name="doj" class="form-control" placeholder="YYYY-MM-DD">
 					
				</div>
				<div class="form-group has-warning col-md-3">
				 <label class="control-label" for="inputWarning1">Designation</label>
                 <input list="desgnpop" id="desgn" name="desgn" class="form-control"  />
                 <datalist id="desgnpop">
                 </datalist>
                 </div>
		
				
				<div class="form-group has-warning   col-md-3">
					<label class="control-label" for="inputWarning1">JobStatus</label>
					<select class="form-control" id="jobstatus" name="jobstatus">
						<option value="">select</option>

					</select>

				</div>


				<div class="form-group has-warning   col-md-3">
					<label class="control-label" for="inputWarning1">Grade</label> <select
						class="form-control" id="gradeid" name="gradeid">
						<option value="">select</option>

					</select>
				</div>

				<div class="form-group has-warning   col-md-3">
					<label class="control-label" for="inputWarning1">Cadre</label> 
					<select class="form-control" id="cadreid" name="cadreid">
						<option value="">select</option>

					</select>
				</div>
				
				<div class="form-group has-warning   col-md-3">
					<label class="control-label"  for="inputWarning1">Department</label>
					<select class="form-control" id="workdeptid" name="workdeptid">
						<option value="0">select</option>

					</select>
				</div>

				<div class="form-group has-warning   col-md-3">
					<label class="control-label" for="inputWarning1">Section</label>
					<select class="form-control" id="sectionid" name="sectionid">
						<option value="0">select</option>

					</select>
				</div>

				<div class="form-group has-warning    col-md-3">
					<label class="control-label" for="inputWarning1">Project</label><br>
					<select class="form-control" id="project" name="project">
						<option value="0">select</option>
					</select>
				</div>				
				
				<div class="form-group has-warning    col-md-3">
					<label class="control-label" for="inputWarning1">Reporting To</label>
					<!--  <select class="form-control" id="reportingempid" name="reportingempid">
						<option value="0">select</option>						
					</select> -->
					 <input list="reporting" id="reportingempid" name="reportingempid"  class="form-control" >
					<datalist id="reporting" >
					</datalist>
				</div>

        		<div class="form-group has-warning    col-md-3">
                		<label class="control-label" for="inputWarning1">Skill Set</label><br> 
                        	<select class="form-control" id="skillid" name="skillid">
			        <option value="0">Select</option> 
                                <option value="1">Skilled</option>
				<option value="2">Semi-Skilled</option>
				<option value="3">Un-Skilled</option>
                                </select>
                        </div>    
                        <div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">EmailId
					</label> <input type="text" id="EmailId" name="EmailId" class="form-control">

				</div>
                     
                     <div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">MobileNumber
					</label> <input type="text" id="Mobile" name="Mobile" class="form-control">

				</div>
                                
			<div class="form-group has-warning    col-md-3">
					<label class="control-label" for="inputWarning1">Is
						Technical</label> <label> <input type="checkbox" id="istechnical" name="istechnical">
					</label><br>
			</div>
                            
			<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">Is
						Reportee</label> <label> <input type="checkbox" id="isreportee" name="isreportee">
					</label><br>
			</div>
            			</div>
            			</form>
		</div>
		
		<div align="center">
			<input type="submit" class="btn btn-success" value="Submit"
				 id="submitDetails">
		</div>
                <div align="center"><img src="resources/img/reload.gif" id="image" hidden></div>
	</div>

</div>

<script src="resources/validation/bootstrapValidator.min.js"></script>

<script>
 $('#jobDetails').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
             division: {
                     validators: {
                         notEmpty: {
                             message: 'Division required ',
                          },
                        }
                  },
			 
                  
				  employeeShortName: {
                     validators: {
                         notEmpty: {
                             message: 'Shortname required ',
                          },
                        }
                  },
				  doj: {
                     validators: {
                         notEmpty: {
                             message: 'Date of joining  required ',
                          },
                        }
                  },
				  empstatus: {
                     validators: {
                         notEmpty: {
                             message: 'Employee Status required ',
                          },
                        }
                  },
                 empno: {
                     validators: {
                         notEmpty: {
                             message: 'Employee Code required ',
                          },
                        }
                 },

                 empname: {
                     validators: {
                         notEmpty: {
                             message: 'Name is required ',

                         }
                     }
                 },
                 gender: {
                     validators: {
                         notEmpty: {
                             message: 'Gender required ',
                          },
                        }
                  },
				  doj: {
                     validators: {
                         notEmpty: {
                             message: 'DOJ required ',
                          },
                         date: {
                        format: 'YYYY-MM-DD',
                        message: 'The value is not a valid date'
                    }
                        }
                  },
				  desgn: {
                     validators: {
                         notEmpty: {
                             message: 'Designation required ',
                          },
                        }
                  },
				  jobtype: {
                     validators: {
                         notEmpty: {
                             message: ' JobType is  required ',
                          },
                        }
                  },
				  
                 jobstatus: {
                     validators: {
                         notEmpty: {
                             message: 'JobStatus is required ',
                          },
                        }
                  },

                 gradeid: {
                     validators: {
                         notEmpty: {
                             message: 'Grade is required ',

                         }
                     }
                 },
                cadreid: {
                     validators: {
                         notEmpty: {
                             message: 'Cadre is required ',

                         }
                     }
                 },
				 workdeptid: {
                     validators: {
                         notEmpty: {
                             message: 'Department is required ',

                         }
                     }
                 },
//				 sectionid: {
//                     validators: {
//                         notEmpty: {
//                             message: 'Section is required ',
//
//                         }
//                     }
//                 },
				 project: {
                     validators: {
                         notEmpty: {
                             message: 'Project is required ',

                         }
                     }
                 },
                 EmailId: {
                     validators: {
                         notEmpty: {
                             message: 'Emailid required ',
                          },
                          regexp: {
                              regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                              message:'Please enter valid email address.'
                            }
                        }
                  },
                Mobile : {
                     validators: {
                         notEmpty: {
                             message: 'Mobile Number is required ',

                         }
                     }
                 },

             }

         });
</script>
<script>

$("#submitDetails").on("click", function(){

$('#jobDetails').data('bootstrapValidator').validate();
if($('#jobDetails').data('bootstrapValidator').isValid()){
saveJobDetails();

}

});
 $('#doj').
        on('changeDate show', function(e) {
            // Revalidate the date when user change it
            $('#jobDetails').bootstrapValidator('revalidateField', 'doj');
    });
</script>
<script src="resources/dist/js/sidebarmenu.js"></script>
<%@include file="footer.jsp"%>
<script>
jQuery('#doj').datepicker({
    autoclose: true,
    todayHighlight: true
});

</script> 




