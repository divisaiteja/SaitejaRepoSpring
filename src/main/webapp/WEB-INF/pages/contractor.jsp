<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >


<script>
$(document).ready(function(){
   // $("#warnings").hide();
    $("#DivisionEdit").hide();
    $("#DivisionSave").hide();
   
});
function DivisionDeletion(){
	 $("#Contractors").on('click', '#contractDelete', function() {
			var currentRow = $(this).closest("tr");
		    var contractorId = currentRow.find("td:eq(0)").html(); 
		    var retVal = confirm("would you like to delete this contractorId "+contractorId);
          if( retVal == true ) {
           //  document.write ("User wants to continue!");
             deletedSuccessfully(contractorId);
          } else {
             //document.write ("User does not want to continue!");
          }
         
	 });
}

function deletedSuccessfully(contractorId){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteContractor?contractorId="+contractorId, //this is my servlet
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

$("#Contractors").on('click', '#documentupload', function() {

	var currentRow = $(this).closest("tr");
	//var contractorId = $(this).closest('tr').attr('id');
    var contractorId = currentRow.find("td:eq(0)").html(); 
    document.getElementById("id").value = contractorId;
   // console.log(document.getElementById("id").value);
   // $("#id").append(contractorId);
   
   /*  $(document).ready(function() {
		var contractorid = document.getElementById("contractorId").value; */
		$('#contractordoc').dataTable(
				
				{
					"ajax" : {
						"url" : "/HRMS/getContractorDocs?contractorId="
								+ contractorId,
						"dataSrc" : "",
						"type" : "GET",
						
					},
					"destroy" : true,
					"columns" : [
					        {data : "tranid"},
							{data : "contractorid"},
							{data : "documentdetails"},
							
                             {
								data : null,
								className : "center",
								defaultContent : ' <input type="image" src="resources/assets/images/delete.png" id="deleteDocument" height="15" width="18"  onclick="deleteDocument()" > <input type="image" src="resources/assets/images/download1.jpg" id="downloadFile"  height="30" width="30"  "  >'
							} ],
				});
		 $('#ContractDocuments').modal('show');
});
function contractorDocStore() {
	//var tranid = document.getElementById("tranid").value;
    var contractorid = document.getElementById("id").value; 
	var documentdetails = document.getElementById("documentdetails").files[0];
	var formdata = new FormData();
	formdata.append("documentdetails", documentdetails);

	$.ajax({
		type : "post",
		// contentType: false,
		url : "storeContractorDoc?contractorid=" + contractorid, // this controller url
		//url : "storeDocDetails1",
		data : formdata,
		processData : false,
		contentType : false,
		success : function(data) {
			console.log(data);
			 window.location.reload();
			
		}

	});
	

}
</script>
<script>
$("#Contractors").on('click','#contractEditing',function() {
	var currentRow = $(this).closest("tr");
	var rowData = $("#Contractors").DataTable().row(currentRow).data();
	var contractorId = rowData.contractorid;
	retrieve:true,
	$.ajax({
		
	    type: "GET",
	    contentType : "application/json",
	    url: "/HRMS/getContractor?contractorId=" + contractorId, //this is my servlet
	    success: function(data){ 
	    	for (var i = 0; i < data.length; i++) {
			$("#ContractorId").val(data[i].contractorid);
		    $("#Name").val(data[i].name);
			$("#Address ").val(data[i].address);
			$("#isactive").val(data[i].isactive);
	    	 $("#City").val(data[i].city);
	    	$("#Statecode").val(data[i].statecode);
	    	$("#Pannumber").val(data[i].pannumber);
	    	$("#Gstn").val(data[i].gstn);
	    	$("#Emailid").val(data[i].emailid);
	    	$("#Contactno").val(data[i].contactno);
	    	$("#Estddate").val(data[i].estddate);
	    	$("#DateofJoining").val(data[i].dateOfJoining);
	    	$("#Regionid").val(data[i].regionid);
	    	$("#Zoneid").val(data[i].zoneid);
	    	$("#Areaid").val(data[i].areaid);
	    	$("#Serialno").val(data[i].serialno);
	    	
	    	//$("#Parentid").val(data[i].parentid); 
	    	
	    	}
			selectedRecord = data;
	    },
	});
	$('#contractormodal').modal('show');
});

</script>


<script>
function contractEdit(){
	var contractedit = {};
	//var divisionid = document.getElementById("divisionid").value;
	contractedit["contractorid"] = $("#ContractorId").val();
	contractedit["name"] = $("#Name").val();
	contractedit["address"]=$("#Address").val();
	contractedit["isactive"] = $("#isactive").val(); 
	contractedit["city"] = $("#City").val();
	contractedit["statecode"]=$("#Statecode").val();
	contractedit["pannumber"] = $("#Pannumber").val();
	contractedit["gstn"] = $("#Gstn").val();
	contractedit["emailid"] = $("#Emailid").val();
	contractedit["contactno"] = $("#Contactno").val();
	contractedit["estddate"] = $("#Estddate").val();
	contractedit["dateOfJoining"] = $("#DateofJoining").val();
	contractedit["regionid"] = $("#Regionid").val();
	contractedit["zoneid"] = $("#Zoneid").val();
	contractedit["areaid"] = $("#Areaid").val();
	contractedit["serialno"] = $("#Serialno").val();
	
	//divisionEdit["parentid"] = $("#Parentid").val(); 
	
  
     $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editContractor", 
        data : JSON.stringify(contractedit),
        success: function(data){  
    	 $("#DivisionStrong").html(data["successMessage"]);
       	 $("#DivisionEdit").show();
    	setInterval(function(){
        	window.location.reload(); // this will run after every 5 seconds
        }, 2000);
        }
   
    });
	
   
}

