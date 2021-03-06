<%@include file="header.jsp" %>
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
<script>
$(document).ready(function(){
    $("#successinedit").hide();
    $("#saveBanksuccess").hide();
});
</script>
<script>
$("#banklist").on('click', '#bankId', function() {
	var currentRow = $(this).closest("tr");
    var tranid = currentRow.find("td:eq(0)").html(); 
    var retVal = confirm("would you like to delete this tranid "+tranid);
   if( retVal == true ) {
      deletedSuccessfully(tranid);
   } else {
      //document.write ("User does not want to continue!");
   }
  
});
function deletedSuccessfully(tranid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deletebank?tranid="+tranid, //this is my servlet
	        success: function(data){  
	        	$("#deletemessage").html("DeletedSucessFully");
	        	 setInterval(function(){
	 	        	window.location.reload(); // this will run after every 5 seconds
	 	        }, 2000);
	        }
	  });
}
</script>
<script>
	$("#banklist").on('click','#bankEditing',function() {
		var currentRow = $(this).closest("tr");
		var rowData = $("#banklist").DataTable().row(currentRow).data();
		var tranid = rowData.tranid;
		retrieve:true,
		$.ajax({
		contentType : "application/json",
			"url" : "/HRMS/getAllBankByTranid?tranid="+tranid,
			"dataSrc" : "dataBean",
			"type" : "GET",
             success : function(data) {
			for (var i = 0; i < data.length; i++) {
			  $("#tranid").val(data[i].tranid);
			  $("#contactpersonname").val(data[i].contactpersonname);
			  $("#bankcode ").val(data[i].bankcode);
			  $("#bankname ").val(data[i].bankname);
			  $("#branchname").val(data[i].branchname);
			  $("#ifsccode").val(data[i].ifsccode);
			  $("#address ").val(data[i].address);
			  $("#contactnumber ").val(data[i].contactnumber);
			  $("#emailid").val(data[i].emailid);
							}
                 selectedRecord = data;
                    },
                      });
                  $('#bankmodal').modal('show');

					});
	</script>
	<script>

function bankEdit(){
	var bankEdit = {};
	bankEdit["tranid"] = $("#tranid").val();
	bankEdit["contactpersonname"] = $("#contactpersonname").val();
	bankEdit["bankcode"] = $("#bankcode").val();
	bankEdit["bankname"] = $("#bankname").val();
	bankEdit["branchname"] = $("#branchname").val();
	bankEdit["ifsccode"] = $("#ifsccode").val();
	bankEdit["address"] = $("#address").val();
	bankEdit["contactnumber"] = $("#contactnumber").val();
	bankEdit["emailid"] = $("#emailid").val();
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editBankMaster", //this controller url
        data : JSON.stringify(bankEdit),
        success: function(data){  
        	 $("#successinedit").show();
        	 $("#successmsginedit").html(data["successMessage"]);
        	setInterval(function(){
	        	window.location.reload(); // this will run after every 5 seconds
	        }, 2000);
         
        }
   
    });
   
}

</script>
<script>
$(document).ready(function() {
	$('#banklist').dataTable({
			 "ajax" : {
			"url" : "/HRMS/getAllBankMaster",
			"dataSrc" : "dataBean",
			"type" : "GET",
		       },
			"columns": [
				            { data:"tranid"},
			 				{ data:"bankcode"},
			 				{ data:"bankname"},
					 		{ data:"branchname"},
					 		{ data:"address"},
			 				{ data:"contactnumber"},
					 		{ data:"emailid"},
					 		{ data:"contactpersonname"}, 
					 		{ data:"ifsccode"},
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="bankEditing"    >   <input type="image" src="resources/assets/images/delete.png" id="bankId" height="25" width="25">'
				            }
					],
		
		});
	
});
</script>
<script>
function savebank(){
		var savebank = {};
		savebank["contactpersonname"]= $("#Contactpersonname").val();
		savebank["bankcode"]= $("#Bankcode").val();
		savebank["bankname"]= $("#Bankname").val();
		savebank["branchname"]= $("#Branchname").val();
		savebank["ifsccode"]= $("#Ifsccode").val();
		savebank["address"]= $("#Address").val();
		savebank["contactnumber"]= $("#Contactnumber").val();
		savebank["emailid"]= $("#Emailid").val();
		$.ajax({
			type: "post",
			contentType : "application/json",
			url: "savebank", 
			data : JSON.stringify(savebank),
			success: function(data){ 
				 $("#saveBanksuccess").show();
				$("#banksave").html(data["successMessage"]);
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 2 seconds
		        }, 2000);
			}
		});
	}

</script>
<div>
<h5 align="center">
		To Add New Bank Information <a data-toggle="modal"
			data-target="#modelbank" id="" onclick="" href="#">Click
			Here</a>
	</h5>	
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>
<div class="search-table-outter wrapper">
<table id="banklist" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           	    <th>Tranid</th>
                <th>Short Name</th>
                <th>Bank Name</th>
                <th>Branch Name</th>
                <th>Address</th>
                <th>Contact Number</th>
                <th>Email-Id</th>
                <th>Name</th>
                <th>IFSC</th>
                <th>Action</th>
            </tr>
        </thead>
       
    </table>
    </div>
    
    <!-- ************************************* Bank Edit Model Box *************************************-->
   
    <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="bankmodal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="successinedit" style="text-align:center">
  		<strong id="successmsginedit" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Bank Details Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "bankeditvalidation">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="gradeno">TranId</label>
						<input type="text" id="tranid" name="tranid" class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="code">Contact Person</label>
						<input type="text" id="contactpersonname" name="contactpersonname" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="inputWarning1">BanKShortName</label>
						<input type="text" id="bankcode" name="bankcode" class="form-control">
					</div>
	              

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">BankName</label>
						<input type = "text"  id="bankname" name="bankname" class="form-control">
					
					</div>
					
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">BranchName</label>
						<input type = "text"  id="branchname" name="branchname" class="form-control">
					
					</div>
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">BankIfscCode</label>
						<input type = "text"  id="ifsccode" name="ifsccode" class="form-control">
					
					</div>
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">Address</label>
						<input type = "text"  id="address" name="address" class="form-control">
					
					</div>
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">ContactNumber</label>
						<input type = "text"  id="contactnumber" name="contactnumber" class="form-control">
					
					</div>
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">EmailId</label>
						<input type = "text"  id="emailid" name="emailid" class="form-control">
					
					</div>
					<div align="center">
					<button type="button"id="submitbank" class="btn btn-primary" >
						Submit 
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>
    
