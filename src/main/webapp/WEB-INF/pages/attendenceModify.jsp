<%@include file="header.jsp" %>



<script>
function getHrPunchData(date,idno){
$(document).ready(function() {
	var table=$('#myTab').dataTable({
			 destroy: true,
		    searching: true,
			 "ajax" : {
			"url" : "/HRMS/AttendenceModify?date="+date+"&idno="+idno,
			"dataSrc" : "dataBean",
			"type" : "GET",
			
		       },
		      
			"columns": [
							{ data: "idno"},
			 				{ data: "punchtime"},
			 				{ data: "ioflag"},
					 		{ data: "machineid"},
 							{ data: "punchtype"},
							{ data: "attdate"},
							{ data: "punchstatus"},
							{
				                data: null,
				                className: "center",
				                defaultContent: '<button id="attSelect" class="btn btn-success" onclick="openAttendenceModify()" >ADDPunch</button>'				            }
					],
		
		} );
	  
} );


}


</script>




<%
String date=request.getParameter("date");
int id=Integer.parseInt(request.getParameter("idno"));
System.out.println(date+id);
			%>

<input type="text" id="date" value="<%out.println(date);%>" hidden="hidden">
<input type="text" id="idno" value="<%out.println(id);%>" hidden="hidden">
<h3>HR punches</h3>
<table id="myTab" class="display" style="width:100%" border="1">
        <thead>
            <tr>
           		
                <th>idno</th>
                <th>PunchTime</th>
               <th>I/O Flag</th>
                <th>MachineID</th>
                <th>Punchtype</th>
                <th>AttendenceDate</th>
                <th>Punchstatus</th>
              	<th> Action</th>
                
            </tr>
        </thead>
       
    </table>
       
            <div align="right"><input type="submit" class="btn btn-primary" value="goBack" onclick="attsummary()">
            </div>
            
            
            
            <script>
$(document).ready(function() {
	var date=document.getElementById("date").value;
	var idno=document.getElementById("idno").value;
	getHrPunchData(date,idno);
} );
</script>
      	    <script src="resources/dist/js/sidebarmenu.js"></script>

<%@include file="footer.jsp" %>