</script>

<script>
$(document).ready(function() {
	  // Edit record
   
	$("#Contractors").dataTable( {
			 "ajax" : {
			"url" : "/HRMS/getAllContractors",
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
			"columns": [
				            { data:"contractorid"},
				            { data:"name"},
				            //{ data:"address"},
				            { data:"city"},
				            //{ data:"statecode"},
				            { data:"pannumber"}, 
				            { data:"gstn"},
				            { data:"contactno"}, 
				            { data:"emailid"},
				            //{ data:"estddate"},
				        	{ data: "statusCodeForActive"},  
				           // { data:"regionid "}, 
				           // { data:"zoneid "},
				            //{ data:"areaid "},
				           // { data:"serialno"},
				           // { data:"parentid "},
				           // { data:"icon"},
							
					 	
 							
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="contractEditing"  >   <input type="image" src="resources/assets/images/delete.png" id="contractDelete" height="25" width="25"  onclick="DivisionDeletion()"> <input type="image" src="resources/assets/images/document.jpg"  id="documentupload" height="25" width="25"  >'
				            }
					],
		
		} );
	
} );
</script>

<script>
function saveNewContractor(){
	var saveNewContractor = {};
	saveNewContractor["name"] = $("#name").val();
	saveNewContractor["address"] = $("#address").val();
	saveNewContractor["city"] = $("#city").val();
	saveNewContractor["statecode"] = $("#statecode").val();
	saveNewContractor["pannumber"] = $("#pannumber").val(); 
	saveNewContractor["gstn"] = $("#gstn").val();
	saveNewContractor["contactno"] = $("#contactno").val();
	saveNewContractor["emailid"] = $("#emailid").val();
	saveNewContractor["estddate"] = $("#saveEstddate").val(); 
	saveNewContractor["dateOfJoining"] = $("#dateofjoining").val(); 
	saveNewContractor["regionid"] = $("#regionid").val();
	saveNewContractor["zoneid"] = $("#zoneid").val();
	saveNewContractor["areaid"] = $("#areaid").val();
	
	/*saveDivision["serialno"] = $("#serialno").val();
	saveDivision["parentid"] = $("#parentid").val(); */
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "saveNewContractor", //this is my servlet
	        data : JSON.stringify(saveNewContractor),  
	        success: function(data){ 
	        	$("#DivisionSaveStrong").html(data["successMessage"]);
				$("#DivisionSave").show();	
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);
	        }
	 });
}
</script>

