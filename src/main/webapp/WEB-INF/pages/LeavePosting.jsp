<%-- <%@include file="header.jsp" %>
  <script type="text/javascript" src="resources/customjs/leave.js"></script>  
 <script>
 $(document).ready(function() {
	    $('#leaveposting').DataTable();
	} );
 </script>
 
 <script>
 $(document).ready(function() {
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "getallproject", 
			
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
	 
 </script> 
<style>
th
{
	background-color:green;
	color:white;
	}
	</style>
 

<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
			<h3 align="center" style="color: #fb8c00">Leaves Listing Page</h3>
            </div>
            
            
			<div class="box-content row">

				<div class="form-group has-warning col-md-3">
					<label style="color: Blue" class="control-label" for="inputWarning1">Division
						</label> <select class="form-control" id="division" name="division " >
						<option value="">select</option>
					</select>
				</div>
				


				<div class="form-group has-warning col-md-3">
					<label  style="color: Blue"  class="control-label" for="inputWarning1">Project</label><br>
					<select class="form-control" id="project" name="project">
						<option value="">select</option>

					</select>
				</div>				
			</div>
			<div align="center">
			       <input type="submit"  value="Show" onclick="onChangeLeavePosting()" style="background-color: blue;color:white"	class="btn btn-primary"   >
		      </div>
		</div>
	</div>
</div>
<table id="leaveposting" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		 <th>SNo</th>
                <th>IdNO</th>
                <th>Code</th>
                <th>Name</th>
                <th>Desg</th>
                <th>Dept</th>
              	<th>Action</th>
                
            </tr>
        </thead>
       
    </table>
    
    
     <!-- Modal -->
     <div id="a"></div>

<!--   Leave Credits Modal box  Starting-->
<div class="modal fade" id="leavecreditModal" role="dialog">
   
	<div class="modal-dialog modal-lg">

		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5" align="center">Leave Credits</h4>
				<button type="button" class="close" data-dismiss="modal" onClick="$.leavecreditModal.close();">&times;</button>			
			</div>
			<h3 id="DisplayMessage" align="center" style="color:green"></h3>
			<form id="lc_form">
				<div class="modal-body">
					<div class="box-content row">
						<div class="form-group has-warning col-md-3">
                                                    <label class="control-label" for="inputWarning1">IdNo</label> 
                                                    <input type="text" name="" id="idNumber" class="form-control" readonly="readonly">
                                                </div>
                                        </div>
					<div class="box-content row">                                    
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">CL</label>
						        <input type="text" id="cl" name="cl" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">SL</label>
						        <input type="text" id="sl" name="sl" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">EL</label>
						        <input type="text" id="el" name="el" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Remarks</label>
						        <input type="text" id="remarks" name="remarks" class="form-control">
						</div>

					</div>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="lc_btn">Submit</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--   Leave Credits Modal box  end -->
     
<!--   Leave Process Flow Update Modal box  Starting-->
<div class="modal fade" id="approvalleaveModal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5" align="center">Leave Approval Process Flow</h4>
				<button type="button" class="close" data-dismiss="modal" >&times;</button>			
			</div>
			<h3 id="DisplayMessage" align="center" style="color:green"></h3>
			
			<form id="lp_form">
				<div class="modal-body">
					<div class="box-content row">
		                	<div class="form-group">
				         <label class="control-label" for="inputWarning1">IdNo</label> <input
					type="text" name="" id="idNumber1"
					 class="form-control"
					readonly="readonly">

			               </div>
                                        </div>    
					<div class="box-content row">                                            
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Level-1</label>
						        <input type="text" id="level1" name="level1" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Level-2</label>
						        <input type="text" id="level2" name="level2" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Level-3</label>
						        <input type="text" id="level3" name="level3" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Level-4</label>
						        <input type="text" id="level4" name="level4" class="form-control">
						</div>
                                        </div>    

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="lp_btn">Submit</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--   Leave Credits Modal box  end -->
     
	<script>
//		$('#lc_form').bootstrapValidator({
//			//container: '#messages',
//			feedbackIcons : {
//				valid : 'glyphicon glyphicon-ok',
//				invalid : 'glyphicon glyphicon-remove',
//				validating : 'glyphicon glyphicon-refresh'
//			},
//			fields : {
//				employeename : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
//				comp_address : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
//				workperiod : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
//				experiencedetails : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
//				c_design : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
//				c_ctc : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
////				c_remarks : {
////					validators : {
////						notEmpty : {
////							message : 'Field is required ',
////
////						}
////					}
////				},
//
//			}
//
//		});

		$("#lc_btn").on("click", function() {
				saveLeaveCredit();
		});

		$("#lp_btn").on("click", function() {                    
				saveLeaveProcess();
		});
        
        
        
        </script>
     
     
     
<script src="resources/dist/js/sidebarmenu.js"></script>
  
<%@include file="footer.jsp"%> --%>
<%@include file="header.jsp" %>
  <script type="text/javascript" src="resources/customjs/leave.js"></script>  
 <script>
 $(document).ready(function() {
	    $('#leaveposting').DataTable();
	} );
 </script>
 <script>
$(document).ready(function(){
	   // $("#warnings").hide();
	    $("#DisplayMessage1").hide();
	    $("#LeaveApprovesuccess").hide();
	   
	});
</script>
 <script>
 $(document).ready(function() {
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "getallproject", 
			
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
	 
 </script> 
<style>
th
{
	background-color:green;
	color:white;
	}
	</style>
 

<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
			<h3 align="center" style="color: #fb8c00">Leaves Listing Page</h3>
            </div>
            
            
			<div class="box-content row">

				<div class="form-group has-warning col-md-3">
					<label style="color: Blue" class="control-label" for="inputWarning1">Division
						</label> <select class="form-control" id="division" name="division " >
						<option value="">select</option>
					</select>
				</div>
				


				<div class="form-group has-warning col-md-3">
					<label  style="color: Blue"  class="control-label" for="inputWarning1">Project</label><br>
					<select class="form-control" id="project" name="project">
						<option value="">select</option>

					</select>
				</div>				
			</div>
			<div align="center">
			       <input type="submit"  value="Show" onclick="onChangeLeavePosting()" style="background-color: blue;color:white"	class="btn btn-primary"   >
		      </div>
		</div>
	</div>
</div>
<table id="leaveposting" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		 <th>SNo</th>
                <th>IdNO</th>
                <th>Code</th>
                <th>Name</th>
                <th>Desg</th>
                <th>Dept</th>
              	<th>Action</th>
                
            </tr>
        </thead>
       
    </table>
    
    
     <!-- Modal -->
     <div id="a"></div>

<!--   Leave Credits Modal box  Starting-->
<div class="modal fade" id="leavecreditModal" role="dialog">
   
	<div class="modal-dialog modal-lg">

		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5" align="center">Leave Credits</h4>
				<button type="button" class="close" data-dismiss="modal" >&times;</button>			
			</div>
			<h3 id="DisplayMessage" align="center" style="color:green"></h3>
			<form id="lc_form">
				<div class="modal-body">
					<div class="box-content row">
						<div class="form-group has-warning col-md-3">
                                                    <label class="control-label" for="inputWarning1">IdNo</label> 
                                                    <input type="text" name="" id="idNumber" class="form-control" readonly="readonly">
                                                </div>
                                        </div>
         <div>                              
         <table id="leavecredits" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		 <th>Date</th>
                <th>Type</th>
                <th>NoofDays</th>
                <th>Remarks</th>
                
            </tr>
        </thead>
       
    </table>
    </div>
    
					<div class="box-content row">                                    
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">CL</label>
						        <input type="text" id="cl" name="cl" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">SL</label>
						        <input type="text" id="sl" name="sl" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">EL</label>
						        <input type="text" id="el" name="el" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Remarks</label>
						        <input type="text" id="remarks" name="remarks" class="form-control">
						</div>

					</div>

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="lc_btn">Submit</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--   Leave Credits Modal box  end -->
     
<!--   Leave Process Flow Update Modal box  Starting-->
<div class="modal fade" id="approvalleaveModal" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
			<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5" align="center">Leave Approval Process Flow</h4>
				<button type="button" class="close" data-dismiss="modal" >&times;</button>			
			</div>
			<div class="alert alert-success " id="LeaveApprovesuccess" style="text-align:center">
  		<strong id="LeaveApproveStrong" ></strong> 
		</div>
			<form id="lp_form">
				<div class="modal-body">
					<div class="box-content row">
		                	<div class="form-group">
				         <label class="control-label" for="inputWarning1">IdNo</label> <input
					type="text" name="" id="idNumber1"
					 class="form-control"
					readonly="readonly">

			               </div>
			               
			            
                                        </div>    
					<div class="box-content row">                                            
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Level-1</label>
						        <input type="text" id="level1" name="level1" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Level-2</label>
						        <input type="text" id="level2" name="level2" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Level-3</label>
						        <input type="text" id="level3" name="level3" class="form-control">
						</div>
						<div class="form-group has-warning col-md-3">
							<label class="control-label" for="inputWarning1">Level-4</label>
						        <input type="text" id="level4" name="level4" class="form-control">
						</div>
                                        </div>    

				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="lp_btn">Submit</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--   Leave Credits Modal box  end -->
     
	<script>
//		$('#lc_form').bootstrapValidator({
//			//container: '#messages',
//			feedbackIcons : {
//				valid : 'glyphicon glyphicon-ok',
//				invalid : 'glyphicon glyphicon-remove',
//				validating : 'glyphicon glyphicon-refresh'
//			},
//			fields : {
//				employeename : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
//				comp_address : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
//				workperiod : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
//				experiencedetails : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
//				c_design : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
//				c_ctc : {
//					validators : {
//						notEmpty : {
//							message : 'Field is required ',
//
//						}
//					}
//				},
////				c_remarks : {
////					validators : {
////						notEmpty : {
////							message : 'Field is required ',
////
////						}
////					}
////				},
//
//			}
//
//		});

		$("#lc_btn").on("click", function() {
				saveLeaveCredit();
		});

		$("#lp_btn").on("click", function() {                    
				saveLeaveProcess();
		});
        
        
        
        </script>
     
     
     
<script src="resources/dist/js/sidebarmenu.js"></script>
  
<%@include file="footer.jsp"%>