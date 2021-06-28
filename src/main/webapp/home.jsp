
<%@include file="header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<style>
 a.btn-lg {
  position: relative;
  font-size: 2em;
  color: grey;
  cursor: pointer;
}
 span.glyphicon glyphicon-bell {
  position: absolute;
  font-size: 0.6em;
  top: -4px;
  color: red;
  right: -4px;
  font-size: 150px;
  
}
/* span.num {
 position: absolute; 
  font-size: 0.3em;
  top: -6px;
  color: #bf0b3d;
  right:-6px;
  left:50px;
}  */
.badge{
   /*  padding: 3px 5px 2px; */
    position: absolute;
    top: 10px;
    left: 25px;
    display: inline-block;
    min-width: 1px;
    font-size: 5px;
    font-weight: bold;
   /*  color: #ffffff; */
    line-height: 1;
    vertical-align: baseline;
    white-space: nowrap;
    text-align: center;
    border-radius: 2px;
}
/* .badge-danger {
    background-color: #db5565;
} */


</style>
   <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" /> -->


<%
HttpSession sess=request.getSession();
String username=(String)sess.getAttribute("username");
%>
<%if(username!=null){%>
<script>
$(document).ready(function() {
	
		$.ajax({
					type : "GET",
					contentType : "application/json",
					url : "getsiderbarmenu",
					success : function(data) {
								}
							});
				});

</script>					
<script>
function getAccessRights(activityId){
//    //alert("Clicked on : "+activityId);
//    //alert("Page Redirect To : "+nextPage);
//var username=document.getElementById("userloginid").value;
//     if(username!="admin"){
	$.ajax({
        type: "POST",
        contentType : "application/json",
        url: "setsession?activityId="+activityId, //this is my servlet      
        success: function(data){ 
            //alert("I am here.."+data);
        },
      /*   error: function(XMLHttpRequest, textStatus, errorThrown) {
        //alert("some error "+errorThrown+textStatus);
  } */
 });
//     }
};

  function GetXmlHttpObject()
{
    var xmlHttp = null;
    if (window.XMLHttpRequest) {
        xmlHttp = new window.XMLHttpRequest;
    } else {
        try {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (ex) {
            return null;
        }
    }
    return xmlHttp;
} 




function getImage(parentid) {
	var empid = parentid;
	//alert("empid     "+empid)
	 $.ajax({
		    bProcessing:true,
	        type: "get",
	        url: "getphotobasedonempid?empid="+empid, //this is my servlet
	        		success : function(data) {
	        	  var image = data.base64Image;
	        	     //console.log(image);
	        	$("#ItemPreview").attr("src", "data:image/png;base64," + image);
	        	
			}
	        
	  });

} 
</script>
<!-- <script type="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script> -->
<script src="resources/dist/js/sidebarmenu.js"></script>
 <script src="resources/summy/sammy.js"></script>
 <script src="resources/summy/sammy.template.js"></script>
  <script src="resources/summy/app.js"></script>

<script>
$(document).ready(function() {
	var userloginid=document.getElementById("userloginid").value;
        if(userloginid!="admin"){
             getImage(userloginid);
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "getApprovalCount?userloginid="+userloginid, //this is my servlet
        success: function(data){ 
        	$("#count").html(data);
        }
        });
        }
});

function getNextLevel(clickedid,isRejected){
//var a=	document.getElementById("docflowtranid").value;
	////alert(clickedid);
	var docFlowTranid=clickedid;

	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "getNextLevel?docFlowTranid="+docFlowTranid+"&&isRejected="+isRejected, //this is my servlet
      
        success: function(data){
        	//alert("sucess");
        	window.location.reload();
        }
	});
	//var comment=document.getElementById(this.id+""+this.id).value;
	
}


//function RejectDocument(clickedid){
//	var docFlowTranid=clickedid;
//	$.ajax({
//        type: "GET",
//        contentType : "application/json",
//        url: "rejectDocument?docFlowTranid="+docFlowTranid, //this is my servlet
//      
//        success: function(data){
//        	//alert("sucess");
//        	window.location.reload();
//        }
//	});
//}

