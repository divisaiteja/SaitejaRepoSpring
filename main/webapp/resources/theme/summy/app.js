(function($) {
 
  var app = $.sammy('#app', function() {
	 // this.use('Template');
	  
	  
    this.get('#/accordian/', function() {
	    $("#app").load("dashboard.jsp");
	});
	    
    this.get('#/jobDetails', function() {
    	$("#app").load("jobDetails");
     });
    
    this.get('#/employeeInformation/', function() {
    	//$("#app").html("<img src='https://cdn-images-1.medium.com/max/1600/0*D1icAJvr19HzVBd6.gif' /> ");
    	$("#app").load("employeeInformation");
     });
    
    this.get('#/employee/:id/:idNumber', function() {
    	var id=this.params['id'];
    	var idNumber=this.params['idNumber'];
    	$("#app").load("displayEmployeeEdit?tranid="+id+"&&idNumber="+idNumber);
     });
    
    this.get('#/attendance/', function() {
    	$("#app").load("listAttendence");
     });
   
    
    
    this.get('#/attendance/:date', function() {
    	var date=this.params['date'];
       $("#app").load("validateAttendence.jsp?date="+date);
     });
    this.get('#/generatepaysheetpage/:division/:tmonth/:tyear', function() {
    	var division=this.params['division'];
    	var tmonth=this.params['tmonth'];
    	var tyear=this.params['tyear'];
       $("#app").load("paySheetPageDisplay?division="+division+"&&tmonth="+tmonth+"&&tyear="+tyear);
     });
    
    
    
    this.get('#/displayhrpunches/:date/:idno/:shiftname/:empname/:designation/:depname/:attendid', function() {
    	var date=this.params['date'];
    	var idno=this.params['idno'];
    	var shiftname=this.params['shifname'];
    	var empname=this.params['empname'];
    	var designation=this.params['designation'];
    	var depname=this.params['depname'];
    	var attendid=this.params['attendid'];
  	    $("#app").load("displayhrpunches.jsp",{date:date,idno:idno,shiftname:shiftname,empname:empname,designation:designation,depname:depname,attendid:attendid});

  	    //$("#app").load("displayhrpunches.jsp",{date:date,},)?date="+date+"&idno="+idno+"&shiftname="+shiftname+"&empname="+empname+"&designation="+designation+"&depname="+depname+"&attendid="+attendid);
     });
    
    
	 //   var url = "displayhrpunches.jsp?date="+date+"&idno="+idno+"&shiftname="+shiftname+"&empname="+empname+"&designation="+designation+"&depname="+depname+"&attendid="+attendid;

    
    this.get('#/leaveposting/', function() {
    	$("#app").load("leaveposting");
     });
    
    
    this.get('#/otentry/', function() {
    	$("#app").load("employeeotentry");
     });
    
    
    this.get('#/settings/', function() {
    	$("#app").load("setting");
     });
    
    this.get('#/salaryDeductions/', function() {
    	$("#app").load("salaryDeductions");
     });
    
    this.get('#/hrrepoter/', function() {
    	$("#app").load("hrrepoter");
     });
    
    this.get('#/jobstatus/', function() {
    	$("#app").load("jobstatus");
     });
    
    this.get('#/grade-list/', function() {
    	$("#app").load("gradesList");
     });
    
    this.get('#/division/', function() {
    	$("#app").load("division");
     });
    this.get('#/reports/', function() {
    	$("#app").load("hrrepoter");
     });
    
     this.get('#/leaves/:id', function() {
    	 var id=this.params['id'];
     	$("#app").load("leaves.jsp",{idno:id});
      });
    
     this.get('#/EditLeave/:transid/:idNumber', function() {
    	 var transid=this.params['transid'];
    	 var idNumber=this.params['idNumber'];
     	$("#app").load("EditLeave.jsp?transid="+transid+"&&idNumber="+idNumber);
      });
    
     this.get('#/jobstatus/:jobstatusid/:description/:isactive', function() {
    	 var jobstatusid=this.params['jobstatusid'];
    	 var description=this.params['description'];
    	 var statusCodeForActive=this.params['isactive'];
     	$("#app").load("editjobstatus.jsp?jobstatusid="+jobstatusid+"&&description="+description+"&&isactive="+statusCodeForActive);
      });
     
     this.get('#/view-job-status/', function() {
      	$("#app").load("empstatus");
       });
     
     
     this.get('#/add-divison/', function() {
     	$("#app").load("savedivision");
      });
     this.get('#/add-grade/', function() {
     	$("#app").load("savegrade");
      });
     
     this.get('#/view-blood-group/', function() {
     	$("#app").load("bgroup");
     });
    	 
    this.get('#/add-blood-group/', function() {
    	$("#app").load("savebgroup");
     });
    
    this.get('#/add-emp-status/', function() {
    	$("#app").load("saveEmpstatus");
     });
    
    this.get('#/view-emp-status/', function() {
    	$("#app").load("empstatus");
     });
    this.get('#/view-emp-status/', function() {
    	$("#app").load("empstatus");
     });
    
    this.get('#/admin', function(context) {
    	context.app.swap('');
    	$("#app").load("test.jsp");
     });
   
    
    
//    
//    
//    this.get('#/add-blood-group/', function() {
//    	$("#app").load("savebgroup");
//     });
//    this.get('#/add-blood-group/', function() {
//    	$("#app").load("savebgroup");
//     });
//    this.get('#/add-blood-group/', function() {
//    	$("#app").load("savebgroup");
//     });this.get('#/add-blood-group/', function() {
//    	$("#app").load("savebgroup");
//     });
//     this.get('#/add-blood-group/', function() {
//     	$("#app").load("savebgroup");
//      });
//     this.get('#/add-blood-group/', function() {
//     	$("#app").load("savebgroup");
//      });
//     this.get('#/add-blood-group/', function() {
//     	$("#app").load("savebgroup");
//      });
//     this.get('#/add-blood-group/', function() {
//     	$("#app").load("savebgroup");
//      });
//     this.get('#/add-blood-group/', function() {
//     	$("#app").load("savebgroup");
//      });
//     this.get('#/add-blood-group/', function() {
//     	$("#app").load("savebgroup");
//      });
//     this.get('#/add-blood-group/', function() {
//     	$("#app").load("savebgroup");
//      });
//     this.get('#/add-blood-group/', function() {
//     	$("#app").load("savebgroup");
//      });
    this.get('#/shifts/', function() {
    	$("#app").load("shfitspage");
     });
    this.get('#/jobtype/', function() {
    	$("#app").load("jobtype");
     });
    
    this.get('#/cadre/', function() {
    	$("#app").load("cadre");
     });
    this.get('#/department/', function() {
    	$("#app").load("department");
     });
    this.get('#/sections/', function() {
    	$("#app").load("sections");
     });
    this.get('#/projects/', function() {
    	$("#app").load("projects");
     });
    
    this.get('#/holidays/', function() {
    	$("#app").load("holidays");
     });
    
   this.before({}, function() {
       $("nav ul li").removeClass("selected")
      });
    
    this.notFound = function(){
        this.swap('');
        $("#app").load("404.jsp");
    }
    
   
  });
 
  $(function() {
    app.run('#/accordian/');
  });
 
})(jQuery);