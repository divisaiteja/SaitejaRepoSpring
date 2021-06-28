
<%@ include file="header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="resources/validation/validation.css">
<script src="resources/validation/bootstrapValidator.min.js"></script>
<!-- <link rel="stylesheet" href="resources/css/rowReorder.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="resources/css/font-awesome.min.css"> -->


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
 .modal .modal-body {
    max-height: 500px;
    overflow-y: auto;
  }
 </style>
</head>
<body>
	<%
		HttpSession session2 = request.getSession();
		String username = (String) session2.getAttribute("username");
		
	%>
	<%
		if (username != null) {
	%>
	<input type="text" id=username value="<%=username%>" hidden="hidden">
	
	<script>
		$(document).ready(function() {
			$("#remidiation").hide();
			$("#proofsreq").hide();
			$("#buttonhide").hide();
			$("#approver").hide();
			$("#rejectsuccess").hide();
			$("#approversuccess").hide();
			
		});
		
		function getComplianceTrasactionBasedTranid(tranid) {
			//alert("getRemidiationBasedTranid  "+transactiontranid)
			transactiontranid = tranid;
			$.ajax({
						type : "GET",
						contentType : "application/json",
						url : "getComplianceTrasactionBasedTranid?transactiontranid="+ transactiontranid, // this is my servlet
						success : function(data) {
							document.getElementById("submitteddate").value = data[0]["submitteddate"]
							document.getElementById("transactionremarks").value = data[0]["transactionremarks"]
							document.getElementById("compliedstatus").value = data[0]["complied"]
						    var status=document.getElementById("comp").value = data[0]["complied"]
							CompliedStatus(status);							
						}
					});
		}
	
		function CompliedStatus(status) {
			 ckeckstatus=status;
			 var username = document.getElementById("username").value;
			//alert("status    "+ckeckstatus);
			if(ckeckstatus=='yes' && username!='admin'){
				//alert(">>>>>>>>yes>>>>>>>");
				$("#showtransactionremarks").show();
				//$("#showowner").show();
				$("#showremidiationdescription").hide();
				$("#showalertdate").hide();
			}else if(ckeckstatus=='no'&&username!='admin'){
				$("#showtransactionremarks").hide();
				//$("#showowner").hide();
				$("#showremidiationdescription").show();
				$("#showalertdate").show();
				//alert(">>>>>>>>no>>>>>>>");
			}
		}
		function approvelTransaction(tranid) {
			var username = document.getElementById("username").value;
			var transactiontranid = tranid;
			//alert(transactiontranid);
			if (username == 'admin') {
				//alert(">>if>>" + username)
				$("#approvershow").show();
				$("#showowner").hide();
				$("#showinitiateddate").show();
				$("#showduedate").hide();
				$("#showsubmitteddate").hide();
			} else {
				//alert(" else username " + username)
				$("#approvershow").hide();
				$("#approver").show();
				$("#Rejectedmodel").hide();
				$("#Approvermodel").hide();
				$("#showowner").show();
				$("#showinitiateddate").hide();
				$("#showduedate").show();
				$("#showsubmitteddate").show();
			}

		}
		
	</script>
	<script>
		function getTransactionid(tranid) {
			var transactiontranid = tranid;
			//alert(">>>>>>>>>>"+transactiontranid)
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getFilenamesBasedOnTransactionid?transactiontranid="
						+ transactiontranid, // this is my servlet
				success : function(data) {
					var abc = data;
					var ele = document.getElementById('Filenames');
					for (var i = 0; i < abc.length; i++) {
						// POPULATE SELECT ELEMENT WITH JSON.
						ele.innerHTML = ele.innerHTML+ '<option value="'+ abc[i]["filename"] + '">'+ abc[i]["filename"] + '</option>';

					}

				}
			});
		}
		var transactiontranid;
		function getRemidiationBasedTranid(tranid) {
			transactiontranid = tranid;
			//alert("getRemidiationBasedTranid  "+transactiontranid)
			$.ajax({
						type : "GET",
						contentType : "application/json",
						url : "getRemidiationBasedTranid?transactiontranid="+ transactiontranid, // this is my servlet
						success : function(data) {
							if(data!=null){
								document.getElementById("remidiationdescription").value = data[0]["remidiationdescription"]
								document.getElementById("getalertdate").value = data[0]["alertdate"]
								
							}
							
						}
					});
		}
		
	function Approved() {
		//alert("Approved "+transactiontranid)
		var approvertext = document.getElementById("approvertext").value;
		 var tranid=transactiontranid;
		//alert("transactiontranid "+tranid)
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "approverStatus?transactiontranid="+ transactiontranid+"&approvertext="+approvertext, // this is my servlet
			success : function(data) {
				$("#approverstrong").html(data["successMessage"]);
				$("#approversuccess").show();	
					setInterval(function(){
					window.location.reload(); // this will run after every 5 seconds
					 }, 2000);
                    }
		}); 
		
	}
	function Rejectmodelbox() {
		$('#Rejectedmodel').modal('show');
	}
	function Approvedmodelbox() {
		$('#Approvermodel').modal('show');
	}
	
	function Rejectreset() {
		//alert("Rejectreset");
		 $("#Rejectedvalidation").trigger("reset");
			$("#Rejectedvalidation").data('bootstrapValidator').resetForm();
	}
	
	function Approverreset() {
		//alert("Approverreset");
		 $("#Approvervalidation").trigger("reset");
			$("#Approvervalidation").data('bootstrapValidator').resetForm();
	}
	function Sendback() {
		var rejectedtext = document.getElementById("rejectedtext").value;
		 //alert("rejectedtext  "+rejectedtext);
		var transactranid=transactiontranid;
		// alert("transactiontranid  "+transactranid);
		 $.ajax({
				type : "POST",
				contentType : "application/json",
				url : "rejectedStatus?transactranid="+ transactranid+"&rejectedtext="+rejectedtext, // this is my servlet
				success : function(data) {
					$("#rejectstrong").html(data["successMessage"]);
					$("#rejectsuccess").show();	
						setInterval(function(){
						window.location.reload(); // this will run after every 5 seconds
						 }, 2000);
	                    }
			});  
	}
	</script>
	<script>
		function Remidiation() {
			var complied = document.getElementById("complied").value;
			var proofsrequiredstatus = document
					.getElementById("proofsrequiredstatus").value;
			var transactionimage = document.getElementById("transactionimage").value;
			//alert("proofsrequiredstatus     " +proofsrequiredstatus);
			if (complied == 'no') {
				$("#remidiation").show();
				$("#buttonhide").hide();
			} else {
				$("#remidiation").hide();
			}

			if ((complied == 'yes' && proofsrequiredstatus == 'No')
					|| (transactionimage != null && transactionimage != "" && complied != "")) {
				$("#buttonhide").show();
			} else {
				$("#buttonhide").hide();
			}

		}
		function proofs() {
			var proofsrequiredstatus = document
					.getElementById("proofsrequiredstatus").value;
			if (proofsrequiredstatus == 'Yes') {
				$("#proofsreq").show();
			} else {
				$("#proofsreq").hide();
			}
		}

		function criticalstatus() {
			var iscriticalstatus = document.getElementById("iscriticalstatus").value;
			//	alert("iscriticalstatus  "+iscriticalstatus);
			if (iscriticalstatus == 'Yes') {
				$("#titleyes").show();
				$("#titleno").hide();
			} else {
				$("#titleyes").hide();
				$("#titleno").show();
			}
		}
		function upload() {
			$("#transaction").on('click','#fileupload',function() {
						var currentRow = $(this).closest("tr");
						var rowData = $("#transaction").DataTable().row(currentRow).data();
						var tranid = rowData.tranid;
						window.location.href = "#/Filesupload/" + tranid
					});

		}
		function reset() {
			 // alert("reset");
			$("#transactionform").trigger("reset");
			$("#transactionform").data('bootstrapValidator').resetForm();  
			    $('#Filenames').empty(); 
			    var newOption = $('<option value="1"></option>');
			    $('#Filenames').append(newOption);
			disableBack();
		}
		 function disableBack() { 
			window.history.forward() 
			}
        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() } 
	</script>

	<script>
		$("#transaction").on('click','#transactionEditing',function() {
							var currentRow = $(this).closest("tr");
							var rowData = $("#transaction").DataTable().row(currentRow).data();
							var tranid = rowData.tranid;
							getComplianceTrasactionBasedTranid(tranid);
							getTransactionid(tranid);
							getRemidiationBasedTranid(tranid);
							approvelTransaction(tranid);
							retrieve:true,
									$.ajax({
										contentType : "application/json",
												"url" : "transcationBasedOnTranid?tranid="+ tranid,
												"dataSrc" : "dataBean",
												"type" : "GET",
												success : function(data) {
													for (var i = 0; i < data.length; i++) {
														$("#tranid").val(data[i].tranid);
														$("#title").val(data[i].title);
														$("#titno").val(data[i].title);
														$("#description").val(data[i].description);
														$("#clauseact").val(data[i].clauseact);
														$("#legaslativedescription").val(data[i].legislativeMasterDTO.legaslativedescription);
														$("#compliancetype").val(data[i].compliancetype);
														$("#frequencydescription").val(data[i].frequencymasterDTO.frequencydescription);
														$("#iscriticalstatus").val(data[i].iscriticalstatus);
														$("#initiateddate").val(data[i].initiateddate);
														$("#Duedate").val(data[i].duedate);
														$("#proofsrequiredstatus").val(data[i].proofsrequiredstatus);
														$("#docstatus").val(data[i].docstatus);
														$("#ownername").val(data[i].ownername);
													}
													selectedRecord = data;
													proofs();
													criticalstatus();

												},
											});
							$('#transactionmodal').modal({
								backdrop : 'static',
								keyboard : false
							}, 'show');

						});
	</script>

	<script>
		$(document).ready(function() {
							var dataTable;
							dataTable = $('#transaction').DataTable(	{
												"scrollX" : true,
												"scrollY" : "200px",
												"paging" : true,
												"bSort" : true,
												"ajax" : {
													"url" : "getAllTransaction",
													"dataSrc" : "dataBean",
													"type" : "GET",
												},
												"columns" : [
														{data : "tranid"},
														{data : "complianceid"},
														{data : "title"},
														{data : "description"},
														{data : "clauseact"},
														{data : "legislativeid"},
														{data : "penality"},
														{data : "compliancetype"},
														{data : "frequencyid"},
														{data : "iscriticalstatus"},
														{data : "duedate"},
														{data : "proofsrequiredstatus"},
														{data : "alertdays"},
														{data : "statusCodeForActive"},
														{
															data : null,
															className : "center",
															defaultContent : '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="transactionEditing"  >   '
																	+ '<input type="image" src="resources/assets/images/upload.png" height="25" width="30" id="fileupload"  onclick="upload()" >   '
														} ],
											});
						});
	</script>
	<h3 align="center">Transaction</h3>
	<br>
	<br>
	<table id="transaction" class="display" style="width: 100%" border="1">
		<thead>
			<tr>
				<th>TranId</th>
				<th>ComplianceId</th>
				<th>Title</th>
				<th>Description</th>
				<th>Clause</th>
				<th>Legislative</th>
				<th>Penalty</th>
				<th>Compliance</th>
				<th>Frequency</th>
				<th>IsCritical</th>
				<th>DueDate</th>
				<th>ProffRequired</th>
				<th>AlertDay</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
	</table>
	<!-- ************************************* Transaction Model Box *************************************-->
 <div class="form-group has-warning col-sm-3"  hidden="hidden">
											<label class="control-label" for="inputWarning1">Complied
											</label> <input type="text" id="comp" name="comp"
												readonly="readonly" class="form-control ">
									
                                           </div>

	<div class="modal fade" id="transactionmodal" role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<div class="container">
						<h4 align="center" style="color: #0B1907" class="modal-title">Compliance
							Transaction</h4>
					</div>
					<button type="button" class="close" data-dismiss="modal"
						onclick="reset()">&times;</button>
				</div>
				<h5 align="center" id="successmessage" style="color: blue"></h5>
				<form id="transactionform">
					<div class="modal-body">
						<div class="modal-body mx-3">
							<div class="box-content row">
								<div class="form-group has-warning col-md-3" id="titleyes">
									<label class="control-label" for="inputWarning1">Title*</label>
									<input type="text" id="title" name="title" readonly="readonly"
										class="form-control" readonly="readonly">
								</div>
								<div class="form-group has-warning col-md-3" id="titleno">
									<label class="control-label" for="inputWarning1">Title</label>
									<input type="text" id="titno" name="titno" readonly="readonly"
										class="form-control" readonly="readonly">
								</div>

								<div class="form-group has-warning col-md-3">
									<label class="control-label" for="inputWarning1">Description</label>
									<input type="text" id="description" name="description"
										readonly="readonly" class="form-control">
								</div>

								<div class="form-group has-warning col-md-3">
									<label class="control-label" for="inputWarning1">ClauseAct</label>
									<input type="text" id="clauseact" name="clauseact"
										readonly="readonly" class="form-control">
								</div>
								<div class="form-group has-warning col-md-3">
									<label class="control-label" for="inputWarning1">Legislative</label>
									<input type="text" id="legaslativedescription"
										name="legaslativedescription" readonly="readonly"
										class="form-control">
								</div>

								<div class="form-group has-warning col-md-3">
									<label class="control-label" for="inputWarning1">Compliance
										Type</label> <input type="text" id="compliancetype"
										name="compliancetype" readonly="readonly" class="form-control">

								</div>
								<div class="form-group has-warning col-md-3">
									<label class="control-label" for="inputWarning1">Frequency
										Description</label> <input type="text" id="frequencydescription"
										name="frequencydescription" readonly="readonly"
										class="form-control">

								</div>
								<div class="form-group has-warning col-md-3">
									<label class="control-label" for="inputWarning1">Iscritical</label>
									<input type="text" id="iscriticalstatus"
										name="iscriticalstatus" readonly="readonly"
										class="form-control">

								</div>
								<div class="form-group has-warning col-md-3" id="showinitiateddate">
									<label class="control-label" for="inputWarning1">InitiatedDate</label>
									<input type="text" id="initiateddate" name="initiateddate"
										readonly="readonly" class="form-control">

								</div>
                                 <div class="form-group has-warning col-sm-3" id="showduedate">
												<label class="control-label" for="inputWarning1">DueDate
												</label> <input type="text" id="Duedate" name="DueDate"
													readonly="readonly" class="form-control ">
											</div>

								<div class="form-group has-warning col-md-3">
									<label class="control-label" for="inputWarning1">ProofsRequiredstatus</label>
									<input type="text" id="proofsrequiredstatus"
										name="proofsrequiredstatus" readonly="readonly"
										class="form-control">

								</div>

								<div class="form-group has-warning col-md-3">
									<label class="control-label" for="inputWarning1">DocumentStatus</label>
									<input type="text" id="docstatus" name="docstatus"
										readonly="readonly" class="form-control">
								</div>
								
											
								 <div class="form-group has-warning col-sm-3" >
												<label class="control-label" for="inputWarning1">OwnerName
												</label> <input type="text" id="ownername" name="ownername"
													readonly="readonly" class="form-control "> 
											</div>
							<div class="form-group has-warning col-sm-4" id="showsubmitteddate">
												<label class="control-label" for="inputWarning1">SubmittedDate
												</label> <input type="text" id="submitteddate" name="submitteddate"
													readonly="readonly" class="form-control ">
											</div>
								<div class="form-group has-warning col-md-3" hidden="hidden">
									<label class="control-label" for="inputWarning1">Tranid</label>
									<input type="text" id="tranid" name="tranid"
										class="form-control">

								</div>

							</div>

						</div>
						<hr color="00FFFF ">
						<div id="approvershow">
								<div class="box-content row">
									<div class="form-group has-warning   col-md-3">
										<label class="control-label" for="inputWarning1">Complied</label>
										<select class="form-control" id="complied" name="complied"
											onchange="Remidiation()">
											<option value="">Select</option>
											<option value="yes">Yes</option>
											<option value="no">No</option>
										</select>
									</div>

									

										<div class="form-group has-warning col-sm-4">
											<label class="control-label" for="inputWarning1">ChooseFile </label> 
											<input type="file" id="transactionimage" name="transactionimage" multiple="multiple"
												class="form-control" onchange="Remidiation()">
										</div>
										<div class="form-group has-warning col-md-5">
											<label class="control-label" for="inputWarning1">Remarks</label>
											<textarea rows="4" cols="10" id="remarks" name="remarks"
												class="form-control">
			                               </textarea>
										</div>
								
									
									</div>
								
									 <div id="remidiation"> 
										<hr color="00FFFF ">
										 <div class="row"> 
											<div class="form-group has-warning col-sm-4" >
												<label class="control-label" for="inputWarning1">AlertDate
												 </label> <input type="text" id="duedate" name="duedate"
													autocomplete="off" class="form-control ">
											</div>
											<div class="form-group has-warning col-md-5"  >
												<label class="control-label" for="inputWarning1">Remidiation
													Plan</label>
												<textarea rows="4" cols="10" id="Remidiationplan"
													name="Remidiationplan" class="form-control">
			         </textarea>
											</div>
										</div> 
									 </div> 
								
							</div>
						
						<div id="approver">
								<div class="box-content row">
										<div class="form-group has-warning col-sm-3">
											<label class="control-label" for="inputWarning1">Complied
											</label> <input type="text" id="compliedstatus" name="compliedstatus"
												readonly="readonly" class="form-control ">
                                           </div>
                                           <div class="form-group has-warning col-sm-7" id="showtransactionremarks">
												<label class="control-label" for="inputWarning1">TransactionRemarks
												</label> 
												<textarea rows="7" cols="10" id="transactionremarks"
													name="transactionremarks" class="form-control" readonly="readonly">
			                                  </textarea>
												
                                          </div> 
											
											 <div class="form-group has-warning col-sm-3" id="showalertdate">
										<label class="control-label" for="inputWarning1">AlertDate 
										</label> <input type="text" id="getalertdate" name="getalertdate"
											class="form-control " readonly="readonly">
									    </div>
											<div class="form-group has-warning col-md-5"  id="showremidiationdescription">
												<label class="control-label" for="inputWarning1">RemidiationPlan</label>
												<textarea rows="4" cols="10" id="remidiationdescription" name="remidiationdescription" class="form-control" readonly="readonly">
			                                      </textarea>
											</div>
											<div class="form-group has-warning col-md-5">
												<label class="control-label" for="inputWarning1">Proofs</label>
												<select  class="form-control"  id="Filenames" name="Filenames" multiple="multiple">
												  <option value="1"></option>
												</select>
											</div>
											<div>
											</div>
								
							<div class="container" align ="center">
		                      <button  type="button"  onclick="Approvedmodelbox()"  class="btn btn-primary">Approved</button> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		                      <button  type="button"  onclick="Rejectmodelbox()"  class="btn btn-primary">Send Back</button>                     
		                   </div>					
										</div>
									
								</div>
							</div>
						
						<div class="modal-footer">
							<div class="container" align="center" id="buttonhide">
								<button type="button" class="btn btn-primary" id="submittransaction">Submit</button>
							</div>
						</div>
						
						</form>
					</div>
			</div>
		</div>
