<%@include file="header.jsp"%>
<script type="text/javascript" src="resources/customjs/leave.js"></script>
      <link rel="stylesheet" type="text/css"
	href="resources/validation/validation.css">
<script>
function cal(){
	 var fromdate = document.getElementById("fromdate").value;
    var todate = document.getElementById("todate").value;
    var fhalfday=document.getElementById("fhalfday").value;
    var thalfday=document.getElementById("thalfday").value;
    var idno=document.getElementById("idNumber").value;
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "countingLeaves?fromdate="+fromdate+"&&todate="+todate+"&&fhalfday="+fhalfday+"&&thalfday="+thalfday+"&&idno="+idno, 		//this is my servlet

       success: function(data){  
       	/*if($("#noofdays").val(data) > clval){
       		
       	}*/
       	 $("#noofdays").val(data);

       }
 });
	}
$("#fromdate").on("changeDate",function (){ 
	 var fromdate = document.getElementById("fromdate").value;
	    var todate = document.getElementById("todate").value;
	    var fhalfday=document.getElementById("fhalfday").value;
	    var thalfday=document.getElementById("thalfday").value;
	    var idno=document.getElementById("idNumber").value;
		$.ajax({
	       type: "GET",
	       contentType : "application/json",
	       url: "countingLeaves?fromdate="+fromdate+"&&todate="+todate+"&&fhalfday="+fhalfday+"&&thalfday="+thalfday+"&&idno="+idno, 		//this is my servlet

	       success: function(data){  
	       	/*if($("#noofdays").val(data) > clval){
	       		
	       	}*/
	       	 $("#noofdays").val(data);

	       }
	 });
});

$("#todate").on("changeDate",function (){ 
	 var fromdate = document.getElementById("fromdate").value;
	    var todate = document.getElementById("todate").value;
	    var fhalfday=document.getElementById("fhalfday").value;
	    var thalfday=document.getElementById("thalfday").value;
	    var idno=document.getElementById("idNumber").value;
		$.ajax({
	       type: "GET",
	       contentType : "application/json",
	       url: "countingLeaves?fromdate="+fromdate+"&&todate="+todate+"&&fhalfday="+fhalfday+"&&thalfday="+thalfday+"&&idno="+idno, 		//this is my servlet

	       success: function(data){  
	       	/*if($("#noofdays").val(data) > clval){
	       		
	       	}*/
	       	 $("#noofdays").val(data);

	       }
	 });
});



