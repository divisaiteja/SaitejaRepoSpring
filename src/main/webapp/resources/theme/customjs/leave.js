//calling leaveposting.jsp page throw controller url
$(document).ready(function() {
	$("#leaveposting").on('click', '#leaveDebit', function() {
		 var currentRow = $(this).closest("tr");
		 var rowData = $("#leaveposting").DataTable().row(currentRow).data();
		 var idNumber = rowData.idNumber;
		 console.log(rowData);
       window.location.href ="#/leaves/" +idNumber
		  //window.location.href = "#/employee/" + tranid+"/"+ idNumber
 });
 });
 
$(document).ready(function() {
	$("#leaveposting").on('click', '#leaveCredit', function() {
	
		 var currentRow = $(this).closest("tr");
		 var rowData = $("#leaveposting").DataTable().row(currentRow).data();
		 var idNumber = rowData.idNumber;
                 //alert(idNumber);
                  $("#idNumber").val(idNumber);
                  
                 $('#leavecreditModal').modal('show');
	
		  
 });
 });
 
 $(document).ready(function() {
	$("#leaveposting").on('click', '#leaveProcess', function() {
	
		 var currentRow = $(this).closest("tr");
		 var rowData = $("#leaveposting").DataTable().row(currentRow).data();
		 var idNumber = rowData.idNumber;
               
                  $("#idNumber1").val(idNumber);
                  $.ajax({
                      contentType : "application/json",
                      "url" : "/HRMS/getLevelIds?idno="+ idNumber,
	              "dataSrc" : "dataBean",
		      "type" : "GET",
                      success : function(data) {
                              
                              $("#level1").val(data[0].level1);
			                  $("#level2").val(data[0].level2);
                              $("#level3 ").val(data[0].level3);
                              $("#level4 ").val(data[0].level4);                 
                      },
                  });
                 $('#approvalleaveModal').modal('show');
	
		  
 });
 });
	 
/*	 var addpermission=1;
	 if (addpermission==0){
		 document.getElementById('cfiblinks').style.visibility = 'hidden';
		 }else{
			 document.getElementById('cfiblinks').style.visibility = 'visible';
			 }
	 //alert(addpermission+" - "+ document.getElementById('cfiblinks').style.visibility);*/
	
	  
	 
//});
	 
$(document).ready(function() {
	 var idno=document.getElementById("idNumber").value;
	  var selectedRecord;
		$.ajax({
			
		    type: "GET",
		    contentType : "application/json",
		    url: "/HRMS/getLeave?idno="+idno, //this is my servlet
		    success: function(data){ 
		    	//selectedRecord = data;
		    	console.log(data);
		    	$("#idno").val(data["idNumber"]);
		    	$("#empno").val(data["employeeNumber"]);
		    	$("#empname ").val(data["employeeName"]);
		    	$("#desgn ").val(data["design"]);
		    	$("#name ").val( data["name"]);
		    }
		});	 
});




function onChangeLeavePosting() {
	 
	 var project=document.getElementById("project").value;
	 var division=document.getElementById("division").value;
	 
	$('#leaveposting').dataTable( {
		  "destroy" : true,
			 "ajax" : {
			"url" : "/HRMS/getLeavePosting?project="+project+"&&division="+division,
			"dataSrc" : "dataBean",
			"type" : "GET",
		
		       },
			"columns": [
 				
				           	{ data: "sno"},
			 				{ data: "idNumber"},
			 				{ data: "employeeNumber"},
					 		{ data: "employeeName"},
							{ data: "design"},
							{ data: "name"},
							{
				                data: null,
				                className: "center",
//				                defaultContent: '<button id ="leave" type ="button"  color="green"  >View</button> ' +
                                                defaultContent: '<input type="image" src="resources/assets/images/leaves.png" id="leaveDebit" height="20" width="20" title="Apply Leave" >'+
                                                                '&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" src="resources/assets/images/add.png" id="leaveCredit" height="20" width="20" title="Leave Credits" data-toggle="modal" data-target="#myModal" href="#" >'+
                                                                '&nbsp;&nbsp;&nbsp;&nbsp;<input type="image" src="resources/assets/images/appprocess.png" id="leaveProcess" height="20" width="20" title="Approval Flow" data-toggle="modal" data-target="#myModal1" href="#" >'                                                                 
				            }
					],
		
		} );
	
}


//script for leave process
function saveLeaveProcess() {
        var idno=document.getElementById("idNumber1").value;
//	var idno = $("#idno").val();
	var level1 = $("#level1").val();
	var level2 = $("#level2").val();
	var level3 = $("#level3").val();
	var level4 = $("#level4").val();
      
		$.ajax({
			type : "post",
			url : "saveLeaveProcess?idno="+idno+"&level1="+level1+"&level2="+level2+"&level3="+level3+"&level4="+level4, // this is my servlet
			success : function(data) {
				$("#LeaveApproveStrong").html(data["successMessage"]);
				$("#LeaveApprovesuccess").show();
		        setInterval(function(){
		        	$("#LeaveApprovesuccess").hide();
		        }, 4000);
			}
		});		
}

//script for leave credits
function saveLeaveCredit() {
	alert("saveLeaveCredit");
	var idno=document.getElementById("idNumber").value;
	//var idno = $("#idno").val();
	var cl = $("#cl").val();
	var sl = $("#sl").val();
	var el = $("#el").val();
	var remarks = $("#remarks").val();

		$.ajax({
			type : "post",
			url : "saveLeaveCreditDetails?idno="+idno+"&cl="+cl+"&sl="+sl+"&el="+el+"&remarks="+remarks, // this is my servlet
			success : function(data) {
				$("#DisplayMessage").html(data["successMessage"]);
		        setInterval(function(){
		        	
		        	$("#DisplayMessage").hide();
		        }, 2000);
			}
		});		
}