function showPendingApprovals(){
	//$("#app").hide();
	var userloginid=document.getElementById("userloginid").value;
	$.ajax({
        type: "GET",
        contentType : "application/json",
        url: "getApprovalData?userloginid="+userloginid, //this is my servlet
      
        success: function(data){ 
        	var arr=data;
        	for (var i = 0; i < arr.length; i++){
        		//document.getElementById("docflowtranid").value=arr[i].docFlowTranid;
        		$(".container").append('<div class="comment-widgets scrollable">'+
        		'<input type="hidden" id="docflowtranid" value="'+arr[i].docFlowTranid+'"><div class="d-flex flex-row comment-row m-t-0">'+
        		'<div class="p-2"><b><span id="docstatus" class="dot" style="background-color: #ff2300;color:white;padding-top: 11px;">'
        		+arr[i].docstatus+'</span></b></div><div class="comment-text w-100"><span class="text-muted float-right" id="initiatedon">'
        		+arr[i].initiatedon+'</span><br><h5 id="doctype">' + arr[i].doctype+ '</h5>'+
        		'<span class="m-b-15 d-block"><u><b>Description: </u></b>'+arr[i].description+'</span><div class="comment-footer">'+ 
        		' <input type="text" class="form-control"> <br> <button type="button" id='+arr[i].docFlowTranid+' onclick="getNextLevel(this.id,1)" class="btn btn-danger btn-sm">Reject</button>'+
                        '  <button type="button" id='+arr[i].docFlowTranid+' class="btn btn-success btn-sm" onclick="getNextLevel(this.id,0)">Approve</button></div></div></div></div></div><hr color="00FFFF">'); 
        		
        			
        	}
        	
        	//$("empname").html(data.dataBean["empname"]);
        	//document.getElementById("idno").innerHTML=data.dataBean[0].idno;
        	//document.getElementById("empname").innerHTML=data.dataBean[0].empname;
        	//document.getElementById("docstatus").innerHTML=data.dataBean[0].docstatus;  
        	//document.getElementById("reasonforleave").innerHTML=data.dataBean[0].reasonforleave;
        	//document.getElementById("createdon").innerHTML=data.dataBean[0].createdon;
        	////alert(data.dataBean[0].idno+"--"+data.dataBean[0].empname);
        	//document.getElementById("submitedby").innerHTML="Submitted by: "+ data.dataBean[0].idno+"--"+data.dataBean[0].empname+"--"+data.dataBean[0].designation;
        	//$(".comment-widgets scrollable").append('<div class="d-flex flex-row comment-row m-t-0"><div class="p-2">' + data.dataBean[0].empname + '</div></div><div>' + data.dataBean[0].empname + '</div><div>' + data.dataBean[0].empname + '</div>');
        	//

        	$('#openPendingApprovals').modal('show');
        }
 });
	
}

</script>
  <style>

 </style>
</head>

