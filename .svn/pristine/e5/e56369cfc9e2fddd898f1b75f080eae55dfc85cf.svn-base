
<%@include file="header.jsp"%>
<%@page import="com.hrms.utitlities.DBUtil,java.sql.*"%>
 <link rel="stylesheet" href="resources/bootstrapCSS/datepicker.css" />
 <script src="resources/customjs/bootstrap-datepicker.js"></script> 
<style>



</style>

<script>

$(document).ready(function() {
	/* Not selected */
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getAllHrShifts", //this is my servlet
     
       success: function(data){ 
       	var abc=data;
       	var ele = document.getElementById('shiftId');
           for (var i = 0; i < abc.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["shiftid"] + '">' + abc[i]["name"] + '</option>';
           }
       	
       }
});
});

$( function() {
    $( "#date1" ).datepicker({
    	 dateFormat:"dd-mm-yy", 
    });
  } );
  
$(document).ready(function() {
    $('#example').DataTable();
} );

function govalidateAtt(){
	  var str =document.getElementById("date1").value;
// 	  var month = str.substring(0, 2);
// 	   var subdate = str.substring(3, 5);
// 	   var year = str.substring(6, 10);
// 	   var date=year+"-"+month+"-"+subdate;
var  date=str;
	   alert(date);
	  //validateAtt(date)
	  window.location.href='#/attendance/'+date;
}
</script>

<%
String date=request.getParameter("date");
%>
<script>


// 	 var str =document.getElementById("date1").value;
// 	  var month = str.substring(0, 2);
// 	   var subdate = str.substring(3, 5);
// 	   var year = str.substring(6, 10);
// 	   var date=year+"-"+month+"-"+subdate;
// 	   alert(date);
 $(document).ready(function() {
 var date=document.getElementById("date").value;
 	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/DASHBOARD/validateAttendence?date="+date, //this is my servlet
          success: function(data){ 
	     	var json=data;
        	 var tr;
        	 var ele='<option value="">select</option>';
        		 for (var i = 0; i < json.length; i++) {
        			 if(json[i].inpunchcount!=json[i].outpunchcount){
        				tr = $('<tr style="background-color: #f38b8b"/>');
        			 }
        			 else{
        				tr = $('<tr/>');
        			 }
             //    alert(json[i].employee.employeeName)
                  tr.append("<td>" + json[i].employee.idNumber + "</td>");
                  tr.append("<td>" + json[i].employee.employeeName + "</td>");
                  tr.append("<td>" + json[i].attendid + "</td>");
                  tr.append("<td>" + json[i].employee.design + "</td>");
                  tr.append("<td>" + json[i].departments.name + "</td>");
                  tr.append("<td>" + json[i].employeeDisplaystatus + "</td>");
                  tr.append("<td>" + json[i].shifts.name + "</td>");
                  tr.append("<td>" + json[i].inpunchcount + "</td>");
                  tr.append("<td>" + json[i].outpunchcount + "</td>");
                  tr.append("<td>" + json[i].duration + "</td>");
                  tr.append("<td>" + json[i].overtime + "</td>");
                  tr.append("<td><input type='image' src='resources/assets/images/edit-icon.png' height='20' width='20'  id='attid' ></td>");
                  tr.append("<td><button type='button' data-toggle='modal' data-target='#myModal' id='shiftid'>AssignShift</button></td>");
//   
			              
//                  tr.append("<td>" + json[i].attdate + "</td>");
//                  tr.append("<td>" + json[i].punchstatus + "</td>");
//                  if(json[i].punchstatus=="DL"){
//             	   tr.append("<td>" + "----------" + "</td>");
//                }
//                else{
//                  tr.append("<td>" + "<select name='sweets' id='sravan'>"+ele+"</select>" + "</td>");
//                }                
                 $("#examples").append(tr);
             }
        	
        }
 });			
 } );
 