<!-- Send Back Model Box -->
<div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="Rejectedmodel" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog " role="document">
			<div class="modal-content">
			 <div align="center">
			<div class="alert alert-success " id="rejectsuccess" style="text-align:center">
  		<strong id="rejectstrong" ></strong> 
		</div>
			</div> 
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Rejected</h4>
					<button type="button" class="close text-secondary" data-dismiss="modal" onclick="Rejectreset()" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "Rejectedvalidation">
				<div class="modal-body mx-3">
					<div class="form-group has-warning col-md-8">
						<label class="control-label" for="inputWarning1"> Reason</label>
						<textarea rows="4" cols="10" id="rejectedtext" name="rejectedtext" class="form-control" >
			                                     </textarea>
					</div>
					<div align="center">
					<button type="button"id="submitReject" class="btn btn-primary" >
						Submit
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>
<!-- Approver Model Box -->
<div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="Approvermodel" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			 <div align="center">
			<div class="alert alert-success " id="approversuccess" style="text-align:center">
  		<strong id="approverstrong" ></strong> 
		</div>
			</div> 
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Approver </h4>
					<button type="button" class="close text-secondary" data-dismiss="modal" onclick="Approverreset()" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "Approvervalidation">
				<div class="modal-body mx-3">
					<div class="form-group has-warning col-md-8">
						<label class="control-label" for="inputWarning1"> Reason</label>
						<textarea rows="4" cols="10" id="approvertext" name="approvertext" class="form-control" >
			                                     </textarea>
					</div>
					<div align="center">
					<button type="button"id="submitApprover" class="btn btn-primary" >
						Submit
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>


