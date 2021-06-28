<!-- Script for save division -->
 <link rel="stylesheet" type="text/css" href="resources/validation/validation.css" >

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
	/*saveDivision["serialno"] = $("#serialno").val();
	saveDivision["parentid"] = $("#parentid").val(); */
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "saveNewDivision", //this is my servlet
	        data : JSON.stringify(saveDivision),
//	        
	        success: function(data){ 
	        	
	        	$('#processedData').html(data.successMessage);
				$('#displayDiv').show();
	        	
				division();
	        }
	 });
}
</script>
<div id="displayDiv">
	<h3 id="processedData" align="center" style="color: red"></h3>
</div>
<div class="row">
	<div class="box col-md-12">
	<form id="divison_form">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-info-sign"></i> New Division
				</h2>


			</div>
			
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
		<div align="center">
			<input type="button" class="btn btn-success btn-primary" id="divison_submit" value="Submit">
		</div>
</form>
</div>
</div>
 <%@include file="footer.jsp"%>
<script src="resources/dist/js/sidebarmenu.js"></script>
<script src="resources/validation/bootstrapValidator.min.js"></script>

<script>
$('#divison_form').bootstrapValidator({
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
                    message: 'Name is required ',
                }
            }
        },
        address: {
            validators: {
                notEmpty: {
                    message: 'Address is required ',
                }
            }
        },
        city: {
            validators: {
                notEmpty: {
                    message: 'City is required ',
                }
            }
        },
        statecode: {
            validators: {
                notEmpty: {
                    message: 'Code required ',
                }
            }
        },
        pannumber: {
            validators: {
                notEmpty: {
                    message: 'Pancard required ',
                }
            }
        },
        gstn: {
            validators: {
                notEmpty: {
                    message: 'GSTN is required ',
                }
            }
        },
        contactno: {
            validators: {
                notEmpty: {
                    message: 'Mobile required ',
                }
            }
        },
        emailid: {
            validators: {
                notEmpty: {
                    message: 'Email is required ',
                }
            }
        },
        estddate: {
            validators: {
                notEmpty: {
                    message: 'Date is required ',
                }
            }
        },
        regionid: {
            validators: {
                notEmpty: {
                    message: 'Region is required ',
                }
            }
        },
        zoneid: {
            validators: {
                notEmpty: {
                    message: 'Zone is required ',
                }
            }
        },
        areaid: {
            validators: {
                notEmpty: {
                    message: 'Area is required ',
                }
            }
        },
        
     }

});
</script>
<script>

$("#divison_submit").on("click", function(){
$('#divison_form').data('bootstrapValidator').validate();
if($('#divison_form').data('bootstrapValidator').isValid()){
saveDivision();
}

});
</script>
