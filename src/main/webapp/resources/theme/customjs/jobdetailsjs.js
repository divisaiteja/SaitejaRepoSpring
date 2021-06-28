
$(document).ready(function() {
	   
      // alert("I am here at Reportee dropdown collection...");
	$.ajax({
		type: "GET",
		contentType : "application/json",
		 url: "getAllReportees", //this is my servlet
		success: function(data){ 
			var abc=data;
			//alert(data[0]);
			var ele = document.getElementById('reporting');
			for (var i = 0; i < abc.length; i++) {
				// POPULATE SELECT ELEMENT WITH JSON.
				ele.innerHTML = ele.innerHTML +
				'<option value="' + abc[i]["idno"] + '">' + abc[i]["empname"] + '</option>';
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
function saveJobDetails(){
    	    $("#image").show();
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
    saveData["parentDeptId"] = $("#workdeptid").val();
    saveData["gender"] = $("#gender").val();
    saveData["reportingempid"] = $("#reportingempid").val();
    saveData["project"] = $("#project").val();
    saveData["sectionid"] = $("#sectionid").val();
    saveData["jobtype"] = $("#jobtype").val();
    saveData["parentDivisionID"] = $("#division").val();
    saveData["skillid"] = $("#skillid").val();
    saveData["emailid"] = $("#EmailId").val();
    saveData["mobilenumber"] = $("#Mobile").val();
    saveData["contractorid"] = $("#contractperson").val();
    var workingdivisionid = document.getElementById("division");
    var checkBox = document.getElementById("istechnical");
   if (checkBox.checked){
	   ////alert("checked");
	   saveData["istechnical"] = "1";  
   } else {
	 //  //alert("notchecked");
	   saveData["istechnical"] = "0";  
   }
    var rcheckBox = document.getElementById("isreportee");
   if (rcheckBox.checked){
	   ////alert("checked");
	   saveData["isreportee"] = "1";  
   } else {
	 //  //alert("notchecked");
	   saveData["isreportee"] = "0";  
   }
   
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "jobDetailsSave", //this is my servlet
	        data : JSON.stringify(saveData),
	        success: function(data){ 
	        $("#jobdetailsDisplayMessage").html(data["successMessage"]);
	        
	        setInterval(function(){
	        	window.location.reload(); // this will run after every 5 seconds
	        }, 2000);
	        }
	 });
         	    $("#image").hide();
         	   
         	    
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

/*Designation Dropdown*/
$(document).ready(function() {
	DesignationDropdown();	
});

function DesignationDropdown(){
	$.ajax({
	       type: "GET",
	       contentType : "application/json",
	       url: "getallDesignationdropdown",
	       success: function(data){ 
	       	var abc=data;
	       	var ele = document.getElementById('desgnpop');
	           for (var i = 0; i < abc.length; i++) {
	               ele.innerHTML = ele.innerHTML +
	                   '<option value="' + abc[i]["Designation"] + '">' + abc[i]["Designation"] + '</option>';
	                 
	           }
	       	
	       }
	});
	
}
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
	
	var jobtypeid = $("#jobtype option:selected").text();	
	if (!jobtypeid.match("Contract")){		
	   $.ajax({
	       type: "GET",
	       contentType : "application/json",
	       url: "getIdNumBasedOnDivision?divid="+divid, //this is my servlet
	     
	       success: function(data){ 
	    	var ss=   document.getElementById('idNumber');
	    	ss.value=data;       	
	       }	
	   });
	}
}

function getContractId(){
	var contractid=$("#contractperson").val();
	$.ajax({
	       type: "GET",
	       contentType : "application/json",
	       url: "getIdNumBasedOnContract?contractid="+contractid, //this is my servlet
	     
	       success: function(data){ 
	    	var ss=   document.getElementById('idNumber');
	    	ss.value=data;
	       	
	       }
	});
}
$(document).ready(function() {
	  $("#contract").hide();
	  
})
$(document).ready(function() {
	$.ajax({
	       type: "GET",
	       contentType : "application/json",
	       url: "getallcontractpersonnames", //this is my servlet
	       success: function(data){ 
	       	var abc=data;
	       	var ele = document.getElementById('contractperson');
	           for (var i = 0; i < abc.length; i++) {
	               // POPULATE SELECT ELEMENT WITH JSON.
	               ele.innerHTML = ele.innerHTML +
	                   '<option value="' + abc[i]["contractorid"] + '">' + abc[i]["name"] + '</option>';
	           }
	       	
	       }
	});	
	  
})

function jobtypeChange(){
	var divisionid=$("#division").val();
	var jobtypeid = $("#jobtype option:selected").text();
	document.getElementById('idNumber').value="";	
	document.getElementById("contractperson").value="0";
	if (jobtypeid.match("Contract")){
		$("#contract").show();
	}
	else{
		$("#contract").hide();	
		if (divisionid>0){
			getCompId();
		} 
	}
	 
	
}