<!-- fileshow show Model Box -->

<div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="fileshow" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
			  
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Files show  </h4>
					<button type="button" class="close text-secondary" data-dismiss="modal"  aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form >
				<div class="modal-body mx-3">
					<div class="form-group has-warning col-md-8" align="center">
						<label class="control-label" for="inputWarning1"> </label>
						<img  height="150" width="150"  id = "Item"/> 
					</div>
					  <div class="form-group has-warning col-md-8">
						<label class="control-label" for="inputWarning1"> </label>
						 <div>
                    <embed  type="application/pdf"  width="700px" height="1100px" id="pdffile">
                        </div>
					</div>  
				</div>				
				</form>
			</div>
		</div>
	</div>
</div>


</body>
</html>
<script>
	$('#transactionform').bootstrapValidator({
						//container: '#messages',
						feedbackIcons : {
							valid : 'glyphicon glyphicon-ok',
							invalid : 'glyphicon glyphicon-remove',
							validating : 'glyphicon glyphicon-refresh'
						},
						fields : {
							remarks : {
								validators : {
									notEmpty : {
										message : 'remarks is required ',

									}
								}
							},
							
							complied : {
								validators : {
									notEmpty : {
										message : 'Choose Yes or No ',

									}
								}
							},
							duedate : {
								validators : {
									notEmpty : {
										message : 'duedate is required ',

									}
								}
							},
							Remidiationplan : {
								validators : {
									notEmpty : {
										message : 'Remidiationplan is required ',

									}
								}
							},
							transactionimage : {
								validators : {
									notEmpty : {
										message : 'Select a valid file to upload'
									},
									file : {
										extension : 'pdf,jpeg,png,jpg,csv',
										type : 'application/pdf,image/jpeg,image/png,image/jpg,application/vnd.ms-excel',
										maxSize : 2048 * 1024,
										message : 'The selected files only jpeg or png or jpg or pdf is valid'
									}
								}
							},

						}

					});

	$("#submittransaction").on("click", function() {
		$('#transactionform').data('bootstrapValidator').validate();
		if ($('#transactionform').data('bootstrapValidator').isValid()) {
			//alert("Transactionsave");
			Transactionsave();
		}

	});