<body>
<div>
<h5 align="center">
		To Add New Contractor <a data-toggle="modal"
			data-target="#newContractor" href="#">ClickHere</a>
	</h5>
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>
<table id="Contractors" class="display" style="width:100%" border="2">
        <thead>
            <tr>
           		 <th>Id</th>
                <th>Name</th>
                <th>City</th>
                <th>PAN</th>
                <th>GST</th>
                <th>ContactNumber</th>
                <th>EmailId</th>
                <th>Status</th>
              	<th>Action</th>
                
            </tr>
        </thead>
    </table>
    
  <!--****************************Edit Division model box *******************************-->
  
  <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="contractormodal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="DivisionEdit" style="text-align:center">
  		<strong id="DivisionStrong" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Contract Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "contracteditvalidation">
				<div class="modal-body mx-3">
				<div class="box-content row">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="contractorId">Contractor Id</label>
						<input type="text" name="contractorId" id="ContractorId"  class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="Name">Name</label>
						<input type="text" id="Name" name="Name" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="Address">Address</label>
						<input type="text" id="Address" name="Address" class="form-control">
					</div>

                                        <div  class="form-group has-warning col-md-12">
						<label class="control-label" for="City">City</label>
						<input type="text" id="City" name="City" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12" hidden>
						<label class="control-label" for="Statecode">Statecode</label>
						<input type="text" id="Statecode" name="Statecode" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="Pannumber">PanNumber</label>
						<input type="text" id="Pannumber" name="Pannumber" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="Gstn">GSTN</label>
						<input type="text" id="Gstn" name="Gstn" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="Emailid">Emailid</label>
						<input type="text" id="Emailid" name="Emailid" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="Contactno">ContactNo</label>
						<input type="text" id="Contactno" name="Contactno" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="Estddate">EstdDate </label>
                         <input placeholder="YYYY-MM-DD" type="text" id="Estddate" name="Estddate" class="form-control">
					</div>
					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="DateofJoining">Date Of Joining </label>
                         <input placeholder="YYYY-MM-DD" type="text" id="DateofJoining" name="DateofJoining" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12" hidden>
						<label class="control-label" for="Regionid">RegionId</label>
						<input type="text" id="Regionid" name="Regionid" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12" hidden>
						<label class="control-label" for="Zoneid">ZoneId</label>
						<input type="text" id="Zoneid" name="Zoneid" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12" hidden>
						<label class="control-label" for="Areaid">AreaId</label>
						<input type="text" id="Areaid" name="Areaid" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="Serialno">SerialNo</label>
						<input type="text" id="Serialno" name="Serialno" class="form-control">
					</div>
						<!-- <div  class="form-group has-warning col-md-12">
						<label class="control-label" for="Parentid">ParentId</label>
						<input type="text" id="Parentid" name="Parentid" class="form-control" readonly = "readonly">
					</div> -->
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">Status</label>
						<input type = "text"  id="isactive" name="isactive" class="form-control">
					
					</div>
					<div align="center">
					<button type="button"id="submitcontract" class="btn btn-primary" >
						Submit
					</button> 
					</div>
				</div>				
				</div>
				</form>
			</div>
		</div>
	</div>