<body>
<input type="hidden" value="<%=username%>" id="userloginid">
<!-- <input type="text" id="itemname" name="itemname">
<input type="text" id="itemaction" name="itemaction" > -->

	<div id="main-wrapper">
		<header class="topbar" data-navbarbg="skin5">
			<nav class="navbar top-navbar navbar-expand-md navbar-dark">
				<div class="navbar-header" data-logobg="skin5"	>
					<!-- This is for the sidebar toggle which is visible on mobile only -->
					<a class="nav-toggler waves-effect waves-light d-block d-md-none"
						href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
					<!-- ============================================================== -->
					<!-- Logo -->
					<!-- ============================================================== -->
                                        <a class="navbar-brand"> 
                                            <span class="logo-text"> <!-- dark Logo text -->
						<img src="resources/assets/images/booklogo.png" alt="homepage"
							height="65" width="240"  style="align-content: left"/>
                                            </span>
					</a> 
                                        <a class="topbartoggler d-block d-md-none waves-effect waves-light"
						href="javascript:void(0)" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation"><i class="ti-more"></i></a>
				</div>
				<!-- ============================================================== -->
				<!-- End Logo -->
				<!-- ============================================================== -->
				<div class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin5">
					
					<!-- ============================================================== -->
					<!-- toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-left mr-auto">
						 <li class="nav-item d-none d-md-block"><a
							class="nav-link sidebartoggler waves-effect waves-light"
							href="javascript:void(0)" data-sidebartype="mini-sidebar">
							<i class="mdi mdi-menu font-24">
							</i>
							</a>
							</li>
                       <%if(!username.equalsIgnoreCase("admin")){%>		
                          <div align="left">
                          <h6 style="margin-top: 15px; color: white;margin-left: 82px;"> 
                         <a  onclick="showPendingApprovals()"> 
                        <input type="image" src="resources/assets/images/Bell-icon.png" height="40" width="40">
                        <font color="red"><b  id="count"></b></font>
                         </a>

                         </h6>
                      </div>
                        <%}%>
					</ul>


                                        <%if(!username.equalsIgnoreCase("admin")){%>
                                       <!--  <div id=""></div>	 -->    
                                                                              
                                        <%}else{%>
                                       <!--  <img src="resources/assets/images/admin_pic.jpg" height="45" width="45" class="rounded-circle"/> -->
                                     <!-- <script>
                                     $("#jio").hide();
                                      </script> -->
                                     
                                        <%}%>
                                        
                                       <ul class="navbar-nav float-right">
                                            <li class=" nav-item dropdown">
                                                <a  class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic"
							                           href="javascript:void(0)" data-toggle="dropdown" aria-haspopup="true"
                                                      
                                                                              aria-expanded="false" ><h9 style="color:white">Welcome </h9>
                                                                              
                                                    <span> <%-- <%out.println(username);%> --%>
                                                    <img style="background-color:white;" height="62" width="62" class="rounded-circle" id = "ItemPreview"/> 
                                                    </span>
                                                   
                                                    
     
		
                                                     <i class="fa fa-arrow-down" style="font-size:10px;color:greenyellow"></i> 
                                                </a>
                                                    <ul class="dropdown-menu" role="menu">
                                                       <li><a href="#">Personal Details</a></li> 
                                                       <li><a href="#">Attendance</a></li>
                                                       <li><a href="#">Leave Card</a></li>
                                                       <li><a href="#">Pay-Slip</a></li>
                                                       <li class="divider"></li>
                                                       <li><a onclick="logout()">Logout</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                        
					<!-- ============================================================== -->
					<!-- Right side toggle and nav items -->
					<!-- ============================================================== -->
