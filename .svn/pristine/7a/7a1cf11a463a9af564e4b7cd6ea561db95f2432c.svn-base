
 
 
//script for leave calculation
function cal(){
	 var fromdate = document.getElementById("fromdate").value;
     var todate = document.getElementById("todate").value;
     var fhalfday=document.getElementById("fhalfday").value;
     var thalfday=document.getElementById("thalfday").value;
     var idno=document.getElementById("idNumber").value;
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "countingLeaves?fromdate="+fromdate+"&&todate="+todate+"&&fhalfday="+fhalfday+"&&thalfday="+thalfday+"&&idno="+idno, 		//this is my servlet

        success: function(data){  
        	/*if($("#noofdays").val(data) > clval){
        		
        	}*/
        	 $("#noofdays").val(data);

        }
  });
	}

//calling leaveposting.jsp page throw controller url
	$(document).ready(function() {
	$("#leaveposting").on('click', '#leave', function() {
	
		 var currentRow = $(this).closest("tr");
		 var rowData = $("#leaveposting").DataTable().row(currentRow).data();
		 var idNumber = rowData.idNumber;
		 console.log(rowData);
		  window.location.href ="#/leaves/" +idNumber
		  //window.location.href = "#/employee/" + tranid+"/"+ idNumber
 });
	 

	 
/*	 var addpermission=1;
	 if (addpermission==0){
		 document.getElementById('cfiblinks').style.visibility = 'hidden';
		 }else{
			 document.getElementById('cfiblinks').style.visibility = 'visible';
			 }
	 alert(addpermission+" - "+ document.getElementById('cfiblinks').style.visibility);*/
	
	  
	 
});
	 
$(document).ready(function() {
	 var idno=document.getElementById("idNumber").value;
	  var selectedRecord;
		$.ajax({
			
		    type: "GET",
		    contentType : "application/json",
		    url: "/DASHBOARD/getLeave?idno="+idno, //this is my servlet
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


$(document).ready(function() {
	$('#leaveposting').dataTable( {
			 "ajax" : {
			"url" : "/DASHBOARD/getLeavePosting",
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
				                defaultContent: '<button id ="leave" type ="button"  color="green"  >View</button> '
				            }
					],
		
		} );
	
} );
//json listing page for leavedebits





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
	var rowData = $("#leavedebits").DataTable().row(currentRow).data();
   var transid = rowData.transid;
   var idNumber=document.getElementById("idNumber").value;
 // openEditLeave(transid,idNumber);
 // var url = "EditLeave.jsp?transid="+transid+"&idno="+idNumber;
  window.location.href ="#/EditLeave/" +transid+"/"+idNumber
  
	 });

}

$(document).ready(function() {
	
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "/DASHBOARD/leaveType", //this is my servlet
      
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
        url: "/DASHBOARD/getleavetype", //this is my servlet
      
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
	    url: "/DASHBOARD/getleavebalance?idno=" +idno, //this is my servlet
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
