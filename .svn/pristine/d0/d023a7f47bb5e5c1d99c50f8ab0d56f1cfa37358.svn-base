<%@include file="header.jsp" %>

      <link rel="stylesheet" type="text/css"
	href="resources/validation/validation.css"> 
<script>
$(document).ready(function(){
	 
    $("#warnings").hide();
    $("#success").hide();
    
 
});
function cal(){
	 var fromdate = document.getElementById("fromdate").value;
   var todate = document.getElementById("todate").value;
   var fhalfday=document.getElementById("fhalfday").value;
   var thalfday=document.getElementById("thalfday").value;
   var idno=document.getElementById("idNumber").value;
	////alert(fromdate+todate+fhalfday+thalfday+idno);
	$.ajax({
      type: "GET",
      contentType : "application/json",
      url: "countingLeaves?fromdate="+fromdate+"&&todate="+todate+"&&fhalfday="+fhalfday+"&&thalfday="+thalfday+"&&idno="+idno, 		//this is my servlet

      success: function(data){  
      	 $("#noofdays").val(data);

      }
});

	}
	
function calculationForEditLeaves(){
	 var calNoOfDays=$("#noofdays").val();
		var calcltype=$("#cl").val();
		var calsltype=$("#sl").val();
		var caleltype=$("#el").val();
		var calcotype=$("#co").val();
		var calleavetype=$("#sel").val();
		if(calleavetype=="1"){
			if(parseFloat(calNoOfDays) >  parseFloat(calcltype)){
				 $("#msg").html("Warning! You don't Have enough CL's goto ListTable");
				 $("#warnings").show();
			}
			else{
				leaveEdit();
			}
		}
		if(calleavetype=="2"){
			if(parseFloat(calNoOfDays) > parseFloat(calsltype)){
				$("#msg").html("Warning! You don't Have enough SL's goto ListTable");
				 $("#warnings").show();
			}
			else{
				leaveEdit();
			}
		}
		if(calleavetype=="3"){
			if(parseFloat(calNoOfDays)>parseFloat(caleltype)){
				$("#msg").html("Warning! You don't Have enough El's goto ListTable");
				 $("#warnings").show();			
			}
			else{
				leaveEdit();
			}
		}
		if(calleavetype=="4"){
			if(parseFloat(calNoOfDays)>parseFloat(calcotype)){
				$("#msg").html("Warning! You don't Have enough Comp offs's goto ListTable");
				 $("#warnings").show();
			}
			else{
				leaveEdit();
			}
		}
	 	
	 }
	
	$(document).ready(function() {
	var leavetypeid;

	var transid=document.getElementById("transid").value;
	var idno=document.getElementById("idNumber").value;
    var selectedRecord;
	$.ajax({
		
	    type: "GET",
	    contentType : "application/json",
	    url: "/HRMS/getleaverecord?transid="+ transid, //this is my servlet
	    success: function(data){ 
	    	////alert(data["reasonforleave"]);
	    	selectedRecord = data;
	    	$("#transid").val(data["transid"]);
	    	$("#sel").val(data["leavetypeid"]);
	    	$("#fromdate").val(data["fromdate"]);
	    	$("#fhalfday").val( data["fhalfday"]);
	    	$("#todate").val(data["todate"]);
	    	$("#thalfday").val(data["thalfday"]);
	    	$("#noofdays").val(data["noofdays"]);
	    	$("#reasonforleave").val(data["reasonforleave"]);
	    	$("#idNumber").val(data["idno"]);

	    }
	});
	
		//var idno = document.getElementById("idNumber").value;
		$.ajax({
			
		    type: "GET",
		    contentType : "application/json",
		    url: "/HRMS/getleavebalance?idno=" +idno, //this is my servlet
		    success: function(data){ 
		      	var clval = parseFloat(data[0]).toFixed(1);
		    	document.getElementById("cl").value=clval;
		    	var slval = parseFloat(data[1]).toFixed(1);
		    	document.getElementById("sl").value=slval;
		    	var elval = parseFloat(data[2]).toFixed(1);
		    	document.getElementById("el").value=elval;
		    	var coval = parseFloat(data[3]).toFixed(1);
		    	document.getElementById("co").value=coval;
		    }
		});
	
	
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/HRMS/getleavetype", //this is my servlet
      
        success: function(data){ 
        	////alert(data[1].leavetype);
        	var abc=data;
        	var ele = document.getElementById('sel');
        	var options = '';;
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                options = options +
                    '<option value="' + abc[i]["transid"] + '" ' + (selectedRecord && selectedRecord.leavetypeid === abc[i]["transid"] ? "selected" : "" ) + '>' + abc[i]["leavetype"] + '</option>';
            }
            ele.innerHTML = options;
        	
        }
 });
	function show(ele) {
	    // GET THE SELECTED VALUE FROM <select> ELEMENT AND SHOW IT.
	    var msg = document.getElementById('msg');
	    msg.innerHTML = 'Selected LeaveType: <b>' + ele.options[ele.selectedIndex].text + '</b> </br>';
	}

	function populateSelect(){
		var a=document.getElementById("sel").value;
		////alert(a);
	}
});

	function leaveEdit(){
		var Leavedata = {};
		var idNumber=$("#idNumber").val();
		Leavedata["idno"] = $("#idNumber").val();
		Leavedata["transid"] = $("#transid").val(); 
		Leavedata["leavetypeid"] = $("#sel").val();
		Leavedata["fromdate"] = $("#fromdate").val();
		Leavedata["fhalfday"] = $("#fhalfday").val();
		Leavedata["todate"] = $("#todate").val();
		Leavedata["thalfday"] = $("#thalfday").val();
		Leavedata["noofdays"] = $("#noofdays").val();
		Leavedata["reasonforleave"] = $("#reasonforleave").val();
		
		
	    $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "EditLeave", //this controller url
	        data : JSON.stringify(Leavedata),
	        success: function(data){  
	        	$("#msg").html("SUCCESS! Your Leave updated Sucessfully Please Wait for Reload Page ");
	        	 $("#warnings").show();
				 setInterval(function(){
					 //window.location.href ="#/leaves/" +idNumber
			        	window.location.reload(); // this will run after every 5 seconds
			     }, 2000);
	        }
	   
	    });
	   
	}
	function goback(){
		var idNumber=document.getElementById("idNumber").value;
		window.location.href ="#/leaves/" +idNumber
		/* openeditPage(idNumber); */
	}
