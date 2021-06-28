<%@include file="header.jsp" %>
 <link rel="stylesheet" href="resources/bootstrapCSS/datepicker.css" />
      <script src="resources/customjs/bootstrap-datepicker.js"></script> 
<script>
 
$(function() {
	   $( "#datepicker-3" ).datepicker({
	      appendText:"(yy-mm-dd)",
	      dateFormat:"yy-mm-dd",
	      
	   });
	});
    
$(document).ready(function() {
	var date=new Date();
	var val=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+(date.getDate()-1);
	document.getElementById("date").value=val;
	 abcd(val);
} );
	</script>
	<script>
function dummy() {
	
	  $(document).ready(function() {
		  var val=document.getElementById("date").value;
		  abcd(val);
		} );
	 // alert(val);
	 
	
} 
	</script>
<script>
function abcd(val){
$(document).ready(function() {
	var table=$('#attendence').dataTable({
			 destroy: true,
		    searching: true,
			 "ajax" : {
			"url" : "/DASHBOARD/Attendencelist?date="+val,
			"dataSrc" : "dataBean",
			"type" : "GET",
			
		       },
		      
			"columns": [
							{ data: "tranId"},
			 				{ data: "idno"},
			 				{ data: "attdate"},
					 		{ data: "shifttime"},
 							{ data: "shiftid"},
							{ data: "inpunchCount"},
							{ data: "outpunchCount"},
							{
				                data: null,
				                className: "center",
				                defaultContent: '<input type="submit" id="attSelect" class="btn btn-success"  >'				            }
					],
		
		} );
	  
} );


}


</script>
<div>
 <!-- <div class="input-group">
 <input type="text" id="datepicker-3"  placeholder="">
           
                                </div> -->
Date:<input type="text" id="date" ><input type="submit" onclick="dummy()"></div>
<table id="attendence" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		 <th>tranId</th>
                <th>idNo</th>
               <th>attendanceDate</th>
                <th>shiftTime</th>
                <th>shiftId</th>
                <th>inPunchCount</th>
                <th>outPunchCount</th>
              	<th> Action</th>
                
            </tr>
        </thead>
       
    </table>
    
  <script>
function get(){
	alert();

}
</script>
<script>
$(document).ready(function(){
     $("#attendence").on('click', '#attSelect', function() {
      // get the current row
      var currentRow = $(this).closest("tr");
      var idno = currentRow.find("td:eq(1)").html(); // get current row 1st table cell TD value
      var date = currentRow.find("td:eq(2)").html(); // get current row 2nd table cell TD value
      openAttendenceModify(idno,date);
    });

 });
 

</script>
<script src="resources/dist/js/sidebarmenu.js"></script>
<%@include file="footer.jsp"%>