<!--******************************  Bank Save  model box***************************--> 
    
    <div class="modal fade" id="modelbank" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
		
		<div class="modal-header">
		   <div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" >Adding New BankDetails</h4>
		   </div>
			<button type="button"  class="close"  data-dismiss="modal">&times;</button>
			</div>
			 <div align="center">
			<div class="alert alert-success " id="saveBanksuccess">
  		    <strong id="banksave" ></strong> 
		    </div>
			</div>
			
          <form id="savebankdetails">
			<div class="modal-body">
				<div class="box-content row">
				<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">Person Name</label> <input
							type="text" id="Contactpersonname" name="Contactpersonname" class="form-control">
					</div>
					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">BankShortName</label> <input
							type="text" id="Bankcode" name="Bankcode" class="form-control">
					</div>
                    
                    <div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">BankName</label> <input
							type="text" id="Bankname" name="Bankname" class="form-control">
					</div>
                    
                     <div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">BranchName</label> <input
							type="text" id="Branchname" name="Branchname" class="form-control">
					</div>
					
					 <div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">BankIfscCode</label> <input
							type="text" id="Ifsccode" name="Ifsccode" class="form-control">
					</div>
					
					 <div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">Address</label> <input
							type="text" id="Address" name="Address" class="form-control">
					</div>
                   
                   <div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">ContactNumber</label> <input
							type="text" id="Contactnumber" name="Contactnumber" class="form-control">
					</div>
					 <div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">EmailId</label> <input
							type="text" id="Emailid" name="Emailid" class="form-control">
					</div>
                    
				</div>
                 
			</div>
			
			<div class="modal-footer">
			<div class ="container" align="center">
				<button type="button" class="btn btn-default"  id="submitsavebankdetails">Submit</button>
			</div>
			</div>
			</form>
		</div>
	</div>
	</div>
	<link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
	 <script src="resources/dist/js/sidebarmenu.js"></script>
	<%@include file="footer.jsp"%>
  <script src="resources/validation/bootstrapValidator.min.js"></script>
<script>
 $('#savebankdetails').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	 Contactpersonname: {
                     validators: {
                         notEmpty: {
                             message: 'Person Name is required ',
                          },
                        }
                  },
                  Bankcode: {
                      validators: {
                          notEmpty: {
                              message: 'BankShortName is required ',
                           },
                         }
                   },
                   Bankname: {
                       validators: {
                           notEmpty: {
                               message: 'BankName is required ',
                            },
                          }
                    },
                    Branchname: {
                        validators: {
                            notEmpty: {
                                message: 'BranchName is required ',
                             },
                           }
                     },
                     Ifsccode: {
                         validators: {
                             notEmpty: {
                                 message: 'IfscCode is required ',
                              },
                            }
                      },
                      Address: {
                          validators: {
                              notEmpty: {
                                  message: 'Address is required ',
                               },
                             }
                       },
                       Contactnumber : {
                           validators: {
                               notEmpty: {
                                   message: 'Contact Number is required ',
                                },
                              }
                        },
                        Emailid: {
                        	validators: {
                                notEmpty: {
                                    message: 'Emailid is required ',
                                 },
                                 regexp: {
                                     regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                                     message:'Please enter valid email address.'
                                   }
                               }
                         },
             }
         });
        $("#submitsavebankdetails").click(function(){
$('#savebankdetails').data('bootstrapValidator').validate();
if($('#savebankdetails').data('bootstrapValidator').isValid()){
	savebank();
}
});
</script>



<script>
 $('#bankeditvalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	 contactpersonname: {
                     validators: {
                         notEmpty: {
                             message: 'Person Name is required ',
                          },
                        }
                  },
                  bankcode: {
                      validators: {
                          notEmpty: {
                              message: 'BankShortName is required ',
                           },
                         }
                   },
                   bankname: {
                       validators: {
                           notEmpty: {
                               message: 'BankName is required ',
                            },
                          }
                    },
                    branchname: {
                        validators: {
                            notEmpty: {
                                message: 'BranchName is required ',
                             },
                           }
                     },
                     ifsccode: {
                         validators: {
                             notEmpty: {
                                 message: 'IfscCode is required ',
                              },
                            }
                      },
                      address: {
                          validators: {
                              notEmpty: {
                                  message: 'Address is required ',
                               },
                             }
                       },
                       contactnumber : {
                           validators: {
                               notEmpty: {
                                   message: 'Contact Number is required ',
                                },
                              }
                        },
                        emailid: {
                        	validators: {
                                notEmpty: {
                                    message: 'Emailid is required ',
                                 },
                                 regexp: {
                                     regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                                     message:'Please enter valid email address.'
                                   }
                               }
                         },
             }

         });

$("#submitbank").on("click", function(){
$('#bankeditvalidation').data('bootstrapValidator').validate();
if($('#bankeditvalidation').data('bootstrapValidator').isValid()){
	bankEdit();
}

});
</script>

