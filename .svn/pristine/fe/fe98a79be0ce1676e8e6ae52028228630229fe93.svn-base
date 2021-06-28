<%@include file="header.jsp"%>
<script>
$(document).ready(function() {
	$("#image").hide();
	openNotify();
});

function openNotify(){
	var test_1 = document.getElementsByName('test');
	if (test_1[0].checked) {
		// document.getElementById('testing').style.visibility = "hidden";
		document.getElementById('Email').style.display = "block";
		document.getElementById('sms').style.display = "none";
		
	} else {
		//document.getElementById('testing').style.visibility = "visible";
		document.getElementById('Email').style.display = "none";
		document.getElementById('sms').style.display = "block";

	}
}	
$(document).ready(function() {
$.ajax({
    type: "GET",
    contentType : "application/json",
    url: "getEmployeePopup", //this is my servlet
  
    success: function(data){
    	var abc = data;
		var ele = document.getElementById('empnames');
		for (var i = 0; i < abc.length; i++) {
			// POPULATE SELECT ELEMENT WITH JSON.
			ele.innerHTML = ele.innerHTML + '<option value="'
					+ abc[i]["idNumber"] + '">'
					+ abc[i]["employeeName"] + '</option>';
		}

    }
});
});
function sendEmail(){
	var empnames = [];
	$.each($("#empnames option:selected"), function() {
		empnames.push($(this).val());
	});
	var empids = empnames.join(",");
	//alert(empids);
	var emaildetails = {};
	emaildetails["subject"] = $("#subject").val();
	emaildetails["message"] = $("#message").val();
	emaildetails["empid"] = empids;
	$("#Email").hide();
	$("#image").show();
	
	$.ajax({
		type : "post",
		contentType : "application/json",
		url : "sendingEmailNotification", // this is my servlet
		data : JSON.stringify(emaildetails),
		success : function(data) {
			//alert(data["successMessage"]);
			$("#image").hide();
			window.location.reload();
		}
	});
	//data : JSON.stringify(otherdetails),
}
</script>
<h3 align="center">Send Notifications</h3><hr>
<b>Notification Through Email</b>
&nbsp;&nbsp;
<input type="radio" name="test" title="yes" onclick="openNotify()"
	value="Y" checked="checked">
&nbsp;&nbsp;
<b>Notification Through SMS</b>
&nbsp;&nbsp;
<input type="radio" name="test" title="NO" onclick="openNotify()"value="N">
<hr>
<div align="center"><img src="resources/img/reload.gif" id="image" ></div>
<div id="Email">
<div class="container">
<div class="col-md-6">
  <h2>Email Notification</h2>
    <div class="form-group">
      <label for="select">Select:</label>
      <select class="form-control" id="empnames" multiple="multiple">
      </select>
    </div>
    <div class="form-group">
      <label for="subject">Subject:</label>
      <input type="text" class="form-control" id="subject" placeholder="Enter Subject" name="pwd">
    </div>
    <div class="form-group">
      <label for="subject">Message:</label>
      <textarea rows="4" cols="50" class="form-control" id="message">

</textarea>
    </div>
    <button type="submit" class="btn btn-default" onclick="sendEmail()">Submit</button>
</div>
</div>


</div>
<div id="sms">
SMS
</div>
<script src="resources/dist/js/sidebarmenu.js"></script>
	<%@include file="footer.jsp" %>