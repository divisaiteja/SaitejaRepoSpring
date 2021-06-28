<%@page import="com.hrms.utitlities.DBUtil,java.sql.*"%>
<script src="resources/customjs/jquery-1.10.2.js"></script>
<%@include file="header.jsp"%>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid black;
	text-align: left;
	padding: 6px;
}
</style>

<script>
$(document).ready(function() {
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/HRMS/getDropdowns", //this is my servlet
          success: function(data){ 
          	var abc=data;
//             for (var i = 0; i < abc.length; i++) {
//                 // POPULATE SELECT ELEMENT WITH JSON.
//                 ele.innerHTML = ele.innerHTML +
//                     '<option value="' + abc[i]["description"] + '">' + abc[i]["description"] + '</option>';
//             }
            getDataFromAnother(abc)
        }
 });
});

$(document).ready(function() {
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/HRMS/getDropdownsForI", //this is my servlet
          success: function(data){ 
          	var abc=data;
        	
        	var ele = document.getElementById('punchTypesI');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                ele.innerHTML = ele.innerHTML +
                    '<option value="' + abc[i]["punchcode"] + '">' + abc[i]["description"] + '</option>';
            }
        }
 });
});


function getDataFromAnother(abc){
	
 $(document).ready(function() {
 var date=document.getElementById("date").value;
	 var idno=document.getElementById("idno").value;
 	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/HRMS/displayHrPunches?idno="+idno+"&date="+date, //this is my servlet
          success: function(data){ 
	     	var json=data;
        	 var tr;
        	 var ele='<option value="">select</option>';
        	 for (var i = 0; i < abc.length; i++) {
                 // POPULATE SELECT ELEMENT WITH JSON.
                 ele = ele +
                     '<option value="' + abc[i]["punchcode"] + '">' + abc[i]["description"] + '</option>';
             }
        	 for (var i = 0; i < json.length; i++) {
                 tr = $('<tr/>');
                 
                 tr.append("<td>" + json[i].tranid + "</td>");
                 tr.append("<td>" + json[i].punchtime + "</td>");
                 tr.append("<td>" + json[i].ioflag + "</td>");
                 tr.append("<td>" + json[i].attdate + "</td>");
                 tr.append("<td>" + json[i].remarks + "</td>");
                 tr.append("<td>" + json[i].punchstatus + "</td>");
                 if(json[i].punchstatus=="DL"){
            	   tr.append("<td>" + "----------" + "</td>");
               }
               else{
                 tr.append("<td>" + "<select name='sweets' id='sravan'>"+ele+"</select>" + "</td>");
               }                
                 $('table').append(tr);
             }
        	
        }
 });			
 } );
}
</script>

<%
					
String date=request.getParameter("date");
String shiftname=request.getParameter("shiftname");
String empname=request.getParameter("empname");
String designation=request.getParameter("designation");
String depname=request.getParameter("depname");
int idno=Integer.parseInt(request.getParameter("idno"));
int attendid=Integer.parseInt(request.getParameter("attendid"));
String project = request.getParameter("project");
String division = request.getParameter("division");
%>
<div></div>


<script>