<!--					<ul class="navbar-nav float-right">
						<li class="nav-item dropdown">
						<a
							class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic"
							href="javascript:void(0)" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
							
							<img src="resources/assets/images/LOGOUT.png" alt="user" width="41" onclick="logout()">
							
							</a>
								
								
							</li>
						 ============================================================== 
						 User profile and search 
						 ============================================================== 
					</ul>-->
				</div>
			</nav>
		</header>
		
		<aside class="left-sidebar" data-sidebarbg="skin5">

		<!-- Sidebar scroll-->
			<div class="scroll-sidebar">
				<!-- Sidebar navigation-->
				<nav class="sidebar-nav" >
					<ul id="sidebarnav" class="p-t-30" >
							
								 <li class="sidebar-item" >
                                <a id="link" href="#/accordian/" class="sidebar-link" onclick="getAccessRights(19)"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> HomePage </span>
                                </a>
								
								</li>	
									
						<li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">HR Management</span></a>
                            <ul aria-expanded="false" class="collapse  first-level">

                                 <li class="sidebar-item">                                
                                <a  class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-clipboard-account"></i><span class="hide-menu"> Employees </span>
                                </a>
								<ul aria-expanded="false" class="collapse  first-level">
                                                    <%if(username.equalsIgnoreCase("admin")){%>                                                                    
                                <li class="sidebar-item"><a  href="#/jobDetails" class="sidebar-link">
								<i class="mdi mdi-note-outline"></i><span class="hide-menu"> New Joining</span></a>
								</li>
                                                    <%}%>
                                <li class="sidebar-item" id="pInfo"><a  href="#/employeeInformation/"  class="sidebar-link"  onclick="getAccessRights(19)">
                                <i class="mdi mdi-note-plus"></i><span class="hide-menu"> Personal Information </span></a>
                                </li>
								</ul>
								</li> 
								
								
								 <li class="sidebar-item">
                                <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-clock"></i><span class="hide-menu"> Attendence </span>
                                </a>
								<ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item"><a href="#/attendance/" class="sidebar-link" onclick="getAccessRights(15)">
								<i class="mdi mdi-note-outline"></i><span class="hide-menu"> Punches Checklist </span></a>
								</li>
                                <li class="sidebar-item"><a href="#/leaveposting/" class="sidebar-link" onclick="getAccessRights(16)">
                                <i class="mdi mdi-note-plus"></i><span class="hide-menu"> Leave Posting </span></a>
                                </li>
                               <li class="sidebar-item"><a href="#/permissions/" class="sidebar-link"  onclick="getAccessRights(58)">
                                <i class="mdi mdi-emoticon-cool"></i><span class="hide-menu">Permissions </span></a>
                                </li>                                
                                <li class="sidebar-item"><a href="#/otentry/" class="sidebar-link" onclick="getAccessRights(39)">
                                <i class="mdi mdi-note-plus"></i><span class="hide-menu"> OT Entry </span></a>
                                </li>
								</ul>
								</li> 
								
								
                                
                                <li class="sidebar-item">
                                <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-cash"></i><span class="hide-menu"> PayRoll </span>
                                </a>
								<ul aria-expanded="false" class="collapse  first-level">
                               <li class="sidebar-item"><a onclick="monthdeductions()" class="sidebar-link">
								<i class="mdi mdi-note-outline"></i><span class="hide-menu"> Month Deductions </span></a>
								</li>
                                <li class="sidebar-item"><a href="#/salaryDeductions/" class="sidebar-link" onclick="getAccessRights(37)">
                                <i class="mdi mdi-note-plus"></i><span class="hide-menu"> Salary Deductions </span></a>
                                </li>
                                
                                <li class="sidebar-item"><a href="#/appraisals/" class="sidebar-link" onclick="getAccessRights(14)">
                                <i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Appraisals  </span></a>
                                </li>
								</ul>
								</li> 
								
                        </ul>
                        </li>
							