</script>
<script>
	function Transactionsave() {
		//alert("Transactionsave");
		var tranid = document.getElementById("tranid").value;
		//alert("tranid "+tranid);
		var remarks = document.getElementById("remarks").value;
		//alert("remarks "+remarks);
		var duedate = document.getElementById("duedate").value;
		//alert("duedate "+duedate);
		var Remidiationplan = document.getElementById("Remidiationplan").value;
		//alert("Remidiationplan "+Remidiationplan);
		var complied = document.getElementById("complied").value;
		//alert("complied "+complied);
		var formdata = new FormData();
		var totalFiles = document.getElementById("transactionimage").files.length;
		for (var i = 0; i < totalFiles; i++) {
			var multiplefilesupload = document.getElementById("transactionimage").files[i];
			formdata.append("multiplefilesupload", multiplefilesupload);
		}
		$.ajax({
			type : "post",
			url : "TransactionPhoto?tranid=" + tranid + "&remarks=" + remarks
					+ "&duedate=" + duedate + "&Remidiationplan="
					+ Remidiationplan + "&complied=" + complied, // this controller url
			data : formdata,
			processData : false,
			contentType : false,
			success : function(data) {
				$("#successmessage").html(" Sucessfully Stored");
				setInterval(function() {
					window.location.reload(); // this will run after every 5 seconds
				}, 2000);

			}

		});
	}
