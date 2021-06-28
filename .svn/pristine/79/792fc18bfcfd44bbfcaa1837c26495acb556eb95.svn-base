<%@include file="header.jsp" %>
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >

<script>
$(document).ready(function(){
   // $("#warnings").hide();
    $("#DivisionEdit").hide();
    $("#DivisionSave").hide();
   
});
function DivisionDeletion(){
	 $("#division").on('click', '#divisiondeleted', function() {
			var currentRow = $(this).closest("tr");
		    var divisionid = currentRow.find("td:eq(0)").html(); 
		    var retVal = confirm("would you like to delete this divisionid "+divisionid);
          if( retVal == true ) {
           //  document.write ("User wants to continue!");
             deletedSuccessfully(divisionid);
          } else {
             //document.write ("User does not want to continue!");
          }
         
	 });
}

function deletedSuccessfully(divisionid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteDivision?divisionid="+divisionid, //this is my servlet
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
$("#division").on('click','#divisionEditing',function() {
	var currentRow = $(this).closest("tr");
	var rowData = $("#division").DataTable().row(currentRow).data();
	var divisionid = rowData.divisionid;
	retrieve:true,
	$.ajax({
		
	    type: "GET",
	    contentType : "application/json",
	    url: "/DASHBOARD/getdivisions?divisionid=" + divisionid, //this is my servlet
	    success: function(data){ 
	    	for (var i = 0; i < data.length; i++) {
			$("#Divisionid").val(data[i].divisionid);
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
	    	$("#Regionid").val(data[i].regionid);
	    	$("#Zoneid").val(data[i].zoneid);
	    	$("#Areaid").val(data[i].areaid);
	    	$("#Serialno").val(data[i].serialno);
	    	//$("#Parentid").val(data[i].parentid); 
	    	
	    	}
			selectedRecord = data;
	    },
	});
	$('#divisionmodal').modal('show');
});

</script>


<script>
function divisionedit(){
	var divisionEdit = {};
	//var divisionid = document.getElementById("divisionid").value;
	divisionEdit["divisionid"] = $("#Divisionid").val();
	divisionEdit["name"] = $("#Name").val();
    divisionEdit["address"]=$("#Address").val();
    divisionEdit["isactive"] = $("#isactive").val(); 
    divisionEdit["city"] = $("#City").val();
	divisionEdit["statecode"]=$("#Statecode").val();
	divisionEdit["pannumber"] = $("#Pannumber").val();
	divisionEdit["gstn"] = $("#Gstn").val();
	divisionEdit["emailid"] = $("#Emailid").val();
	divisionEdit["contactno"] = $("#Contactno").val();
	divisionEdit["estddate"] = $("#Estddate").val();
	divisionEdit["regionid"] = $("#Regionid").val();
	divisionEdit["zoneid"] = $("#Zoneid").val();
	divisionEdit["areaid"] = $("#Areaid").val();
	divisionEdit["serialno"] = $("#Serialno").val();
	//divisionEdit["parentid"] = $("#Parentid").val(); 
	
  
     $.ajax({
        type: "post",
        contentType : "application/json",
        url: "editDivision", 
        data : JSON.stringify(divisionEdit),
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
   
	$('#division').dataTable( {
			 "ajax" : {
			"url" : "/DASHBOARD/getdivision",
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
			"columns": [
				            { data:"divisionid"},
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
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="divisionEditing"  >   <input type="image" src="resources/assets/images/delete.png" id="divisiondeleted" height="25" width="25"  onclick="DivisionDeletion()">'
				            }
					],
		
		} );
	
} );
</script>

<script>
function saveDivision(){
	var saveDivision = {};
	saveDivision["name"] = $("#name").val();
	saveDivision["address"] = $("#address").val();
	saveDivision["city"] = $("#city").val();
	saveDivision["statecode"] = $("#statecode").val();
	saveDivision["pannumber"] = $("#pannumber").val(); 
	saveDivision["gstn"] = $("#gstn").val();
	saveDivision["contactno"] = $("#contactno").val();
	saveDivision["emailid"] = $("#emailid").val();
	saveDivision["estddate"] = $("#estddate").val(); 
	saveDivision["regionid"] = $("#regionid").val();
	saveDivision["zoneid"] = $("#zoneid").val();
	saveDivision["areaid"] = $("#areaid").val();
	/*saveDivision["serialno"] = $("#serialno").val();
	saveDivision["parentid"] = $("#parentid").val(); */
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "saveNewDivision", //this is my servlet
	        data : JSON.stringify(saveDivision),  
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
<div>
<h5 align="center">
		To Add New Division <a data-toggle="modal"
			data-target="#newDivision" href="#">ClickHere</a>
	</h5>
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>
<table id="division" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		 <th>Id</th>
                <th>Name</th>
                <th>City</th>
                <th>PAN</th>
                <th>GST</th>
                <th>EmailId</th>
                <th>ContactNumber</th>
                <th>Status</th>
              	<th>Action</th>
                
            </tr>
        </thead>
    </table>
    
  <!--****************************Edit Division model box *******************************-->
  
  <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="divisionmodal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="DivisionEdit" style="text-align:center">
  		<strong id="DivisionStrong" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5"> Division Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "divisioneditvalidation">
				<div class="modal-body mx-3">
				<div class="box-content row">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="Divisionid">DivisionId</label>
						<input type="text" name="Divisionid" id="Divisionid"  class="form-control"
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
						<div  class="form-group has-warning col-md-12">
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
						<label class="control-label" for="Estddate">EstdDate</label>
						<input type="date" id="Estddate" name="Estddate" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="Regionid">RegionId</label>
						<input type="text" id="Regionid" name="Regionid" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="Zoneid">ZoneId</label>
						<input type="text" id="Zoneid" name="Zoneid" class="form-control">
					</div>
						<div  class="form-group has-warning col-md-12">
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
					<button type="button"id="submitgrade" class="btn btn-primary" >
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
    
  <div class="modal fade" id="newDivision" role="dialog">
		
	<div class="modal-dialog modal-lg">
	
		<div class="modal-content">
		
			<div class="modal-header">
			<div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" >Adding New Division </h4>
		   </div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div align="center">
			<div class="alert alert-success " id="DivisionSave" style="text-align:center">
  	<strong id="DivisionSaveStrong" ></strong> 
	</div>
	</div>
       <form id="division_form">
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
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">StateCode</label>
					<input type="text" id="statecode" name="statecode" class="form-control">
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
						type="date" id="estddate" name="estddate" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Regionid</label> <input
						type="text" id="regionid" name="regionid" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">ZoneId</label> <input
						type="text" id="zoneid" name="zoneid" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">AreaId</label> <input
						type="text" id="areaid" name="areaid" class="form-control">
				</div>

			</div>
			</div>
			
			<div class="modal-footer">
			<div class="container" align="center">
				<button type="button" class="btn btn-default"  id="division_btn" >Submit</button>
			</div>
			</div>
			</form>
		</div>
		
		</div>
	</div>
  
 <script src="resources/validation/bootstrapValidator.min.js"></script>

<script>
 $('#division_form').bootstrapValidator({
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
                       estddate: {
                           validators: {
                               notEmpty: {
                                   message: 'estddate is required ',
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
        $("#division_btn").click(function(){
$('#division_form').data('bootstrapValidator').validate();
if($('#division_form').data('bootstrapValidator').isValid()){
	saveDivision();
}


});

</script>
<script>
 $('#divisioneditvalidation').bootstrapValidator({
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


$("#submitgrade").on("click", function(){
$('#divisioneditvalidation').data('bootstrapValidator').validate();
if($('#divisioneditvalidation').data('bootstrapValidator').isValid()){
	divisionedit();
}

});
</script>
<script src="resources/dist/js/sidebarmenu.js"></script>
  
 <%@include file="footer.jsp"%>