</script>
 

<%
int transid=Integer.parseInt(request.getParameter("transid"));
int idNumber = Integer.parseInt(request.getParameter("idNumber"));
%>

<div>
<input type="hidden" id="cl" class="form-control"
					readonly="readonly">
					<input type="hidden" id="sl" class="form-control"
					readonly="readonly">
					<input type="hidden" id="el" class="form-control"
					readonly="readonly">
					<input type="hidden" id="co" class="form-control"
					readonly="readonly">
		<div class="alert alert-warning" id="warnings" style="text-align:center">
  	<strong id="msg" > </strong> 
	</div>
	
	
<h3 align="center" style="color:blue">Edit Leave</h3>
<br>
			<div class="box-content row">
				<div class="form-group has-warning col-md-4">
				<label class="control-label" for="inputWarning1">TransId</label> 
				<input type="text" name="" id="transid" value="<%=transid%>" class="form-control"readonly="readonly">
				</div>
				<div class="form-group has-warning col-md-4">
				<label class="control-label">Leave Type</label> 
            	<select id="sel" class="form-control">
                  <option value="">LeaveType</option>
             	</select>
				</div>
				<div class="form-group has-warning col-md-4">
				<label class="control-label" for="inputWarning1">Fromdate</label> 
				<input type="text"  id="fromdate" onchange="cal()"class="form-control" >
				</div>
				<div class="form-group has-warning col-md-4">
				<label class="control-label" for="inputWarning1"> Half-Day</label>
			 <select id="fhalfday"  onchange="cal()" class="form-control">
			 <option value="0">select</option>
                  <option value="1">Second-Half</option>
             </select>
				</div>

				<div class="form-group has-warning col-md-4">
				<label class="control-label" for="inputWarning1">Todate
			</label> <input type="text"  id="todate" onchange="cal()"  class="form-control">
				</div>
				
			<div class="form-group has-warning col-md-4">
			<label class="control-label" for="inputWarning1"> Half-Day</label>
			 <select id="thalfday" onchange="cal()" class="form-control" >
			 <option value="0">select</option>
                  <option value="1">First-Half</option>
             </select>
		   </div>
		   
			<div class="form-group has-warning col-md-4">
		<label class="control-label" for="inputWarning1">Noofdays</label>
		<input type="text"  id="noofdays" readonly="readonly" class="form-control">
		</div>
							
		<div class="form-group has-warning col-md-4">
		<label class="control-label" for="inputWarning1">Reasonforleave
		</label>
		<input type="text"  id="reasonforleave"  class="form-control">
						</div>
						
						</div>
						<input type="hidden" id = "idNumber" value="<%=idNumber%>">
		
		<div align="center"> 
		<input type="submit" class="btn btn-success"  onclick="calculationForEditLeaves()"  >
		</div>
		</div>
		<br><br><br>
		<div align="center"> 
		<input type="submit" value ="GoBack" class="btn btn-success"  onclick="goback()"  >
		</div>
		
		
		<script src="resources/dist/js/sidebarmenu.js"></script>
	
	 <script src="resources/validation/bootstrapValidator.min.js"></script>
	 <%@include file="footer.jsp" %>
<script>
jQuery('#fromdate').datepicker({
    autoclose: true,
    todayHighlight: true
});
jQuery('#todate').datepicker({
    autoclose: true,
    todayHighlight: true
});
</script>