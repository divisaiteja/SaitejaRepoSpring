<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>

$(document).ready(function(){
    $('input[type="radio"]').click(function(){
        var inputValue = $(this).attr("value");
        var targetBox = $("." + inputValue);
        $(".answer_list").not(targetBox).hide();
        $(targetBox).show();
    });
});

</script>
<script>
$(document).ready(function(){
	startTime();
	startdate();
});
</script>
<script>
$(document).ready(function(){
	 $("#successinsavenewRegistration").hide();
	 $("#successinsaveFirstWeight").hide();
	 $("#successinsaveSecondWeight").hide();
	 $("#successinsaveEnquiry").hide();
});
</script>
<script>

function saveFirstWeight(){
	
	var inwardno = document.getElementById("inwardno").value;
	
	var saveFirstWeight = {};
	saveFirstWeight["truckno"] = $("#truckNumberofFirst").val();
	saveFirstWeight["transporter"] = $("#gettransporterofFirst").val();
	saveFirstWeight[""] = $("#lastVisitofFirst").val();
	saveFirstWeight[""] = $("#previousweightofFirst").val();
	saveFirstWeight["grosswt"] = $("#grossofFirst").val();
	saveFirstWeight["tarewt"] = $("#tareofFirst").val();
	saveFirstWeight["netwt"] = $("#netofFirst").val();
	saveFirstWeight["inwardno"] = $("#inwardno").val();
	
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "saveFirstWeight", //this is my servlet
        data : JSON.stringify(saveFirstWeight),
        success: function(data){ 
        	 $("#successinsaveFirstWeight").show();
        	 $("#successmsginsaveFirstWeight").html(data["successMessage"]);
        setInterval(function(){
        	window.location.reload(); // this will run after every 5 seconds
        }, 2000);
        }
 });
}

</script>
<script>

function  saveEnquiry(){
	
var inwardno = document.getElementById("inwardno").value;

	var saveEnquiry = {};
	saveEnquiry["orderno"] = $("#orderNumber").val();
	saveEnquiry["transporter"] = $("#transporter").val();
	saveEnquiry["refno"] = $("#referenceNumber").val();
	saveEnquiry["dcqty"] = $("#dcQuality").val();
	saveEnquiry["DCDate"] = $("#dcDate").val();
	saveEnquiry["dcno"] = $("#dcNumber").val();
	saveEnquiry["lrno"] = $("#lrNumber").val();
	saveEnquiry["materialname"] = $("#productName").val();
	saveEnquiry["supcustname"] = $("#customer").val();
	saveEnquiry["orderdate"] = $("#orderDate").val();
	saveEnquiry["inwardno"] = $("#inwardno").val();
	
	
    $.ajax({    
        type: "post",
        contentType : "application/json",
        url: "saveEnquiry", //this is my servlet
        data : JSON.stringify(saveEnquiry),
        success: function(data){ 
        	 $("#successinsaveEnquiry").show();
        	 $("#successmsginsaveEnquiry").html(data["successMessage"]);
        setInterval(function(){
        	window.location.reload(); // this will run after every 5 seconds
        }, 2000);
        }
 });
	
}


</script>
<script>

function saveSecondWeight(){
	
	var inwardno = document.getElementById("inwardno").value;
	
	var saveSecondWeight = {};
	saveSecondWeight["truckno"] = $("#secondtruckNumber").val();
	saveSecondWeight["transporter"] = $("#secondgettransporter").val();
	//saveFirstWavement["idNumber"] = $("#secondlastvisit").val();
	//saveFirstWavement["doj"] = $("#secondprevious").val();
	saveSecondWeight["grosswt"] = $("#secondgross").val();
	saveSecondWeight["tarewt"] = $("#secondtare").val();
	saveSecondWeight["netwt"] = $("#secondnet").val();
	saveSecondWeight["inwardno"] = $("#inwardno").val();
	
    $.ajax({
        type: "post",
        contentType : "application/json",
        url: "saveSecondWeight", //this is my servlet
        data : JSON.stringify(saveSecondWeight),
        success: function(data){ 
        	 $("#successinsaveSecondWeight").show();
        	 $("#successmsginsaveSecondWeight").html(data["successMessage"]);
        setInterval(function(){
        	window.location.reload(); // this will run after every 5 seconds
        }, 2000);
        }
 });
}