</div>
  
    
    <!--**************************Save Division model box *******************************-->
    
  <div class="modal fade" id="newContractor" role="dialog">
		
	<div class="modal-dialog modal-lg">
	
		<div class="modal-content">
		
			<div class="modal-header">
			<div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" >Adding New Contractor </h4>
		   </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div align="center">
			<div class="alert alert-success " id="DivisionSave" style="text-align:center">
  	<strong id="DivisionSaveStrong" ></strong> 
	</div>
	</div>
       <form id="ContractSave" autocomplete="on|off">
			<div class="modal-body">
				<div class="box-content row">
			<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Name</label> <input
						type="text" id="name" name="name" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Address</label> <input
						type="text" id="address" name="address" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">City</label> <input
						type="text" id="city" name="city" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4" hidden>
					<label class="control-label" for="inputWarning1" >StateCode</label>
					<input type="text" id="statecode"  name="statecode" class="form-control" >
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">PanNumber</label>
					<input type="text" id="pannumber" name="pannumber" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">GST</label> <input
						type="text" id="gstn" name="gstn" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">ContactNo</label>
					<input type="text" id="contactno" name="contactno" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">EmailId</label> <input
						type="text" id="emailid" name="emailid" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">EstdDate</label> <input
						type="text" id="saveEstddate" name="saveEstddate" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4" hidden>
					<label class="control-label" for="inputWarning1">Regionid</label> <input
						type="text" id="regionid" name="regionid" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4" hidden>
					<label class="control-label" for="inputWarning1">ZoneId</label> <input
						type="text" id="zoneid" name="zoneid" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4" hidden>
					<label class="control-label" for="inputWarning1">AreaId</label> <input
						type="text" id="areaid" name="areaid" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Date Of Joining</label> <input
						type="text" id="dateofjoining" name="dateofjoining" class="form-control">
				</div>

			</div>
			</div>
			
			<div class="modal-footer">
			<div class="container" align="center">
				<button type="button" class="btn btn-default"  id="ContractorSaveBtn" >Submit</button>
			</div>
			</div>
			</form>
		</div>
		
		</div>
	</div>
	<!-- ######################################################## -->
	<div class="modal fade" id="ContractDocuments" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
        <h3 align="left" style="color: #fb8c00">Contractor Documents</h3>
	<form id="doc_form">
		<div class="row">
		<input type="hidden" name="contractorId" id="id"  class="form-control"
							readonly="readonly">
			<div class="form-group has-warning col-sm-5">
				<label class="control-label" for="inputWarning1">Choose
					File:</label> <input type="file" id="documentdetails" name="documentdetails" class="form-control" multiple>
			</div>
			<div class="form-group has-warning col-sm-2"
				style='margin-top: 28px;'>
				<input type="submit" id="doc_submit" value="Submit" class="btn btn-success">
			</div>
		</div>
	</form>
          <table id="contractordoc" class="display" style="width:100%" border="2">
        <thead>
            <tr>
           		 <th>Tranid</th>
                <th>Contractorid</th>
                <th>Documentdetails</th>
              	<th>Action</th>
                
            </tr>
        </thead>
    </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  

	
</body>
<script src="resources/validation/bootstrapValidator.min.js"></script>

<script>
 $('#ContractSave').bootstrapValidator({
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
                             message: 'name is required ',
                          },
                        }
                  },
				  address: {
                     validators: {
                         notEmpty: {
                             message: 'address is required ',
                          },
                        }
                  },
				  city: {
                     validators: {
                         notEmpty: {
                             message: 'city is required ',
                          },
                        }
                  },
                  statecode: {
                      validators: {
                          notEmpty: {
                              message: 'statecode is required ',
                           },
                         }
                   },
                   pannumber: {
                       validators: {
                           notEmpty: {
                               message: 'pannumber is required ',
                            },
                          }
                    },
                    gstn: {
                        validators: {
                            notEmpty: {
                                message: 'gstnumber is required ',
                             },
                           }
                     },
                     contactno: {
                         validators: {
                             notEmpty: {
                                 message: 'contactno is required ',
                              },
                            }
                      },
                      emailid: {
                          validators: {
                              notEmpty: {
                                  message: 'email is required ',
                               },
                               regexp: {
                                   regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                                   message:'Please enter valid email address.'
                                 }
                             }
                       },
                       saveEstddate: {
                           validators: {
                               notEmpty: {
                                   message: 'estddate is required ',
                                },
                              }
                        },
                        dateofjoining: {
                            validators: {
                                notEmpty: {
                                    message: 'DateofJoining is required ',
                                 },
                               }
                         },
                        
                        regionid: {
                            validators: {
                                notEmpty: {
                                    message: 'regionid is required ',
                                 },
                               }
                         },
                         zoneid: {
                             validators: {
                                 notEmpty: {
                                     message: 'zoneid is required ',
                                  },
                                }
                          },
                          areaid: {
                              validators: {
                                  notEmpty: {
                                      message: 'areaid is required ',
                                   },
                                 }
                           },

             }

         });
        $("#ContractorSaveBtn").click(function(){
$('#ContractSave').data('bootstrapValidator').validate();
if($('#ContractSave').data('bootstrapValidator').isValid()){
	saveNewContractor();
}


});