</script>
<!-- Rejectedvalidation -->
<script>
 $('#Rejectedvalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	 rejectedtext  :{
                      validators: {
                          notEmpty: {
                              message: 'Reason is required ',
                           },
                         }
                   }

             }

         });


$("#submitReject").on("click", function(){
$('#Rejectedvalidation').data('bootstrapValidator').validate();
if($('#Rejectedvalidation').data('bootstrapValidator').isValid()){
	//alert("Reject()")
	Sendback();
}

});
</script>
<!-- Appover Validation -->
<script>
 $('#Approvervalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	 approvertext  :{
                      validators: {
                          notEmpty: {
                              message: 'Reason is required ',
                           },
                         }
                   }

             }

         });


$("#submitApprover").on("click", function(){
$('#Approvervalidation').data('bootstrapValidator').validate();
if($('#Approvervalidation').data('bootstrapValidator').isValid()){
//	alert("Approver()")
	Approved();
}

});
</script>
<script src="resources/dist/js/sidebarmenu.js"></script>
<%@include file="footer.jsp"%>
<script>
	jQuery('#duedate').datepicker({
		format : "dd-mm-yyyy",
		autoclose : true,
		todayHighlight : true
	});
	jQuery('#alertdate').datepicker({
		format : "dd-mm-yyyy",
		autoclose : true,
		todayHighlight : true
	});
