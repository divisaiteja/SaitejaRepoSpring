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
   
    
    this.get('#/attendance/:date/:project/:division', function() {
    	var date=this.params['date'];    	
    	var project=this.params['project'];    
    	var division=this.params['division']; 
       $("#app").load("validateAttendence.jsp?sType=0&&date="+date+"&&project="+project+"&&division="+division);
     });
    

    this.get('#/getsalarystatement/:year/:project/:division/:month', function() {
    	var year=this.params['year'];    	
    	var project=this.params['project'];    
    	var division=this.params['division']; 
    	var month=this.params['month']; 
       $("#app").load("getsalarystatement?year="+year+"&&project="+project+"&&division="+division+"&&month="+month);
     });
    
    this.get('#/getReport/:project/:division', function() {
    	   	
    	var project=this.params['project'];    
    	var division=this.params['division']; 
    	console.log(division);
       $("#app").load("getDailyAttendenceStrenthReport");
     });
    
    this.get('#/download', function() {
    	//var date=this.params['date'];    	
    	//var project=this.params['project'];    

       $("#app").load("downloaddocs.jsp");
     });

     
    this.get('#/generatepaysheetpage/:division/:tmonth/:tyear', function() {
    	var division=this.params['division'];
    	var tmonth=this.params['tmonth'];
    	var tyear=this.params['tyear'];
       $("#app").load("paySheetPageDisplay?division="+division+"&&tmonth="+tmonth+"&&tyear="+tyear);
     });
    
    
    
    this.get('#/displayhrpunches/:date/:idno/:shiftname/:empname/:designation/:depname/:attendid/:division/:project', function() {
    	var date=this.params['date'];
    	var idno=this.params['idno'];
    	var shiftname=this.params['shifname'];
    	var empname=this.params['empname'];
    	var designation=this.params['designation'];
    	var depname=this.params['depname'];
    	var attendid=this.params['attendid'];
        var division=this.params['division'];
        var project=this.params['project'];
        
  	    $("#app").load("displayhrpunches.jsp",{date:date,idno:idno,shiftname:shiftname,empname:empname,designation:designation,depname:depname,attendid:attendid,division:division,project:project});

  	    //$("#app").load("displayhrpunches.jsp",{date:date,},)?date="+date+"&idno="+idno+"&shiftname="+shiftname+"&empname="+empname+"&designation="+designation+"&depname="+depname+"&attendid="+attendid);
     });
  
    this.get('#/permissions/', function() {
    	$("#app").load("EmployeePermissionsInformation");
     });
     this.get('#/appraisals/', function() {
    	$("#app").load("appraisalsEmployeeInformation");
     });
    
     this.get('#/appraisals/:id/:idNumber', function() {
     	var id=this.params['id'];
     	var idNumber=this.params['idNumber'];
     	$("#app").load("IncrementsAndPromotions?tranid="+id+"&&idNumber="+idNumber);
      });
     
     this.get('#/Filesupload/:tranid', function() {
    	 var tranid=this.params['tranid'];
    	$("#app").load("Filesupload?tranid="+tranid);
     });
     
    this.get('#/leaveposting/', function() {
    	$("#app").load("leaveposting");
     });
    
    
    this.get('#/otentry/', function() {
    	$("#app").load("employeeotentry");
     });
    
    
    this.get('#/settings/', function() {
    	$("#app").load("setting");
     });
    
    this.get('#/notifications/', function() {
    	$("#app").load("notifications");
     });
    
    this.get('#/menuAccess/', function() {
    	$("#app").load("usercompmapping");
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
    
    this.get('#/events/', function() {
    	$("#app").load("eventcontrol");
     });
    
    this.get('#/report/', function() {
    	$("#app").load("report");
     });
    
    this.get('#/sample1/', function() {
    	$("#app").load("sample1");
     });
    this.get('#/transaction/', function() {
    	$("#app").load("transaction");
     });
    
   
     this.get('#/leaves/:id', function() {
    	 var id=this.params['id'];
     	$("#app").load("leaves.jsp",{idno:id});
      });
        this.get('#/addpunch/:date:/division:/project', function() {
    	 var date=this.params['date'];
         var division=this.params['division'];
         var project=this.params['project'];
     	$("#app").load("validateAttendence.jsp",{date:date,division:division,project:project});
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
    
    this.get('#/view-otlist/', function() {
    	var division=this.params['division'];
    	var otdate=this.params['otdate'];
    	var project=this.params['project'];
    	$("#app").load("getAllEmployeeAndDepartment?division="+division+"&&otdate="+otdate+"&&project="+project);
     });
    this.get('#/admin', function(context) {
    	context.app.swap('');
    	$("#app").load("test.jsp");
     });
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
    this.get('#/bankmaster/', function() {
    	$("#app").load("bankmaster");
     });
    this.get('#/faceDetection/', function() {
    	$("#app").load("faceDetection");
     });
    this.get('#/faceRecognization/', function() {
    	$("#app").load("faceRecognization");
     });
    this.get('#/scan/', function() {
    	$("#app").load("scan");
     });
    this.get('#/contractor/', function() {
    	$("#app").load("contractor");
     });
    this.get('#/compliance/', function() {
    	$("#app").load("compliance");
     });
    
    this.get('#/weightbridge/', function() {
    	$("#app").load("weightbridge");
     });
    this.get('#/WeightTimeAnalysis/', function() {
    	$("#app").load("WeightTimeAnalysis");
     });
    this.get('#/WeightRegister/', function() {
    	$("#app").load("WeightRegister");
     });
    this.get('#/Quality/', function() {
    	$("#app").load("Quality");
     });
    
    this.get('#/salarystatement/', function() {
    	$("#app").load("salarystatement");
     });
    this.get('#/MonthlyAttendence/', function() {
    	$("#app").load("MonthlyAttendence");
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