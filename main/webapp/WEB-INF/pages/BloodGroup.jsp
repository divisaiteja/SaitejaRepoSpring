<%@include file="header.jsp" %>
<script>
function forBgroupDeletion(){
	 $("#bgroup").on('click', '#deleteId', function() {
			var currentRow = $(this).closest("tr");
		    var tranid = currentRow.find("td:eq(0)").html(); 
		   
		   // alert(tranid);
		    
		    var retVal = confirm("would you like to delete this tranid "+tranid);
           if( retVal == true ) {
            //  document.write ("User wants to continue!");
              deletedSuccessfully(tranid);
           } else {
              //document.write ("User does not want to continue!");
           }
           bgroup();
	 });
}

function deletedSuccessfully(tranid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deletebgroup?tranid="+tranid, //this is my servlet

	        success: function(data){  
	        	
	        }
	  });
}
function fetchToBGroup(){
	 $("#bgroup").on('click', '#myid', function() {
		 
	var currentRow = $(this).closest("tr");

   var tranid = currentRow.find("td:eq(0)").html(); 
   
   var bloodgroup = currentRow.find("td:eq(1)").html();
  
     
   openEditBlood(tranid,bloodgroup);
   
   
  // alert(data);
	 });
}

</script>
<script>
$(document).ready(function() {
	  // Edit record
   
	$('#bgroup').dataTable( {
			 "ajax" : {
			"url" : "/DASHBOARD/getbgroup",
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
			"columns": [
							{ data: "tranid"},
			 				{ data: "bloodgroup"},
					 		
 							
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="image" src="resources/assets/images/edit-icon.png" height="25" width="25" id="myid"  onclick="fetchToBGroup()"  >   <input type="image" src="resources/assets/images/delete.png" id="deleteId" height="25" width="25"  onclick="forBgroupDeletion()">'
				            }
					],
		
		} );
	
} );
</script>
<div><h5>To Add New BloodGroup <input type="submit" class="save"  onclick="saveBlood()"  value="Click Here"></h5></div>
<table id="bgroup" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		 <th>Tranid</th>
                <th>BloodGroup</th>
              	<th>Action</th>
                
            </tr>
        </thead>
       
    </table>
    
    
     <!-- Modal -->
         <div class="modal fade" id="editEmpStatus" role="dialog">
		
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
       <form id="emp_status_form">
			<div class="modal-body">
				<div class="box-content row">
				
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">BloodGroup</label>
					<input type="text" id="bloodgroup" name="bloodgroup" class="form-control" placeholder="">
				</div>
				</div>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn btn-default"  id="emp_edit_btn" >Submit</button>
			</div>
			</form>
		</div>
		
		</div>
	</div>
	
	
    <script src="resources/dist/js/sidebarmenu.js"></script>
 <%@include file="footer.jsp"%>