$(document).ready(function(){
	 
	    $("#warnings").hide();
	    $("#success").hide();
	    
	 
	});
 $(document).ready(function() {
 var today = new Date();
 var dd = String(today.getDate()).padStart(2, '0');
 var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
 var yyyy = today.getFullYear();

 var today = yyyy + '-' + mm + '-' + dd;

 $("#fromdate").val(today);
 $("#todate").val(today);
 
 ////alert(today);
 
 });
 
 function calculationForLeaves(){
 var calNoOfDays=$("#noofdays").val();
	var calcltype=$("#cl").val();
	var calsltype=$("#sl").val();
	var caleltype=$("#el").val();
	var calcotype=$("#co").val();
	var calleavetype=$("#sel").val();
	if(calleavetype=="1"){
		//alert(parseFloat(calNoOfDays)+""+parseFloat(calcltype));
		if(parseFloat(calNoOfDays) >  parseFloat(calcltype)){
			$("#msg").html("Warning! You don't Have enough CL's Please Check AboveTable");
			 $("#warnings").show();
			 return false;
		}
		else{
			saveleave();
		}
	}
	if(calleavetype=="2"){
		if(parseFloat(calNoOfDays) > parseFloat(calsltype)){
			$("#msg").html("Warning! You don't Have enough SL's Please Check AboveTable");
			 $("#warnings").show();
			 return false;
		}
		else{
			saveleave();
		}
	}
	if(calleavetype=="3"){
		if(parseFloat(calNoOfDays)>parseFloat(caleltype)){
			$("#msg").html("Warning! You don't Have enough EL's Please Check AboveTable");
			 $("#warnings").show();		
			 return false;
		}
		else{
			saveleave();
		}
	}
	if(calleavetype=="4"){
		if(parseFloat(calNoOfDays)>parseFloat(calcotype)){
			// $("#msg").val("Warning! You don't Have enough CompOffs Please Check AboveTable");
			 $("#msg").html("Warning! You don't Have enough CompOffs Please Check AboveTable");
			 $("#warnings").show();
			 return false;
		}
		else{
			saveleave();
		}
	}
 	
 }
 
 

 
 
 $(document).ready(function() {
		var idNumber=document.getElementById("idNumber").value;
		$.ajax({
			url : "/HRMS/getLeavedebits?idno="+idNumber,
			success : function(data, textStatus, jqXHR) {
				var table_data = data.dataBean;
				var table = $('#leavedebits').DataTable(
								{
									"destroy" : true,
									data : table_data,
									//dataSrc:data,
									//"dataSrc" : "data",
									columns : [
										{ data: "sno"},
							            {data: "transid"},
							           	{ data: "createdon"},
						 				{ data: "leavetype"},
						 				{ data: "fromdate"},
								 		{ data: "todate"},
										{ data: "noofdays"},
										{ data: "reasonforleave"},
										{ data: "docstatus"},
										{
							                data: null,
							                className: "center",
							                defaultContent: '<div id ="editLeave"><input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25"  id ="fetchToleave"  onclick = "OpenEditLeaveRecd()">   <input type="image" src="resources/assets/images/delete.png" id="deleteleave" height="25" width="25"  onclick="forleavedeletion()"></div>'
							            }	
											],
								//  searching : false
								});
				table.destroy();
				var oTable = $('#leavedebits').DataTable({
					"pageLength": 50,
					rowCallback: function(row, data, index){
					if(data[8] == "AU"){
							$(row).find('td:eq(3)').css('background-color', '#73f777');
					    	$(row).find('td:eq(6)').css('background-color', '#73f777');
					    	$(row).find('td:eq(8)').css('background-color', '#73f777');
					}
				  	if(data[8]== "RJ"){
				  		$(row).find('td:eq(3)').css('background-color', '#ff2929');
				    	$(row).find('td:eq(6)').css('background-color', '#ff2929');
				    	$(row).find('td:eq(8)').css('background-color', '#ff2929');
				    }
				    
				  }
				});
			}
		});

	} );
 </script>


<input type="text" value="${idno}" id="tranid" hidden="hidden" >	
<!-- noof days caluculation between fom date and todate -->
<body>

	<%-- <%
		int idNumber = Integer.parseInt(request.getParameter("idno"));
	%>
 --%>
 <%int idNumber = Integer.parseInt(request.getParameter("idno")); %>
 
	<div>

		<br>
		<h3 align="center" style="color: blue">Leaves</h3>

		<br>
		<div class="box-content row">

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">IdNo</label> <input
					type="text" name="" id="idNumber"
					value="<%=idNumber%>" class="form-control"
					readonly="readonly">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Code</label> <input
					type="text" id="empno" name="" class="form-control"
					readonly="readonly">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Name</label> <input
					type="text" name="" id="empname" class="form-control"
					readonly="readonly">

			</div>



			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">
					Designation</label> <input type="text" name="desg" id="desgn"
					class="form-control" readonly="readonly">

			</div>

			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1">Department</label>
				<input type="text" id="name" class="form-control"
					readonly="readonly">

			</div>


		</div>

	</div>
	<hr color="blue">
	<div>
		<br>
		<h3 align="left" style="color: blue">Leave Balances</h3>
		<div class="box-content row">
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1"><b
					id="lType"></b></label> <input type="text" id="cl" class="form-control"
					readonly="readonly">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1"><b
					id="lType1"></b></label> <input type="text" id="sl" class="form-control"
					readonly="readonly">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1"><b
					id="lType2"></b></label> <input type="text" id="el" class="form-control"
					readonly="readonly">

			</div>
			<div class="form-group has-warning col-md-3">
				<label class="control-label" for="inputWarning1"><b
					id="lType3"></b></label> <input type="text" id="co" class="form-control"
					readonly="readonly">

			</div>