</script>
<script>
 $('#contracteditvalidation').bootstrapValidator({
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
			 
                  Address: {
                     validators: {
                         notEmpty: {
                             message: 'Address required ',
                          },
                        }
                  },
                  City: {
                      validators: {
                          notEmpty: {
                              message: 'City required ',
                           },
                         }
                   },
                   Statecode: {
                       validators: {
                           notEmpty: {
                               message: 'Statecode required ',
                            },
                          }
                    },
                    Pannumber: {
                        validators: {
                            notEmpty: {
                                message: 'Pannumber required ',
                             },
                           }
                     },
                     Gstn: {
                         validators: {
                             notEmpty: {
                                 message: 'Gstn required ',
                              },
                            }
                      },
                      Emailid: {
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
                       Contactno: {
                           validators: {
                               notEmpty: {
                                   message: 'Contact Number required ',
                                },
                              }
                        },
                        Estddate: {
                            validators: {
                                notEmpty: {
                                    message: 'Estd Date required ',
                                 },
                               }
                         },
                         DateofJoining: {
                             validators: {
                                 notEmpty: {
                                     message: 'DateofJoining required ',
                                  },
                                }
                          },
                         
                         Regionid: {
                             validators: {
                                 notEmpty: {
                                     message: 'Regionid Date required ',
                                  },
                                }
                          },
                          Zoneid: {
                              validators: {
                                  notEmpty: {
                                      message: 'Zoneid Date required ',
                                   },
                                 }
                           },
                           Areaid: {
                               validators: {
                                   notEmpty: {
                                       message: 'Areaid Date required ',
                                    },
                                  }
                            },
                            Serialno: {
                                validators: {
                                    notEmpty: {
                                        message: 'Serilno Date required ',
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


$("#submitcontract").on("click", function(){
$('#contracteditvalidation').data('bootstrapValidator').validate();
if($('#contracteditvalidation').data('bootstrapValidator').isValid()){
	contractEdit();
}

});
</script>
<script>
$('#doc_form').bootstrapValidator({
	//container: '#messages',
	feedbackIcons : {
		valid : 'glyphicon glyphicon-ok',
		invalid : 'glyphicon glyphicon-remove',
		validating : 'glyphicon glyphicon-refresh'
	},

		documentdetails : {
			validators : {
				notEmpty : {
					message : 'Select a valid file to upload'
				},
				file : {
					extension : 'pdf,jpeg,png',
					type : 'application/pdf,image/jpeg,image/png',
				     maxSize : 2048 * 1024,
					message : 'The selected file is not valid'
				}
			}
		},
		});


$("#doc_submit").on("click", function(){
	$('#doc_form').data('bootstrapValidator').validate();
	if($('#doc_form').data('bootstrapValidator').isValid()){
		contractorDocStore();
	}

	});
</script>
<script src="resources/dist/js/sidebarmenu.js"></script>
  
 <%@include file="footer.jsp"%>
 <script>
jQuery('#saveEstddate').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#Estddate').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#DateofJoining').datepicker({
    autoclose: true,
    todayHighlight: true
});
$("#dateofjoining").datepicker().datepicker("setDate", new Date());
/* jQuery('#dateofJoining').datepicker({
    autoclose: true,
    todayHighlight: true
}); */

</script>
</html>