</script>

<script>
function startTime() {
  var today = new Date();
  var h = today.getHours();
  var m = today.getMinutes();
  var s = today.getSeconds();
  m = checkTime(m);
  s = checkTime(s);
  document.getElementById('txt').innerHTML =
  h + ":" + m + ":" + s;
  var t = setTimeout(startTime, 500);
}
function checkTime(i) {
  if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
  return i;
}
</script>
<script>
$(document).ready(function() {
	   
	 $("#image").hide();
});


</script>
<script>
function startdate() {
	n =  new Date();
	y = n.getFullYear();
	m = n.getMonth() + 1;
	d = n.getDate();
	document.getElementById("date").innerHTML = d + "-" + m + "-" + y;
	}
</script>
<script>

function newRegistration(){
    $("#image").show();
var saveData = {};
saveData["truckno"] = $("#vehicleno").val();
saveData["materialname"] = $("#materialname").val();
saveData["inwardtype"] = $("#inwardtype").val();

$.ajax({
    type: "post",
    contentType : "application/json",
    url: "newRegistration", //this is my servlet
    data : JSON.stringify(saveData),
    success: function(data){ 
    	 $("#successinsavenewRegistration").show();
    	 $("#successmsginsavenewRegistration").html(data["successMessage"]);
    setInterval(function(){
    	window.location.reload(); // this will run after every 5 seconds
    }, 2000);
    }
});
 	    $("#image").hide();
 	   
 	    
}
</script>
<script>

function equiryBasedOnInwardNumber(){
  alert();
	var inwardno = document.getElementById("inwardno").value;
	 $.ajax({
			type : "GET",
			contentType : "application/json",
			url : "getequiryBasedOnInwardNumber?inwardno="+inwardno,										
			success : function(data) {
				if(data[0]["orderno"] !== null  ){
					document.getElementById("orderNumber").value = data[0]["orderno"];
						}
				if(data[0]["orderdate"] !== null  ){
					document.getElementById("orderDate").value = data[0]["orderdate"];
						}
				if(data[0]["supcustname"] !== null  ){
					document.getElementById("customer").value = data[0]["supcustname"];
						}
				if(data[0]["materialname"] !== null  ){
					document.getElementById("productName").value = data[0]["materialname"];
						}
				if(data[0]["lrno"] !== null  ){
					document.getElementById("lrNumber").value = data[0]["lrno"];
						}
				if(data[0]["dcno"] !== null  ){
					document.getElementById("dcNumber").value = data[0]["dcno"];
						}
				if(data[0]["dcdate"] !== null  ){
					document.getElementById("dcdate").value = data[0]["dcdate"];
						}
				if(data[0]["dcqty"] !== null  ){
					document.getElementById("dcQuality").value = data[0]["dcqty"];
						}
				if(data[0]["refno"] !== null  ){
					document.getElementById("referenceNumber").value = data[0]["refno"];
						}
				if(data[0]["transporter"] !== null  ){
					document.getElementById("transporter").value = data[0]["transporter"];
						}
				if(data[0]["grosswt"] !== null  ){
					document.getElementById("grossofFirst").value = data[0]["grosswt"];
						}
				if(data[0]["tarewt"] !== null  ){
					document.getElementById("tareofFirst").value = data[0]["tarewt"];
						}
			    var   orderno = data[0]["orderno"];
		        var   gross   = data[0]["grosswt"];
		        var   tare    = data[0]["tarewt"];
			   
		        
		        if(orderno==null){
		        	
		        	 $('input[type="radio"][value=2]').attr('checked', true); 
		        	 $("#enquiry").show();
		        	 $("#second").hide();
		        	 $("#first").hide();
		        	
		        }
		        else{
			   if(gross==0&&tare>0||tare==0&&gross>0){
				   
				   $('input[type="radio"][value=4]').attr('checked', true);
			  	    $("#second").show();
			  	  $("#enquiry").hide();
			  	 $("#first").hide();
			  	
			   }
			   if(gross==0&&tare==0){
				   
				   $('input[type="radio"][value=3]').attr('checked', true);
			  	     $("#first").show();
			  	     $("#enquiry").hide();
		        	 $("#second").hide();
			   }
		       
			   if(gross>0&&tare>0){
				     $("#first").hide();
			  	     $("#enquiry").hide();	  
				disableTextBoxess();
				   
			   }
		        }
		}
	     
	});
 	    
	
}