//script for leave deletion
function forleavedeletion(){
	 $("#leavedebits").on('click', '#deleteleave', function() {
		    var currentRow = $(this).closest("tr");
		    var transid = currentRow.find("td:eq(1)").html();   
		    var retVal = confirm("would you like to delete this transid "+transid);
           if( retVal == true ) {
            //  document.write ("User wants to continue!");
              deletedSuccessfully(transid);
           } else {
              //document.write ("User does not want to continue!");
           }
           var idNumber=document.getElementById("idNumber").value;			
          // window.location.href ="#/leaves/" +idNumber
	 });
}

function deletedSuccessfully(transid){
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "deleteLeave?transid="+transid, //this is my servlet

	        success: function(data){  
	        	window.location.reload();
	        }
	  });
}

// script for current row edit function based on transid
function OpenEditLeaveRecd(){
	 $("#leavedebits").on('click', '#fetchToleave', function() {
	var currentRow = $(this).closest("tr");
	var transid = currentRow.find("td:eq(1)").html();
   var idNumber=document.getElementById("idNumber").value;
  window.location.href ="#/EditLeave/" +transid+"/"+idNumber
  
	 });

}

$(document).ready(function() {
	
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/HRMS/leaveType", //this is my servlet
      
        success: function(data){ 
        	document.getElementById("lType").innerHTML = data[2];
        	document.getElementById("lType1").innerHTML = data[6];
        	document.getElementById("lType2").innerHTML = data[10];
        	document.getElementById("lType3").innerHTML = data[14];
        }
 });
  
});
//script for save leave
function saveleave(){ 	
	var saveLeave = {};
	saveLeave["idno"] = $("#idNumber").val();
	saveLeave["leavetypeid"] = $("#sel").val();
	var str=	$("#fromdate").val();
    var month = str.substring(0, 2);
    var subdate = str.substring(3, 5);
	var year = str.substring(6, 10);
	var fromdate=$("#fromdate").val();
	var str1=$("#todate").val();
	var month = str1.substring(0, 2);
	var subdate = str1.substring(3, 5);
	var year = str1.substring(6, 10);
	var todate=$("#todate").val();
	var noofdays=$("#noofdays").val();
	saveLeave["fromdate"] = fromdate;
	saveLeave["todate"] = todate;
	saveLeave["fhalfday"] = $("#fhalfday").val();
	saveLeave["thalfday"] = $("#thalfday").val();
	saveLeave["noofdays"] = parseFloat(noofdays);
	saveLeave["reasonforleave"] = $("#reasonforleave").val();
	 $.ajax({
		 
	        type: "POST",
	        contentType : "application/json",
	        url: "savenewleave", //this is my servlet
	        data : JSON.stringify(saveLeave),        
	        success: function(data){ 
	        	$("#warnings").hide();
				$('#success').show();
				 setInterval(function(){
			        	window.location.reload(); // this will run after every 5 seconds
			     }, 3000);
	        }
	 });
	 return false;
	
}
  //json listing page for leavetype

$(document).ready(function() {
	
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/HRMS/getleavetype", //this is my servlet
      
        success: function(data){ 
        	var abc=data;
        	var ele = document.getElementById('sel');
            for (var i = 0; i < abc.length; i++) {
                // POPULATE SELECT ELEMENT WITH JSON.
                ele.innerHTML = ele.innerHTML +
                    '<option value="' + abc[i]["transid"] + '">' + abc[i]["leavetype"] + '</option>';
            }
        	
        }
 });
});

function show(ele) {
    // GET THE SELECTED VALUE FROM <select> ELEMENT AND SHOW IT.
    var msg = document.getElementById('msg');
    msg.innerHTML = 'Selected LeaveType: <b>' + ele.options[ele.selectedIndex].text + '</b> </br>';
}

function populateSelect(){
	var a=document.getElementById("sel").value;
}

/*function getLeaveBalance(leaveTypeId) {
	for(var i=0; i<leaveBalances.length; i++){
		if(leaveBalances[i].id == leaveTypeId) {
			return leaveBalances[i].balance;
		}
	}
}
var leaveBalances;*/
$(document).ready(function() {    
	var idno = document.getElementById("idNumber").value;
	$.ajax({
		
	    type: "GET",
	    contentType : "application/json",
	    url: "/HRMS/getleavebalance?idno=" +idno, //this is my servlet
	    success: function(data){ 
	    /*	leaveBalances = data;
	    	for(var i=0; i<leaveBalances.length; i++){
	    		document.getElementById(leaveBalances[i].code).value = leaveBalances[i].balance;	    		
	    	}*/
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
});

//get leave process flow ids
function getLeaveApprovalFlow() {
	var idno = document.getElementById("idNumber").value;
	$.ajax({
		
	    type: "GET",
	    contentType : "application/json",
	    url: "/HRMS/getleaveApprovalFlow?idno=" +idno, //this is my servlet
	    success: function(data){ 
	    /*	leaveBalances = data;
	    	for(var i=0; i<leaveBalances.length; i++){
	    		document.getElementById(leaveBalances[i].code).value = leaveBalances[i].balance;	    		
	    	}*/
	    	var level1 = parseFloat(data[0]).toFixed(1);
	    	document.getElementById("level1").value=level1;
	    	var level2 = parseFloat(data[1]).toFixed(1);
	    	document.getElementById("level2").value=level2;
	    	var level3 = parseFloat(data[2]).toFixed(1);
	    	document.getElementById("level3").value=level3;
	    	var level4 = parseFloat(data[3]).toFixed(1);
	    	document.getElementById("level4").value=level4;
	    }
	});
}
