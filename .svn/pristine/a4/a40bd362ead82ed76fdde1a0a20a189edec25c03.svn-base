 <%@include file="header.jsp" %>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
 <style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid black;
	text-align: left;
	padding: 6px;
}

.search-table-outter {
	border:;
}

.search-table {
	table-layout: fixed;
	margin: 40px auto 0px auto;
}

.search-table, td, th {
	border-collapse: collapse;
	border: 1px solid #777;
}

th {
	padding:;
	font-size: 15px;
	color: #444;
	background: #66C2E0;
}

td {
	padding:;
	height: 35px;
}

.search-table-outter {
	overflow-x: scroll;
}

th, td {
	min-width:;
}
</style>
<script>
$(document).ready(function(){
	   // $("#warnings").hide();
	    $("#shiftsavesuccess").hide();
	    $("#shiftsEditsuccess").hide();
	   
	});
</script>
 <script>
$(document).ready(function() {
	$('#shifts').dataTable( {
			 "ajax" : {
			"url" : "/DASHBOARD/getShifts",
			"dataSrc" : "dataBean",
			"type" : "GET",
		},
			"columns": [
							{ data: "shiftid"},
			 				{ data: "name"},
					 		{ data: "starttime"},
 							{ data: "endtime"},
							{ data: "gracetime"},
							{ data: "lunchouttime"},
							{ data: "lunchintime"},
							{ data: "duration"},
							{ data: "daycrossed"},
							{ data: "statusCodeForActive"},
							
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="shiftedit" >   <input type="image" src="resources/assets/images/delete.png" id="shiftsdelete" height="25" width="25"  onclick="ShiftsDelete()">'
				            }
					],
		
		} );
	
} );
</script>
<script>
	$("#shifts").on('click','#shiftedit',function() {
	var currentRow = $(this).closest("tr");
	var rowData = $("#shifts").DataTable().row(currentRow).data();
     var shiftid = rowData.shiftid;
	retrieve:true,
	$.ajax({
 contentType : "application/json",
"url" : "/DASHBOARD/shiftnamebasedonid?shiftid="+ shiftid,
"dataSrc" : "dataBean",
	"type" : "GET",
success : function(data) {
 for (var i = 0; i < data.length; i++) {
	$("#shiftid").val(data[i].shiftid);
	$("#name").val(data[i].name);
	$("#starttime").val(data[i].starttime);
	$("#endtime").val(data[i].endtime);
	$("#gracetime").val(data[i].gracetime);
	$("#lunchouttime").val(data[i].lunchouttime);
	$("#lunchintime").val(data[i].lunchintime);
	$("#duration").val(data[i].duration);
	$("#daycrossed").val(data[i].daycrossed);
	$("#isactive").val(data[i].isactive);
		}
    selectedRecord = data;
},
});
$('#shiftTypeModal').modal('show');
});
</script>
	
	<script>
	function ShiftsDelete(){
		 $("#shifts").on('click', '#shiftsdelete', function() {
				var currentRow = $(this).closest("tr");
			    var shiftid = currentRow.find("td:eq(0)").html(); 
			    var retVal = confirm("would you like to delete this shiftid "+shiftid);
	           if( retVal == true ) {
	            //  document.write ("User wants to continue!");
	              deletedSuccessfully(shiftid);
	           } else {
	              //document.write ("User does not want to continue!");
	           }
	         
		 });
	}
function deletedSuccessfully(shiftid){
		 $.ajax({
		        type: "post",
		        contentType : "application/json",
		        url: "deleteShifts?shiftsid="+shiftid, //this is my servlet
		        success : function(data) {
		        	$("#deletemessage").html("DeletedSucessFully");
		        	 setInterval(function(){
		 	        	window.location.reload(); // this will run after every 5 seconds
		 	        }, 2000);
				}
		        
		  });
	}
</script>