function disableTextBoxess()
{
	   
	    document.getElementById("secondgettransporter").disabled = true;
	    document.getElementById("secondtruckNumber").disabled = true;
		document.getElementById("secondlastvisit").disabled = true;
		document.getElementById("secondprevious").disabled = true;
		document.getElementById("secondgross").disabled = true;
		document.getElementById("secondtare").disabled = true;
		
		 $("#second").show();
}
</script>

</head>
<body>
<h2 align="center">WEIGTH-BRIDGE</h2>

Date: <div id="date"></div><br>                        
Time:<div id="txt"></div>
<hr color="00FFFF">
<div id="header">
    <h4 style="float: left; width: 25%; text-align: left;"><input type="radio" name="test" value="1"  > <b>New Registration </b></h4>
    <h4 style="float: left; width: 25%; text-align: center;"> <input type="radio" name="test" value="2" > <b>Enquiry </b></h4>
    <h4 style="float: left; width: 25%; text-align: right;"><input type="radio" name="test" value="3"  > <b>1st WT </b></h4>
    <h4 style="float: left; width: 25%; text-align: right;"><input type="radio" name="test" value="4"  > <b>2nd WT</b></h4>
</div>
<br>
<hr color="00FFFF">
 
<div class="form-group has-warning col-md-2">
			<label class="control-label" for="inputWarning1">Inward Number</label> 
			<input type="text" id="inwardno" name="inwardno" class="form-control" onchange="equiryBasedOnInwardNumber()">
		</div> 
		
		
<div id="registration" style="display: none;" class="1 answer_list">
<br><br>
	<h3 style="color: blue;" align="center">Vehicle Registration</h3>
	<br><br>
	 <div align="center"><img src="resources/img/reload.gif" id="image" ></div>
	 <div align="center">
			<div class="alert alert-success " id="successinsavenewRegistration" style="text-align:center">
  		<strong id="successmsginsavenewRegistration" ></strong> 
  		</div>
  		</div>
	<div class="row">
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Vehicle Number</label> 
			<input type="text" id="vehicleno" name="vehicleno" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Material</label> <select
				class="form-control" id="materialname">
			    <option value="">Select</option>
				<option value="M1">Material-1</option>
				<option value="M2">Material-2</option>
				<option value="M3">Material-3</option>
				<option value="M4">Material-4</option>
			</select>
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">InWardType</label> <select
				class="form-control" id="inwardtype">
				<option value="">Select</option>
				<option value="i">Incoming</option>
				<option value="o">Outgoing</option>


			</select>
		</div>
		
</div>

<div align="center">
			<input type="submit" class="btn btn-success" value="Submit"
				 onclick="newRegistration()">
		</div>
</div>

<div id="enquiry" style="display: none;" class="2 answer_list">
<br><br>
	<h3 style="color: blue;" align="center">Enquiry </h3>
	<br><br>
	<div align="center">
			<div class="alert alert-success " id="successinsaveEnquiry" style="text-align:center">
  		<strong id="successmsginsaveEnquiry" ></strong> 
  		</div>
  		</div>
	<div class="row">
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Order Number</label> 
			<input type="text" id="orderNumber" name="orderNumber" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1" >Order Date</label> 
			<input type="text" id="orderDate" name="orderDate" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Customer/supplier</label> 
			<input type="text" id="customer" name="customer" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Product Name</label> 
			<input type="text" id="productName" name="productName" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">LR Number</label> 
			<input type="text" id="lrNumber" name="lrNumber" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">DC Number</label> 
			<input type="text" id="dcNumber" name="dcNumber" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">DC Date</label> 
			<input type="text" id="dcDate" name="dcDate" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">DC Quality</label> 
			<input type="text" id="dcQuality" name="dcQuality" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Reference Number</label> 
			<input type="text" id="referenceNumber" name="referenceNumber" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Transporter</label> <select
				class="form-control" id="transporter" name="transporter" class="form-control">
					<option value="">Select</option>
                <option value="T1">Transporter-1</option>
				<option value="T2">Transporter-2</option>
				<option value="T3">Transporter-3</option>
				<option value="T4">Transporter-4</option>
			</select>
		</div>
		
