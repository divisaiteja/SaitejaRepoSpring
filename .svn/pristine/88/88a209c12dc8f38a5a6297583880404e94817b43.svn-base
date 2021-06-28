$(document).ready(function() {
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getEmployeePopup", //this is my servlet
          success: function(data){    	   
       	var abc=data;
       	//alert(data[0]);
       	var ele = document.getElementById('reportingempid');
           for (var i = 0; i < abc.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["idNumber"] + '">' + abc[i]["employeeName"] + '</option>';
           }
       }
});
});

$(document).ready(function() {
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
function saveJobDetails1(){
	var saveData = {};
	saveData["empno"] = $("#empno").val();
	saveData["empname"] = $("#empname").val();
    saveData["idNumber"] = $("#idNumber").val();
    
    saveData["doj"] = $("#doj").val();
    saveData["desgn"] = $("#desgn").val();
    saveData["empstatus"] = $("#empstatus").val();
    saveData["workingdivisionid"] = $("#division").val();
    saveData["gradeid"] = $("#gradeid").val();
    saveData["jobstatus"] = $("#jobstatus").val();
    saveData["cadreid"] = $("#cadreid").val();
    saveData["workdeptid"] = $("#workdeptid").val();
    saveData["gender"] = $("#gender").val();
    saveData["reportingempid"] = $("#reportingempid").val();
    saveData["project"] = $("#project").val();
    saveData["sectionid"] = $("#sectionid").val();
    saveData["jobtype"] = $("#jobtype").val();
    var workingdivisionid = document.getElementById("division");
    var checkBox = document.getElementById("istechnical1");
   if (checkBox.checked == true){
	   //alert("checked");
	   saveData["istechnical"] = "1";  
   } else {
	 //  alert("notchecked");
	   saveData["istechnical"] = "0";  
   }
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "jobDetailsSave", //this is my servlet
	        data : JSON.stringify(saveData),
	        success: function(data){ 
	       // empinfo();
	        $("#jobdetailsDisplayMessage").html(data["successMessage"]);
	        
	        setInterval(function(){
	        	window.location.reload(); // this will run after every 5 seconds
	        }, 2000);
	        }
	 });
}
/*
$(document).ready(function() {
	
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "getallempstatus", //this is my servlet
        success: function(data){ 
        	var abc=data;
        	var ele = document.getElementById('empstatus');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                ele.innerHTML = ele.innerHTML +
                    '<option value="' + abc[i]["empstatusid"] + '">' + abc[i]["description"] + '</option>';
            }
        	
        }
 });
});
*/
/*
$(document).ready(function() {
	
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getallDivision", //this is my servlet
     
       success: function(data){ 
       	var abc=data;
       	var ele = document.getElementById('workingdivisionid');
           for (var i = 0; i < abc.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["divisionid"] + '">' + abc[i]["name"] + '</option>';
           }
       	
       }
});
});
*/

$(document).ready(function() {
	
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "getallempgrade", //this is my servlet
      
        success: function(data){ 
        	var abc=data;
        	var ele = document.getElementById('gradeid');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                ele.innerHTML = ele.innerHTML +
                    '<option value="' + abc[i]["gradeno"] + '">' + abc[i]["description"] + '</option>';
            }
        	
        }
 });
});


$(document).ready(function() {
	
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "getalljobstatus", //this is my servlet
      
        success: function(data){ 
        	var abc=data;
        	var ele = document.getElementById('jobstatus');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                ele.innerHTML = ele.innerHTML +
                    '<option value="' + abc[i]["jobstatusid"] + '">' + abc[i]["description"] + '</option>';
            }
        	
        }
 });
});

$(document).ready(function() {
	
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getallCadre", //this is my servlet
     
       success: function(data){ 
       	var abc=data;
       	var ele = document.getElementById('cadreid');
           for (var i = 0; i < abc.length; i++) {
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["tranid"] + '">' + abc[i]["cadredescription"] + '</option>';
           }
       	
       }
});
});



$(document).ready(function() {
	
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getallproject", //this is my servlet
     
       success: function(data){ 
       	var abc=data;
       	var ele = document.getElementById('project');
           for (var i = 0; i < abc.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["tranid"] + '">' + abc[i]["projectcode"] + '</option>';
           }
       	
       }
});
});


$(document).ready(function() {
	
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getalljobtype", //this is my servlet
     
       success: function(data){ 
       	var abc=data;
       	var ele = document.getElementById('jobtype');
           for (var i = 0; i < abc.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["tranid"] + '">' + abc[i]["jobDescription"] + '</option>';
           }
       	
       }
});
});


/*Department dropdown*/

$(document).ready(function() {
	
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getallDepartment", //this is my servlet
     
       success: function(data){ 
       	var abc=data;
       	var ele = document.getElementById('workdeptid');
           for (var i = 0; i < abc.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["deptid"] + '">' + abc[i]["name"] + '</option>';
           }
       	
       }
});
});

/*Section dropdown*/

$(document).ready(function() {
	
	$.ajax({
       type: "GET",
       contentType : "application/json",
       url: "getallsection", //this is my servlet
     
       success: function(data){ 
       	var abc=data;
       	var ele = document.getElementById('sectionid');
           for (var i = 0; i < abc.length; i++) {
               // POPULATE SELECT ELEMENT WITH JSON.
               ele.innerHTML = ele.innerHTML +
                   '<option value="' + abc[i]["sectionid"] + '">' + abc[i]["name"] + '</option>';
           }
       	
       }
});
});


function getCompId(){
	var divid=$("#division").val();
	$.ajax({
	       type: "GET",
	       contentType : "application/json",
	       url: "getIdNumBasedOnDivision?divid="+divid, //this is my servlet
	     
	       success: function(data){ 
	    	var ss=   document.getElementById('idNumber');
	    	ss.value=data;
//	       	var abc=data;
//	       	var ele = document.getElementById('jobtype');
//	           for (var i = 0; i < abc.length; i++) {
//	               // POPULATE SELECT ELEMENT WITH JSON.
//	               ele.innerHTML = ele.innerHTML +
//	                   '<option value="' + abc[i]["tranid"] + '">' + abc[i]["jobDescription"] + '</option>';
//	           }
	       	
	       }
	});
}