</div>
		<br>
	</div>
	<hr color="blue">
	<div>
		<table id="leavedebits" class="display" style="width: 100%" border="1">
			<thead>
				<tr>

					<th>sno</th>
					<th>TransId</th>
					<th>Date</th>
					<th>Type</th>
					<th>FromDate</th>
					<th>ToDate</th>
					<th>Days</th>
					<th>Reason</th>
					<th>Status</th>
					<th>Action</th>

				</tr>
			</thead>
		</table>
		<div id="displayDiv">
			<h3 id="processedData" align="center" style="color: red"></h3>
		</div>
	</div>
	<hr color="blue">
	<div class="container-fluid">
	<div class="alert alert-warning" id="warnings" style="text-align:center">
  	<strong id="msg" ></strong> 
	</div>
	<div class="alert alert-success " id="success" style="text-align:center">
  	<strong id="successmsg" >SUCCESS! Your Leave Added Sucessfully Please Wait for Reload Page </strong> 
	</div>
	
		<div class="row">
			<div class="col-md-4" >
			</div>

			<div class="col-md-8"  id="addLeave">
			

				<form id="leaves_add" >
					<h3  style="color: blue">Add Leave</h3>
					<br>

					<div class="box-content row">
						<div class="form-group has-warning col-md-4" >
							<label class="control-label">Leave Type</label> 
							<select id="sel" class="form-control" name="sel">
								<option value="">LeaveType</option>
							</select>
						</div>
					</div>
					<div class="box-content row">
						<div class="form-group has-warning col-md-4" >
							<label class="control-label" for="inputWarning1">From
								Date</label> <input type="text" id="fromdate" name="fromdate"
								onchange="cal()" class="form-control" placeholder="YYYY-MM-DD">

						</div>
						<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">
								Half-Day</label>  
						<select id="fhalfday" onchange="cal()"class="form-control">
						<option value="0">select</option>
						<option value="1">Second-Half</option>
							</select>

						</div>
					</div>
					<div class="box-content row">

						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">To Date</label>
							<input type="text" id="todate" name="todate" onchange="cal()"
								class="form-control" placeholder="YYYY-MM-DD">

						</div>
						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">
								Half-Day</label> <br> <select id="thalfday" onchange="cal()"
								class="form-control">
								<option value="0">select</option>
								<option value="1">First-Half</option>

							</select>

						</div>


					</div>
					<div class="box-content row">

						<div class="form-group has-warning col-md-4">
							<label class="control-label" for="inputWarning1">No Of
								Days</label> 
						<input type="text" id="noofdays" readonly="readonly" class="form-control" style="color:red;font-size: large">



						</div>
					</div>
					<div class="box-content row">

						<div class="form-group has-warning col-md-8">
			<label class="control-label" for="inputWarning1">Reason</label>
			<textarea rows="4" cols="10" id="reasonforleave"
				name="reasonforleave" class="form-control">
			</textarea>

		</div>
						
					</div>
					<br>
					<div>
						<input type="button" id="leave_btn" class="btn btn-success" value="submit" >
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>
		</div>
	</div>
	
	
</body>

	<script src="resources/dist/js/sidebarmenu.js"></script>
	<%@include file="footer.jsp" %>
	 <script src="resources/validation/bootstrapValidator.min.js"></script>
	
	
	<script>
		$('#leaves_add').bootstrapValidator({
			//container: '#messages',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				sel : {
					validators : {
						notEmpty : {
							message : 'select leavetype ',
						}
					}
				},
				fromdate: {
					validators : {
						notEmpty : {
							message : 'select fromdate ',
						}
					}
				},
				todate: {
					validators : {
						notEmpty : {
							message : 'select Todate ',
						}
					}
				},
				fhalfday: {
					validators : {
						notEmpty : {
							message : 'select firsthalf ',
						}
					}
				},
				thalfday: {
					validators : {
						notEmpty : {
							message : 'select secondhalf ',
						}
					}
				},
				noofdays: {
					validators : {
						notEmpty : {
							message : 'no of days required ',
						}
					}
				},
				reasonforleave: {
					validators : {
						notEmpty : {
							message : 'Reason Required ',
						}
					}
				}
			}

		});
		$("#leave_btn").click(function() {

			$('#leaves_add').data('bootstrapValidator').validate();
			if ($('#leaves_add').data('bootstrapValidator').isValid()) {
				//editempinfo();
				calculationForLeaves();
			}

		});
		jQuery('#fromdate').datepicker({
		    autoclose: true,
		    todayHighlight: true
		});
		jQuery('#todate').datepicker({
		    autoclose: true,
		    todayHighlight: true
		});
	</script>