</div>

   <div align="center">
			<input type="submit" class="btn btn-success" value="Submit"
				 id="submitDetails" onclick="saveEnquiry()">
		</div>
</div>

<div id="first" style="display: none;" class="3 answer_list">
<br><br>
	<h3 style="color: blue;" align="center">1st WT </h3>
	<br><br>
	<div align="center">
			<div class="alert alert-success " id="successinsaveFirstWeight" style="text-align:center">
  		<strong id="successmsginsaveFirstWeight" ></strong> 
  		</div>
  		</div>
	<div class="row">
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Truck Number</label> 
			<input type="text" id="truckNumberofFirst" name="truckNumberofFirst" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Transporter</label> <select
				class="form-control" id="gettransporterofFirst" name="gettransporterofFirst" class="form-control">
					<option value="">Select</option>
				 <option value="T1">Transporter-1</option>
				<option value="T2">Transporter-2</option>
				<option value="T3">Transporter-3</option>
				<option value="T4">Transporter-4</option>
			</select>
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Last Visit</label> 
			<input type="text" id="lastVisitofFirst" name="lastVisitofFirst" class="form-control" readonly="readonly" >
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Previous Wt</label> 
			<input type="text" id="previousweightofFirst" name="previousweightofFirst" class="form-control" readonly="readonly">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Gross Wt</label> 
			<input type="text" id="grossofFirst" name="grossofFirst" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Tare Wt</label> 
			<input type="text" id="tareofFirst" name="tareofFirst" class="form-control" readonly="readonly">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Net Wt</label> 
			<input type="text" id="netofFirst " name="netofFirst" class="form-control" readonly="readonly">
		</div>	
      </div>
        <div align="center">
			<input type="submit" class="btn btn-success" value="Submit"
				 id="submitDetails" onclick="saveFirstWeight()">
		</div>
</div>
<div id="second" style="display: none;" class="4 answer_list">
<br><br>
	<h3 style="color: blue;" align="center">2nd WT </h3>
	<br><br>
	<div align="center">
			<div class="alert alert-success " id="successinsaveSecondWeight" style="text-align:center">
  		<strong id="successmsginsaveSecondWeight" ></strong> 
  		</div>
  		</div>
<div class="row">
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Truck Number</label> 
			<input type="text" id="secondtruckNumber" name="secondtruckNumber" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Transporter</label> <select
				class="form-control" id="secondgettransporter" name="secondgettransporter" class="form-control">
					<option value="">Select</option>
				 <option value="T1">Transporter-1</option>
				<option value="T2">Transporter-2</option>
				<option value="T3">Transporter-3</option>
				<option value="T4">Transporter-4</option>
			</select>
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Last Visit</label> 
			<input type="text" id="secondlastvisit" name="secondlastvisit" class="form-control" >
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Previous Wt</label> 
			<input type="text" id="secondprevious" name="secondprevious" class="form-control" >
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Gross Wt</label> 
			<input type="text" id="secondgross" name="secondgross" class="form-control" >
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Tare Wt</label> 
			<input type="text" id="secondtare" name="secondtare" class="form-control">
		</div>
		<div class="form-group has-warning col-md-3">
			<label class="control-label" for="inputWarning1">Net Wt</label> 
			<input type="text" id="secondnet " name="secondnet" class="form-control" >
		</div>
		
		
</div>
<div align="center">
			<input type="submit" class="btn btn-success" value="Submit"
				 id="submitDetails" onclick="saveSecondWeight()">
		</div>
</div>
</body>
<script src="resources/dist/js/sidebarmenu.js"></script>
</html>

<%@include file="footer.jsp" %>