<script>
function editshifts(){
	var editshifts = {};
	editshifts["shiftid"] = $("#shiftid").val();
	editshifts["name"] = $("#name").val();
	editshifts["starttime"] = $("#starttime").val();
	editshifts["endtime"] = $("#endtime").val();
	editshifts["gracetime"] = $("#gracetime").val();
	editshifts["lunchouttime"] = $("#lunchouttime").val();
	editshifts["lunchintime"] = $("#lunchintime").val();
	editshifts["duration"] = $("#duration").val();
	editshifts["daycrossed"] = $("#daycrossed").val();
	editshifts["isactive"] = $("#isactive").val();
	
	$.ajax({
	type : "post",
	contentType : "application/json",
	url : "editShifts", //this is my servlet
	data : JSON.stringify(editshifts),
	success : function(data) {
	$("#EditShiftStrong").html(data["successMessage"]);
	$("#shiftsEditsuccess").show();
	setInterval(function(){
	window.location.reload(); // this will run after every 5 seconds
	}, 2000);
	}
	});
}
</script>
	
	
	<script>
function saveshifts(){
	var saveshifts = {};
	saveshifts["name"] = $("#Name").val();
	saveshifts["starttime"] = $("#Starttime").val();
	saveshifts["endtime"] = $("#Endtime").val();
	saveshifts["gracetime"] = $("#Gracetime").val();
	saveshifts["lunchouttime"] = $("#Lunchouttime").val();
	saveshifts["lunchintime"] = $("#Lunchintime").val();
	saveshifts["duration"] = $("#Duration").val();
	saveshifts["daycrossed"] = $("#Daycrossed").val();
	$.ajax({
	type : "post",
	contentType : "application/json",
	url : "saveShifts", //this is my servlet
	data : JSON.stringify(saveshifts),
	success : function(data) {
	$("#shiftStrong").html(data["successMessage"]);
	$("#shiftsavesuccess").show();
	setInterval(function(){
	window.location.reload(); // this will run after every 5 seconds
	}, 2000);
	}
	});
}
</script>
	
	
 <div>
	<h5 align="center">
		To Add New Shifts <a data-toggle="modal"
			data-target="#myshift" id="" onclick="" href="#">Click
			Here</a>
	</h5>
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>
<div class="search-table-outter wrapper">
<table id="shifts" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		<th>ShiftsId</th>
                <th>Name</th>
                <th>StartTime</th>
                <th>EndTime</th>
                <th>GraceTime</th>
                <th>LunchOutTime</th>
                <th>LunchInTime</th>
                <th>Duration</th>
                <th>DayCrossed</th>
                <th>Status</th>
                <th>Edit  /  Delete </th>
             </tr>
        </thead>
       
    </table>
    </div>
 
 <!--***************************** Shifts Edit Model Box *********************************-->
    
  <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="shiftTypeModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="shiftsEditsuccess" style="text-align:center">
  		<strong id="EditShiftStrong" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Shifts Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "editshiftvalidation">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="gradeno">ShiftID</label>
						<input type="text"  id="shiftid" name="shiftid" class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="name">Name</label>
						<input type="text" id="name" name="name" class="form-control">
					</div>

	              <div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="starttime">StartTime</label>
						<input type="text" id="starttime" name="starttime" class="form-control">
					</div>
                     
                     <div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="endtime">EndTime</label>
						<input type="text" id="endtime" name="endtime" class="form-control">
					</div>
                     <div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="gracetime">GraceTime</label>
						<input type="text" id="gracetime" name="gracetime" class="form-control">
					</div>
					
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="lunchouttime">LunchOutTime</label>
						<input type="text" id="lunchouttime" name="lunchouttime" class="form-control">
					</div>
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="lunchintime">LunchInTime</label>
						<input type="text" id="lunchintime" name="lunchintime" class="form-control">
					</div>
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="duration">Duration</label>
						<input type="text" id="duration" name="duration" class="form-control">
					</div>
                     
                     <div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="daycrossed">DayCrossed</label>
						<input type="text" id="daycrossed" name="daycrossed" class="form-control">
					</div>
                     
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">Status</label>
						<input type = "text"  id="isactive" name="isactive" class="form-control">
					
					</div>
					<div align="center">
					<button type="button"id="submitshifts" class="btn btn-primary" >
						Submit
					</button> 
					</div>
				</div>	
				
				</form>
			</div>
		</div>
	</div>
</div>

<!-- ***************************** Shifts save  model box ************************** -->