</script>

  <!-- <script >
var message = "right click disabled";
function rtclickcheck(keyp){
	if (navigator.appName == "Netscape" && keyp.which == 3){ 
		alert(message); 
	    return false; 
	}

if (navigator.appVersion.indexOf("MSIE") != -1 && event.button == 2) 
{ 
	alert(message);
return false;
} 
}
document.onmousedown = rtclickcheck;
</script>  --> 


 <script>
	window.history.pushState(null, "", window.location.href);
	window.onpopstate = function() {
	window.history.pushState(null, "", window.location.href);
	};
</script> 
<script>
$("#Filenames").click(function () {
	$('#fileshow').modal('show');
	 var filename = document.getElementById("Filenames").value;
	$.ajax({
	    bProcessing:true,
        type: "get",
        url: "displayimageandpdf?filename="+filename, //this is my servlet
        		success : function(data) {
        	  var image = data.base64Image;
        	 //  console.log(image);
        	$("#Item").attr("src", "data:image/*;base64," + image);
        	
        	$("#pdffile").attr("src", "data:application/pdf;base64," + image);
        //	$("#excelfile").attr("src", "data:application/vnd.ms-excel", + image);
        	
        	
		}
        
  });
   
    
});

</script>

<%
	} else {
		response.sendRedirect("login");
	}
%>





