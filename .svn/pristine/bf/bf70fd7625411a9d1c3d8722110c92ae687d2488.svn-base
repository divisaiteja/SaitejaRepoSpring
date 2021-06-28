<%@include file="header.jsp" %>
 
<style>
.mycustom{


}


</style>

  <script>

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallproject", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('project');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML + '<option value="'
						+ abc[i]["tranid"] + '">'
						+ abc[i]["projectname"] + '</option>';
			}

		}
	});
});

$(document).ready(function() {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "getallDivision", // this is my servlet

		success : function(data) {
			var abc = data;
			var ele = document.getElementById('division');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
			ele.innerHTML = ele.innerHTML + '<option value="'+ abc[i]["divisionid"] + '">' + abc[i]["name"]+ '</option>';								
			
			}

		}
	});
});

  $( function() {
    $( "#date1" ).datepicker({
    	 dateFormat:"dd-mm-yyyy", 
    	      
    });
   
  } );
  

  
  </script>
  <script>
 function getAttendenceData(){
	
 }
  </script>
</head>
<body>
            
     <div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
			<h3 align="center" style="color: #fb8c00">Attendance Listing Page</h3>
            </div>
            <hr color="00FFFF">
            
			<div class="box-content row">

				<div class="form-group has-warning col-md-3">
					<label style="color: Blue" class="control-label" for="inputWarning1">Division
						</label> <select class="form-control" id="division" name="division"  style="border:1px solid #696969;">
						<option value="">select</option>
					</select>
				</div>
				


				<div class="form-group has-warning col-md-3">
					<label  style="color: Blue"  class="control-label" for="inputWarning1">Project</label><br>
					<select class="form-control" id="project" name="project" style="border:1px solid #696969;">
						<option value="">select</option>

					</select>
				</div>				
				
				<div class="form-group has-warning col-md-3"  >
                                    <label style="color: Blue"   class="control-label" for="inputWarning1">Date </label> <br><input type="text" placeholder="YYYY-MM-DD"   id="date1" class="form-control" style="border:1px solid #696969;">
                                               
		      </div>
			</div>
			 <div align="center">
			       <input type="submit"  value="Show" onclick="submit()" style="background-color: blue;color:white"	class="btn btn-primary"   >
		      </div>
		</div>
	</div>
</div>
              
<!--<br><h3 id="msg" align="center" style="color:red"></h3>-->


 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
         
        </div>
        <div class="modal-body">
        <input type="text" id="modalboxidno">
        <input type="text" id="punchcode" value="3" readonly="readonly">
         <select id="shiftId">
        
          </select>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal"   id="addManualPunch" >Submit</button>
        </div>
      </div>
      
    </div>
  </div>

      	    <script src="resources/dist/js/sidebarmenu.js"></script>
<%@include file="footer.jsp" %>
<script>
function submit(){
var date=document.getElementById("date1").value;
var project=document.getElementById("project").value;
var division=document.getElementById("division").value;
//window.location.href = "#/attendance/"+date+"/"+project;
window.location.href= "#/attendance/"+date+"/"+project+"/"+division;
}
</script>
<script>
jQuery('#date1').datepicker({
    autoclose: true,
    todayHighlight: true
});
</script>