<div class="modal fade" id="myshift" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			<div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" >Adding New Shift </h4>
		   </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div align="center">
			<div class="alert alert-success " id="shiftsavesuccess" style="text-align:center">
  	           <strong id="shiftStrong" ></strong> 
	            </div>
	            </div>
     <form id="saveshiftvalidation">
			<h3 align="center" style="color: green" id="jobtypedisplaymsg"></h3>

			<div class="modal-body">
				<div class="box-content row">
					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">Name</label> <input
							type="text" id="Name" name="Name"  class="form-control">
					</div>

					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">StartTime</label>
						<input type="text" id="Starttime" name="Starttime"  class="form-control">
					</div>
					
					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">EndTime</label> <input
							type="text" id="Endtime" name="Endtime"  class="form-control">
					</div>

					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">GraceTime</label>
						<input type="text" id="Gracetime" name="Gracetime"  class="form-control">
					</div>
					
					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">LunchOutTime</label> <input
							type="text" id="Lunchouttime" name="Lunchouttime"  class="form-control">
					</div>

					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">LunchInTime</label>
						<input type="text" id="Lunchintime" name="Lunchintime"  class="form-control">
					</div>
					
					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">Duration</label> <input
							type="text" id="Duration" name="Duration"  class="form-control">
					</div>

					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">DayCrossed</label>
						<input type="text" id="Daycrossed" name="Daycrossed"  class="form-control">
					</div>
				</div>
                 
			</div>
			
			<div class="modal-footer">
			<div class="container" align="center">
				<button type="button" class="btn btn-default"  id="submitsaveshifts">Submit</button>
			</div>
			</div>
			</form>
		</div>
	</div>
	</div>
    <script src="resources/dist/js/sidebarmenu.js"></script>
    <script src="resources/validation/bootstrapValidator.min.js"></script>
  <%@include file="footer.jsp"%>
<script>
 $('#editshiftvalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
             name: {
                     validators: {
                         notEmpty: {
                             message: 'Name required ',
                          },
                        }
                  },
			 
			 starttime: {
                     validators: {
                         notEmpty: {
                             message: 'StartTime required ',
                          },
                        }
                  },
                  endtime: {
                      validators: {
                          notEmpty: {
                              message: 'EndTime required ',
                           },
                         }
                   },
                   gracetime: {
                       validators: {
                           notEmpty: {
                               message: 'GraceTime required ',
                            },
                          }
                    },
                    lunchouttime: {
                        validators: {
                            notEmpty: {
                                message: 'LunchOutTime required ',
                             },
                           }
                     },
                     lunchintime: {
                         validators: {
                             notEmpty: {
                                 message: 'LunchInTime required ',
                              },
                            }
                      },
                      duration: {
                          validators: {
                              notEmpty: {
                                  message: 'Duration required ',
                               },
                             }
                       },
                       daycrossed: {
                           validators: {
                               notEmpty: {
                                   message: 'DayCrossed required ',
                                },
                              }
                        },
                  isactive: {
                      validators: {
                          notEmpty: {
                              message: 'IsActive required ',
                           },
                         }
                   }

             }

         });

$("#submitshifts").on("click", function(){
$('#editshiftvalidation').data('bootstrapValidator').validate();
if($('#editshiftvalidation').data('bootstrapValidator').isValid()){
	editshifts();
}
});
</script>
 
 
 <script>
 $('#saveshiftvalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
             Name: {
                     validators: {
                         notEmpty: {
                             message: 'Name required ',
                          },
                        }
                  },
			 
			 Starttime: {
                     validators: {
                         notEmpty: {
                             message: 'StartTime required ',
                          },
                        }
                  },
                  Endtime: {
                      validators: {
                          notEmpty: {
                              message: 'EndTime required ',
                           },
                         }
                   },
                   Gracetime: {
                       validators: {
                           notEmpty: {
                               message: 'GraceTime required ',
                            },
                          }
                    },
                    Lunchouttime: {
                        validators: {
                            notEmpty: {
                                message: 'LaunchOutTime required ',
                             },
                           }
                     },
                     Lunchintime: {
                         validators: {
                             notEmpty: {
                                 message: 'LaunchInTime required ',
                              },
                            }
                      },
                      Duration: {
                          validators: {
                              notEmpty: {
                                  message: 'Duration required ',
                               },
                             }
                       },
                       Daycrossed: {
                           validators: {
                               notEmpty: {
                                   message: 'DayCrossed required ',
                                },
                              }
                        }
                 

             }

         });

$("#submitsaveshifts").on("click", function(){
$('#saveshiftvalidation').data('bootstrapValidator').validate();
if($('#saveshiftvalidation').data('bootstrapValidator').isValid()){
	saveshifts();
}
});
</script>
 
	
	