$(document).ready(function(){
	 $("#examples").on('click', '#attid', function() {
	var currentRow = $(this).closest("tr");
   var idno = currentRow.find("td:eq(0)").html(); 
   var shiftname = currentRow.find("td:eq(6)").html(); 
   alert(shiftname);
   var empname = currentRow.find("td:eq(1)").html(); 
   var attendid = currentRow.find("td:eq(2)").html(); 
   var designation = currentRow.find("td:eq(3)").html(); 
   var depname = currentRow.find("td:eq(4)").html(); 
   var date=document.getElementById("date").value
   
  
// displayHrpunches(date,idno,shiftname,empname,designation,depname,attendid)
 
 window.location.href='#/displayhrpunches/'+date+'/'+idno+'/'+shiftname+'/'+empname+'/'+designation+'/'+depname+'/'+attendid;
  
	 });
});


$(document).ready(function(){
	
	 $("#examples").on('click', '#shiftid', function() {
	var currentRow = $(this).closest("tr");
	var date=document.getElementById("date").value
  	var idno = currentRow.find("td:eq(0)").html(); 
  	alert(idno+date);
  	document.getElementById("modalboxidno").value=idno;
//displayHrpunches(date,idno,shiftname,empname,designation,depname,attendid)
 
	 });
});

$(document).ready(function() {
    $("#addManualPunch").on('click', function() {
	var date=document.getElementById("date").value;
  	var idno = document.getElementById("modalboxidno").value;
	var punchcode=document.getElementById("punchcode").value;
  	var shiftId =  document.getElementById("shiftId").value;
  	alert(shiftId);
  	 $.ajax({
	        type: "post",
	       // url: "AddHrPunchCodesForI.jsp?idno="+idno+"&punchtypes="+punchtypes+"&date="+date,
	        url: "AddHrPunchCodesForI?idno="+idno+"&punchtypes="+punchcode+"&date="+date+"&shiftcode="+shiftId,

	        		success: function(data){ 
	        	//alert(data);
	    		//validateAtt(date)
	    		window.location.reload();
	        }
	 });
    });
});


</script>
<script>

</script>
<%

// Statement stmForHr=con.createStatement();
// String hrmusterdataquery="select hre.idno,hs.name,h.attendid,hre.empname,hre.desgn,hrd.name,h.inpunchcount,h.outpunchcount,h.duration,h.overtime from hr_muster h"+
// " left join hr_shifts hs on hs.shiftid=h.attendid"+ 
// " left join hr_empmaster hre on hre.idno=h.idno"+
// " left join hr_department hrd on hrd.deptid=hre.workdeptid where h.attdate='"+date+"'";
// ResultSet resultForHr=stmForHr.executeQuery(hrmusterdataquery);

%>
<input type="text" id="date" value="<%=date%>" hidden="hidden">
<h4 align="right" style="color:red">Selected Date: <%=date%> </h4>
Attendence For:<input type="text" id="date1"> 
<input type="submit" value="Check" onclick="govalidateAtt()" style="background-color: blue;color:white	">
     			
     		<br><br><br><h3 align="center">Attendence</h3>	
     			<div class="search-table-outter wrapper">
     				<table class="mycustom" width="100%" id="examples"  overflow:auto border="1px solid  black">
                                        <thead>
                                            <tr >
                                               <th ><b>IdNumber</b></th>
                                                 <th><b>EmployeeName</b></th>
                                                <th><b>attendId</b></th>
                                                <th><b>Designation</b></th>
                                                <th><b>DepartmentName</b></th>
                                                  <th><b>Status</b></th>
                                                <th><b>ShiftName</b></th>
                                                <th><b>Inpunch</b></th>
                                                <th><b>OutPunch</b></th>
                                                 <th><b>duration</b></th>
                                                <th><b>O.T</b></th>
                                                <th><b>Action</b></th>
                                                <th><b>AssignShift</b></th>
                                                
                                            </tr>
                                           
                                            
                                           
                                           
                                           
                                        </thead>
                                        <tbody>
                                      
                                       
                                        
                                        </tbody>
                </table>
                       </div>                  
           <%//con.close(); %>                


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

