<%@include file="header.jsp" %>
<link rel="stylesheet" href="resources/bootstrapCSS/datepicker.css" />
 <script src="resources/customjs/bootstrap-datepicker.js"></script> 
<script>
$(function() {
	$("#date").datepicker({
		dateFormat:"yy-mm-dd"
	});
});


$(document).ready(function() {
	/* Not Selected */
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
function getList(division) {
	commonFunctionForList(division);
}
	
function commonFunctionForList(division) {
	var division=document.getElementById("division").value;
	alert("getList>>>>>>"+division);
	 $.ajax({
			"url" : "/DASHBOARD/getAllEmployeeAndDepartment?division="+division,
			 success : function(data, textStatus, jqXHR) {
		 	        var table_data = data.dataBean;
		 	       // alert(table_data[punchcod]);
		 	        var table = $('#employeedivision').DataTable( {
		 	        	"destroy": true,
		 	            data: table_data,
		 	            //dataSrc:data,
		 	            //"dataSrc" : "data",
			"columns": [
							{ data: "idNumber"},
			 				{ data: "employeeName"},
			 				{ data: "design"},
			 				{ data: "hrDepartmentMaster.name"},
					 		
							
							{
				                data: null,
				                className: "center",
				                defaultContent: '<button id ="" type ="button" color="green" >OT</button> <input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id=""  onclick="fetchToBGroup()"  >   <input type="image" src="resources/assets/images/save-icon.png" id="" height="25" width="25"  onclick="()">'
				            }
					],
		
		} );
	
			 }
	 })
}
</script>
<div>
	<h3 align="center" style="color: #fb8c00">EmployeeOTEntry</h3>
</div>
<hr color="00FFFF">
<div class="box-content row">
<div class="form-group has-warning col-md-3">
					<label class="control-label" for="inputWarning1">Division
						</label>
                    <select class="form-control" id="division" onchange="getList()">
						<option value="">select</option>

					</select>

				</div>

				<div class="form-group has-warning col-md-2">
					<label class="control-label" for="inputWarning1">Date
						</label> <input type="text" id="date" class="form-control">

				</div>
				</div>

<hr color="00FFFF">

<div>
<table id="employeedivision" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           	    <th>idNumber</th>
                <th>employeeName</th>
                <th>Designation</th>
                <th>Department</th>
              	<th>OT Hours</th>
                
            </tr>
        </thead>
       
    </table>
</div>
<%@include file="footer.jsp" %>