<!--								<li class="sidebar-item"><a 
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-face"></i>
								<span class="hide-menu">CSR Activities</span></a></li>
								-->
									
								
								 <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">Masters</span></a>
                                 <ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item">
                                <a href="#/grade-list/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Grades </span>
                                </a>
								
								</li>
								
						
                              <li class="sidebar-item"><a href="#/jobstatus/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Job Status  </span></a></li>
                             <li class="sidebar-item"><a href="#/view-emp-status/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Employee Status  </span></a></li>
                             <li class="sidebar-item"><a href="#/division/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Divisions  </span></a></li>                             
                             <li class="sidebar-item"><a  class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Shift Schedules  </span></a></li>
                             <li class="sidebar-item"><a href="#/view-blood-group/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> BloodGroup  </span></a></li>
                          
                         <li class="sidebar-item"><a href="#/shifts/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Shifts  </span></a></li>
                           
                          <li class="sidebar-item"><a href="#/jobtype/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Job Type  </span></a></li>
                          <li class="sidebar-item"><a href="#/cadre/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Cadre  </span></a></li>
                          <li class="sidebar-item"><a href="#/department/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Department  </span></a></li>
                          <li class="sidebar-item"><a href="#/sections/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu">  Sections </span></a></li>
                          <li class="sidebar-item"><a href="#/projects/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Projects  </span></a></li>
                          <li class="sidebar-item"><a href="#/holidays/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Holidays  </span></a></li>
                           <li class="sidebar-item"><a href="#/bankmaster/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Bank Master  </span></a></li>
                           <li class="sidebar-item"><a href="#/contractor/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Contractor  </span></a></li>
                           <li class="sidebar-item"><a href="#/compliance/" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Compliance  </span></a></li>
                          
                           </ul>
                        </li>
                        
                        
                        
                             
                        
								
								 <li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">Utilities</span></a>
                            <ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item">
                                <a href="#/menuAccess/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> User Settings </span>
                                </a>
								
								</li>
								<li class="sidebar-item">
                                <a href="#/settings/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Division Settings </span>
                                </a>
								
								</li>
								<li class="sidebar-item">
                                <a href="#/notifications/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu">Notifications</span>
                                </a>
								
								</li>
								
								
                            
                           </ul>
                        </li> 
                        
                        
                         <li class="sidebar-item">
                                <a href="#/menuAccess/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> User Settings </span>
                                </a>
								
								</li>
								<li class="sidebar-item">
                                <a href="#/settings/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Division Settings </span>
                                </a>
								
								</li>
								<li class="sidebar-item">
                                <a href="#/notifications/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu">Notifications</span>
                                </a>
								
								</li>
                        
                        
                        
                         <li class="sidebar-item">
                                <a href="#/events/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Events </span>
                                </a>
								
								</li>
                        
                             <li class="sidebar-item">
                                <a href="#/scan/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Scan </span>
                                </a>
								</li>
								
                        
								 <li class="sidebar-item">
                                <a href="#/report/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> ReportCenter </span>
                                </a>
								
								</li>
								
									<!-- <li class="sidebar-item">
                                <a href="#/weightbridge/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> WeightBridge </span>
                                </a>
								</li> -->
								
								
								<li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">WeightBridgeAnalysis</span></a>
                            <ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item">
                                <a href="#/weightbridge/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> WeightBridge </span>
                                </a>
								
								</li>
								<li class="sidebar-item">
                                <a href="#/WeightTimeAnalysis/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> WeightBridgeTimeAnalysis </span>
                                </a>
								
								</li>
								<li class="sidebar-item">
                                <a href="#/WeightRegister/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu">WeightBridgeRegister</span>
                                </a>
								
								</li>
								<li class="sidebar-item">
                                <a href="#/Quality/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu">QualityReport</span>
                                </a>
								
								</li>
								
                            
                           </ul>
                        </li> 
								
								
								
								 <li class="sidebar-item">
                                <a href="#/sample1/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu">sample1</span>
                                </a>
								
								</li>
								 <li class="sidebar-item">
                                <a href="#/transaction/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu">Transaction</span>
                                </a>
								</li>
								
								<li class="sidebar-item">
                                <a href="#/faceDetection/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu">FaceDetection</span>
                                </a>
								</li>
								
								<li class="sidebar-item">
                                <a href="#/faceRecognization/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu">FaceRecognization</span>
                                </a>
								</li>
								
								<li class="sidebar-item">
                                <a href="#/salarystatement/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu">SaLaryStatement</span>
                                </a>
								</li>
								
								<li class="sidebar-item">
                                <a href="#/MonthlyAttendence/" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu">MonthlyAttendence</span>
                                </a>
								</li>
									
								
						
									
					</ul>
				</nav>
				<!-- End Sidebar navigation -->
			</div> 
			<!-- End Sidebar scroll-->
			</aside>
		

		<div class="page-wrapper" style="background-color: #ffffff">

			<div class="container-fluid">
				<div class="main wrapper clearfix">
					<div id="app">
						<!--  template will be injected here -->
					</div>
					
				</div>
			</div>

		</div>
		
<!-- Modal -->
  <div class="modal fade" id="openPendingApprovals" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content" >
        <div class="modal-header">
          <h4 class="modal-title">Pending Approvals</h4>
        </div>
        <div class="modal-body">
         <div class="row">
		<div class="col-lg-12">
                    <div class="container"></div>
                        <div class="card">                                                                                    
                        </div>
                    </div>
                </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" onclick="window.location.reload()">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
	</div>
	<%}else{
		
		response.sendRedirect("login");
	}
		%>
	}
</body>
</html>
 
    
   

    
 