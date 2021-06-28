 <%@include file="header.jsp"%>
    <link rel="stylesheet" href="resources/dist/css/icons/font-awesome/css/fontawesome.min.css">
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
<script src="resources/customjs/jobdetailsjs.js"></script> 

      <link rel="stylesheet" href="resources/bootstrapCSS/datepicker.css" />
      <script src="resources/customjs/bootstrap-datepicker.js"></script> 
      
<script>

$(function() {
	$("#doj").datepicker({
		dateFormat:"dd/mm/yyyy",
	});

});

$(document).ready(function() {
	//window.location.reload();
})
</script>

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
					Joining</label> <input type="text" id="doj" name="doj" class="form-control">
 					
				</div>

				<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">Designation</label>
					<input type="text" id="desgn" name="desgn" class="form-control">

				</div>

				<div class="form-group has-warning   col-md-3">
					<label class="control-label" for="inputWarning1">JobType</label> <select
						class="form-control" id="jobtype" name="jobtype">
						<option value="">select</option>

					</select>
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
						<option value="">select</option>

					</select>
				</div>

				<div class="form-group has-warning   col-md-3">
					<label class="control-label" for="inputWarning1">Section</label>
					<select class="form-control" id="sectionid" name="sectionid">
						<option value="">select</option>

					</select>
				</div>

				<div class="form-group has-warning    col-md-3">
					<label class="control-label" for="inputWarning1">Project</label><br>
					<select class="form-control" id="project" name="project">
						<option value="">select</option>

					</select>
				</div>				
				
				<div class="form-group has-warning    col-md-3">
					<label class="control-label" for="inputWarning1">ReportingTo</label>
					<select class="form-control" id="reportingempid" name="reportingempid">
						<option value="0">select</option>
						
					</select>
				</div>

<!-- 			<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">EmpLoyee
						Status</label> <select class="form-control" id="empstatus">
						<option value="">select</option>
					</select>
				</div>
 -->

			</div>
			<div class="form-group has-warning    col-md-6">
					<label class="control-label" for="inputWarning1">Is
						Technical</label> <label> <input type="checkbox" id="istechnical1" name="istechnical1[]">
					</label><br>
				</div>
		</div>
		</form>
		<div align="center">
			<input type="submit" class="btn btn-success" value="Submit"
				 id="submitDetails">
		</div>

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
				 sectionid: {
                     validators: {
                         notEmpty: {
                             message: 'Section is required ',

                         }
                     }
                 },
				 project: {
                     validators: {
                         notEmpty: {
                             message: 'Project is required ',

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
saveJobDetails1();
}

});
 $('#doj')
        on('changeDate show', function(e) {
            // Revalidate the date when user change it
            $('#jobDetails').bootstrapValidator('revalidateField', 'doj');
    });
</script>
<script src="resources/dist/js/sidebarmenu.js"></script>
<%@include file="footer.jsp"%>