$(document).ready(function() {
//$( "#sravan" ).change(function () {
    $("#hrpunchtable").on('change', '#sravan', function() {
    	var modifyType = $(this).val(); //geting data from dropdown
       // //alert(modifyType)
		var currentRow = $(this).closest("tr");
	    var tranid = currentRow.find("td:eq(0)").html(); 
	    var punchtime = currentRow.find("td:eq(1)").html(); 
	    var ioflag = currentRow.find("td:eq(2)").html(); 
	    var attdate = currentRow.find("td:eq(3)").html(); 
	    var punchstatus = currentRow.find("td:eq(4)").html(); 
	    if(modifyType!=""){
	    	////alert("going for update");	    
	    	 $.ajax({
	 	        type: "post",
	 	         //  url: "updateHrPunchCodes.jsp?tranid="+tranid+"&modifyType="+modifyType+"&attdate="+attdate, 
	 	            url:"updateHrPunchCodes?tranid="+tranid+"&modifyType="+modifyType+"&attdate="+attdate,  
	 	    		   success: function(data){ 
	 	        	////alert(data);
	 	    		window.location.reload();
	 	        }
	 	 });
	    
	    }else{
	    	//alert("sorry");
	    }
    });
   // });
  });

  
  function validateAtts(){
	  var date=document.getElementById("date").value;
	  validateAtt(date)
  }
  
  
  
  function AddManualPunch(){
	 var punchtypes= document.getElementById("punchTypesI").value ;
	 //alert(punchtypes);
	 var date=document.getElementById("date").value;
	 var idno=document.getElementById("idno").value;
	 var shiftname=document.getElementById("shiftname").value;
	 var empname=document.getElementById("empname").value;
	 var designation=document.getElementById("designation").value;
	 var depname=document.getElementById("depname").value;
	 var remarks = "";
	 var attendid=document.getElementById("attendid").value;
	 //alert(punchtypes+date+idno);
	 
	 if(punchtypes!=""){
                 
		 $.ajax({
	 	        type: "post",
	 	       // url: "AddHrPunchCodesForI.jsp?idno="+idno+"&punchtypes="+punchtypes+"&date="+date,
	 	        url: "AddHrPunchCodesForI?idno="+idno+"&punchtypes="+punchtypes+"&date="+date+"&shiftcode=0&remarks="+remarks,
	 	        		success: function(data){ 
	 	        	//alert(data);
	 	        	//displayHrpunches(date,idno,shiftname,empname,designation,depname,attendid);
	 	    		//validateAtt(attdate)
	 	    		window.location.reload();
	 	  // window.location.href='#/displayhrpunches/'+date+'/'+idno+'/'+shiftname+'/'+empname+'/'+designation+'/'+depname+'/'+attendid;

	 	        }
	 	 });
		 
	 }
	 else{
		 //alert("improper selection");
	 }
	
  }
  

 

  
  
  
</script>
 <input
			type="text" id="division" hidden="hidden" value="<%out.println(division);%>">
 <input
			type="text" id="project" hidden="hidden" value="<%out.println(project);%>">
<div class="row">
	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">idno</label> <input
			type="text" id="date" hidden="hidden" value="<%out.println(date);%>">
		<input type="text" id="idno" value="<%out.println(idno);%>"
			class="form-control" readonly="readonly">
	</div>
	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">empname</label> <input
			type="text" id="empname" value="<%out.println(empname);%>"
			class="form-control" readonly="readonly">
	</div>
	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">depname</label> <input
			type="text" id="depname" value="<%out.println(depname);%>"
			class="form-control" readonly="readonly">
	</div>
	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">Designation</label> <input
			type="text" id="designation" value="<%out.println(designation);%>"
			class="form-control" readonly="readonly">
	</div>
	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">shiftname</label> <input
			type="text" id="shiftname" value="<%out.println(shiftname);%>"
			class="form-control" readonly="readonly">
	</div>
	<div class="form-group has-warning col-md-2">
		<label class="control-label" for="inputWarning1">attendid</label> <input
			type="text" id="attendid" value="<%out.println(attendid);%>"
			class="form-control" readonly="readonly">
	</div>
</div>
<hr>


<div align="right">
	<select id="punchTypesI" onchange="AddManualPunch()">
		<option value="">select</option>
	</select>
</div>
<div class="table-responsive">
	<table id="hrpunchtable">
		<thead class="thead-light">
			<tr>

				<th>TranId</th>
				<th>PunchTime</th>
				<th>IoFlag</th>
				<th>AttDate</th>
				<th>Remarks</th>
				<th>PunchStatus</th>
				<th>Check</th>

			</tr>

		</thead>
		<tbody>
		</tbody>
	</table>
	
</div><br>
<div align="right">
<input type="submit" onclick="back()" value="goback" class="btn btn-primary">
</div>

<script>
function back(){
var date=document.getElementById("date").value;
var project=document.getElementById("project").value;
var division=document.getElementById("division").value;
window.location.href ="#/attendance/" +date+"/"+project+"/"+division;
	
}
</script>


<!--The SELECT element.-->

<!--The SELECT element.-->

<script src="resources/dist/js/sidebarmenu.js"></script>

<%@include file="footer.jsp"%>
