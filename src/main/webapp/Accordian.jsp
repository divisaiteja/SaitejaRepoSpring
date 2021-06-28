<!DOCTYPE html>
<html>
<head>
<%@page import="java.util.*" %>
<%@page import="com.hrms.utitlities.DBUtil" %>
<%
	HttpSession sess = request.getSession();
	String username = (String) sess.getAttribute("username");
	System.out.println(username);
%>
<%
	if (username != null) {
%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="header.jsp"%>

<script src="resources/highcharts/highcharts.js"></script>
<script src="resources/highcharts/exporting.js"></script>
<script src="resources/highcharts/export-data.js"></script>
 <script type="text/javascript" src="resources/assets/libs/jquery/dist/jquery.min.js"></script> 
<!-- <script src="resources/summy/sammy.js"></script> -->
<!-- <script src="resources/summy/sammy.template.js"></script> -->
<!-- <script src="resources/summy/app.js"></script> -->
</head>
<script>
$(document).ready(function() {
	xmlHttp = GetXmlHttpObject();
    var url = "openDashBoard";
    xmlHttp.onreadystatechange = showmenudata1;
    //alert("I am in Accordian.jsp page...");
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
});
</script>
<body>
<%//response.sendRedirect("test.jsp"); %>


	<div id="main-wrapper">
		<header class="topbar" data-navbarbg="skin5">
			<nav class="navbar top-navbar navbar-expand-md navbar-dark">
				<div class="navbar-header" data-logobg="skin5"
					style="background-color: #043f61!importan">
					<!-- This is for the sidebar toggle which is visible on mobile only -->
					<a class="nav-toggler waves-effect waves-light d-block d-md-none"
						href="javascript:void(0)"><i class="ti-menu ti-close"></i></a>
					<!-- ============================================================== -->
					<!-- Logo -->
					<!-- ============================================================== -->
					<a class="navbar-brand"> <span class="logo-text"> <!-- dark Logo text -->
							<img src="resources/assets/images/booklogo.png" alt="homepage"
							height="50" width="160" />
					</span>

					</a> <a
						class="topbartoggler d-block d-md-none waves-effect waves-light"
						href="javascript:void(0)" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation"><i class="ti-more"></i></a>
				</div>
				<!-- ============================================================== -->
				<!-- End Logo -->
				<!-- ============================================================== -->
				<div class="navbar-collapse collapse" id="navbarSupportedContent"
					style="background-color: #043f61!importan">
					<!-- ============================================================== -->
					<!-- toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-left mr-auto">
						<!-- <li class="nav-item d-none d-md-block"><a
							class="nav-link sidebartoggler waves-effect waves-light"
							href="javascript:void(0)" data-sidebartype="mini-sidebar"><i
								class="mdi mdi-menu font-24"></i></a></li> -->
						<!-- ============================================================== -->
						<!-- Search -->
						<!-- ============================================================== -->
						
					</ul>
					<!-- ============================================================== -->
					<!-- Right side toggle and nav items -->
					<!-- ============================================================== -->
					<ul class="navbar-nav float-right">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic"
							href="" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
							<input type="submit" value="logout" onclick="login()" class="btn btn-danger"
								></a>
							<div class="dropdown-menu dropdown-menu-right user-dd animated">
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="javascript:void(0)"><i
									class="fa fa-power-off m-r-5 m-l-5"></i> Logout</a>
							</div></li>
						<!-- ============================================================== -->
						<!-- User profile and search -->
						<!-- ============================================================== -->
					</ul>
				</div>
			</nav>
		</header>

		<aside class="left-sidebar" data-sidebarbg="skin5">

			<!-- Sidebar scroll-->
			<div class="scroll-sidebar">
				<!-- Sidebar navigation-->
				<nav class="sidebar-nav" style="background-color: #043f61">
					<ul id="sidebarnav" class="p-t-30"
						style="background-color: #043f61">
								
									
						<li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">HR Management</span></a>
                            <ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item">
                                <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Employee Information </span>
                                </a>
								<ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item"><a onclick="jobDetails()" class="sidebar-link">
								<i class="mdi mdi-note-outline"></i><span class="hide-menu"> Job Details </span></a>
								</li>
                                <li class="sidebar-item"><a onclick="empinfo()"  class="sidebar-link">
                                <i class="mdi mdi-note-plus"></i><span class="hide-menu"> Personal Information </span></a>
                                </li>
								</ul>
								</li>
								
								
								<li class="sidebar-item">
                                <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Attendence </span>
                                </a>
								<ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item"><a onclick="attsummary()" class="sidebar-link">
								<i class="mdi mdi-note-outline"></i><span class="hide-menu"> Punches Checklist </span></a>
								</li>
                                <li class="sidebar-item"><a onclick="leaveposting()" class="sidebar-link">
                                <i class="mdi mdi-note-plus"></i><span class="hide-menu"> Leave Posting </span></a>
                                </li>
								</ul>
								</li>
								
                                
                                
                                <li class="sidebar-item">
                                <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> PayRoll </span>
                                </a>
								<ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item"><a onclick="monthdeductions()" class="sidebar-link">
								<i class="mdi mdi-note-outline"></i><span class="hide-menu"> Month Deductions </span></a>
								</li>
                                <li class="sidebar-item"><a onclick="salaryDeductions()" class="sidebar-link">
                                <i class="mdi mdi-note-plus"></i><span class="hide-menu"> Salary Deductions </span></a>
                                </li>
								</ul>
								</li>
                               
                                <li class="sidebar-item"><a href="icon-fontawesome.html" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Appraisals  </span></a></li>
                           
                            
                           </ul>
                        </li>
								
								<li class="sidebar-item"><a 
							class="sidebar-link waves-effect waves-dark sidebar-link"
							aria-expanded="false"><i class="mdi mdi-face"></i>
								<span class="hide-menu">CSR Activities</span></a></li>
								
									
								
								<li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">Masters</span></a>
                            <ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item">
                                <a onclick="gradesList()" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Grades </span>
                                </a>
								
								</li>
								
								
								<li class="sidebar-item">
                                <a href="icon-fontawesome.html" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Departments </span>
                                </a>
								</li>
								<li class="sidebar-item">
                                <a href="icon-fontawesome.html" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Sections </span>
                                </a>
								</li>
                              <li class="sidebar-item"><a onclick="jobstatus()" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Job Status  </span></a></li>
                             <li class="sidebar-item"><a onclick="empstatus()" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Employee Status  </span></a></li>
                             <li class="sidebar-item"><a onclick="division()" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Divisions  </span></a></li>                             
                             <li class="sidebar-item"><a  class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Shift Schedules  </span></a></li>
                             <li class="sidebar-item"><a onclick="bgroup()" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> BloodGroup  </span></a></li>
                              <li class="sidebar-item"><a onclick="bgroup()" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> BloodGroup  </span></a></li>
                               <li class="sidebar-item"><a onclick="bgroup()" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> BloodGroup  </span></a></li>
                          
                         <li class="sidebar-item"><a href="icon-fontawesome.html" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Shifts  </span></a></li>
                           
                            
                           </ul>
                        </li>
								
								
								
								
								
								
								
								<li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">Utilities</span></a>
                            <ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item">
                                <a href="icon-fontawesome.html" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> User-Components Mapping </span>
                                </a>
								
								</li>
								<li class="sidebar-item">
                                <a onclick="appsettings()" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Settings </span>
                                </a>
								
								</li>
								
								
                            
                           </ul>
                        </li>
                        
                        
                        
                        
                        
								
									
								<li class="sidebar-item"> <a class="sidebar-link has-arrow waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-face"></i><span class="hide-menu">Report Center</span></a>
                            <ul aria-expanded="false" class="collapse  first-level">
                                <li class="sidebar-item">
                                <a onclick="report()" class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Employee List </span>
                                </a>
								
								</li>
								
								
								<li class="sidebar-item">
                                <a  class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Daily Attendance Report  </span>
                                </a>
								</li>
								<li class="sidebar-item">
                                <a  class="sidebar-link"><i class="mdi mdi-emoticon"></i><span class="hide-menu"> Month Attendance Report </span>
                                </a>
								</li>
                              <li class="sidebar-item"><a href="icon-fontawesome.html" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu"> Leave Register  </span></a></li>
                              <li class="sidebar-item"><a href="icon-fontawesome.html" class="sidebar-link"><i class="mdi mdi-emoticon-cool"></i><span class="hide-menu">  Attendance Register  </span></a></li>
                            
                           
                           
                            
                           </ul>
                        </li>
									
								
						
									
					</ul>
				</nav>
				<!-- End Sidebar navigation -->
			</div>
			<!-- End Sidebar scroll-->
		</aside>
		 <div class="page-wrapper" style="background-color: #ffffff">
           
            <div class="container-fluid">
                  <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                
                              <div id="data"></div>
                                          
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           
        </div>

	</div>
	    <script src="resources/dist/js/sidebarmenu.js"></script>
	<%}else{ %>
	<%
		response.sendRedirect("login");
	%>
	<%} %>
	 <%@include file="footer.jsp" %>
	  <script src="resources/dist/js/sidebarmenu.js"></script>
</body>

</html>