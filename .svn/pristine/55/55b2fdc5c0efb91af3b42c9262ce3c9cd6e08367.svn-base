<%@include file="header.jsp" %>

<link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >
<title>Holiday</title>
<script>
$(document).ready(function() {
	$.ajax({
		type: "GET",
		contentType : "application/json",
		url: "getallDivision", //this is my servlet

		success: function(data){ 
			var abc=data;
			var ele = document.getElementById('division');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML +
				'<option value="' + abc[i]["divisionid"] + '">' + abc[i]["name"] + '</option>';
			}

		}
	});
});
</script>
<script>
$(document).ready(function(){
	    $("#holidayeditsuccess").hide();
	    $("#Holidaysavemessage").hide();
});

$(function() {
	$("#SaveInfodate").datepicker({
		dateFormat:"yyyy-mm-dd"
	});
	$("#infodate").datepicker({
		dateFormat:"yyyy-mm-dd"
	});

});
</script>
<script>
 $("#holidays").on('click', '#HolidayDeleting', function() {
				var currentRow = $(this).closest("tr");
			    var tranid = currentRow.find("td:eq(0)").html(); 
			    var retVal = confirm("would you like to delete this tranid "+tranid);
	           if( retVal == true ) {
	            //  document.write ("User wants to continue!");
	              deletedSuccessfully(tranid);
	           } else {
	              //document.write ("User does not want to continue!");
	           }
	         
		 });
	

	function deletedSuccessfully(tranid){
		 $.ajax({
		        type: "post",
		        contentType : "application/json",
		        url: "deleteholiday?tranid="+tranid, //this is my servlet
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
$(document).ready(function() {
	$('#holidays').dataTable( {
			 "ajax" : {
			"url" : "/HRMS/getallholiday",
			"dataSrc" : "dataBean",
			"type" : "GET",
		},
			"columns": [
							{ data: "tranid"},
			 				{ data: "infodate"},
			 				{ data: "reasonforholiday"},
			 				{ data: "alloweddivisions"},
					 		{ data: "statusCodeForActive"},
 							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/delete.png" height="15" width="15" id="HolidayDeleting" >'
				            }
					],
		
		} );
	
} );
</script>
<script>
	$("#holidays").on('click','#HolidayEditing',function() {
						var currentRow = $(this).closest("tr");
						var rowData = $("#holidays").DataTable().row(currentRow).data();
                        var tranid = rowData.tranid;
						retrieve:true,
								$.ajax({
										contentType : "application/json",
										"url" : "/HRMS/getHolidayBytranId?tranid="+ tranid,
											"dataSrc" : "dataBean",
											"type" : "GET",

											success : function(data) {
												for (var i = 0; i < data.length; i++) {
													$("#tranid").val(data[i].tranid);
													$("#infodate").val(data[i].infodate);
													$("#reasonforholiday").val(data[i].reasonforholiday);
													$("#alloweddivisions").val(data[i].alloweddivisions);
													$("#isactive").val(data[i].isactive);
													}
                                       selectedRecord = data;

											},

										});

						$('#HolidayTypeModal').modal('show');

					});
	</script>
	<script>
function editHoliday(){
	
                         var editHoliday = {};                   
                        editHoliday["tranid"] = $("#tranid").val();
                        editHoliday["infodate"] = $("#infodate").val();
                        editHoliday["reasonforholiday"] = $("#reasonforholiday").val();
                        editHoliday["alloweddivisions"] = $("#alloweddivisions").val();
                        editHoliday["isactive"] = $("#isactive").val();
						$.ajax({
							type : "post",
							contentType : "application/json",
							url : "editHolidays", //this is my servlet
							data : JSON.stringify(editHoliday),
							success : function(data) {
								 $("#holidayeditsuccess").show();
								 $("#editholidaymessage").html(data["successMessage"]);
						           setInterval(function(){
						        	window.location.reload(); // this will run after every 5 seconds
						        }, 2000);  
								
							}
						});
}
	
</script>
<script>
function saveHolidays(){
	
		var saveHoliday = {};
		saveHoliday["infodate"] = $("#SaveInfodate").val();
		saveHoliday["reasonforholiday"] = $("#Reason").val();
		saveHoliday["alloweddivisions"] = $("#division").val();
		
		$.ajax({
			type: "post",
			contentType : "application/json",
			url: "saveHoliday", //this is my servlet
			data : JSON.stringify(saveHoliday),
			success: function(data){ 
				 $("#Holidaysavemessage").show();
				$("#Holidaysave").html(data["successMessage"]);
		        setInterval(function(){
		        	window.location.reload(); // this will run after every 5 seconds
		        }, 2000);
			}
		});
	}

</script>
</head>
<body>
<div>
<h5 align="center">
		To Add New Holiday <a data-toggle="modal"
			data-target="#modelholidays" id="" onclick="" href="#">Click
			Here</a>
	</h5>	
	<h5 align="center" id="deletemessage" style="color:red"></h5>
</div>
<table id="holidays" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		<th>TranId</th>
                <th>InfoDate</th>
                <th>Reason</th>
               <th>Divisions</th>
                <th>Status</th>
                <th>Action</th>
             </tr>
        </thead>
       
    </table>
    
   <!-- *************************Edit Holiday model box ****************************-->
   
    <div class="wrapper-editor" style="color: #fb8c00">
	<div class="modal fade modalEditClass" id="HolidayTypeModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div align="center">
			<div class="alert alert-success " id="holidayeditsuccess" style="text-align:center">
  		<strong id="editholidaymessage" ></strong> 
		</div>
			</div>
			<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold text-secondary ml-5">Holiday Edit
						form</h4>
					<button type="button" class="close text-secondary"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			<form id = "editholidayvalidation">
				<div class="modal-body mx-3">
					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="gradeno">TranId</label>
						<input type="text" id="tranid" name="tranid" class="form-control"
							readonly="readonly">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="infodate">InfoDate</label>
						<input type="text" id="infodate" name="infodate" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label class="control-label" for="inputWarning1">Reason</label>
						<input type="text" id="reasonforholiday" name="reasonforholiday" class="form-control">
					</div>
	              <div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="cadrecode">AllowedDivision</label>
						<input type="text" id="alloweddivisions" name="alloweddivisions" class="form-control">
					</div>

					<div  class="form-group has-warning col-md-12">
						<label data-error="wrong" data-success="right" for="isactive">Status</label>
						<input type = "text"  id="isactive" name="isactive" class="form-control">
					
					</div>
					<div align="center">
					<button type="button"id="editsubmitholiday" class="btn btn-primary" >
						Submit
					</button> 
					</div>
				</div>				
				
				</form>
			</div>
		</div>
	</div>
</div>
   
   <!--****************************** Holiday Save  model box***************************--> 
    
    <div class="modal fade" id="modelholidays" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
		
		<div class="modal-header">
		   <div class="container">
		   <h4 align="center" style="color: #0B1907" class="modal-title" >Adding New Holiday</h4>
		   </div>
			<button type="button"  class="close"  data-dismiss="modal">&times;</button>
			</div>
			<div align="center">
			<div class="alert alert-success " id="Holidaysavemessage" style="text-align:center">
  		    <strong id="Holidaysave" ></strong> 
		    </div>
			</div>
          <form id="saveholidayvalidation">
			<div class="modal-body">
				<div class="box-content row">
					<div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">InfoDate</label> <input
							type="text" id="SaveInfodate" name="SaveInfodate" class="form-control">
					</div>
                    
                    <div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">ReasonForHoliday</label> <input
							type="text" id="Reason" name="Reason" class="form-control">
					</div>
                    
                    <div class="form-group has-warning col-md-4">
						<label class="control-label" for="inputWarning1">AllowedDivisions</label> 
						<select  id="division" name="division" class="form-control">
						<option value="">select</option>
						</select>
					</div>
                    
				</div>
                 
			</div>
			
			<div class="modal-footer">
			<div class ="container" align="center">
				<button type="button" class="btn btn-default"  id="submitsaveholiday">Submit</button>
			</div>
			</div>
			</form>
		</div>
	</div>
	</div>
	<%@include file="footer.jsp"%>
  <script src="resources/validation/bootstrapValidator.min.js"></script>
<script>
 $('#saveholidayvalidation').bootstrapValidator({
            //container: '#messages',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
            	 SaveInfodate: {
                     validators: {
                         notEmpty: {
                             message: 'Infodate is required ',
                          },
                        }
                  },
                  Reason: {
                      validators: {
                          notEmpty: {
                              message: 'Reason is required ',
                           },
                         }
                   },
                   division: {
                       validators: {
                           notEmpty: {
                               message: 'AllowedDivision is required ',
                            },
                          }
                    },
             }
         });
        $("#submitsaveholiday").click(function(){
$('#saveholidayvalidation').data('bootstrapValidator').validate();
if($('#saveholidayvalidation').data('bootstrapValidator').isValid()){
	saveHolidays();
}
});
</script>

<script>
$('#editholidayvalidation').bootstrapValidator({
    //container: '#messages',
     feedbackIcons: {
         valid: 'glyphicon glyphicon-ok',
         invalid: 'glyphicon glyphicon-remove',
         validating: 'glyphicon glyphicon-refresh'
     },
     fields: {
     
    	 infodate: {
             validators: {
                 notEmpty: {
                     message: 'Infodate is required ',
                  },
                }
          },
          
          reasonforholiday: {
              validators: {
                  notEmpty: {
                      message: 'Reason is required ',
                   },
                 }
           },
           
           alloweddivisions: {
               validators: {
                   notEmpty: {
                       message: 'Division is required ',
                    },
                  }
            },
          isactive: {
              validators: {
                  notEmpty: {
                      message: 'IsActive is required ',
                   },
                 }
           },
     }

 });
$("#editsubmitholiday").click(function(){
$('#editholidayvalidation').data('bootstrapValidator').validate();
if($('#editholidayvalidation').data('bootstrapValidator').isValid()){
	editHoliday();
}
});
</script>
<script>
jQuery('#SaveInfodate').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#infodate').datepicker({
    autoclose: true,
    todayHighlight: true
});
</script>
</body>
<script src="resources/dist/js/sidebarmenu.js"></script>
</html>